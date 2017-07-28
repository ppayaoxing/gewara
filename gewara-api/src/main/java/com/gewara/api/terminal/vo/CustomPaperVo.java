/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;

public class CustomPaperVo extends BaseVo {
	private static final long serialVersionUID = -2058581559758933954L;
	private String id;
	private String tradeno;
	private String tag;
	private Date addtime;
	private String selfdomcontent;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getSelfdomcontent() {
		return this.selfdomcontent;
	}

	public void setSelfdomcontent(String selfdomcontent) {
		this.selfdomcontent = selfdomcontent;
	}

	public Serializable realId() {
		return this.id;
	}
}