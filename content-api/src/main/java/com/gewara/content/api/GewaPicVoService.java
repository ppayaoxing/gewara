/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.PictureVo;
import java.util.List;

public abstract interface GewaPicVoService {
	public abstract ResultCode<String> saveToTempPic(String paramString1, String paramString2);

	public abstract ResultCode<String> saveTempFileToRemote(String paramString, boolean paramBoolean);

	public abstract ResultCode<String> moveRemoteTempTo(Long paramLong1, String paramString1, Long paramLong2,
			String paramString2, String paramString3);

	public abstract ResultCode<String> uploadPic(String paramString1, String paramString2, boolean paramBoolean,
			Long paramLong1, String paramString3, Long paramLong2, String paramString4);

	public abstract ResultCode<String> uploadPicture(String paramString1, String paramString2, boolean paramBoolean,
			Long paramLong1, String paramString3, Long paramLong2, String paramString4);

	public abstract ResultCode<List<PictureVo>> getPictureList(Long paramLong, String paramString,
			Integer paramInteger1, Integer paramInteger2);
}