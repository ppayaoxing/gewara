/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import java.util.zip.ZipException;

public interface AESEncrypter {
	void init(String arg0, int arg1) throws ZipException;

	void encrypt(byte[] arg0, int arg1);

	byte[] getSalt();

	byte[] getPwVerification();

	byte[] getFinalAuthentication();
}