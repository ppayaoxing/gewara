package com.gewara.movie.api.service.brand;


import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BSGoodsStoreVo;

public interface BSGoodsStoreVoService {
	
	/**
	 * 保存“商品-门店”关联数据
	 * @return
	 */
	ResultCode save(List<BSGoodsStoreVo> list);
	
	/**
	 * 获取“商品-门店”关联数据
	 * @return
	 */
	ResultCode<List<BSGoodsStoreVo>> getBSGoodsStoreListByGoodsId(Long goodsId);
	
}
