package com.gewara.api.sns.comment;

import java.util.HashMap;
import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface ReCommentApiService {
	ResultCode<List<ReCommentVo>> getRecommentBycommentid(Long commentid, int from, int maxnum);
	ResultCode<List<ReCommentVo>> getReplyMeReCommentList(Long memberid, int from, int maxnum);
	
	ResultCode<Integer> getReCommentCountByMemberid(Long memberid, String status);
	//该方法要删除
	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long relatedid, Long tomemberid, Long memberid, int from, int maxnum);
	
	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long relatedid, Long tomemberid, Long memberid, Long mtid, int from, int maxnum);
	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long relatedid, Long tomemberid, Long memberid, Long mtid, boolean isAsc,int from, int maxnum);
	ResultCode<List<ReCommentVo>> getReplyCommentListByAtMe(String nickName, int from, int maxnum);
	
	ResultCode<Integer> getReCommentCountByRelatedidAndTomemberid(Long relatedid, Long tomemberid, Long memberid);
	
	ResultCode<ReCommentVo> getReCommentById(Long reCommentId) ;
	
	ResultCode<Integer> getReplyMeReCommentCount(Long memberid);

	ResultCode<Integer> getReCommentByRelatedidAndTomemberidCount(Long relatedid, Long tomemberid, Long memberid) ;
	ResultCode<List<CommentVo>> getReCommentListByMemberid(Long memberid, String status, int from, int maxnum);
	
	//根据哇啦idList获取回复列表
	/**
	 * @param commentIdList
	 * @param maxnum
	 * @return
	 */
	ResultCode<VoMap<Long, List<ReCommentVo>>> getReCommentVoMap(List<Long> commentIdList, int maxnum);
	
	/**
	 * 查询热门哇啦评论 v6.3
	 * @param relatedid
	 * @param tomemberid
	 * @param memberid
	 * @param mtid
	 * @param status
	 * @param flowernum
	 * @param isTopThree
	 * @param isAsc
	 * @param from
	 * @param maxnum
	 * @return
	 */
	public ResultCode<List<ReCommentVo>> getHotReCommentByRelatedidAndTomemberid(Long relatedid, Long tomemberid, Long memberid, Long mtid, String status,
			Integer flowernum, boolean isTopThree, boolean isAsc, int from, int maxnum);
	/**
	 * 查询热门哇啦数
	 * @param relatedid
	 * @param tomemberid
	 * @param memberid
	 * @param mtid
	 * @param status
	 * @param flowernum
	 * @return
	 */
	ResultCode<Integer> getHotReCommentByRelatedidAndTomemberidCount(Long relatedid, Long tomemberid, Long memberid, Long mtid, String status,
			Integer flowernum);
	
	/**
	 * 查询哇啦回复,排除热门回复
	 * @param relatedid
	 * @param isAsc
	 * @param hotids
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<ReCommentVo>> getReCommentWithOutHot(Long relatedid, boolean isAsc, List<Long> hotids, int from, int maxnum);
	/**
	 * 获取回复的回复
	 * @param memberid
	 * @param ids
	 * @return
	 */
	ResultCode<VoMap<Long, List<ReCommentVo>>> getReCommenReInfoVoMap(List<Long> memberid, List<Long> ids,Long commentid);
	/**
	 * 查询哇啦回复,排除热门回复
	 * @param paramet
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<ReCommentVo>> getReCommentWithOutHotByParam(HashMap<String,Object> paramet, int from, int maxnum);
}
