/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin.job;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface JobUpdateVoService {
	ResultCode<Integer> updateCityprice(List<Map> arg0, String arg1);
}