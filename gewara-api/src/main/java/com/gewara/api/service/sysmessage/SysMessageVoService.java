package com.gewara.api.service.sysmessage;

import com.gewara.api.vo.ResultCode;

public interface SysMessageVoService {

	/**
	 * 根据后台运营系统消息id获取  图文混排内容
	 * @param id
	 * @return
	 */
	ResultCode<String> getSysMessageContentById(String id);
	
	/**
	 * 重新加载权限列表
	 * @return
	 */
	ResultCode<String> reloadAcl();
}
