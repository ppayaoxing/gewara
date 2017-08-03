package com.gewara.drama.dubbo;

import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaStarVo;

public interface DramaStarVoService {
	
	ResultCode<DramaStarVo> getDramaStarById (Long id);

	ResultCode<List<DramaStarVo>> getDramaStarList (Collection<Long> idList);
	
	ResultCode<List<DramaStarVo>> getStarListByStateAndName(String state, String name, String type, int from, int maxnum);
	
	ResultCode<List<DramaStarVo>> getDramaStarListByDramaid(Long dramaid, String starType, int from, int maxnum, String...notNullPropertys);
}
