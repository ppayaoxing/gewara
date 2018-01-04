package com.gewara.sso.model;

public class UserSso {
	private Long id;//用户ID
	private String username;//登录名
	private String password;//不会使用
	private String nickname;//用户姓名
	private String accountEnabled;//不会使用		
	private String citycode="";//城市名称			
	private String mobile;//手机号码				
	private String rolenames;//不会使用	
	private String usertype;//不会使用	
	private Long deptid;//部门id
	private String mail;//邮箱
	private String district;//区域
	private String station;//岗位
	public UserSso() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccountEnabled() {
		return accountEnabled;
	}
	public void setAccountEnabled(String accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRolenames() {
		return rolenames;
	}
	public void setRolenames(String rolenames) {
		this.rolenames = rolenames;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
}
