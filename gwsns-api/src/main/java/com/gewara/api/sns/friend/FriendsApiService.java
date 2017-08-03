/** 
 */
package com.gewara.api.sns.friend;

import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

/**
 * @author Zhicheng.Peng   Johnny.Resurgam@Gmail.com
 *  
 *  Jun 18, 2015  7:27:37 PM
 */
public interface FriendsApiService {
	
	/**
	 * 获取朋友圈哇啦
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getMyFriendsCommentList(Long memberid, int from, int maxnum);
	
	/**
	 * 获取朋友圈哇啦总数
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getMyFriendsCommentsIdsCount(Long memberid);
	
	/**
	 * 获取我关注的好友在Tag下的哇啦
	 * @param mid
	 * @param tag
	 * @param relateId
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getMyFriendsCommentsForTag(Long mid, String tag, Long relateId, int from, int maxnum);
	/**
	 * 获取我的好友关注的电影
	 * @param tag
	 * @param relatedid
	 * @param memberId
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Long>> getMyFriendsTreasureList(String tag,Long relatedid, Long memberId, int from, int maxnum);
	/**
	 * 获取我的好友关注的数量
	 * @param tag
	 * @param relatedid
	 * @param memberId
	 * @return
	 */
	ResultCode<Integer> getMyFriendsTreasureCount(String tag,Long relatedid, Long memberId);
	
	/**
	 * 获取我关注的好友在Tag下的哇啦的数量
	 * @param mid
	 * @param tag
	 * @param relateId
	 * @return
	 */
	ResultCode<Integer> getMyFriendsCommentsIdsForTagCount(Long mid, String tag, Long relateId);

	/**
	 * 获取我朋友圈中提醒的哇啦数量（红点）
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getMyFriendsWalaCount(Long memberid);
	
	/**
	 * 获取好友的好友说数量
	 * @param memberid
	 * @param tag
	 * @param relateIds
	 * @return
	 */
	ResultCode<VoMap<Long,Integer>> getMyFriedsSayCountVoMapByList(Long memberid,String tag,List<Long> relateIds);
	/**
	 * 我关注的好友
	 * @param mid
	 * @param tag
	 * @param relateId
	 * @return
	 */
	ResultCode<VoMap<String, String>> getMyFriendsCommentsIdsForTag(Long mid, String tag, Long relateId);
	ResultCode<Integer> getMyFriedsSayUnreadCount(Long mid, String tag, Long relateId);
	
	
}
