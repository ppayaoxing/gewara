/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

import com.gewara.api.vo.ResultCode;

public interface WpApiService {
	ResultCode<String> getItem(String arg0);

	ResultCode<String> getVenue(String arg0);
}