package com.gewara.mall.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class VendorVo extends BaseVo{

	/**
	 * 供应商
	 */
	private static final long serialVersionUID = 5944928545021109753L;

	private Long id;
	private String vendorCode;
	private String vendorName;
	private String contactPerson;
	private String mobile;
	private String telephone;
	private String address;
	private String zip;
	private Timestamp addTime;        			//创建时间
	
	public VendorVo(){
		
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

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
}
