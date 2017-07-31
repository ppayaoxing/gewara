package com.gewara.api.merchant.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * 电影在具体城市的购票人数
 * @author user
 *
 */
public class MovieCityBoughtReportVo extends BaseVo{
	
	private Long movieId;//电影id
	
	private String citycode;//所在城市
	
	private Integer boughtCount;//购票人数
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4138365875993478768L;

	public MovieCityBoughtReportVo(){}
	
	public MovieCityBoughtReportVo(Long movieId,String citycode,Integer boughtCount){
		this.movieId = movieId;
		this.citycode = citycode;
		this.boughtCount = boughtCount;
	}
	
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getBoughtCount() {
		return boughtCount;
	}

	public void setBoughtCount(Integer boughtCount) {
		this.boughtCount = boughtCount;
	}

	@Override
	public Serializable realId() {
		return movieId + "_" + citycode;
	}

}
