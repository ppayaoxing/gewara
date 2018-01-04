package com.gewara.api.vo.pay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class OtherFeeDetailVo extends BaseVo{
	private static final long serialVersionUID = 2420637586145837449L;
	public static final String FEETYPE_E = "E";		//快递费
	public static final String FEETYPE_U = "U";		//移动手续费
	public static final String FEETYPE_C = "C";		//更换订单产生多余的费用
	
	private Long id;
	private Long orderid;		//订单的id
	private Integer fee;		//费用
	private Integer quantity;	//数量
	private String feetype;		//费用类型
	private String reason;		//原因  （orderid+reason）唯一
	private String status;     //
	private String otherinfo;  //电影退票险 保存姓名 生日
	
	public OtherFeeDetailVo(){
	}
	public OtherFeeDetailVo(Long orderid, String feetype, Integer fee, String reason){
		this(orderid, feetype, fee, reason, 1);
	}
	
	public OtherFeeDetailVo(Long orderid, String feetype, Integer fee, String reason, Integer quantity){
		this.orderid = orderid;
		this.feetype = feetype;
		this.fee = fee;
		this.reason = reason;
		this.quantity = quantity;
	}
	
	public OtherFeeDetailVo(OtherFeeDetailVo otherFeeDetail){
		this.orderid = otherFeeDetail.getOrderid();
		this.fee = otherFeeDetail.getFee();
		this.quantity = otherFeeDetail.getQuantity();
		this.feetype = otherFeeDetail.getFeetype();
		this.reason = otherFeeDetail.getReason();
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}
