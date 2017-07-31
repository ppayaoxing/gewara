package com.gewara.api.service.membermerge;


import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface MemberMergeVoService {
  
	ResultCode<Map<String, Object>> getBindMemberInfo(Long bindMemberId);
	
	/**
	 * 绑定用户的优惠活动
	 * @param fromMemberid
	 * @param toMemberid
	 * @param memberMergerHisid
	 * @return
	 */
	ResultCode<String> bindSpCode(Long fromMemberid, Long toMemberid, Long memberMergerHisid);
	/**
	 * 绑定用户的优惠券
	 * @param fromMemberid
	 * @param toMemberid
	 * @param memberMergerHisid
	 * @return
	 */
	ResultCode<String> bindElecard(Long fromMemberId, Long toMemberId, Long memberMergerHisid);
	/**
	 * 用户曾经喜欢
	 * @param fromMemberid
	 * @param toMemberid
	 * @param memberMergerHisid
	 * @return
	 */
	ResultCode<String> bindTreasure(Long fromMemberId, Long toMemberId, Long memberMergerHisid);
	/**
	 * 同步用户去过
	 * @param fromMemberid
	 * @param toMemberid
	 * @param memberMergerHisid
	 * @return
	 */
	ResultCode<String> bindMemberCount(Long fromMemberId, Long toMemberId, Long memberMergerHisid);
	/**
	 * 创建微信卡包
	 * @param tradeNo
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode<Map<String, Object>> createCardTicket(String tradeNo, String encodeOrSessid, String remoteIp);
}
