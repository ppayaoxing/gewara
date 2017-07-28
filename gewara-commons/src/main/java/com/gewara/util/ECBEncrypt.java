/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class ECBEncrypt {
	public static String ecbEncrypt(String input, String key) {
		return ecbEncrypt(input, (String) key, "iso-8859-1", 8);
	}

	public static String ecbEncrypt(String input, String keyStr, String charset, int length) {
		byte[] keys = String2Hex(keyStr);
		return ecbEncrypt(input, keys, charset, length);
	}

	public static String ecbEncrypt(String input, byte[] keys, String charset, int length) {
		byte[] mac = new byte[8];
		byte[] temp = new byte[8];
		int z = 0;

		try {
			byte[] e = input.getBytes(charset);
			int len = e.length;
			int other = len % 8;
			byte[] tmpResult;
			if (other != 0) {
				tmpResult = e;
				e = new byte[e.length + (8 - other)];
				System.arraycopy(tmpResult, 0, e, 0, len);
			}

			int arg12;
			for (arg12 = 0; arg12 < 8; ++arg12) {
				mac[arg12] = e[arg12];
			}

			for (arg12 = 8; arg12 <= e.length; ++z) {
				if (arg12 != 8 && arg12 % 8 == 0) {
					for (int j = 0; j < 8; ++j) {
						mac[j] ^= temp[j];
					}

					z = 0;
					temp = new byte[8];
				}

				if (arg12 != e.length) {
					temp[z] = e[arg12];
				}

				++arg12;
			}

			tmpResult = new byte[8];
			tmpResult = des(mac, keys);
			return Hex2String(tmpResult).toUpperCase().substring(0, length);
		} catch (Exception arg11) {
			return null;
		}
	}

	public static String Hex2String(byte[] bytearr) {
		if (bytearr == null) {
			return "null";
		} else {
			StringBuilder sb = new StringBuilder();

			for (int k = 0; k < bytearr.length; ++k) {
				if ((bytearr[k] & 255) < 16) {
					sb.append("0");
				}

				sb.append(Integer.toString(bytearr[k] & 255, 16));
			}

			return sb.toString();
		}
	}

	public static byte[] String2Hex(String bytearr) {
		if (bytearr != null && bytearr.length() % 2 == 0) {
			byte[] dest = new byte[bytearr.length() / 2];

			for (int i = 0; i < dest.length; ++i) {
				String val = bytearr.substring(2 * i, 2 * i + 2);
				dest[i] = (byte) Integer.parseInt(val, 16);
			}

			return dest;
		} else {
			return new byte[0];
		}
	}

	public static byte[] des(byte[] reqBytes, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ShortBufferException {
		SecretKeySpec keySpec = null;
		DESKeySpec deskey = null;
		deskey = new DESKeySpec(key);
		keySpec = new SecretKeySpec(deskey.getKey(), "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(1, keySpec);
		byte[] cipherText = new byte[cipher.getOutputSize(reqBytes.length)];
		int ctLength = cipher.update(reqBytes, 0, reqBytes.length, cipherText, 0);
		ctLength += cipher.doFinal(cipherText, ctLength);
		return cipherText;
	}
}