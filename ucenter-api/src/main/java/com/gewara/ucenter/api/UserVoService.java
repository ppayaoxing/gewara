/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.user.UserVo;
import java.util.List;

public interface UserVoService {
	ResultCode<UserVo> getUserVoById(Long arg0);

	ResultCode<List<UserVo>> getUserVoListByIdList(Long... arg0);
}