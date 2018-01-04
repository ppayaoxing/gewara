package com.gewara.movie.vo.filmfest;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;


public class ViewFilmScheduleVo extends BaseVo{
	
	private static final long serialVersionUID = 6376895767049902327L;
	public static final String TYPE_MOVIE_FILMFEST = "movie";
	public static final String TYPE_SCHEDULE_FILMFEST = "schedule";
	
	private String _id;
	
	private Long mpid;
	
	private Long movieId;
	
	private Long memberId;
	
	private String addTime;
	
	private String playTime;
	
	private String type;// movie 片单  schedule 日程 
	
	private String source;
	
	private Long batch;
	
	private String tradeNo;
	
	private Long cinemaId;
	private String buy;
	private String filmTag; //不同电影节的标示
	private Integer score;
	private String like;	// 赞
	private String shareReason;	
	public ViewFilmScheduleVo(){}
	
	public ViewFilmScheduleVo(String type,Long mpid,Long movieId,Long memberId){
		this.type = type;
		this.mpid = mpid;
		this.movieId = movieId;
		this.memberId = memberId;
		this.addTime = DateUtil.getCurFullTimestampStr();
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long getMpid() {
		return mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	@Override
	public Serializable realId() {
		return this._id;
	}

	public String getFilmTag() {
		return filmTag;
	}

	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getShareReason() {
		return shareReason;
	}

	public void setShareReason(String shareReason) {
		this.shareReason = shareReason;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

}
