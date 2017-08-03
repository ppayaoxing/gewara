package com.gewara.drama.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ZgCounterVo extends BaseVo {

	private static final long serialVersionUID = 357537779534232402L;
	private Long priceid;					//价格ID
	private Integer version;
	private Integer quantity;
	private Integer maxnum;
	private Integer grabnum;
	private String zgcukey;					//限制用户只能参加一个活动
	
	@Override
	public Serializable realId() {
		return priceid;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public Integer getGrabnum() {
		return grabnum;
	}

	public void setGrabnum(Integer grabnum) {
		this.grabnum = grabnum;
	}

	public String getZgcukey() {
		return zgcukey;
	}

	public void setZgcukey(String zgcukey) {
		this.zgcukey = zgcukey;
	}

}
