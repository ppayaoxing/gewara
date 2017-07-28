/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.ExtZipEntry;
import de.idyl.winzipaes.impl.ZipConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;

public class ExtZipOutputStream implements ZipConstants {
	protected String comment;
	protected OutputStream out;
	protected int written;
	protected static final short ZIP_VERSION = 20;
	private List<ExtZipEntry> entries = new ArrayList();

	public ExtZipOutputStream(File file) throws IOException {
		this.out = new FileOutputStream(file);
	}

	public ExtZipOutputStream(OutputStream out) {
		this.out = out;
	}

	public int getWritten() {
		return this.written;
	}

	public void writeBytes(byte[] b) throws IOException {
		this.out.write(b);
		this.written += b.length;
	}

	public void writeShort(int v) throws IOException {
		this.out.write(v >>> 0 & 255);
		this.out.write(v >>> 8 & 255);
		this.written += 2;
	}

	public void writeInt(long v) throws IOException {
		this.out.write((int) (v >>> 0 & 255L));
		this.out.write((int) (v >>> 8 & 255L));
		this.out.write((int) (v >>> 16 & 255L));
		this.out.write((int) (v >>> 24 & 255L));
		this.written += 4;
	}

	public void writeBytes(byte[] b, int off, int len) throws IOException {
		this.out.write(b, off, len);
		this.written += len;
	}

	protected void writeFileInfo(ExtZipEntry entry) throws IOException {
		this.writeShort(20);
		this.writeShort(entry.getFlag());
		this.writeShort(entry.getPrimaryCompressionMethod());
		this.writeInt(entry.getDosTime());
		this.writeInt(entry.getCrc());
		this.writeInt((long) ((int) entry.getCompressedSize()));
		this.writeInt((long) ((int) entry.getSize()));
		this.writeShort(entry.getName().length());
		if (entry.getExtra() != null) {
			this.writeShort(entry.getExtra().length);
		} else {
			this.writeShort(0);
		}

	}

	protected void writeDirEntry(ExtZipEntry entry) throws IOException {
		this.writeInt(33639248L);
		this.writeShort(20);
		this.writeFileInfo(entry);
		this.writeShort(0);
		this.writeShort(0);
		this.writeShort(0);
		this.writeInt(0L);
		this.writeInt((long) entry.getOffset());
		this.writeBytes(entry.getName().getBytes("gbk"));
		this.writeExtraBytes(entry);
	}

	protected void writeExtraBytes(ZipEntry entry) throws IOException {
		byte[] extraBytes = entry.getExtra();
		if (extraBytes != null) {
			this.writeBytes(extraBytes);
		}

	}

	public void putNextEntry(ExtZipEntry entry) throws IOException {
		this.entries.add(entry);
		entry.setOffset(this.written);
		this.writeInt(67324752L);
		this.writeFileInfo(entry);
		this.writeBytes(entry.getName().getBytes("gbk"));
		this.writeExtraBytes(entry);
	}

	public void finish() throws IOException {
		int dirOffset = this.written;
		int startOfCentralDirectory = this.written;
		Iterator it = this.entries.iterator();

		while (it.hasNext()) {
			ExtZipEntry centralDirectorySize = (ExtZipEntry) it.next();
			this.writeDirEntry(centralDirectorySize);
		}

		int centralDirectorySize1 = this.written - startOfCentralDirectory;
		this.writeInt(101010256L);
		this.writeShort(0);
		this.writeShort(0);
		this.writeShort(this.entries.size());
		this.writeShort(this.entries.size());
		this.writeInt((long) centralDirectorySize1);
		this.writeInt((long) dirOffset);
		byte[] commentBytes = this.comment != null ? this.comment.getBytes("gbk") : new byte[0];
		this.writeShort(commentBytes.length);
		if (commentBytes.length > 0) {
			this.writeBytes(commentBytes);
		}

		this.out.close();
	}

	public void close() throws IOException {
		this.out.close();
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}