package com.gewara.drama.vo.req;

public class CheckSimpleDramaRollCallReq extends AbstractCheckDramaRollCallReq {

	private static final long serialVersionUID = -321277072407870155L;

	private Long dpid;
	private Integer buyCount;

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

}
