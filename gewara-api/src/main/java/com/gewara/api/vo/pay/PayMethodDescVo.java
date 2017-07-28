/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PayMethodDescVo extends BaseVo {
	private static final long serialVersionUID = -4565555963884678186L;
	private String payname;
	private String payalias;
	private String paydesc;

	public Serializable realId() {
		return this.payname;
	}

	public String getPayname() {
		return this.payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public String getPayalias() {
		return this.payalias;
	}

	public void setPayalias(String payalias) {
		this.payalias = payalias;
	}

	public String getPaydesc() {
		return this.paydesc;
	}

	public void setPaydesc(String paydesc) {
		this.paydesc = paydesc;
	}
}