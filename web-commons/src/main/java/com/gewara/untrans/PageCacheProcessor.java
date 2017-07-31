package com.gewara.untrans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PageCacheProcessor {
	/**
	 * 缓存发送队列
	 * @param params
	 */
	void sendMsgToDst(Map<String, String> params);
	/**
	 * 缓存的页面前缀
	 * @return
	 */
	String getKeyPre();
	/**
	 * 是否有清除缓存的权限
	 * @param request
	 * @return
	 */
	boolean canClear(HttpServletRequest request);
}
