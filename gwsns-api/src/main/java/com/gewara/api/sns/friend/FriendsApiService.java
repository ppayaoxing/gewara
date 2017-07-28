/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.friend;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface FriendsApiService {
	ResultCode<List<CommentVo>> getMyFriendsCommentList(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getMyFriendsCommentsIdsCount(Long arg0);

	ResultCode<List<CommentVo>> getMyFriendsCommentsForTag(Long arg0, String arg1, Long arg2, int arg3, int arg4);

	ResultCode<List<Long>> getMyFriendsTreasureList(String arg0, Long arg1, Long arg2, int arg3, int arg4);

	ResultCode<Integer> getMyFriendsTreasureCount(String arg0, Long arg1, Long arg2);

	ResultCode<Integer> getMyFriendsCommentsIdsForTagCount(Long arg0, String arg1, Long arg2);

	ResultCode<Integer> getMyFriendsWalaCount(Long arg0);

	ResultCode<VoMap<Long, Integer>> getMyFriedsSayCountVoMapByList(Long arg0, String arg1, List<Long> arg2);

	ResultCode<VoMap<String, String>> getMyFriendsCommentsIdsForTag(Long arg0, String arg1, Long arg2);

	ResultCode<Integer> getMyFriedsSayUnreadCount(Long arg0, String arg1, Long arg2);
}