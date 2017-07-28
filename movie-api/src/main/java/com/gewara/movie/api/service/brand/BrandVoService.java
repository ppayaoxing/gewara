/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.brand;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BrandVo;
import java.util.List;

public interface BrandVoService {
	ResultCode<BrandVo> getBrandByName(String arg0);

	ResultCode<BrandVo> getBrandById(Long arg0);

	ResultCode<List<BrandVo>> getBrandList(int arg0, int arg1);

	ResultCode<List<BrandVo>> searchBrandListByName(String arg0);

	ResultCode<Integer> getBrandCount();

	ResultCode save(BrandVo arg0);

	ResultCode<List<BrandVo>> getBrandListByIdList(List<Long> arg0);
}