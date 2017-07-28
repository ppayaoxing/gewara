/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.res.vo.PhoneAdvertisementVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface PhoneAdvertisementVoService {
	ResultCode<PhoneAdvertisementVo> getPhoneAdverVo(Long arg0);

	ResultCode<Map<String, Long>> getCitycodesByBatchid(String arg0);

	ResultCode<List<Map<String, String>>> getLinkedListBySourceId(Long arg0, Long arg1);

	ResultCode<Long> getSameLevelIdByCitycode(Long arg0, String arg1);

	ResultCode<List<PhoneAdvertisementVo>> getPhoneAdvertList(String arg0, String arg1, String arg2, String arg3);
}