package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberMergerHisVo;


public interface BindMemberVoService {
	/**
	 * 根据用户ID查找该账户是否有合并账号申请记录
	 * @param memberId
	 * @return
	 */
	ResultCode<MemberMergerHisVo> checkMemberApply(Long memberId);
	/**
	 * 合并账户
	 * @param masterMemberId 主账号
	 * @param branchMemberId 分支账号
	 * @return
	 */
	ResultCode mergerMember(Long masterMemberId, Long branchMemberId);
	/**
	 * 查询合并记录
	 * @param id
	 * @return
	 */
	ResultCode<MemberMergerHisVo> getMemberMergerHisVo(Long id);
	/**
	 * 保存合并步奏
	 * @param id
	 * @param bindStep
	 * @param otherinfo
	 * @return
	 */
	ResultCode updateMemberMergerHisBindStep(Long id, Long bindStep, String otherinfo);
}
