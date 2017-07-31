package com.gewara.api.terminal.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class MachineAdVo extends BaseVo {
	public static final String FILE_TYPE_WALLPAPER = "wallpaper";
	public static final String FILE_TYPE_SCREENSAVER = "screensaver";
	
	private static final long serialVersionUID = 8091397268335515143L;
	private Long id;			
	private String placeid;		//场馆id
	private String adversion;	//版本
	private String zipurl;		//压缩包地址
	private String remark;		//描述
	private Timestamp addtime;
	private Timestamp startTime; //广告有效开始时间
	private Timestamp endTime; //广告有效结束时间
	private String type;//场馆类型
	private String nickName;//添加人id
	private String filetype;	// 壁纸or屏保
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaceid() {
		return placeid;
	}
	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}
	public String getAdversion() {
		return adversion;
	}
	public void setAdversion(String adversion) {
		this.adversion = adversion;
	}
	public String getZipurl() {
		return zipurl;
	}
	public void setZipurl(String zipurl) {
		this.zipurl = zipurl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
}
