package com.gewara.api.service.goods;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.GoodsExtraPriceVo;
import com.gewara.api.vo.goods.GoodsVo;
import com.gewara.api.vo.goods.TeamShareVo;

public interface TeamVoService {

	ResultCode<TeamShareVo> getTeamShareById(Long shareid);
	
	ResultCode<TeamShareVo> getTeamShareByCode(String shareCode);
	
	ResultCode<Map<Long, Map>> getTeamMemberList(Long shareid);
	
	ResultCode<List<GoodsExtraPriceVo>> getGoodsPriceList(Long goodsid);
	
	ResultCode<GoodsVo> getGoodsById(Long goodsid);
	
	ResultCode<Boolean> isFinish2(Long shareid, Long goodsid);
	ResultCode<GoodsExtraPriceVo> getExtPriceById(Long extid);
	
}
