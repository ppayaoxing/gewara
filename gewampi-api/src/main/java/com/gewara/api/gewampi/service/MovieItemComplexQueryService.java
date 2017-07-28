/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.service;

import com.gewara.api.gewampi.vo.MovieItemBasicQueryRequest;
import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

@Deprecated
public interface MovieItemComplexQueryService {

	@Deprecated
	ResultCode<List<MovieItemVo>> findByBasicQuery(MovieItemBasicQueryRequest arg0);

	@Deprecated
	ResultCode<Integer> findCountByBasicQuery(MovieItemBasicQueryRequest arg0);

	@Deprecated
	ResultCode<List> findPropertyListByBasicQuery(MovieItemBasicQueryRequest arg0);

	@Deprecated
	ResultCode<Integer> findPropertyCountByBasicQuery(MovieItemBasicQueryRequest arg0);
}