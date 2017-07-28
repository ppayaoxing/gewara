/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.goods;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsExtraVo;
import com.gewara.api.vo.goods.GoodsVo;
import java.util.List;
import java.util.Map;

public interface GoodsVoService {
	ResultCode<List<GoodsVo>> getGoodsByTagAndRelatedid(String arg0, Long arg1);

	ResultCode<GoodsVo> getBaseGoodsById(Long arg0);

	ResultCode<Map<Long, Integer>> getGoodsMapAllownum(Long... arg0);

	ResultCode<Boolean> addRemindMe(Long arg0, String arg1, Long arg2);

	ResultCode<Integer> getRemindCount(Long arg0);

	ResultCode<Boolean> isMeInRemindList(Long arg0, Long arg1, String arg2);

	ResultCode<List<GoodsVo>> getGoodsList(Long arg0, String arg1);

	ResultCode<List<GoodsVo>> getSameLevelGoodsList(Long arg0);

	ResultCode<List<GoodsVo>> getGoodsListByTagOrItemtypeFixedsmalltype(String arg0, Long arg1, String arg2,
			boolean arg3, int arg4, int arg5);

	ResultCode<GoodsVo> getBindGoodsVo(Long arg0, String arg1);

	ResultCode<GoodsVo> getGoods(Long arg0);

	ResultCode<List<Long>> getCinemaIdListByGoods(String arg0);

	ResultCode<List<Long>> getCinemaVoByTag(String arg0, String arg1);

	ResultCode<List<GoodsExtraVo>> getGoodsExtraList(Long... arg0);

	ResultCode<List<GoodsVo>> getGoodsListByBmhAndGift(Long arg0, boolean arg1, String arg2, boolean arg3, int arg4,
			int arg5);

	ResultCode<List<GoodsVo>> getGoodsListByTagOrItemtype(String arg0, Long arg1, String arg2, String arg3,
			boolean arg4, int arg5, int arg6);

	ResultCode<GoodsExtraVo> getGoodsExtraVoById(Long arg0);

	ResultCode<List<GoodsVo>> getGoodsListByItemid(Long arg0);

	ResultCode<List<GoodsVo>> getGoodsListByIdList(List<Long> arg0);

	ResultCode<List<GoodsVo>> getGoodsListBySmalId(Long arg0);

	ResultCode<Map<String, Integer>> checkSpcounterBeforeAddOrder(Long arg0);

	ResultCode<Map<Long, Map<String, Integer>>> getSpcounter(List<Long> arg0);
}