/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.AdvertisingVo;
import java.util.List;

public abstract interface AdVoService {
	public abstract ResultCode<AdvertisingVo> getFirstAdByPostionTag(String paramString);

	public abstract ResultCode<List<AdvertisingVo>> getAdListByPid(String paramString1, String paramString2);
}