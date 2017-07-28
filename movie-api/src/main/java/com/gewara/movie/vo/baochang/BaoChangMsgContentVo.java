/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class BaoChangMsgContentVo extends BaseVo {
	private static final long serialVersionUID = -8708356666973143888L;
	public static final String BAOCHANG_MSG_TAG_ORDER_PURCHASER = "order_purchaser";
	public static final String BAOCHANG_MSG_TAG_ORDER_PUSH_PURCHASER = "order_push_purchaser";
	public static final String BAOCHANG_MSG_TAG_PAID_PURCHASER = "paid_purchaser";
	public static final String BAOCHANG_MSG_TAG_PAID_PUSH_PURCHASER = "paid_push_purchaser";
	public static final String BAOCHANG_MSG_TAG_FAIL_PURCHASER = "fail_purchaser";
	public static final String BAOCHANG_MSG_TAG_FAIL_PUSH_PURCHASER = "fail_push_purchaser";
	public static final String BAOCHANG_MSG_TAG_RECEIPTOR = "receiptor";
	private String id;
	private String tag;
	private String mobileType;
	private String content;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMobileType() {
		return this.mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}