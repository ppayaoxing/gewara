package com.gewara.ucenter.vo.member;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class WeixinUserVo extends BaseVo{
	private static final long serialVersionUID = -8245027841331253158L;
	private String openid;
	private String nickname;
	private String sex;
	private String headpic; 
	private String bindGewa;
	private String bindGewaMobile;
	private String bindGewaNickname;
	private String unionid;
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	public String getBindGewa() {
		return bindGewa;
	}
	public void setBindGewa(String bindGewa) {
		this.bindGewa = bindGewa;
	}
	public String getBindGewaMobile() {
		return bindGewaMobile;
	}
	public void setBindGewaMobile(String bindGewaMobile) {
		this.bindGewaMobile = bindGewaMobile;
	}
	public String getBindGewaNickname() {
		return bindGewaNickname;
	}
	public void setBindGewaNickname(String bindGewaNickname) {
		this.bindGewaNickname = bindGewaNickname;
	}
	@Override
	public Serializable realId() {
		return openid;
	}
}
