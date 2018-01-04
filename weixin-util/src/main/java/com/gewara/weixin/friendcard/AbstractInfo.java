package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class AbstractInfo implements Serializable{
	private static final long serialVersionUID = -4922262696501830877L;
	private String abstract1;			//优惠详情摘要字段结构体名称
	private String[] icon_url_list;		//封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350 
	private String text_image_list;		//图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 
	public AbstractInfo(){
		
	}
	public String getAbstract1() {
		return abstract1;
	}
	public void setAbstract1(String abstract1) {
		this.abstract1 = abstract1;
	}
	public String[] getIcon_url_list() {
		return icon_url_list;
	}
	public void setIcon_url_list(String[] icon_url_list) {
		this.icon_url_list = icon_url_list;
	}
	public String getText_image_list() {
		return text_image_list;
	}
	public void setText_image_list(String text_image_list) {
		this.text_image_list = text_image_list;
	}
	
}
