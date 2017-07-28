/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.partner;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class FanliMemberVo extends BaseVo {
	private static final long serialVersionUID = -7934071223394226183L;
	private Long _id;
	private String uid;
	private String channel_id;
	private String tracking_code;
	private String username;
	private String usersafekey;
	private String email;
	private String show_name;
	private String province;
	private String city;
	private String area;
	private String zip;
	private String phone;
	private String mobile;
	private String name;
	private String address;
	private Long createTime;
	private Long updateTIme;

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getChannel_id() {
		return this.channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getTracking_code() {
		return this.tracking_code;
	}

	public void setTracking_code(String tracking_code) {
		this.tracking_code = tracking_code;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersafekey() {
		return this.usersafekey;
	}

	public void setUsersafekey(String usersafekey) {
		this.usersafekey = usersafekey;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShow_name() {
		return this.show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTIme() {
		return this.updateTIme;
	}

	public void setUpdateTIme(Long updateTime) {
		this.updateTIme = updateTime;
	}

	public Object get_id() {
		return this._id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public Serializable realId() {
		return this._id;
	}
}