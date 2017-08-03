package com.gewara.content.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.NewsVo;

public interface NewsVoService {

	ResultCode<List<NewsVo>> getNewsListByCitycode(String citycode, String tag, Long relatedid, int from, int maxnum);

	ResultCode<NewsVo> getNewsById(Long id);
	
	ResultCode<List<NewsVo>> getNewsListByIds(Long ... ids);
	
	ResultCode<List<NewsVo>> getNewsListByIdList(List<Long> idList);
	
	ResultCode<Integer> getNewsCount(String citycode, String tag, String newstype, Long relatedid, String title);
	ResultCode<List<NewsVo>> getCurrentNewsByTag(String citycode, String tag, String newstype, final int from, final int num);
	ResultCode<List<NewsVo>> getNewsListByCitycodeNewstype(String citycode, String tag, Long relatedid, String newstype, int from, int maxnum);
}
