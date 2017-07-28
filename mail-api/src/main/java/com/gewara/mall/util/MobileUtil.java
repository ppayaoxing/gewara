/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.util;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.mobile.MobileApiRes;
import com.gewara.mall.vo.mobile.MobileInfo;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MobileUtil {
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

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList mobileList = new ArrayList();
		ArrayList cityList = new ArrayList();
		List zxsList = Arrays.asList(new String[] { "110000", "120000", "500000", "310000" });
		long startSecond = (new Date()).getTime();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("D://mobileInfo/mobile_info.txt")));
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(new FileInputStream("D://mobileInfo/city_info.txt")));

		String result;
		for (result = br.readLine(); result != null; result = br.readLine()) {
			if (!result.trim().equals("")) {
				result = result.trim().substring(0, 7);
				if (!mobileList.contains(result)) {
					mobileList.add(result.trim());
				}
			}
		}

		for (result = br2.readLine(); result != null; result = br2.readLine()) {
			String[] fw = result.trim().split(",");
			cityList.add(fw);
		}

		br.close();
		br2.close();
		System.out.println("取前7位去重后共" + mobileList.size() + "个手机号");
		System.out.println("共" + cityList.size() + "个城市对照表");
		StringBuilder result1 = new StringBuilder();
		Iterator fw1 = mobileList.iterator();

		while (fw1.hasNext()) {
			String endSecond = (String) fw1.next();
			ResultCode code = getQryRes(endSecond);
			if (code.isSuccess()) {
				MobileApiRes showapiresult = (MobileApiRes) code.getRetval();
				MobileInfo info = showapiresult.getShowapi_res_body();
				String cityName = info.getCity();
				String pronCode = info.getProvCode();
				if (zxsList.contains(pronCode)) {
					result1.append(info.getNum()).append("\t").append(info.getProvCode()).append("\t")
							.append(info.getProvCode()).append("\t\n");
				} else {
					Iterator arg15 = cityList.iterator();

					while (arg15.hasNext()) {
						String[] s = (String[]) arg15.next();
						if (cityName != null && !cityName.equals("") && s[0].indexOf(cityName) >= 0) {
							result1.append(info.getNum()).append("\t").append(s[1]).append("\t")
									.append(info.getProvCode()).append("\t\n");
							break;
						}
					}
				}
			}

			Thread.currentThread();
			Thread.sleep(3000L);
		}

		FileWriter fw2 = new FileWriter("D://mobileInfo/mobile_area.txt");
		fw2.write(result1.toString());
		fw2.close();
		System.out.println("运行结束");
		long endSecond1 = (new Date()).getTime();
		System.out.println("用时：" + (endSecond1 - startSecond) / 60000L + "分钟");
	}
}