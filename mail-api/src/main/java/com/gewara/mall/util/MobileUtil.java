package com.gewara.mall.util;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.mobile.MobileApiRes;
import com.gewara.mall.vo.mobile.MobileInfo;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
//手机归属地查询
public class MobileUtil {
	//使用lun.li@gewara.com登陆showapi.com
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
	public static void main(String[] args) throws IOException, InterruptedException {
		List<String> mobileList=new ArrayList<String>();
		List<String[]> cityList=new ArrayList<String[]>();
		List<String> zxsList = Arrays.asList("110000","120000", "500000", "310000");
		long startSecond = new Date().getTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D://mobileInfo/mobile_info.txt")));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("D://mobileInfo/city_info.txt")));
        for (String mobile = br.readLine(); mobile != null; mobile = br.readLine()) {
        	if(!mobile.trim().equals("")){
	        	mobile=mobile.trim().substring(0, 7);
	        	if(!mobileList.contains(mobile)){
	        		mobileList.add(mobile.trim());
	        	}
        	}
        }
        for (String cityInfo = br2.readLine(); cityInfo != null; cityInfo = br2.readLine()) {
        	String[] cityArr=cityInfo.trim().split(",");
        	cityList.add(cityArr);
        }
        br.close();
        br2.close();
        System.out.println("取前7位去重后共"+mobileList.size()+"个手机号");
        System.out.println("共"+cityList.size()+"个城市对照表");
        StringBuilder result=new StringBuilder();
        for(String m:mobileList){
        	ResultCode<MobileApiRes> code= getQryRes(m);
    		if(code.isSuccess()){
    			MobileApiRes showapiresult = code.getRetval();
    			MobileInfo info = showapiresult.getShowapi_res_body();
    			String cityName=info.getCity();
    			String pronCode=info.getProvCode();
    			if(zxsList.contains(pronCode)){
					result.append(info.getNum()).append("\t").append(info.getProvCode()).append("\t").append(info.getProvCode()).append("\t\n");
    			}else{
	    			for(String[] s : cityList){
	    				if(cityName!=null&&!cityName.equals("")&&s[0].indexOf(cityName)>=0){
	    					result.append(info.getNum()).append("\t").append(s[1]).append("\t").append(info.getProvCode()).append("\t\n");
	    					break;
	    				}
	    			}
    			}
    		}
    		Thread.currentThread().sleep(3000);
        }
        FileWriter  fw=new FileWriter("D://mobileInfo/mobile_area.txt");
        fw.write(result.toString());
        fw.close();
        System.out.println("运行结束");
        long endSecond = new Date().getTime();
        System.out.println("用时："+((endSecond-startSecond)/60000)+"分钟");
	}
	
}
