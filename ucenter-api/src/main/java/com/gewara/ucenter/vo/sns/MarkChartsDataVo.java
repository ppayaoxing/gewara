package com.gewara.ucenter.vo.sns;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MarkChartsDataVo extends BaseVo{
	private static final long serialVersionUID = 997813214833427169L;
	private String id;
	private String mkey;
	private String tag;
	private Long relatedid;
	private Integer bookingmarks;   //已购票 评分值
	private Integer bookingtimes;   //已购票 评分人数
	private Integer unbookingmarks; //未购票 评分值
	private Integer unbookingtimes; //未购票 评分人数
	private String markValue;
	private String statisticDate;   //统计时间
	private String addTime;
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
	public String getMkey() {
		return mkey;
	}
	public void setMkey(String mkey) {
		this.mkey = mkey;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public Integer getBookingmarks() {
		return bookingmarks;
	}
	public void setBookingmarks(Integer bookingmarks) {
		this.bookingmarks = bookingmarks;
	}
	public Integer getBookingtimes() {
		return bookingtimes;
	}
	public void setBookingtimes(Integer bookingtimes) {
		this.bookingtimes = bookingtimes;
	}
	public Integer getUnbookingmarks() {
		return unbookingmarks;
	}
	public void setUnbookingmarks(Integer unbookingmarks) {
		this.unbookingmarks = unbookingmarks;
	}
	public Integer getUnbookingtimes() {
		return unbookingtimes;
	}
	public void setUnbookingtimes(Integer unbookingtimes) {
		this.unbookingtimes = unbookingtimes;
	}
	public String getMarkValue() {
		return markValue;
	}
	public void setMarkValue(String markValue) {
		this.markValue = markValue;
	}
	public String getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(String statisticDate) {
		this.statisticDate = statisticDate;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
}
