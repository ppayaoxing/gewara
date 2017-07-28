/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.OpenCityVo;
import com.gewara.api.partner.res.vo.PhoneActivityVo;
import com.gewara.api.partner.res.vo.UpGradeVo;
import com.gewara.api.partner.res.vo.WeiXinAdVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface PartnerAppVoService {
	ResultCode<String> addComplain(PartnerCommonReqVo arg0);

	ResultCode<UpGradeVo> getUpGrade(PartnerCommonReqVo arg0);

	ResultCode<PhoneActivityVo> getPhoneActivity(PartnerCommonReqVo arg0);

	ResultCode<List<PhoneActivityVo>> getPhoneActivityList(PartnerCommonReqVo arg0);

	ResultCode<WeiXinAdVo> getWeiXinAd(PartnerCommonReqVo arg0);

	ResultCode<List<OpenCityVo>> getOpenCity(PartnerCommonReqVo arg0);
}