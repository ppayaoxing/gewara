/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface GpticketCrmApiService {
	ResultCode<Map> getMemberDiscount(String arg0, String arg1);
}