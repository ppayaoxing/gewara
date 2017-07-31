package com.gewara.ucenter.api.member;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.ShareMemberVo;



public interface ShareVoService {
	/**
	 * 添加要分享的信息
	 * @param tag
	 * @param tagid
	 * @param memberid
	 * @param category
	 * @return
	 */
	ResultCode sendShareInfo(String tag, Long tagid, Long memberid, String category);
	/**自定义分享内容
	 * @param tag
	 * @param tagid
	 * @param memberid
	 * @param content
	 * @param picUrl
	 * @return
	 */
	ResultCode sendShareInfo(String tag, Long tagid, Long memberid, String content, String picUrl);
	/**
	 * 根据来源获取关联同步用户
	 * @param source
	 * @param memberid
	 * @return
	 */
	ResultCode<List<ShareMemberVo>> getShareMemberByMemberid(List<String> source, Long memberid);
	/**
	 * 创建sharemember
	 * @param memberid
	 * @param source
	 * @param loginname
	 * @param token
	 * @param tokensecret
	 * @param expires
	 * @return
	 */
	ResultCode createShareMember(Long memberid, String source, String loginname, String token, String tokensecret, String expires);
	/**
	 * 修改otherinfo相关操作
	 * @param shareMemberid
	 * @param otherinfoKey
	 * @param otherinfoValue
	 * @return
	 */
	ResultCode updateShareMemberRights(Long shareMemberid, String otherinfoKey, String otherinfoValue);
	/**
	 * 移除
	 * @param shareMemberid
	 * @return
	 */
	ResultCode removeShareMember(Long shareMemberid);
}
