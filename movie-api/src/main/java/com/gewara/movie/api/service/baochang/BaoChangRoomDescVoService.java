package com.gewara.movie.api.service.baochang;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangRoomDescVo;

public interface BaoChangRoomDescVoService {
	ResultCode<BaoChangRoomDescVo> getRoomDescById(String id);
	ResultCode<List<BaoChangRoomDescVo>> getRoomDescListByRoomId(Long roomid);
	ResultCode<Boolean> removeRoomDescById(String id);
	ResultCode<BaoChangRoomDescVo> saveRoomDesc(Map<String, String> dataMap);
}
