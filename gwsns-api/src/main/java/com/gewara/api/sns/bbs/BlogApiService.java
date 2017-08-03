package com.gewara.api.sns.bbs;


import java.util.List;

import com.gewara.api.sns.vo.bbs.AccusationVo;
import com.gewara.api.sns.vo.bbs.BlackMemberVo;
import com.gewara.api.vo.ResultCode;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public interface BlogApiService{
	
	/**
	 * 获取黑名单列表
	 * @param memberId 为空则返回所有黑名单
	 * @return
	 */
	ResultCode<List<BlackMemberVo>> getBlackMemberList(Long memberId, int from, int maxnum);
	/**
	 * 用户是否在黑名单中
	 * @param memberId
	 * @return
	 */
	ResultCode<Boolean> isBlackMember(Long memberId);
	/**
	 * 黑名单中的人数
	 */
	ResultCode<Integer> getBlackMemberCount();
	/**
	 * 举报数量
	 * @return
	 */
	ResultCode<Integer> getAccusationCount();
	ResultCode<List<AccusationVo>> getAccusationList(int from, int maxnum);
	
	

	/**
	 * 根据关联memberid，查询黑名单数量
	 */
	ResultCode<Integer> getBlackMemberCount(Long memberId);
	
	/**
	 * 保存黑名单
	 * @param bm
	 * @return
	 */
	ResultCode<BlackMemberVo> saveBlackMember(BlackMemberVo bm);
	
	/**
	 * 删除黑名单
	 * @param blackMemberId
	 */
	ResultCode removeBlackMember(Long blackMemberId);
	
	/**
	 * 保存投诉
	 * @param acc
	 * @return
	 */
	ResultCode<AccusationVo> saveAccusation(AccusationVo acc);
	
	/**
	 * 查询投诉
	 * @param accid
	 * @return
	 */
	ResultCode<AccusationVo> getAccusation(Long accid);
	
	/**
	 * 删除投诉
	 * @param accid
	 */
	ResultCode removeAccusation(Long accid);	
	
}
