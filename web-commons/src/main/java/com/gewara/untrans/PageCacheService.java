/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.json.PageView;
import com.gewara.untrans.PageParams;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PageCacheService {
	String NOT_USE_CACHE_KEY = "notUseCache";

	PageView getPageView(String arg0, PageParams arg1, String arg2, String arg3);

	PageView getPageView(HttpServletRequest arg0, String arg1, PageParams arg2, String arg3);

	boolean refreshPageView(String arg0, PageParams arg1, String arg2);

	void updatePageView(String arg0, PageParams arg1, String arg2, String arg3);

	void clearPageView(String arg0, PageParams arg1, String arg2);

	String refreshKeyVersion();

	Map<String, Integer> getCacheMinMap();

	void refreashCacheMin(String arg0, Integer arg1);

	Integer getCacheMin(String arg0);

	boolean isUseCache(HttpServletRequest arg0);

	boolean isUpdated(String arg0, String arg1, Long arg2, PageParams arg3);

	void processPageView(String arg0, Map<String, String> arg1, Map<String, String[]> arg2, String arg3);

	void setEnableCache(boolean arg0);

	void setPageCacheHeader(boolean arg0, HttpServletRequest arg1, HttpServletResponse arg2);
}