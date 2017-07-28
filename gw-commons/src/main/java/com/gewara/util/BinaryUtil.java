/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.nio.ByteBuffer;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class BinaryUtil {
	public static byte[] getBytes1(Integer... nums) {
		byte[] result = new byte[4 * nums.length];

		for (int i = 0; i < nums.length; ++i) {
			byte[] src = toBytes(nums[i].intValue());
			System.arraycopy(src, 0, result, i * 4, 4);
		}

		return result;
	}

	public static byte[] getBytes2(Long num1, Integer num2) {
		byte[] result = new byte[12];
		byte[] src = toBytes(num1.longValue());
		System.arraycopy(src, 0, result, 0, 8);
		byte[] src2 = toBytes(num2.intValue());
		System.arraycopy(src2, 0, result, 8, 4);
		return result;
	}

	public static byte[] getBytes3(Long num1, Long num2, Integer num3) {
		byte[] result = new byte[20];
		byte[] src = toBytes(num1.longValue());
		System.arraycopy(src, 0, result, 0, 8);
		byte[] src2 = toBytes(num2.longValue());
		System.arraycopy(src2, 0, result, 8, 8);
		byte[] src3 = toBytes(num3.intValue());
		System.arraycopy(src3, 0, result, 16, 4);
		return result;
	}

	public static String getIdHex(Long id) {
		return Hex.encodeHexString(toBytes(id.longValue()));
	}

	public static Long convertIdHexToLong(String idHex) throws DecoderException {
		byte[] hexbytes = Hex.decodeHex(idHex.toCharArray());
		return Long.valueOf(ByteBuffer.wrap(hexbytes).asLongBuffer().get());
	}

	public static byte[] toBytes(long val) {
		byte[] b = new byte[8];

		for (int i = 7; i > 0; --i) {
			b[i] = (byte) ((int) val);
			val >>>= 8;
		}

		b[0] = (byte) ((int) val);
		return b;
	}

	public static byte[] toBytes(int val) {
		byte[] b = new byte[4];

		for (int i = 3; i > 0; --i) {
			b[i] = (byte) val;
			val >>>= 8;
		}

		b[0] = (byte) val;
		return b;
	}
}