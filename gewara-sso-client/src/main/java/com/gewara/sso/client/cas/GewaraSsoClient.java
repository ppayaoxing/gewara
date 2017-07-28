/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.sso.client.cas;

import com.gewara.sso.model.UserSso;
import com.gewara.sso.model.WebModule;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

public class GewaraSsoClient {
	protected final Log log = LogFactory.getLog(GewaraSsoClient.class);
	private String artifactParameterName = "ticket";
	private String serviceParameterName = "service";
	public final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
	private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
	private boolean renew = false;
	private boolean encodeServiceUrl = true;
	private boolean gateway = false;
	private String service;
	private boolean useSession = false;
	private boolean exceptionOnValidationFailure = true;
	private boolean redirectAfterValidation = false;
	private String casServerLoginUrl;
	private String serverName;
	private TicketValidator ticketValidator;

	public static List<WebModule> findResoureByName(String url, String serviceName) {
		HashMap params = new HashMap();
		params.put("serviceName", serviceName);
		params.put("SYSTEMID", "");
		HttpResult result = HttpUtils.getUrlAsString(url, params);

		for (int i = 0; !result.isSuccess() && i < 10; ++i) {
			result = HttpUtils.getUrlAsString(url, params);
		}

		List lst = JsonUtils.readJsonToObjectList(WebModule.class, result.getResponse());
		return lst;
	}

	public static List<UserSso> findUserList(String url, String serviceName) {
		HashMap params = new HashMap();
		params.put("serviceName", serviceName);
		params.put("SYSTEMID", "");
		HttpResult result = HttpUtils.getUrlAsString(url, params);

		for (int i = 0; !result.isSuccess() && i < 10; ++i) {
			result = HttpUtils.getUrlAsString(url, params);
		}

		List lst = JsonUtils.readJsonToObjectList(UserSso.class, result.getResponse());
		return lst;
	}

	public final Assertion loginValidationSso(ServletRequest servletRequest, ServletResponse servletResponse)
			throws IOException, ServletException {
		this.loginSso(servletRequest, servletResponse);
		return this.validationSso(servletRequest, servletResponse);
	}

	public void loginSso(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		String ticket = request.getParameter(this.artifactParameterName);
		String serviceUrl = this.constructServiceUrl(request, response);
		Assertion assertion = session != null ? (Assertion) session.getAttribute("_const_cas_assertion_") : null;
		boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
		if (CommonUtils.isBlank(ticket) && assertion == null && !wasGatewayed) {
			this.log.debug("no ticket and no assertion found");
			String modifiedServiceUrl;
			if (this.gateway) {
				this.log.debug("setting gateway attribute in session");
				modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
			} else {
				modifiedServiceUrl = serviceUrl;
			}

			if (this.log.isDebugEnabled()) {
				this.log.debug("Constructed service url: " + modifiedServiceUrl);
			}

			String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, this.serviceParameterName,
					modifiedServiceUrl, this.renew, this.gateway);
			if (this.log.isDebugEnabled()) {
				this.log.debug("redirecting to \"" + urlToRedirectTo + "\"");
			}

			response.sendRedirect(urlToRedirectTo);
		}

	}

	public final Assertion validationSso(ServletRequest servletRequest, ServletResponse servletResponse)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String ticket = request.getParameter(this.artifactParameterName);
		Assertion assertion = null;
		if (CommonUtils.isNotBlank(ticket)) {
			if (this.log.isDebugEnabled()) {
				this.log.debug("Attempting to validate ticket: " + ticket);
			}

			try {
				assertion = this.ticketValidator.validate(ticket, this.constructServiceUrl(request, response));
				if (this.log.isDebugEnabled()) {
					this.log.debug("Successfully authenticated user: " + assertion.getPrincipal().getName());
				}

				request.setAttribute("_const_cas_assertion_", assertion);
				if (this.useSession) {
					request.getSession().setAttribute("_const_cas_assertion_", assertion);
				}
			} catch (TicketValidationException arg7) {
				response.setStatus(403);
				this.log.warn("TicketValidationException", arg7);
				if (this.exceptionOnValidationFailure) {
					throw new ServletException(arg7);
				}
			}

			if (this.redirectAfterValidation) {
				this.log.debug("Redirecting after successful ticket validation.");
				response.sendRedirect(response.encodeRedirectURL(this.constructServiceUrl(request, response)));
			}
		}

		return assertion;
	}

	public final Assertion validationSso(ServletRequest servletRequest, ServletResponse servletResponse, String absPath,
			String basePath) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String ticket = request.getParameter(this.artifactParameterName);
		Assertion assertion = null;
		if (CommonUtils.isNotBlank(ticket)) {
			if (this.log.isDebugEnabled()) {
				this.log.debug("Attempting to validate ticket: " + ticket);
			}

			try {
				String e = request.getServletPath();
				if (e.length() > 1) {
					e = e.substring(1);
				}

				String queryStr = request.getQueryString();
				String[] queryList = queryStr.split("&");
				boolean first = true;
				StringBuffer queryString = new StringBuffer();
				String[] url = queryList;
				int arg14 = queryList.length;

				for (int arg15 = 0; arg15 < arg14; ++arg15) {
					String query = url[arg15];
					if (!query.startsWith(this.artifactParameterName)) {
						if (!first) {
							queryString.append("&");
						}

						first = false;
						queryString.append(query);
					}
				}

				String arg18 = absPath + basePath + e + "?" + queryString.toString();
				assertion = this.ticketValidator.validate(ticket, arg18);
				if (this.log.isDebugEnabled()) {
					this.log.debug("Successfully authenticated user: " + assertion.getPrincipal().getName());
				}

				request.setAttribute("_const_cas_assertion_", assertion);
				if (this.useSession) {
					request.getSession().setAttribute("_const_cas_assertion_", assertion);
				}
			} catch (TicketValidationException arg17) {
				response.setStatus(403);
				this.log.warn("TicketValidationException:", arg17);
				if (this.exceptionOnValidationFailure) {
					throw new ServletException(arg17);
				}
			}

			if (this.redirectAfterValidation) {
				this.log.debug("Redirecting after successful ticket validation.");
				response.sendRedirect(response.encodeRedirectURL(this.constructServiceUrl(request, response)));
			}
		}

		return assertion;
	}

	public GewaraSsoClient(String casServerLoginUrl, String clientServerName, String casServerUrlPrefix) {
		this.casServerLoginUrl = casServerLoginUrl;
		this.serverName = clientServerName;
		Cas20ServiceTicketValidator validator = new Cas20ServiceTicketValidator(casServerUrlPrefix);
		validator.setRenew(false);
		validator.setEncoding("GBK");
		this.ticketValidator = validator;
	}

	public List<String> loadUserAttributes(Assertion assertion) {
		ArrayList grantedAuthorities = new ArrayList();
		if (assertion == null) {
			return grantedAuthorities;
		} else {
			Object value = assertion.getPrincipal().getAttributes().get("attributes");
			if (value == null) {
				value = assertion.getPrincipal().getAttributes().get("authorities");
			}

			boolean convertToUpperCase = false;
			if (value != null) {
				if (value instanceof List) {
					List valueList = (List) value;
					Iterator lst = valueList.iterator();

					while (lst.hasNext()) {
						Object o = lst.next();
						grantedAuthorities.add(convertToUpperCase ? o.toString().toUpperCase() : o.toString());
					}
				} else {
					if ("".equals(value.toString())) {
						return grantedAuthorities;
					}

					if (value.toString().startsWith("[") && value.toString().endsWith("]")) {
						String arg10 = convertToUpperCase ? value.toString().toUpperCase() : value.toString();
						String[] arg11 = arg10.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
						String[] arg12 = arg11;
						int arg7 = arg11.length;

						for (int arg8 = 0; arg8 < arg7; ++arg8) {
							String key = arg12[arg8];
							grantedAuthorities.add(key.trim());
						}
					} else {
						grantedAuthorities.add(convertToUpperCase ? value.toString().toUpperCase() : value.toString());
					}
				}
			}

			return grantedAuthorities;
		}
	}

	public static String loadUserAttributes(Assertion assertion, String attributes) {
		if (assertion == null) {
			return null;
		} else {
			Object value = assertion.getPrincipal().getAttributes().get(attributes);
			return value == null ? null : value.toString();
		}
	}

	protected final String constructServiceUrl(HttpServletRequest request, HttpServletResponse response) {
		return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName,
				this.artifactParameterName, this.encodeServiceUrl);
	}

	public static final String getRemoteIp(HttpServletRequest request) {
		String xfwd = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotBlank(xfwd)) {
			String[] ips = xfwd.split(",");
			String[] arg2 = ips;
			int arg3 = ips.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				String ip = arg2[arg4];
				if (!StringUtils.trim(ip).equals("127.0.0.1") && !StringUtils.trim(ip).equals("localhost")) {
					return ip;
				}
			}
		}

		return request.getRemoteAddr();
	}
}