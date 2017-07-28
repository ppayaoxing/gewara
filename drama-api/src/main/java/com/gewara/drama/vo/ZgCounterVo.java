/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ZgCounterVo extends BaseVo {
	private static final long serialVersionUID = 357537779534232402L;
	private Long priceid;
	private Integer version;
	private Integer quantity;
	private Integer maxnum;
	private Integer grabnum;
	private String zgcukey;

	public Serializable realId() {
		return this.priceid;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public Integer getGrabnum() {
		return this.grabnum;
	}

	public void setGrabnum(Integer grabnum) {
		this.grabnum = grabnum;
	}

	public String getZgcukey() {
		return this.zgcukey;
	}

	public void setZgcukey(String zgcukey) {
		this.zgcukey = zgcukey;
	}
}