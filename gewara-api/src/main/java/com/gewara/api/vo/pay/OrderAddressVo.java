/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAddressVo extends BaseVo {
	private static final long serialVersionUID = -8227413676440639244L;
	private String tradeno;
	private Long usefulAddressId;
	private String realname;
	private String postalcode;
	private Timestamp addtime;
	private Long memberid;
	private String mobile;
	private String provincecode;
	private String provincename;
	private String citycode;
	private String cityname;
	private String countycode;
	private String countyname;
	private String expresstype;
	private String address;

	public Serializable realId() {
		return this.tradeno;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvincecode() {
		return this.provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getCountyname() {
		return this.countyname;
	}

	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}

	public String getExpresstype() {
		return this.expresstype;
	}

	public void setExpresstype(String expresstype) {
		this.expresstype = expresstype;
	}

	public Long getUsefulAddressId() {
		return this.usefulAddressId;
	}

	public void setUsefulAddressId(Long usefulAddressId) {
		this.usefulAddressId = usefulAddressId;
	}

	public String gainAddress() {
		return this.provincename + " " + this.cityname + " " + this.countyname + " " + this.address;
	}
}