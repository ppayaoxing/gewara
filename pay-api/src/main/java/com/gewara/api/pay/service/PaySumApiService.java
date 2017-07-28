/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.service;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface PaySumApiService {
	ResultCode<List<Map<String, Object>>> getSum(String arg0, String arg1, String arg2);
}