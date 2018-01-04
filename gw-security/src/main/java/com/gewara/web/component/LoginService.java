package com.gewara.web.component;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;

public interface LoginService {
	
	/** 鏍规嵁鐢ㄦ埛鍚嶅瘑鐮佺櫥褰�
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return Map(id,realname)
	 */
	ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password);

	/** 鏍规嵁sessid 鍜� ip鍦板潃鐧诲綍
	 * @param ip
	 * @param sessid
	 * @return
	 */
	GewaraUser getLogonGewaraUserBySessid(String ip, String sessid);

	/**鏍规嵁sessid 鍜� ip鍦板潃鑾峰彇璁よ瘉淇℃伅
	 * @param ip
	 * @param sessid
	 * @return
	 */
	Authentication loadAuthentication(String ip, String sessid);

	/** 鏍规嵁sessid鍒ゆ柇鏄惁鏄痝ewara鐢ㄦ埛鐧诲綍
	 * @param request
	 * @param sessid
	 * @return
	 */
	boolean isGewaraUserLogon(HttpServletRequest request, String sessid);

	/** 鍗曠偣鐧诲綍
	 * @param request
	 * @param response
	 * @param sessid
	 * @return
	 */
	ErrorCode<Map> ssoAutoLogin(HttpServletRequest request, HttpServletResponse response, String sessid);

	/** 閿�姣乻essid
	 * @param sessid
	 */
	void removeInvalidSessid(String sessid);
}
