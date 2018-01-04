package com.gewara.api.sns.mongo;

import java.util.List;

import com.gewara.api.sns.vo.UserUploadMessage;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;


public interface UserMessageDBApiService {
	/**
	 * 保存上传通讯录
	 */
	ResultCode save(Long memberid, List<UserUploadMessage> userMessageList, String type); 
	/**
	 * 上传过通讯录记录
	 */
	ResultCode<List<VoMap<String,Object>>> getMongoUserVoMapList(Long memberid, Integer from, Integer maxnum, String source);
	/**
	 * 获取推荐好友列表
	 */
	ResultCode<List<UserUploadMessage>> getRecommendFriends(Long memberid, Integer from, Integer maxnum);
	/**
	 * 获取推荐好友数量
	 */
	ResultCode<Integer> getRecommendUserNum(Long memberid);
	/**
	 * 增加匹配推荐用户列表
	 */
	ResultCode<VoMap<Long,UserUploadMessage>> getRecommendFriendsVoMapByMemberid(Long memberid, Integer from, Integer maxnum, boolean flag,List<Long> attenList);
}
