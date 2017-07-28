/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.req;

import com.gewara.drama.vo.req.AbstractCheckDramaRollCallReq;

public class CheckSimpleDramaRollCallReq extends AbstractCheckDramaRollCallReq {
	private static final long serialVersionUID = -321277072407870155L;
	private Long dpid;
	private Integer buyCount;

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Integer getBuyCount() {
		return this.buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
}