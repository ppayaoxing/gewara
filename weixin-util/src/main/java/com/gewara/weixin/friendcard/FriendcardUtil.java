package com.gewara.weixin.friendcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.ResultCode;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.weixin.WeixinUtil;
import com.gewara.weixin.callback.QryCode;
import com.gewara.weixin.callback.WxBack;

public class FriendcardUtil {
	public static final String FCCN = "wxfriendcard"; //cookie的名称
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(WeixinUtil.class);
	private static ResultCode<String> getAccessToken(){
		String url = "http://www.gewara.com/weixin/getAccessToken.xhtml";
		HttpResult result = HttpUtils.getUrlAsString(url);
		if(result.isSuccess()){
			String response = result.getResponse();
			Map<String, String> map = JsonUtils.readJsonToMap(response);
			if(!map.containsKey("access_token")){
				return ResultCode.getFailure(map.get("errcode")+ "=" +map.get("errmsg"));
			}
			return ResultCode.getSuccessReturn(map.get("access_token"));
		}else {
			return ResultCode.getFailure(result.getMsg());
		}
	}
	//查询码
	public static ResultCode<QryCode> qryCode(String code, String card_id) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return ResultCode.getFailure(res.getMsg());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("check_consume", true);
		String url = "https://api.weixin.qq.com/card/code/get?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		QryCode qryCode = JsonUtils.readJsonToObject(QryCode.class, response);
		if(!qryCode.getErrcode().equals(0)){
			return ResultCode.getFailure(qryCode.getErrcode()+"", qryCode.getErrmsg());
		}
		return ResultCode.getSuccessReturn(qryCode);
	}
	//查询码状态
	public static ResultCode<QryCode> qryCodeStatus(String code, String card_id) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return ResultCode.getFailure(res.getMsg());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("check_consume", false);
		String url = "https://api.weixin.qq.com/card/code/get?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		QryCode qryCode = JsonUtils.readJsonToObject(QryCode.class, response);
		if(!qryCode.getErrcode().equals(0)){
			return ResultCode.getFailure(qryCode.getErrcode()+"", qryCode.getErrmsg());
		}
		return ResultCode.getSuccessReturn(qryCode);
	}
	//解密码
	public static ResultCode<String> decryptCode(String encrypt_code) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return ResultCode.getFailure(res.getMsg());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("encrypt_code", encrypt_code);
		String url = "https://api.weixin.qq.com/card/code/decrypt?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		Map<String, Object> resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if(!StringUtils.equals(v, "0")){
			return ResultCode.getFailure(v, resMap.get("errmsg")+"");
		}
		return ResultCode.getSuccessReturn(resMap.get("code")+"");
	}
	//占用，解除占用
	public static ResultCode<String> mark(String code, String open_id, String card_id, boolean ismark) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return res;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("card_id", card_id);
		map.put("openid", open_id);
		map.put("is_mark", ismark);
		String url = "https://api.weixin.qq.com/card/code/mark?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeObjectToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		WxBack back = JsonUtils.readJsonToObject(WxBack.class, response);
		if(!back.getErrcode().equals(0)){
			return ResultCode.getFailure(back.getErrcode()+"", back.getErrmsg());
		}
		return ResultCode.getSuccessReturn(code);
	}
	//核销
	public static ResultCode<String> consume(String code, String open_id) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return res;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("openid", open_id);
		String body = JsonUtils.writeObjectToJson(map);
		String url = "https://api.weixin.qq.com/card/code/consume?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		WxBack back = JsonUtils.readJsonToObject(WxBack.class, response);
		if(!back.getErrcode().equals(0)){
			return ResultCode.getFailure(back.getErrcode()+"", back.getErrmsg());
		}
		return ResultCode.getSuccessReturn(code);
	}
	private static CashBaseInfo getBaseInfo(CreateFriendCardCmd cmd){
		DateInfo dateInfo = new DateInfo(cmd.getStarttime().getTime()/1000, cmd.getEndtime().getTime()/1000);
		CashBaseInfo baseInfo = new CashBaseInfo(cmd.getTitle(), cmd.getNotice(), cmd.getDescription(), dateInfo, cmd.getGet_limit(), 
				cmd.getCenter_title(), cmd.getCenter_sub_title(), cmd.getCenter_url());
		return baseInfo;
	}
	private static CashAdvancedInfo getAdvancedInfo(CreateFriendCardCmd cmd){
		AdvancedAbstact abstract1 = new AdvancedAbstact(cmd.getAbstractText(), new String[]{cmd.getIcon()});
		UseCondition condition = new UseCondition(cmd.getAccept_category(), cmd.getReject_category());
		Img2Text img2Text = new Img2Text(cmd.getImg(), cmd.getImgText());
		List<Img2Text> text_image_list = new ArrayList<Img2Text>();
		text_image_list.add(img2Text);
		CashAdvancedInfo advancedInfo = new CashAdvancedInfo(condition, abstract1, text_image_list);
		return advancedInfo;
	}
	//create朋友的券
	public static ResultCode<String> createFriendCard(Integer amount, CreateFriendCardCmd cmd) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return res;
		}
		FriendCash cash = new FriendCash(amount*100, getBaseInfo(cmd), getAdvancedInfo(cmd));
		FriendCard card = new FriendCard("CASH", cash);
		String json = JsonUtils.writeObjectToJson(card);
		json = json.replace("abstract1", "abstract");
		String body = "{\"card\":"+json+"}";
		dbLogger.warn(body);
		String url = "https://api.weixin.qq.com/card/create?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		Map<String, Object> resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if(!StringUtils.equals(v, "0")){
			return ResultCode.getFailure(v, resMap.get("errmsg")+"");
		}
		return ResultCode.getSuccessReturn(resMap.get("card_id")+"");
	}
	//update朋友的券
	public static ResultCode<String> updateFriendCard(String cardid, CreateFriendCardCmd cmd) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
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
		cardid = "\""+cardid+"\"";
		String body = "{\"card_id\":"+cardid+",\"cash\":"+json+"}";
		dbLogger.warn(body);
		String url = "https://api.weixin.qq.com/card/update?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, body);
		String response = result.getResponse();
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		Map<String, Object> resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if(!StringUtils.equals(v, "0")){
			return ResultCode.getFailure(v, resMap.get("errmsg")+"");
		}
		return ResultCode.getSuccessReturn(resMap.get("card_id")+"");
	}
	public static ResultCode<String> delete(String card_id) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return ResultCode.getFailure(res.getMsg());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("card_id", card_id);
		String url = "https://api.weixin.qq.com/card/delete?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		Map<String, Object> resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if(!StringUtils.equals(v, "0")){
			return ResultCode.getFailure(v, resMap.get("errmsg")+"");
		}
		return ResultCode.getSuccessReturn(resMap.get("code")+"");
	}
	public static ResultCode<String> unavailable(String code) {
		ResultCode<String> res = getAccessToken();
		if(!res.isSuccess()){
			return ResultCode.getFailure(res.getMsg());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		String url = "https://api.weixin.qq.com/card/code/unavailable?access_token=" + res.getRetval();
		HttpResult result = HttpUtils.postBodyAsString(url, JsonUtils.writeMapToJson(map));
		dbLogger.warn(result.getMsg());
		dbLogger.warn(result.getResponse());
		if(!result.isSuccess()){
			return ResultCode.getFailure(result.getStatus()+"", result.getMsg());
		}
		String response = result.getResponse();
		Map<String, Object> resMap = JsonUtils.readJsonToMap(response);
		String v = resMap.get("errcode").toString();
		if(!StringUtils.equals(v, "0")){
			return ResultCode.getFailure(v, resMap.get("errmsg")+"");
		}
		return ResultCode.getSuccessReturn(resMap.get("code")+"");
	}
}
