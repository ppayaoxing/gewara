/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;

public class MovieTierPriceVo extends BaseVo {
	private static final long serialVersionUID = 7000800806805382097L;
	private Long id;
	private Long movieid;
	private String type;
	private Timestamp addtime;
	private Integer edition3D;
	private Integer price;
	private Integer editionJumu;
	private Integer editionIMAX;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer rangeEdition3D;
	private Integer rangePrice;
	private Integer rangeEditionJumu;
	private Integer rangeEditionIMAX;

	public MovieTierPriceVo() {
	}

	public MovieTierPriceVo(Long movieid, String type, Integer price) {
		this.movieid = movieid;
		this.type = type;
		this.price = price;
		this.addtime = DateUtil.getCurFullTimestamp();
	}

	public MovieTierPriceVo(Long movieid, String type) {
		this.movieid = movieid;
		this.type = type;
		this.addtime = DateUtil.getCurFullTimestamp();
	}

	public Serializable realId() {
		return this.id;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getEdition3D() {
		return this.edition3D;
	}

	public void setEdition3D(Integer edition3D) {
		this.edition3D = edition3D;
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
}