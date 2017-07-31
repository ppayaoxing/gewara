package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 商户联盟券
 * @author zhoufy
 */
public class BSCardVo extends BaseVo {
	
	private static final long serialVersionUID = -6845529792674703434L;
	
	private Long id;
	private String cardnum;		//券号
	private Long goodsid;		//物品ID
	private String brandname;	//品牌名称
	private Long orderid;		//订单号
	private Long memberid;		//用户ID
	private String status;		//状态 	未使用：Status.N	已使用：Status.Y
	private String remark;		//备注
	private Timestamp fromtime;
	private Timestamp totime;
	private Timestamp addtime;
	private Timestamp bindtime;	//使用时间
	private Long brandid;
	
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getFromtime() {
		return fromtime;
	}
	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}
	public Timestamp getTotime() {
		return totime;
	}
	public void setTotime(Timestamp totime) {
		this.totime = totime;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getBindtime() {
		return bindtime;
	}
	public void setBindtime(Timestamp bindtime) {
		this.bindtime = bindtime;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getBrandid() {
		return brandid;
	}
	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}
	
}
