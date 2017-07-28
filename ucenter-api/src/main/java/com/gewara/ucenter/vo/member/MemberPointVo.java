/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.ucenter.vo.member.MemberPointTypeVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MemberPointVo extends BaseVo {
	private static final long serialVersionUID = 2495173855721498326L;
	private Long memberid;
	private Long id;
	private Integer pointvalue = Integer.valueOf(0);
	private String pointtype;
	private Timestamp pointtime;
	private String pointstatus;
	private String tips;
	private String pointinfo;
	private List<MemberPointTypeVo> pointTypeList = new ArrayList();
	private String reason;
	private Integer point;
	private Timestamp addtime;
	private String nickname;
	private String headpic;
	private String remark;
	private String tag;
	private Integer continunum;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPointvalue() {
		return this.pointvalue;
	}

	public void setPointvalue(Integer pointvalue) {
		this.pointvalue = pointvalue;
	}

	public String getPointtype() {
		return this.pointtype;
	}

	public void setPointtype(String pointtype) {
		this.pointtype = pointtype;
	}

	public Timestamp getPointtime() {
		return this.pointtime;
	}

	public void setPointtime(Timestamp pointtime) {
		this.pointtime = pointtime;
	}

	public String getPointstatus() {
		return this.pointstatus;
	}

	public void setPointstatus(String pointstatus) {
		this.pointstatus = pointstatus;
	}

	public String getTips() {
		return this.tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getPointinfo() {
		return this.pointinfo;
	}

	public void setPointinfo(String pointinfo) {
		this.pointinfo = pointinfo;
	}

	public List<MemberPointTypeVo> getPointTypeList() {
		return this.pointTypeList;
	}

	public void setPointTypeList(List<MemberPointTypeVo> pointTypeList) {
		this.pointTypeList = pointTypeList;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getContinunum() {
		return this.continunum;
	}

	public void setContinunum(Integer continunum) {
		this.continunum = continunum;
	}

	public Serializable realId() {
		return this.id;
	}
}