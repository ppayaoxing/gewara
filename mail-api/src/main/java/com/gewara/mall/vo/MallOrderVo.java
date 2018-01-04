package com.gewara.mall.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.cons.OrderConstant;
import com.gewara.api.vo.BaseVo;
import com.gewara.mall.constant.MallOrderConstant;


public class MallOrderVo extends BaseVo{

	/**
	 * 订单
	 */
	private static final long serialVersionUID = -551269625866654797L;
	private Long id;
	private String mobile;							//会员电话
	private Integer totalFee;						//订单总金额
	private Integer totalCost;						//订单成本总金额	
	private Integer usedPoint;						//使用的积分数量
	private Integer shippingFee;					//货运费用
	private Long memberId;							//会员id
	private Long partnerId;							//来源
	private String memberRemark;					//用户备注
	private String remark;							//系统备注
	private String description;						//订单描述
	private Timestamp validTime;					//有效期
	
	private String status;							//mall订单状态,比订单等中心订单状态更细化
	private String category;						//订单类型区分：product,presell_deposit,presell_retainage
	private Long parentMallOrderId;					//关联父级订单的ID,如：预售的尾款产生的订单
	private String otherInfo;						//其他信息 json格式
	//以下是关联订单中心数据
	/** 订单id由mall系统产生，传递给上海系统relatedid */
	private Long shOrderId;							//上海系统订单id
	private String shStatus;						//上海系统订单状态
	private String tradeNo;							//上海交易流水号
	
	private String expressStatus;					//物流状态(查询订单的使用)
	public MallOrderVo() {
		
	}
	
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getDue(){
		return totalFee+shippingFee;
	}
	public Long getShOrderId() {
		return shOrderId;
	}
	public void setShOrderId(Long shOrderId) {
		this.shOrderId = shOrderId;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}
	
	public String getMemberRemark() {
		return memberRemark;
	}
	public void setMemberRemark(String memberRemark) {
		this.memberRemark = memberRemark;
	}
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getShStatus() {
		return shStatus;
	}
	public void setShStatus(String shStatus) {
		this.shStatus = shStatus;
	}
	public Long getParentMallOrderId() {
		return parentMallOrderId;
	}
	public void setParentMallOrderId(Long parentMallOrderId) {
		this.parentMallOrderId = parentMallOrderId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Timestamp getValidTime() {
		return validTime;
	}
	public void setValidTime(Timestamp validTime) {
		this.validTime = validTime;
	}
	public boolean isTimeout(){
		return validTime!=null && validTime.before(new Timestamp(System.currentTimeMillis()));
	}
	public boolean isNew(){
		return StringUtils.startsWith(shStatus, "new") && !isTimeout();
	}
	public boolean isNeedPaidRetainage(){
		return StringUtils.startsWith(status, MallOrderConstant.MALL_STATUS_PAID_DEPOSIT);
	}
	public Integer getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(Integer usedPoint) {
		this.usedPoint = usedPoint;
	}
	//是否已经付款
	public boolean isPaid(){
		return StringUtils.startsWith(shStatus, "paid");
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getExpressStatus() {
		return expressStatus;
	}
	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
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
	
	
	public String getFullStatus(){
		if(status.startsWith(OrderConstant.STATUS_NEW) && isTimeout()) {
			return OrderConstant.STATUS_TIMEOUT;
		}
		return status;
	}
	public String getStatusText(){
		if(StringUtils.equals(shStatus, MallOrderConstant.STATUS_PAID_SUCCESS)){
			if(!StringUtils.equals(expressStatus, MallOrderConstant.EXP_STATUS_INIT)){
				return MallOrderConstant.expStatusMap.get(expressStatus);
			}
			if(StringUtils.equals(status, MallOrderConstant.MALL_STATUS_PAID_DEPOSIT)){
				return MallOrderConstant.orderStatusMap.get(status);
			}else if(StringUtils.equals(status, MallOrderConstant.MALL_STATUS_PAID_RETAINAGE)){
				return MallOrderConstant.orderStatusMap.get(status);
			}
		}
		String fullStatus = getFullStatus();
		return MallOrderConstant.orderStatusMap.get(fullStatus);
	}
}
