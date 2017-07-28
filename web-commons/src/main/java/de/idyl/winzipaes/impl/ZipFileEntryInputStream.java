/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.ByteArrayHelper;
import de.idyl.winzipaes.impl.ZipConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

public class ZipFileEntryInputStream implements ZipConstants {
	private static final Logger LOG = Logger.getLogger(ZipFileEntryInputStream.class.getName());
	protected FileInputStream fis;
	protected long startPos;
	protected long endPos;
	protected long currentPos;
	protected long compressedSize;

	public long getCompressedSize() {
		return this.compressedSize;
	}

	public ZipFileEntryInputStream(String fileName) throws IOException {
		this.fis = new FileInputStream(fileName);
	}

	public void nextEntry(ZipEntry ze) throws IOException {
		LOG.fine("nextEntry().currentPos=" + this.currentPos);
		byte[] intBuffer = new byte[4];
		int bytesRead = this.fis.read(intBuffer);
		LOG.fine("bytes read=" + bytesRead);
		if (bytesRead == -1) {
			throw new IOException("no data available - available=" + this.fis.available());
		} else {
			byte dataDescriptorLength = 0;
			if (Arrays.equals(intBuffer, new byte[]{80, 75, 7, 8})) {
				dataDescriptorLength = 12;
				this.fis.skip((long) dataDescriptorLength);
				this.fis.read(intBuffer);
			}

			if (!Arrays.equals(intBuffer, new byte[]{80, 75, 3, 4})) {
				throw new IOException(
						"wrong local file header signature - value=" + ByteArrayHelper.toString(intBuffer));
			} else {
				boolean hasDataDescriptor = (ze.getMethod() & 8) > 0;
				LOG.fine("nextEntry().hasDataDescriptor=" + hasDataDescriptor);
				this.compressedSize = ze.getCompressedSize();
				this.fis.skip(22L);
				byte[] shortBuffer = new byte[2];
				this.fis.read(shortBuffer);
				int fileNameLength = ByteArrayHelper.toInt(shortBuffer);
				this.fis.read(shortBuffer);
				int extraFieldLength = ByteArrayHelper.toInt(shortBuffer);
				this.startPos = (long) (30 + fileNameLength + extraFieldLength + dataDescriptorLength);
				this.currentPos = this.startPos;
				this.endPos = this.startPos + this.compressedSize;
				this.fis.skip((long) (fileNameLength + extraFieldLength));
			}
		}
	}

	public int read(byte[] b) throws IOException {
		return this.read(b, 0, b.length);
	}

	public int read(byte[] b, int off, int len) throws IOException {
		int bytesRead = -1;
		int remainingBytes = (int) (this.endPos - this.currentPos);
		if (remainingBytes > 0) {
			if (this.currentPos + (long) len < this.endPos) {
				bytesRead = this.fis.read(b, off, len);
				this.currentPos += (long) bytesRead;
			} else {
				bytesRead = this.fis.read(b, off, remainingBytes);
				this.currentPos += (long) bytesRead;
			}
		}

		return bytesRead;
	}

	public void close() throws IOException {
		this.fis.close();
	}
}