/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package de.idyl.winzipaes.impl;

import de.idyl.winzipaes.impl.AESCryptoBase;
import de.idyl.winzipaes.impl.AESEncrypter;
import de.idyl.winzipaes.impl.ByteArrayHelper;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class AESEncrypterBC extends AESCryptoBase implements AESEncrypter {
	private static final Logger LOG = Logger.getLogger(AESEncrypterBC.class.getName());
	protected CipherParameters cipherParameters;
	protected SICBlockCipher aesCipher;
	protected HMac mac;
	private static final Random RANDOM = new SecureRandom();

	public void init(String pwStr, int keySize) throws ZipException {
		byte[] pwBytes = pwStr.getBytes();
		PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
		this.saltBytes = createSalt();
		generator.init(pwBytes, this.saltBytes, 1000);
		this.cipherParameters = generator.generateDerivedParameters(528);
		byte[] keyBytes = ((KeyParameter) this.cipherParameters).getKey();
		this.cryptoKeyBytes = new byte[32];
		System.arraycopy(keyBytes, 0, this.cryptoKeyBytes, 0, 32);
		this.authenticationCodeBytes = new byte[32];
		System.arraycopy(keyBytes, 32, this.authenticationCodeBytes, 0, 32);
		this.pwVerificationBytes = new byte[2];
		System.arraycopy(keyBytes, 64, this.pwVerificationBytes, 0, 2);
		generator.init(pwBytes, this.saltBytes, 1000);
		this.cipherParameters = generator.generateDerivedParameters(256);
		this.mac = new HMac(new SHA1Digest());
		this.mac.init(new KeyParameter(this.authenticationCodeBytes));
		this.aesCipher = new SICBlockCipher(new AESEngine());
		this.blockSize = this.aesCipher.getBlockSize();
		this.nonce = 1;
		if (LOG.isLoggable(Level.FINEST)) {
			LOG.finest("pwBytes   = " + ByteArrayHelper.toString(pwBytes) + " - " + pwBytes.length);
			LOG.finest("salt      = " + ByteArrayHelper.toString(this.saltBytes) + " - " + this.saltBytes.length);
			LOG.finest("pwVerif   = " + ByteArrayHelper.toString(this.pwVerificationBytes) + " - "
					+ this.pwVerificationBytes.length);
		}

	}

	public void encrypt(byte[] in, int length) {
		for (int pos = 0; pos < in.length && pos < length; pos += this.blockSize) {
			this.encryptBlock(in, pos, length);
		}

	}

	protected void encryptBlock(byte[] in, int pos, int length) {
		byte[] encryptedIn = new byte[this.blockSize];
		byte[] ivBytes = ByteArrayHelper.toByteArray(this.nonce++, 16);
		ParametersWithIV ivParams = new ParametersWithIV(this.cipherParameters, ivBytes);
		this.aesCipher.init(true, ivParams);
		int remainingCount = length - pos;
		if (remainingCount >= this.blockSize) {
			this.aesCipher.processBlock(in, pos, encryptedIn, 0);
			System.arraycopy(encryptedIn, 0, in, pos, this.blockSize);
			this.mac.update(encryptedIn, 0, this.blockSize);
		} else {
			byte[] extendedIn = new byte[this.blockSize];
			System.arraycopy(in, pos, extendedIn, 0, remainingCount);
			this.aesCipher.processBlock(extendedIn, 0, encryptedIn, 0);
			System.arraycopy(encryptedIn, 0, in, pos, remainingCount);
			this.mac.update(encryptedIn, 0, remainingCount);
		}

	}

	public byte[] getSalt() {
		return this.saltBytes;
	}

	public byte[] getPwVerification() {
		return this.pwVerificationBytes;
	}

	public byte[] getFinalAuthentication() {
		byte[] macBytes = new byte[this.mac.getMacSize()];
		this.mac.doFinal(macBytes, 0);
		byte[] macBytes10 = new byte[10];
		System.arraycopy(macBytes, 0, macBytes10, 0, 10);
		return macBytes10;
	}

	protected static byte[] createSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}
}