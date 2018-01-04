package com.gewara.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;

public class InnerRequestFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		if(!GewaIpConfig.isGewaInnerIp(remoteIp) && !GewaIpConfig.isLocalIp(remoteIp)) {
			response.sendError(403, "只能内部调用！");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
