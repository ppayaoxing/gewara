package com.gewara.sso.client.cas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.gewara.sso.model.UserSso;
import com.gewara.sso.model.WebModule;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;

public class GewaraSsoClient {
	/**
	 * 从sso获取menu资源
	 * 
	 * @param url
	 * @param serviceName
	 * @return
	 */
	public static List<WebModule> findResoureByName(String url, String serviceName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("serviceName", serviceName);
		params.put("SYSTEMID", "");
		HttpResult result = HttpUtils.getUrlAsString(url, params);
		int i=0;
		while(!result.isSuccess() && i<10){//重试10次
			result = HttpUtils.getUrlAsString(url, params);
			i ++;
		}
		List<WebModule> lst = JsonUtils.readJsonToObjectList(WebModule.class, result.getResponse());
		return lst;
	}
	
	
	public static List<UserSso> findUserList(String url, String serviceName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("serviceName", serviceName);
		params.put("SYSTEMID", "");
		HttpResult result = HttpUtils.getUrlAsString(url, params);
		int i=0;
		while(!result.isSuccess() && i<10){//重试10次
			result = HttpUtils.getUrlAsString(url, params);
			i ++;
		}
		List<UserSso> lst = JsonUtils.readJsonToObjectList(UserSso.class, result.getResponse());
		return lst;
	}

	/**
	 * 登录并返回用户信息
	 * 
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public final Assertion loginValidationSso(final ServletRequest servletRequest, final ServletResponse servletResponse)
			throws IOException, ServletException {
		// 判断是否用户登录过，如果没有登录跳转到sso
		loginSso(servletRequest, servletResponse);
		// 验证登录成功的用户信息，并返回用户信息和权限
		return validationSso(servletRequest, servletResponse);
	}

	public void loginSso(final ServletRequest servletRequest, final ServletResponse servletResponse) throws IOException {

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final HttpSession session = request.getSession(false);
		final String ticket = request.getParameter(artifactParameterName);
		final String serviceUrl = constructServiceUrl(request, response);
		final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;
		final boolean wasGatewayed = gatewayStorage.hasGatewayedAlready(request, serviceUrl);

		if (CommonUtils.isBlank(ticket) && assertion == null && !wasGatewayed) {
			final String modifiedServiceUrl;

			log.debug("no ticket and no assertion found");
			if (gateway) {
				log.debug("setting gateway attribute in session");
				modifiedServiceUrl = gatewayStorage.storeGatewayInformation(request, serviceUrl);
			} else {
				modifiedServiceUrl = serviceUrl;
			}

			if (log.isDebugEnabled()) {
				log.debug("Constructed service url: " + modifiedServiceUrl);
			}

			final String urlToRedirectTo = CommonUtils.constructRedirectUrl(casServerLoginUrl, serviceParameterName,
					modifiedServiceUrl, renew, gateway);

			if (log.isDebugEnabled()) {
				log.debug("redirecting to \"" + urlToRedirectTo + "\"");
			}

			response.sendRedirect(urlToRedirectTo);
		}

	}

	public final Assertion validationSso(final ServletRequest servletRequest, final ServletResponse servletResponse)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String ticket = request.getParameter(artifactParameterName);
		Assertion assertion = null;
		if (CommonUtils.isNotBlank(ticket)) {
			if (log.isDebugEnabled()) {
				log.debug("Attempting to validate ticket: " + ticket);
			}

			try {
				assertion = this.ticketValidator.validate(ticket, constructServiceUrl(request, response));

				if (log.isDebugEnabled()) {
					log.debug("Successfully authenticated user: " + assertion.getPrincipal().getName());
				}

				request.setAttribute(CONST_CAS_ASSERTION, assertion);
				// user = loadUserDetails(assertion);
				if (this.useSession) {
					request.getSession().setAttribute(CONST_CAS_ASSERTION, assertion);
				}

			} catch (final TicketValidationException e) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				log.warn("TicketValidationException", e);

				if (this.exceptionOnValidationFailure) {
					throw new ServletException(e);
				}
			}

			if (this.redirectAfterValidation) {
				log.debug("Redirecting after successful ticket validation.");
				response.sendRedirect(response.encodeRedirectURL(constructServiceUrl(request, response)));
			}
		}
		return assertion;
	}

	
	public final Assertion validationSso(final ServletRequest servletRequest, final ServletResponse servletResponse,String absPath, String basePath)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String ticket = request.getParameter(artifactParameterName);
		Assertion assertion = null;
		if (CommonUtils.isNotBlank(ticket)) {
			if (log.isDebugEnabled()) {
				log.debug("Attempting to validate ticket: " + ticket);
			}

			try {
				//String url = constructServiceUrl(request, response);
				String servletPath=request.getServletPath();
				if(servletPath.length()>1){
					servletPath=servletPath.substring(1);
				}
				String queryStr=request.getQueryString();
				String[] queryList=queryStr.split("&");
				boolean first=true;
				StringBuffer queryString=new StringBuffer();
				for(String query:queryList){
					if(!query.startsWith(artifactParameterName)){
						if(!first){
							queryString.append("&");
						}
						first=false;
						queryString.append(query);
					}
				}
				String url = absPath + basePath + servletPath + "?" + queryString.toString();
				assertion = this.ticketValidator.validate(ticket, url);

				if (log.isDebugEnabled()) {
					log.debug("Successfully authenticated user: " + assertion.getPrincipal().getName());
				}

				request.setAttribute(CONST_CAS_ASSERTION, assertion);
				// user = loadUserDetails(assertion);
				if (this.useSession) {
					request.getSession().setAttribute(CONST_CAS_ASSERTION, assertion);
				}

			} catch (final TicketValidationException e) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				log.warn("TicketValidationException:", e);

				if (this.exceptionOnValidationFailure) {
					throw new ServletException(e);
				}
			}

			if (this.redirectAfterValidation) {
				log.debug("Redirecting after successful ticket validation.");
				response.sendRedirect(response.encodeRedirectURL(constructServiceUrl(request, response)));
			}
		}
		return assertion;
	}
	
	
	/** Instance of commons logging for logging purposes. */
	protected final Log log = LogFactory.getLog(GewaraSsoClient.class);

	/** 返回tk的名称. */
	private String artifactParameterName = "ticket";
	/** 请求本地service的名称 */
	private String serviceParameterName = "service";
	/**
	 * Represents the constant for where the assertion will be located in
	 * memory.
	 */
	public final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
	private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
	/**
	 * Whether to send the renew request or not.
	 */
	private boolean renew = false;
	/**
	 * Sets where response.encodeUrl should be called on service urls when
	 * constructed.
	 */
	private boolean encodeServiceUrl = true;
	/**
	 * Whether to send the gateway request or not.
	 */
	private boolean gateway = false;
	/** The exact url of the service. */
	private String service;

	private boolean useSession = false;
	/**
	 * Determines whether an exception is thrown when there is a ticket
	 * validation failure.
	 */
	private boolean exceptionOnValidationFailure = true;
	/**
	 * Specify whether the filter should redirect the user agent after a
	 * successful validation to remove the ticket parameter from the query
	 * string.
	 */
	private boolean redirectAfterValidation = false;

	/**
	 * CAS服务登录Login
	 */
	private String casServerLoginUrl;
	/**
	 * 本地serverName The name of the server. Should be in the following format:
	 * {protocol}:{hostName}:{port}. Standard ports can be excluded.
	 */
	private String serverName;
	/** The TicketValidator we will use to validate tickets. */
	private TicketValidator ticketValidator;

	public GewaraSsoClient(String casServerLoginUrl, String clientServerName, String casServerUrlPrefix) {
		this.casServerLoginUrl = casServerLoginUrl;
		this.serverName = clientServerName;
		final Cas20ServiceTicketValidator validator = new Cas20ServiceTicketValidator(casServerUrlPrefix);
		validator.setRenew(false);
		validator.setEncoding("GBK");
		ticketValidator = validator;

	}

	// protected GewaraUserDetail loadUserDetails(final Assertion assertion) {
	// final List<GrantedAuthority> grantedAuthorities =
	// loadUserAttributes(assertion);
	// GewaraUserDetail user = new GewaraUserDetail(assertion,
	// NON_EXISTENT_PASSWORD_VALUE, grantedAuthorities);
	// return user;
	// }

	public List<String> loadUserAttributes(final Assertion assertion) {
		final List<String> grantedAuthorities = new ArrayList<String>();
		if (assertion == null) {
			return grantedAuthorities;
		}
		Object value = assertion.getPrincipal().getAttributes().get("attributes");
		if(value==null){
			value = assertion.getPrincipal().getAttributes().get("authorities");
		}
		
		boolean convertToUpperCase = false;

		if (value != null) {
			if (value instanceof List) {
				final List list = (List) value;

				for (final Object o : list) {
					grantedAuthorities.add((convertToUpperCase ? o.toString().toUpperCase() : o.toString()));
				}

			} else {
				if ("".equals(value.toString())) {
					return grantedAuthorities;
				}

				if (value.toString().startsWith("[") && value.toString().endsWith("]")) {
					String valueList = convertToUpperCase ? value.toString().toUpperCase() : value.toString();
					String[] lst = valueList.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
					for (String key : lst) {
						grantedAuthorities.add((key.trim()));
					}
				} else {
					grantedAuthorities.add((convertToUpperCase ? value.toString().toUpperCase() : value.toString()));
				}
			}
		}
		return grantedAuthorities;
	}
	
	
	public static String loadUserAttributes(final Assertion assertion,String attributes) {
		if (assertion == null) {
			return null;
		}
		Object value = assertion.getPrincipal().getAttributes().get(attributes);
		return value==null?null:value.toString();
	}

	/**
	 * 或者casserver的url
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	protected final String constructServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
		return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName,
				this.artifactParameterName, this.encodeServiceUrl);
	}
	
	public static final String getRemoteIp(HttpServletRequest request) {
		String xfwd = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotBlank(xfwd)) {
			String[] ips = xfwd.split(",");
			for (String ip : ips) {
				if (!StringUtils.trim(ip).equals("127.0.0.1") && !StringUtils.trim(ip).equals("localhost"))
					return ip;
			}
		}
		return request.getRemoteAddr();
	}
}
