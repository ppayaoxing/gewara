/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.support.ErrorCode;
import com.gewara.support.GewaCaptchaService;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.support.AclService;
import com.gewara.web.util.ReqLogUtil;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class GewaAuthenticationFilter extends UsernamePasswordAuthenticationFilter implements ApplicationContextAware {
	private String logonTypeParamName = "ptn";
	private boolean enableCaptcha = true;
	private AclService aclService;
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		this.aclService = (AclService) this.applicationContext.getBean(AclService.class);
		Assert.notNull(this.aclService, "必须提供aclService实现！");
	}

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (this.enableCaptcha) {
			boolean ptn = this.validateCaptcha(request.getParameter("captchaId"), request.getParameter("captcha"),
					BaseWebUtils.getRemoteIp(request));
			if (!ptn) {
				throw new InvalidCookieException("验证码不正确！");
			}
		}

		String ptn1 = request.getParameter(this.logonTypeParamName);
		if (StringUtils.isBlank(ptn1)) {
			ptn1 = "member";
		}

		this.aclService.setLogonType(ptn1);
		return super.attemptAuthentication(request, response);
	}

	protected boolean validateCaptcha(String captchaId, String captcha, String ip) {
		if (StringUtils.isNotBlank(captcha)) {
			captcha = StringUtils.lowerCase(captcha);
			WebApplicationContext ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(this.getServletContext());
			GewaCaptchaService captchaService = (GewaCaptchaService) ctx.getBean(GewaCaptchaService.class);
			ErrorCode result = captchaService.validateResponseForID(captchaId, captcha, ip);
			if (result.isSuccess()) {
				return true;
			}

			ReqLogUtil.addLogInfo((Map) result.getRetval());
		}

		return false;
	}

	public void setEnableCaptcha(boolean enableCaptcha) {
		this.enableCaptcha = enableCaptcha;
	}
}