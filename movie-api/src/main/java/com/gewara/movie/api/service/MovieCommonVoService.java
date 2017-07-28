/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.common.SubwaystationVo;
import java.util.List;

public interface MovieCommonVoService {
	ResultCode<List<SubwaystationVo>> getSubwayStationVoList(List<Long> arg0);
}