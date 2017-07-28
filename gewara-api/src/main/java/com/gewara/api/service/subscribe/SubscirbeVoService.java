/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.subscribe;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.movie.SubscribeVo;
import java.util.List;

public interface SubscirbeVoService {
	ResultCode<String> getSubscribeList(String arg0, String arg1, int arg2, int arg3);

	ResultCode<List<SubscribeVo>> getSubscribeList(Long arg0, int arg1, int arg2);
}