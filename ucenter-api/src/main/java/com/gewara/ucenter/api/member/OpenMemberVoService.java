package com.gewara.ucenter.api.member;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.support.ErrorCode;
import com.gewara.ucenter.vo.member.MemberRegInfoVo;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenMemberVo;

/**
 * 外部商家合作登录账号信息接口
 * 
 * @author shenlibin
 */
public interface OpenMemberVoService {
	/**
	 * 根据source,loginName查询联名登录用户
	 * 
	 * @param source
	 * @param loginName
	 * @return
	 */
	ResultCode<OpenMemberVo> getOpenMemberByLoginname(String source, String loginName);

	/**
	 * 合作商联名登录接口
	 * 
	 * @param source
	 * @param citycode
	 * @param loginName
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> partnerJointLogin(String source, String citycode, String loginName, String remoteIp);
	/**
	 * 根据memberid获取关联开放账户
	 * @param memberid
	 * @return
	 */
	ResultCode<List<OpenMemberVo>> getOpenMemberListByMemberid(Long memberid);
	/**
	 * 根据udi获取关联开发账户
	 * uidList.size()<=1000
	 * @param source
	 * @param 
	 * @return
	 */
	ResultCode<Map<Long, Map>> getOpenMemberByUidList(String source, List<String> uidList);
	/**
	 * 根据memberid获取关联开放账户
	 * @param memberid
	 * @param source
	 * @return
	 */
	ResultCode<List<OpenMemberVo>> getOpenMemberListByMemberidSource(Long memberid, String source);
	
	/**
	 * 修改开放账户信息
	 * @param openMemberVo
	 * @param unionid
	 * @param cloumn 针对 对象，要修改的对象属性列表
	 * @return
	 */
	ResultCode<OpenMemberVo> updateOpenMember(OpenMemberVo openMemberVo,String unionid, String [] cloumn);
	@Deprecated
	ErrorCode<MemberRegInfoVo> regMemberWithMobile1(String nickname, String mobile, String password, String checkpass, Long inviteid, String invitetype, String regfrom, String ip);
	@Deprecated
	ErrorCode<MemberRegInfoVo> createMemberWithBindMobile1(String mobile, String checkpass, String ip);
	
	ResultCode<MemberRegInfoVo> regMemberWithMobile2(String nickname, String mobile, String password, String checkpass, Long inviteid, String invitetype, String regfrom, String ip);
	
	ResultCode<MemberRegInfoVo> createMemberWithBindMobile2(String mobile, String checkpass, String ip);	
	
	/**
	 * 第三方账户解绑功能
	 * @param memberid 用户id
	 * @param source 第三方标识
	 * @param reson  原因
	 * @param adminid  后台操作人id
	 * @param adminname   后台操作人姓名
	 * @return
	 */
	ResultCode cancelOpenMemberBySource(Long memberid, String source, String reson, Long adminid, String adminname);
}
