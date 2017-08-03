package com.gewara.mall.util;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.mobile.MobileApiRes;
import com.gewara.mall.vo.mobile.MobileInfo;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;

public class MobileTest {
	public static final String APPID = "2440";
	public static final String SECRET = "2703ea38b023468099941a827cb4818a";
	public static final String URL4MOBILE = "http://route.showapi.com/6-1";
	
	public static ResultCode<MobileApiRes> getQryRes(String num){
		
		Map<String, String> map = new HashMap<String, String>();
		Long curtime = System.currentTimeMillis();
		map.put("num", num);
		map.put("showapi_appid", APPID);
		map.put("showapi_timestamp",curtime+"");
		map.put("showapi_sign","simple_" + SECRET);
		HttpResult code = HttpUtils.postUrlAsString(URL4MOBILE, map);
		if(!code.isSuccess()){
			return ResultCode.getFailure(code.getStatus()+"", code.getMsg());
		}
		String res = code.getResponse();
		MobileApiRes mres = JsonUtils.readJsonToObject(MobileApiRes.class, res);
		if(!mres.getShowapi_res_code().equals(0)){
			return ResultCode.getFailure(mres.getShowapi_res_error());
		}
		return ResultCode.getSuccessReturn(mres);
	}
	public static void main(String[] args) {
		ResultCode<MobileApiRes> code= getQryRes("1776276");
		if(code.isSuccess()){
			MobileApiRes showapiresult = code.getRetval();
			MobileInfo info = showapiresult.getShowapi_res_body();
			String cityName=info.getCity();
			String pronCode=info.getProvCode();
			System.out.println("城市:"+cityName);
			System.out.println("省份代码:"+pronCode);
			System.out.println("省份名称:"+info.getProv());
		}	
	}

}
