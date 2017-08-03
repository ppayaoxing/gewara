package com.gewara.drama.admin.dubbo.order;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SellDramaSeatVo;

public interface SellDramaSeatAdminVoService {
	
	ResultCode<List<SellDramaSeatVo>> getDramaOrderSeatList(Long orderid);
	
	ResultCode<List<SellDramaSeatVo>> getSellDramaSeatList(Long dpid, Long areaid);

}
