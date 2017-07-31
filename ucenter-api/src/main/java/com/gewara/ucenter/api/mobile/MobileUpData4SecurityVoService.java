package com.gewara.ucenter.api.mobile;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MobileUpData4SecurityVo;

public interface MobileUpData4SecurityVoService {
	
	ResultCode<MobileUpData4SecurityVo> getMobileUpData4SecurityByKey(String key);
	
	ResultCode saveOrUpdataMobileUpData4Security(MobileUpData4SecurityVo mud);
}
