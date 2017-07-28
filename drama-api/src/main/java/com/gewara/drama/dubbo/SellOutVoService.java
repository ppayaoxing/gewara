/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SellOutRegisterVo;

public interface SellOutVoService {
	ResultCode<SellOutRegisterVo> registerIt(SellOutRegisterVo arg0);
}