package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class BaseMemberVo extends BaseVo{
	private static final long serialVersionUID = 7900654577749680105L;
	protected Long id;
	protected String nickname;
	protected String headpic;				//用户logo
	protected String sex;					//性别
	protected String source;
	protected Integer pointvalue;				//积分
	protected String otherinfo;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	protected Timestamp addtime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return nickname;
	}
	public Long getMemberid() {
		return id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public Integer getPointvalue() {
		return pointvalue;
	}
	public void setPointvalue(Integer pointvalue) {
		this.pointvalue = pointvalue;
	}
	@Override
	public Serializable realId() {
		return id;
	}			
	
}
