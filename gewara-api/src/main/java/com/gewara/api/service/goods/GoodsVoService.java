package com.gewara.api.service.goods;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsExtraVo;
import com.gewara.api.vo.goods.GoodsVo;


public interface GoodsVoService {
	
	ResultCode<List<GoodsVo>> getGoodsByTagAndRelatedid(String tag, Long relatedid);
	/**
	 * 根据goodsId获取Goods详细数据
	 * @param goodId
	 * @return
	 */
	ResultCode<GoodsVo> getBaseGoodsById(Long goodId);
	
	/**
	 * 获取物品可下单数量
	 * @param goodids
	 * @return
	 */
	ResultCode<Map<Long, Integer>> getGoodsMapAllownum(Long ... goodids);

	/**
	 * 预售前提醒<b>memberid</b>
	 * @param memberid
	 * @param goodsid
	 * @return
	 */
	ResultCode<Boolean> addRemindMe(Long memberid, String mobile, Long goodsid);
	
	/**
	 * <b>goodsid</b>中提醒人总数
	 * @param goodsid
	 * @return
	 */
	ResultCode<Integer> getRemindCount(Long goodsid);
	
	/**
	 * 判断<b>memberid</b>是否已经添加到提醒名单.<br/>
	 * 分两步判断：
	 * 1: goodsid + memberid 联合查询，如果有结果，则说明这个memberid已经在提醒列表里了，返回<br/>
	 * 2: goodsid + mobile 联合查询，如果有结果，则说明这个mobile已经在提醒列表里了，返回
	 * @param memberid
	 * @param goodsid
	 * @return
	 */
	ResultCode<Boolean> isMeInRemindList(Long memberid, Long goodsid, String mobile);
	
	/**
	 * 聚合页面接口
	 * @param memberid 登录用户的标识
	 * @param mobile   手机号码
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsList(Long memberid,String mobile);
	
	
	/**
	 * 获取同级的Goods数据(即describeId相等的数据)
	 * @param describeId
	 * @return
	 */
	ResultCode<List<GoodsVo>> getSameLevelGoodsList(Long describeId);
	
	
	ResultCode<List<GoodsVo>>getGoodsListByTagOrItemtypeFixedsmalltype(final String tag, final Long relatedid, String order, boolean asc, int from, int maxnum);
	ResultCode<GoodsVo> getBindGoodsVo(Long mpid, String appkey);
	/**
	 * 查Goods详情数据
	 * @return
	 */
	ResultCode<GoodsVo> getGoods(Long goodsid);
	/**
	 * 有线上卖品的影院ID列表，根据数量排序
	 * @param citycode
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByGoods(String citycode);
	/**
	 * 根据tag和状态获取影院列表
	 * @param tag
	 * @param status
	 * @return
	 */
	ResultCode<List<Long>> getCinemaVoByTag(String tag, String status);
	/**
	 * 查GoodsExtraVo数据
	 * @return
	 */
	ResultCode<List<GoodsExtraVo>> getGoodsExtraList(Long... goodsids);
	/**
	 * 查询影院套餐
	 * @param relatedid
	 * @param isGift
	 * @param order
	 * @param asc
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsListByBmhAndGift(Long relatedid, boolean isGift, String order, boolean asc, int from, int maxnum);
	/**
	 * 
	 * 根据场馆或项目查询物品信息
	 * @param tag
	 * @param relatedid
	 * @param smalltype
	 * @param order
	 * @param asc
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsListByTagOrItemtype(String tag, Long relatedid, String smalltype, String order, boolean asc, int from, int maxnum);
	/**
	 * 根据ID取得goosextra 
	 * @param id
	 * @return
	 */
	ResultCode<GoodsExtraVo> getGoodsExtraVoById(Long id);
	
	/**
	 * 
	 * 根据项目查询物品信息
	 * @param itemid
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsListByItemid(Long itemid);
	/**
	 * 
	 * 根据IDList查询goods
	 * @param idList  ID集合
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsListByIdList(List<Long> idList);
	/**
	 * 
	 * 根据smailid查询活动物品信息
	 * @param itemid
	 * @return
	 */
	ResultCode<List<GoodsVo>> getGoodsListBySmalId(Long smalid);
	/**
	 * 在下单之前校验计数器
	 * @param goodsid
	 * @return
	 */
	ResultCode<Map<String, Integer>> checkSpcounterBeforeAddOrder(Long goodsid);
	/**
	 * 获取物品计数器信息
	 * @param goodsid
	 * @return
	 */
	public ResultCode<Map<Long,Map<String, Integer>>> getSpcounter(List<Long> goodsid);
	
}
