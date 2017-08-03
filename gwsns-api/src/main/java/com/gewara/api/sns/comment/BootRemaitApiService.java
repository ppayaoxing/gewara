package com.gewara.api.sns.comment;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface BootRemaitApiService {
	/**
	 * 保存
	 * @param memberid
	 * @param movieid
	 * @param status
	 * @return
	 */
	ResultCode saveOrUpdate(Long memberid, Long movieid);
	/**
	 * 观影后发领积分消息
	 * @param memberid
	 * @param relatedid
	 * @param tag
	 */
	ResultCode sendMsgToUser(Long memberid, Long relatedid,Timestamp sendTime, String content);
	ResultCode sendMsgToUser(Long memberid, Long relatedid,Timestamp sendTime, String content, String contentForWeibo);
	/**
	 * 获取电影赠送积分
	 * @param memberid
	 * @param movieid
	 * @param addPointType  true：立即赠送;false：不赠送
	 * @param afterSeen     true：观影后;false：不论是否观影
	 * @return
	 */
	ResultCode<Integer> getMovieScore(Long memberid, Long movieid, boolean addPointType, boolean afterSeen); 
	/**
	 * 获取哇啦指定用户的回复的回复memberid
	 * @return
	 */
	ResultCode<List<Long>> getRereMemberids();
	/**
	 * 保存用户写哇啦赠送电影积分
	 * @param memberid
	 * @param relatedid
	 * @return
	 */
	ResultCode saveUserWalaPresent(Long memberid, Long relatedid);
	/**
	 * 判断该用户是否导入过通讯录
	 * @param memberid
	 * @param movieid
	 * @param addPointType
	 * @param afterSeen
	 * @return
	 */
	ResultCode<Boolean> checkMember(Long memberid, Long movieid, boolean addPointType, boolean afterSeen);
	/**
	 * app哇啦奖励提醒
	 * @param memberid
	 * @param score
	 */
	ResultCode saveAppScoreRemain(Long memberid, Integer score);
	/**
	 * 判断写哇啦是否赠送过积分
	 * @param memberid
	 * @param movieid
	 * @return
	 */
	ResultCode<Boolean> checkIsPresent(Long memberid,Long movieid);
	
	/**
	 * 获取用户开机提醒电影
	 * @param memberid
	 * @return
	 */
	ResultCode<VoMap<String,Long>> getBootRemaitVoMapById(Long memberid);
	/**
	 * 获取app哇啦奖励提醒
	 * @param memberid
	 * @return
	 */
	ResultCode<VoMap<String,Integer>> getAppScoreRemainVoMap(Long memberid);
	/**
	 * 获取发送的消息内容
	 * @param memberid
	 * @param movieid
	 * @return
	 */
	ResultCode<String> getUserMsgContent(Long memberid, Long movieid);
	/**
	 * 获取电影圈广场V说、麻辣哇啦、资讯哇啦
	 * @param table
	 * @param type
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Long>> getRecommendWalaForSquare(String table,String type,int from, int maxnum);
	/**
	 * 初始化用户app7.1.0广场准备数据
	 * @param memberid
	 */
	ResultCode readyMemberSquareData(Long memberid);
	/**
	 * 用户调取app7.1.0广场数据
	 * @param memberid
	 * @param pageNo
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getMemberSquareCommentVoList(Long memberid, Integer pageNo, Integer maxnum);
	/**
	 * 获取麻辣哇啦
	 * @param startime
	 * @param endtime
	 * @return
	 */
	ResultCode<VoMap<String, List<Long>>> getMalaCommentList(String startime, String endtime);
	/**
	 * 获取麻辣哇啦起始推送时间
	 * @return
	 */
	ResultCode<String> getMalaCommentFirstTime();
}

