/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin.system;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface MySqlAdminService {
	ResultCode<Map<String, Object>> queryOneRowForMap(String arg0);

	ResultCode<List<Map<String, Object>>> queryMapListBySQL(String arg0);

	ResultCode<Map<String, Object>> getTableInfo(String arg0);
}