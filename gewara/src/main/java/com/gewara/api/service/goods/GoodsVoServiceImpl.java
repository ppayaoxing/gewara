package com.gewara.api.service.goods;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsExtraVo;
import com.gewara.api.vo.goods.GoodsVo;
import com.gewara.service.impl.BaseServiceImpl;

public class GoodsVoServiceImpl extends BaseServiceImpl implements GoodsVoService {

	@Override
	public ResultCode<List<GoodsVo>> getGoodsByTagAndRelatedid(String tag, Long relatedid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GoodsVo> getBaseGoodsById(Long goodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Map<Long, Integer>> getGoodsMapAllownum(Long... goodids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Boolean> addRemindMe(Long memberid, String mobile, Long goodsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> getRemindCount(Long goodsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Boolean> isMeInRemindList(Long memberid, Long goodsid, String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsList(Long memberid, String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getSameLevelGoodsList(Long describeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListByTagOrItemtypeFixedsmalltype(String tag, Long relatedid, String order,
			boolean asc, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GoodsVo> getBindGoodsVo(Long mpid, String appkey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GoodsVo> getGoods(Long goodsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getCinemaIdListByGoods(String citycode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getCinemaVoByTag(String tag, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsExtraVo>> getGoodsExtraList(Long... goodsids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListByBmhAndGift(Long relatedid, boolean isGift, String order, boolean asc,
			int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListByTagOrItemtype(String tag, Long relatedid, String smalltype,
			String order, boolean asc, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GoodsExtraVo> getGoodsExtraVoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListByItemid(Long itemid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListByIdList(List<Long> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<GoodsVo>> getGoodsListBySmalId(Long smalid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Map<String, Integer>> checkSpcounterBeforeAddOrder(Long goodsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Map<Long, Map<String, Integer>>> getSpcounter(List<Long> goodsid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
