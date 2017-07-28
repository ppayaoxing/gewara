/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MachineAdVo extends BaseVo {
	public static final String FILE_TYPE_WALLPAPER = "wallpaper";
	public static final String FILE_TYPE_SCREENSAVER = "screensaver";
	private static final long serialVersionUID = 8091397268335515143L;
	private Long id;
	private String placeid;
	private String adversion;
	private String zipurl;
	private String remark;
	private Timestamp addtime;
	private Timestamp startTime;
	private Timestamp endTime;
	private String type;
	private String nickName;
	private String filetype;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getAdversion() {
		return this.adversion;
	}

	public void setAdversion(String adversion) {
		this.adversion = adversion;
	}

	public String getZipurl() {
		return this.zipurl;
	}

	public void setZipurl(String zipurl) {
		this.zipurl = zipurl;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
}