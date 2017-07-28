/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.GewaCommendVo;
import com.gewara.content.vo.HeadInfoVo;
import java.util.List;
import java.util.Map;

public abstract interface GewaCommendVoService {
	public abstract ResultCode<List<Map>> getGewaCommendList(String paramString1, String paramString2, int paramInt1,
			int paramInt2);

	public abstract ResultCode<List<GewaCommendVo>> getGewaCommendListByWithActive(String paramString1,
			String paramString2, Long paramLong, String paramString3, boolean paramBoolean1, boolean paramBoolean2,
			int paramInt1, int paramInt2);

	public abstract ResultCode<List<GewaCommendVo>> getGewaCommendListByActiveRealtedid(String paramString1,
			String paramString2, Long paramLong1, Long paramLong2, String paramString3, boolean paramBoolean1,
			boolean paramBoolean2, int paramInt1, int paramInt2);

	public abstract ResultCode<List<GewaCommendVo>> getGewaCommendListByTag(String paramString1, String paramString2,
			Long paramLong, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2);

	public abstract ResultCode<List<Map>> getGewaCurCommendList(String paramString1, String paramString2, int paramInt1,
			int paramInt2);

	public abstract ResultCode<List<GewaCommendVo>> getAllGewaCommendList(String paramString1, String paramString2,
			Long paramLong, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2);

	public abstract ResultCode<Map<String, Integer>> getVideoCount();

	public abstract ResultCode<Map<String, Integer>> getCommentCount();

	public abstract ResultCode<Map<String, Integer>> getPictureCount();

	public abstract ResultCode<HeadInfoVo> getIndexHeadInfo(String paramString);

	public abstract ResultCode<HeadInfoVo> getHeadInfoById(Long paramLong);

	public abstract ResultCode<GewaCommendVo> getMovieWalaGewaCommend(String paramString);
}