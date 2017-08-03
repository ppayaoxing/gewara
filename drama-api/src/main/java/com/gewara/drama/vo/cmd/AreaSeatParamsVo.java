package com.gewara.drama.vo.cmd;

import java.io.Serializable;

public class AreaSeatParamsVo implements Serializable {

	private static final long serialVersionUID = 3032766935494905571L;
	
	private Long itemid;				//场次ID
	private Long areaid;			//区域ID
	private Long priceid;			//价格ID
	private Long disid;				//套票ID
	private String spkey;
	
	public AreaSeatParamsVo(){}
	
	public AreaSeatParamsVo(Long itemid){
		this.itemid = itemid;
	}
	
	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	public Long getPriceid() {
		return priceid;
	}
	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}
	public Long getDisid() {
		return disid;
	}
	public void setDisid(Long disid) {
		this.disid = disid;
	}
	public String getSpkey() {
		return spkey;
	}
	public void setSpkey(String spkey) {
		this.spkey = spkey;
	}
	
}
