/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class DiaryCommentVo extends BaseVo {
	private static final long serialVersionUID = 4476980910614491968L;
	private Long id;
	private Long memberid;
	private Long diaryid;
	private String body;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String status;
	private String citycode;
	private String ip;

	public DiaryCommentVo() {
	}

	public DiaryCommentVo(Long memberid) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.addtime;
		this.status = "Y_NEW";
		this.memberid = memberid;
	}

	public DiaryCommentVo(Long diaryid, Long memberid, String body) {
		this(memberid);
		this.diaryid = diaryid;
		this.body = body;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getDiaryid() {
		return this.diaryid;
	}

	public void setDiaryid(Long diaryid) {
		this.diaryid = diaryid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}