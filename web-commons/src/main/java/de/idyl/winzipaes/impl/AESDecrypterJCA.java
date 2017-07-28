/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.AESDecrypter;
import de.idyl.winzipaes.impl.AESUtilsJCA;
import java.util.Arrays;
import java.util.zip.ZipException;

public class AESDecrypterJCA implements AESDecrypter {
	private AESUtilsJCA utils;

	public void init(String password, int keySize, byte[] salt, byte[] passwordVerifier) throws ZipException {
		this.utils = new AESUtilsJCA(password, keySize, salt);
		if (!Arrays.equals(passwordVerifier, this.utils.getPasswordVerifier())) {
			throw new ZipException("Password verification failed");
		}
	}

	public void decrypt(byte[] in, int length) {
		this.utils.authUpdate(in, length);
		this.utils.cryptUpdate(in, length);
	}

	public byte[] getFinalAuthentication() {
		return this.utils.getFinalAuthentifier();
	}
}