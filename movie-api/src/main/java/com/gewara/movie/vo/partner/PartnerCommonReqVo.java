package com.gewara.movie.vo.partner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.util.DateUtil;

public class PartnerCommonReqVo extends PartnerBaseReqVo{
	private static final long serialVersionUID = -5115491020877458901L;
	private Map<String, Object> commonMap;
	public PartnerCommonReqVo(){
		
	}
	public PartnerCommonReqVo(String appkey, String remoteIp, Map<String, Object> commonMap){
		this.appkey = appkey;
		this.remoteIp = remoteIp;
		this.commonMap = commonMap;
	}
	public Map<String, Object> getCommonMap() {
		return commonMap;
	}
	public void setCommonMap(Map<String, Object> commonMap) {
		this.commonMap = commonMap;
	}
	public void addMemberEncode(String memberEncode){
		addValue("memberEncode", memberEncode);
	}
	public void addValue(String key, String value){
		commonMap.put(key, value);
	}
	public Object gainValue(String key){
		return commonMap.get(key);
	}
	public String gainMemberEncode(){
		return gainStringValue("memberEncode");
	}
	public Long gainMemberId(){
		return gainLongValue("memberId");
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
	public Timestamp gainTimestampValue(String key){
		return DateUtil.parseTimestamp(gainStringValue(key));
	}
	public Date gainDateValue(String key){
		String str = gainStringValue(key);
		if(StringUtils.isBlank(str)){
			return null;
		}
		return DateUtil.parseDate(str);
	}
}
