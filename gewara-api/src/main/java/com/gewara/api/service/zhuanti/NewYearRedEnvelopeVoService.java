/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.zhuanti;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.RedEnvelopeManagerVo;
import com.gewara.api.vo.order.GewaOrderVo;

public interface NewYearRedEnvelopeVoService {
	ResultCode<RedEnvelopeManagerVo> findRedEnvelopeManager(GewaOrderVo arg0);

	ResultCode<String> findRedEnvelopeByRelatedId(Long arg0);
}