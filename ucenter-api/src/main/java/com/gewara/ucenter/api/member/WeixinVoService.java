package com.gewara.ucenter.api.member;

import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.WeixinUserVo;

public interface WeixinVoService {
	/**
	 * 绑定微信账户到已存在的格瓦拉账户
	 * 需要做登录流程
	 * @param appkey
	 * @param userid
	 * @param unionid
	 * @param username
	 * @param password
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> bindWeixin2Gewa(String appkey, String userid, String unionid, String username, String password, String remoteIp);
	/**
	 * 通过code查询是否绑定格瓦拉账户
	 * 需要做登录流程
	 * @param appkey
	 * @param code
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> getUserByCode(String appkey, String code, String remoteIp);
	
	/**
	 * 根据code
	 * @param appkey
	 * @param code
	 * @return
	 */
	ResultCode<WeixinUserVo> getWeixinUserByCodeOnlyGet(String appkey, String code);
	/**
	 * 根据code登录，并返回微信用户信息
	 * @param appkey
	 * @param code
	 * @return
	 */
	ResultCode<WeixinUserVo> getWeixinUserByCode(String appkey, String code);
	/**
	 * 根据userid获取微信用户
	 * @return
	 */
	ResultCode<WeixinUserVo> getWeixinUserByUserid(String appkey, String userid, String unionid);
	/**
	 * 取消绑定
	 * @return
	 */
	ResultCode cancelWeixinUser(String appkey, String userid);
	
	/***
	 * 创建openmember并登录
	 * 需要做登录流程
	 * @param openid 联名登录回传
	 * @param unionid 联名登录回传
	 * @param headiPic
	 * @param nickname
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> createMemberAndBindWeixinUser(String openid, String unionid, String headiPic, String nickname, String remoteIp) ;
	/***
	 * 绑定微信账户
	 * 需要做登录流程
	 * @param username
	 * @param password
	 * @param openid
	 * @param unionid
	 * @param headiPic
	 * @param nickname
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> bindOpenMember2Member (String username,String password, String openid, String unionid, String headiPic, 
			String nickname, String remoteIp);
	
	ResultCode<MemberVo> createOpenmemberByCodeOnlyOpenid(String code, String citycode, String appkey, String remoteIp);
	/**
	 * 绑定账户
	 * 需要做登录流程
	 * @param appkey
	 * @param code
	 * @param uuid 用于回调信息查询的
	 * @param remoteIp
	 * @return
	 */
	ResultCode<Map<String, Object>> bindMemberByCode(String appkey, String code,String uuid, String remoteIp);

	/**
	 * 账户合并
	 * @param uuid currentMemberId
	 * @param unionid bandMemberId
	 * @return
	 */
	ResultCode<Map<String,Object>> mergerMember(String uuid,String unionid,String remoteIp);
	
}
