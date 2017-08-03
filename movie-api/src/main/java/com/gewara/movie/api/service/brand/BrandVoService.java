package com.gewara.movie.api.service.brand;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BrandVo;

public interface BrandVoService {
	
	/**
	 * 根据品牌名称查询品牌数据
	 * @param brandName	品牌名称
	 * @return
	 */
	ResultCode<BrandVo> getBrandByName(String brandName);
	
	/**
	 * 根据品牌id查询品牌数据
	 * @param id 品牌id
	 * @return
	 */
	ResultCode<BrandVo> getBrandById(Long id);
	
	/**
	 * 查询品牌列表
	 * @return
	 */
	ResultCode<List<BrandVo>> getBrandList(int from,int to);
	
	/**
	 * 搜索品牌列表
	 * @param brandName
	 * @return
	 */
	ResultCode<List<BrandVo>> searchBrandListByName(String brandName);
	
	/**
	 * 查询品牌数据量
	 * @return
	 */
	ResultCode<Integer> getBrandCount();
	
	/**
	 * 保存品牌数据
	 * @return
	 */
	ResultCode save(BrandVo brand);
	/**
	 * 查询品牌列表根据IDLIST
	 * @return
	 */
	ResultCode<List<BrandVo>> getBrandListByIdList(List<Long> idList);
	
}
