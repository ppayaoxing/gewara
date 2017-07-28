/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MoviePriceVo extends BaseVo {
	private static final long serialVersionUID = -2432793126595408229L;
	private Long id;
	private Long movieid;
	private Integer price;
	private String citycode;
	private String type;
	private Integer edition3D;
	private Integer editionJumu;
	private Integer editionIMAX;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer rangeEdition3D;
	private Integer rangePrice;
	private Integer rangeEditionJumu;
	private Integer rangeEditionIMAX;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Long cinemaid;

	public Serializable realId() {
		return this.id;
	}

	public MoviePriceVo() {
	}

	public MoviePriceVo(Long movieid, Integer price, String citycode) {
		this.movieid = movieid;
		this.price = price;
		this.citycode = citycode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEdition3D() {
		return this.edition3D;
	}

	public void setEdition3D(Integer edition3d) {
		this.edition3D = edition3d;
	}

	public Integer getEditionJumu() {
		return this.editionJumu;
	}

	public void setEditionJumu(Integer editionJumu) {
		this.editionJumu = editionJumu;
	}

	public Integer getEditionIMAX() {
		return this.editionIMAX;
	}

	public void setEditionIMAX(Integer editionIMAX) {
		this.editionIMAX = editionIMAX;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getRangeEdition3D() {
		return this.rangeEdition3D;
	}

	public void setRangeEdition3D(Integer rangeEdition3D) {
		this.rangeEdition3D = rangeEdition3D;
	}

	public Integer getRangePrice() {
		return this.rangePrice;
	}

	public void setRangePrice(Integer rangePrice) {
		this.rangePrice = rangePrice;
	}

	public Integer getRangeEditionJumu() {
		return this.rangeEditionJumu;
	}

	public void setRangeEditionJumu(Integer rangeEditionJumu) {
		this.rangeEditionJumu = rangeEditionJumu;
	}

	public Integer getRangeEditionIMAX() {
		return this.rangeEditionIMAX;
	}

	public void setRangeEditionIMAX(Integer rangeEditionIMAX) {
		this.rangeEditionIMAX = rangeEditionIMAX;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
}