package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface MSQMAppAuthorizeVoService {
	
	/**
	 * 民生其妙app 密文登录
	 * @param context 密文
	 * @return
	 */
	ResultCode<OpenResultVo> getMSQMLoginMemberVoByContext(String context, String remoteIp);
}
