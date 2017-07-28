/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.schedule;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;

public class TheatreSeatPriceExtVo extends BaseVo {
	private static final long serialVersionUID = -8669655167327194190L;
	private Long id;
	private Long dramaid;
	private Long theatreid;
	private String dramaname;
	private String theatrename;
	private Long dpid;
	private Long areaid;
	private Timestamp playtime;
	private String areaname;
	private Long tspid;
	private String correcttype;
	private Integer quantity;
	private Long disid;
	private Integer disquantity;
	private Integer price;
	private Integer costprice;
	private Long settleid;
	private String opertype;
	private Long operuser;
	private String opername;
	private String tradeno;
	private Long buyitemid;
	private String remark;
	private String otherinfo;
	private Timestamp addtime;

	public TheatreSeatPriceExtVo() {
	}

	public TheatreSeatPriceExtVo(String correcttype, Integer quantity) {
		this.correcttype = correcttype;
		this.quantity = quantity;
		this.disquantity = Integer.valueOf(1);
		this.addtime = DateUtil.getCurFullTimestamp();
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getDramaname() {
		return this.dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getTheatrename() {
		return this.theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Long getTspid() {
		return this.tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public String getCorrecttype() {
		return this.correcttype;
	}

	public void setCorrecttype(String correcttype) {
		this.correcttype = correcttype;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getDisquantity() {
		return this.disquantity;
	}

	public void setDisquantity(Integer disquantity) {
		this.disquantity = disquantity;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getOpertype() {
		return this.opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public Long getOperuser() {
		return this.operuser;
	}

	public void setOperuser(Long operuser) {
		this.operuser = operuser;
	}

	public String getOpername() {
		return this.opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getBuyitemid() {
		return this.buyitemid;
	}

	public void setBuyitemid(Long buyitemid) {
		this.buyitemid = buyitemid;
	}

	public Integer getSubQuantity() {
		return this.getCorrecttype().startsWith("sub") ? this.quantity : Integer.valueOf(-this.quantity.intValue());
	}

	public Integer getAddQuantity() {
		return this.getCorrecttype().startsWith("add") ? this.quantity : Integer.valueOf(-this.quantity.intValue());
	}
}