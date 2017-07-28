/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaProfileVo;
import com.gewara.drama.vo.DramaRaidersVo;
import com.gewara.drama.vo.DramaVo;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface DramaVoService {
	ResultCode<List<DramaVo>> getDramaList(Long arg0);

	ResultCode<DramaVo> getDramaById(Long arg0);

	ResultCode<List<DramaVo>> getDramaListByIdList(Long... arg0);

	ResultCode<Boolean> getDramaBooking(Long arg0);

	ResultCode<List<Integer>> getDramaPriceListByDramaid(Long arg0);

	ResultCode<List<DramaVo>> getDramaListByUpdatetime(Timestamp arg0, int arg1, int arg2);

	ResultCode<List<DramaRaidersVo>> getDramaRaidersListByDramaid(Long arg0);

	ResultCode<DramaProfileVo> getDramaProfileByDramaid(Long arg0);

	ResultCode<List<DramaProfileVo>> getDramaProfileByDramaidList(Long... arg0);

	ResultCode<List<DramaVo>> getHotDrama(String arg0, String arg1, int arg2, int arg3);

	ResultCode<List<DramaVo>> getDramaListByStarid(Long arg0, boolean arg1, int arg2, int arg3);

	ResultCode<Integer> getDramaCountByStarid(Long arg0, boolean arg1);

	ResultCode<List<DramaVo>> getFutureDramaList(String arg0, Date arg1, int arg2, int arg3);

	ResultCode<DramaVo> getDramaByName(String arg0);

	ResultCode<List<DramaVo>> getDramaListByName(String arg0);

	ResultCode<List<Long>> getDramaIdListByReserve();

	ResultCode<List<DramaVo>> getDramaSomeDayCalendar(String arg0, Date arg1, int arg2, int arg3);
}