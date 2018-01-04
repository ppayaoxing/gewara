package com.gewara.movie.vo.filmfest;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class SetTicketVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8313840001633377715L;
	private String id;			//主键
	private String filmTag;		//电影节标记
	private String title; 		//套票标题
	private String subtitle;	//套票副标题
	private String amount;		//套票总价
	private String movieInfo;	//套票电影,Json形式存储
	private Long mallGoodsId;	//商城物品Id
	private String topImg;		//套票图片
	private String otherInfo;	//其他信息
	private Timestamp addtime;	//添加时间
	private Long clicktimes;	//点击次数
	private Integer orderSort;	//排序
	private String content;		//规则
	private String original_price;//套票原价
	private String presell;//是否预售:0:否；1：是
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public Long getMallGoodsId() {
		return mallGoodsId;
	}
	public void setMallGoodsId(Long mallGoodsId) {
		this.mallGoodsId = mallGoodsId;
	}
	public String getTopImg() {
		return topImg;
	}
	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Long getClicktimes() {
		return clicktimes;
	}
	public void setClicktimes(Long clicktimes) {
		this.clicktimes = clicktimes;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getFilmTag() {
		return filmTag;
	}
	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}
	public Integer getOrderSort() {
		return orderSort;
	}
	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}
	public String getPresell() {
		return presell;
	}
	public void setPresell(String presell) {
		this.presell = presell;
	}
	
}
