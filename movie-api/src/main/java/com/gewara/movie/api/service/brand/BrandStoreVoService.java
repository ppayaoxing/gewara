/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.brand;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BrandStoreVo;
import java.util.List;

public interface BrandStoreVoService {
	ResultCode<List<BrandStoreVo>> getBrandStoreInfoByBrandId(int arg0, int arg1, String arg2, Long arg3, Byte arg4);

	ResultCode<Integer> getBrandStoreCount(Long arg0, String arg1);

	ResultCode<BrandStoreVo> getBrandStore(Long arg0);

	ResultCode<BrandStoreVo> getBrandStoreByName(String arg0);

	ResultCode<List<BrandStoreVo>> search(String arg0);

	ResultCode save(BrandStoreVo arg0);

	ResultCode saveObjectList(List<BrandStoreVo> arg0);

	ResultCode removeById(Long arg0);

	ResultCode<List<BrandStoreVo>> getBrandStoreListByIdList(List<Long> arg0);

	ResultCode<List<BrandStoreVo>> getBrandStoreListByGoodsId(Long arg0, String arg1, String arg2, int arg3, int arg4);
}