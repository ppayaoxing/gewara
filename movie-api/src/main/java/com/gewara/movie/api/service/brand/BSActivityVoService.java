/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.brand;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BSActivityVo;
import java.util.List;

public interface BSActivityVoService {
	ResultCode<BSActivityVo> getActivityDataById(Long arg0);

	ResultCode<BSActivityVo> save(BSActivityVo arg0);

	ResultCode<List<BSActivityVo>> getActivityListByActType(String arg0, String arg1);

	ResultCode<List<BSActivityVo>> getActivityList(String arg0);

	ResultCode<Integer> getActivityCount();

	ResultCode<List<BSActivityVo>> getActivityList(int arg0, int arg1, String arg2);

	ResultCode deleteById(Long arg0);
}