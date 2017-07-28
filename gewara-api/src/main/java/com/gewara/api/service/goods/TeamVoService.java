/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.goods;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsExtraPriceVo;
import com.gewara.api.vo.goods.GoodsVo;
import com.gewara.api.vo.goods.TeamShareVo;
import java.util.List;
import java.util.Map;

public interface TeamVoService {
	ResultCode<TeamShareVo> getTeamShareById(Long arg0);

	ResultCode<TeamShareVo> getTeamShareByCode(String arg0);

	ResultCode<Map<Long, Map>> getTeamMemberList(Long arg0);

	ResultCode<List<GoodsExtraPriceVo>> getGoodsPriceList(Long arg0);

	ResultCode<GoodsVo> getGoodsById(Long arg0);

	ResultCode<Boolean> isFinish2(Long arg0, Long arg1);

	ResultCode<GoodsExtraPriceVo> getExtPriceById(Long arg0);
}