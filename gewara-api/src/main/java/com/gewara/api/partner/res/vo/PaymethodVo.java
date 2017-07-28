/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PaymethodVo extends BaseVo {
	private static final long serialVersionUID = -43179635576108505L;
	private String _id;
	private String paymethodDesc;

	public String getPaymethodDesc() {
		return this.paymethodDesc;
	}

	public void setPaymethodDesc(String paymethodDesc) {
		this.paymethodDesc = paymethodDesc;
	}

	public Serializable realId() {
		return this._id;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}