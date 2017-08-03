package com.gewara.weixin;

import java.util.List;

public class Button {
	private String name;
	private List<SubButton> sub_button;
	public Button(){
		
	}
	public Button(String name, List<SubButton> sub_button){
		this.name = name;
		this.sub_button = sub_button;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<SubButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<SubButton> sub_button) {
		this.sub_button = sub_button;
	}
}
