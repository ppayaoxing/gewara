/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class DpiLayoutVo extends BaseVo {
	private static final long serialVersionUID = -1572220456053548458L;
	private Long dpid;
	private String seller;
	private String content;

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Serializable realId() {
		return this.dpid;
	}
}