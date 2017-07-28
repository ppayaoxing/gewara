/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.mongo;

import com.gewara.api.sns.vo.UserUploadMessage;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface UserMessageDBApiService {
	ResultCode save(Long arg0, List<UserUploadMessage> arg1, String arg2);

	ResultCode<List<VoMap<String, Object>>> getMongoUserVoMapList(Long arg0, Integer arg1, Integer arg2, String arg3);

	ResultCode<List<UserUploadMessage>> getRecommendFriends(Long arg0, Integer arg1, Integer arg2);

	ResultCode<Integer> getRecommendUserNum(Long arg0);

	ResultCode<VoMap<Long, UserUploadMessage>> getRecommendFriendsVoMapByMemberid(Long arg0, Integer arg1, Integer arg2,
			boolean arg3, List<Long> arg4);
}