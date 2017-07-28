/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class WeixinUserVo extends BaseVo {
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
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadpic() {
		return this.headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public String getBindGewa() {
		return this.bindGewa;
	}

	public void setBindGewa(String bindGewa) {
		this.bindGewa = bindGewa;
	}

	public String getBindGewaMobile() {
		return this.bindGewaMobile;
	}

	public void setBindGewaMobile(String bindGewaMobile) {
		this.bindGewaMobile = bindGewaMobile;
	}

	public String getBindGewaNickname() {
		return this.bindGewaNickname;
	}

	public void setBindGewaNickname(String bindGewaNickname) {
		this.bindGewaNickname = bindGewaNickname;
	}

	public Serializable realId() {
		return this.openid;
	}
}