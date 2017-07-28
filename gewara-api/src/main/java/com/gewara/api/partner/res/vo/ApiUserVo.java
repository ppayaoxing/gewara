/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ApiUserVo extends BaseVo {
	private static final long serialVersionUID = 9050518635941028420L;
	public static final String STATUS_OPEN = "open";
	public static final String STATUS_PAUSE = "pause";
	public static final String STATUS_STOP = "stop";
	private Long id;
	private String partnername;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartnername() {
		return this.partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
}