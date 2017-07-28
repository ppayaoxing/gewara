/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class TheatreSeatPriceVo extends BaseVo {
	private static final long serialVersionUID = -8024907727734150864L;
	private Long id;
	private Long dramaid;
	private Long dpid;
	private Long areaid;
	private Integer version;
	private String seattype;
	private Integer price;
	private Integer costprice;
	private Integer theatreprice;
	private Long itemPriceId;
	private String status;
	private String remark;
	private Integer maxbuy;
	private Integer quantity;
	private Integer allowaddnum;
	private Integer sales;
	private Integer sellordernum;
	private Timestamp updatetime;
	private String seller;
	private String sispseq;
	private String retail;
	private String showprice;
	private String flag;
	private Timestamp addtime;
	private Long settleid;
	private Integer csellnum;
	private Integer gsellnum;
	private String origin;
	private Integer warnnum;
	private String otherinfo;

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

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSeattype() {
		return this.seattype;
	}

	public void setSeattype(String seattype) {
		this.seattype = seattype;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAllowaddnum() {
		return this.allowaddnum;
	}

	public void setAllowaddnum(Integer allowaddnum) {
		this.allowaddnum = allowaddnum;
	}

	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getSellordernum() {
		return this.sellordernum;
	}

	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public String getRetail() {
		return this.retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getShowprice() {
		return this.showprice;
	}

	public void setShowprice(String showprice) {
		this.showprice = showprice;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public Integer getCsellnum() {
		return this.csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getGsellnum() {
		return this.gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getWarnnum() {
		return this.warnnum;
	}

	public void setWarnnum(Integer warnnum) {
		this.warnnum = warnnum;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public boolean hasBooking() {
		return this.hasStatus("Y");
	}

	public boolean hasAllownum() {
		return this.gainSurplus().intValue() > 0 && this.allowaddnum.intValue() > 0;
	}

	public Integer gainSurplus() {
		return Integer.valueOf(this.quantity.intValue() - this.gainSell().intValue());
	}

	public Integer gainSell() {
		return StringUtils.equals(this.seller, "GEWA")
				? Integer.valueOf(this.sales.intValue() + this.gsellnum.intValue())
				: Integer.valueOf(this.csellnum.intValue() + this.gsellnum.intValue() + this.sales.intValue());
	}

	public boolean hasRetail() {
		return StringUtils.equals(this.retail, "Y");
	}

	public boolean hasShowPrice() {
		return StringUtils.equals(this.showprice, "Y");
	}

	public boolean hasStatus(String stats) {
		return StringUtils.isBlank(stats) ? false : StringUtils.equals(this.status, stats);
	}

	public Long getItemPriceId() {
		return this.itemPriceId;
	}

	public void setItemPriceId(Long itemPriceId) {
		this.itemPriceId = itemPriceId;
	}
}