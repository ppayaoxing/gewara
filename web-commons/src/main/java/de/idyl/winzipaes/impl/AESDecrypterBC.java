/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.AESCryptoBase;
import de.idyl.winzipaes.impl.AESDecrypter;
import de.idyl.winzipaes.impl.ByteArrayHelper;
import java.util.zip.ZipException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class AESDecrypterBC extends AESCryptoBase implements AESDecrypter {
	protected CipherParameters cipherParameters;
	protected SICBlockCipher aesCipher;
	protected HMac mac;

	public void init(String pwStr, int keySize, byte[] salt, byte[] pwVerification) throws ZipException {
		byte[] pwBytes = pwStr.getBytes();
		super.saltBytes = salt;
		PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
		generator.init(pwBytes, salt, 1000);
		this.cipherParameters = generator.generateDerivedParameters(528);
		byte[] keyBytes = ((KeyParameter) this.cipherParameters).getKey();
		this.cryptoKeyBytes = new byte[32];
		System.arraycopy(keyBytes, 0, this.cryptoKeyBytes, 0, 32);
		this.authenticationCodeBytes = new byte[32];
		System.arraycopy(keyBytes, 32, this.authenticationCodeBytes, 0, 32);
		this.pwVerificationBytes = new byte[2];
		System.arraycopy(keyBytes, 64, this.pwVerificationBytes, 0, 2);
		if (!ByteArrayHelper.isEqual(this.pwVerificationBytes, pwVerification)) {
			throw new ZipException("wrong password - " + ByteArrayHelper.toString(this.pwVerificationBytes) + "/ "
					+ ByteArrayHelper.toString(pwVerification));
		} else {
			generator.init(pwBytes, salt, 1000);
			this.cipherParameters = generator.generateDerivedParameters(256);
			this.mac = new HMac(new SHA1Digest());
			this.mac.init(new KeyParameter(this.authenticationCodeBytes));
			this.aesCipher = new SICBlockCipher(new AESEngine());
			this.blockSize = this.aesCipher.getBlockSize();
			this.nonce = 1;
		}
	}

	public void decrypt(byte[] in, int length) {
		for (int pos = 0; pos < in.length && pos < length; pos += this.blockSize) {
			this.decryptBlock(in, pos, length);
		}

	}

	protected void decryptBlock(byte[] in, int pos, int length) {
		byte[] decryptedIn = new byte[this.blockSize];
		byte[] ivBytes = ByteArrayHelper.toByteArray(this.nonce++, 16);
		ParametersWithIV ivParams = new ParametersWithIV(this.cipherParameters, ivBytes);
		this.aesCipher.init(false, ivParams);
		int remainingCount = length - pos;
		if (remainingCount >= this.blockSize) {
			this.mac.update(in, pos, this.blockSize);
			this.aesCipher.processBlock(in, pos, decryptedIn, 0);
			System.arraycopy(decryptedIn, 0, in, pos, this.blockSize);
		} else {
			this.mac.update(in, pos, remainingCount);
			byte[] extendedIn = new byte[this.blockSize];
			System.arraycopy(in, pos, extendedIn, 0, remainingCount);
			this.aesCipher.processBlock(extendedIn, 0, decryptedIn, 0);
			System.arraycopy(decryptedIn, 0, in, pos, remainingCount);
		}

	}

	public byte[] getFinalAuthentication() {
		byte[] macBytes = new byte[this.mac.getMacSize()];
		this.mac.doFinal(macBytes, 0);
		byte[] macBytes10 = new byte[10];
		System.arraycopy(macBytes, 0, macBytes10, 0, 10);
		return macBytes10;
	}
}