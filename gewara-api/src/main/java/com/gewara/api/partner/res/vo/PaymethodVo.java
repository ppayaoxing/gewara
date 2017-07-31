package com.gewara.api.partner.res.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class PaymethodVo extends BaseVo{
	private static final long serialVersionUID = -43179635576108505L;
	private String _id;
	private String paymethodDesc;

	public String getPaymethodDesc() {
		return paymethodDesc;
	}

	public void setPaymethodDesc(String paymethodDesc) {
		this.paymethodDesc = paymethodDesc;
	}

	@Override
	public Serializable realId() {
		return _id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
