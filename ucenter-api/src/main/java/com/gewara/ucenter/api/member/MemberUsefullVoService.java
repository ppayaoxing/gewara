/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.cmd.UsefulAddressVo;
import com.gewara.ucenter.vo.member.ExpressProvinceVo;
import com.gewara.ucenter.vo.member.MemberUsefulAddressVo;
import java.util.List;

public interface MemberUsefullVoService {
	ResultCode<MemberUsefulAddressVo> checkCreanteUsefulAddress(UsefulAddressVo arg0);

	ResultCode<MemberUsefulAddressVo> getMemberUsefulAddressById(Long arg0);

	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByMeberid(Long arg0, int arg1, int arg2);

	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByMobile(String arg0, int arg1, int arg2);

	ResultCode<ExpressProvinceVo> getExpressProvince(String arg0, String arg1);

	ResultCode<List<ExpressProvinceVo>> getExpressProvinceList(String arg0);

	ResultCode<MemberUsefulAddressVo> addOrUpdateUsefulAddress(UsefulAddressVo arg0);

	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByIdList(List<Long> arg0);

	ResultCode delOldAddress(Long arg0, Long arg1);

	ResultCode changeDefaultAddress(Long arg0, Long arg1, String arg2);

	ResultCode<MemberUsefulAddressVo> saveMemberUsefulAddress(Long arg0, Long arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11,
			String arg12);
}