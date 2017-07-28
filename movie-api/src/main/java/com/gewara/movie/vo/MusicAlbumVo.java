/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.movie.vo.MovieMusicVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class MusicAlbumVo extends BaseVo {
	private static final long serialVersionUID = 309009193307051030L;
	private String list_id;
	private String collect_name;
	private String collect_logo;
	private List<Long> movieid;
	private Integer likeNum;
	private Integer talkNum;
	private Timestamp createTime;
	private Timestamp updateTime;
	private List<MovieMusicVo> songs;
	private Boolean isUpdate;
	private String type;

	public String getList_id() {
		return this.list_id;
	}

	public void setList_id(String list_id) {
		this.list_id = list_id;
	}

	public String getCollect_name() {
		return this.collect_name;
	}

	public void setCollect_name(String collect_name) {
		this.collect_name = collect_name;
	}

	public String getCollect_logo() {
		return this.collect_logo;
	}

	public void setCollect_logo(String collect_logo) {
		this.collect_logo = collect_logo;
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

	public List<Long> getMovieid() {
		return this.movieid;
	}

	public void setMovieid(List<Long> movieid) {
		this.movieid = movieid;
	}

	public Integer getLikeNum() {
		return this.likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	public Integer getTalkNum() {
		return this.talkNum;
	}

	public void setTalkNum(Integer talkNum) {
		this.talkNum = talkNum;
	}

	public List<MovieMusicVo> getSongs() {
		return this.songs;
	}

	public void setSongs(List<MovieMusicVo> songs) {
		this.songs = songs;
	}

	public Boolean getIsUpdate() {
		return this.isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Serializable realId() {
		return this.list_id;
	}
}