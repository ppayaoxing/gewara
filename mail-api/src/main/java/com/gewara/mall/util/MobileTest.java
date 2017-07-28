/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.util;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.mobile.MobileApiRes;
import com.gewara.mall.vo.mobile.MobileInfo;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import java.util.HashMap;

public class MobileTest {
	public static final String APPID = "2440";
	public static final String SECRET = "2703ea38b023468099941a827cb4818a";
	public static final String URL4MOBILE = "http://route.showapi.com/6-1";

	public static ResultCode<MobileApiRes> getQryRes(String num) {
		HashMap map = new HashMap();
		Long curtime = Long.valueOf(System.currentTimeMillis());
		map.put("num", num);
		map.put("showapi_appid", "2440");
		map.put("showapi_timestamp", curtime + "");
		map.put("showapi_sign", "simple_2703ea38b023468099941a827cb4818a");
		HttpResult code = HttpUtils.postUrlAsString("http://route.showapi.com/6-1", map);
		if (!code.isSuccess()) {
			return ResultCode.getFailure(code.getStatus() + "", code.getMsg());
		} else {
			String res = code.getResponse();
			MobileApiRes mres = (MobileApiRes) JsonUtils.readJsonToObject(MobileApiRes.class, res);
			return !mres.getShowapi_res_code().equals(Integer.valueOf(0))
					? ResultCode.getFailure(mres.getShowapi_res_error()) : ResultCode.getSuccessReturn(mres);
		}
	}

	public static void main(String[] args) {
		ResultCode code = getQryRes("1776276");
		if (code.isSuccess()) {
			MobileApiRes showapiresult = (MobileApiRes) code.getRetval();
			MobileInfo info = showapiresult.getShowapi_res_body();
			String cityName = info.getCity();
			String pronCode = info.getProvCode();
			System.out.println("城市:" + cityName);
			System.out.println("省份代码:" + pronCode);
			System.out.println("省份名称:" + info.getProv());
		}

	}
}