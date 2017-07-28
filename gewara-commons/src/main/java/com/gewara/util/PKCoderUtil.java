/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

public final class PKCoderUtil {
	private static transient String Algorithm = "DES";
	private static transient byte[] DEFAULT_KEY = new byte[] { -72, -16, -79, -22, -79, -32, -48, -76 };
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(PKCoderUtil.class);

	public static final String encodePK(long pk) {
		return encodePK(Long.valueOf(pk), DEFAULT_KEY);
	}

	public static final String encodePK(Long pk, byte[] skey) {
		byte[] bytes = long2bytes(pk.longValue());
		byte[] encoded = encode(bytes, skey);
		String result = byte2hex(encoded);
		return result;
	}

	private static final byte[] long2bytes(long num) {
		byte[] b = new byte[7];

		for (int i = 1; i < 8; ++i) {
			b[i - 1] = (byte) ((int) (num >>> 56 - i * 8));
		}

		return b;
	}

	public static final String encodePK(String pkStr) {
		Long pk = Long.valueOf(pkStr);
		return encodePK(pk.longValue());
	}

	public static final String encodeString(String original, byte[] skey) {
		String result = null;

		try {
			byte[] pkbytes = original.getBytes("gbk");
			byte[] e = encode(pkbytes, skey);
			result = byte2hex(e);
		} catch (Exception arg4) {
			dbLogger.error(original + LoggerUtils.getExceptionTrace(arg4, 10));
		}

		return result;
	}

	public static final String encodeString(String original) {
		return encodeString(original, DEFAULT_KEY);
	}

	public static final String decodeString(String encrypt) {
		return decodeString(encrypt, DEFAULT_KEY);
	}

	public static final String decodeString(String encodedHex, byte[] skey) {
		byte[] encoded = hex2byte(encodedHex);
		byte[] decoded = decode(encoded, skey);

		try {
			String e = new String(decoded, "gbk");
			return e;
		} catch (Exception arg4) {
			dbLogger.error(encodedHex + ":" + arg4.getClass().getName());
			return null;
		}
	}

	public static final Long encodeNumer(long num) {
		byte[] bytes = long2bytes(num);
		byte[] encoded = encode(bytes, DEFAULT_KEY);
		Long mask = Long.valueOf(255L);
		Long temp = Long.valueOf(0L);
		Long res = Long.valueOf(0L);

		for (int i = 0; i < 8; ++i) {
			res = Long.valueOf(res.longValue() << 8);
			temp = Long.valueOf((long) encoded[i] & mask.longValue());
			res = Long.valueOf(res.longValue() | temp.longValue());
		}

		return Long.valueOf(Math.abs(res.longValue()));
	}

	private static final byte[] encode(byte[] input, byte[] key) {
		SecretKeySpec deskey = new SecretKeySpec(key, Algorithm);
		Cipher c1 = null;

		try {
			c1 = Cipher.getInstance(Algorithm);
			c1.init(1, deskey);
			byte[] e = c1.doFinal(input);
			return e;
		} catch (Exception arg4) {
			dbLogger.error(arg4.getClass().getCanonicalName());
			return null;
		}
	}

	private static byte[] decode(byte[] input, byte[] key) {
		SecretKeySpec deskey = new SecretKeySpec(key, Algorithm);
		Cipher c1 = null;

		try {
			c1 = Cipher.getInstance(Algorithm);
			c1.init(2, deskey);
			byte[] e = c1.doFinal(input);
			return e;
		} catch (Exception arg4) {
			dbLogger.error(arg4.getClass().getCanonicalName());
			return null;
		}
	}

	private static final String byte2hex(byte[] bytes) {
		StringBuilder retString = new StringBuilder();

		for (int i = 0; i < bytes.length; ++i) {
			retString.append(Integer.toHexString(256 + (bytes[i] & 255)).substring(1).toUpperCase());
		}

		return retString.toString();
	}

	private static final byte[] hex2byte(String hex) {
		byte[] bts = new byte[hex.length() / 2];

		for (int i = 0; i < bts.length; ++i) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}

		return bts;
	}

	public static final String encryptString(String original, String key) {
		String tmpKey = StringUtils.rightPad(key, 8, "¾­");

		try {
			byte[] e = Arrays.copyOf(tmpKey.getBytes("utf-8"), 8);
			return encodeString(original, e);
		} catch (Exception arg4) {
			dbLogger.error(original + ":" + key + ":" + arg4.getClass().getCanonicalName());
			return null;
		}
	}

	public static final String decryptString(String encryptStr, String key) {
		if (!StringUtils.isBlank(encryptStr) && encryptStr.length() % 2 != 1) {
			try {
				String e = StringUtils.rightPad(key, 8, "¾­");
				byte[] keys = Arrays.copyOf(e.getBytes("utf-8"), 8);
				String str = decodeString(encryptStr, keys);
				return str;
			} catch (Exception arg4) {
				dbLogger.error(encryptStr + ":" + arg4.getClass().getCanonicalName());
				return "";
			}
		} else {
			return "";
		}
	}

	public static String TriDesEncrypt(String pKey, String pIV, String pContent) {
		String ret = "";

		try {
			IvParameterSpec e = new IvParameterSpec(pIV.getBytes());
			SecretKeySpec key = new SecretKeySpec(pKey.getBytes(), "DESede");
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			cipher.init(1, key, e);
			ret = Base64.encodeBase64String(cipher.doFinal(pContent.getBytes("utf-8")));
			return ret.replaceAll("\r\n", "");
		} catch (Exception arg6) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg6, 10));
			return "";
		}
	}

	public static String triDesDecrypt(String enc, String pKey, String pIV) {
		String ret = "";

		try {
			IvParameterSpec e = new IvParameterSpec(pIV.getBytes());
			SecretKeySpec key = new SecretKeySpec(pKey.getBytes(), "DESede");
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			cipher.init(2, key, e);
			ret = new String(cipher.doFinal(Base64.decodeBase64(enc)), "UTF-8");
			return ret.replaceAll("\r\n", "");
		} catch (Exception arg6) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg6, 10));
			return "";
		}
	}

	public static String RSAEncrypt(String pKey, String pContent) {
		String ret = "";

		try {
			int e = pKey.indexOf("<Modulus>") + 9;
			int endIndex = pKey.indexOf("</Modulus>");
			byte[] b = Base64.decodeBase64(pKey.substring(e, endIndex));
			String N = byte2hex(b);
			e = pKey.indexOf("<Exponent>") + 10;
			endIndex = pKey.indexOf("</Exponent>");
			b = Base64.decodeBase64(pKey.substring(e, endIndex));
			String E = byte2hex(b);
			BigInteger bigN = new BigInteger(N, 16);
			BigInteger bigE = new BigInteger(E, 16);
			RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(bigN, bigE);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(pubSpec));
			ret = Base64.encodeBase64String(cipher.doFinal(pContent.getBytes("utf-8")));
			return ret.replaceAll("\r\n", "");
		} catch (Exception arg11) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg11, 10));
			return "";
		}
	}

	public static String encryptWithThiDES(String keyStr, String plainText, String encoding) {
		try {
			byte[] e = Base64.decodeBase64(keyStr);
			byte[] src = plainText.getBytes(encoding);
			byte[] result = encryptWithThiDES(e, src);
			return Base64.encodeBase64String(result).replaceAll("\r\n", "");
		} catch (Exception arg5) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg5, 10));
			return null;
		}
	}

	public static String decryptWithThiDES(String keyStr, String encrypt, String encoding) {
		try {
			byte[] e = Base64.decodeBase64(keyStr);
			byte[] src = Base64.decodeBase64(encrypt);
			byte[] result = decryptWithThiDES(e, src);
			return new String(result, encoding);
		} catch (Exception arg5) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg5, 10));
			return null;
		}
	}

	public static byte[] encryptWithThiDES(byte[] key, byte[] src) throws Exception {
		SecretKeySpec deskey = new SecretKeySpec(key, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(1, deskey);
		byte[] result = cipher.doFinal(src);
		return result;
	}

	public static byte[] decryptWithThiDES(byte[] key, byte[] encrypted) throws Exception {
		SecretKeySpec deskey = new SecretKeySpec(key, "DESede");
		Cipher c1 = Cipher.getInstance("DESede");
		c1.init(2, deskey);
		byte[] result = c1.doFinal(encrypted);
		return result;
	}

	public static String getRandomKey(int length) {
		byte[] key = new byte[length];

		for (int i = 0; i < length; ++i) {
			key[i] = (byte) (RandomUtils.nextInt() & 255);
		}

		return Base64.encodeBase64String(key);
	}
}