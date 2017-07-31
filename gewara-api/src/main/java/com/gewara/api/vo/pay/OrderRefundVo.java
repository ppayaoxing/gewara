/**
 * 
 */
package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
/**
 * 订单退款
 * @author gebiao(ge.biao@gewara.com)
 * @since Aug 20, 2012 4:43:34 PM
 */
public class OrderRefundVo extends BaseVo {
	private static final long serialVersionUID = 6029378080103301843L;
	private Long id;
	private Integer version;			//版本
	private String tradeno;				//订单号
	private String ordertype;			//订单类型
	private Long placeid;				//场馆ID
	private Long memberid;				//用户ID
	private String mobile;				//手机号
	private String orderstatus;			//状态类型：paid_failure: 待处理订单  paid_success: 成交订单 paid_failure_unfix: 座位待处理
	private String refundtype;			//退款类型：unknown, all 全额退款：part 部分退款：supplement 增补
	private Long partnerid;				//合作商家
	private Timestamp expiretime;		//订单过期时间
	
	private Integer gewaRetAmount;		//Gewara退款
	private Integer merRetAmount;		//商家退款

	private Integer oldSettle;			//原结算金额
	private Integer newSettle;			//新结算金额
	private String settletype;			//结算类型
	private String cardno;				//补偿券号
	
	private String opmark;				//操作标识：记录需要或完成的操作
	private String reason;				//原因
	private String retback;				//是否要原路返回：Y：需要，N：不需要，O：未知, 参见描述(Other)，S: 已提交账务(Submit) R：财务已经返还(Refund)，F：财务返还出错(Failure)
	private Long applyuser;				//申请人
	private String applyinfo;			//申请信息
	
	private String otherinfo;			//其他信息：处理人，财务返回信息
	
	
	//结算方式
	private Timestamp addtime;			//增加日期
	private Timestamp refundtime; 		//退款时间
	private String status;				//状态
	private String dealinfo;			//处理信息

	private String preinfo;				//预处理要求
	private String cancelinfo;			//中断理由
	
	private String origin;				//来源   user：用户   kf：客服 
	private String reasoninfo;			//如果是用户退款，记录用户退款原因	
	
	private String ticketRefund;		//退票类型
	
	public OrderRefundVo(){}

	@Override
	public Serializable realId() {
		return id;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public String getTicketRefund() {
		return ticketRefund;
	}

	public void setTicketRefund(String ticketRefund) {
		this.ticketRefund = ticketRefund;
	}

	public void setStatus(String status) {
		this.status = status;
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
	public String getOpmark() {
		return opmark;
	}
	public void setOpmark(String opmark) {
		this.opmark = opmark;
	}
	public String getRetback() {
		return retback;
	}
	public void setRetback(String retback) {
		this.retback = retback;
	}
	public Integer getGewaRetAmount() {
		return gewaRetAmount;
	}
	public void setGewaRetAmount(Integer gewaRetAmount) {
		this.gewaRetAmount = gewaRetAmount;
	}
	public Integer getMerRetAmount() {
		return merRetAmount;
	}
	public void setMerRetAmount(Integer merRetAmount) {
		this.merRetAmount = merRetAmount;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Long getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Timestamp getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}
	public Long getApplyuser() {
		return applyuser;
	}
	public void setApplyuser(Long applyuser) {
		this.applyuser = applyuser;
	}
	public String getRefundtype() {
		return refundtype;
	}
	public void setRefundtype(String refundtype) {
		this.refundtype = refundtype;
	}
	public String getApplyinfo() {
		return applyinfo;
	}
	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}
	public String getDealinfo() {
		return dealinfo;
	}
	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}
	public Timestamp getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(Timestamp expiretime) {
		this.expiretime = expiretime;
	}
	public boolean gainExpired(){//是过期订单
		return expiretime != null && expiretime.before(new Timestamp(System.currentTimeMillis())); 
	}
	public String getPreinfo() {
		return preinfo;
	}
	public void setPreinfo(String preinfo) {
		this.preinfo = preinfo;
	}
	public String getCancelinfo() {
		return cancelinfo;
	}
	public void setCancelinfo(String cancelinfo) {
		this.cancelinfo = cancelinfo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getOldSettle() {
		return oldSettle;
	}
	public void setOldSettle(Integer oldSettle) {
		this.oldSettle = oldSettle;
	}
	public Integer getNewSettle() {
		return newSettle;
	}
	public void setNewSettle(Integer newSettle) {
		this.newSettle = newSettle;
	}
	public String getSettletype() {
		return settletype;
	}
	public void setSettletype(String settletype) {
		this.settletype = settletype;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public Long getPlaceid() {
		return placeid;
	}
	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}
	/*public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}*/
	public String getRefundStatusText(){
		if(StringUtils.equals(status, "finish") || StringUtils.equals(status, "success")){
			return "已退款";
		}else if(StringUtils.equals(status, "reject") || StringUtils.equals(status, "user_reject")){
			return "退款失败";
		}else{
			return "退款处理中";
		}
	}	
	
	public boolean hasRefundTimeout(){
		double diffMinu = DateUtil.getDiffMinu(DateUtil.getCurFullTimestamp(), addtime);
		return diffMinu > 10;
	}
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getReasoninfo() {
		return reasoninfo;
	}

	public void setReasoninfo(String reasoninfo) {
		this.reasoninfo = reasoninfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
}
