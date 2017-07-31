package com.gewara.ucenter.api.member;


import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberPointVo;
/*
 * pengdi 
 * 2014年10月29日
 * 获取积分的定义的接口
 */
public interface MemberPointVoService {
	ResultCode<MemberPointVo> getWapPointType(String encodeOrSessid, String remoteIp);
	
	ResultCode<List<MemberPointVo>> getLuckPoint(Integer topnum);
	
	ResultCode<List<MemberPointVo>> getMyPointList(String encodeOrSessid, String remoteIp, Integer pageno, Integer pagesize, Integer datenum);

	ResultCode<String> checkSharePointByWeixin(String encodeOrSessid, String remoteIp, String pointType); 
	
	ResultCode<MemberPointVo> getDayPoint(String encodeOrSessid, String remoteIp, String pointType);
	
	ResultCode<Integer> getOrderPointByMemberIdAndTradeNo(Long memberId,String tradeNo);

	ResultCode getPointGiftByDay(Long memberid, Timestamp cur);
	//新每日登录积分
	ResultCode<Integer> addLoginPointNew(Long memberid);
	/**
	 * 每日答题积分
	 */
	ResultCode<Integer> getAnswerPoint(Long memberid, Timestamp cur);
	/**
	 * 给用户减少积分
	 * @param memberid
	 * @param pointvalue  一定是负数
	 * @param reason
	 * @return
	 */
	ResultCode<String> reducePoint(Long memberid, Integer pointvalue, String tag, String reason);
	/**
	 * 添加积分
	 * 
	 * @param memberid
	 * @param pointvalue
	 * @param tag
	 * @param reason
	 * @return
	 */
	ResultCode<String> addPoint(Long memberid, Integer pointvalue, String tag, String reason);
}
