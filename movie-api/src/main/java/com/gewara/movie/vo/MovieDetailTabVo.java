package com.gewara.movie.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MovieDetailTabVo extends BaseVo {

	private static final long serialVersionUID = -1118829041626421812L;
	private String id;
	// 影片ID
	private Long movieId;
	// 影片详情的标签
	private String tag;
	// 图片
	private String pic;
	// 标题
	private String title;
	// 点击之后的连接URL
	private String link;

	private String content;
	private Integer picHeight;
	private Integer picWight;
	@Override
	public Serializable realId() {
		return id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPicHeight() {
		return picHeight;
	}
	public void setPicHeight(Integer picHeight) {
		this.picHeight = picHeight;
	}
	public Integer getPicWight() {
		return picWight;
	}
	public void setPicWight(Integer picWight) {
		this.picWight = picWight;
	}


}
