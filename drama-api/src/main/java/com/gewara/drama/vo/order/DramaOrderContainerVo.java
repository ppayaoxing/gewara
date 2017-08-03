package com.gewara.drama.vo.order;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.TheatreVo;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.util.Assert;

public class DramaOrderContainerVo extends BaseVo {

	private static final long serialVersionUID = 6688203510575752974L;

	private Long orderid;
	private TheatreVo theatre;
	private DramaVo drama;
	private ZeroGrabRosterVo roster;
	
	public DramaOrderContainerVo(){
		
	}
	
	public DramaOrderContainerVo(Long orderid, TheatreVo theatre, DramaVo drama){
		Assert.notNull(orderid);
		Assert.notNull(theatre);
		Assert.notNull(drama);
		this.theatre = theatre;
		this.drama = drama;
	}
	
	@Override
	public Serializable realId() {
		return orderid;
	}


	public Long getOrderid() {
		return orderid;
	}

	public TheatreVo getTheatre() {
		return theatre;
	}

	public DramaVo getDrama() {
		return drama;
	}

	public ZeroGrabRosterVo getRoster() {
		return roster;
	}

	public void setRoster(ZeroGrabRosterVo roster) {
		this.roster = roster;
	}


}
