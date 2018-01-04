package com.gewara.api.sns.guess;

import java.util.List;

import com.gewara.api.sns.vo.guess.BettingOptionCountVo;
import com.gewara.api.sns.vo.guess.BettingOptionVo;
import com.gewara.api.sns.vo.guess.GuessSetupVo;
import com.gewara.api.sns.vo.guess.UserBettingVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

/**
 * 猜票房接口
 *
 */
public interface GuessApiService {
	
	/**
	 * 获取猜票房
	 * @param   id  票房设置ID
	 */
	ResultCode<GuessSetupVo> getGuessById(Long id);
	 /**
     * 根据票房设置ID获取投注选项
     * @param   relatedid  票房设置ID
     */
	ResultCode<List<BettingOptionVo>> getBettingOptionsByRelatedId(Long relatedid);
	/**
	 * 投注选项ID获取数据
	 * @param   id    主键ID
	 */
	ResultCode<BettingOptionVo> getBettingOptionById(Long id);
	
	/**
     * 获取用户投注的猜票房信息
     * @param   memberid  用户ID  
     * @param   stepid 设置猜票房ID
     */
	ResultCode<UserBettingVo> getUserBetting(Long memberid,Long stepid);
	
	/**
     * 获取猜票房投注总人数
     * @param   stepid 设置猜票房ID
     */
	ResultCode<Integer> getBettingCount(Long stepid);
	
	/**
     * 获取猜票房投注用户ID
     * @param   stepid 设置猜票房ID
     */
	ResultCode<List<Long>> getUserIdBetting(Long stepid,int from, int maxnum);
	/**
	 * 获取投注选项信息
	 * @param   optionid 投注选项ID
	 */
	ResultCode<BettingOptionCountVo> getBettingOptionCount(Long optionid);
	/**
	 * 获取各投注选项总人数 
	 * key --选项ID value--总人数
	 * @param   stepid 设置猜票房ID
	 */
	ResultCode<VoMap<Long,Integer>> getVoMapCount(Long stepid);
	/**
	 * 保存用户投注选项信息
	 * @param   memberid 用户ID
	 * @param   stepid 设置猜票房ID
	 * @param   optionid 投注选项ID 
	 * @param   num  投注倍数
	 * @param   point 投注总积分
	 */
	ResultCode saveUserBetting(Long memberid,Long stepid,Long optionid,Integer num,Integer point);
	
	/**
	 * 回滚用户投注选项信息
	 * @param   memberid 用户ID
	 * @param   stepid 设置猜票房ID
	 * @param   optionid 投注选项ID 
	 * @param   num  投注倍数
	 * @param   point 投注总积分
	 */
	ResultCode rollBackUserBetting(Long memberid, Long stepid,Long optionid, Integer num, Integer point);
	
	
}
