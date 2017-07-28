/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes;

import com.gewara.util.TmpFileUtil;
import de.idyl.winzipaes.impl.AESDecrypter;
import de.idyl.winzipaes.impl.ByteArrayHelper;
import de.idyl.winzipaes.impl.CentralDirectoryEntry;
import de.idyl.winzipaes.impl.ExtRandomAccessFile;
import de.idyl.winzipaes.impl.ExtZipEntry;
import de.idyl.winzipaes.impl.ExtZipOutputStream;
import de.idyl.winzipaes.impl.ZipConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class AesZipFileDecrypter implements ZipConstants {
	private static final Logger LOG = Logger.getLogger(AesZipFileDecrypter.class.getName());
	public static String charset = "iso-8859-1";
	protected static int bufferSize = 10240;
	protected AESDecrypter decrypter;
	protected ExtRandomAccessFile raFile;
	protected long dirOffsetPos;
	protected File zipFile;
	protected String comment;

	public AesZipFileDecrypter(File zipFile, AESDecrypter decrypter) throws IOException {
		this.zipFile = zipFile;
		this.decrypter = decrypter;
		this.raFile = new ExtRandomAccessFile(zipFile);
		this.initDirOffsetPosAndComment();
	}

	protected void initDirOffsetPosAndComment() throws IOException {
		this.dirOffsetPos = this.zipFile.length() - 6L;
		int dirOffset = this.raFile.readInt(this.dirOffsetPos - 16L);
		if ((long) dirOffset != 101010256L) {
			byte[] endsig = ByteArrayHelper.toByteArray(101010256);
			long endsigPos = this.raFile.lastPosOf(endsig);
			if (endsigPos == -1L) {
				throw new ZipException(
						"expected ENDSIC not found (marks the beginning of the central directory at end of the zip file)");
			}

			this.dirOffsetPos = endsigPos + 16L;
			short commentLength = this.raFile.readShort(this.dirOffsetPos + 4L);
			this.comment = new String(this.raFile.readByteArray(this.dirOffsetPos + 6L, commentLength));
		}

	}

	public void close() throws IOException {
		this.raFile.close();
	}

	public List<ExtZipEntry> getEntryList() throws IOException, ZipException {
		ArrayList out = new ArrayList();
		short totalNumberOfEntries = this.getNumberOfEntries();
		int dirOffset = this.raFile.readInt(this.dirOffsetPos);
		long fileOffset = (long) dirOffset;

		for (int i = 0; i < totalNumberOfEntries; ++i) {
			int censig = this.raFile.readInt(fileOffset);
			if ((long) censig != 33639248L) {
				throw new ZipException("expected CENSIC not found at entry no " + (i + 1)
						+ " in central directory at end of zip file at " + fileOffset);
			}

			short fileNameLength = this.raFile.readShort(fileOffset + 28L);
			short extraFieldLength = this.raFile.readShort(fileOffset + 30L);
			long fileOffsetPos = fileOffset + 28L + 14L;
			long fileDataOffset = (long) this.raFile.readInt(fileOffsetPos);
			int locsig = this.raFile.readInt(fileDataOffset);
			if ((long) locsig != 67324752L) {
				throw new ZipException("expected LOCSIC not found at alleged position of data for file no " + (i + 1));
			}

			byte[] fileNameBytes = this.raFile.readByteArray(fileOffsetPos + 4L, fileNameLength);
			long nextFileOffset = this.raFile.getFilePointer();
			String fileName = new String(fileNameBytes, charset);
			CentralDirectoryEntry cde = new CentralDirectoryEntry(this.raFile, fileOffset);
			ExtZipEntry zipEntry = new ExtZipEntry(fileName, cde);
			zipEntry.setCompressedSize((long) cde.getCompressedSize());
			zipEntry.setSize((long) cde.getUncompressedSize());
			long dosTime = (long) this.raFile.readInt(fileOffset + 12L);
			zipEntry.setTime(ExtZipEntry.dosToJavaTime(dosTime));
			if (cde.isEncrypted()) {
				zipEntry.setMethod(cde.getActualCompressionMethod());
				zipEntry.setOffset((int) (cde.getLocalHeaderOffset() + (long) cde.getLocalHeaderSize())
						+ cde.getCryptoHeaderLength());
				zipEntry.initEncryptedEntry();
			} else {
				zipEntry.setMethod(8);
				zipEntry.setPrimaryCompressionMethod(8);
			}

			nextFileOffset += (long) extraFieldLength;
			out.add(zipEntry);
			fileOffset = nextFileOffset;
		}

		return out;
	}

	public ExtZipEntry getEntry(String name) throws IOException, ZipException {
		Iterator arg1 = this.getEntryList().iterator();

		ExtZipEntry zipEntry;
		do {
			if (!arg1.hasNext()) {
				return null;
			}

			zipEntry = (ExtZipEntry) arg1.next();
		} while (!name.equals(zipEntry.getName()));

		return zipEntry;
	}

	protected void checkZipEntry(ExtZipEntry zipEntry) throws ZipException {
		if (zipEntry == null) {
			throw new ZipException("zipEntry must NOT be NULL");
		} else if (zipEntry.isDirectory()) {
			throw new ZipException("directory entries cannot be decrypted");
		} else if (!zipEntry.isEncrypted()) {
			throw new ZipException("currently only extracts encrypted files - use java.util.zip to unzip");
		}
	}

	public void extractEntryWithTmpFile(ExtZipEntry zipEntry, File outFile, String password)
			throws IOException, ZipException {
		this.checkZipEntry(zipEntry);
		CentralDirectoryEntry cde = zipEntry.getCentralDirectoryEntry();
		if (!cde.isAesEncrypted()) {
			throw new ZipException("only AES encrypted files are supported");
		} else {
			int cryptoHeaderOffset = zipEntry.getOffset() - cde.getCryptoHeaderLength();
			byte[] salt = this.raFile.readByteArray((long) cryptoHeaderOffset, 16);
			byte[] pwVerification = this.raFile.readByteArray((long) (cryptoHeaderOffset + 16), 2);
			if (LOG.isLoggable(Level.FINEST)) {
				LOG.finest("\n" + cde.toString());
				LOG.finest("offset    = " + zipEntry.getOffset());
				LOG.finest("cryptoOff = " + cryptoHeaderOffset);
				LOG.finest("password  = " + password + " - " + password.length());
				LOG.finest("salt      = " + ByteArrayHelper.toString(salt) + " - " + salt.length);
				LOG.finest("pwVerif   = " + ByteArrayHelper.toString(pwVerification) + " - " + pwVerification.length);
			}

			this.decrypter.init(password, 256, salt, pwVerification);
			File tmpFile = new File(outFile.getPath() + "_TMP.zip");
			makeDir(tmpFile.getParent());
			ExtZipOutputStream zos = null;
			ZipFile zf = null;
			FileOutputStream fos = null;
			InputStream is = null;

			try {
				zos = new ExtZipOutputStream(tmpFile);
				ExtZipEntry tmpEntry = new ExtZipEntry(zipEntry);
				tmpEntry.setPrimaryCompressionMethod(zipEntry.getMethod());
				zos.putNextEntry(tmpEntry);
				this.raFile.seek((long) cde.getOffset());
				byte[] buffer = new byte[bufferSize];
				int remaining = (int) zipEntry.getEncryptedDataSize();

				label145 : while (true) {
					if (remaining <= 0) {
						zos.finish();
						zos = null;
						byte[] storedMac1 = new byte[10];
						this.raFile.readByteArray(storedMac1, 10);
						byte[] calcMac1 = this.decrypter.getFinalAuthentication();
						if (LOG.isLoggable(Level.FINE)) {
							LOG.fine("storedMac=" + Arrays.toString(storedMac1));
							LOG.fine("calcMac=" + Arrays.toString(calcMac1));
						}

						if (!Arrays.equals(storedMac1, calcMac1)) {
							throw new ZipException("stored authentication (mac) value does not match calculated one");
						}

						zf = new ZipFile(tmpFile);
						ZipEntry ze = (ZipEntry) zf.entries().nextElement();
						is = zf.getInputStream(ze);
						fos = new FileOutputStream(outFile.getPath());
						int read = is.read(buffer);

						while (true) {
							if (read <= 0) {
								break label145;
							}

							fos.write(buffer, 0, read);
							read = is.read(buffer);
						}
					}

					int storedMac = remaining > buffer.length ? buffer.length : remaining;
					int calcMac = this.raFile.readByteArray(buffer, storedMac);
					this.decrypter.decrypt(buffer, calcMac);
					zos.writeBytes(buffer, 0, calcMac);
					remaining -= storedMac;
				}
			} finally {
				if (zos != null) {
					zos.close();
				}

				if (zf != null) {
					zf.close();
				}

				if (fos != null) {
					fos.close();
				}

				if (is != null) {
					is.close();
				}

			}

			TmpFileUtil.deleteFile(tmpFile);
		}
	}

	public short getNumberOfEntries() throws IOException {
		return this.raFile.readShort(this.dirOffsetPos - 6L);
	}

	protected static void makeDir(String dirStr) {
		if (dirStr != null) {
			makeDir(new File(dirStr));
		}

	}

	protected static void makeDir(File dir) {
		if (dir != null && !dir.exists()) {
			if (dir.getParent() != null) {
				File parentDir = new File(dir.getParent());
				if (!parentDir.exists()) {
					makeDir(parentDir);
				}
			}

			dir.mkdir();
		}

	}

	public String getComment() {
		return this.comment;
	}

	public void extractEntry(ExtZipEntry zipEntry, OutputStream outStream, String password)
			throws IOException, ZipException {
		this.checkZipEntry(zipEntry);
		ZipInputStream zipInputStream = null;
		ByteArrayOutputStream bos = null;

		try {
			CentralDirectoryEntry cde = zipEntry.getCentralDirectoryEntry();
			if (!cde.isAesEncrypted()) {
				throw new ZipException("only AES encrypted files are supported");
			}

			int cryptoHeaderOffset = zipEntry.getOffset() - cde.getCryptoHeaderLength();
			byte[] salt = this.raFile.readByteArray((long) cryptoHeaderOffset, 16);
			byte[] pwVerification = this.raFile.readByteArray((long) (cryptoHeaderOffset + 16), 2);
			if (LOG.isLoggable(Level.FINEST)) {
				LOG.finest("\n" + cde.toString());
				LOG.finest("offset    = " + zipEntry.getOffset());
				LOG.finest("cryptoOff = " + cryptoHeaderOffset);
				LOG.finest("password  = " + password + " - " + password.length());
				LOG.finest("salt      = " + ByteArrayHelper.toString(salt) + " - " + salt.length);
				LOG.finest("pwVerif   = " + ByteArrayHelper.toString(pwVerification) + " - " + pwVerification.length);
			}

			this.decrypter.init(password, 256, salt, pwVerification);
			bos = new ByteArrayOutputStream(bufferSize);
			ExtZipOutputStream zos = new ExtZipOutputStream(bos);
			ExtZipEntry tmpEntry = new ExtZipEntry(zipEntry);
			tmpEntry.setPrimaryCompressionMethod(zipEntry.getMethod());
			tmpEntry.setCompressedSize(zipEntry.getEncryptedDataSize());
			zos.putNextEntry(tmpEntry);
			this.raFile.seek((long) cde.getOffset());
			byte[] buffer = new byte[bufferSize];
			CRC32 crc32 = new CRC32();
			int remaining = (int) zipEntry.getEncryptedDataSize();

			while (remaining > 0) {
				int storedMac = remaining > buffer.length ? buffer.length : remaining;
				int calcMac = this.raFile.readByteArray(buffer, storedMac);
				this.decrypter.decrypt(buffer, calcMac);
				zos.writeBytes(buffer, 0, calcMac);
				remaining -= storedMac;
				crc32.update(buffer, 0, calcMac);
			}

			tmpEntry.setCrc(crc32.getValue());
			zos.finish();
			byte[] storedMac1 = new byte[10];
			this.raFile.readByteArray(storedMac1, 10);
			byte[] calcMac1 = this.decrypter.getFinalAuthentication();
			if (LOG.isLoggable(Level.FINE)) {
				LOG.fine("storedMac=" + Arrays.toString(storedMac1));
				LOG.fine("calcMac=" + Arrays.toString(calcMac1));
			}

			if (!Arrays.equals(storedMac1, calcMac1)) {
				throw new ZipException("stored authentication (mac) value does not match calculated one");
			}

			zipInputStream = new ZipInputStream(new ByteArrayInputStream(bos.toByteArray()));
			ZipEntry entry = zipInputStream.getNextEntry();
			entry.setCrc(crc32.getValue());
			if (entry.getSize() != 0L) {
				crc32 = new CRC32();

				for (int read = zipInputStream.read(buffer); read > 0; read = zipInputStream.read(buffer)) {
					outStream.write(buffer, 0, read);
					crc32.update(buffer, 0, read);
					entry.setCrc(crc32.getValue());
				}
			}
		} finally {
			if (bos != null) {
				bos.close();
			}

			if (zipInputStream != null) {
				zipInputStream.close();
			}

		}

	}

	public void extractEntry(ExtZipEntry zipEntry, File outFile, String password) throws IOException, ZipException {
		ByteArrayOutputStream bos = null;
		FileOutputStream fos = null;

		try {
			bos = new ByteArrayOutputStream(bufferSize);
			fos = new FileOutputStream(outFile);
			this.extractEntry(zipEntry, (OutputStream) bos, password);
			byte[] buffer = bos.toByteArray();
			fos.write(buffer);
		} finally {
			if (bos != null) {
				bos.close();
			}

			if (fos != null) {
				fos.close();
			}

		}

	}
}