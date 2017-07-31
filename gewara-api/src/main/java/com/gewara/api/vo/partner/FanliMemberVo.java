package com.gewara.api.vo.partner;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class FanliMemberVo extends BaseVo {
	private static final long serialVersionUID = -7934071223394226183L;
	private Long _id;
	private String uid ;//返利网会员编号
	private String channel_id;//渠道编码
	private String tracking_code;//效果追踪识别码
	private String username;//联合登陆的用户名
	private String usersafekey;//联合登录验证码
	private String email;//用户email
	private String show_name;//用户昵称
	private String province;//省
	private String city;//市
	private String area;//区
	private String zip;//邮编
	private String phone;//电话
	private String mobile;//手机
	private String name;
	private String address;
	private Long createTime;//创建时间
	private Long updateTIme;//最后更新时间
	
	public FanliMemberVo() {
		super();
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getTracking_code() {
		return tracking_code;
	}
	public void setTracking_code(String tracking_code) {
		this.tracking_code = tracking_code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersafekey() {
		return usersafekey;
	}
	public void setUsersafekey(String usersafekey) {
		this.usersafekey = usersafekey;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateTIme() {
		return updateTIme;
	}
	public void setUpdateTIme(Long updateTime) {
		this.updateTIme = updateTime;
	}
	public Object get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	@Override
	public Serializable realId() {
		return this._id;
	}
	
}
