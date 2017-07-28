/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.qa;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class GewaQaExpertVo extends BaseVo {
	private static final long serialVersionUID = -2898820814440297249L;
	public static Map<String, String> ssMap = new HashMap();
	public static final int HOTVALUE_HOT = 30000;
	public static final int HOTVALUE_RECOMMEND = 50000;
	public static String STATUS_N = "N";
	public static String STATUS_Y = "Y";
	private Long id;
	private Long memberid;
	private String status;
	private Integer hotvalue;
	private Long userid;
	private String tag;
	private String reason;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public GewaQaExpertVo() {
	}

	public GewaQaExpertVo(Long memberid) {
		this.memberid = memberid;
		this.status = STATUS_N;
		this.hotvalue = Integer.valueOf(0);
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTagname() {
		return (String) ssMap.get(this.tag);
	}

	static {
		ssMap.put("cinema", "电影");
		ssMap.put("", "其它");
	}
}