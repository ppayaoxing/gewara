/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DisQuantityVo extends BaseVo {
	private static final long serialVersionUID = 4242392716444879503L;
	private Long id;
	private Long dpid;
	private Long tspid;
	private Long areaid;
	private Integer quantity;
	private Integer price;
	private Integer costprice;
	private Integer theatreprice;
	private Integer version;
	private Integer maxbuy;
	private Integer tickettotal;
	private Integer allownum;
	private Integer sellordernum;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String distype;
	private Long settleid;
	private String name;
	private Timestamp starttime;
	private Timestamp endtime;
	private String retail;
	private String status;
	private String seller;
	private String sispseq;
	private String supplierCode;
	private Long dramaSettleid;
	private Long tipid;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getTspid() {
		return this.tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public Integer getTheatreprice() {
		return this.theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getTickettotal() {
		return this.tickettotal;
	}

	public void setTickettotal(Integer tickettotal) {
		this.tickettotal = tickettotal;
	}

	public Integer getAllownum() {
		return this.allownum;
	}

	public void setAllownum(Integer allownum) {
		this.allownum = allownum;
	}

	public Integer getSellordernum() {
		return this.sellordernum;
	}

	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getDistype() {
		return this.distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getRetail() {
		return this.retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSispseq() {
		return this.sispseq;
	}

	public void setSispseq(String sispseq) {
		this.sispseq = sispseq;
	}

	public boolean hasBooking() {
		Timestamp cur = DateUtil.getCurFullTimestamp();
		return cur.after(this.starttime) && cur.before(this.endtime) && StringUtils.equals(this.status, "Y");
	}

	public boolean hasStatus(String stats) {
		return StringUtils.isBlank(stats) ? false : StringUtils.equals(this.status, stats);
	}

	public boolean hasRetail() {
		return StringUtils.equals(this.getRetail(), "Y");
	}

	public boolean hasSeller(String sell) {
		return StringUtils.isBlank(sell) ? false : StringUtils.equals(this.seller, sell);
	}

	public Long getDramaSettleid() {
		return this.dramaSettleid;
	}

	public void setDramaSettleid(Long dramaSettleid) {
		this.dramaSettleid = dramaSettleid;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Long getTipid() {
		return this.tipid;
	}

	public void setTipid(Long tipid) {
		this.tipid = tipid;
	}
}