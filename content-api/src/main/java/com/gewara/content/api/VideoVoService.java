/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.VideoVo;
import java.util.List;

public abstract interface VideoVoService {
	public abstract ResultCode<List<VideoVo>> getVideoList(String paramString, Long paramLong, int paramInt1,
			int paramInt2);

	public abstract ResultCode<VideoVo> getVideoById(Long paramLong);

	public abstract ResultCode<List<VideoVo>> getVideoListByIds(Long[] paramArrayOfLong);

	public abstract ResultCode<List<VideoVo>> getVideoListByIdList(List<Long> paramList);

	public abstract ResultCode<Integer> getVideoCountByTag(String paramString, Long paramLong, Integer paramInteger);

	public abstract ResultCode<List<VideoVo>> getVideoListByTag(String paramString1, Long paramLong,
			Integer paramInteger, String paramString2, String paramString3, boolean paramBoolean, int paramInt1,
			int paramInt2);
}