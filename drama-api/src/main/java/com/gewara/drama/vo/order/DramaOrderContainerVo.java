/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.order;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.TheatreVo;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.util.Assert;
import java.io.Serializable;

public class DramaOrderContainerVo extends BaseVo {
	private static final long serialVersionUID = 6688203510575752974L;
	private Long orderid;
	private TheatreVo theatre;
	private DramaVo drama;
	private ZeroGrabRosterVo roster;

	public DramaOrderContainerVo() {
	}

	public DramaOrderContainerVo(Long orderid, TheatreVo theatre, DramaVo drama) {
		Assert.notNull(orderid);
		Assert.notNull(theatre);
		Assert.notNull(drama);
		this.theatre = theatre;
		this.drama = drama;
	}

	public Serializable realId() {
		return this.orderid;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public TheatreVo getTheatre() {
		return this.theatre;
	}

	public DramaVo getDrama() {
		return this.drama;
	}

	public ZeroGrabRosterVo getRoster() {
		return this.roster;
	}

	public void setRoster(ZeroGrabRosterVo roster) {
		this.roster = roster;
	}
}