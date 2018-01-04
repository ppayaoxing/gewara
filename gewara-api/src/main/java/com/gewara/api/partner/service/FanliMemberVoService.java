package com.gewara.api.partner.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.partner.FanliMemberVo;

public interface FanliMemberVoService {
	/**
	 * 根据id获取返利网用户信息
	 * @param id
	 * @return
	 */
	ResultCode<FanliMemberVo> getFanliMemberById(Long id);
	/**
	 * 更新返利网用户信息
	 */
	ResultCode<Boolean> updateFanliMember(FanliMemberVo member);
}
