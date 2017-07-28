/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.BaseMemberVo;
import com.gewara.api.partner.res.vo.MemberECardVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface PartnerMemberVoService {
	ResultCode<BaseMemberVo> getMemberByMemberid(PartnerCommonReqVo arg0);

	ResultCode<String> bindCard(PartnerCommonReqVo arg0);

	ResultCode getBindMobileDynamicNumber(PartnerCommonReqVo arg0);

	ResultCode bindMobile(PartnerCommonReqVo arg0);

	ResultCode<Integer> bindVipCard(PartnerCommonReqVo arg0);

	ResultCode<List<MemberECardVo>> getMemberECardList(PartnerCommonReqVo arg0);

	ResultCode<MemberECardVo> getCardDetailByCardno(String arg0, String arg1, String arg2, String arg3);
}