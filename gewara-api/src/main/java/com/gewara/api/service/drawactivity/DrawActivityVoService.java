package com.gewara.api.service.drawactivity;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.ParamsVo;
import com.gewara.api.vo.draw.DrawActivityVo;
import com.gewara.api.vo.draw.PrizeVo;
import com.gewara.api.vo.draw.WinnerInfoVo;

public interface DrawActivityVoService {
	
	/**
	 * 查询抽奖活动
	 * @param param
	 * @return
	 */
	ResultCode<List<DrawActivityVo>> getDrawActivityList(ParamsVo param);
	
	/**
	 * 根据不同活动信息，奖品类型，查询获奖信息
	 * @param param
	 * @return
	 */
	ResultCode<List<WinnerInfoVo>> getWinnerList(ParamsVo param);
	
	/**
	 * 根据不同活动信息，奖品类型，查询获奖信息数量
	 * @param param
	 * @return
	 */
	ResultCode<Integer> getWinnerCount(ParamsVo param);
	
	/**
	 * 获取奖品列表
	 * @param prizeIdList
	 * @return
	 */
	ResultCode<List<PrizeVo>> getPrizeByList(List<Long> prizeIdList);
	
	/**
	 * 根据主键获取活动
	 * @param activityId
	 * @return
	 */
	ResultCode<DrawActivityVo> getDrawActivityById(Long activityId);
	
	/**
	 * 计算获奖概率
	 * @param drawActivityId
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getCurChanceNum(Long drawActivityId, Long memberid);
	
	/**
	 * 查询当前用户，在这个活动中邀请的人数
	 * @param param
	 * @return
	 */
	ResultCode<Integer> getInviteMemberCount(ParamsVo param);
	
	ResultCode<String> clickDrawByRelated(Long memberid, String tag, String noLimitDraw, String needGoodsOrder, Long relatedId, String ip);

	ResultCode<String> clickDraw(Long memberid, String tag, String source, String pricategory, String citycode, String pointxy, String ip);
	
	/**
	 * 抽奖加次数限制
	 * @param memberid
	 * @param tag
	 * @param source
	 * @param pricategory
	 * @param citycode
	 * @param pointxy
	 * @param ip
	 * @param isMaxCount
	 * @param dayCount
	 * @return
	 */
	ResultCode<String> clickDrawWithCountControl(Long memberid, String tag, String source, String pricategory, String citycode, String pointxy, String ip, boolean isMaxCount, Integer dayCount);

	/**
	 * 非登录用户，手机号抽奖（合作商用）
	 * @param da
	 * @param mobile
	 * @param ip
	 * @return
	 */
	ResultCode<String> clickDrawByMobile(String mobile, String tag, String source, String pricategory, String ip);
	
	/**
	 * 根据手机号码领券(用户可以不登录或不是我们系统的用户):
	 * 1:如果oldUserTag和newUserTag都不为空,则说明有两个奖池,新老用户走不同的奖池
	 * 2:如果oldUserTag为空,newUserTag不为空,则表示只允许新用户抽奖
	 * 3:如果oldUserTag为空,newUserTag为空,不合法
	 * 4:如果oldUserTag不为空,newUserTag为空,则表示新老用户走一个奖池,并不是说不允许新用户抽奖(此时应该调用上面的抽奖方法)
	 * @see clickDrawByMobile(mobile, tag, source, pricategory, ip)
	 * @param mobile
	 * @param oldUserTag 老用户抽奖标签,如果不区别新老用户,则是抽奖标签.
	 * @param source
	 * @param pricategory
	 * @param ip
	 * @param newUserTag 如果区分新老用户,则这个必填
	 * @return
	 */
	ResultCode<String> clickDrawByMobileWithTag(String mobile, String oldUserTag, String source, String pricategory, String ip, String newUserTag);

	/**
	 * goods订单自动抽奖
	 * @param tradeno
	 * @param tag
	 * @param remoteIp
	 * @return
	 */
	ResultCode clickDrawByOrder(String tradeno, String tag, String remoteIp);
	
	ResultCode<List<Map>> getWinnerInfoList(String tag, String prizeType, String prizeOtype, int from, int maxnum);

	/**
	 * 根据合作商唯一标识partnerUkey抽奖(浦发)
	 * @param mobile
	 * @param tag
	 * @param source
	 * @param ip
	 * @return
	 */
	ResultCode<PrizeVo> clickDrawByPartnerUkeyPufa(String partnerUkey, String tag, String source, String ip);
	
	/**
	 * 根据合作商唯一标识partnerUkey抽奖
	 * @param mobile
	 * @param tag
	 * @param source
	 * @param ip
	 * @return
	 */
	ResultCode<PrizeVo> clickDrawByPartnerUkey(String partnerUkey, String tag, String source, String ip);

	/**
	 * 根据winnerinfo和partnerukey给把奖品给指定的手机号,memberid可以为空
	 * @param winnerInfoId
	 * @param partnerUkey
	 * @param mobile
	 * @return
	 */
	ResultCode<String> givePrize2Mobile(Long memberid, Long winnerInfoId, String partnerUkey, String mobile);
	
	
	/**
	 * 保存抽奖用户的设备信息
	 * 
	 * @param deviceId
	 * @param imei
	 * @param tag
	 * @param memberid
	 * @param mobile
	 * @param appSource
	 * @return
	 */
	ResultCode<String> saveDrawDeviceInfo(String deviceId, String imei, String tag, String memberid, String mobile, String appSource);
	
	/**
	 * 绑定券
	 * @param memberid
	 * @param cardNo  好像没用
	 * @param cardPass
	 * @param ip
	 * @param costPoint 消耗多少积分，<=0或null表示不消耗积分
	 * @return
	 */
	ResultCode<String> bindECard(Long memberId, String cardNo, String cardPass, String ip, Integer costPoint);
	/**
	 * 领取节日红包
	 * @param drawid
	 * @param memberid
	 * @return
	 */
	ResultCode<PrizeVo> addLoginPointInFestival(Long drawid, Long memberid);
	
	
	/**
	 * 根据tag获取活动
	 * @param tag
	 * @return
	 */
	ResultCode<DrawActivityVo> getDrawActivityByTag(String tag);
	
	/**
	 * 获取用户剩余抽奖次数(根据活动配置项目数据)
	 * @param tag 
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode<String> getDrawAllowNumber(String tag, Long memberid, String remoteIp);
	
	/**
	 * 根据购票类型类型查询抽奖活动
	 * @param tickettype
	 * @return
	 */
	ResultCode<List<DrawActivityVo>> getDrawActivityListByTickettype(String tickettype);
}
