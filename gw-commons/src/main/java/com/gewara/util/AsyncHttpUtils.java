/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpResultCallback;
import com.gewara.util.LoggerUtils;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ByteArrayPart;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.Response;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.multipart.FilePart;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;

public class AsyncHttpUtils {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(AsyncHttpUtils.class);
	public static final int defaultConnectionTimeOutInMs = 15000;
	public static final int defaultRequestTimeoutInMs = 90000;
	public static final int defaultIdleConnectionInPoolTimeoutInMS = 90000;
	public static final int defaultIdleConnectionTimeoutInMs = 90000;
	public static final int defaultMaxTotalConnections = 3000;
	public static final int defaultMaxConnectionPerHost = 300;
	private static AsyncHttpClient asyncHttpClient2;
	private static ConcurrentHashMap<Integer, AsyncHttpClient> clientMap = new ConcurrentHashMap();

	private static AsyncHttpClient getAsyncHttpClient(int reqTimeout) {
		AsyncHttpClient client = (AsyncHttpClient) clientMap.get(Integer.valueOf(reqTimeout));
		if (client == null) {
			Builder cf = new Builder();
			cf.setCompressionEnabled(true);
			cf.setConnectionTimeoutInMs(15000);
			cf.setMaximumConnectionsTotal(3000);
			cf.setMaximumConnectionsPerHost(300);
			cf.setRequestTimeoutInMs(reqTimeout);
			cf.setIdleConnectionInPoolTimeoutInMs(90000);
			cf.setIdleConnectionTimeoutInMs(90000);
			client = new AsyncHttpClient(cf.build());
			clientMap.putIfAbsent(Integer.valueOf(reqTimeout), client);
		}

		return client;
	}

	public static AsyncHttpClient getDefault() {
		if (asyncHttpClient2 == null) {
			asyncHttpClient2 = getAsyncHttpClient(90000);
		}

		return asyncHttpClient2;
	}

	public static void getUrlAsString(String url, Map<String, String> params, HttpResultCallback callback) {
		if (!StringUtils.isBlank(url)) {
			String gurl = getFullUrl(url, params, "utf-8");

			try {
				BoundRequestBuilder e = getDefault().prepareGet(gurl);
				e.setHeader("Accept-Encoding", "gzip,deflate");
				e.execute(new AsyncHttpUtils.AsynchHandler(callback));
			} catch (IOException arg4) {
				dbLogger.error(arg4, 30);
			}

		}
	}

	public static void getUrlAsString(String url, Map<String, String> params, int reqTimeout,
			HttpResultCallback callback) {
		if (!StringUtils.isBlank(url)) {
			String gurl = getFullUrl(url, params, "utf-8");

			try {
				BoundRequestBuilder e = getAsyncHttpClient(reqTimeout).prepareGet(gurl);
				e.setHeader("Accept-Encoding", "gzip,deflate");
				e.execute(new AsyncHttpUtils.AsynchHandler(callback));
			} catch (IOException arg5) {
				dbLogger.error(arg5, 30);
			}

		}
	}

	public static void postUrlAsString(String url, Map<String, String> params, int reqTimeout,
			HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getAsyncHttpClient(reqTimeout).preparePost(url);
			e.setHeader("Accept-Encoding", "gzip,deflate");
			e.setBodyEncoding("utf-8");
			setPostParams(params, e);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg4) {
			dbLogger.error(arg4, 30);
		}

	}

	public static void postUrlAsString(String url, Map<String, String> params, HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getDefault().preparePost(url);
			e.setHeader("Accept-Encoding", "gzip,deflate");
			e.setBodyEncoding("utf-8");
			setPostParams(params, e);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg3) {
			dbLogger.error(arg3, 30);
		}

	}

	public static void postUrlAsString(String url, Map<String, String> params, Map<String, String> headerMap,
			HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getDefault().preparePost(url);
			if (headerMap != null) {
				Iterator arg4 = headerMap.keySet().iterator();

				while (arg4.hasNext()) {
					String key = (String) arg4.next();
					e.setHeader(key, (String) headerMap.get(key));
				}
			}

			e.setHeader("Accept-Encoding", "gzip,deflate");
			e.setBodyEncoding("utf-8");
			setPostParams(params, e);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg6) {
			dbLogger.error(arg6, 30);
		}

	}

	public static void postBodyAsString(String url, String body, HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getDefault().preparePost(url);
			e.setHeader("Accept-Encoding", "gzip,deflate");
			e.setBodyEncoding("utf-8");
			e.setBody(body);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg3) {
			dbLogger.error(arg3, 30);
		}

	}

	public static void uploadFile(String url, Map<String, String> params, byte[] bytes, String inputName,
			String fileName, HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getDefault().preparePost(url);
			setPostParams(params, e);
			ByteArrayPart part = new ByteArrayPart(inputName, fileName, bytes, (String) null, "utf-8");
			e.addBodyPart(part);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg7) {
			dbLogger.error(arg7, 30);
		}

	}

	public static void uploadFile(String url, Map<String, String> params, File file, String inputName, String fileName,
			HttpResultCallback callback) {
		try {
			BoundRequestBuilder e = getDefault().preparePost(url);
			setPostParams(params, e);
			FilePart part = new FilePart(inputName, fileName, file);
			e.addBodyPart(part);
			e.execute(new AsyncHttpUtils.AsynchHandler(callback));
		} catch (IOException arg7) {
			dbLogger.error(arg7, 30);
		}

	}

	private static void setPostParams(Map<String, String> params, BoundRequestBuilder rb) {
		rb.setHeader("Accept-Encoding", "gzip,deflate");
		rb.setBodyEncoding("utf-8");
		if (params != null && !params.isEmpty()) {
			HashMap parameters = new HashMap();
			Iterator arg2 = params.keySet().iterator();

			while (arg2.hasNext()) {
				String key = (String) arg2.next();
				ArrayList cs = new ArrayList(1);
				cs.add(params.get(key));
				parameters.put(key, cs);
			}

			rb.setParameters(parameters);
		}

	}

	private static String getFullUrl(String url, Map<String, String> params, String encode) {
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

	private static void addHeader(HttpResult ret, Response response) {
		try {
			FluentCaseInsensitiveStringsMap headers = response.getHeaders();
			Iterator arg2 = headers.keySet().iterator();

			while (arg2.hasNext()) {
				String key = (String) arg2.next();
				ret.addHeader(key, headers.getJoinedValue(key, ","));
			}
		} catch (Exception arg4) {
			;
		}

	}

	private static class AsynchHandler extends AsyncCompletionHandler<HttpResult> {
		private HttpResultCallback callback;

		public AsynchHandler(HttpResultCallback callback) {
			this.callback = callback;
		}

		public HttpResult onCompleted(Response response) throws Exception {
			boolean success = response.getStatusCode() == 200;
			HttpResult result = new HttpResult(success, response.getResponseBody(),
					"httpStatus:" + response.getStatusCode(), response.getStatusCode());
			AsyncHttpUtils.addHeader(result, response);
			if (this.callback != null) {
				this.callback.processResult(result);
			}

			return result;
		}

		public void onThrowable(Throwable t) {
			this.callback.processError(t);
		}
	}
}