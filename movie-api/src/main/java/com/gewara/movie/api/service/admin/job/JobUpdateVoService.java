package com.gewara.movie.api.service.admin.job;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

/**
 * 用来接收来自定时任务的数据
 */
public interface JobUpdateVoService {
	ResultCode<Integer> updateCityprice(List<Map> result, String tag);
}
