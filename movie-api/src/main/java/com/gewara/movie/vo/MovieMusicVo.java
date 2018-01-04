package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class MovieMusicVo extends BaseVo{
	public static final Integer IS_HOT = 0;
	public static final Integer IS_NOT_HOT = 1;
	public static final Integer IS_LIKE = 0;
	public static final Integer IS_NOT_LIKE = 1;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4294404569766014178L;
	private String song_id;//虾米id
	private String song_name;//歌曲
	private List<Long> movieid;//电影ID
	private String artist_id;//艺人ID
	private String artist_name;//艺人名字
	private String artist_logo;//艺人图片
	private String singers;//演唱者
	private String album_id;//专辑ID
	private String album_name;//专辑名称 
	private String album_logo;//专辑logo
	private Integer length;//歌曲长度
	private Integer track;//歌曲序号
	private Integer cd_serial;//CD序号
	private Integer music_type;//音乐类型
	private Integer likeNum;//喜欢数
	private Integer talkNum;//讨论数
	private List<String> relateid;//关联的list_id
	private Timestamp createTime;//创建时间
	private Timestamp updateTime;//修改时间
	private String orderby;//排序 
	private Integer hot = 0;//是否热门音乐，0：不热门；1：热门
	private Long starid;//影人ID
	private Integer liked=0;
	
	public MovieMusicVo() {
		super();
	}

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public List<Long> getMovieid() {
		return movieid;
	}

	public void setMovieid(List<Long> movieid) {
		this.movieid = movieid;
	}

	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getArtist_logo() {
		return artist_logo;
	}

	public void setArtist_logo(String artist_logo) {
		this.artist_logo = artist_logo;
	}

	public String getSingers() {
		return singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_logo() {
		return album_logo;
	}

	public void setAlbum_logo(String album_logo) {
		this.album_logo = album_logo;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getTrack() {
		return track;
	}

	public void setTrack(Integer track) {
		this.track = track;
	}

	public Integer getCd_serial() {
		return cd_serial;
	}

	public void setCd_serial(Integer cd_serial) {
		this.cd_serial = cd_serial;
	}

	public Integer getMusic_type() {
		return music_type;
	}

	public void setMusic_type(Integer music_type) {
		this.music_type = music_type;
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
	
	public List<String> getRelateid() {
		return relateid;
	}

	public void setRelateid(List<String> relateid) {
		this.relateid = relateid;
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

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	@Override
	public Serializable realId() {
		return song_id;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Long getStarid() {
		return starid;
	}

	public void setStarid(Long starid) {
		this.starid = starid;
	}

	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	
}
