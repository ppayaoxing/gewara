package com.gewara.web.support;

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

import com.gewara.support.ErrorCode;
import com.gewara.support.GewaCaptchaService;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.util.ReqLogUtil;

public class GewaAuthenticationFilter extends UsernamePasswordAuthenticationFilter implements ApplicationContextAware {
	private String logonTypeParamName = "ptn";
	private boolean enableCaptcha = true;
	private AclService aclService;
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		aclService = applicationContext.getBean(AclService.class);
		Assert.notNull(aclService, "�����ṩaclServiceʵ�֣�");
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		if(enableCaptcha){
			boolean validCaptcha = validateCaptcha(request.getParameter("captchaId"), request.getParameter("captcha"), BaseWebUtils.getRemoteIp(request));
			if(!validCaptcha) {
                throw new InvalidCookieException("��֤�벻��ȷ��");
            }
		}
		String ptn = request.getParameter(logonTypeParamName);
		if (StringUtils.isBlank(ptn)) {
            ptn = "member";
        }
		aclService.setLogonType(ptn);
		return super.attemptAuthentication(request, response);
	}
	protected boolean validateCaptcha(String captchaId, String captcha, String ip) {
		if(StringUtils.isNotBlank(captcha)){
			captcha = StringUtils.lowerCase(captcha);
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
			GewaCaptchaService captchaService = ctx.getBean(GewaCaptchaService.class);
			ErrorCode<Map<String, String>> result = captchaService.validateResponseForID(captchaId, captcha, ip);
			if(result.isSuccess()){
				return true;
			}else{
				ReqLogUtil.addLogInfo(result.getRetval());
			}
			
		}
		return false;
	}
	public void setEnableCaptcha(boolean enableCaptcha) {
		this.enableCaptcha = enableCaptcha;
	}
}
