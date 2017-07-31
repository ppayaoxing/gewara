package com.gewara.api.terminal.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class DpiLayoutVo extends BaseVo{
	private static final long serialVersionUID = -1572220456053548458L;
	private Long dpid;
	private String seller;
	private String content;
	public Long getDpid() {
		return dpid;
	}
	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public Serializable realId() {
		return dpid;
	}
}
