/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SpecialDiscountTagVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = 5874675414503642541L;
	private Long spdid;
	private String description;
	private String otherinfo;
	private String addtime;
	private String updatetime;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Long getSpdid() {
		return this.spdid;
	}

	public void setSpdid(Long spdid) {
		this.spdid = spdid;
	}

	public Serializable realId() {
		return this.spdid;
	}
}