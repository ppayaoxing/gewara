/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.mall.vo.MallOrderVo;
import com.gewara.mall.vo.MemberUsefulAddressVo;
import com.gewara.mall.vo.ShipperOrderVo;
import java.io.Serializable;
import java.util.List;

public class OrderDetailShowVo extends BaseVo {
	private static final long serialVersionUID = -8328663577263980164L;
	private MallOrderVo mallOrder;
	private GewaOrderVo gewaOrder;
	private MemberUsefulAddressVo memberAddress;
	private List<ShipperOrderVo> shipperOrderList;

	public OrderDetailShowVo() {
	}

	public OrderDetailShowVo(MallOrderVo mallOrder, GewaOrderVo gewaOrder, MemberUsefulAddressVo memberAddress,
			List<ShipperOrderVo> shipperOrderList) {
		this.mallOrder = mallOrder;
		this.gewaOrder = gewaOrder;
		this.shipperOrderList = shipperOrderList;
		this.memberAddress = memberAddress;
	}

	public MallOrderVo getMallOrder() {
		return this.mallOrder;
	}

	public void setMallOrder(MallOrderVo mallOrder) {
		this.mallOrder = mallOrder;
	}

	public GewaOrderVo getGewaOrder() {
		return this.gewaOrder;
	}

	public void setGewaOrder(GewaOrderVo gewaOrder) {
		this.gewaOrder = gewaOrder;
	}

	public MemberUsefulAddressVo getMemberAddress() {
		return this.memberAddress;
	}

	public void setMemberAddress(MemberUsefulAddressVo memberAddress) {
		this.memberAddress = memberAddress;
	}

	public List<ShipperOrderVo> getShipperOrderList() {
		return this.shipperOrderList;
	}

	public void setShipperOrderList(List<ShipperOrderVo> shipperOrderList) {
		this.shipperOrderList = shipperOrderList;
	}

	public Serializable realId() {
		return null;
	}
}