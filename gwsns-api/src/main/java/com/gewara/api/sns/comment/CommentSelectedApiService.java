package com.gewara.api.sns.comment;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;

/**
 * 精选哇啦
 * @author zf
 *
 */

public interface CommentSelectedApiService {
	/**
	 * 获取精选哇啦
	 * @param tag
	 * @param relatedid
	 * @param beginDate
	 * @param endDate
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getCommentListByCommentSelected(String tag,Long relatedid,Timestamp beginDate,Timestamp endDate,int from, int maxnum);
	
	
	/**
	 * 获取当前权重后面的精选哇啦
	 * @param commentid
	 * @param beginDate
	 * @param endDate
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getNextCommentListByCommentSelected(Long commentid,Timestamp beginDate, Timestamp endDate,int maxnum);
	
	/**
	 * 获取电影相关精选哇啦
	 * @param tag
	 * @param relatedid
	 * @param currentid 
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getMovieCommentSelected(String tag,Long relatedid,Long currentid, int from, int maxnum);
	
	
	/**
	 * 获取当前权重后面的电影相关精选哇啦
	 * @param commentid
	 * @param tag
	 * @param relatedid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getNextMovieCommentSelected(Long commentid,String tag,Long relatedid,int from,int maxnum);
	
	/**
	 * 获取关注电影的相关精选哇啦
	 * @param tag
	 * @param relatedids
	 * @param notin 
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getAttentionCommentSelected(String tag,List<Long> relatedids,List<Long> notin, int from, int maxnum);
	
	/**
	 * 获取关注电影的相关精选哇啦
	 * @param tag
	 * @param relatedids
	 * @return
	 */
	ResultCode<Integer> getAttentionCommentSelectedCount(String tag,List<Long> relatedids);
}
