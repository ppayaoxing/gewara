/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.goods;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsVo;
import java.util.Map;

public interface GoodsAvatarVoService {
	ResultCode<GoodsVo> saveOrUpdateActivityGoods(Long arg0, Long arg1, Map<String, String> arg2);
}