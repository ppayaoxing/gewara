/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MarkChartsDataVo extends BaseVo {
	private static final long serialVersionUID = 997813214833427169L;
	private String id;
	private String mkey;
	private String tag;
	private Long relatedid;
	private Integer bookingmarks;
	private Integer bookingtimes;
	private Integer unbookingmarks;
	private Integer unbookingtimes;
	private String markValue;
	private String statisticDate;
	private String addTime;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMkey() {
		return this.mkey;
	}

	public void setMkey(String mkey) {
		this.mkey = mkey;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Integer getBookingmarks() {
		return this.bookingmarks;
	}

	public void setBookingmarks(Integer bookingmarks) {
		this.bookingmarks = bookingmarks;
	}

	public Integer getBookingtimes() {
		return this.bookingtimes;
	}

	public void setBookingtimes(Integer bookingtimes) {
		this.bookingtimes = bookingtimes;
	}

	public Integer getUnbookingmarks() {
		return this.unbookingmarks;
	}

	public void setUnbookingmarks(Integer unbookingmarks) {
		this.unbookingmarks = unbookingmarks;
	}

	public Integer getUnbookingtimes() {
		return this.unbookingtimes;
	}

	public void setUnbookingtimes(Integer unbookingtimes) {
		this.unbookingtimes = unbookingtimes;
	}

	public String getMarkValue() {
		return this.markValue;
	}

	public void setMarkValue(String markValue) {
		this.markValue = markValue;
	}

	public String getStatisticDate() {
		return this.statisticDate;
	}

	public void setStatisticDate(String statisticDate) {
		this.statisticDate = statisticDate;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
}