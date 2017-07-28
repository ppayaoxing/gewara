/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.FakeX509TrustManager;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public final class SSLUtilities {
	private static HostnameVerifier _hostnameVerifier;
	private static TrustManager[] _trustManagers;

	public static void trustAllHostnames() {
		if (_hostnameVerifier == null) {
			_hostnameVerifier = new SSLUtilities.FakeHostnameVerifier();
		}

		HttpsURLConnection.setDefaultHostnameVerifier(_hostnameVerifier);
	}

	public static void trustAllHttpsCertificates() {
		if (_trustManagers == null) {
			_trustManagers = new TrustManager[] { new FakeX509TrustManager() };
		}

		SSLContext context;
		try {
			context = SSLContext.getInstance("SSL");
			context.init((KeyManager[]) null, _trustManagers, new SecureRandom());
		} catch (GeneralSecurityException arg1) {
			throw new IllegalStateException(arg1.getMessage());
		}

		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	}

	public static boolean isDeprecatedSSLProtocol() {
		return "com.sun.net.ssl.internal.www.protocol".equals(System.getProperty("java.protocol.handler.pkgs"));
	}

	public static class FakeHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
}