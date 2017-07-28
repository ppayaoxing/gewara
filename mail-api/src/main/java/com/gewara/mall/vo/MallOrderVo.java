/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.mall.constant.MallOrderConstant;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class MallOrderVo extends BaseVo {
	private static final long serialVersionUID = -551269625866654797L;
	private Long id;
	private String mobile;
	private Integer totalFee;
	private Integer totalCost;
	private Integer usedPoint;
	private Integer shippingFee;
	private Long memberId;
	private Long partnerId;
	private String memberRemark;
	private String remark;
	private String description;
	private Timestamp validTime;
	private String status;
	private String category;
	private Long parentMallOrderId;
	private String otherInfo;
	private Long shOrderId;
	private String shStatus;
	private String tradeNo;
	private String expressStatus;

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getDue() {
		return Integer.valueOf(this.totalFee.intValue() + this.shippingFee.intValue());
	}

	public Long getShOrderId() {
		return this.shOrderId;
	}

	public void setShOrderId(Long shOrderId) {
		this.shOrderId = shOrderId;
	}

	public Integer getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getMemberRemark() {
		return this.memberRemark;
	}

	public void setMemberRemark(String memberRemark) {
		this.memberRemark = memberRemark;
	}

	public Long getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getShStatus() {
		return this.shStatus;
	}

	public void setShStatus(String shStatus) {
		this.shStatus = shStatus;
	}

	public Long getParentMallOrderId() {
		return this.parentMallOrderId;
	}

	public void setParentMallOrderId(Long parentMallOrderId) {
		this.parentMallOrderId = parentMallOrderId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getValidTime() {
		return this.validTime;
	}

	public void setValidTime(Timestamp validTime) {
		this.validTime = validTime;
	}

	public boolean isTimeout() {
		return this.validTime != null && this.validTime.before(new Timestamp(System.currentTimeMillis()));
	}

	public boolean isNew() {
		return StringUtils.startsWith(this.shStatus, "new") && !this.isTimeout();
	}

	public boolean isNeedPaidRetainage() {
		return StringUtils.startsWith(this.status, "paid_deposit");
	}

	public Integer getUsedPoint() {
		return this.usedPoint;
	}

	public void setUsedPoint(Integer usedPoint) {
		this.usedPoint = usedPoint;
	}

	public boolean isPaid() {
		return StringUtils.startsWith(this.shStatus, "paid");
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExpressStatus() {
		return this.expressStatus;
	}

	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
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

	public String getFullStatus() {
		return this.status.startsWith("new") && this.isTimeout() ? "cancel_timeout" : this.status;
	}

	public String getStatusText() {
		if (StringUtils.equals(this.shStatus, "paid_success")) {
			if (!StringUtils.equals(this.expressStatus, "init")) {
				return (String) MallOrderConstant.expStatusMap.get(this.expressStatus);
			}

			if (StringUtils.equals(this.status, "paid_deposit")) {
				return (String) MallOrderConstant.orderStatusMap.get(this.status);
			}

			if (StringUtils.equals(this.status, "paid_retainage")) {
				return (String) MallOrderConstant.orderStatusMap.get(this.status);
			}
		}

		String fullStatus = this.getFullStatus();
		return (String) MallOrderConstant.orderStatusMap.get(fullStatus);
	}
}