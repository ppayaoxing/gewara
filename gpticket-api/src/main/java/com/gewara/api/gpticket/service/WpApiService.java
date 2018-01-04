package com.gewara.api.gpticket.service;

import com.gewara.api.vo.ResultCode;

public interface WpApiService {
	/**
	 * 获取项目名称
	 * @param onlineid
	 * @return
	 */
	ResultCode<String> getItem(String onlineid);
	/**
	 * 获取场馆名称
	 * @param venueid
	 * @return
	 */
	ResultCode<String> getVenue(String venueid);
}
