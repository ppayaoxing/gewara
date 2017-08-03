package com.gewara.drama.vo.req.common;

import java.io.Serializable;

public abstract class AbstractPageReqVo implements Serializable{
	private static final long serialVersionUID = -6586890914220965781L;

	protected int from;
	protected int maxnum;
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	
	
}
