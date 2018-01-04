package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class PlayMovieVo extends BaseVo {

	private Long id; //唯一标示
	private Long kindId; //所在类别,属于哪一期
	private String kindName; //放映类别名称
	private String belongToKind;//属于哪个类别 新商业or新经典 现在的值有 newBusiness newClassics 影展模式(yingzhan)
	private Long movieId; //影片ID
	private Timestamp playStartTime; //影片点映开始时间
	private Timestamp playEndTime;  //影片点映结束时间
	private Timestamp cinemaPlayTime; //影院放映时间
	private Integer orderNumber;	//排序序号
	private Integer status;	//是否删除 1=删除 0=未删除
	private Timestamp addtime; //添加时间
	private Timestamp updatetime;//修改时间
	private String activityId; //试片活动id
	private Timestamp startTime; //活动有效时间 开始时间
	private Timestamp endTime; //活动有效时间 结束时间
	private String impression; //影片印象 多个印象用逗号分开
	private String qualityReport; //质量报告
	private String videoLink; //视频链接
	private String playCityCode;//放映城市编码
	private String describe;//描述
	private String yingzhangurl;//影展的url，如果是影展模式的话
	private String yingzhanAddress;//影展地址
	private String relativeIds;//影展关联id
	private String imgUrl;
	public String getRelativeIds() {
		return relativeIds;
	}
	public void setRelativeIds(String relativeIds) {
		this.relativeIds = relativeIds;
	}
	public String getYingzhangurl() {
		return yingzhangurl;
	}

	public void setYingzhangurl(String yingzhangurl) {
		this.yingzhangurl = yingzhangurl;
	}

	public PlayMovieVo(){}
	private static final long serialVersionUID = 6672625770368452937L;

	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Timestamp getPlayStartTime() {
		return playStartTime;
	}

	public void setPlayStartTime(Timestamp playStartTime) {
		this.playStartTime = playStartTime;
	}

	public Timestamp getPlayEndTime() {
		return playEndTime;
	}

	public void setPlayEndTime(Timestamp playEndTime) {
		this.playEndTime = playEndTime;
	}

	public Timestamp getCinemaPlayTime() {
		return cinemaPlayTime;
	}

	public void setCinemaPlayTime(Timestamp cinemaPlayTime) {
		this.cinemaPlayTime = cinemaPlayTime;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getQualityReport() {
		return qualityReport;
	}

	public void setQualityReport(String qualityReport) {
		this.qualityReport = qualityReport;
	}

	public String getPlayCityCode() {
		return playCityCode;
	}

	public void setPlayCityCode(String playCityCode) {
		this.playCityCode = playCityCode;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getKindName() {
		return kindName;
	}
	
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	
	public String getBelongToKind() {
		return belongToKind;
	}
	
	public void setBelongToKind(String belongToKind) {
		this.belongToKind = belongToKind;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	public Timestamp getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	public String getYingzhanAddress() {
		return yingzhanAddress;
	}
	
	public void setYingzhanAddress(String yingzhanAddress) {
		this.yingzhanAddress = yingzhanAddress;
	}
	
}
