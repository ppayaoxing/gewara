/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.filter;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InnerRequestFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		if (!GewaIpConfig.isGewaInnerIp(remoteIp) && !GewaIpConfig.isLocalIp(remoteIp)) {
			response.sendError(403, "只能内部调用！");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}