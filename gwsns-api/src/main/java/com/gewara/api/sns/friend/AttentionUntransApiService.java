package com.gewara.api.sns.friend;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;



public interface AttentionUntransApiService {

	/**
	 * 关注用户
	 * @param memberid 
	 * @param attentionid 被关注的用户id
	 */
	ResultCode addAttention(Long memberid, Long attentionid);
	
	/**
	 * 取消关注
	 * @param memberid
	 * @param attentionid 被取消的用户id
	 */
	ResultCode cancelAttention(Long memberid, Long attentionid);
	/**
	 * 关注数 粉丝数 新增粉丝数
	 * @param memberid
	 * @return key: total(关注) betotal(粉丝) count(新增)
	 */
	ResultCode<VoMap<String,Integer>> getUserAttentionTotalVoMap(Long memberid);
	/**
	 * 是否关注了该用户
	 * @param memberid
	 * @param attentionid
	 * @return
	 */
	ResultCode<Boolean> hasAttention(Long memberid, Long attentionid);
	/**
	 * 关注列表
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List> getUserAttention(Long memberid, int from, int maxnum);
	/**
	 * 粉丝列表
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List> getUserBeAttention(Long memberid, int from, int maxnum);
	/**
	 * 用户关系
	 * @param memberid   当前用户id
	 * @param memberids  匹配用户id
	 * @return
	 */
	ResultCode<VoMap<Long,String>> relationShipVoMap(Long memberid, List<Long> memberids);
	/**
	 * 是否是我的粉丝
	 * @param memberid
	 * @param attentionid
	 * @return
	 */
	ResultCode<Boolean> hasBeAttention(Long memberid, Long attentionid);
	/**
	 * 单个用户关系
	 * @param memberid
	 * @param attentionid
	 * @return
	 */
	ResultCode<String> relationShip(Long memberid, Long attentionid);
	/**
	 * 获取用户写过的哇啦
	 * @param memberid
	 * @return
	 */
	ResultCode<List<Long>> getMemberTagCommentList(Long memberid);
	/**
	 * 批量关注用户
	 * @param memberid 
	 * @param attentionid 被关注的用户id
	 */
	ResultCode addAttentions(Long memberid, List<Long> attentionid);
	/**
	 * 增加用户黑名单接口
	 * @param memberid
	 * @param beMemberid
	 * @return
	 */
	ResultCode addBlackForUser(Long memberid, Long beMemberid);
	/**
	 * 取消用户黑名单接口
	 * @param memberid
	 * @param beMemberid
	 * @return
	 */
	ResultCode cancelBlackForUser(Long memberid, Long beMemberid);
	/**
	 * 是否拉黑
	 * @param memberid
	 * @param beMemberid
	 * @return
	 */
	ResultCode<Boolean> checkIsBlackUser(Long memberid,Long beMemberid); 
	/**
	 * 获取指定用户的黑名单用户
	 * @param memberid
	 * @return
	 */
	ResultCode<List<Long>> getBlackUserByMemberid(Long memberid);
}
