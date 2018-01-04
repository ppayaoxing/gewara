package com.gewara.movie.api.service.brand;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BrandStoreVo;

public interface BrandStoreVoService {
	
	/**
	 * 查询门店列表
	 * @param from
	 * @param to
	 * @param citycode
	 * @param brandId
	 * @param status
	 * @return
	 */
	ResultCode<List<BrandStoreVo>> getBrandStoreInfoByBrandId(int from, int to,String citycode,Long brandId,Byte status);
	
	/**
	 * 获取门店的数量 
	 * @param brandid	品牌id
	 * @param citycode	城市code
	 * @return
	 */
	ResultCode<Integer> getBrandStoreCount(Long brandid,String citycode);
	
	/**
	 * 根据id获取门店的数据
	 * @param id
	 * @return
	 */
	ResultCode<BrandStoreVo> getBrandStore(Long id);
	/**
	 * 根据名称获取门店的数据
	 * @param id
	 * @return
	 */
	ResultCode<BrandStoreVo> getBrandStoreByName(String name);
	/**
	 * 模糊搜索
	 * @param storeName 门店名称或地址
	 * @return
	 */
	ResultCode<List<BrandStoreVo>> search(String storeNameOrAddress);
	/**
	 * 保存门店数据
	 * @return
	 */
	ResultCode save(BrandStoreVo bs);
	/**
	 * 保存门店数据
	 * @return
	 */
	ResultCode saveObjectList(List<BrandStoreVo> list);
	/**
	 * 删除门店
	 * @param id
	 * @return
	 */
	ResultCode removeById(Long id);

	/**
	 * 查询门店列表
	 * @param from
	 * @param to
	 * @param citycode
	 * @param brandId
	 * @param status
	 * @return
	 */
	ResultCode<List<BrandStoreVo>> getBrandStoreListByIdList(List<Long> idList);
	/**
	 * 查询门店列表
	 * @param goodsid 物品ID
	 * @param pointx 当前经度
	 * @param pointy 当前维度
	 * @return
	 */
	ResultCode<List<BrandStoreVo>> getBrandStoreListByGoodsId(Long goodsid, String pointx, String pointy, int from, int maxnum);
}
