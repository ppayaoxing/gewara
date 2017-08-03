package com.gewara.movie.vo.filmfest;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
public class FilmfestMovieVo extends BaseVo {
	private static final long serialVersionUID = 3937193844172039215L;
	private Long id;
	private Long movieid;
	private String movieName;
	private Integer orderNumber;
	private Long kindId;
	private Long belongToId;
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMovieid() {
		return movieid;
	}
	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getKindId() {
		return kindId;
	}
	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}
	public Long getBelongToId() {
		return belongToId;
	}
	public void setBelongToId(Long belongToId) {
		this.belongToId = belongToId;
	}

}
