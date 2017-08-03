package com.gewara.drama.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;

public interface DramaOdiVoService {

	/**
	 * 城市可购票演出项目数
	 * @param citycode
	 * @return
	 */
	ResultCode<Integer> getDramaCountByCitycode(String citycode);
	
	/**
	 * 
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByCitycode(String citycode, int from, int maxnum);
	
	ResultCode<List<Long>> getDramaIdListByCitycode(String citycode, String opentype);
	
	/**
	 * 场馆编号查询可购票项目
	 * @param theatreid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByTheatreid(Long theatreid, int from, int maxnum);
}
