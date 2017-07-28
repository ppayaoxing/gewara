/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.OpenDramaItemExtVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import java.util.Collection;
import java.util.List;

public interface DpiVoService {
	ResultCode<OpenDramaItemVo> getOpenDramaItemByDpid(Long arg0);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDpid(Long... arg0);

	ResultCode<DramaPlayItemVo> getDramaPlayItemById(Long arg0);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListById(Long... arg0);

	ResultCode<Integer> getDramaPlayItemCountByDramaid(Long arg0);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByCitycode(String arg0, Long arg1, boolean arg2,
			boolean arg3);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListCache(String arg0, Long arg1, Long arg2, boolean arg3,
			boolean arg4);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemExpireListByTheatreid(Long arg0, Long arg1);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByTheatreid(Long arg0, Long arg1, boolean arg2, boolean arg3);

	ResultCode<Boolean> isBookingByDramaId(Long arg0);

	ResultCode<OpenDramaItemExtVo> getOdiExtbyDpid(Long arg0);

	ResultCode<List<OpenDramaItemExtVo>> getOdiExtbyDpidList(Collection<Long> arg0);
}