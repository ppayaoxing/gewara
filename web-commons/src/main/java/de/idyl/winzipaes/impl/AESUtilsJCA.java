/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtilsJCA {
	public static final int ITERATION_COUNT = 1000;
	public static final int BLOCK_SIZE = 16;
	private final Cipher cipher;
	private final Mac mac;
	private final byte[] passwordVerifier;
	private final byte[] iv = new byte[16];
	private final byte[] keystream = new byte[16];
	private int next = 16;

	public AESUtilsJCA(String password, int keySize, byte[] salt) {
		if (keySize != 128 && keySize != 192 && keySize != 256) {
			throw new IllegalArgumentException("Illegal keysize: " + keySize);
		} else {
			try {
				SecretKeyFactory e = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
				char[] passwordChars = password.toCharArray();
				PBEKeySpec keySpec = new PBEKeySpec(passwordChars, salt, 1000, keySize * 2 + 16);
				SecretKey sk = e.generateSecret(keySpec);
				byte[] keyBytes = sk.getEncoded();
				this.cipher = Cipher.getInstance("AES");
				SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, 0, keySize / 8, "AES");
				this.cipher.init(1, secretKeySpec);
				this.mac = Mac.getInstance("HmacSHA1");
				this.mac.init(new SecretKeySpec(keyBytes, keySize / 8, keySize / 8, "HmacSHA1"));
				this.passwordVerifier = new byte[2];
				System.arraycopy(keyBytes, 2 * (keySize / 8), this.passwordVerifier, 0, 2);
			} catch (NoSuchAlgorithmException arg9) {
				throw new TypeNotPresentException(arg9.getMessage(), arg9);
			} catch (InvalidKeyException arg10) {
				arg10.printStackTrace();
				throw new TypeNotPresentException(arg10.getMessage(), arg10);
			} catch (InvalidKeySpecException arg11) {
				throw new TypeNotPresentException(arg11.getMessage(), arg11);
			} catch (NoSuchPaddingException arg12) {
				throw new TypeNotPresentException(arg12.getMessage(), arg12);
			}
		}
	}

	public void cryptUpdate(byte[] in, int length) {
		try {
			for (int e = 0; e < length; ++e) {
				if (this.next == 16) {
					for (int j = 0; j < 16 && ++this.iv[j] == 0; ++j) {
						;
					}

					this.cipher.update(this.iv, 0, 16, this.keystream);
					this.next = 0;
				}

				in[e] ^= this.keystream[this.next++];
			}

		} catch (ShortBufferException arg4) {
			throw new Error();
		}
	}

	public void authUpdate(byte[] in, int length) {
		this.mac.update(in, 0, length);
	}

	public byte[] getFinalAuthentifier() {
		byte[] auth = new byte[10];
		System.arraycopy(this.mac.doFinal(), 0, auth, 0, 10);
		return auth;
	}

	public byte[] getPasswordVerifier() {
		return this.passwordVerifier;
	}
}