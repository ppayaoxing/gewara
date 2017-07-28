/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.sso.client.cas;

import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

public class AuthenticationFilter {
	private String casServerLoginUrl;
	private boolean renew = false;
	private boolean gateway = false;
	private String artifactParameterName = "ticket";
	private String serviceParameterName = "service";
	private boolean encodeServiceUrl = true;
	private String serverName;
	private String service;
	public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
	private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
	protected final Log log = LogFactory.getLog(this.getClass());
	private boolean ignoreInitConfiguration = false;

	protected void initInternal(FilterConfig filterConfig) throws ServletException {
		if (!this.isIgnoreInitConfiguration()) {
			this.setServerName(this.getPropertyFromInitParams(filterConfig, "serverName", (String) null));
			this.log.trace("Loading serverName property: " + this.serverName);
			this.setService(this.getPropertyFromInitParams(filterConfig, "service", (String) null));
			this.log.trace("Loading service property: " + this.service);
			this.setArtifactParameterName(
					this.getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
			this.log.trace("Loading artifact parameter name property: " + this.artifactParameterName);
			this.setServiceParameterName(
					this.getPropertyFromInitParams(filterConfig, "serviceParameterName", "service"));
			this.log.trace("Loading serviceParameterName property: " + this.serviceParameterName);
			this.setEncodeServiceUrl(
					this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "encodeServiceUrl", "true")));
			this.log.trace("Loading encodeServiceUrl property: " + this.encodeServiceUrl);
			this.setCasServerLoginUrl(this.getPropertyFromInitParams(filterConfig, "casServerLoginUrl", (String) null));
			this.log.trace("Loaded CasServerLoginUrl parameter: " + this.casServerLoginUrl);
			this.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "renew", "false")));
			this.log.trace("Loaded renew parameter: " + this.renew);
			this.setGateway(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "gateway", "false")));
			this.log.trace("Loaded gateway parameter: " + this.gateway);
			String gatewayStorageClass = this.getPropertyFromInitParams(filterConfig, "gatewayStorageClass",
					(String) null);
			if (gatewayStorageClass != null) {
				try {
					this.gatewayStorage = (GatewayResolver) Class.forName(gatewayStorageClass).newInstance();
				} catch (Exception arg3) {
					this.log.error(arg3, arg3);
					throw new ServletException(arg3);
				}
			}

			this.init();
		}

	}

	public void init() {
		CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
		CommonUtils.assertNotNull(this.serviceParameterName, "serviceParameterName cannot be null.");
		CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName) || CommonUtils.isNotEmpty(this.service),
				"serverName or service must be set.");
		CommonUtils.assertNotNull(this.casServerLoginUrl, "casServerLoginUrl cannot be null.");
	}

	public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		String ticket = request.getParameter(this.getArtifactParameterName());
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

			String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl,
					this.getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);
			if (this.log.isDebugEnabled()) {
				this.log.debug("redirecting to \"" + urlToRedirectTo + "\"");
			}

			response.sendRedirect(urlToRedirectTo);
		} else {
			filterChain.doFilter(request, response);
		}
	}

	protected final String constructServiceUrl(HttpServletRequest request, HttpServletResponse response) {
		return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName,
				this.artifactParameterName, this.encodeServiceUrl);
	}

	public final void setRenew(boolean renew) {
		this.renew = renew;
	}

	public final void setGateway(boolean gateway) {
		this.gateway = gateway;
	}

	public final String getArtifactParameterName() {
		return this.artifactParameterName;
	}

	public final String getServiceParameterName() {
		return this.serviceParameterName;
	}

	public final void setCasServerLoginUrl(String casServerLoginUrl) {
		this.casServerLoginUrl = casServerLoginUrl;
	}

	public final void setGatewayStorage(GatewayResolver gatewayStorage) {
		this.gatewayStorage = gatewayStorage;
	}

	protected final boolean isIgnoreInitConfiguration() {
		return this.ignoreInitConfiguration;
	}

	protected final String getPropertyFromInitParams(FilterConfig filterConfig, String propertyName,
			String defaultValue) {
		String value = filterConfig.getInitParameter(propertyName);
		if (CommonUtils.isNotBlank(value)) {
			return value;
		} else {
			String value2 = filterConfig.getServletContext().getInitParameter(propertyName);
			if (CommonUtils.isNotBlank(value2)) {
				return value2;
			} else {
				InitialContext context = null;

				try {
					context = new InitialContext();
				} catch (NamingException arg9) {
					this.log.warn(arg9, arg9);
					return defaultValue;
				}

				String shortName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
				String value3 = this.loadFromContext(context, "java:comp/env/cas/" + shortName + "/" + propertyName);
				if (CommonUtils.isNotBlank(value3)) {
					return value3;
				} else {
					String value4 = this.loadFromContext(context, "java:comp/env/cas/" + propertyName);
					return CommonUtils.isNotBlank(value4) ? value4 : defaultValue;
				}
			}
		}
	}

	protected final String loadFromContext(InitialContext context, String path) {
		try {
			return (String) context.lookup(path);
		} catch (NamingException arg3) {
			this.log.warn("No value found in context for: \'" + path + "\'; Returning null.");
			return null;
		}
	}

	public final void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public final void setService(String service) {
		this.service = service;
	}

	public final void setArtifactParameterName(String artifactParameterName) {
		this.artifactParameterName = artifactParameterName;
	}

	public final void setServiceParameterName(String serviceParameterName) {
		this.serviceParameterName = serviceParameterName;
	}

	public final void setEncodeServiceUrl(boolean encodeServiceUrl) {
		this.encodeServiceUrl = encodeServiceUrl;
	}

	protected final boolean parseBoolean(String value) {
		return value != null && value.equalsIgnoreCase("true");
	}
}