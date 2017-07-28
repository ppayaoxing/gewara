/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerBaseReqVo;
import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class PartnerCommonReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -5115491020877458901L;
	private Map<String, Object> commonMap;

	public PartnerCommonReqVo() {
		this.commonMap = new HashMap();
	}

	public PartnerCommonReqVo(String appkey, String remoteIp, Map<String, Object> commonMap) {
		this.appkey = appkey;
		this.remoteIp = remoteIp;
		this.commonMap = commonMap;
	}

	public Map<String, Object> getCommonMap() {
		return this.commonMap;
	}

	public void setCommonMap(Map<String, Object> commonMap) {
		this.commonMap = commonMap;
	}

	public void addMemberEncode(String memberEncode) {
		this.addValue("memberEncode", memberEncode);
	}

	public void addValue(String key, String value) {
		this.commonMap.put(key, value);
	}

	public Object gainValue(String key) {
		return this.commonMap.get(key);
	}

	public String gainMemberEncode() {
		return this.gainStringValue("memberEncode");
	}

	public Long gainMemberId() {
		return this.gainLongValue("memberId");
	}

	public String gainStringValue(String key) {
		Object object = this.gainValue(key);
		return object == null ? "" : String.valueOf(object);
	}

	public Long gainLongValue(String key) {
		String str = this.gainStringValue(key);
		return StringUtils.isBlank(str) ? null : Long.valueOf(str);
	}

	public Integer gainIntegerValue(String key) {
		String str = this.gainStringValue(key);
		return StringUtils.isBlank(str) ? null : Integer.valueOf(str);
	}

	public Timestamp gainTimestampValue(String key) {
		return DateUtil.parseTimestamp(this.gainStringValue(key));
	}

	public Date gainDateValue(String key) {
		String str = this.gainStringValue(key);
		return StringUtils.isBlank(str) ? null : DateUtil.parseDate(str);
	}
}