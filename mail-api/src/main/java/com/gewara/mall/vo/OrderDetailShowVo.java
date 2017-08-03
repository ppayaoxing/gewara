package com.gewara.mall.vo;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.order.GewaOrderVo;

public class OrderDetailShowVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8328663577263980164L;
	
	private MallOrderVo mallOrder;
	private GewaOrderVo gewaOrder;
	private MemberUsefulAddressVo memberAddress;
	private List<ShipperOrderVo> shipperOrderList;
	public OrderDetailShowVo(){
		
	}
	
	public OrderDetailShowVo(MallOrderVo mallOrder, GewaOrderVo gewaOrder, MemberUsefulAddressVo memberAddress, List<ShipperOrderVo> shipperOrderList){
		this.mallOrder = mallOrder;
		this.gewaOrder = gewaOrder;
		this.shipperOrderList = shipperOrderList;
		this.memberAddress = memberAddress;
	}

	public MallOrderVo getMallOrder() {
		return mallOrder;
	}

	public void setMallOrder(MallOrderVo mallOrder) {
		this.mallOrder = mallOrder;
	}

	public GewaOrderVo getGewaOrder() {
		return gewaOrder;
	}

	public void setGewaOrder(GewaOrderVo gewaOrder) {
		this.gewaOrder = gewaOrder;
	}

	public MemberUsefulAddressVo getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(MemberUsefulAddressVo memberAddress) {
		this.memberAddress = memberAddress;
	}

	public List<ShipperOrderVo> getShipperOrderList() {
		return shipperOrderList;
	}

	public void setShipperOrderList(List<ShipperOrderVo> shipperOrderList) {
		this.shipperOrderList = shipperOrderList;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
