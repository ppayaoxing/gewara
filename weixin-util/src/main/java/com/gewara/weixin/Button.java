/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin;

import java.util.List;

public class Button {
	private String name;
	private List<SubButton> sub_button;

	public Button() {
	}

	public Button(String name, List<SubButton> sub_button) {
		this.name = name;
		this.sub_button = sub_button;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubButton> getSub_button() {
		return this.sub_button;
	}

	public void setSub_button(List<SubButton> sub_button) {
		this.sub_button = sub_button;
	}
}