/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class OrderCommandVo implements Serializable {
	private static final long serialVersionUID = -3829651039853670498L;
	private String takemethod;
	private String citycode;
	private String realname;
	private String telphone;
	private String address;
	private String seqno;
	private String mobile;
	private Long orderid;
	private String areaseqno;
	private String opentype;
	private String greetings;
	private String seatLabel;
	private String usertype;
	private String bindMobile;
	private Integer ticketnum;
	private Double totalfee;
	private Double payfee;
	private String checkpass;
	private String idnumber;
	private Long configid;
	private String clientIp;

	public OrderCommandVo(String seqno, Long orderid, String mobile, String areaseqno, String opentype,
			String seatLabel) {
		this.seqno = seqno;
		this.orderid = orderid;
		this.mobile = mobile;
		this.areaseqno = areaseqno;
		this.opentype = opentype;
		this.seatLabel = seatLabel;
	}

	public OrderCommandVo(String seqno, Long orderid, String mobile, String areaseqno, String opentype,
			String seatLabel, String usertype) {
		this(seqno, orderid, mobile, areaseqno, opentype, seatLabel);
		this.usertype = usertype;
	}

	public String getSeqno() {
		return this.seqno;
	}

	public String getMobile() {
		return this.mobile;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public String getAreaseqno() {
		return this.areaseqno;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public String getSeatLabel() {
		return this.seatLabel;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public String getGreetings() {
		return this.greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public boolean hasOpentype(String type) {
		return StringUtils.isBlank(type) ? false : StringUtils.equals(this.opentype, type);
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
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

	public String getBindMobile() {
		return this.bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
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

	public String getCheckpass() {
		return this.checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Long getConfigid() {
		return this.configid;
	}

	public void setConfigid(Long configid) {
		this.configid = configid;
	}

	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
}