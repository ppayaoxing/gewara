/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.PictureVo;
import java.util.List;

public abstract interface PictureVoService {
	public abstract ResultCode<List<PictureVo>> getPictureList(String paramString, Long paramLong, int paramInt1,
			int paramInt2);

	public abstract ResultCode<List<PictureVo>> getPictureListUseCache(String paramString, Long paramLong,
			int paramInt1, int paramInt2);

	public abstract ResultCode<Integer> getPictureCount(String paramString, Long paramLong);

	public abstract ResultCode saveActivityPicture(Long paramLong1, Long paramLong2, String paramString1,
			String paramString2);

	public abstract ResultCode<PictureVo> getPicture(Long paramLong);

	public abstract ResultCode<Integer> getPictureCountByRelatedid(String paramString, Long paramLong);

	public abstract ResultCode<List<PictureVo>> getPictureListByRelatedidUseCache(String paramString, Long paramLong,
			int paramInt1, int paramInt2);
}