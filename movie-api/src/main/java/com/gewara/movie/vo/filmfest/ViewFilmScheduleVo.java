/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.filmfest;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;

public class ViewFilmScheduleVo extends BaseVo {
	private static final long serialVersionUID = 6376895767049902327L;
	public static final String TYPE_MOVIE_FILMFEST = "movie";
	public static final String TYPE_SCHEDULE_FILMFEST = "schedule";
	private String _id;
	private Long mpid;
	private Long movieId;
	private Long memberId;
	private String addTime;
	private String playTime;
	private String type;
	private String source;
	private Long batch;
	private String tradeNo;
	private Long cinemaId;
	private String buy;
	private String filmTag;
	private Integer score;
	private String like;
	private String shareReason;

	public ViewFilmScheduleVo() {
	}

	public ViewFilmScheduleVo(String type, Long mpid, Long movieId, Long memberId) {
		this.type = type;
		this.mpid = mpid;
		this.movieId = movieId;
		this.memberId = memberId;
		this.addTime = DateUtil.getCurFullTimestampStr();
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getBatch() {
		return this.batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getBuy() {
		return this.buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public Serializable realId() {
		return this._id;
	}

	public String getFilmTag() {
		return this.filmTag;
	}

	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getShareReason() {
		return this.shareReason;
	}

	public void setShareReason(String shareReason) {
		this.shareReason = shareReason;
	}

	public String getLike() {
		return this.like;
	}

	public void setLike(String like) {
		this.like = like;
	}
}