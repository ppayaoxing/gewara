/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes;

import de.idyl.winzipaes.impl.AESEncrypter;
import de.idyl.winzipaes.impl.ExtZipEntry;
import de.idyl.winzipaes.impl.ExtZipOutputStream;
import de.idyl.winzipaes.impl.ZipFileEntryInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class AesZipFileEncrypter {
	private static final Logger LOG = Logger.getLogger(AesZipFileEncrypter.class.getName());
	protected AESEncrypter encrypter;
	protected ExtZipOutputStream zipOS;

	public AesZipFileEncrypter(String pathName, AESEncrypter encrypter) throws IOException {
		this.zipOS = new ExtZipOutputStream(new File(pathName));
		this.encrypter = encrypter;
	}

	public AesZipFileEncrypter(File outFile, AESEncrypter encrypter) throws IOException {
		this.zipOS = new ExtZipOutputStream(outFile);
		this.encrypter = encrypter;
	}

	public AesZipFileEncrypter(OutputStream outFile, AESEncrypter encrypter) {
		this.zipOS = new ExtZipOutputStream(outFile);
		this.encrypter = encrypter;
	}

	protected void add(ExtZipEntry zipEntry, InputStream zipData) throws IOException, UnsupportedEncodingException {
		this.zipOS.putNextEntry(zipEntry);
		byte[] data = new byte[1024];

		for (int read = zipData.read(data); read != -1; read = zipData.read(data)) {
			this.zipOS.writeBytes(data, 0, read);
		}

	}

	protected void add(ZipFile inFile, String password) throws IOException, UnsupportedEncodingException {
		ZipFileEntryInputStream zfe = new ZipFileEntryInputStream(inFile.getName());

		try {
			Enumeration en = inFile.entries();

			while (en.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) en.nextElement();
				zfe.nextEntry(ze);
				this.add(ze, zfe, password);
			}
		} finally {
			zfe.close();
		}

	}

	protected void add(ZipEntry zipEntry, ZipFileEntryInputStream zipData, String password)
			throws IOException, UnsupportedEncodingException {
		this.encrypter.init(password, 256);
		ExtZipEntry entry = new ExtZipEntry(zipEntry.getName());
		entry.setMethod(zipEntry.getMethod());
		entry.setSize(zipEntry.getSize());
		entry.setCompressedSize(zipEntry.getCompressedSize() + 28L);
		entry.setTime(zipEntry.getTime());
		entry.initEncryptedEntry();
		this.zipOS.putNextEntry(entry);
		this.zipOS.writeBytes(this.encrypter.getSalt());
		this.zipOS.writeBytes(this.encrypter.getPwVerification());
		byte[] data = new byte[1024];

		for (int read = zipData.read(data); read != -1; read = zipData.read(data)) {
			this.encrypter.encrypt(data, read);
			this.zipOS.writeBytes(data, 0, read);
		}

		byte[] finalAuthentication = this.encrypter.getFinalAuthentication();
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("finalAuthentication=" + Arrays.toString(finalAuthentication) + " at pos="
					+ this.zipOS.getWritten());
		}

		this.zipOS.writeBytes(finalAuthentication);
	}

	public void add(File file, String pathForEntry, String password) throws IOException, UnsupportedEncodingException {
		FileInputStream fis = new FileInputStream(file);

		try {
			this.add((String) pathForEntry, (InputStream) fis, password);
		} finally {
			fis.close();
		}

	}

	public void add(File file, String password) throws IOException, UnsupportedEncodingException {
		FileInputStream fis = new FileInputStream(file);

		try {
			this.add((String) file.getPath(), (InputStream) fis, password);
		} finally {
			fis.close();
		}

	}

	public void add(String name, InputStream is, String password) throws IOException, UnsupportedEncodingException {
		this.encrypter.init(password, 256);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DeflaterOutputStream dos = new DeflaterOutputStream(bos, new Deflater(9, true), 8192);
		boolean read = false;
		long inputLen = 0L;
		byte[] buf = new byte[8192];

		int read1;
		while ((read1 = is.read(buf)) > 0) {
			inputLen += (long) read1;
			dos.write(buf, 0, read1);
		}

		dos.close();
		byte[] data = bos.toByteArray();
		ExtZipEntry entry = new ExtZipEntry(name);
		entry.setMethod(8);
		entry.setSize(inputLen);
		entry.setCompressedSize((long) (data.length + 28));
		entry.setTime((new Date()).getTime());
		entry.initEncryptedEntry();
		this.zipOS.putNextEntry(entry);
		this.zipOS.writeBytes(this.encrypter.getSalt());
		this.zipOS.writeBytes(this.encrypter.getPwVerification());
		this.encrypter.encrypt(data, data.length);
		this.zipOS.writeBytes(data, 0, data.length);
		byte[] finalAuthentication = this.encrypter.getFinalAuthentication();
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("finalAuthentication=" + Arrays.toString(finalAuthentication) + " at pos="
					+ this.zipOS.getWritten());
		}

		this.zipOS.writeBytes(finalAuthentication);
	}

	public static void zip(File inFile, File outFile) throws IOException {
		FileInputStream fin = new FileInputStream(inFile);
		FileOutputStream fout = new FileOutputStream(outFile);
		ZipOutputStream zout = new ZipOutputStream(fout);

		try {
			zout.putNextEntry(new ZipEntry(inFile.getName()));
			byte[] buffer = new byte[1024];

			int len;
			while ((len = fin.read(buffer)) > 0) {
				zout.write(buffer, 0, len);
			}

			zout.closeEntry();
		} finally {
			zout.close();
			fin.close();
		}
	}

	public void addAll(File pathToZipFile, String password) throws IOException {
		ZipFile zipFile = new ZipFile(pathToZipFile);

		try {
			this.add(zipFile, password);
		} finally {
			zipFile.close();
		}

	}

	public void setComment(String comment) {
		this.zipOS.setComment(comment);
	}

	public void close() throws IOException {
		this.zipOS.finish();
	}

	public static void zipAndEncrypt(File inFile, File outFile, String password, AESEncrypter encrypter)
			throws IOException {
		AesZipFileEncrypter enc = new AesZipFileEncrypter(outFile, encrypter);

		try {
			enc.add(inFile, password);
		} finally {
			enc.close();
		}

	}

	public static void zipAndEncryptAll(File inZipFile, File outFile, String password, AESEncrypter encrypter)
			throws IOException {
		AesZipFileEncrypter enc = new AesZipFileEncrypter(outFile, encrypter);

		try {
			enc.addAll(inZipFile, password);
		} finally {
			enc.close();
		}

	}
}