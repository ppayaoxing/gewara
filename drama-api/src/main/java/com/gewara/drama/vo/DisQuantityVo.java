package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.OdiConstant;
import com.gewara.util.DateUtil;

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
	private Integer maxbuy;				//���ι�Ʊ����
	private Integer tickettotal;		//���Ʊ��
	private Integer allownum;			//ʣ����Ʊ��
	private Integer sellordernum;		//��������Ʊ��
	private Timestamp addtime;
	private Timestamp updatetime;
	private String distype;				//�Ż����� G(���������Ż�) P(���췽�Ż�)
	private Long settleid;				//�������
	
	private String name;
	private Timestamp starttime;		//��Ʊ��ʼʱ��
	private Timestamp endtime;			//��Ʊ����ʱ��
	private String retail;				//�Ƿ�����
	private String status;				//�Ƿ����
	private String seller;				//
	private String sispseq;		

	private String supplierCode;
	private Long dramaSettleid;
	private Long tipid;
	
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

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getTspid() {
		return tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getMaxbuy() {
		return maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getTickettotal() {
		return tickettotal;
	}

	public void setTickettotal(Integer tickettotal) {
		this.tickettotal = tickettotal;
	}

	public Integer getAllownum() {
		return allownum;
	}

	public void setAllownum(Integer allownum) {
		this.allownum = allownum;
	}

	public Integer getSellordernum() {
		return sellordernum;
	}

	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getDistype() {
		return distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public Long getSettleid() {
		return settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getRetail() {
		return retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public boolean hasBooking(){
		Timestamp cur = DateUtil.getCurFullTimestamp();
		return cur.after(starttime) && cur.before(endtime)
				&& StringUtils.equals(this.status, OdiConstant.STATUS_BOOK);
	}
	
	public boolean hasStatus(String stats){
		if(StringUtils.isBlank(stats)) {
            return false;
        }
		return StringUtils.equals(this.status, stats);
	}
	
	public boolean hasRetail(){
		return StringUtils.equals(this.getRetail(), OdiConstant.STATUS_BOOK);
	}
	
	public boolean hasSeller(String sell){
		if(StringUtils.isBlank(sell)) {
            return false;
        }
		return StringUtils.equals(this.seller, sell);
	}

	public Long getDramaSettleid() {
		return dramaSettleid;
	}

	public void setDramaSettleid(Long dramaSettleid) {
		this.dramaSettleid = dramaSettleid;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Long getTipid() {
		return tipid;
	}

	public void setTipid(Long tipid) {
		this.tipid = tipid;
	}
}
