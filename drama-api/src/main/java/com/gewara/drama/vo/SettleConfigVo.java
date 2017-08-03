package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class SettleConfigVo extends BaseVo {
	
	private static final long serialVersionUID = -6321561266158903620L;

	private Long id;
	private Double discount;
	private String distype;
	private Timestamp addtime;
	
	public SettleConfigVo(){}
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDistype() {
		return distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}
