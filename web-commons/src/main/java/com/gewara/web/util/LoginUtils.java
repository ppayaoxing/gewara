package com.gewara.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gewara.Config;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.PKCoderUtil;
import com.gewara.util.StringUtil;

public abstract class LoginUtils {
	//public static final String LOG_TYPE_LOGIN = "login";			// ��¼����
	//public static final String LOG_TYPE_LOGOUT = "logout";			// �û��˳�
	//public static final String LOG_TYPE_USERLOGIN = "userlogin";	// ��̨��¼����
	

	public static final String SESS_COOKIE_NAME = Config.SESSION_COOKIE_NAME;
	public static final String COOKIE_NAME_TRACE = "_gwtc_"; 
	public static final String ERROR_PASSORNAME = "passOrName"; 	//�û������������
	public static final String ERROR_USERNAME = "username"; 		//�û���������
	public static final String ERROR_PASSWORD = "password"; 		//�������
	public static final String ERROR_CAPTCHA = "captcha"; 			//��֤�����
	public static final String ERROR_REJECTED = "rejected"; 		//�û���������
	public static final String ERROR_LOGOUT = "logout";				//�˳�
	public static final String ERROR_IPCHANGE = "ipChange";			//ip����
	
	private static String encKey = "skTeis@2";
	public static String getTraceId(String memberid){
		return PKCoderUtil.encryptString(""+memberid, encKey);
	}
	public static String getUserIdByTraceId(String traceId){
		if(StringUtil.isHexDataStr(traceId)){//�Ϸ��Ĳ�ȡֵ
			return PKCoderUtil.decryptString(traceId, encKey);
		}
		return null;
	}
	public static String getUserIdByFullTrace(HttpServletRequest request){
		String track = BaseWebUtils.getCookieValue(request, COOKIE_NAME_TRACE);
		if(StringUtils.isBlank(track)) {
            return null;
        }
		String userId = getUserIdByTraceId(StringUtils.split(track, ".")[0]);
		return userId;
	}
	public static String[] getTracePair(HttpServletRequest request){
		String track = BaseWebUtils.getCookieValue(request, COOKIE_NAME_TRACE);
		if(StringUtils.isBlank(track)) {
            return null;
        }
		String[] tracePair = StringUtils.split(track, "@");
		return tracePair;
	}
	//��¼cacheKey
	public static final String KEY_TIMEOUT_ = "TIMEOUT_";
	
	public static boolean isValidSessid(String ukey){
		if(StringUtils.length(ukey) != 32) {
			return isMemberEncode(ukey);
		}
		String random = ukey.substring(0, 24);
		String mykey = StringUtil.md5(random + "testKeyMemberLogon", 8);
		return mykey.equals(ukey.substring(24));
	}
	private static boolean isMemberEncode(String memberEncode){
		if(StringUtils.isBlank(memberEncode)) {
            return false;
        }
		if(StringUtils.contains(memberEncode, ",")){
			String[] encodes = memberEncode.split(",");
			if(StringUtils.equals(encodes[0], encodes[1])){
				memberEncode = encodes[0];
			}
		}
		String[] pair = memberEncode.split("@");
		if(pair.length > 1){
			return true;
		}
		return false;
	}
	public static void removeLogonUkey(HttpServletResponse response){
		Cookie cookie = new Cookie(SESS_COOKIE_NAME, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	public static String getSessid(HttpServletRequest request){
		String value = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		return value;
	}
	public static String getRepeatKey(String usertype, String username) {
		return usertype + "__" + username;
	}
	public static void setLogonTrace(Long userid, HttpServletRequest request, HttpServletResponse response){
		String traceUkey = BaseWebUtils.getCookieValue(request, LoginUtils.COOKIE_NAME_TRACE);
		setLogonTrace(userid, response, traceUkey);
	}
	private static void setLogonTrace(Long userid, HttpServletResponse response, String traceUkey){
		if(StringUtils.isBlank(traceUkey)){
			traceUkey = LoginUtils.getTraceUkey();
		}else{
			int index = StringUtils.indexOf(traceUkey, '@');
			if(index > 0){
				traceUkey = traceUkey.substring(0, index);
			}
		}
		if(userid!=null){
			traceUkey += "@" + LoginUtils.getTraceId(""+userid);
		}
		Cookie cookie = new Cookie(LoginUtils.COOKIE_NAME_TRACE, traceUkey);
		int duration = 60 * 60 * 24 * 30;//one month
		cookie.setMaxAge(duration);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	public static void setTraceIfNotExists(HttpServletRequest request, HttpServletResponse response){
		String traceUkey = BaseWebUtils.getCookieValue(request, LoginUtils.COOKIE_NAME_TRACE);
		if(StringUtils.isBlank(traceUkey)){
			setLogonTrace(null, response, traceUkey);
		}
	}

	private static String getTraceUkey() {
		String t = System.currentTimeMillis() + "";
		String r = "_" + StringUtil.getRandomString(4);
		String v = StringUtil.md5WithKey(t, 4);
		return t + r + "_" + v;
	}
	public static String getCacheUkey(String sessid) {
		return StringUtil.md5(sessid);
	}

}
