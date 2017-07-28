/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.service;

import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface ActivityMappingApiService {
	ResultCode<List<Long>> getRelatedIds(Long arg0, String arg1);
}