/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.NewsVo;
import java.util.List;

public abstract interface NewsVoService {
	public abstract ResultCode<List<NewsVo>> getNewsListByCitycode(String paramString1, String paramString2,
			Long paramLong, int paramInt1, int paramInt2);

	public abstract ResultCode<NewsVo> getNewsById(Long paramLong);

	public abstract ResultCode<List<NewsVo>> getNewsListByIds(Long[] paramArrayOfLong);

	public abstract ResultCode<List<NewsVo>> getNewsListByIdList(List<Long> paramList);

	public abstract ResultCode<Integer> getNewsCount(String paramString1, String paramString2, String paramString3,
			Long paramLong, String paramString4);

	public abstract ResultCode<List<NewsVo>> getCurrentNewsByTag(String paramString1, String paramString2,
			String paramString3, int paramInt1, int paramInt2);

	public abstract ResultCode<List<NewsVo>> getNewsListByCitycodeNewstype(String paramString1, String paramString2,
			Long paramLong, String paramString3, int paramInt1, int paramInt2);
}