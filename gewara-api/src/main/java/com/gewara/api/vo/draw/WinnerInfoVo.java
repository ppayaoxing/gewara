/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.draw;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class WinnerInfoVo extends BaseVo {
	private static final long serialVersionUID = -7691160993786955260L;
	public static final String TAG_SYSTEM = "system";
	public static final String TAG_USER = "user";
	public static final String SUM_PRIZECOUNT = "sumprizecount";
	public static final String PROBABILTY_STATUS = "probabiltystatus";
	private Long id;
	private Long activityid;
	private Long memberid;
	private String nickname;
	private Long prizeid;
	private String mobile;
	private Timestamp addtime;
	private String status;
	private String tag;
	private Long relatedid;
	private String remark;
	private String ip;

	public WinnerInfoVo() {
	}

	public WinnerInfoVo(Long activityid, Timestamp addtime) {
		this.addtime = addtime;
		this.status = "N";
		this.tag = "system";
		this.activityid = activityid;
	}

	public WinnerInfoVo(Long activityid, Long prizeid, String mobile, Timestamp addtime, String tag) {
		this(activityid, addtime);
		this.prizeid = prizeid;
		this.mobile = mobile;
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getPrizeid() {
		return this.prizeid;
	}

	public void setPrizeid(Long prizeid) {
		this.prizeid = prizeid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getEnmobile() {
		String result = this.mobile;
		return StringUtils.length(result) <= 4 ? result : "*******" + result.substring(result.length() - 4);
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}