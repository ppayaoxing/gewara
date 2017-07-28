/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.merchant.vo.CinemaDetailSellerVo;
import com.gewara.api.merchant.vo.MovieSellerVo;
import java.io.Serializable;
import java.util.List;

public class MovieSellerTotalVo implements Serializable {
	private static final long serialVersionUID = 4278400994817916606L;
	private List<MovieSellerVo> movieSellerVoList;
	private List<CinemaDetailSellerVo> cinemaSellerVoList;
	private Integer cinemaCount;
	private Integer movieCount;
	private Long tolalMpi;
	private Long totalQuantity;
	private Long totalOrder;
	private Long totalcost;
	private int totalCount;

	public List<MovieSellerVo> getMovieSellerVoList() {
		return this.movieSellerVoList;
	}

	public void setMovieSellerVoList(List<MovieSellerVo> movieSellerVoList) {
		this.movieSellerVoList = movieSellerVoList;
	}

	public Integer getCinemaCount() {
		return this.cinemaCount;
	}

	public void setCinemaCount(Integer cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public Integer getMovieCount() {
		return this.movieCount;
	}

	public void setMovieCount(Integer movieCount) {
		this.movieCount = movieCount;
	}

	public Long getTolalMpi() {
		return this.tolalMpi;
	}

	public void setTolalMpi(Long tolalMpi) {
		this.tolalMpi = tolalMpi;
	}

	public Long getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getTotalOrder() {
		return this.totalOrder;
	}

	public void setTotalOrder(Long totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Long getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<CinemaDetailSellerVo> getCinemaSellerVoList() {
		return this.cinemaSellerVoList;
	}

	public void setCinemaSellerVoList(List<CinemaDetailSellerVo> cinemaSellerVoList) {
		this.cinemaSellerVoList = cinemaSellerVoList;
	}
}