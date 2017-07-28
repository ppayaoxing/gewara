/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.VmBaseUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DramaSettleVo extends BaseVo {
	public static final String DISCOUNT_TYPE_PERCENT = "percent";
	public static final String DISCOUNT_TYPE_UPRICE = "uprice";
	private static final long serialVersionUID = 3859456713215899179L;
	private Long dramaid;
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

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String gainSettleRemark() {
		String tmp = "";
		if (StringUtils.equals(this.getDistype(), "uprice")) {
			tmp = "按基价(减)" + this.getDiscount() + "结算";
		} else if (StringUtils.equals(this.getDistype(), "percent")) {
			tmp = "按基价(乘)" + VmBaseUtil.formatPercent(this.getDiscount(), Double.valueOf(100.0D)) + "结算";
		}

		return tmp;
	}

	public String gainSecondSettleRemark() {
		String tmp = "";
		if (StringUtils.equals(this.getCommissionDistype(), "uprice")) {
			tmp = "按基价(减)" + this.getCommissionDiscount() + "结算";
		} else if (StringUtils.equals(this.getCommissionDistype(), "percent")) {
			tmp = "按基价(乘)" + VmBaseUtil.formatPercent(this.getCommissionDiscount(), Double.valueOf(100.0D)) + "结算";
		}

		return tmp;
	}

	public String getSettletype() {
		return "drama";
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDistype() {
		return this.distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSettleBase() {
		return this.settleBase;
	}

	public void setSettleBase(String settleBase) {
		this.settleBase = settleBase;
	}

	public String getSettleCycle() {
		return this.settleCycle;
	}

	public void setSettleCycle(String settleCycle) {
		this.settleCycle = settleCycle;
	}

	public Long getCommissionSettleid() {
		return this.commissionSettleid;
	}

	public void setCommissionSettleid(Long commissionSettleid) {
		this.commissionSettleid = commissionSettleid;
	}

	public Double getCommissionDiscount() {
		return this.commissionDiscount;
	}

	public void setCommissionDiscount(Double commissionDiscount) {
		this.commissionDiscount = commissionDiscount;
	}

	public String getCommissionDistype() {
		return this.commissionDistype;
	}

	public void setCommissionDistype(String commissionDistype) {
		this.commissionDistype = commissionDistype;
	}
}