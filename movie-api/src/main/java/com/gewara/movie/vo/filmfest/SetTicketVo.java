/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.filmfest;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class SetTicketVo extends BaseVo {
	private static final long serialVersionUID = 8313840001633377715L;
	private String id;
	private String filmTag;
	private String title;
	private String subtitle;
	private String amount;
	private String movieInfo;
	private Long mallGoodsId;
	private String topImg;
	private String otherInfo;
	private Timestamp addtime;
	private Long clicktimes;
	private Integer orderSort;
	private String content;
	private String original_price;
	private String presell;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMovieInfo() {
		return this.movieInfo;
	}

	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}

	public Long getMallGoodsId() {
		return this.mallGoodsId;
	}

	public void setMallGoodsId(Long mallGoodsId) {
		this.mallGoodsId = mallGoodsId;
	}

	public String getTopImg() {
		return this.topImg;
	}

	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getClicktimes() {
		return this.clicktimes;
	}

	public void setClicktimes(Long clicktimes) {
		this.clicktimes = clicktimes;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getFilmTag() {
		return this.filmTag;
	}

	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}

	public Integer getOrderSort() {
		return this.orderSort;
	}

	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOriginal_price() {
		return this.original_price;
	}

	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}

	public String getPresell() {
		return this.presell;
	}

	public void setPresell(String presell) {
		this.presell = presell;
	}
}