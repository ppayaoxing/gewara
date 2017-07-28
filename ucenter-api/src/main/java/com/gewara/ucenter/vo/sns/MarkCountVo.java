/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MarkCountVo extends BaseVo {
	private static final long serialVersionUID = 7402495088924178076L;
	protected String mkey;
	protected String tag;
	protected Long relatedid;
	protected Integer bookingmarks;
	protected Integer bookingtimes;
	protected Integer unbookingmarks;
	protected Integer unbookingtimes;

	public Serializable realId() {
		return this.mkey;
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

	public Integer getAvgbookingmarks() {
		return Integer.valueOf(this.bookingmarks.intValue() * 10 / this.bookingtimes.intValue());
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

	public Integer getUnavgbookingmarks() {
		return Integer.valueOf(this.unbookingmarks.intValue() * 10 / this.unbookingtimes.intValue());
	}

	public String getMkey() {
		return this.mkey;
	}

	public void setMkey(String mkey) {
		this.mkey = mkey;
	}
}