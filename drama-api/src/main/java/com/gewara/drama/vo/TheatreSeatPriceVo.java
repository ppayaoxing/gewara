package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.OdiConstant;

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
	private Integer maxbuy;				//单次购票数量
	private Integer quantity;			//剧院拿票数量
	private Integer allowaddnum;		//最大订单名额
	private Integer sales;				//卖出票数量
	private Integer sellordernum;		//卖出订单数量
	private Timestamp updatetime;		//更新时间
	private String seller;				//
	private String sispseq;				//第三方价格编号(ShowPrice-->sispseq)
	private String retail;				//是否可以零售
	private String showprice;			//是否展示在前台
	private String flag;
	
	private Timestamp addtime;
	private Long settleid;				
	private Integer csellnum;			//场馆卖出数
	private Integer gsellnum;			//格瓦拉锁定
	private String origin;				//来源
	private Integer warnnum;			//预警数量
	private String otherinfo;			//其它信息
	
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
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
	public Integer getTheatreprice() {
		return theatreprice;
	}
	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getMaxbuy() {
		return maxbuy;
	}
	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getAllowaddnum() {
		return allowaddnum;
	}
	public void setAllowaddnum(Integer allowaddnum) {
		this.allowaddnum = allowaddnum;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getSellordernum() {
		return sellordernum;
	}
	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getSispseq() {
		return sispseq;
	}
	public void setSispseq(String sispseq) {
		this.sispseq = sispseq;
	}
	public String getRetail() {
		return retail;
	}
	public void setRetail(String retail) {
		this.retail = retail;
	}
	public String getShowprice() {
		return showprice;
	}
	public void setShowprice(String showprice) {
		this.showprice = showprice;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Long getSettleid() {
		return settleid;
	}
	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}
	public Integer getCsellnum() {
		return csellnum;
	}
	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}
	
	public Integer getGsellnum() {
		return gsellnum;
	}
	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Integer getWarnnum() {
		return warnnum;
	}
	public void setWarnnum(Integer warnnum) {
		this.warnnum = warnnum;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public boolean hasBooking(){
		return hasStatus(OdiConstant.STATUS_BOOK);
	}

	public boolean hasAllownum(){
		return gainSurplus() > 0 && allowaddnum > 0;
	}
	
	public Integer gainSurplus(){
		return quantity - gainSell();
	}
	
	public Integer gainSell(){
		if(StringUtils.equals(this.seller, OdiConstant.PARTNER_GEWA)){
			 return sales + gsellnum;
		}
		return csellnum + gsellnum + sales;
	}
	
	public boolean hasRetail(){
		return StringUtils.equals(this.retail, OdiConstant.STATUS_BOOK);
	}
	
	public boolean hasShowPrice(){
		return StringUtils.equals(this.showprice, OdiConstant.STATUS_BOOK);
	}

	public boolean hasStatus(String stats){
		if(StringUtils.isBlank(stats)){
			return false;
		}
		return StringUtils.equals(this.status, stats);
	}
	public Long getItemPriceId() {
		return itemPriceId;
	}
	public void setItemPriceId(Long itemPriceId) {
		this.itemPriceId = itemPriceId;
	}
}
