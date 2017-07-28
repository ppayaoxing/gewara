/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;

public class FakeX509TrustManager extends X509ExtendedTrustManager {
	private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[0];

	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return _AcceptedIssuers;
	}

	public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
	}

	public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {
	}
}