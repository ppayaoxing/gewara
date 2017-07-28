/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

public class ByteArrayHelper {
	public static long toLong(byte[] in) {
		long out = 0L;

		for (int i = in.length - 1; i > 0; --i) {
			out |= (long) (in[i] & 255);
			out <<= 8;
		}

		out |= (long) (in[0] & 255);
		return out;
	}

	public static int toInt(byte[] in) {
		int out = 0;

		for (int i = in.length - 1; i > 0; --i) {
			out |= in[i] & 255;
			out <<= 8;
		}

		out |= in[0] & 255;
		return out;
	}

	public static short toShort(byte[] in) {
		short out = 0;

		for (int i = in.length - 1; i > 0; --i) {
			out = (short) (out | in[i] & 255);
			out = (short) (out << 8);
		}

		out = (short) (out | in[0] & 255);
		return out;
	}

	public static byte[] toByteArray(int in) {
		byte[] out = new byte[]{(byte) in, (byte) (in >> 8), (byte) (in >> 16), (byte) (in >> 24)};
		return out;
	}

	public static byte[] toByteArray(int in, int outSize) {
		byte[] out = new byte[outSize];
		byte[] intArray = toByteArray(in);

		for (int i = 0; i < intArray.length && i < outSize; ++i) {
			out[i] = intArray[i];
		}

		return out;
	}

	public static String toString(byte[] theByteArray) {
		StringBuffer out = new StringBuffer();

		for (int i = 0; i < theByteArray.length; ++i) {
			String s = Integer.toHexString(theByteArray[i] & 255);
			if (s.length() < 2) {
				out.append('0');
			}

			out.append(s).append(' ');
		}

		return out.toString();
	}

	public static boolean isEqual(byte[] first, byte[] second) {
		boolean out = first != null && second != null && first.length == second.length;

		for (int i = 0; out && i < first.length; ++i) {
			if (first[i] != second[i]) {
				out = false;
			}
		}

		return out;
	}
}