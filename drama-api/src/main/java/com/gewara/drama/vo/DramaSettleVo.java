package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.VmBaseUtil;

public class DramaSettleVo extends BaseVo {
	
	public static final String DISCOUNT_TYPE_PERCENT = "percent";			//结算百分比
	public static final String DISCOUNT_TYPE_UPRICE = "uprice";			//物品折扣

	private static final long serialVersionUID = 3859456713215899179L;
	private Long dramaid;					//结算项目
	private Long id;
	private Long settleid;
	private Long commissionSettleid;
	private Double discount;
	private Double commissionDiscount;
	private String distype;
	private String commissionDistype;
	private String remark;
	private Timestamp addtime;
	private String supplierCode;

	private String settleCycle;
	private String settleBase;
	
	public DramaSettleVo(){}

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	
	public Long getSettleid(){
		return settleid;
	}
	
	public void setSettleid(Long settleid){
		this.settleid = settleid;
	}
	
	public String gainSettleRemark(){
		String tmp = "";
		if(StringUtils.equals(this.getDistype(), DISCOUNT_TYPE_UPRICE)){
			tmp = "按基价(减)" + this.getDiscount() + "结算";
		}else if(StringUtils.equals(this.getDistype(), DISCOUNT_TYPE_PERCENT)){
			tmp = "按基价(乘)" + VmBaseUtil.formatPercent(this.getDiscount(), 100.0)+ "结算";
		}
		return tmp;
	}
	public String gainSecondSettleRemark(){
		String tmp = "";
		if(StringUtils.equals(this.getCommissionDistype(), DISCOUNT_TYPE_UPRICE)){
			tmp = "按基价(减)" + this.getCommissionDiscount() + "结算";
		}else if(StringUtils.equals(this.getCommissionDistype(), DISCOUNT_TYPE_PERCENT)){
			tmp = "按基价(乘)" + VmBaseUtil.formatPercent(this.getCommissionDiscount(), 100.0)+ "结算";
		}
		return tmp;
	}
	
	public String getSettletype() {
		return "drama";
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDistype() {
		return distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSettleBase() {
		return settleBase;
	}

	public void setSettleBase(String settleBase) {
		this.settleBase = settleBase;
	}

	public String getSettleCycle() {
		return settleCycle;
	}

	public void setSettleCycle(String settleCycle) {
		this.settleCycle = settleCycle;
	}

	public Long getCommissionSettleid() {
		return commissionSettleid;
	}

	public void setCommissionSettleid(Long commissionSettleid) {
		this.commissionSettleid = commissionSettleid;
	}

	public Double getCommissionDiscount() {
		return commissionDiscount;
	}

	public void setCommissionDiscount(Double commissionDiscount) {
		this.commissionDiscount = commissionDiscount;
	}

	public String getCommissionDistype() {
		return commissionDistype;
	}

	public void setCommissionDistype(String commissionDistype) {
		this.commissionDistype = commissionDistype;
	}

}
