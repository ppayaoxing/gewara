/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.FakeX509TrustManager;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpMethod;
import com.gewara.util.HttpOther;
import com.gewara.util.HttpResult;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.util.RequestCallback;
import com.gewara.util.SSLUtilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(HttpUtils.class);
	private static final String DEFAULT_CHARSET = "UTF-8";
	public static final int MAX_TOTAL_CONNECTIONS = 3000;
	public static final int MAX_ROUTE_CONNECTIONS = 800;
	public static final int DEFAULT_TIMEOUT = 60000;
	public static final int SHORT_TIMEOUT = 30000;
	public static final int LONG_TIMEOUT = 120000;
	public static final int CONNECTION_TIMEOUT = 20000;
	public static final int CONNECTION_REQUEST_TIMEOUT = 500;
	public static final int CONNECTION_IDLE_TIMEOUT = 30000;
	public static final int EXCEPTION_HTTP_STATUSCODE = 9999;
	public static final int HTTP_STATUSCODE_HTTP_HOST_CONNECT_EXCEPTION = 9001;
	public static final int HTTP_STATUSCODE_CONNECT_TIMEOUT_EXCEPTION = 9002;
	public static final int HTTP_STATUSCODE_SOCKET_TIMEOUT_EXCEPTION = 9003;
	private static Map<String, AtomicLong> hostCountMap = new ConcurrentHashMap();
	private static ScheduledExecutorService scheduExec = null;
	private static PoolingHttpClientConnectionManager cm;
	private static RequestConfig defaultRequestConfig;
	private static Pattern QUERY_MAP_PATTERN;

	private static SSLConnectionSocketFactory getSSLConnectionSocketFactory() {
		try {
			SSLContext context = SSLContext.getInstance("TLS");
			TrustManager[] e = new TrustManager[] { new FakeX509TrustManager() };
			context.init((KeyManager[]) null, e, new SecureRandom());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(context,
					new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }, (String[]) null,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return sslsf;
		} catch (NoSuchAlgorithmException arg2) {
			throw new IllegalStateException(arg2.getMessage());
		} catch (KeyManagementException arg3) {
			throw new IllegalStateException(arg3.getMessage());
		}
	}

	public static CloseableHttpClient getHttpClient() {
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm)
				.setRedirectStrategy(new HttpUtils.MyDefaultRedirectStrategy())
				.setDefaultRequestConfig(defaultRequestConfig).build();
		return httpclient;
	}

	public static CloseableHttpClient getHttpClient(int connectTimeout, int readTimeout) {
		RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setConnectTimeout(connectTimeout)
				.setSocketTimeout(readTimeout).build();
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm)
				.setRedirectStrategy(new HttpUtils.MyDefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig)
				.build();
		return httpclient;
	}

	private static CloseableHttpClient getHttpClient(int connectTimeout, int readTimeout, CookieStore cookieStore) {
		if (cookieStore == null) {
			return getHttpClient(connectTimeout, readTimeout);
		} else {
			RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setConnectTimeout(connectTimeout)
					.setSocketTimeout(readTimeout).build();
			CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm)
					.setDefaultCookieStore(cookieStore).setRedirectStrategy(new HttpUtils.MyDefaultRedirectStrategy())
					.setDefaultRequestConfig(requestConfig).build();
			return httpclient;
		}
	}

	private static CookieStore getCookieStore(List<BasicClientCookie> cookies) {
		BasicCookieStore cookieStore = new BasicCookieStore();
		if (cookies != null) {
			Iterator arg1 = cookies.iterator();

			while (arg1.hasNext()) {
				BasicClientCookie cookie = (BasicClientCookie) arg1.next();
				cookieStore.addCookie(cookie);
			}
		}

		return cookieStore;
	}

	public static void setMaxConnectionsPerHost(String url, int maxHostConnections) {
		try {
			URI uri = new URI(url);
			HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
			cm.setMaxPerRoute(new HttpRoute(httpHost), maxHostConnections);
		} catch (Exception arg3) {
			;
		}

	}

	public static HttpResult getUrlAsString(String url) {
		HttpGet httpGet = getHttpGet(url, (Map) null, (String) null);
		HttpResult result = executeHttpRequest(httpGet, (Map) null, '?', "UTF-8");
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params) {
		HttpGet httpGet = getHttpGet(url, params, "UTF-8");
		HttpResult result = executeHttpRequest(httpGet, (Map) null, '?', "UTF-8");
		return result;
	}

	public static HttpResult purgeUrlAsString(String url, HttpMethod method, Map<String, String> params,
			Map<String, String> reqHeader) {
		HttpOther httpOther = getHttpOtherMethod(url, method, params, "UTF-8");
		HttpResult result = executeHttpRequest(httpOther, reqHeader, '?', "UTF-8");
		return result;
	}

	public static HttpResult purgeBodyAsString(String url, HttpMethod method, String body) {
		return purgeBodyAsString2(url, method, body, "UTF-8", (Map) null);
	}

	public static HttpResult purgeBodyAsString2(String url, HttpMethod method, String body, String encode,
			Map<String, String> reqHeader) {
		HttpOther httpOther = getHttpOtherMethod2(url, method, body, encode);
		HttpResult result = executeHttpRequest(httpOther, reqHeader, '?', encode);
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params, int timeoutMills) {
		HttpGet httpGet = getHttpGet(url, params, "UTF-8");
		HttpResult result = executeHttpRequest(httpGet, (Map) null, timeoutMills, "UTF-8");
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params, List<BasicClientCookie> cookies) {
		HttpGet httpGet = getHttpGet(url, params, "UTF-8");
		HttpResult result = executeHttpRequestWithCookie(httpGet, (Map) null, '?', "UTF-8", cookies);
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params, String encode) {
		HttpGet httpGet = getHttpGet(url, params, encode);
		HttpResult result = executeHttpRequest(httpGet, (Map) null, '?', encode);
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params, Map<String, String> reqHeader,
			String encode) {
		HttpGet httpGet = getHttpGet(url, params, encode);
		HttpResult result = executeHttpRequest(httpGet, reqHeader, '?', encode);
		return result;
	}

	public static HttpResult getUrlAsString(String url, Map<String, String> params, Map<String, String> reqHeader,
			List<BasicClientCookie> cookies, String encode) {
		HttpGet httpGet = getHttpGet(url, params, encode);
		HttpResult result = executeHttpRequestWithCookie(httpGet, reqHeader, '?', encode, cookies);
		return result;
	}

	public static boolean getUrlAsInputStream(String url, Map<String, String> params, RequestCallback callback) {
		HttpGet httpGet = getHttpGet(url, params, "UTF-8");
		return executeHttpRequest(httpGet, (Map) null, (BasicClientCookie) null, callback, '?');
	}

	public static boolean getUrlAsInputStream(String url, Map<String, String> params, RequestCallback callback,
			String encode) {
		HttpGet httpGet = getHttpGet(url, params, encode);
		return executeHttpRequest(httpGet, (Map) null, (BasicClientCookie) null, callback, '?');
	}

	public static boolean getUrlAsInputStream(String url, Map<String, String> params, RequestCallback callback,
			String encode, int timeoutMills) {
		HttpGet httpGet = getHttpGet(url, params, encode);
		return executeHttpRequest(httpGet, (Map) null, (BasicClientCookie) null, callback, timeoutMills);
	}

	public static HttpResult postUrlAsString(String url, Map<String, String> params) {
		HttpPost httpPost = getHttpPost(url, params, "UTF-8");
		return executeHttpRequest(httpPost, (Map) null, '?', "UTF-8");
	}

	public static HttpResult postUrlAsString(String url, Map<String, String> params, List<BasicClientCookie> cookies) {
		HttpPost httpPost = getHttpPost(url, params, "UTF-8");
		HttpResult result = executeHttpRequestWithCookie(httpPost, (Map) null, '?', "UTF-8", cookies);
		return result;
	}

	public static HttpResult postUrlAsString(String url, Map<String, String> params, int timeoutMills) {
		HttpPost httpPost = getHttpPost(url, params, "UTF-8");
		return executeHttpRequest(httpPost, (Map) null, timeoutMills, "UTF-8");
	}

	public static HttpResult postBodyAsString(String url, String body) {
		return postBodyAsString2(url, body, "UTF-8");
	}

	public static HttpResult postBodyAsString2(String url, String body, String encode) {
		HttpPost httpPost = getHttpPost(url, body, encode);
		return executeHttpRequest(httpPost, (Map) null, '?', encode);
	}

	public static HttpResult postBodyAsString2(String url, String body, String encode, Map<String, String> header) {
		HttpPost httpPost = getHttpPost(url, body, encode);
		return executeHttpRequest(httpPost, header, '?', encode);
	}

	public static HttpResult postBodyAsString2(String url, byte[] body, String mimeType, String charset,
			Map<String, String> header) {
		HttpPost httpPost = getHttpPost(url, body, mimeType, charset);
		return executeHttpRequest(httpPost, header, '?', charset);
	}

	public static HttpResult postBodyAsString(String url, String body, int timeoutMills) {
		return postBodyAsString2(url, body, "UTF-8", timeoutMills);
	}

	public static HttpResult postBodyAsString2(String url, String body, String encode, int timeoutMills) {
		HttpPost httpPost = getHttpPost(url, body, encode);
		return executeHttpRequest(httpPost, (Map) null, timeoutMills, encode);
	}

	public static HttpResult postUrlAsString(String url, Map<String, String> params, Map<String, String> reqHeader,
			String encode) {
		HttpPost httpPost = getHttpPost(url, params, encode);
		return executeHttpRequestWithCookie(httpPost, reqHeader, '?', encode, (List) null);
	}

	public static HttpResult postUrlAsString3(String url, Map<String, String> params, Map<String, String> reqHeader,
			String encode, int timeoutMills) {
		HttpPost httpPost = getHttpPost(url, params, encode);
		return executeHttpRequestWithCookie(httpPost, reqHeader, timeoutMills, encode, (List) null);
	}

	public static boolean postUrlAsInputStream(String url, Map<String, String> params, RequestCallback callback) {
		HttpPost httpPost = getHttpPost(url, params, "UTF-8");
		return executeHttpRequest(httpPost, (Map) null, (BasicClientCookie) null, callback, '?');
	}

	public static HttpResult uploadFile(String url, Map<String, String> params, byte[] bytes, String inputName,
			String fileName) {
		return uploadFile(url, params, bytes, inputName, fileName, "UTF-8");
	}

	public static HttpResult uploadFile(String url, Map<String, String> params, byte[] bytes, String inputName,
			String fileName, String encode) {
		HashMap uploadMap = new HashMap();
		uploadMap.put(inputName, bytes);
		HashMap fileNameMap = new HashMap();
		fileNameMap.put(inputName, fileName);
		return uploadFile(url, params, (Map) uploadMap, (Map) fileNameMap, encode);
	}

	public static HttpResult uploadFile(String url, Map<String, String> params, Map<String, byte[]> uploadMap,
			Map<String, String> fileNameMap) {
		return uploadFile(url, params, uploadMap, fileNameMap, "UTF-8");
	}

	public static HttpResult uploadFile(String url, Map<String, String> params, Map<String, byte[]> uploadMap,
			Map<String, String> fileNameMap, String encode) {
		return uploadFile(url, params, uploadMap, fileNameMap, encode, '?');
	}

	public static HttpResult uploadFile(String url, Map<String, String> params, Map<String, byte[]> uploadMap,
			Map<String, String> fileNameMap, String encode, int timeout) {
		CookieStore cookieStore = getCookieStore((List) null);
		CloseableHttpClient client = getHttpClient(20000, timeout, cookieStore);
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
				.setCharset(Charset.forName(encode));
		HttpPost request = new HttpPost(url);
		Iterator e = uploadMap.keySet().iterator();

		String response;
		while (e.hasNext()) {
			response = (String) e.next();
			ByteArrayBody result = new ByteArrayBody((byte[]) uploadMap.get(response),
					(String) fileNameMap.get(response));
			multipartEntityBuilder.addPart(response, result);
		}

		try {
			if (params != null && !params.isEmpty()) {
				e = params.keySet().iterator();

				while (e.hasNext()) {
					response = (String) e.next();
					multipartEntityBuilder.addTextBody(response, (String) params.get(response),
							ContentType.create("text/plain", Charset.forName(encode)));
				}
			}

			request.setEntity(multipartEntityBuilder.build());
			List arg31 = cookieStore.getCookies();
			CloseableHttpResponse arg32 = client.execute(request);

			try {
				String arg33 = "";
				HttpEntity entity = getEntity(arg32);
				if (entity != null) {
					arg33 = EntityUtils.toString(entity, encode);
				}

				if (isSuccess(arg32)) {
					HttpResult arg34 = HttpResult.getSuccessReturn(arg33);
					addHeader(arg34, arg32);
					List arg35 = cookieStore.getCookies();
					addCookie(arg34, arg35, arg31);
					HttpResult arg36 = arg34;
					return arg36;
				} else {
					int statusCode = arg32.getStatusLine().getStatusCode();
					String msg = "httpStatus:" + statusCode + arg32.getStatusLine().getReasonPhrase() + ", Header: ";
					Header[] headers = arg32.getAllHeaders();
					Header[] arg16 = headers;
					int arg17 = headers.length;

					for (int arg18 = 0; arg18 < arg17; ++arg18) {
						Header header = arg16[arg18];
						msg = msg + header.getName() + ":" + header.getValue();
					}

					request.abort();
					dbLogger.error("ERROR HttpUtils:" + msg + request.getURI());
					HttpResult arg37 = HttpResult.getFailure("httpStatus:" + arg32.getStatusLine().getStatusCode(),
							statusCode, arg33);
					return arg37;
				}
			} finally {
				arg32.close();
			}
		} catch (HttpHostConnectException arg27) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg27, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg27.getClass().getCanonicalName(), 9001);
		} catch (ConnectTimeoutException arg28) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg28, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg28.getClass().getCanonicalName(), 9002);
		} catch (SocketTimeoutException arg29) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg29, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg29.getClass().getCanonicalName(), 9003);
		} catch (Exception arg30) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg30, 100));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg30.getClass().getCanonicalName(), 9999);
		}
	}

	private static void addCookie(HttpResult ret, List<Cookie> cookies, List<Cookie> reqcookie) {
		try {
			Iterator arg2 = cookies.iterator();

			while (arg2.hasNext()) {
				Cookie cookie = (Cookie) arg2.next();
				if (!reqcookie.contains(cookie)) {
					ret.addCookie(cookie.getName(), cookie.getPath(), cookie.getValue(), cookie.getExpiryDate());
				}
			}
		} catch (Exception arg4) {
			;
		}

	}

	private static void addHeader(HttpResult ret, HttpResponse response) {
		try {
			Header[] headers = response.getAllHeaders();
			Header[] arg2 = headers;
			int arg3 = headers.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Header header = arg2[arg4];
				ret.addHeader(header.getName(), header.getValue());
			}
		} catch (Exception arg6) {
			;
		}

	}

	private static HttpPost getHttpPost(String url, Map<String, String> params, String encoding) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept-Encoding", "gzip,deflate");
		if (params != null) {
			ArrayList form = new ArrayList();
			Iterator e = params.keySet().iterator();

			while (e.hasNext()) {
				String name = (String) e.next();
				form.add(new BasicNameValuePair(name, (String) params.get(name)));
			}

			try {
				UrlEncodedFormEntity e1 = new UrlEncodedFormEntity(form, encoding);
				httpPost.setEntity(e1);
			} catch (UnsupportedEncodingException arg6) {
				dbLogger.error("", arg6);
			}
		}

		return httpPost;
	}

	private static HttpOther getHttpOtherMethod(String url, HttpMethod method, Map<String, String> params,
			String encoding) {
		HttpOther httpOther = getHttpOtherMethod(url, method);
		if (params != null) {
			ArrayList form = new ArrayList();
			Iterator e = params.keySet().iterator();

			while (e.hasNext()) {
				String name = (String) e.next();
				form.add(new BasicNameValuePair(name, (String) params.get(name)));
			}

			try {
				UrlEncodedFormEntity e1 = new UrlEncodedFormEntity(form, encoding);
				httpOther.setEntity(e1);
			} catch (UnsupportedEncodingException arg7) {
				dbLogger.error("", arg7);
			}
		}

		return httpOther;
	}

	private static HttpOther getHttpOtherMethod(String url, HttpMethod method) {
		HttpOther httpOther = new HttpOther(method);
		httpOther.setURI(URI.create(url));
		httpOther.setHeader("Accept-Encoding", "gzip,deflate");
		return httpOther;
	}

	private static HttpOther getHttpOtherMethod2(String url, HttpMethod method, String body, String encoding) {
		HttpOther httpOther = getHttpOtherMethod(url, method);
		if (body != null) {
			try {
				StringEntity e = new StringEntity(body, encoding);
				httpOther.setEntity(e);
			} catch (Exception arg5) {
				dbLogger.error("", arg5);
			}
		}

		return httpOther;
	}

	private static HttpPost getHttpPost(String url, String body, String encoding) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept-Encoding", "gzip,deflate");
		if (body != null) {
			try {
				StringEntity e = new StringEntity(body, encoding);
				httpPost.setEntity(e);
			} catch (Exception arg4) {
				dbLogger.error("", arg4);
			}
		}

		return httpPost;
	}

	private static HttpPost getHttpPost(String url, byte[] body, String mimeType, String charset) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept-Encoding", "gzip,deflate");
		if (body != null) {
			try {
				ContentType e = ContentType.create(mimeType, charset);
				ByteArrayEntity entity = new ByteArrayEntity(body, e);
				httpPost.setEntity(entity);
			} catch (Exception arg6) {
				dbLogger.error("", arg6);
			}
		}

		return httpPost;
	}

	private static HttpGet getHttpGet(String url, Map<String, String> params, String encode) {
		String fullUrl = getFullUrl(url, params, encode);
		HttpGet httpGet = new HttpGet(fullUrl);
		httpGet.setHeader("Accept-Encoding", "gzip,deflate");
		return httpGet;
	}

	public static String getFullUrl(String url, Map<String, String> params, String encode) {
		if (params != null) {
			if (url.indexOf(63) == -1) {
				url = url + "?";
			} else {
				url = url + "&";
			}

			Iterator arg2 = params.keySet().iterator();

			while (arg2.hasNext()) {
				String name = (String) arg2.next();

				try {
					if (StringUtils.isNotBlank((String) params.get(name))) {
						url = url + name + "=" + URLEncoder.encode((String) params.get(name), encode) + "&";
					}
				} catch (UnsupportedEncodingException arg5) {
					;
				}
			}

			url = url.substring(0, url.length() - 1);
		}

		return url;
	}

	private static HttpResult executeHttpRequest(HttpUriRequest request, Map<String, String> reqHeader,
			int timeoutMills, String charset) {
		return executeHttpRequestWithCookie(request, reqHeader, timeoutMills, charset, (List) null);
	}

	private static HttpResult executeHttpRequestWithCookie(HttpUriRequest request, Map<String, String> reqHeader,
			int timeoutMills, String charset, List<BasicClientCookie> cookies) {
		hostCount(request);
		CookieStore cookieStore = getCookieStore(cookies);
		CloseableHttpClient client = getHttpClient(20000, timeoutMills, cookieStore);
		if (reqHeader != null) {
			Iterator e = reqHeader.keySet().iterator();

			while (e.hasNext()) {
				String response = (String) e.next();
				request.addHeader(response, (String) reqHeader.get(response));
			}
		}

		try {
			List e1 = cookieStore.getCookies();
			CloseableHttpResponse response1 = client.execute(request);

			HttpResult arg13;
			try {
				HttpEntity entiry = getEntity(response1);
				String result = "";
				if (entiry != null) {
					result = EntityUtils.toString(getEntity(response1), charset);
				}

				if (isSuccess(response1)) {
					HttpResult statusCode1 = HttpResult.getSuccessReturn(result);
					addHeader(statusCode1, response1);
					List ret1 = cookieStore.getCookies();
					addCookie(statusCode1, ret1, e1);
					HttpResult msg1 = statusCode1;
					return msg1;
				}

				int statusCode = response1.getStatusLine().getStatusCode();
				HttpResult ret = HttpResult.getFailure("httpStatus:" + response1.getStatusLine().getStatusCode(),
						statusCode, result);
				addHeader(ret, response1);
				String msg = "httpStatus:" + statusCode + response1.getStatusLine().getReasonPhrase() + ", Header: "
						+ ret.getAllHeaders();
				dbLogger.error("ERROR HttpUtils:" + msg + request.getURI());
				request.abort();
				arg13 = ret;
			} finally {
				response1.close();
			}

			return arg13;
		} catch (HttpHostConnectException arg21) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg21, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg21.getClass().getCanonicalName(), 9001);
		} catch (ConnectTimeoutException arg22) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg22, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg22.getClass().getCanonicalName(), 9002);
		} catch (SocketTimeoutException arg23) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg23, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg23.getClass().getCanonicalName(), 9003);
		} catch (Exception arg24) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg24, 30));
			return HttpResult.getFailure(request.getURI() + " exception:" + arg24.getClass().getCanonicalName(), 9999);
		}
	}

	private static boolean isSuccess(HttpResponse response) {
		return response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() <= 207;
	}

	private static boolean executeHttpRequest(HttpUriRequest request, Map<String, String> reqHeader,
			BasicClientCookie cookie, RequestCallback callback, int timeoutMills) {
		hostCount(request);
		CookieStore cookieStore = getCookieStore(Arrays.asList(new BasicClientCookie[] { cookie }));
		CloseableHttpClient client = getHttpClient(20000, timeoutMills, cookieStore);
		String msg;
		if (reqHeader != null) {
			Iterator e = reqHeader.keySet().iterator();

			while (e.hasNext()) {
				msg = (String) e.next();
				request.addHeader(msg, (String) reqHeader.get(msg));
			}
		}

		try {
			CloseableHttpResponse arg26 = client.execute(request);

			Exception entity;
			try {
				if (!isSuccess(arg26)) {
					msg = "httpStatus:" + arg26.getStatusLine().getStatusCode()
							+ arg26.getStatusLine().getReasonPhrase() + ", Header: ";
					Header[] arg28 = arg26.getAllHeaders();
					Header[] arg29 = arg28;
					int arg10 = arg28.length;

					for (int arg11 = 0; arg11 < arg10; ++arg11) {
						Header header = arg29[arg11];
						msg = msg + header.getName() + ":" + header.getValue();
					}

					HttpEntity arg30 = getEntity(arg26);
					if (arg30 != null) {
						EntityUtils.toString(arg30);
					}

					request.abort();
					dbLogger.error("ERROR HttpUtils:" + msg + request.getURI());
					return false;
				}

				HttpEntity arg27 = getEntity(arg26);
				if (arg27 == null) {
					return false;
				}

				InputStream headers = arg27.getContent();

				try {
					entity = callback.processResult(headers, getAllHeaders(arg26));
				} catch (Exception arg22) {
					entity = arg22;
					dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg22, 30));
					return false;
				} finally {
					if (headers != null) {
						headers.close();
					}

				}
			} finally {
				arg26.close();
			}

			return (boolean) entity;
		} catch (Exception arg25) {
			request.abort();
			dbLogger.error(request.getURI() + ":" + LoggerUtils.getExceptionTrace(arg25, 30));
			return false;
		}
	}

	private static Map<String, String> getAllHeaders(HttpResponse response) {
		Header[] headers = response.getAllHeaders();
		CaseInsensitiveMap headerMap = new CaseInsensitiveMap();
		Header[] arg2 = headers;
		int arg3 = headers.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			Header header = arg2[arg4];
			if (StringUtils.isNotBlank(header.getName()) && StringUtils.isNotBlank(header.getValue())) {
				headerMap.put(header.getName(), header.getValue());
			}
		}

		return headerMap;
	}

	public static Map<String, String> parseQueryStr(String queryString, String encode) {
		LinkedHashMap map = new LinkedHashMap();
		if (StringUtils.isBlank(queryString)) {
			return map;
		} else {
			Matcher matcher = QUERY_MAP_PATTERN.matcher(queryString);
			String key = null;

			String value;
			int end;
			for (end = 0; matcher.find(); end = matcher.end()) {
				if (key != null) {
					try {
						value = queryString.substring(end, matcher.start());
						if (StringUtils.isNotBlank(value)) {
							value = URLDecoder.decode(value, encode);
							map.put(key, value);
						}
					} catch (UnsupportedEncodingException arg8) {
						dbLogger.error(arg8, 30);
					}
				}

				key = matcher.group(1);
			}

			if (key != null) {
				try {
					value = queryString.substring(end);
					if (StringUtils.isNotBlank(value)) {
						value = URLDecoder.decode(value, encode);
						map.put(key, value);
					}
				} catch (UnsupportedEncodingException arg7) {
					dbLogger.error(arg7, 30);
				}
			}

			return map;
		}
	}

	public static Map<String, Long> getStats(boolean clean) {
		HashMap result = new HashMap();
		Iterator arg1 = hostCountMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			long value = ((AtomicLong) entry.getValue()).get();
			if (value > 0L) {
				result.put(entry.getKey(), Long.valueOf(value));
				if (clean) {
					((AtomicLong) entry.getValue()).addAndGet(-value);
				}
			}
		}

		return result;
	}

	private static HttpEntity getEntity(HttpResponse response) {
		Object entity = response.getEntity();
		if (entity == null) {
			return null;
		} else {
			Header header = ((HttpEntity) entity).getContentEncoding();
			if (header != null) {
				HeaderElement[] arg2 = header.getElements();
				int arg3 = arg2.length;

				for (int arg4 = 0; arg4 < arg3; ++arg4) {
					HeaderElement element = arg2[arg4];
					if (element.getName().toLowerCase().indexOf("gzip") != -1) {
						entity = new GzipDecompressingEntity((HttpEntity) entity);
						break;
					}
				}
			}

			return (HttpEntity) entity;
		}
	}

	private static void hostCount(HttpUriRequest request) {
		try {
			if (request == null) {
				return;
			}

			if (request.getURI() == null || StringUtils.isBlank(request.getURI().getHost())) {
				return;
			}

			URI e = request.getURI();
			int port = e.getPort();
			String host = e.getScheme() + "://" + e.getHost() + (port == -1 ? "" : ":" + port) + e.getPath();
			AtomicLong al = (AtomicLong) hostCountMap.get(host);
			if (al == null) {
				al = new AtomicLong(0L);
				hostCountMap.put(host, al);
			}

			al.incrementAndGet();
		} catch (Exception arg4) {
			dbLogger.error(arg4, 30);
		}

	}

	static {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		defaultRequestConfig = RequestConfig.custom().setCookieSpec("best-match").setExpectContinueEnabled(false)
				.setStaleConnectionCheckEnabled(true)
				.setTargetPreferredAuthSchemes(Arrays.asList(new String[] { "NTLM", "Digest" }))
				.setRedirectsEnabled(true).setConnectionRequestTimeout(500).setConnectTimeout(20000)
				.setSocketTimeout(120000).build();
		Registry socketFactoryRegistry = RegistryBuilder.create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", getSSLConnectionSocketFactory()).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(3000);
		cm.setDefaultMaxPerRoute(800);
		scheduExec = Executors.newScheduledThreadPool(3);
		scheduExec.scheduleWithFixedDelay(new HttpUtils.LogHostCountCommand(), 1L, 1200L, TimeUnit.SECONDS);
		scheduExec.scheduleWithFixedDelay(new HttpUtils.IdleConnectionEvictorCommand(), 1L, 300L, TimeUnit.SECONDS);
		QUERY_MAP_PATTERN = Pattern.compile("&?([^=&]+)=");
	}

	private static class IdleConnectionEvictorCommand implements Runnable {
		private IdleConnectionEvictorCommand() {
		}

		public void run() {
			HttpUtils.cm.closeExpiredConnections();
			PoolStats poolStats = HttpUtils.cm.getTotalStats();
			HttpUtils.dbLogger.warn("PoolStats----" + poolStats.toString());
		}
	}

	private static class LogHostCountCommand implements Runnable {
		private LogHostCountCommand() {
		}

		public void run() {
			Map stats = HttpUtils.getStats(true);
			if (!stats.isEmpty()) {
				HttpUtils.dbLogger.warn("HostCount:" + JsonUtils.writeObjectToJson(stats));
			}

		}
	}

	public static class FileRequestCallback implements RequestCallback {
		private File file;

		public FileRequestCallback(File file) {
			this.file = file;
		}

		public boolean processResult(InputStream stream, Map<String, String> headerMap) {
			FileOutputStream os = null;

			try {
				os = new FileOutputStream(this.file);
				IOUtils.copy(stream, os);
				os.close();
				boolean e = true;
				return e;
			} catch (Exception arg13) {
				HttpUtils.dbLogger.error("", arg13);
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (Exception arg12) {
					;
				}

			}

			return false;
		}
	}

	private static class MyDefaultRedirectStrategy extends DefaultRedirectStrategy {
		private MyDefaultRedirectStrategy() {
		}

		public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) {
			boolean isRedirect = false;

			try {
				isRedirect = super.isRedirected(request, response, context);
			} catch (ProtocolException arg5) {
				HttpUtils.dbLogger.error("isRedirected:" + LoggerUtils.getExceptionTrace(arg5, 100));
			}

			if (!isRedirect) {
				int responseCode = response.getStatusLine().getStatusCode();
				if (responseCode == 301 || responseCode == 302) {
					return true;
				}
			}

			return isRedirect;
		}
	}
}