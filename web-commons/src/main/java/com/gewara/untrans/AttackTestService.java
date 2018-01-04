package com.gewara.untrans;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gewara.bean.BlackMatcher;

public interface AttackTestService {
	/**
	 * 在本系统中增加黑名单
	 * @param ip
	 * @param disableMin
	 * @return
	 */
	void addRealBlack(String ip, String uri, int disableMin);
	/**
	 * 重置黑名单
	 */
	void resetBlack();
	/**
	 * 重置白名单
	 */
	void resetWhite();
	void setDisabled(boolean disabled);
	boolean checkBlackReq(String ip, String uri);
	public Map<String, BlackMatcher> getBlackMap();
	public boolean isDisabled();
	public List<String> getWhiteList();
	/**
	 * 根据url获取规则脚本，在monitor系统中配置
	 * @param urlKey
	 * @return
	 */
	String getRegScript(String urlKey);
	
	/**
	 * ip segment
	 * @return
	 */
	Map<String, BlackMatcher> getBlackMap2();
	/**
	 * 更新黑名单
	 */
	void refreshBlack();
	/**
	 * 更新白名单
	 * @param ips
	 * @param action
	 */
	void refreshWhite(String ips, String action);
	
}
