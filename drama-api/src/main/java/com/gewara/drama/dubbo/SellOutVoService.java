package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SellOutRegisterVo;

public interface SellOutVoService {
	
	public ResultCode<SellOutRegisterVo> registerIt(SellOutRegisterVo paramVo);
	
}
