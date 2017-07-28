/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin;

import com.gewara.support.ErrorCode;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.util.StringUtil;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class WeixinUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(WeixinUtil.class);
	public static final String ANDROIDTV_APPID = "wx92ecb43d47027db2";
	public static final String ANDROIDTV_APPSECRET = "48ac261a1598ba9ee146e47b7803cd1d";
	public static final String GETTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public static final String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
	public static final String ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	public static final String SEND_CUSTMSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
	public static final String CREATE_QCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
	public static final String CARD_CREATE = "https://api.weixin.qq.com/card/create?access_token=";
	public static final String LOCATION_BATCHADD = "https://api.weixin.qq.com/card/location/batchadd?access_token=";
	public static final String UPDATE_MOVIETICKET = "https://api.weixin.qq.com/card/movieticket/updateuser?access_token=";
	public static final String CONSUME_CODE = "https://api.weixin.qq.com/card/code/consume?access_token=";
	public static final String UNAVAILABLE_CODE = "https://api.weixin.qq.com/card/code/unavailable";
	public static final String USERINFO_URL_APP = "https://api.weixin.qq.com/sns/userinfo";
	public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public static final String KEY_ORDER_CARDPASS = "wx_cardpass";
	public static final String KEY_ORDER_CARDID = "wx_cardid";
	public static final String KEY_USE_WEIXIN_CARD = "use_wxcard";
	public static final String KEY_REMOTEIP = "remoteIp";
	public static final String VALUE_USE_WEIXIN_CARD = "Y";
	public static final String CARD_ORANGE = "pwG3Ejg41PtsFHOIDzkQGlUzbr3g";
	public static final String CARD_18 = "pwG3EjvDgeYUhjnByGmydG9XheGw";
	public static final String CARD_ORANGE_TEXT = "³ÈÈ¯¿¨È¯";
	public static final String CARD_18_TEXT = "18Ôª¿¨È¯";
	public static final String CARD_TEST = "pwG3EjoMoAVIeG79lgfeWBTJUvo8";
	public static final String CARD_18_TEST = "pwG3EjjjX_J2d8BA4i6YCCMg8zjw";
	public static final String CARD_BY_PUFA = "pwG3EjnAp_UwANeEdPH5oUJ7Nisk";
	public static final String CARD_BY_ZSY = "pwG3EjpFQOLZNRyY88A6FpN8B8hY";

	public static boolean isValidText(String content) {
		return StringUtil.regMatch(content, "^[\\w-Ò»-ý›]+$", true);
	}

	public static String toHalf(String input) {
		if (StringUtils.isBlank(input))
			return "";
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; ++i) {
			if (c[i] == 12288) {
				c[i] = ' ';
			} else if ((c[i] > 65280) && (c[i] < 65375)) {
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);
	}

	public static String getContent(WeixinMsg msg) {
		String content = msg.getContent();
		if (StringUtils.isBlank(content))
			content = "";
		content = content.trim();
		content = toHalf(content);
		return content;
	}

	public static ErrorCode<String> getAccessTokenResponse(String appid, String appsecret) {
		Map params = new HashMap();
		params.put("grant_type", "client_credential");
		params.put("appid", appid);
		params.put("secret", appsecret);
		HttpResult result = HttpUtils.getUrlAsString("https://api.weixin.qq.com/cgi-bin/token", params);
		if (result.isSuccess()) {
			String response = result.getResponse();
			Map map = JsonUtils.readJsonToMap(response);
			Object obj = map.get("errmsg");
			String errmsg = obj + "";
			if ((StringUtils.isNotBlank(errmsg)) && (!(StringUtils.equalsIgnoreCase(errmsg, "ok")))) {
				return ErrorCode.getFailure("" + map.get("errcode"), errmsg);
			}
			return ErrorCode.getSuccessReturn(response);
		}
		return ErrorCode.getFailure(result.getMsg());
	}

	public static ErrorCode<String> sendCustomerMsg(String token, String touser, String content) {
		Map map = new HashMap();
		map.put("touser", touser);
		map.put("msgtype", "text");
		Map smap = new HashMap();
		smap.put("content", content);
		map.put("text", smap);
		String str = JsonUtils.writeMapToJson(map);
		HttpResult result = HttpUtils
				.postBodyAsString("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + token, str);
		String response = result.getResponse();
		dbLogger.warn(result.getResponse() + "," + result.getMsg());
		if (!(result.isSuccess())) {
			return ErrorCode.getFailure(result.getMsg());
		}
		Map resmap = JsonUtils.readJsonToMap(response);
		String errmsg = (String) resmap.get("errmsg");
		if (!(StringUtils.equalsIgnoreCase(errmsg, "ok"))) {
			return ErrorCode.getFailure(errmsg);
		}
		return ErrorCode.SUCCESS;
	}

	public static ErrorCode<Map> createQCodeTicket(String token, String sceneid, Long exsecond) {
		Map map = new HashMap();
		map.put("expire_seconds", exsecond);
		map.put("action_name", "QR_SCENE");
		Map smap = new HashMap();
		Map ssmap = new HashMap();
		ssmap.put("scene_id", sceneid);
		smap.put("scene", ssmap);
		map.put("action_info", smap);
		String str = JsonUtils.writeMapToJson(map);
		HttpResult result = HttpUtils
				.postBodyAsString("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token, str);
		String response = result.getResponse();
		dbLogger.warn(result.getResponse() + "," + result.getMsg());
		if (!(result.isSuccess())) {
			return ErrorCode.getFailure(result.getMsg());
		}
		Map resmap = JsonUtils.readJsonToMap(response);
		String errmsg = (String) resmap.get("errmsg");
		if (StringUtils.isNotBlank(errmsg)) {
			return ErrorCode.getFailure(errmsg);
		}
		return ErrorCode.getSuccessReturn(resmap);
	}

	public static ErrorCode<String> getPriJsapiTicket(String type, String accessToken) {
		Map params = new HashMap();
		params.put("access_token", accessToken);
		type = (StringUtils.isBlank(type)) ? "jsapi" : type;
		params.put("type", type);
		HttpResult result = HttpUtils.getUrlAsString("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
		String response = result.getResponse();
		if (!(result.isSuccess())) {
			dbLogger.warn(result.getResponse() + "," + result.getMsg());
			return ErrorCode.getFailure(result.getMsg());
		}
		Map map = JsonUtils.readJsonToMap(response);
		Object obj = map.get("errmsg");
		String errmsg = obj + "";
		if ((StringUtils.isNotBlank(errmsg)) && (!(StringUtils.equalsIgnoreCase(errmsg, "ok")))) {
			return ErrorCode.getFailure("" + map.get("errcode"), errmsg);
		}
		return ErrorCode.getSuccessReturn(map.get("ticket") + "");
	}

	public static void main(String[] args) {
	}
}