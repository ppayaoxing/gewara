/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external;

import com.gewara.api.vo.ResultCode;
import com.gewara.msearch.external.entity.GwSearchResult;
import com.gewara.msearch.external.entity.QueryCondition;
import com.gewara.msearch.external.entity.QueryResult;
import java.util.Collection;

public interface QueryService {
	<T> ResultCode<Collection<QueryResult<T>>> query(QueryCondition arg0);

	ResultCode<QueryResult<GwSearchResult>> queryGwSearch(String arg0, String arg1, String arg2, String arg3,
			String arg4, int arg5, int arg6);
}