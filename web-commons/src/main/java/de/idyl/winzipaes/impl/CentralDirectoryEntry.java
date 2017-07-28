/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.AesZipFileDecrypter;
import de.idyl.winzipaes.impl.ExtRandomAccessFile;
import de.idyl.winzipaes.impl.ZipConstants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipException;

public class CentralDirectoryEntry implements ZipConstants {
	private static final Logger LOG = Logger.getLogger(CentralDirectoryEntry.class.getName());
	protected ExtRandomAccessFile raFile;
	protected long fileOffset;
	protected boolean isEncrypted;
	protected boolean isAesEncrypted;
	protected short fileNameLength;
	protected long extraFieldOffset;
	protected String fileName;
	protected int localHeaderSize;
	protected short actualCompressionMethod;
	protected short extraFieldLength;
	protected long localHeaderOffset;
	protected int compressedSize;
	protected int uncompressedSize;

	public CentralDirectoryEntry(ExtRandomAccessFile raFile, long fileOffset) throws IOException {
		this.raFile = raFile;
		this.fileOffset = fileOffset;
		this.initFromRaFile();
	}

	protected void initFromRaFile() throws IOException {
		int censig = this.raFile.readInt(this.fileOffset);
		if ((long) censig != 33639248L) {
			throw new ZipException("expected CENSIC not found in central directory (at end of zip file)");
		} else {
			if (LOG.isLoggable(Level.FINE)) {
				LOG.fine("found censigOffset=" + this.fileOffset);
			}

			short flag = this.raFile.readShort(this.fileOffset + 8L);
			this.isEncrypted = (flag & 1) > 0;
			this.fileNameLength = this.raFile.readShort(this.fileOffset + 28L);
			byte[] fileNameBytes = this.raFile.readByteArray(this.fileOffset + 46L, this.fileNameLength);
			this.fileName = new String(fileNameBytes, AesZipFileDecrypter.charset);
			if (LOG.isLoggable(Level.FINE)) {
				LOG.fine("fileName = " + this.fileName);
			}

			this.extraFieldOffset = this.fileOffset + 46L + (long) this.fileNameLength;
			this.extraFieldLength = this.raFile.readShort(this.fileOffset + 30L);
			this.localHeaderOffset = (long) this.raFile.readInt(this.fileOffset + 28L + 14L);
			if (LOG.isLoggable(Level.FINE)) {
				LOG.fine("CDS - extraFieldOffset =" + Long.toHexString(this.extraFieldOffset));
				LOG.fine("CDS - extraFieldLength =" + this.extraFieldLength);
				LOG.fine("CDS - localHeaderOffset=" + Long.toHexString(this.localHeaderOffset));
			}

			if (this.isEncrypted) {
				byte[] efhid = this.raFile.readByteArray(this.extraFieldOffset, 2);
				if (efhid[0] == 1 && efhid[1] == -103) {
					this.isAesEncrypted = true;
				} else {
					this.extraFieldOffset = this.localHeaderOffset + 30L + (long) this.fileNameLength;
					this.extraFieldLength = this.raFile.readShort(this.localHeaderOffset + 28L);
					if (LOG.isLoggable(Level.FINE)) {
						LOG.fine("local header - extraFieldOffset=" + Long.toHexString(this.extraFieldOffset));
						LOG.fine("local header - extraFieldLength=" + Long.toHexString((long) this.extraFieldLength));
					}

					if (0 == this.extraFieldLength) {
						throw new ZipException(
								"extra field is of length 0 - this is probably not a WinZip AES encrypted entry");
					}

					efhid = this.raFile.readByteArray(this.extraFieldOffset, 2);
					if (efhid[0] == 1 && efhid[1] == -103) {
						this.isAesEncrypted = true;
					}
				}

				if (this.isAesEncrypted) {
					this.actualCompressionMethod = this.raFile.readShort(this.getExtraFieldOffset() + 9L);
					this.localHeaderSize = 30 + this.getExtraFieldLength() + this.getFileNameLength();
				}
			}

			this.compressedSize = (int) this.raFile.readLong(this.fileOffset + 20L);
			this.uncompressedSize = (int) this.raFile.readLong(this.fileOffset + 24L);
		}
	}

	public int getCompressedSize() {
		return this.compressedSize;
	}

	public int getUncompressedSize() {
		return this.uncompressedSize;
	}

	public boolean isEncrypted() {
		return this.isEncrypted;
	}

	public String getFileName() {
		return this.fileName;
	}

	public short getFileNameLength() {
		return this.fileNameLength;
	}

	public short getExtraFieldLength() {
		return this.extraFieldLength;
	}

	public long getLocalHeaderOffset() {
		return this.localHeaderOffset;
	}

	protected long getExtraFieldOffset() {
		return this.extraFieldOffset;
	}

	public int getOffset() {
		return (int) (this.getLocalHeaderOffset() + (long) this.getLocalHeaderSize()
				+ (long) this.getCryptoHeaderLength());
	}

	public short getActualCompressionMethod() {
		return this.actualCompressionMethod;
	}

	public byte getEncryptionStrength() throws IOException {
		return this.raFile.readByte(this.getExtraFieldOffset() + 8L);
	}

	public int getLocalHeaderSize() {
		return this.localHeaderSize;
	}

	public short getCryptoHeaderLength() {
		return 18;
	}

	public boolean isAesEncrypted() {
		return this.isAesEncrypted;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("fileName\t\t = ").append(this.fileName).append('\n');

		try {
			sb.append("uncompressedSize\t = ").append(this.getUncompressedSize()).append('\n');
			sb.append("compressedSize\t\t = ").append(this.getCompressedSize()).append('\n');
			sb.append("encryptionStrength\t = ").append(this.getEncryptionStrength()).append('\n');
			sb.append("extraFieldOffset\t = ").append(this.getExtraFieldOffset()).append('\n');
			sb.append("extraFieldLength\t = ").append(this.getExtraFieldLength()).append('\n');
			sb.append("localHeaderOffset\t = ").append(this.getLocalHeaderOffset()).append('\n');
			sb.append("localHeaderSize\t\t = ").append(this.getLocalHeaderSize()).append('\n');
			sb.append("offset\t\t\t = ").append(this.getOffset()).append('\n');
		} catch (IOException arg2) {
			LOG.log(Level.WARNING, arg2.getMessage(), arg2);
		}

		return sb.toString();
	}
}