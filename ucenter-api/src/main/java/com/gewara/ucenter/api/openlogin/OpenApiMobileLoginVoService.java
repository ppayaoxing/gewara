package com.gewara.ucenter.api.openlogin;

import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;

/**
 * APP µÇÂ½Ïà¹ØAPI
 * 
 */
public interface OpenApiMobileLoginVoService {
	ResultCode<String> mobileRegister(String nickname, String password,
			String dynamicNumber, String mobile, String appSource,
			String apptype, String osType, String appVersion, String idfa,
			String deviceid, String deviceId, String imei, String citycode,
			String invfrom, String remoteIp,
			Map<String, String> requestParamMap, boolean hasM66V);

	ResultCode sendMobileCheck(MemberVo currentMember, String mobile,
			String memberEncode, String remoteIp);

	ResultCode<OpenResultVo> openMemberLogin(String userid, String source,
			String nickname, String token, String remoteIp);

	ResultCode<OpenResultVo> openMemberLoginByApp(String accessToken,
			String userid, String source, Long partnerid, String otherinfo,
			String remoteIp);

	ResultCode<OpenResultVo> bindAuth(MemberVo masterMember, Boolean bindFlag,
			Boolean bindGewaraFlag, String openid, String source,
			Long partnerid, String accessToken, String username,
			String password, String remoteIp);
}
