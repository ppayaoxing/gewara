/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.poi;

import com.gewara.weixin.callback.WxBack;
import java.util.List;

public class WxPoiList extends WxBack {
	private static final long serialVersionUID = -112047014841026654L;
	private List<WxPoiBaseInfo> business_list;

	public List<WxPoiBaseInfo> getBusiness_list() {
		return this.business_list;
	}

	public void setBusiness_list(List<WxPoiBaseInfo> business_list) {
		this.business_list = business_list;
	}
}