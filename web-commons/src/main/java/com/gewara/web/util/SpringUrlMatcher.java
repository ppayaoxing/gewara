package com.gewara.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;

/**
 * Matcher which compares a pre-defined ant-style pattern against the URL (
 * {@code servletPath + pathInfo}) of an {@code HttpServletRequest}. The query
 * string of the URL is ignored and matching is case-insensitive.
 * <p>
 * Using a pattern value of {@code /**} or {@code **} is treated as a universal
 * match, which will match any request. Patterns which end with {@code /**} (and
 * have no other wildcards) are optimized by using a substring match &mdash; a
 * pattern of {@code /aaa/**} will match {@code /aaa}, {@code /aaa/} and any
 * sub-directories, such as {@code /aaa/bbb/ccc}.
 * <p>
 * For all other cases, Spring's {@link AntPathMatcher} is used to perform the
 * match. See the Spring documentation for this class for comprehensive
 * information on the syntax used.
 * 
 * @author Luke Taylor
 * @since 3.1
 * 
 * @see org.springframework.util.AntPathMatcher
 * copy from spring, for match uri
 */
public final class SpringUrlMatcher implements UrlMatcher {
	private static final Log logger = LogFactory.getLog(SpringUrlMatcher.class);
	private static final String MATCH_ALL = "/**";

	private final UrlMatcher matcher;
	private final String pattern;

	/**
	 * Creates a matcher with the specific pattern which will match all HTTP
	 * methods.
	 * 
	 * @param pattern
	 *            the ant pattern to use for matching
	 */
	public SpringUrlMatcher(String pattern) {
		Assert.hasText(pattern, "Pattern cannot be null or empty");

		if (pattern.equals(MATCH_ALL) || pattern.equals("**")) {
			pattern = MATCH_ALL;
			matcher = null;
		} else {
			pattern = pattern.toLowerCase();

			// If the pattern ends with {@code /**} and has no other
			// wildcards, then optimize to a sub-path match
			if (pattern.endsWith(MATCH_ALL) && pattern.indexOf('?') == -1 && pattern.indexOf("*") == pattern.length() - 2) {
				matcher = new SubpathMatcher(pattern.substring(0, pattern.length() - 3));
			} else {
				matcher = new SpringAntMatcher(pattern);
			}
		}

		this.pattern = pattern;
	}

	/**
	 * Returns true if the configured pattern (and HTTP-Method) match those of
	 * the supplied request.
	 * 
	 * @param request
	 *            the request to match against. The ant pattern will be matched
	 *            against the {@code servletPath} + {@code pathInfo} of the
	 *            request.
	 */
	@Override
	public boolean matches(String url) {
		if (pattern.equals(MATCH_ALL)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Request '" + url + "' matched by universal pattern '/**'");
			}

			return true;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Checking match of request : '" + url + "'; against '" + pattern + "'");
		}

		return matcher.matches(url);
	}

	public String getPattern() {
		return pattern;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SpringUrlMatcher)) {
			return false;
		}
		SpringUrlMatcher other = (SpringUrlMatcher) obj;
		return this.pattern.equals(other.pattern);
	}

	@Override
	public int hashCode() {
		int code = 31 ^ pattern.hashCode();
		return code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ant [pattern='").append(pattern).append("']");

		return sb.toString();
	}

	private static class SpringAntMatcher implements UrlMatcher {
		private static final AntPathMatcher antMatcher = new AntPathMatcher();

		private final String pattern;

		private SpringAntMatcher(String pattern) {
			this.pattern = pattern;
		}

		@Override
		public boolean matches(String path) {
			return antMatcher.match(pattern, path);
		}
	}

	/**
	 * Optimized matcher for trailing wildcards
	 */
	private static class SubpathMatcher implements UrlMatcher {
		private final String subpath;
		private final int length;

		private SubpathMatcher(String subpath) {
			assert !subpath.contains("*");
			this.subpath = subpath;
			this.length = subpath.length();
		}

		@Override
		public boolean matches(String path) {
			return path.startsWith(subpath) && (path.length() == length || path.charAt(length) == '/');
		}
	}

}
