package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OtherFeeRefundVo extends BaseVo {
	private static final long serialVersionUID = 7420087805465434371L;

	private Long id;
	private Integer version;			//版本
	private String tradeno;				//订单号
	private String ordertype;			//订单类型
	private Long memberid;				//用户ID
	private Long partnerid;				//合作商ID
	private String mobile;				//手机号
	private String orderstatus;			//状态类型：paid_failure: 待处理订单  paid_success: 成交订单 paid_failure_unfix: 座位待处理
	private String origin;				//来源，费用类型
	private String reason;				//原因
	private Integer gewaRetAmount;		//Gewara退款
	private Integer oldFeeAmount;		//
	private String retback;				//是否要原路返回：Y：需要，N：不需要，O：未知, 参见描述(Other)，S: 已提交账务(Submit) R：财务已经返还(Refund)，F：财务返还出错(Failure)
	private Long applyuser;				//申请人
	private String applyinfo;			//申请信息
	private String otherinfo;			//其他信息：处理人，财务返回信息
	private Timestamp addtime;			//增加日期
	private Timestamp refundtime; 		//退款时间
	private String status;				//状态
	private Long dealuser;				//处理人
	private String dealinfo;			//处理信息
	private Long batch;					//批次标识

	public OtherFeeRefundVo(){}
	
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getPartnerid() {
		return partnerid;
	}
	
	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
	
	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getOldFeeAmount() {
		return oldFeeAmount;
	}
	
	public void setOldFeeAmount(Integer oldFeeAmount) {
		this.oldFeeAmount = oldFeeAmount;
	}
	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getGewaRetAmount() {
		return gewaRetAmount;
	}

	public void setGewaRetAmount(Integer gewaRetAmount) {
		this.gewaRetAmount = gewaRetAmount;
	}

	public String getRetback() {
		return retback;
	}

	public void setRetback(String retback) {
		this.retback = retback;
	}

	public Long getApplyuser() {
		return applyuser;
	}

	public void setApplyuser(Long applyuser) {
		this.applyuser = applyuser;
	}

	public String getApplyinfo() {
		return applyinfo;
	}

	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getRefundtime() {
		return refundtime;
	}

	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDealuser() {
		return dealuser;
	}
	public void setDealuser(Long dealuser) {
		this.dealuser = dealuser;
	}
	public String getDealinfo() {
		return dealinfo;
	}

	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}
	
	public Long getBatch() {
		return batch;
	}
	
	public void setBatch(Long batch) {
		this.batch = batch;
	}

}
