package com.gewara.untrans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.gewara.util.DateUtil;

public class PageParams {
	private Map<String, String> params = new TreeMap<String, String>();
	private Map<String/*cookiename*/, String[]/*cookiepath,value*/> reqCookies = new TreeMap<String, String[]>();
	private int hash = 0;
	public Map<String, String[]> getReqCookies() {
		return reqCookies;
	}
	public Map<String, String> getParams(){
		return params;
	}
	public void addCookie(String cookieName, String cookiePath, String value){
		reqCookies.put(cookieName, new String[]{cookiePath, value});
	}
	public void addInteger(String key, Integer value){
		if(value!=null){
			params.put(key, value.toString());
		}
	}
	public void addLong(String key, Long value){
		if(value!=null){
			params.put(key, value.toString());
		}
	}
	public void addDate(String key, Date date){
		if(date!=null){
			params.put(key, DateUtil.formatDate(date));
		}
	}
	public void addTimestamp(String key, Timestamp timestamp){
		if(timestamp!=null){
			params.put(key, DateUtil.formatTimestamp(timestamp));
		}
	}
	public void addNumber(HttpServletRequest req, String paramName){
		String value = req.getParameter(paramName);
		if(StringUtils.isNotBlank(value) && NumberUtils.isNumber(value)){
			params.put(paramName, value);
		}
	}
	public void addNumberStr(String key, String value){
		if(StringUtils.isNotBlank(value) && NumberUtils.isNumber(value)){
			params.put(key, value);
		}
	}
	public void addDateStr(String key, String value) {
		Date date = DateUtil.parseDate(value);
		if(date!=null) {
            params.put(key, value);
        }
	}
	public void addTimestampStr(String key, String value) {
		Date date = DateUtil.parseTimestamp(value);
		if(date!=null) {
            params.put(key, value);
        }
	}
	public void addDate(HttpServletRequest req, String paramName){
		String value = req.getParameter(paramName);
		addDateStr(paramName, value);
	}
	public void addTimestamp(HttpServletRequest req, String paramName){
		String value = req.getParameter(paramName);
		addTimestampStr(paramName, value);
	}
	public void addEnum(HttpServletRequest req, String paramName, List<String> validList){
		String value = req.getParameter(paramName);
		addEnumStr(paramName, value, validList);
	}
	public void addEnumStr(String key, String value, List<String> validList){
		if(StringUtils.isNotBlank(value) && validList.contains(value)){
			params.put(key, value);
		}
	}
	public void addSingleString(String name, String value){
		if(StringUtils.isNotBlank(value)&& StringUtils.isNotBlank(name)){
			params.put(name, value);
		}
	}
	public void addString(HttpServletRequest req, String paramName){
		String value = req.getParameter(paramName);
		if(StringUtils.isNotBlank(value)){
			params.put(paramName, value);
		}
	}
	public int gainParamsHash(){
		if(hash==0){
			String paramHash = ""+getParams();
			if(!reqCookies.isEmpty()){
				paramHash +="cookie";
				for(String key: reqCookies.keySet()){
					paramHash +=key + reqCookies.get(key)[0] + reqCookies.get(key)[1];	
				}
			}
			hash = paramHash.hashCode();
		}
		return hash;
	}
}
