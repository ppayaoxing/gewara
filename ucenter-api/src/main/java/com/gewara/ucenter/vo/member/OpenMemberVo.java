package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OpenMemberVo extends BaseVo {

	private static final long serialVersionUID = 8774133904980152319L;

	private Long id;
	private Long memberid;			//绑定的用户
	private String loginname;		//登录名：Email、mobile等
	private String source;			//来源
	private String category;		//小类 比如支付宝：分为快捷登录和钱包
	private String nickname;		//第三方用户的昵称
	private String headpic;
	private String otherinfo;		//其他数据
	private Long relateid;			//当前同步用户ID
	private String mobile;			//仅对支付宝联名登录用户起作用
	private Timestamp validtime;	//有效时间
	private String unionid;
	
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

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

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Long getRelateid() {
		return relateid;
	}

	public void setRelateid(Long relateid) {
		this.relateid = relateid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
}
