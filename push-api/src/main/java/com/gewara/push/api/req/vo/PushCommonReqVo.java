package com.gewara.push.api.req.vo;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * (请求消息实体)
 * @author chunhui.wang
 */
public class PushCommonReqVo implements Serializable {
	private static final long serialVersionUID = 4572609223488668907L;
	
	protected String remoteIp;//终端IP
	private Map<String, Object> commonMap;//入参集
	
	public PushCommonReqVo(){}
	
	public PushCommonReqVo(String remoteIp,Map<String, Object> commonMap){
		this.remoteIp = remoteIp;
		this.commonMap = commonMap;
	}
	
	public Map<String, Object> getCommonMap() {
		return commonMap;
	}
	public void setCommonMap(Map<String, Object> commonMap) {
		this.commonMap = commonMap;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public void addValue(String key, String value){
		commonMap.put(key, value);
	}
	public Object gainValue(String key){
		return commonMap.get(key);
	}
	public String gainStringValue(String key){
		Object object = gainValue(key);
		if(object==null){
			return "";
		}
		return String.valueOf(object);
	}
	public Long gainLongValue(String key){
		String str = gainStringValue(key);
		if(StringUtils.isBlank(str)){
			return null;
		}
		return Long.valueOf(str);
	}
	public Integer gainIntegerValue(String key){
		String str = gainStringValue(key);
		if(StringUtils.isBlank(str)){
			return null;
		}
		return Integer.valueOf(str);
	}
}
