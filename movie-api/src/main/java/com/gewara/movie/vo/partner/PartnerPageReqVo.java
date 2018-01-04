package com.gewara.movie.vo.partner;

/**
 * 分页用
 */
public class PartnerPageReqVo extends PartnerBaseReqVo {

	private static final long serialVersionUID = 7490043716132851414L;
	private Integer from;
	private Integer maxnum;

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
}
