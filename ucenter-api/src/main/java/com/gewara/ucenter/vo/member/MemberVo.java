/**
 * 
 */
package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.ucenter.constant.MemberConstant;

/**
 * @author hxs(ncng_2006@hotmail.com)
 * @since Jan 27, 2010 10:18:24 AM
 */
public class MemberVo extends BaseVo{
	private static final long serialVersionUID = -5010141453720441090L;
	private Long id;
	private String nickname;
	private String email;
	private String mobile;
	private String rejected;
	private String bindStatus;		
	private String headpicUrl;
	private Timestamp addtime;
	private long lastLoginTime; //用户最后登录时间戳
	private String needValid;	//黄牛可能性：Y 需要短信回复验证，N：不需要验证，U：暂不需要验证
	private String memberEncode;
	private String gewara_uskey_;
	
	public String getNeedValid() {
		return needValid;
	}

	public void setNeedValid(String needValid) {
		this.needValid = needValid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public String getRejected() {
		return rejected;
	}

	public void setRejected(String rejected) {
		this.rejected = rejected;
	}

	public String getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	public String getHeadpicUrl() {
		return headpicUrl;
	}

	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
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
	public String getHeadpic(){
		return headpicUrl;
	}

	public String gainMemberEncodeOrSessid(){
		if(StringUtils.isNotBlank(memberEncode)){
			return memberEncode;
		}else{
			return gewara_uskey_;
		}
	}
	
	public boolean isEnabled() {
		return "N".equals(rejected);
	}
	
	public boolean isBindMobile(){
		return StringUtils.isNotBlank(mobile) && StringUtils.startsWith(bindStatus, MemberConstant.BINDMOBILE_STATUS_Y);
	}
}
