/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.baochang;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangRoomDescVo;
import java.util.List;
import java.util.Map;

public interface BaoChangRoomDescVoService {
	ResultCode<BaoChangRoomDescVo> getRoomDescById(String arg0);

	ResultCode<List<BaoChangRoomDescVo>> getRoomDescListByRoomId(Long arg0);

	ResultCode<Boolean> removeRoomDescById(String arg0);

	ResultCode<BaoChangRoomDescVo> saveRoomDesc(Map<String, String> arg0);
}