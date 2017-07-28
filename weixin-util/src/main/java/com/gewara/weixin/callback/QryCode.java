/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.callback;

public class QryCode extends WxBack {
	private static final long serialVersionUID = 4995725043605140159L;
	private String openid;
	private WxCard card;

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public WxCard getCard() {
		return this.card;
	}

	public void setCard(WxCard card) {
		this.card = card;
	}
}