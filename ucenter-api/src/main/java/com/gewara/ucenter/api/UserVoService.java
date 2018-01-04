package com.gewara.ucenter.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.user.UserVo;

public interface UserVoService {
	/**
	 * 获取管理员信息
	 * @param id 管理员id
	 * @return 管理员实体对象
	 */
	ResultCode<UserVo> getUserVoById(Long id);
	/**
	 * 批量获取管理员
	 * @param ids  管理员id数组
	 * @return   管理员实体对象数组
	 */
	ResultCode<List<UserVo>> getUserVoListByIdList(Long ... ids);

}
