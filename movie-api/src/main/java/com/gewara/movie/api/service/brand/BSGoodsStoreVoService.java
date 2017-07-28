/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.brand;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BSGoodsStoreVo;
import java.util.List;

public interface BSGoodsStoreVoService {
	ResultCode save(List<BSGoodsStoreVo> arg0);

	ResultCode<List<BSGoodsStoreVo>> getBSGoodsStoreListByGoodsId(Long arg0);
}