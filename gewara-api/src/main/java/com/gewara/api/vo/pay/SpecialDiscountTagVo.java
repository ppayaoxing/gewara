package com.gewara.api.vo.pay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class SpecialDiscountTagVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = 5874675414503642541L;
	private Long spdid;
	private String description;
	private String otherinfo;
	private String addtime;
	private String updatetime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Long getSpdid() {
		return spdid;
	}

	public void setSpdid(Long spdid) {
		this.spdid = spdid;
	}

	@Override
	public Serializable realId() {
		return spdid;
	}
}
