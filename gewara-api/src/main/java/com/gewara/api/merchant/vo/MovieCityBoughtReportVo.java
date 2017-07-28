/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MovieCityBoughtReportVo extends BaseVo {
	private Long movieId;
	private String citycode;
	private Integer boughtCount;
	private static final long serialVersionUID = 4138365875993478768L;

	public MovieCityBoughtReportVo() {
	}

	public MovieCityBoughtReportVo(Long movieId, String citycode, Integer boughtCount) {
		this.movieId = movieId;
		this.citycode = citycode;
		this.boughtCount = boughtCount;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getBoughtCount() {
		return this.boughtCount;
	}

	public void setBoughtCount(Integer boughtCount) {
		this.boughtCount = boughtCount;
	}

	public Serializable realId() {
		return this.movieId + "_" + this.citycode;
	}
}