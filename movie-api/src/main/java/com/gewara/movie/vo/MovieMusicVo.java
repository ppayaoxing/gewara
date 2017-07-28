/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class MovieMusicVo extends BaseVo {
	public static final Integer IS_HOT = Integer.valueOf(0);
	public static final Integer IS_NOT_HOT = Integer.valueOf(1);
	public static final Integer IS_LIKE = Integer.valueOf(0);
	public static final Integer IS_NOT_LIKE = Integer.valueOf(1);
	private static final long serialVersionUID = -4294404569766014178L;
	private String song_id;
	private String song_name;
	private List<Long> movieid;
	private String artist_id;
	private String artist_name;
	private String artist_logo;
	private String singers;
	private String album_id;
	private String album_name;
	private String album_logo;
	private Integer length;
	private Integer track;
	private Integer cd_serial;
	private Integer music_type;
	private Integer likeNum;
	private Integer talkNum;
	private List<String> relateid;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String orderby;
	private Integer hot = Integer.valueOf(0);
	private Long starid;
	private Integer liked = Integer.valueOf(0);

	public String getSong_id() {
		return this.song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public String getSong_name() {
		return this.song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public List<Long> getMovieid() {
		return this.movieid;
	}

	public void setMovieid(List<Long> movieid) {
		this.movieid = movieid;
	}

	public String getArtist_id() {
		return this.artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return this.artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getArtist_logo() {
		return this.artist_logo;
	}

	public void setArtist_logo(String artist_logo) {
		this.artist_logo = artist_logo;
	}

	public String getSingers() {
		return this.singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	public String getAlbum_id() {
		return this.album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return this.album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_logo() {
		return this.album_logo;
	}

	public void setAlbum_logo(String album_logo) {
		this.album_logo = album_logo;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getTrack() {
		return this.track;
	}

	public void setTrack(Integer track) {
		this.track = track;
	}

	public Integer getCd_serial() {
		return this.cd_serial;
	}

	public void setCd_serial(Integer cd_serial) {
		this.cd_serial = cd_serial;
	}

	public Integer getMusic_type() {
		return this.music_type;
	}

	public void setMusic_type(Integer music_type) {
		this.music_type = music_type;
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

	public List<String> getRelateid() {
		return this.relateid;
	}

	public void setRelateid(List<String> relateid) {
		this.relateid = relateid;
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

	public String getOrderby() {
		return this.orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public Serializable realId() {
		return this.song_id;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Long getStarid() {
		return this.starid;
	}

	public void setStarid(Long starid) {
		this.starid = starid;
	}

	public Integer getLiked() {
		return this.liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}
}