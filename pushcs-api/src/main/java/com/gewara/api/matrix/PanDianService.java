/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.matrix;

import com.gewara.api.vo.PanDianVO;
import com.gewara.api.vo.ResultCode;

public interface PanDianService {
	ResultCode<PanDianVO> getUserMovieDiaryByMemberid(Long arg0);
}