/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.hotrepair;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface HotRepairApiService {
	ResultCode<List<VoMap<String, String>>> getPatchList(String arg0, String arg1, String arg2, int arg3, int arg4);
}