package com.gewara.drama.vo.schedule;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.OdiConstant;
import com.gewara.util.DateUtil;

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
	private String opertype;		//操作类型
	private Long operuser;			//操作ID
	private String opername;		//操作人
	private String tradeno;			//订单号
	private Long buyitemid;			//buyitem ID
	private String remark;			//说明
	private String otherinfo;		
	private Timestamp addtime;		//增加时间
	
	public TheatreSeatPriceExtVo(){}
	
	public TheatreSeatPriceExtVo(String correcttype, Integer quantity){
		this.correcttype = correcttype;
		this.quantity = quantity;
		this.disquantity = 1;
		this.addtime = DateUtil.getCurFullTimestamp();
	}

	@Override
	public Serializable realId() {
		return id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getDramaname() {
		return dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Timestamp getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Long getTspid() {
		return tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public Long getDisid() {
		return disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public String getCorrecttype() {
		return correcttype;
	}

	public void setCorrecttype(String correcttype) {
		this.correcttype = correcttype;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getDisquantity() {
		return disquantity;
	}

	public void setDisquantity(Integer disquantity) {
		this.disquantity = disquantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Long getSettleid() {
		return settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public Long getOperuser() {
		return operuser;
	}

	public void setOperuser(Long operuser) {
		this.operuser = operuser;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getBuyitemid() {
		return buyitemid;
	}

	public void setBuyitemid(Long buyitemid) {
		this.buyitemid = buyitemid;
	}

	public Integer getSubQuantity(){
		if(this.getCorrecttype().startsWith(OdiConstant.CORRECT_SUB)){
			return this.quantity;
		}
		return -quantity;
	}
	public Integer getAddQuantity(){
		if(this.getCorrecttype().startsWith(OdiConstant.CORRECT_ADD)){
			return this.quantity;
		}
		return -quantity;
	}
}
