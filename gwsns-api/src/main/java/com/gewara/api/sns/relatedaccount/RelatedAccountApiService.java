/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.relatedaccount;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface RelatedAccountApiService {
	ResultCode<List<VoMap<String, String>>> getRelatedAccountVoMapList(Long arg0, String arg1);
}