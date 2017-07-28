/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class OrderRefundVo extends BaseVo {
	private static final long serialVersionUID = 6029378080103301843L;
	private Long id;
	private Integer version;
	private String tradeno;
	private String ordertype;
	private Long placeid;
	private Long memberid;
	private String mobile;
	private String orderstatus;
	private String refundtype;
	private Long partnerid;
	private Timestamp expiretime;
	private Integer gewaRetAmount;
	private Integer merRetAmount;
	private Integer oldSettle;
	private Integer newSettle;
	private String settletype;
	private String cardno;
	private String opmark;
	private String reason;
	private String retback;
	private Long applyuser;
	private String applyinfo;
	private String otherinfo;
	private Timestamp addtime;
	private Timestamp refundtime;
	private String status;
	private String dealinfo;
	private String preinfo;
	private String cancelinfo;
	private String origin;
	private String reasoninfo;
	private String ticketRefund;

	public Serializable realId() {
		return this.id;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return this.status;
	}

	public String getTicketRefund() {
		return this.ticketRefund;
	}

	public void setTicketRefund(String ticketRefund) {
		this.ticketRefund = ticketRefund;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOpmark() {
		return this.opmark;
	}

	public void setOpmark(String opmark) {
		this.opmark = opmark;
	}

	public String getRetback() {
		return this.retback;
	}

	public void setRetback(String retback) {
		this.retback = retback;
	}

	public Integer getGewaRetAmount() {
		return this.gewaRetAmount;
	}

	public void setGewaRetAmount(Integer gewaRetAmount) {
		this.gewaRetAmount = gewaRetAmount;
	}

	public Integer getMerRetAmount() {
		return this.merRetAmount;
	}

	public void setMerRetAmount(Integer merRetAmount) {
		this.merRetAmount = merRetAmount;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public String getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Timestamp getRefundtime() {
		return this.refundtime;
	}

	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}

	public Long getApplyuser() {
		return this.applyuser;
	}

	public void setApplyuser(Long applyuser) {
		this.applyuser = applyuser;
	}

	public String getRefundtype() {
		return this.refundtype;
	}

	public void setRefundtype(String refundtype) {
		this.refundtype = refundtype;
	}

	public String getApplyinfo() {
		return this.applyinfo;
	}

	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}

	public String getDealinfo() {
		return this.dealinfo;
	}

	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}

	public Timestamp getExpiretime() {
		return this.expiretime;
	}

	public void setExpiretime(Timestamp expiretime) {
		this.expiretime = expiretime;
	}

	public boolean gainExpired() {
		return this.expiretime != null && this.expiretime.before(new Timestamp(System.currentTimeMillis()));
	}

	public String getPreinfo() {
		return this.preinfo;
	}

	public void setPreinfo(String preinfo) {
		this.preinfo = preinfo;
	}

	public String getCancelinfo() {
		return this.cancelinfo;
	}

	public void setCancelinfo(String cancelinfo) {
		this.cancelinfo = cancelinfo;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getOldSettle() {
		return this.oldSettle;
	}

	public void setOldSettle(Integer oldSettle) {
		this.oldSettle = oldSettle;
	}

	public Integer getNewSettle() {
		return this.newSettle;
	}

	public void setNewSettle(Integer newSettle) {
		this.newSettle = newSettle;
	}

	public String getSettletype() {
		return this.settletype;
	}

	public void setSettletype(String settletype) {
		this.settletype = settletype;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getRefundStatusText() {
		return !StringUtils.equals(this.status, "finish") && !StringUtils.equals(this.status, "success")
				? (!StringUtils.equals(this.status, "reject") && !StringUtils.equals(this.status, "user_reject")
						? "退款处理中" : "退款失败")
				: "已退款";
	}

	public boolean hasRefundTimeout() {
		double diffMinu = DateUtil.getDiffMinu(DateUtil.getCurFullTimestamp(), this.addtime);
		return diffMinu > 10.0D;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getReasoninfo() {
		return this.reasoninfo;
	}

	public void setReasoninfo(String reasoninfo) {
		this.reasoninfo = reasoninfo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}