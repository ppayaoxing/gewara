/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface PageCacheProcessor {
	void sendMsgToDst(Map<String, String> arg0);

	String getKeyPre();

	boolean canClear(HttpServletRequest arg0);
}