package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class OrderCommandVo implements Serializable {

	private static final long serialVersionUID = -3829651039853670498L;
	private String takemethod; // 取票方式
	private String citycode;
	private String realname; // 用户真实姓名
	private String telphone;
	private String address; // 快递地址
	private String seqno; // 场次编号
	private String mobile; // 手机号
	private Long orderid; // 订单号
	private String areaseqno; // 区域编号
	private String opentype; // 订单类型：选座、价格
	private String greetings; // 订单文字个性化
	private String seatLabel; // old interface: 座位座标 areasq:1:2,areasq:1:3 价格数据: areasq:priceid:quantity areaseq:234:5,areaseq:235:2
	// new interface: {"type":seat or price,"seatIds": "座位座标areasq:1:2,areasq:1:3价格数据areasq:priceid:quantity areaseq:234:5,areaseq:235:2",
	// "packTicketId":"套票编号","discountInfo":"折扣信息","discountTotal":""}
	private String usertype;
	private String bindMobile;
	
	private Integer ticketnum;		//订单票数
	private Double totalfee;		//订单总金额
	private Double payfee;			//订单支付金额
	private String checkpass;
	private String idnumber;		//身份证信息
	private Long configid;			//二级渠道用
	private String clientIp;		//客户端IP

	public OrderCommandVo(String seqno, Long orderid, String mobile, String areaseqno, String opentype, String seatLabel) {
		this.seqno = seqno;
		this.orderid = orderid;
		this.mobile = mobile;
		this.areaseqno = areaseqno;
		this.opentype = opentype;
		this.seatLabel = seatLabel;
	}

	public OrderCommandVo(String seqno, Long orderid, String mobile, String areaseqno, String opentype, String seatLabel, String usertype) {
		this(seqno, orderid, mobile, areaseqno, opentype, seatLabel);
		this.usertype = usertype;
	}

	public String getSeqno() {
		return seqno;
	}

	public String getMobile() {
		return mobile;
	}

	public Long getOrderid() {
		return orderid;
	}

	public String getAreaseqno() {
		return areaseqno;
	}

	public String getOpentype() {
		return opentype;
	}

	public String getSeatLabel() {
		return seatLabel;
	}

	public String getUsertype() {
		return usertype;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public boolean hasOpentype(String type) {
		if (StringUtils.isBlank(type))
			return false;
		return StringUtils.equals(this.opentype, type);
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
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

	public String getBindMobile() {
		return bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
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

	public String getCheckpass() {
		return checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Long getConfigid() {
		return configid;
	}

	public void setConfigid(Long configid) {
		this.configid = configid;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
}
