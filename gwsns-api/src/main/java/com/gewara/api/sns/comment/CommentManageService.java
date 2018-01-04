package com.gewara.api.sns.comment;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVoCommand;
import com.gewara.api.vo.ResultCode;
import com.gewara.command.CommentVoCommand;

public interface CommentManageService {
	
	ResultCode<Long> updateComment(String commentJson);
	//保存哇啦回复--新添加的方法
	ResultCode<Long> saveReComment(ReCommentVoCommand reComment);
	
	ResultCode<String> saveModeratorTag(Long id, List<String> titles);
	
	ResultCode<Integer> saveFlowerMember(Long memberid, String type, Long relatedid,String source);
	
	/**
	 * 匿名点赞
	 */
	ResultCode<Integer> saveAnonymFlowerMember(String type,Long relatedid,String gwtc);
	
	ResultCode<Long> saveComment(CommentVoCommand command);
	/**
	 * 查询memberid已赞过的回复
	 * @param memberid
	 * @param type
	 * @param relatedids
	 * @return
	 */
	ResultCode<List<Long>> hasFlowerMemberList(Long memberid, String type, List<Long> relatedids);
	
	/**
	 * 是否匿名点赞过
	 */
	ResultCode<Integer> hasAnonymFlowerMember(String type, Long relatedid,String gwtc);
	
	ResultCode<Integer> hasFlowerMember(Long memberid, String type, Long relatedid);
	/**
	 * 用户点赞操作
	 * 			beforRelatedid=0 则点赞
	 *          afterRelatedid=0 则取消点赞
	 *          否则是点赞变更
	 * @param memberid
	 * @param type
	 * @param beforRelatedid
	 * @param afterRelatedid
	 * @param source
	 * @return
	 */
	ResultCode<Integer> flowerMemberOperate(Long memberid, String type, Long beforRelatedid,Long afterRelatedid,String source);
	/**
	 * 取消点赞
	 * @param memberid
	 * @param type
	 * @param relatedid
	 * @return
	 */
	ResultCode<Integer> cancelFlowerMember(Long memberid, String type, Long relatedid);
	
	//匿名取消点赞
	ResultCode<Integer> cancelAnonymFlowerMember(String type,Long relatedid,String gwtc);
	
	ResultCode<List<CommentVo>> adminGetCommentList(Long memberid, Timestamp starttime, Timestamp endtime, String transfer, String status, String keyname, String isMicro, int from, int maxnum);	
	
	ResultCode<Integer> adminGetCommentCount(Long memberid, Timestamp starttime, Timestamp endtime, String transfer, String status, String keyname,
			String isMicro);
	
	ResultCode<Integer> deleteComment(Long commentId);
	
	

	ResultCode<Integer> deleteMicroReComment(Long mid);

	
	ResultCode<Integer> updateReComment(String recommentJson);
	
	ResultCode<List<ReCommentVo>> adminGetReCommentList(Long cid, Long memberid, Timestamp starttime, Timestamp endtime, String status, String keyname, int from,
			int maxnum) ;

	
	ResultCode<Integer> adminGetReCommentCount(Long cid, Long memberid, Timestamp starttime, Timestamp endtime, String status, String keyname);
	/**
	 * 举报回复
	 * @param id
	 * @return
	 */
	ResultCode saveCommentReport(Long id,Long memberid);
	/**
	 * 是否已举报
	 * @param id
	 * @param memberid
	 * @return
	 */
	ResultCode<Boolean> checkIsReportForId(Long id,Long memberid);
}
