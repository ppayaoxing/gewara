/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.filmfest;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class FilmfestMovieVo extends BaseVo {
	private static final long serialVersionUID = 3937193844172039215L;
	private Long id;
	private Long movieid;
	private String movieName;
	private Integer orderNumber;
	private Long kindId;
	private Long belongToId;

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

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getKindId() {
		return this.kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public Long getBelongToId() {
		return this.belongToId;
	}

	public void setBelongToId(Long belongToId) {
		this.belongToId = belongToId;
	}
}