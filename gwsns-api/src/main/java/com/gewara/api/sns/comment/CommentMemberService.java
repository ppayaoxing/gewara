package com.gewara.api.sns.comment;

import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.FlowerMemberVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface CommentMemberService {
	
	ResultCode<List<Long>> getFlowerMemberIdList(String type, Long relatedid, int from, int maxnum);
	
	/**
	 * 根据memberId 获取点赞列表
	 */
	ResultCode<List<FlowerMemberVo>> getFlowerMemberByParent(Long memberid, Long parentid, String parenttype, int from, int maxnum);
	
	ResultCode<List<CommentVo>> getCommentListByMemberIdAndTags(String tags, Long memberId, String beginTime, String endTime, int from, int maxnum);
	/**
	 * 得到用户发表哇啦数和回复数
	 * @param memberid
	 * @return key:commentcount minaddtime maxaddtime maxid
	 */
	ResultCode<VoMap<String,Object>> getMemberCountVoMap(Long memberid);
}
