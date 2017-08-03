package com.gewara.drama.vo.partner.req;

import java.io.Serializable;

public class UserAddressReqVo implements Serializable {

	private static final long serialVersionUID = 7701780568323034201L;
	private Long memberid;
	private String realname;
	private String address;
	private String postalcode;
	private String mobile;
	private String provincecode;
	private String provincename;
	private String citycode;
	private String cityname;
	private String countycode;
	private String countyname;
	
	public UserAddressReqVo(){
	}
	
	public UserAddressReqVo(Long memberid, String realname, String address, String postalcode){
		this.memberid = memberid;
		this.realname = realname;
		this.address = address;
		this.postalcode = postalcode;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
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
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProvincecode() {
		return provincecode;
	}
	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	

	


}
