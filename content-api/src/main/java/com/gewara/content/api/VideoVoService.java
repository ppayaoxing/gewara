package com.gewara.content.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.VideoVo;

public interface VideoVoService {

	ResultCode<List<VideoVo>> getVideoList(String tag, Long relatedid, int from, int maxnum);
	
	ResultCode<VideoVo> getVideoById(Long id);
	
	ResultCode<List<VideoVo>> getVideoListByIds(Long ... ids);
	
	ResultCode<List<VideoVo>> getVideoListByIdList(List<Long> idList);
	
	ResultCode<Integer> getVideoCountByTag(String tag, Long relatedid, Integer hotvalue);

	ResultCode<List<VideoVo>> getVideoListByTag(String tag, Long relatedid, Integer hotvalue, String orderField, String origin, boolean asc, int from,	int maxnum);

}
