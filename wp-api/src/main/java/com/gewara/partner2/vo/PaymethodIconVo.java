/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PaymethodIconVo extends BaseVo {
	private static final long serialVersionUID = 2047438443244820893L;
	private Long id;
	private String createstaff;
	private String createtime;
	private String remark;
	private String paymethod;
	private String iconurl;

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatestaff() {
		return this.createstaff;
	}

	public void setCreatestaff(String createstaff) {
		this.createstaff = createstaff;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getIconurl() {
		return this.iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public Serializable realId() {
		return this.id;
	}
}