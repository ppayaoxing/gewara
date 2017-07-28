/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface PartnerContractPayVoService {
	ResultCode sendSignMsg(PartnerCommonReqVo arg0);

	ResultCode doSign(PartnerCommonReqVo arg0);

	ResultCode unSign(PartnerCommonReqVo arg0);

	ResultCode sendPayMsg(PartnerCommonReqVo arg0);

	ResultCode doPay(PartnerCommonReqVo arg0);

	ResultCode<List<Map>> querySignContents(String arg0, String arg1);
}