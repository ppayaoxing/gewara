/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class FriendCard implements Serializable {
	private static final long serialVersionUID = -6183884043365444307L;
	private String card_type;
	private FriendCash cash;

	public FriendCard() {
	}

	public FriendCard(String card_type, FriendCash cash) {
		this.card_type = card_type;
		this.cash = cash;
	}

	public String getCard_type() {
		return this.card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public FriendCash getCash() {
		return this.cash;
	}

	public void setCash(FriendCash cash) {
		this.cash = cash;
	}
}