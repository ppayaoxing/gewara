package com.gewara.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class QueryStrBuilder {
	private String encode = "utf-8";
	private String queryStr = "";
	public void buildQueryStr(Map<String, String[]> params, String[] paramNames){
		//1����ȡ��ѯ��
		List<String> keyList = new ArrayList<String>();
		if(params != null){
			if(paramNames==null) {
                keyList.addAll(params.keySet());
            } else {
                keyList.addAll(Arrays.asList(paramNames));
            }
			Collections.sort(keyList);
			for(String key: keyList){
				Object values = params.get(key);
				if(values==null) {
                    continue;
                }
				if(values instanceof String[]){//��ֵ
					for(String value:(String[])values){
						if(StringUtils.isNotBlank(value)){
							try {
								queryStr += "&" + key + "=" + URLEncoder.encode(value,encode);
							} catch (UnsupportedEncodingException e) {
							}
						}
					}
				}else{//��ֵ
					try {
						queryStr += "&" + key + "=" + URLEncoder.encode(""+values,encode);
					} catch (UnsupportedEncodingException e) {
					}
				}
			}
		}
	}
	public void buildQueryStr(Map<String, String[]> params){
		buildQueryStr(params, null);
	}
	public String getQueryStr(String fieldname, Object fieldvalue){
		String value = "";
		try {
			if(fieldvalue != null) {
                value = URLEncoder.encode(fieldvalue.toString(), encode);
            }
		} catch (UnsupportedEncodingException e) {
		}
		String result = this.queryStr;
		int idx1 = StringUtils.indexOf(result, "&"+fieldname+"=");
		if(idx1 >= 0){//�滻��ֵ
			int idx2 = StringUtils.indexOf(result, '&', idx1 + 1);
			if(idx2 == -1) {
                idx2 = result.length();
            }
			result = result.substring(0, idx1 + 1) + fieldname + "=" + value + result.substring(idx2);
		}else{
			if(StringUtils.isNotBlank(value)) {
                result += "&" + fieldname + "=" + value;
            }
		}
		return result.substring(1);
	}
}
