/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.AESEncrypter;
import de.idyl.winzipaes.impl.AESUtilsJCA;
import java.security.SecureRandom;
import java.util.Random;

public class AESEncrypterJCA implements AESEncrypter {
	private byte[] salt;
	private AESUtilsJCA utils;
	private static final Random RANDOM = new SecureRandom();

	public void init(String password, int keySize) {
		this.salt = createSalt(keySize / 16);
		this.utils = new AESUtilsJCA(password, keySize, this.salt);
	}

	public void encrypt(byte[] in, int length) {
		this.utils.cryptUpdate(in, length);
		this.utils.authUpdate(in, length);
	}

	public byte[] getSalt() {
		return this.salt;
	}

	public byte[] getPwVerification() {
		return this.utils.getPasswordVerifier();
	}

	public byte[] getFinalAuthentication() {
		return this.utils.getFinalAuthentifier();
	}

	private static byte[] createSalt(int size) {
		byte[] salt = new byte[size];
		RANDOM.nextBytes(salt);
		return salt;
	}
}