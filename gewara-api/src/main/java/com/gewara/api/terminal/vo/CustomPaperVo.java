package com.gewara.api.terminal.vo;

import java.io.Serializable;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class CustomPaperVo extends BaseVo{
	private static final long serialVersionUID = -2058581559758933954L;
	private String id;
	private String tradeno;
	private String tag;
	private Date addtime;
	private String selfdomcontent;	//Æ±Ö½ÄÚÈÝ
	
	public CustomPaperVo(){}
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getSelfdomcontent() {
		return selfdomcontent;
	}
	public void setSelfdomcontent(String selfdomcontent) {
		this.selfdomcontent = selfdomcontent;
	}

	@Override
	public Serializable realId() {
		return id;
	}
}
