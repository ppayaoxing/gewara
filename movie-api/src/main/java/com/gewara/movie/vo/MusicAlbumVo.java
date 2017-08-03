package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class MusicAlbumVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 309009193307051030L;
	private String list_id;//精选集ID
	private String collect_name;//精选集名称
	private String collect_logo;//精选集LOGO
	private List<Long> movieid;//电影ID
	private Integer likeNum;//喜欢数
	private Integer talkNum;//讨论数
	private Timestamp createTime;//创建时间
	private Timestamp updateTime;//修改时间
	private List<MovieMusicVo> songs;//音乐
	private Boolean isUpdate;//是否更新
	private String type;//专辑 精选集 歌曲列表(album,collection,song)
	public MusicAlbumVo() {
		super();
	}
	public String getList_id() {
		return list_id;
	}
	public void setList_id(String list_id) {
		this.list_id = list_id;
	}
	public String getCollect_name() {
		return collect_name;
	}
	public void setCollect_name(String collect_name) {
		this.collect_name = collect_name;
	}
	public String getCollect_logo() {
		return collect_logo;
	}
	public void setCollect_logo(String collect_logo) {
		this.collect_logo = collect_logo;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public List<Long> getMovieid() {
		return movieid;
	}
	public void setMovieid(List<Long> movieid) {
		this.movieid = movieid;
	}
	public Integer getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}
	public Integer getTalkNum() {
		return talkNum;
	}
	public void setTalkNum(Integer talkNum) {
		this.talkNum = talkNum;
	}
	public List<MovieMusicVo> getSongs() {
		return songs;
	}
	public void setSongs(List<MovieMusicVo> songs) {
		this.songs = songs;
	}
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public Serializable realId() {
		return list_id;
	}

}
