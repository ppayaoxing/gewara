/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.web.support.UriMatcher;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public final class GewaAntPathRequestMatcher implements RequestMatcher {
	private static final Log logger = LogFactory.getLog(GewaAntPathRequestMatcher.class);
	private static final String MATCH_ALL = "/**";
	private final UriMatcher matcher;
	private final String pattern;
	private final HttpMethod httpMethod;
	private final boolean caseSensitive;

	public UriMatcher getMatcher() {
		return this.matcher;
	}

	public GewaAntPathRequestMatcher(String pattern) {
		this(pattern, (String) null);
	}

	public GewaAntPathRequestMatcher(String pattern, String httpMethod) {
		this(pattern, httpMethod, false);
	}

	public GewaAntPathRequestMatcher(String pattern, String httpMethod, boolean caseSensitive) {
		Assert.hasText(pattern, "Pattern cannot be null or empty");
		this.caseSensitive = caseSensitive;
		if (!pattern.equals("/**") && !pattern.equals("**")) {
			if (!caseSensitive) {
				pattern = pattern.toLowerCase();
			}

			if (pattern.endsWith("/**") && pattern.indexOf(63) == -1 && pattern.indexOf("*") == pattern.length() - 2) {
				this.matcher = new GewaAntPathRequestMatcher.SubpathMatcher(pattern.substring(0, pattern.length() - 3));
			} else {
				this.matcher = new GewaAntPathRequestMatcher.SpringAntMatcher(pattern);
			}
		} else {
			pattern = "/**";
			this.matcher = null;
		}

		this.pattern = pattern;
		this.httpMethod = StringUtils.hasText(httpMethod) ? HttpMethod.valueOf(httpMethod) : null;
	}

	public boolean matches(HttpServletRequest request) {
		if (this.httpMethod != null && request.getMethod() != null
				&& this.httpMethod != HttpMethod.valueOf(request.getMethod())) {
			if (logger.isDebugEnabled()) {
				logger.debug("Request \'" + request.getMethod() + " " + this.getRequestPath(request)
						+ "\' doesn\'t match \'" + this.httpMethod + " " + this.pattern);
			}

			return false;
		} else if (this.pattern.equals("/**")) {
			if (logger.isDebugEnabled()) {
				logger.debug("Request \'" + this.getRequestPath(request) + "\' matched by universal pattern \'/**\'");
			}

			return true;
		} else {
			String url = this.getRequestPath(request);
			if (logger.isDebugEnabled()) {
				logger.debug("Checking match of request : \'" + url + "\'; against \'" + this.pattern + "\'");
			}

			return this.matcher.matches(url);
		}
	}

	private String getRequestPath(HttpServletRequest request) {
		String url = request.getServletPath();
		if (request.getPathInfo() != null) {
			url = url + request.getPathInfo();
		}

		if (!this.caseSensitive) {
			url = url.toLowerCase();
		}

		return url;
	}

	public String getPattern() {
		return this.pattern;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof GewaAntPathRequestMatcher)) {
			return false;
		} else {
			GewaAntPathRequestMatcher other = (GewaAntPathRequestMatcher) obj;
			return this.pattern.equals(other.pattern) && this.httpMethod == other.httpMethod
					&& this.caseSensitive == other.caseSensitive;
		}
	}

	public int hashCode() {
		int code = 31 ^ this.pattern.hashCode();
		if (this.httpMethod != null) {
			code ^= this.httpMethod.hashCode();
		}

		return code;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ant [pattern=\'").append(this.pattern).append("\'");
		if (this.httpMethod != null) {
			sb.append(", ").append(this.httpMethod);
		}

		sb.append("]");
		return sb.toString();
	}

	private static class SubpathMatcher implements UriMatcher {
		private final String subpath;
		private final int length;

		private SubpathMatcher(String subpath) {
			assert !subpath.contains("*");

			this.subpath = subpath;
			this.length = subpath.length();
		}

		public boolean matches(String path) {
			return path.startsWith(this.subpath) && (path.length() == this.length || path.charAt(this.length) == 47);
		}
	}

	private static class SpringAntMatcher implements UriMatcher {
		private static final AntPathMatcher antMatcher = new AntPathMatcher();
		private final String pattern;

		private SpringAntMatcher(String pattern) {
			this.pattern = pattern;
		}

		public boolean matches(String path) {
			return antMatcher.match(this.pattern, path);
		}
	}
}