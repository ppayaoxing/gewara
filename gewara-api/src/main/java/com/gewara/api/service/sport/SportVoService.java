package com.gewara.api.service.sport;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.sport.SportVo;

public interface SportVoService {

	/** 通过id获取SportVo
	 * @param sportid
	 * @return
	 */
	ResultCode<SportVo> getSportVoById(Long sportid); }
