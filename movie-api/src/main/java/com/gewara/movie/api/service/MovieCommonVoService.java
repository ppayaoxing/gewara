package com.gewara.movie.api.service;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.common.SubwaystationVo;

public interface MovieCommonVoService {
	ResultCode<List<SubwaystationVo>> getSubwayStationVoList(List<Long> idList);
}
