package com.gewara.drama.admin.dubbo.drama;

import java.util.Date;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreItemPriceVo;

public interface RemoteTheatreAdminVoService {

	ResultCode<List<String>> updateTheatreField(Long theatreid);

	ResultCode<List<String>> updateTheatreRoom(Long fieldid);
	
	ResultCode<List<String>> updateTheatreRoomSeat(Long theatreid);

	ResultCode<List<String>> updateDramaPlayItem(Long theatreid, Date playdate);
	
	ResultCode updateDramaPlayItem(String siseq);
	
	ResultCode<List<String>> updateDramaPlayItem(Long theatreid);
	
	ResultCode<List<String>> refreshAreaSeat(Long dpid);
	
	ResultCode<List<String>> updateTheateSeatArea(Long dpid);
	
	ResultCode<List<String>> updateSeatPrice(Long dpid);
	
	ResultCode<List<String>> updateDisQuantity(Long areaid);
	
	ResultCode<List<TheatreItemPriceVo>> updateTheaterItemPrice(Long dpid);
	
	ResultCode<List<String>> updateSeatPrice(Long dpid, List<Long> areaidList);

	ResultCode<List<String>> refreshOpenTheatreSeat(Long dpid);
}
