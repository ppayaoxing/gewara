/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.CentralDirectoryEntry;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;

public class ExtZipEntry extends ZipEntry {
	private CentralDirectoryEntry centralDirectoryEntry;
	protected int flag;
	protected int offset;
	protected int primaryCompressionMethod;

	public ExtZipEntry(String name) {
		super(name);
	}

	public ExtZipEntry(ExtZipEntry entry) {
		super(entry.getName());
		this.setCompressedSize(entry.getCompressedSize());
		this.setSize(entry.getSize());
		this.setComment(entry.getComment());
		this.setTime(entry.getTime());
		this.setMethod(entry.getMethod());
	}

	public ExtZipEntry(String name, CentralDirectoryEntry centralDirectoryEntry) {
		super(name);
		this.centralDirectoryEntry = centralDirectoryEntry;
	}

	public void initEncryptedEntry() {
		this.setCrc(0L);
		this.flag |= 1;
		this.primaryCompressionMethod = 99;
		byte[] extraBytes = new byte[11];
		extraBytes = new byte[]{1, -103, 7, 0, 2, 0, 65, 69, 3, (byte) (this.getMethod() & 255),
				(byte) ((this.getMethod() & '＀') >> 8)};
		this.setExtra(extraBytes);
	}

	public int getFlag() {
		return this.flag;
	}

	public boolean isAesEncrypted() {
		return this.isEncrypted() && this.centralDirectoryEntry != null && this.centralDirectoryEntry.isAesEncrypted();
	}

	public boolean isEncrypted() {
		return (this.flag & 1) > 0;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPrimaryCompressionMethod() {
		return this.primaryCompressionMethod;
	}

	public void setPrimaryCompressionMethod(int primaryCompressionMethod) {
		this.primaryCompressionMethod = primaryCompressionMethod;
	}

	public long getEncryptedDataSize() {
		return this.getCompressedSize() - 10L - 16L - 2L;
	}

	public CentralDirectoryEntry getCentralDirectoryEntry() {
		return this.centralDirectoryEntry;
	}

	public void setSize(long size) {
		if (size < 0L) {
			size &= 4294967295L;
		}

		super.setSize(size);
	}

	public long getDosTime() {
		return javaToDosTime(this.getTime());
	}

	public static long javaToDosTime(long javaTime) {
		Date d = new Date(javaTime);
		Calendar ca = Calendar.getInstance();
		ca.setTime(d);
		int year = ca.get(1);
		return year < 1980
				? 2162688L
				: (long) (year - 1980 << 25 | ca.get(2) + 1 << 21 | ca.get(5) << 16 | ca.get(11) << 11 | ca.get(12) << 5
						| ca.get(13) >> 1);
	}

	public static long dosToJavaTime(long dosTime) {
		Calendar ca = Calendar.getInstance();
		ca.set(1, (int) (dosTime >> 25 & 127L) + 1980);
		ca.set(2, (int) (dosTime >> 21 & 15L) - 1);
		ca.set(5, (int) (dosTime >> 16) & 31);
		ca.set(11, (int) (dosTime >> 11) & 31);
		ca.set(12, (int) (dosTime >> 5) & 63);
		ca.set(13, (int) (dosTime << 1) & 62);
		return ca.getTime().getTime();
	}
}