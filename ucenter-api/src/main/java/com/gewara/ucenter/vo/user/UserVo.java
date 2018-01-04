package com.gewara.ucenter.vo.user;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * FIXME:remove from  ucenter
 */
public class UserVo extends BaseVo {
	private static final long serialVersionUID = 4667924164196642997L;
	private Long id;
	private String username; // required
	private String nickname;
	private String accountEnabled; // Y or N
	private String citycode;
	private String mobile;
	private String rolenames;
	private String usertype; // 用户类型：inner:内部用户，其他：外部用户
	private String email;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
