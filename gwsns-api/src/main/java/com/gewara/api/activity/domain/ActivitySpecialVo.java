package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ActivitySpecialVo extends BaseVo{

	private static final long serialVersionUID = 4637206764118261534L;
	private Long ztid;//专题ID
	private String title;//专题标题
	private String url;//专题链接
	private String logo;//专题封面图片
	private String support;//专题支持类型 pc/wap/all
	private Timestamp addtime;//创建时间
	private Timestamp starttime;//发布时间
	private Integer orderNum;//排序序号
	private String otherinfo;
	
	@Override
	public Serializable realId() {
		return ztid;
	}
	public Long getZtid() {
		return ztid;
	}
	public void setZtid(Long ztid) {
		this.ztid = ztid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

}
