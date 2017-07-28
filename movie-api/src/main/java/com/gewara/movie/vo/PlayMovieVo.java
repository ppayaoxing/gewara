/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class PlayMovieVo extends BaseVo {
	private Long id;
	private Long kindId;
	private String kindName;
	private String belongToKind;
	private Long movieId;
	private Timestamp playStartTime;
	private Timestamp playEndTime;
	private Timestamp cinemaPlayTime;
	private Integer orderNumber;
	private Integer status;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String activityId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String impression;
	private String qualityReport;
	private String videoLink;
	private String playCityCode;
	private String describe;
	private String yingzhangurl;
	private String yingzhanAddress;
	private String relativeIds;
	private String imgUrl;
	private static final long serialVersionUID = 6672625770368452937L;

	public String getRelativeIds() {
		return this.relativeIds;
	}

	public void setRelativeIds(String relativeIds) {
		this.relativeIds = relativeIds;
	}

	public String getYingzhangurl() {
		return this.yingzhangurl;
	}

	public void setYingzhangurl(String yingzhangurl) {
		this.yingzhangurl = yingzhangurl;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Timestamp getPlayStartTime() {
		return this.playStartTime;
	}

	public void setPlayStartTime(Timestamp playStartTime) {
		this.playStartTime = playStartTime;
	}

	public Timestamp getPlayEndTime() {
		return this.playEndTime;
	}

	public void setPlayEndTime(Timestamp playEndTime) {
		this.playEndTime = playEndTime;
	}

	public Timestamp getCinemaPlayTime() {
		return this.cinemaPlayTime;
	}

	public void setCinemaPlayTime(Timestamp cinemaPlayTime) {
		this.cinemaPlayTime = cinemaPlayTime;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getKindId() {
		return this.kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getImpression() {
		return this.impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getVideoLink() {
		return this.videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getQualityReport() {
		return this.qualityReport;
	}

	public void setQualityReport(String qualityReport) {
		this.qualityReport = qualityReport;
	}

	public String getPlayCityCode() {
		return this.playCityCode;
	}

	public void setPlayCityCode(String playCityCode) {
		this.playCityCode = playCityCode;
	}

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getBelongToKind() {
		return this.belongToKind;
	}

	public void setBelongToKind(String belongToKind) {
		this.belongToKind = belongToKind;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getYingzhanAddress() {
		return this.yingzhanAddress;
	}

	public void setYingzhanAddress(String yingzhanAddress) {
		this.yingzhanAddress = yingzhanAddress;
	}
}