/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.ByteArrayHelper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class ExtRandomAccessFile {
	protected RandomAccessFile file;

	public ExtRandomAccessFile(File zipFile) throws IOException {
		this.file = new RandomAccessFile(zipFile, "r");
	}

	public void close() throws IOException {
		this.file.close();
	}

	public int readByteArray(byte[] buffer, int len) throws IOException {
		int read = this.file.read(buffer, 0, len);
		return read;
	}

	public byte[] readByteArray(long pos, int length) throws IOException {
		byte[] out = new byte[length];
		this.file.seek(pos);
		this.file.read(out, 0, length);
		return out;
	}

	public long readLong() throws IOException {
		byte[] b = new byte[8];
		this.file.read(b, 0, 8);
		long out = ByteArrayHelper.toLong(b);
		return out;
	}

	public long readLong(long pos) throws IOException {
		this.file.seek(pos);
		return this.readLong();
	}

	public int readInt() throws IOException {
		byte[] b = new byte[4];
		this.file.read(b, 0, 4);
		int out = ByteArrayHelper.toInt(b);
		return out;
	}

	public int readInt(long pos) throws IOException {
		this.file.seek(pos);
		return this.readInt();
	}

	public short readShort() throws IOException {
		byte[] b = new byte[2];
		this.file.read(b, 0, 2);
		short out = ByteArrayHelper.toShort(b);
		return out;
	}

	public short readShort(long pos) throws IOException {
		this.file.seek(pos);
		return this.readShort();
	}

	public byte readByte() throws IOException {
		byte[] b = new byte[1];
		this.file.read(b, 0, 1);
		return b[0];
	}

	public byte readByte(long pos) throws IOException {
		this.file.seek(pos);
		return this.readByte();
	}

	public void seek(long pos) throws IOException {
		this.file.seek(pos);
	}

	public long getFilePointer() throws IOException {
		return this.file.getFilePointer();
	}

	public long lastPosOf(byte[] bytesToFind) throws IOException {
		long out = -1L;

		for (long seekPos = this.file.length() - 1L - (long) bytesToFind.length; seekPos > 3L
				&& out == -1L; --seekPos) {
			byte[] buffer = this.readByteArray(seekPos, bytesToFind.length);
			if (Arrays.equals(bytesToFind, buffer)) {
				out = seekPos;
			}
		}

		return out;
	}
}