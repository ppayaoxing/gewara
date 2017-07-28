/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.drama;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsSellOutRegisterVo;

public interface GoodsSellOutVoService {
	ResultCode<GoodsSellOutRegisterVo> registerIt(GoodsSellOutRegisterVo arg0);
}