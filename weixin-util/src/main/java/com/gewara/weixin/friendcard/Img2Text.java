/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class Img2Text implements Serializable {
	private static final long serialVersionUID = -7882425815550750870L;
	private String image_url;
	private String text;

	public Img2Text() {
	}

	public Img2Text(String image_url, String text) {
		this.image_url = image_url;
		this.text = text;
	}

	public String getImage_url() {
		return this.image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
}