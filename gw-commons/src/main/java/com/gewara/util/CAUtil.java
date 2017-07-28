/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import org.apache.commons.codec.binary.Base64;

public class CAUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(CAUtil.class);
	public static final String MD5withRSA = "MD5withRSA";
	public static final String SHA1WithRSA = "SHA1WithRSA";

	public static PrivateKey getFirstPvkfromPfx(String pfxFile, String password) {
		PrivateKey prikey = null;
		char[] nPassword = password.toCharArray();
		KeyStore ks = getKsfromPfx(pfxFile, password);

		try {
			prikey = (PrivateKey) ks.getKey((String) ks.aliases().nextElement(), nPassword);
		} catch (UnrecoverableKeyException arg5) {
			dbLogger.error("", arg5);
		} catch (KeyStoreException arg6) {
			dbLogger.error("", arg6);
		} catch (NoSuchAlgorithmException arg7) {
			dbLogger.error("", arg7);
		}

		return prikey;
	}

	public static PrivateKey getPvkfromPfx(String pfxFile, String password, String alias) {
		PrivateKey prikey = null;
		char[] nPassword = password.toCharArray();
		KeyStore ks = getKsfromPfx(pfxFile, password);

		try {
			prikey = (PrivateKey) ks.getKey(alias, nPassword);
		} catch (UnrecoverableKeyException arg6) {
			dbLogger.error("", arg6);
		} catch (KeyStoreException arg7) {
			dbLogger.error("", arg7);
		} catch (NoSuchAlgorithmException arg8) {
			dbLogger.error("", arg8);
		}

		return prikey;
	}

	private static KeyStore getKsfromPfx(String pfxFile, String password) {
		FileInputStream fis = null;

		try {
			KeyStore e = KeyStore.getInstance("PKCS12");
			fis = new FileInputStream(pfxFile);
			e.load(fis, password.toCharArray());
			KeyStore arg3 = e;
			return arg3;
		} catch (Exception arg13) {
			dbLogger.error("", arg13);
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException arg12) {
					dbLogger.error("", arg12);
				}
			}

		}

		return null;
	}

	public static String getAlsfromPfx(String pfxFile, String strPassword) {
		String keyAlias = null;
		KeyStore ks = getKsfromPfx(pfxFile, strPassword);

		try {
			Enumeration e = ks.aliases();
			if (e.hasMoreElements()) {
				keyAlias = (String) e.nextElement();
			}
		} catch (KeyStoreException arg4) {
			dbLogger.error("", arg4);
		}

		return keyAlias;
	}

	public static X509Certificate getX509Certificate(String certFile) {
		X509Certificate x509Certificate = null;
		FileInputStream ism = null;

		try {
			CertificateFactory e = CertificateFactory.getInstance("X.509");
			ism = new FileInputStream(certFile);
			x509Certificate = (X509Certificate) e.generateCertificate(ism);
		} catch (CertificateException arg13) {
			dbLogger.error("", arg13);
		} catch (FileNotFoundException arg14) {
			dbLogger.error("", arg14);
		} finally {
			if (null != ism) {
				try {
					ism.close();
				} catch (IOException arg12) {
					dbLogger.error("", arg12);
				}
			}

		}

		return x509Certificate;
	}

	public static Certificate getCfefromPfx(String certFile, String password, String alias) {
		Certificate cert = null;

		try {
			KeyStore e = getKsfromPfx(certFile, password);
			cert = e.getCertificate(alias);
		} catch (KeyStoreException arg4) {
			dbLogger.error("", arg4);
		}

		return cert;
	}

	public static boolean doCheck(String content, String sign, String publicKey, String algorithm) {
		try {
			PublicKey e = getPublicKeyFromX509("RSA", publicKey);
			Signature signature = Signature.getInstance(algorithm);
			signature.initVerify(e);
			signature.update(content.getBytes("UTF-8"));
			return signature.verify(Base64.decodeBase64(sign.getBytes()));
		} catch (Exception arg5) {
			return false;
		}
	}

	public static boolean doCheck(String content, String sign, String publicKey) {
		return doCheck(content, sign, publicKey, "MD5withRSA");
	}

	private static PublicKey getPublicKeyFromX509(String algorithm, String publicKey) throws NoSuchAlgorithmException {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
			byte[] encodedKey = publicKey.getBytes();
			encodedKey = Base64.decodeBase64(encodedKey);
			return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
		} catch (InvalidKeySpecException arg3) {
			return null;
		}
	}

	public static String doSign(String content, String privateKey, String encoding) {
		return doSign(content, privateKey, encoding, "MD5withRSA");
	}

	public static String doSign(String content, String privateKey, String encoding, String algorithm) {
		try {
			KeyFactory e = KeyFactory.getInstance("RSA");
			byte[] encodedKey = privateKey.getBytes(encoding);
			encodedKey = Base64.decodeBase64(encodedKey);
			PrivateKey priKey = e.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
			Signature signature = Signature.getInstance(algorithm);
			signature.initSign(priKey);
			signature.update(content.getBytes(encoding));
			byte[] signed = signature.sign();
			return new String(Base64.encodeBase64(signed));
		} catch (Exception arg8) {
			dbLogger.warn(arg8, 20);
			return "";
		}
	}

	public static String doSign(String content, PrivateKey priKey, String encoding, String algorithm) {
		try {
			Signature e = Signature.getInstance(algorithm);
			e.initSign(priKey);
			e.update(content.getBytes(encoding));
			byte[] signed = e.sign();
			return new String(Base64.encodeBase64(signed));
		} catch (Exception arg5) {
			dbLogger.warn(arg5, 20);
			return "";
		}
	}

	public static byte[] doSign(byte[] content, PrivateKey priKey, String algorithm) {
		try {
			Signature e = Signature.getInstance(algorithm);
			e.initSign(priKey);
			e.update(content);
			byte[] signed = e.sign();
			return signed;
		} catch (Exception arg4) {
			dbLogger.warn(arg4, 20);
			return null;
		}
	}

	public static boolean doCheck(String content, String sign, byte[] publicKey) {
		return doCheck(content, sign, publicKey, "MD5withRSA");
	}

	public static boolean doCheck(String content, String sign, byte[] publicKey, String algorithm) {
		try {
			PublicKey e = getPublicKeyFromX509("RSA", publicKey);
			Signature signature = Signature.getInstance(algorithm);
			signature.initVerify(e);
			signature.update(content.getBytes("UTF-8"));
			return signature.verify(Base64.decodeBase64(sign.getBytes()));
		} catch (Exception arg5) {
			return false;
		}
	}

	public static boolean doCheck(String content, byte[] sign, byte[] publicKey) {
		return doCheck(content, sign, publicKey, "MD5withRSA");
	}

	public static boolean doCheck(String content, byte[] sign, byte[] publicKey, String algorithm) {
		try {
			PublicKey e = getPublicKeyFromX509("RSA", publicKey);
			Signature signature = Signature.getInstance(algorithm);
			signature.initVerify(e);
			signature.update(content.getBytes("UTF-8"));
			return signature.verify(sign);
		} catch (Exception arg5) {
			return false;
		}
	}

	private static PublicKey getPublicKeyFromX509(String algorithm, byte[] publicKey) throws NoSuchAlgorithmException {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
			return keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
		} catch (InvalidKeySpecException arg2) {
			return null;
		}
	}
}