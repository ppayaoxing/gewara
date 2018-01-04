package com.gewara.mall.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.mall.constant.MallOrderConstant;
//根据发货商生成订单(包裹单)
public class ShipperOrderVo extends BaseVo{
	private static final long serialVersionUID = 3765934532987492193L;
	private Long id;	
	private Long mallOrderId;						//订单id
	private String shipperOrderNo;					//订单号
	private Long shipperId;							//发货商的Id
	private Integer shippingFee;					//货运费用
	private String expressNo;						//运单号
	private String expressType;						//快递类型
	private String expressStatus;					//物流状态
	private String remark;							//商家备注
	private Timestamp sendTime;						//发货时间
	
	private List<OrderProductVo> orderProductList=new ArrayList<OrderProductVo>();		//查询的时候使用
	
	@Override
	public Serializable realId() {
		return id;
	}
	public ShipperOrderVo(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShipperId() {
		return shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public Long getMallOrderId() {
		return mallOrderId;
	}

	public void setMallOrderId(Long mallOrderId) {
		this.mallOrderId = mallOrderId;
	}

	public String getExpressNo() {
		return expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public String getExpressStatus() {
		return expressStatus;
	}

	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
	}
	public String getShipperOrderNo() {
		return shipperOrderNo;
	}
	public void setShipperOrderNo(String shipperOrderNo) {
		this.shipperOrderNo = shipperOrderNo;
	}
	public Integer getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public List<OrderProductVo> getOrderProductList() {
		return orderProductList;
	}
	public void setOrderProductList(List<OrderProductVo> orderProductList) {
		this.orderProductList = orderProductList;
	}
	public void addOrderProductVo(OrderProductVo orderProductVo){
		this.orderProductList.add(orderProductVo);
	}
	
	public String gainStatusText(MallOrderVo mallOrder){
		String shStatus = mallOrder.getShStatus();
		String status = mallOrder.getStatus();
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
		String fullStatus = mallOrder.getFullStatus();
		return MallOrderConstant.orderStatusMap.get(fullStatus);
	}
	
	public Integer gainTotalFee(){
		if(orderProductList!=null){
			int totalFee = 0;
			for(OrderProductVo itemVo : orderProductList){
				totalFee = totalFee + itemVo.getOrderItem().getDue();
			}
			return totalFee;
		}
		return null;
	}
}
