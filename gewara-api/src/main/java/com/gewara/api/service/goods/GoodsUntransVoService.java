package com.gewara.api.service.goods;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsStockDataVo;

public interface GoodsUntransVoService {
	/**
	 * 根据项目类型与物品类型查询项目ID集合
	 * @param itemtype
	 * @param smalltype
	 * @return
	 */
	ResultCode<List<Long>> getItemIdListByItemtype(String itemtype, String smalltype);
	/**
	 * 根据物品ID获得物品库存信息
	 * @param goodsId
	 * @return
	 */
	ResultCode<GoodsStockDataVo> getGoodsStockDataVoByGoodsId(Long goodsId);
}
