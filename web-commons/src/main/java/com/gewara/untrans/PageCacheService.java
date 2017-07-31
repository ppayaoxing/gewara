package com.gewara.untrans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gewara.json.PageView;

public interface PageCacheService {
	String NOT_USE_CACHE_KEY = "notUseCache";
	/**
	 * 获取页面缓存
	 * @param request
	 * @param pageUrl 页面地址
	 * @param params
	 * @param citycode
	 * @param cacheMin 缓存分钟
	 * @return
	 */
	PageView getPageView(String pageUrl, PageParams params, String citycode, String ip);
	PageView getPageView(HttpServletRequest request, String pageUrl, PageParams params, String citycode);
	boolean refreshPageView(String pageUrl, PageParams params, String citycode);
	void updatePageView(String pageUrl, PageParams params, String citycode, String content);
	void clearPageView(String pageUrl, PageParams params, String citycode);
	String refreshKeyVersion();
	Map<String, Integer> getCacheMinMap();
	void refreashCacheMin(String pageUrl, Integer minute);
	Integer getCacheMin(String pageUrl);
	boolean isUseCache(HttpServletRequest request);
	/**
	 * 判断是否是最新缓存
	 * @param pageParams
	 * @return
	 */
	boolean isUpdated(String pageUrl, String citycode, Long cur, PageParams pageParams);
	/**
	 * 处理更新缓存
	 * @param pageUrl
	 * @param params
	 * @param citycode
	 */
	void processPageView(String pageUrl, Map<String, String> params, Map<String, String[]> cookieMap, String citycode);
	void setEnableCache(boolean enableCache);
	
	/**
	 * 设置页面缓存头：如果outerAllow && isUseCache(request) 则设置缓存相关头
	 * @param allow
	 * @param request
	 * @param response
	 */
	void setPageCacheHeader(boolean outerAllow, HttpServletRequest request, HttpServletResponse response);
}
