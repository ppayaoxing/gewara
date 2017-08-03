package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class Img2Text implements Serializable{
	private static final long serialVersionUID = -7882425815550750870L;
	private String image_url;		//图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错 
	private String text;			//图文描述，5000字以内 
	public Img2Text(){
		
	}
	public Img2Text(String image_url, String text){
		this.image_url = image_url;
		this.text = text;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
