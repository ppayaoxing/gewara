/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class OtherFeeDetailVo extends BaseVo {
	private static final long serialVersionUID = 2420637586145837449L;
	public static final String FEETYPE_E = "E";
	public static final String FEETYPE_U = "U";
	public static final String FEETYPE_C = "C";
	private Long id;
	private Long orderid;
	private Integer fee;
	private Integer quantity;
	private String feetype;
	private String reason;
	private String status;
	private String otherinfo;

	public OtherFeeDetailVo() {
	}

	public OtherFeeDetailVo(Long orderid, String feetype, Integer fee, String reason) {
		this(orderid, feetype, fee, reason, Integer.valueOf(1));
	}

	public OtherFeeDetailVo(Long orderid, String feetype, Integer fee, String reason, Integer quantity) {
		this.orderid = orderid;
		this.feetype = feetype;
		this.fee = fee;
		this.reason = reason;
		this.quantity = quantity;
	}

	public OtherFeeDetailVo(OtherFeeDetailVo otherFeeDetail) {
		this.orderid = otherFeeDetail.getOrderid();
		this.fee = otherFeeDetail.getFee();
		this.quantity = otherFeeDetail.getQuantity();
		this.feetype = otherFeeDetail.getFeetype();
		this.reason = otherFeeDetail.getReason();
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getFeetype() {
		return this.feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Integer getFee() {
		return this.fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}