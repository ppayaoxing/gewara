/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class VoteOptionVo extends BaseVo {
	private static final long serialVersionUID = -5224752838982070278L;
	private Long id;
	private String option;
	private Long diaryid;
	private Integer selectednum;
	private Boolean iscorrect;

	public VoteOptionVo() {
	}

	public VoteOptionVo(String option) {
		this.selectednum = Integer.valueOf(0);
		this.iscorrect = Boolean.valueOf(false);
		this.option = option;
	}

	public VoteOptionVo(String option, Long diaryid) {
		this(option);
		this.diaryid = diaryid;
	}

	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Integer getSelectednum() {
		return this.selectednum;
	}

	public void setSelectednum(Integer selectednum) {
		this.selectednum = selectednum;
	}

	public Boolean getIscorrect() {
		return this.iscorrect;
	}

	public void setIscorrect(Boolean iscorrect) {
		this.iscorrect = iscorrect;
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

	public void addSelelctednum() {
		Integer arg1 = this.selectednum;
		Integer arg2 = this.selectednum = Integer.valueOf(this.selectednum.intValue() + 1);
	}

	public Long getDiaryid() {
		return this.diaryid;
	}

	public void setDiaryid(Long diaryid) {
		this.diaryid = diaryid;
	}
}