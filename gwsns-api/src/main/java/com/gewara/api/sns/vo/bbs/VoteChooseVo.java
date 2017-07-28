/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class VoteChooseVo extends BaseVo {
	private static final long serialVersionUID = -5224752838982070278L;
	private Long id;
	private Long optionid;
	private Long diaryid;
	private Long memberid;
	private Timestamp addtime;

	public VoteChooseVo() {
	}

	public VoteChooseVo(Long memberid) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.memberid = memberid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Long optionid) {
		this.optionid = optionid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getDiaryid() {
		return this.diaryid;
	}

	public void setDiaryid(Long diaryid) {
		this.diaryid = diaryid;
	}
}