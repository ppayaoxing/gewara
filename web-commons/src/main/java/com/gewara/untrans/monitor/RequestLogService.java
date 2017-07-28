/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.support.ServletRequestHandledEvent;

public interface RequestLogService {
	void logRequest(String arg0, String arg1, Map<String, String> arg2, HttpServletRequest arg3,
			ServletRequestHandledEvent arg4);

	void logRequest(String arg0, String arg1, String arg2, String arg3, String arg4, Map<String, String> arg5,
			String arg6, String arg7, String arg8);

	void addSensitiveWords(String arg0);

	void addIgnoreUriList(List<String> arg0);
}