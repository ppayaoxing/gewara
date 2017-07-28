/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.goods;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsStockDataVo;
import java.util.List;

public interface GoodsUntransVoService {
	ResultCode<List<Long>> getItemIdListByItemtype(String arg0, String arg1);

	ResultCode<GoodsStockDataVo> getGoodsStockDataVoByGoodsId(Long arg0);
}