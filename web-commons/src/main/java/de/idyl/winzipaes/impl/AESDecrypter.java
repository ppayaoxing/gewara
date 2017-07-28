/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import java.util.zip.ZipException;

public interface AESDecrypter {
	void init(String arg0, int arg1, byte[] arg2, byte[] arg3) throws ZipException;

	void decrypt(byte[] arg0, int arg1);

	byte[] getFinalAuthentication();
}