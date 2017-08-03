package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
public class OurPlayMovieVo  extends BaseVo{
	private static final long serialVersionUID = -8678097443317181445L;
	private Long movieId; //Ö÷¼ü µçÓ°id
	private Timestamp addTime;
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	@Override
	public Serializable realId() {
		return movieId;
	}
}
