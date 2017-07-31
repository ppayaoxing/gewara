package com.gewara.api.vo.pay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class PayMethodDescVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4565555963884678186L;
	
	private String payname;
	private String payalias;
	private String paydesc;
	
	@Override
	public Serializable realId() {
		return payname;
	}

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public String getPayalias() {
		return payalias;
	}

	public void setPayalias(String payalias) {
		this.payalias = payalias;
	}

	public String getPaydesc() {
		return paydesc;
	}

	public void setPaydesc(String paydesc) {
		this.paydesc = paydesc;
	}

	
}
