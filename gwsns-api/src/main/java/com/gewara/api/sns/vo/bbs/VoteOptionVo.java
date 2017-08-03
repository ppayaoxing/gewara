package com.gewara.api.sns.vo.bbs;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class VoteOptionVo extends BaseVo{
	private static final long serialVersionUID = -5224752838982070278L;
	private Long id;
	private String option;
	private Long diaryid;
	private Integer selectednum;
	private Boolean iscorrect;

	public VoteOptionVo() {}
	
	public VoteOptionVo(String option){
		this.selectednum = 0;
		this.iscorrect = false;
		this.option = option;
	}
	public VoteOptionVo(String option, Long diaryid){
		this(option);
		this.diaryid = diaryid;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	public Integer getSelectednum() {
		return selectednum;
	}
	public void setSelectednum(Integer selectednum) {
		this.selectednum = selectednum;
	}
	public Boolean getIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(Boolean iscorrect) {
		this.iscorrect = iscorrect;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public void addSelelctednum(){
		this.selectednum++;
	}
	public Long getDiaryid() {
		return diaryid;
	}
	public void setDiaryid(Long diaryid) {
		this.diaryid = diaryid;
	}
}
