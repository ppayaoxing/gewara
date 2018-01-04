package com.gewara.api.vo.mongo;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class GewaraMoviePlayVo extends BaseVo{

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
	private String pattern;//模式，单片或者影展 单片只能有一部电影，影展可以有3部
	private String singularpattern;//单片模式：点映还是招募
	private String oneword;//一句话点评
	private String advlogo;//上传单片的横幅海报
	private String logourl;//电影海报的URL
	
	@Override
	public Serializable realId() {
		return _id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getH5url() {
		return h5url;
	}

	public void setH5url(String h5url) {
		this.h5url = h5url;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMovieIdList() {
		return movieIdList;
	}

	public void setMovieIdList(String movieIdList) {
		this.movieIdList = movieIdList;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public Integer getOrderSort() {
		return orderSort;
	}

	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getSingularpattern() {
		return singularpattern;
	}

	public void setSingularpattern(String singularpattern) {
		this.singularpattern = singularpattern;
	}

	public String getOneword() {
		return oneword;
	}

	public void setOneword(String oneword) {
		this.oneword = oneword;
	}

	public String getAdvlogo() {
		return advlogo;
	}

	public void setAdvlogo(String advlogo) {
		this.advlogo = advlogo;
	}

	public String getLogourl() {
		return logourl;
	}

	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}

}
