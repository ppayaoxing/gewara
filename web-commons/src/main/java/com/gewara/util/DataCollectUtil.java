package com.gewara.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * 鏁版嵁閲囬泦涓撶敤
 */
public abstract class DataCollectUtil {
	protected final static transient GewaLogger dbLogger = WebLogger.getLogger(DataCollectUtil.class);
	private static final String LD_REG_KEY = "_LD_REG_KEY";
	/**
	 * 璺熻釜鐗逛环娲诲姩娉ㄥ唽鎯呭喌銆�
	 * cookie鍊间负鍓嶅悗涓ら儴鍒唘rl缁勬垚锛� 鍓嶄负鏈�鏂帮紝鍚庝笂涓�涓壒浠锋椿鍔ㄩ〉闈�
	 * @param url
	 * @param request
	 * @param response
	 */
	public static void addLeiDaCookie(String url, HttpServletRequest request, HttpServletResponse response){
		String oldValue = BaseWebUtils.getCookieValue(request, LD_REG_KEY);
		String[]  split = null;
		if (StringUtils.isNotBlank(oldValue)){
			try {
				oldValue = new String(Base64.decodeBase64(oldValue), "UTF-8");
				split = oldValue.split("@");
				split[1] = split[0];
				split[0] = url;
			} catch (Exception e) {
				dbLogger.error(url + ":" + oldValue, e);
			}
		}else {
			split = new String[]{url, url};
		}
		String newCookie = StringUtils.join(split, "@");
		try {
			newCookie = Base64.encodeBase64URLSafeString(newCookie.getBytes("UTF-8"));
		} catch (Exception e) {
			dbLogger.error(""+ newCookie, e);
		}
		BaseWebUtils.addCookie(response, LD_REG_KEY, newCookie, "/", 30 * 1000);
	}
	public static String getLeiDaCookie(HttpServletRequest request){
		String value = BaseWebUtils.getCookieValue(request, LD_REG_KEY);
		if (StringUtils.isNotBlank(value)){
			try {
				value = new String(Base64.decodeBase64(value), "UTF-8");
				if (StringUtils.contains(value, "@")) {
                    return value;
                }
			} catch (Exception e) {
				dbLogger.error("" + value, e);
			}
		}
		return "";
	}
}
