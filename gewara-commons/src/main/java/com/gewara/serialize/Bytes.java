/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

public class Bytes {
	private static final char[] BASE16 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f' };
	private static final int MASK4 = 15;

	public static byte[] copyOf(byte[] src, int length) {
		byte[] dest = new byte[length];
		System.arraycopy(src, 0, dest, 0, Math.min(src.length, length));
		return dest;
	}

	public static String bytes2hex(byte[] bs) {
		return bytes2hex(bs, 0, bs.length);
	}

	public static String bytes2hex(byte[] bs, int off, int len) {
		if (off < 0) {
			throw new IndexOutOfBoundsException("bytes2hex: offset < 0, offset is " + off);
		} else if (len < 0) {
			throw new IndexOutOfBoundsException("bytes2hex: length < 0, length is " + len);
		} else if (off + len > bs.length) {
			throw new IndexOutOfBoundsException("bytes2hex: offset + length > array length.");
		} else {
			int r = off;
			int w = 0;
			char[] cs = new char[len * 2];

			for (int i = 0; i < len; ++i) {
				byte b = bs[r++];
				cs[w++] = BASE16[b >> 4 & 15];
				cs[w++] = BASE16[b & 15];
			}

			return new String(cs);
		}
	}
}