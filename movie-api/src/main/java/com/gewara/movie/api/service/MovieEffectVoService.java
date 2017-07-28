/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.EffectInfoVo;
import java.util.List;
import java.util.Map;

public interface MovieEffectVoService {
	ResultCode<List<EffectInfoVo>> getEffectInfoListByMovieId(Long arg0);

	ResultCode<Long> getWatchMovieCountByMidEffect(Long arg0, String arg1);

	ResultCode<List<String>> getEffectsByMemberid(Long arg0);

	ResultCode<List<String>> getCityEffectUnifysByCitycode(String arg0);

	ResultCode<Map<String, Map<String, String>>> getMovieEffectMap();

	ResultCode<Map<String, Object>> getMovieIcon(String arg0, String arg1, Long arg2, boolean arg3);
}