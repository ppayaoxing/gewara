package com.gewara.weixin.poi;

import java.util.List;

import com.gewara.weixin.callback.WxBack;

public class WxPoiList extends WxBack{
	private static final long serialVersionUID = -112047014841026654L;
	private List<WxPoiBaseInfo> business_list;
	public List<WxPoiBaseInfo> getBusiness_list() {
		return business_list;
	}
	public void setBusiness_list(List<WxPoiBaseInfo> business_list) {
		this.business_list = business_list;
	}
}
