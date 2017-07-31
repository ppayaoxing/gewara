package com.gewara.api.partner.service;

import java.util.List;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.BaseMemberVo;
import com.gewara.api.partner.res.vo.MemberECardVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerMemberVoService {
	/**
	 * 根据memberid获取用户信息
	 * @param reqVo
	 * @return
	 */
	ResultCode<BaseMemberVo> getMemberByMemberid(PartnerCommonReqVo reqVo);
	/**
	 * 用户绑定券
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> bindCard(PartnerCommonReqVo reqVo);
	/**
	 * 获取绑定手机号的动态码
	 * @param reqVo
	 * @return
	 */
	ResultCode getBindMobileDynamicNumber(PartnerCommonReqVo reqVo);
	/**
	 * 用户绑定手机号
	 * @param reqVo
	 * @return
	 */
	ResultCode bindMobile(PartnerCommonReqVo reqVo);
	/**
	 * 贵宾卡充值
	 * @param reqVo
	 * @return
	 */
	ResultCode<Integer> bindVipCard(PartnerCommonReqVo reqVo);
	/**
	 * 获取用户的电子券列表
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<MemberECardVo>> getMemberECardList(PartnerCommonReqVo reqVo);
	/**
	 * 获取票券详细，为H5卡券详细页使用
	 * @param appkey
	 * @param cardno
	 * @return
	 */
	ResultCode<MemberECardVo> getCardDetailByCardno(String appkey, String memberEncode, String remoteIp, String cardno);
	
}
