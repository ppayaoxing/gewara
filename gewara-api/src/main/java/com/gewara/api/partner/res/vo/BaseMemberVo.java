/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BaseMemberVo extends BaseVo {
	private static final long serialVersionUID = 7900654577749680105L;
	protected Long id;
	protected String nickname;
	protected String headpic;
	protected String sex;
	protected String source;
	protected Integer pointvalue;
	protected String otherinfo;
	protected Timestamp addtime;

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.nickname;
	}

	public Long getMemberid() {
		return this.id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadpic() {
		return this.headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Integer getPointvalue() {
		return this.pointvalue;
	}

	public void setPointvalue(Integer pointvalue) {
		this.pointvalue = pointvalue;
	}

	public Serializable realId() {
		return this.id;
	}
}