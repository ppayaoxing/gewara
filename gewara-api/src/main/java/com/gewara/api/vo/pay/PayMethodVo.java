/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PayMethodVo extends BaseVo {
	private static final long serialVersionUID = 1752493104769799032L;
	private String payMethod;
	private String payMethodText;
	private String flag;
	private String mangerUrl;

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayMethodText() {
		return this.payMethodText;
	}

	public void setPayMethodText(String payMethodText) {
		this.payMethodText = payMethodText;
	}

	public String getTag() {
		return this.flag;
	}

	public void setTag(String tag) {
		this.flag = tag;
	}

	public Serializable realId() {
		return this.payMethod;
	}

	public String getMangerUrl() {
		return this.mangerUrl;
	}

	public void setMangerUrl(String mangerUrl) {
		this.mangerUrl = mangerUrl;
	}
}