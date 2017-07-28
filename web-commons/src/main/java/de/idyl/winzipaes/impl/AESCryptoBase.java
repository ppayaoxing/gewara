/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

public class AESCryptoBase {
	public static final int KEY_SIZE_BIT = 256;
	public static final int KEY_SIZE_BYTE = 32;
	public static final int ITERATION_COUNT = 1000;
	protected byte[] saltBytes;
	protected byte[] cryptoKeyBytes;
	protected byte[] authenticationCodeBytes;
	protected byte[] pwVerificationBytes;
	protected int blockSize;
	protected int nonce;
}