/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import com.gewara.web.util.UrlMatcher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;

public final class SpringUrlMatcher implements UrlMatcher {
	private static final Log logger = LogFactory.getLog(SpringUrlMatcher.class);
	private static final String MATCH_ALL = "/**";
	private final UrlMatcher matcher;
	private final String pattern;

	public SpringUrlMatcher(String pattern) {
		Assert.hasText(pattern, "Pattern cannot be null or empty");
		if (!pattern.equals("/**") && !pattern.equals("**")) {
			pattern = pattern.toLowerCase();
			if (pattern.endsWith("/**") && pattern.indexOf(63) == -1 && pattern.indexOf("*") == pattern.length() - 2) {
				this.matcher = new SpringUrlMatcher.SubpathMatcher(pattern.substring(0, pattern.length() - 3));
			} else {
				this.matcher = new SpringUrlMatcher.SpringAntMatcher(pattern);
			}
		} else {
			pattern = "/**";
			this.matcher = null;
		}

		this.pattern = pattern;
	}

	public boolean matches(String url) {
		if (this.pattern.equals("/**")) {
			if (logger.isDebugEnabled()) {
				logger.debug("Request \'" + url + "\' matched by universal pattern \'/**\'");
			}

			return true;
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Checking match of request : \'" + url + "\'; against \'" + this.pattern + "\'");
			}

			return this.matcher.matches(url);
		}
	}

	public String getPattern() {
		return this.pattern;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof SpringUrlMatcher)) {
			return false;
		} else {
			SpringUrlMatcher other = (SpringUrlMatcher) obj;
			return this.pattern.equals(other.pattern);
		}
	}

	public int hashCode() {
		int code = 31 ^ this.pattern.hashCode();
		return code;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ant [pattern=\'").append(this.pattern).append("\']");
		return sb.toString();
	}

	private static class SubpathMatcher implements UrlMatcher {
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

	private static class SpringAntMatcher implements UrlMatcher {
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