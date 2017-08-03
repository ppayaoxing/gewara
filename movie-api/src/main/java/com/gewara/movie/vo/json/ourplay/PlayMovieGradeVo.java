package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;


public class PlayMovieGradeVo extends BaseVo {
	private static final long serialVersionUID = 4067709411833539664L;
	private Long movieId;	   //电影id 主键
	private String gradeValue; //积分值
	private String status;     //是否启用
	private Timestamp addTime; //添加时间
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public Serializable realId() {
		return this.movieId;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	

}
