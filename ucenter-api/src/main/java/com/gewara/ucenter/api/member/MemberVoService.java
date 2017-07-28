/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.ChargeVo;
import com.gewara.ucenter.vo.member.EncodeDataVo;
import com.gewara.ucenter.vo.member.MemberAccountVo;
import com.gewara.ucenter.vo.member.MemberInfoVo;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.PersonDescribes;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface MemberVoService {
	ResultCode<Map<String, Object>> getUserInfo2(Long arg0, String arg1, String arg2);

	ResultCode<MemberVo> getMemberVo(Long arg0);

	ResultCode<List<MemberVo>> getMemberVoList(Long... arg0);

	ResultCode<MemberInfoVo> getMemberInfoVo(Long arg0);

	ResultCode<List<MemberInfoVo>> getMemberInfoVoList(Long... arg0);

	ResultCode<MemberAccountVo> getMemberAccountVoByMemberid(Long arg0);

	ResultCode updateMemberCount(Long arg0, String arg1, int arg2, boolean arg3);

	ResultCode<String> getCacheMemberHeadpic(Long arg0);

	ResultCode<Map<Long, String>> getCacheHeadpicMap(Collection<Long> arg0);

	ResultCode<Map<Long, Map>> getCacheMemberInfoMap(Collection<Long> arg0);

	ResultCode<Map> getCacheMemberInfo(Long arg0);

	ResultCode<Map> resetMemberCache(Long arg0);

	ResultCode<Boolean> isPlayMemberByTagAndId(Long arg0, String arg1, Long arg2);

	ResultCode<Map> getPlayMemberByTagAndId(Long arg0, String arg1, Long arg2);

	ResultCode<Map<Long, Map>> getMemberByMobile(List<String> arg0);

	ResultCode<Integer> getUserChargeCount(Long arg0, Timestamp arg1, Timestamp arg2);

	ResultCode<List<ChargeVo>> getUserCharge(Long arg0, Timestamp arg1, Timestamp arg2, int arg3, int arg4);

	ResultCode<MemberInfoVo> getMemberInfoByMobile(String arg0);

	ResultCode<String> getPersonDescribe(Long arg0);

	ResultCode<Map<Long, String>> getPersonDescribeByMemberidList(List<Long> arg0);

	ResultCode savePersonDescribe(Long arg0, String arg1, String arg2);

	ResultCode<PersonDescribes> getPersonDescribeMap(Long arg0);

	ResultCode<MemberVo> getMemberVoByMobile(String arg0);

	ResultCode<MemberVo> getMemberVoByEmail(String arg0);

	ResultCode<Integer> isMobileSecurityVerify(String arg0, String arg1, Long arg2);

	ResultCode<String> addMobileSecurityVerify(String arg0, Long arg1);

	ResultCode<Map<String, String>> getMobileSecurityUpdata(String arg0, Long arg1);

	ResultCode<String> addMobileSecurityVerify4MobileUpdata(String arg0, Long arg1);

	boolean isMemberMobileExists(String arg0);

	ResultCode<MemberVo> bindMobile(Long arg0, String arg1, String arg2, String arg3, boolean arg4);

	ResultCode unbindMobile(Long arg0, String arg1, String arg2);

	ResultCode<Boolean> isMemberExistsByEmail(String arg0, Long arg1);

	ResultCode<Boolean> canChangeMobile(Long arg0);

	ResultCode<MemberVo> getMemberByEmail(String arg0);

	ResultCode<MemberVo> isValidMemberPass(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5);

	ResultCode<MemberInfoVo> saveNewTask(Long arg0, String arg1);

	ResultCode<MemberVo> getMemberByMobile(String arg0);

	ResultCode<Integer> getInviteCountByMemberid(Long arg0, Timestamp arg1, Timestamp arg2);

	ResultCode updateMemberInfo(Long arg0, String arg1, String arg2, String arg3);

	ResultCode<MemberInfoVo> updateHeadPic(Long arg0, String arg1);

	ResultCode changePassword(Long arg0, String arg1, String arg2, String arg3);

	ResultCode<MemberInfoVo> addMemberOtherInfo(Long arg0, String arg1, String arg2);

	ResultCode updateMemberNeedValidSetY(Long arg0);

	ResultCode<Integer> getInviteCount(String arg0, Long arg1);

	ResultCode changePasswordByOldpass(Long arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6);

	ResultCode<MemberVo> changePasswordByMobileCode(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7);

	ResultCode<EncodeDataVo> getMemberEncodeDataVo(String arg0, boolean arg1);

	ResultCode exchangeEmail(Long arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode sendExchangeEmail(Long arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
}