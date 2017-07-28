/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.mobile.service;

import com.gewara.api.Response;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface MobileService {

	@Deprecated
	Response saveMobiles(List<String> arg0);

	ResultCode saveMobiles2(List<String> arg0);

	@Deprecated
	Response batchImportMobiles(String arg0);

	ResultCode batchImportMobiles2(String arg0);
}