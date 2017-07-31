package com.gewara.api.vo.goods;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class GoodsSellOutRegisterVo extends BaseVo{
	private static final long serialVersionUID = -1452511463664537830L;
	private String id;
	private Long memberid;
	private Long itemid;
	private Long num;
	private Double price;
	private String mobile;
	private String remark;
	private String addTime;
	
	public GoodsSellOutRegisterVo(){
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	@Override
	public Serializable realId() {
		return id;
	}
	
}
