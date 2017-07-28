/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import com.gewara.api.vo.ResultCode;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.weixin.WeixinUtil;
import com.gewara.weixin.callback.QryCode;
import com.gewara.weixin.callback.WxBack;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class FriendcardUtil {
	public static final String FCCN = "wxfriendcard";
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(WeixinUtil.class);

	private static ResultCode<String> getAccessToken() {
		String url = "http://www.gewara.com/weixin/getAccessToken.xhtml";
		HttpResult result = HttpUtils.getUrlAsString(url);
		if (result.isSuccess()) {
			String response = result.getResponse();
			Map map = JsonUtils.readJsonToMap(response);
			if (!(map.containsKey("access_token"))) {
				return ResultCode.getFailure(((String) map.get("errcode")) + "=" + ((String) map.get("errmsg")));
			}
			return ResultCode.getSuccessReturn((String)map.get("access_token"));
		}
		return ResultCode.getFailure(result.getMsg());
	}

	public static ResultCode<QryCode> qryCode(String code, String card_id) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return ResultCode.getFailure(res.getMsg());
		}
		Map map = new HashMap();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("check_consume", Boolean.valueOf(true));
		String url = "https://api.weixin.qq.com/card/code/get?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		QryCode qryCode = (QryCode) JsonUtils.readJsonToObject(QryCode.class, response);
		if (!(qryCode.getErrcode().equals(Integer.valueOf(0)))) {
			return ResultCode.getFailure(qryCode.getErrcode() + "", qryCode.getErrmsg());
		}
		return ResultCode.getSuccessReturn(qryCode);
	}

	public static ResultCode<QryCode> qryCodeStatus(String code, String card_id) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return ResultCode.getFailure(res.getMsg());
		}
		Map map = new HashMap();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("check_consume", Boolean.valueOf(false));
		String url = "https://api.weixin.qq.com/card/code/get?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		QryCode qryCode = (QryCode) JsonUtils.readJsonToObject(QryCode.class, response);
		if (!(qryCode.getErrcode().equals(Integer.valueOf(0)))) {
			return ResultCode.getFailure(qryCode.getErrcode() + "", qryCode.getErrmsg());
		}
		return ResultCode.getSuccessReturn(qryCode);
	}

	public static ResultCode<String> decryptCode(String encrypt_code) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return ResultCode.getFailure(res.getMsg());
		}
		Map map = new HashMap();
		map.put("encrypt_code", encrypt_code);
		String url = "https://api.weixin.qq.com/card/code/decrypt?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		Map resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if (!(StringUtils.equals(v, "0"))) {
			return ResultCode.getFailure(v, resMap.get("errmsg") + "");
		}
		return ResultCode.getSuccessReturn(resMap.get("code") + "");
	}

	public static ResultCode<String> mark(String code, String open_id, String card_id, boolean ismark) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return res;
		}
		Map map = new HashMap();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("openid", open_id);
		map.put("is_mark", Boolean.valueOf(ismark));
		String url = "https://api.weixin.qq.com/card/code/mark?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		WxBack back = (WxBack) JsonUtils.readJsonToObject(WxBack.class, response);
		if (!(back.getErrcode().equals(Integer.valueOf(0)))) {
			return ResultCode.getFailure(back.getErrcode() + "", back.getErrmsg());
		}
		return ResultCode.getSuccessReturn(code);
	}

	public static ResultCode<String> consume(String code, String open_id) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return res;
		}
		Map map = new HashMap();
		map.put("code", code);
		map.put("openid", open_id);
		String body = JsonUtils.writeObjectToJson(map);
		String url = "https://api.weixin.qq.com/card/code/consume?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		WxBack back = (WxBack) JsonUtils.readJsonToObject(WxBack.class, response);
		if (!(back.getErrcode().equals(Integer.valueOf(0)))) {
			return ResultCode.getFailure(back.getErrcode() + "", back.getErrmsg());
		}
		return ResultCode.getSuccessReturn(code);
	}

	private static CashBaseInfo getBaseInfo(CreateFriendCardCmd cmd) {
		DateInfo dateInfo = new DateInfo(Long.valueOf(cmd.getStarttime().getTime() / 1000L),
				Long.valueOf(cmd.getEndtime().getTime() / 1000L));
		CashBaseInfo baseInfo = new CashBaseInfo(cmd.getTitle(), cmd.getNotice(), cmd.getDescription(), dateInfo,
				cmd.getGet_limit(), cmd.getCenter_title(), cmd.getCenter_sub_title(), cmd.getCenter_url());

		return baseInfo;
	}

	private static CashAdvancedInfo getAdvancedInfo(CreateFriendCardCmd cmd) {
		AdvancedAbstact abstract1 = new AdvancedAbstact(cmd.getAbstractText(), new String[] { cmd.getIcon() });
		UseCondition condition = new UseCondition(cmd.getAccept_category(), cmd.getReject_category());
		Img2Text img2Text = new Img2Text(cmd.getImg(), cmd.getImgText());
		List text_image_list = new ArrayList();
		text_image_list.add(img2Text);
		CashAdvancedInfo advancedInfo = new CashAdvancedInfo(condition, abstract1, text_image_list);
		return advancedInfo;
	}

	public static ResultCode<String> createFriendCard(Integer amount, CreateFriendCardCmd cmd) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return res;
		}
		FriendCash cash = new FriendCash(Integer.valueOf(amount.intValue() * 100), getBaseInfo(cmd),
				getAdvancedInfo(cmd));
		FriendCard card = new FriendCard("CASH", cash);
		String json = JsonUtils.writeObjectToJson(card);
		json = json.replace("abstract1", "abstract");
		String body = "{\"card\":" + json + "}";
		dbLogger.warn(body);
		String url = "https://api.weixin.qq.com/card/create?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		Map resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if (!(StringUtils.equals(v, "0"))) {
			return ResultCode.getFailure(v, resMap.get("errmsg") + "");
		}
		return ResultCode.getSuccessReturn(resMap.get("card_id") + "");
	}

	public static ResultCode<String> updateFriendCard(String cardid, CreateFriendCardCmd cmd) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return res;
		}
		CashBaseInfo baseInfo = getBaseInfo(cmd);
		baseInfo.setBrand_name(null);
		baseInfo.setTitle(null);
		CashAdvancedInfo advInfo = getAdvancedInfo(cmd);
		advInfo.setShare_friends(null);
		advInfo.setUse_condition(null);
		FriendCash cash = new FriendCash(null, baseInfo, advInfo);
		cash.setLeast_cost(null);
		String json = JsonUtils.writeObjectToJson(cash, true);
		json = json.replace("abstract1", "abstract");
		cardid = "\"" + cardid + "\"";
		String body = "{\"card_id\":" + cardid + ",\"cash\":" + json + "}";
		dbLogger.warn(body);
		String url = "https://api.weixin.qq.com/card/update?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		Map resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if (!(StringUtils.equals(v, "0"))) {
			return ResultCode.getFailure(v, resMap.get("errmsg") + "");
		}
		return ResultCode.getSuccessReturn(resMap.get("card_id") + "");
	}

	public static ResultCode<String> delete(String card_id) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return ResultCode.getFailure(res.getMsg());
		}
		Map map = new HashMap();
		map.put("card_id", card_id);
		String url = "https://api.weixin.qq.com/card/delete?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		Map resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if (!(StringUtils.equals(v, "0"))) {
			return ResultCode.getFailure(v, resMap.get("errmsg") + "");
		}
		return ResultCode.getSuccessReturn(resMap.get("code") + "");
	}

	public static ResultCode<String> unavailable(String code) {
		ResultCode res = getAccessToken();
		if (!(res.isSuccess())) {
			return ResultCode.getFailure(res.getMsg());
		}
		Map map = new HashMap();
		map.put("code", code);
		String url = "https://api.weixin.qq.com/card/code/unavailable?access_token=" + ((String) res.getRetval());
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if (!(result.isSuccess())) {
			return ResultCode.getFailure(result.getStatus() + "", result.getMsg());
		}
		String response = result.getResponse();
		Map resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if (!(StringUtils.equals(v, "0"))) {
			return ResultCode.getFailure(v, resMap.get("errmsg") + "");
		}
		return ResultCode.getSuccessReturn(resMap.get("code") + "");
	}
}