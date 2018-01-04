package com.gewara.ucenter.api.member;

import java.sql.Timestamp;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;

public interface MemberLogonVoService {
	/**
	 * 根据sessid和ip登陆
	 * @param sessid
	 * @param ip
	 * @return
	 */
	ResultCode<MemberVo> getLogonMemberBySessid(String sessid, String ip);
	/**
	 * TODO:与上面的合并
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> getLogonMemberByMemberEncodeAndIp(String memberEncode, String remoteIp); 
	/**
	 * 根据memberEncode登陆
	 * @param memberEncode
	 * @return
	 */
	ResultCode<Long> getMemberIdByMemberEncode(String memberEncode);
	/**
	 * 通过用户名和密码登陆
	 * @return
	 */
	ResultCode<MemberVo> loginByNameAndPwd(String appkey, String citycode, String username, String password, String remoteIp);
	/**
	 * 手机号注册
	 * @return
	 */
	ResultCode<MemberVo> mobileReg(String appkey, String citycode, String mobile, String password, String dynamicNumber, String remoteIp);
	/**
	 * 获取注册手机号动态码
	 * @return
	 */
	ResultCode getRegDynamicNumber(String mobile, String remoteIp);
	/**
	 * 获取找回支付密码动态码
	 * @return
	 */
	ResultCode getModifyPwdDynamicNumber(String mobile, String remoteIp);
	/**
	 * 通过手机动态码修改密码
	 * @return
	 */
	ResultCode modifyPwdByDynamicNumber(String mobile, String password, String dynamicNumber, String remoteIp);
	/**
	 * 动态码登录
	 * @param mobile
	 * @param ip
	 * @return
	 */
	ResultCode<String> sendLoginDynamiccode(String mobile, String ip);
	/**
	 * 根据动态码登录
	 * @param mobile
	 * @param checkpass
	 * @param ip
	 * @param citycode
	 * @return
	 */
	ResultCode<MemberVo> loginByDynamiccode(String mobile, String checkpass, String ip, String citycode);
	/**
	 * 新浪微博联名登陆
	 * @param reqVo
	 * @return
	 */
	ResultCode<MemberVo> openMemberLoginBySina(String userid, String accessToken, String remoteIp);
	/**
	 * 交行联名登陆
	 * @param userid(加密的userid，需要经过解密)
	 * @return
	 */
	ResultCode<MemberVo> openMemberLoginByBankcomm(String userid, String remoteIp);
	
	/**
	 * 创建联名登陆用户通过json
	 * @param requestJson
	 * @return
	 */
	ResultCode<MemberVo> openMemberLoginByJson(String source, String requestJson, String remoteIp);
	/**
	 * 创建联名登陆用户通过3des加密
	 * @param content_encrypt
	 * @return
	 */
	ResultCode<MemberVo> openMemberLoginByEncrypt(String appkey, String content_encrypt, String remoteIp);
	/**
	 * 触宝用户联名登录
	 */
	ResultCode<MemberVo> chubaoMemberLogin(String userid, String remoteIp);
	/**
	 * 根据MemberEncode重新登录
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> doLoginByMemberEncode(String memberEncode, String remoteIp);
	/**
	 * @deprecated systemSource unused, get it from dubbo filter
	 * @param memberEncode
	 * @param remoteIp
	 * @param systemSource
	 * @return
	 */
	ResultCode<MemberVo> doLoginByMemberEncode(String memberEncode, String remoteIp, String systemSource);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	ResultCode<MemberVo> doMemberLogin4Api(String username, String password, String remoteIp);
	/**
	 * @deprecated systemSource unused, get it from dubbo filter
	 * @param username
	 * @param password
	 * @param remoteIp
	 * @param systemSource
	 * @return
	 */
	ResultCode<MemberVo> doMemberLogin4Api(String username, String password, String remoteIp, String systemSource);
	/**
	 * TODO 后期功能内聚，不提供dubbo
	 * 用户登录  （简单处理）
	 * @param omid openmemberid(主键)
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> doLoginByOpenMember(Long omid, String remoteIp);
	/**
	 * 修改用户信息刷新
	 * encodeOrSessid
	 * memberid
	 */
	ResultCode updateMemberAuth(String encodeOrSessid, Long memberid);
	/**
	 * 登出
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode doLogout(String memberEncode, String remoteIp);
	/**
	 * 合作商联名登陆MD5方式
	 * @param appkey
	 * @param pukey
	 * @param timestamp
	 * @param sign
	 * @param extraInfo
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> openMemberLoginByMD5(String appkey, String pukey, Timestamp timestamp, String sign, String extraInfo, String remoteIp);
}
