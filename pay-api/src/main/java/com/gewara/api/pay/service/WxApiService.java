/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.service;

import com.gewara.api.pay.request.wx.CheckfirstbindByTradeNoRequest;
import com.gewara.api.pay.response.wx.CheckfirstbindByTradeNoResponse;
import com.gewara.api.vo.ResultCode;

public interface WxApiService {
	ResultCode<CheckfirstbindByTradeNoResponse> checkfirstbindByTradeNo(CheckfirstbindByTradeNoRequest arg0);
}