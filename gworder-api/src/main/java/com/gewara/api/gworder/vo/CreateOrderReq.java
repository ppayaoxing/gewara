/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;

public class CreateOrderReq extends BaseVo {
	private static final long serialVersionUID = -6371087548888845993L;
	public static final String TAG_MOVIE = "movie";
	public static final String TAG_DRAMA = "drama";
	public static final String TAG_GOODS = "goods";
	protected String tag;
	protected String contextKey;
	protected String asyncQueueKey;
	protected Long invalidTime = Long.valueOf(System.currentTimeMillis() + 60000L);
	protected Long memberId;
	protected Long relatedId;
	protected String remoteIp;
	protected String source;

	public CreateOrderReq() {
	}

	public CreateOrderReq(String tag, String contextKey, String asyncQueueKey, String remoteIp, Long memberId,
			Long relatedId) {
		this.tag = tag;
		this.contextKey = contextKey;
		this.asyncQueueKey = asyncQueueKey;
		this.memberId = memberId;
		this.relatedId = relatedId;
		this.remoteIp = remoteIp;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = Long.valueOf(memberId);
	}

	public long getRelatedId() {
		return this.relatedId.longValue();
	}

	public Long getInvalidTime() {
		return this.invalidTime;
	}

	public void setInvalidTime(Long invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getContextKey() {
		return this.contextKey;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}

	public void setContextKey(String contextKey) {
		this.contextKey = contextKey;
	}

	public String getAsyncQueueKey() {
		return this.asyncQueueKey;
	}

	public String getRemoteIp() {
		return this.remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public void setAsyncQueueKey(String asyncQueueKey) {
		this.asyncQueueKey = asyncQueueKey;
	}

	public String buildContextKey() {
		if (StringUtils.isBlank(this.contextKey)) {
			this.contextKey = this.memberId + ":" + this.tag + ":" + this.relatedId;
		}

		return this.contextKey;
	}

	public void setInvalidTime(long invalidTime, TimeUnit unit) {
		this.invalidTime = Long.valueOf(System.currentTimeMillis() + unit.toMillis(invalidTime));
	}

	public boolean isTimeoutReq() {
		return System.currentTimeMillis() - this.invalidTime.longValue() > 0L;
	}

	public Serializable realId() {
		return this.buildContextKey();
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}