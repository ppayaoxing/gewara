/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class MemberVo extends BaseVo {
	private static final long serialVersionUID = -5010141453720441090L;
	private Long id;
	private String nickname;
	private String email;
	private String mobile;
	private String rejected;
	private String bindStatus;
	private String headpicUrl;
	private Timestamp addtime;
	private long lastLoginTime;
	private String needValid;
	private String memberEncode;
	private String gewara_uskey_;

	public String getNeedValid() {
		return this.needValid;
	}

	public void setNeedValid(String needValid) {
		this.needValid = needValid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getRejected() {
		return this.rejected;
	}

	public void setRejected(String rejected) {
		this.rejected = rejected;
	}

	public String getBindStatus() {
		return this.bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	public String getHeadpicUrl() {
		return this.headpicUrl;
	}

	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public void setGewara_uskey_(String gewara_uskey_) {
		this.gewara_uskey_ = gewara_uskey_;
	}

	public String getHeadpic() {
		return this.headpicUrl;
	}

	public String gainMemberEncodeOrSessid() {
		return StringUtils.isNotBlank(this.memberEncode) ? this.memberEncode : this.gewara_uskey_;
	}

	public boolean isEnabled() {
		return "N".equals(this.rejected);
	}

	public boolean isBindMobile() {
		return StringUtils.isNotBlank(this.mobile) && StringUtils.startsWith(this.bindStatus, "Y");
	}
}