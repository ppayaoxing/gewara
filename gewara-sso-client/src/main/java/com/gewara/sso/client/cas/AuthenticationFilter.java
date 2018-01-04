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

public class AuthenticationFilter  {

	/**
	 * CAS锟斤拷锟斤拷锟铰糒ogin
	 */
	private String casServerLoginUrl;

	/**
	 * Whether to send the renew request or not.
	 */
	private boolean renew = false;

	/**
	 * Whether to send the gateway request or not.
	 */
	private boolean gateway = false;
	
	
	/** 锟斤拷锟斤拷tk锟斤拷锟斤拷锟斤拷. */
    private String artifactParameterName = "ticket";

    /** 锟斤拷锟襟本碉拷service锟斤拷锟斤拷锟斤拷 */
    private String serviceParameterName = "service";
    
    /** Sets where response.encodeUrl should be called on service urls when constructed. */
    private boolean encodeServiceUrl = true;

    
    /**
     * The name of the server.  Should be in the following format: {protocol}:{hostName}:{port}.
     * Standard ports can be excluded. */
    private String serverName;

    /** The exact url of the service. */
    private String service;
    
    
    /** Represents the constant for where the assertion will be located in memory. */
    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";

	private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();

	protected void initInternal(final FilterConfig filterConfig) throws ServletException {
		if (!isIgnoreInitConfiguration()) {
			
	        setServerName(getPropertyFromInitParams(filterConfig, "serverName", null));
	        log.trace("Loading serverName property: " + this.serverName);
	        setService(getPropertyFromInitParams(filterConfig, "service", null));
	        log.trace("Loading service property: " + this.service);
	        setArtifactParameterName(getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
	        log.trace("Loading artifact parameter name property: " + this.artifactParameterName);
	        setServiceParameterName(getPropertyFromInitParams(filterConfig, "serviceParameterName", "service"));
	        log.trace("Loading serviceParameterName property: " + this.serviceParameterName);
	        setEncodeServiceUrl(parseBoolean(getPropertyFromInitParams(filterConfig, "encodeServiceUrl", "true")));
	        log.trace("Loading encodeServiceUrl property: " + this.encodeServiceUrl);
		    
		    setCasServerLoginUrl(getPropertyFromInitParams(filterConfig, "casServerLoginUrl", null));
			log.trace("Loaded CasServerLoginUrl parameter: " + this.casServerLoginUrl);
			setRenew(parseBoolean(getPropertyFromInitParams(filterConfig, "renew", "false")));
			log.trace("Loaded renew parameter: " + this.renew);
			setGateway(parseBoolean(getPropertyFromInitParams(filterConfig, "gateway", "false")));
			log.trace("Loaded gateway parameter: " + this.gateway);

			final String gatewayStorageClass = getPropertyFromInitParams(filterConfig, "gatewayStorageClass", null);

			if (gatewayStorageClass != null) {
				try {
					this.gatewayStorage = (GatewayResolver) Class.forName(gatewayStorageClass).newInstance();
				} catch (final Exception e) {
					log.error(e, e);
					throw new ServletException(e);
				}
			}
			
			 init();
		}
	}

	/**
	 * 锟斤拷始锟斤拷
	 * 
	 */
	public void init() {
		CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
		CommonUtils.assertNotNull(this.serviceParameterName, "serviceParameterName cannot be null.");
		CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName) || CommonUtils.isNotEmpty(this.service),
				"serverName or service must be set.");
		CommonUtils.assertNotNull(this.casServerLoginUrl, "casServerLoginUrl cannot be null.");
	}

	public final void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
			final FilterChain filterChain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final HttpSession session = request.getSession(false);
		final String ticket = request.getParameter(getArtifactParameterName());
		final String serviceUrl = constructServiceUrl(request, response);
		final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;
		final boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);

		if (CommonUtils.isBlank(ticket) && assertion == null && !wasGatewayed) {
			final String modifiedServiceUrl;

			log.debug("no ticket and no assertion found");
			if (this.gateway) {
				log.debug("setting gateway attribute in session");
				modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
			} else {
				modifiedServiceUrl = serviceUrl;
			}

			if (log.isDebugEnabled()) {
				log.debug("Constructed service url: " + modifiedServiceUrl);
			}

			final String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl,
					getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);

			if (log.isDebugEnabled()) {
				log.debug("redirecting to \"" + urlToRedirectTo + "\"");
			}

			response.sendRedirect(urlToRedirectTo);
			return;
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * 锟斤拷锟斤拷casserver锟斤拷url
	 * @param request
	 * @param response
	 * @return
	 */
    protected final String constructServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
        return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
    }
	
	
	public final void setRenew(final boolean renew) {
		this.renew = renew;
	}

	public final void setGateway(final boolean gateway) {
		this.gateway = gateway;
	}
	
    public final String getArtifactParameterName() {
        return this.artifactParameterName;
    }
    
    public final String getServiceParameterName() {
        return this.serviceParameterName;
    }

	public final void setCasServerLoginUrl(final String casServerLoginUrl) {
		this.casServerLoginUrl = casServerLoginUrl;
	}

	public final void setGatewayStorage(final GatewayResolver gatewayStorage) {
		this.gatewayStorage = gatewayStorage;
	}
	
    /** Instance of commons logging for logging purposes. */
    protected final Log log = LogFactory.getLog(getClass());
    
    

    protected final boolean isIgnoreInitConfiguration() {
        return this.ignoreInitConfiguration;
    }
    
    
    /**
     * Retrieves the property from the FilterConfig.  First it checks the FilterConfig's initParameters to see if it
     * has a value.
     * If it does, it returns that, otherwise it retrieves the ServletContext's initParameters and returns that value if any.
     * <p>
     * Finally, it will check JNDI if all other methods fail.  All the JNDI properties should be stored under java:comp/env/cas/{propertyName}
     *
     * @param filterConfig the Filter Configuration.
     * @param propertyName the property to retrieve.
     * @param defaultValue the default value if the property is not found.
     * @return the property value, following the above conventions.  It will always return the more specific value (i.e.
     *  filter vs. context).
     */
    protected final String getPropertyFromInitParams(final FilterConfig filterConfig, final String propertyName, final String defaultValue)  {
        final String value = filterConfig.getInitParameter(propertyName);

        if (CommonUtils.isNotBlank(value)) {
            return value;
        }

        final String value2 = filterConfig.getServletContext().getInitParameter(propertyName);

        if (CommonUtils.isNotBlank(value2)) {
            return value2;
        }
        InitialContext context = null;
        try {
         context = new InitialContext();
        } catch (final NamingException e) {
        	log.warn(e,e);
        	return defaultValue;
        }
        
        
        final String shortName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1);
        final String value3 = loadFromContext(context, "java:comp/env/cas/" + shortName + "/" + propertyName);
        
        if (CommonUtils.isNotBlank(value3)) {
        	return value3;
        }
        
        final String value4 = loadFromContext(context, "java:comp/env/cas/" + propertyName); 
        
        if (CommonUtils.isNotBlank(value4)) {
        	return value4;
        }

        return defaultValue;
    }
    
    protected final String loadFromContext(final InitialContext context, final String path) {
    	try {
    		return (String) context.lookup(path);
    	} catch (final NamingException e) {
    		log.warn("No value found in context for: '" + path + "'; Returning null.");
    		return null;
    	}
    }
    public final void setServerName(final String serverName) {
        this.serverName = serverName;
    }
    
    
    public final void setService(final String service) {
        this.service = service;
    }

    public final void setArtifactParameterName(final String artifactParameterName) {
        this.artifactParameterName = artifactParameterName;
    }

    public final void setServiceParameterName(final String serviceParameterName) {
        this.serviceParameterName = serviceParameterName;
    }
    
    public final void setEncodeServiceUrl(final boolean encodeServiceUrl) {
    	this.encodeServiceUrl = encodeServiceUrl;
    }
    
    protected final boolean parseBoolean(final String value) {
    	return ((value != null) && "true".equalsIgnoreCase(value));
    }
    
    private boolean ignoreInitConfiguration = false;
}