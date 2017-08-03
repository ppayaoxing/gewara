package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;


public class DramaRemoteOrderVo extends BaseVo {
	private static final long serialVersionUID = -318165413477507019L;
	private Long orderid;			//与GewaOrder共用ID
	private String serial;			//当前流水号
	private String hisSerial;		//历史流水号:逗号分隔
	private Timestamp addtime;		//创建订单时间
	private Timestamp locktime;		//订单有效时间
	private String seqno;			//场次ID
	private String areaseqno;		//区域ID 逗号分隔
	private String mobile;			//用户手机号
	private String bookingId;		//远程订单ID
	private String confirmationId;	//远程订单密码
	private String tickets;			//影票号，逗号分隔
	private String seatlabel;		//下单数据：{"1233":"01:22,01:23"} (areaseq:seatline:seatrank 或  areaseq:priceseq:quantity)
	private String seatno;			//座位编号：1233:01:22,01:23 或 {"123_21":"32",}
	private String status;			//订单结果：lock、fixed、cancel...
	private String seatText;		//座位文本
	private String checkmark;		
	private String opentype;		//选座、非选座
	private String message;			//最后一次错误消息
	private String ordertype;		//订单类型，GPTBS
	private Timestamp updatetime;	//更新时间
	private String otherinfo;		//远程订单详细
	private String manual;			//Y：人工终结订单
	private String userkey;			//用户ID
	private String takemethod;
	private String realname;
	private String address;
	private String telphone;
	private String expressno;
	private String expressname;
	private String bindMobile;		//用户绑定手机号
	private String clientIp;		//客户端IP
	
	private Integer ticketnum;		//订单票数
	private Double totalfee;		//订单总金额
	private Double payfee;			//订单支付金额
	
	@Override
	public Serializable realId() {
		return orderid;
	}


	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public String getSerial() {
		return serial;
	}


	public void setSerial(String serial) {
		this.serial = serial;
	}


	public String getHisSerial() {
		return hisSerial;
	}


	public void setHisSerial(String hisSerial) {
		this.hisSerial = hisSerial;
	}


	public Timestamp getAddtime() {
		return addtime;
	}


	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}


	public Timestamp getLocktime() {
		return locktime;
	}

	public void setLocktime(Timestamp locktime) {
		this.locktime = locktime;
	}


	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getAreaseqno() {
		return areaseqno;
	}

	public void setAreaseqno(String areaseqno) {
		this.areaseqno = areaseqno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public String getSeatlabel() {
		return seatlabel;
	}


	public void setSeatlabel(String seatlabel) {
		this.seatlabel = seatlabel;
	}


	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatText() {
		return seatText;
	}

	public void setSeatText(String seatText) {
		this.seatText = seatText;
	}

	public String getCheckmark() {
		return checkmark;
	}


	public void setCheckmark(String checkmark) {
		this.checkmark = checkmark;
	}

	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public boolean hasStatus(String fixseat){
		return StringUtils.equals(this.status, fixseat);
	}
	public boolean hasManual() {
		return StringUtils.startsWith(manual, "Y");
	}
	
	public boolean hasOpentype(String type){
		if(StringUtils.isBlank(type)) return false;
		return StringUtils.equals(this.opentype, type);
	}

	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getExpressno() {
		return expressno;
	}

	public void setExpressno(String expressno) {
		this.expressno = expressno;
	}

	public String getExpressname() {
		return expressname;
	}

	public void setExpressname(String expressname) {
		this.expressname = expressname;
	}


	public String getBindMobile() {
		return bindMobile;
	}


	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
	

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}


	public Integer getTicketnum() {
		return ticketnum;
	}


	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}


	public Double getTotalfee() {
		return totalfee;
	}


	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}


	public Double getPayfee() {
		return payfee;
	}


	public void setPayfee(Double payfee) {
		this.payfee = payfee;
	}
	
}
