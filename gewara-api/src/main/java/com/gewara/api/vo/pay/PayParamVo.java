/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PayParamVo extends BaseVo {
	private static final long serialVersionUID = -306123430828268831L;
	private String paramname;
	private String paramvalue;

	public PayParamVo(String paramname, String paramvalue) {
		this.paramname = paramname;
		this.paramvalue = paramvalue;
	}

	public PayParamVo() {
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public Serializable realId() {
		return this.paramname;
	}
}