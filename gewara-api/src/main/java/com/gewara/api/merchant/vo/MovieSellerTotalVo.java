package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.util.List;

public class MovieSellerTotalVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4278400994817916606L;
	private List<MovieSellerVo> movieSellerVoList;
	private List<CinemaDetailSellerVo> cinemaSellerVoList;
	
	private Integer cinemaCount;//查询条件内影院总数
	private Integer movieCount;//影片总数
	private Long tolalMpi;//场次总数
	private Long totalQuantity;//影票总数
	private Long totalOrder;//总订单数
	private Long totalcost;//总金额
	private int totalCount;//总条数
	
	public List<MovieSellerVo> getMovieSellerVoList() {
		return movieSellerVoList;
	}
	public void setMovieSellerVoList(List<MovieSellerVo> movieSellerVoList) {
		this.movieSellerVoList = movieSellerVoList;
	}
	public Integer getCinemaCount() {
		return cinemaCount;
	}
	public void setCinemaCount(Integer cinemaCount) {
		this.cinemaCount = cinemaCount;
	}
	public Integer getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(Integer movieCount) {
		this.movieCount = movieCount;
	}
	public Long getTolalMpi() {
		return tolalMpi;
	}
	public void setTolalMpi(Long tolalMpi) {
		this.tolalMpi = tolalMpi;
	}
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Long getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Long totalOrder) {
		this.totalOrder = totalOrder;
	}
	public Long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<CinemaDetailSellerVo> getCinemaSellerVoList() {
		return cinemaSellerVoList;
	}
	public void setCinemaSellerVoList(List<CinemaDetailSellerVo> cinemaSellerVoList) {
		this.cinemaSellerVoList = cinemaSellerVoList;
	}
	
}
