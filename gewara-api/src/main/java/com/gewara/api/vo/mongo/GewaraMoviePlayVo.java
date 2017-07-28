/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mongo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.List;

public class GewaraMoviePlayVo extends BaseVo {
	private static final long serialVersionUID = -5676159088294979451L;
	private String _id;
	private String title;
	private String content;
	private String h5url;
	private String startTime;
	private String endTime;
	private String movieIdList;
	private List<String> cityList;
	private Integer orderSort;
	private String pattern;
	private String singularpattern;
	private String oneword;
	private String advlogo;
	private String logourl;

	public Serializable realId() {
		return this._id;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getH5url() {
		return this.h5url;
	}

	public void setH5url(String h5url) {
		this.h5url = h5url;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMovieIdList() {
		return this.movieIdList;
	}

	public void setMovieIdList(String movieIdList) {
		this.movieIdList = movieIdList;
	}

	public List<String> getCityList() {
		return this.cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public Integer getOrderSort() {
		return this.orderSort;
	}

	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}

	public String getPattern() {
		return this.pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getSingularpattern() {
		return this.singularpattern;
	}

	public void setSingularpattern(String singularpattern) {
		this.singularpattern = singularpattern;
	}

	public String getOneword() {
		return this.oneword;
	}

	public void setOneword(String oneword) {
		this.oneword = oneword;
	}

	public String getAdvlogo() {
		return this.advlogo;
	}

	public void setAdvlogo(String advlogo) {
		this.advlogo = advlogo;
	}

	public String getLogourl() {
		return this.logourl;
	}

	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}
}