package com.gewara.ucenter.api.member;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.ChargeVo;
import com.gewara.ucenter.vo.member.EncodeDataVo;
import com.gewara.ucenter.vo.member.MemberAccountVo;
import com.gewara.ucenter.vo.member.MemberInfoVo;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.PersonDescribes;

/**
 * 用户信息接口
 * @author user
 *
 */
public interface MemberVoService {
	/**
	 * 查询用户信息
	 * 此方法拆分成 下面的getUserInfo2和 gewara-api.jar TicketRollCallVoService.isTicketRollCallMember 两方法组成
	 * @param mobile
	 * @return
	 */
	ResultCode<Map<String, Object>> getUserInfo2(Long memberid, String mobile, String email);
	ResultCode<MemberVo> getMemberVo(Long memberid);
	
	/**
	 * 批量查询用户信息
	 * memberids<=1000
	 * @param memberids
	 * @return
	 */
	ResultCode<List<MemberVo>> getMemberVoList(Long... memberids);
	
	/**
	 * 查询用户信息
	 * @param memberid
	 * @return
	 */
	ResultCode<MemberInfoVo> getMemberInfoVo(Long memberid);
	
	/**
	 * 查询用户列表信息，memberids<=1000
	 * @param memberids
	 * @return
	 */
	ResultCode<List<MemberInfoVo>> getMemberInfoVoList(Long ... memberids);
	
	/**
	 * 获取帐户用户信息
	 * @param memberid
	 * @return
	 */
	ResultCode<MemberAccountVo> getMemberAccountVoByMemberid(Long memberid);
	
	ResultCode updateMemberCount(Long memberid, String key, int value, boolean isAdd);
	
	/**
	 * 获取用户的头像
	 * @param memberid
	 * @return
	 */
	ResultCode<String> getCacheMemberHeadpic(Long memberid);
	/**
	 * 获取用户头像集合 memberidList<=1000
	 * @param memberidList
	 * @return
	 */
	ResultCode<Map<Long, String>> getCacheHeadpicMap(Collection<Long> memberidList);
	/**
	 * 获取用户的信息 memberidList<=1000
	 * @param memberidList
	 * @return
	 */
	ResultCode<Map<Long, Map>> getCacheMemberInfoMap(Collection<Long> memberidList);
	ResultCode<Map> getCacheMemberInfo(Long memberid);
	/**
	 * 刷新用户缓存
	 * @param memberid
	 * @return
	 */
	ResultCode<Map> resetMemberCache(Long memberid);
	/**
	 * 是否为购票用户
	 * @param memberid
	 * @param tag
	 * @param id
	 * @return
	 */
	ResultCode<Boolean> isPlayMemberByTagAndId(Long memberid, String tag, Long id);
	ResultCode<Map> getPlayMemberByTagAndId(Long memberid, String tag, Long id);
	/**
	 * 根据手机号获取用户昵称、会员id
	 * mobileList.size()<=1000
	 */
	ResultCode<Map<Long, Map>> getMemberByMobile(List<String> mobileList);
	
	ResultCode<Integer> getUserChargeCount(Long memberid, Timestamp starttime, Timestamp endtime);
	ResultCode<List<ChargeVo>> getUserCharge(Long memberid, Timestamp starttime, Timestamp endtime, int from, int maxnum);
	/**
	 * @param mobile
	 * @return
	 */
	ResultCode<MemberInfoVo> getMemberInfoByMobile(String mobile);
	/**
	 * 获取单个用户的个人简介
	 * @param memberid
	 * @return
	 */
	ResultCode<String> getPersonDescribe(Long memberid);
	/**
	 * 获取一组用户的个人简介,memberidList.size()<=1000
	 * @param memberidList
	 * @return
	 */
	ResultCode<Map<Long,String>> getPersonDescribeByMemberidList(List<Long> memberidList);
	/**
	 * 保存个人简介
	 * @param memberid
	 * @param describe
	 * @return
	 */
	ResultCode savePersonDescribe(Long memberid, String describe, String source);
	
	ResultCode<PersonDescribes> getPersonDescribeMap(Long memberid);
	
	/**
	 * 根据手机号码获取用户信息
	 * @param mobile 用户手机号码
	 */
	ResultCode<MemberVo> getMemberVoByMobile(String mobile);
	
	/**
	 * 根据邮箱地址获取用户信息
	 * @param email 注册邮箱地址
	 */
	ResultCode<MemberVo> getMemberVoByEmail(String email);
	
	/**
	 *  是否需要手机短信安全验证
	 * @param securityCode
	 * @param deviceId
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> isMobileSecurityVerify(String securityCode, String deviceId, Long memberid);
	/**
	 * 增加手机短信安全认证
	 * @author qilun
	 * Feb 23, 2016
	 * @param deviceId
	 * @param memberid
	 * @return
	 */
	ResultCode<String> addMobileSecurityVerify(String deviceId, Long memberid);
	/**
	 * 获取手机上行短信相关信息（上行码，随机码）
	 * @param deviceId
	 * @param memberid
	 * @return
	 */
	ResultCode<Map<String, String>> getMobileSecurityUpdata(String deviceId, Long memberid);
	/**
	 * 通过短信上行的方式增加手机短信安全认证
	 * @param deviceId
	 * @param memberid
	 * @return
	 */
	ResultCode<String> addMobileSecurityVerify4MobileUpdata(String deviceId, Long memberid);

	/**
	 * @function 用户手机号唯一性检测
	 */
	boolean isMemberMobileExists(String mobile); 
	
	/**
	 * 绑定手机
	 * @param member
	 * @param mobile
	 * @param checkpass
	 * @param ip
	 * @return
	 */
	ResultCode<MemberVo> bindMobile(Long memberid, String mobile, String checkpass, String remoteIp, boolean isInitBind);

	/**
	 * 解除手机绑定
	 * @param member
	 * @param dynamicCode
	 * @param remoteIp
	 * @return
	 */
	ResultCode unbindMobile(Long memberid, String checkpass, String remoteIp);

	/**
	 * 判断是否有Emai、昵称相同的用户
	 * @param emailOrNicknameOrMobile
	 * @param memberId
	 * @return
	 */
	ResultCode<Boolean> isMemberExistsByEmail(String emailOrNickname, Long memberId);


	/**
	 * 是不能解绑或更换手机号
	 * @param member
	 * @return
	 */
	ResultCode<Boolean> canChangeMobile(Long memberid);
	
	/**
	 * 通过email取用户
	 * @param email
	 * @return
	 */
	ResultCode<MemberVo> getMemberByEmail(String email);
	
	ResultCode<MemberVo> isValidMemberPass(String loginName, String plainPass, String ip, String userAgent, String ckcitycode, String port);

	/**
	 * 新手任务
	 */
	ResultCode<MemberInfoVo> saveNewTask(Long memberid, String newtask);
	
	/**
	 * 根据手机号码查询用户
	 * @param mobile
	 * @return
	 */
	ResultCode<MemberVo> getMemberByMobile(String mobile);
	
	ResultCode<Integer> getInviteCountByMemberid(Long memberid, Timestamp startTime, Timestamp endTime);
	
	ResultCode updateMemberInfo(Long memberid, String nickname, String sex, String realname);

	ResultCode<MemberInfoVo> updateHeadPic(Long memberid, String headpic);
	
	/**
	 * 修改用户密码
	 * @param member
	 * @param password  输入的密码
	 * @param remoteIp  IP
	 * @param isBind2Gewara  联名登录用户绑定Gewara账号
	 * @param from  来源
	 * @return 
	 */
	ResultCode changePassword(Long memberid, String password, String remoteIp, String from);

	ResultCode<MemberInfoVo> addMemberOtherInfo(Long memberid, String tag, String value);	
	/**
	 * 修改用户需要上行短信验证
	 * @param memberid
	 * @return
	 */
	ResultCode updateMemberNeedValidSetY(Long memberid);
	/**
	 * 成功邀请好友次数，并且已绑定手机
	 * @return
	 */
	ResultCode<Integer> getInviteCount(String invitetype, Long inviteid);
	/**
	 * 根据原密码修改新密码
	 * @param memberid		用户id
	 * @param password		原密码
	 * @param password1		新密码
	 * @param password2		确认新密码
	 * @param ip		
	 * @param from			操作mapping
	 * @param encodeOrSessid 刷新
	 * @return
	 */
	ResultCode changePasswordByOldpass(Long memberid, String password, String password1, String password2, String ip, String from, String encodeOrSessid);
	/**
	 * 
	 * @param tag
	 * @param mobile
	 * @param checkpass
	 * @param newpwd
	 * @param repassword
	 * @param ip
	 * @param from
	 * @param encodeOrSessid
	 * @return
	 */
	ResultCode<MemberVo> changePasswordByMobileCode(String tag, String mobile, String checkpass, String newpwd, String repassword, String ip, String from, String encodeOrSessid);
	/**
	 * 是否做密码有效性验证
	 * @param memberEncode
	 * @param doValidate
	 * @return
	 */
	ResultCode<EncodeDataVo> getMemberEncodeDataVo(String memberEncode, boolean doValidate);
	/**
	 * 根据邮件encode修改邮箱
	 * @param memberid 	用户id
	 * @param email		新邮箱
	 * @param random		加密参数
	 * @param encode		
	 * @param ip
	 * @param encodeOrSessid
	 * @return
	 */
	ResultCode exchangeEmail(Long memberid, String email, String random, String encode, String ip, String encodeOrSessid);
	/**
	 * 发送邮箱修改邮件
	 * @param memberid
	 * @param email1
	 * @param email2
	 * @param password
	 * @param ip
	 * @return
	 */
	ResultCode sendExchangeEmail(Long memberid, String type, String email1, String email2, String password, String ip);
}
