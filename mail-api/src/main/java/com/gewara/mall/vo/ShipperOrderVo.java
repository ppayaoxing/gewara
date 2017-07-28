/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.mall.constant.MallOrderConstant;
import com.gewara.mall.vo.MallOrderVo;
import com.gewara.mall.vo.OrderProductVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class ShipperOrderVo extends BaseVo {
	private static final long serialVersionUID = 3765934532987492193L;
	private Long id;
	private Long mallOrderId;
	private String shipperOrderNo;
	private Long shipperId;
	private Integer shippingFee;
	private String expressNo;
	private String expressType;
	private String expressStatus;
	private String remark;
	private Timestamp sendTime;
	private List<OrderProductVo> orderProductList = new ArrayList();

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShipperId() {
		return this.shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public Long getMallOrderId() {
		return this.mallOrderId;
	}

	public void setMallOrderId(Long mallOrderId) {
		this.mallOrderId = mallOrderId;
	}

	public String getExpressNo() {
		return this.expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	public String getExpressType() {
		return this.expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public String getExpressStatus() {
		return this.expressStatus;
	}

	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
	}

	public String getShipperOrderNo() {
		return this.shipperOrderNo;
	}

	public void setShipperOrderNo(String shipperOrderNo) {
		this.shipperOrderNo = shipperOrderNo;
	}

	public Integer getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public List<OrderProductVo> getOrderProductList() {
		return this.orderProductList;
	}

	public void setOrderProductList(List<OrderProductVo> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public void addOrderProductVo(OrderProductVo orderProductVo) {
		this.orderProductList.add(orderProductVo);
	}

	public String gainStatusText(MallOrderVo mallOrder) {
		String shStatus = mallOrder.getShStatus();
		String status = mallOrder.getStatus();
		if (StringUtils.equals(shStatus, "paid_success")) {
			if (!StringUtils.equals(this.expressStatus, "init")) {
				return (String) MallOrderConstant.expStatusMap.get(this.expressStatus);
			}

			if (StringUtils.equals(status, "paid_deposit")) {
				return (String) MallOrderConstant.orderStatusMap.get(status);
			}

			if (StringUtils.equals(status, "paid_retainage")) {
				return (String) MallOrderConstant.orderStatusMap.get(status);
			}
		}

		String fullStatus = mallOrder.getFullStatus();
		return (String) MallOrderConstant.orderStatusMap.get(fullStatus);
	}

	public Integer gainTotalFee() {
		if (this.orderProductList == null) {
			return null;
		} else {
			int totalFee = 0;

			OrderProductVo itemVo;
			for (Iterator arg1 = this.orderProductList.iterator(); arg1
					.hasNext(); totalFee += itemVo.getOrderItem().getDue()) {
				itemVo = (OrderProductVo) arg1.next();
			}

			return Integer.valueOf(totalFee);
		}
	}
}