/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsProcessor;

public class GewaCorsProcessor implements CorsProcessor {
	public boolean processRequest(CorsConfiguration configuration, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return true;
	}
}