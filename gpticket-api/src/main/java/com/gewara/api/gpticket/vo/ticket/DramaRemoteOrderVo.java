/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DramaRemoteOrderVo extends BaseVo {
	private static final long serialVersionUID = -318165413477507019L;
	private Long orderid;
	private String serial;
	private String hisSerial;
	private Timestamp addtime;
	private Timestamp locktime;
	private String seqno;
	private String areaseqno;
	private String mobile;
	private String bookingId;
	private String confirmationId;
	private String tickets;
	private String seatlabel;
	private String seatno;
	private String status;
	private String seatText;
	private String checkmark;
	private String opentype;
	private String message;
	private String ordertype;
	private Timestamp updatetime;
	private String otherinfo;
	private String manual;
	private String userkey;
	private String takemethod;
	private String realname;
	private String address;
	private String telphone;
	private String expressno;
	private String expressname;
	private String bindMobile;
	private String clientIp;
	private Integer ticketnum;
	private Double totalfee;
	private Double payfee;

	public Serializable realId() {
		return this.orderid;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getHisSerial() {
		return this.hisSerial;
	}

	public void setHisSerial(String hisSerial) {
		this.hisSerial = hisSerial;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getLocktime() {
		return this.locktime;
	}

	public void setLocktime(Timestamp locktime) {
		this.locktime = locktime;
	}

	public String getSeqno() {
		return this.seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getAreaseqno() {
		return this.areaseqno;
	}

	public void setAreaseqno(String areaseqno) {
		this.areaseqno = areaseqno;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getConfirmationId() {
		return this.confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getTickets() {
		return this.tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public String getSeatlabel() {
		return this.seatlabel;
	}

	public void setSeatlabel(String seatlabel) {
		this.seatlabel = seatlabel;
	}

	public String getSeatno() {
		return this.seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatText() {
		return this.seatText;
	}

	public void setSeatText(String seatText) {
		this.seatText = seatText;
	}

	public String getCheckmark() {
		return this.checkmark;
	}

	public void setCheckmark(String checkmark) {
		this.checkmark = checkmark;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getManual() {
		return this.manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public boolean hasStatus(String fixseat) {
		return StringUtils.equals(this.status, fixseat);
	}

	public boolean hasManual() {
		return StringUtils.startsWith(this.manual, "Y");
	}

	public boolean hasOpentype(String type) {
		return StringUtils.isBlank(type) ? false : StringUtils.equals(this.opentype, type);
	}

	public String getUserkey() {
		return this.userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getExpressno() {
		return this.expressno;
	}

	public void setExpressno(String expressno) {
		this.expressno = expressno;
	}

	public String getExpressname() {
		return this.expressname;
	}

	public void setExpressname(String expressname) {
		this.expressname = expressname;
	}

	public String getBindMobile() {
		return this.bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}

	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public Integer getTicketnum() {
		return this.ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}

	public Double getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public Double getPayfee() {
		return this.payfee;
	}

	public void setPayfee(Double payfee) {
		this.payfee = payfee;
	}
}