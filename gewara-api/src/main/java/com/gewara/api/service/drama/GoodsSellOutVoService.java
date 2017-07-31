package com.gewara.api.service.drama;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsSellOutRegisterVo;

public interface GoodsSellOutVoService{

	public ResultCode<GoodsSellOutRegisterVo> registerIt(GoodsSellOutRegisterVo paramVo);

}
