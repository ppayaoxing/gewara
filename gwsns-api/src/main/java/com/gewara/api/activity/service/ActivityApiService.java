package com.gewara.api.activity.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.activity.domain.ActivityInterestVo;
import com.gewara.api.activity.domain.ActivityMpiVo;
import com.gewara.api.activity.domain.ActivitySpecialVo;
import com.gewara.api.activity.domain.ActivityVo;
import com.gewara.api.activity.domain.CategoryCountVo;
import com.gewara.api.activity.domain.MobileAdvertRecommendVo;
import com.gewara.api.sns.vo.RecommandData;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface ActivityApiService {

	public ResultCode<ActivityVo> getActivitById(Long activityid);
	
	public ResultCode<ActivityVo> getActivitById(Long activityid, boolean checkStatus);
	
	//@RequestMapping("/api/activity/join.xhtml")
	public  ResultCode<ActivityVo> joinActivity(Long memberid,
			Long activityid, String sex, String realname, String mobile,
			Integer joinnum, Date joindate, String address, String otherinfo,
			String walaaddress);
	/**
	 * 取消参与活动
	 * @param activityid
	 * @param memberid
	 * @return
	 */
	public  ResultCode<ActivityVo> quitActivity(Long activityid, Long memberid);

	/**
	 * 收藏活动
	@RequestMapping("/api/activity/collect.xhtml")
	 * 
	 * @param model
	 * @param activityid
	 * @param memberid
	 * @return
	 */
	public  ResultCode<String> collectActivity(Long activityid, Long memberid);

	/**
	 * 取消收藏
	@RequestMapping("/api/activity/cancelcollect.xhtml")
	 * @param model
	 * @param activityid
	 * @param memberid
	 * @return
	 */
	public  ResultCode<String> cancelCollectActivity(Long activityid, Long memberid);

	/**
	 * 获取推荐或置顶活动列表
	@RequestMapping("/api/activity/topList.xhtml")
	 * 
	 * @param model
	 * @param citycode
	 * @param type
	 * @param tag
	 * @param relatedid
	 *            对应tag的关联id
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getTopActivityList(String citycode, String type, String tag, Long relatedId);
	/**
	 * 根据活动id集合获取活动列表
	@RequestMapping("/api/activity/list/getByIds.xhtml")
	 * @param ids 以“,”分隔的ids
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getActivityListByIds(String ids);

	public  ResultCode<List<ActivityVo>> getMemberJoinActivityListByTag(String tag, 
					Long memberid, int from, int maxnum);


	/**
	 * 查询当前活动数量
	@RequestMapping("/api/activity/count/get.xhtml")
	 * @param citycode
	 * @param type
	 * @param timetype
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	public  ResultCode<String> getActivityCount(String citycode,
			String type, int timetype, String tag, Long relatedId);

	/**
	 * 查询活动的信息
	@RequestMapping("/api/activity/list/get.xhtml")
	 * @param citycode
	 * @param type
	 * @param timetype 1所以活动
	 * @param tag
	 * @param relatedid
	 * @param order
	 * @param from
	 * @param maxnum
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getActivityList(
			String citycode, String type, int timetype, String tag,
			Long relatedId, String order, int from, int maxnum);

	/**
	 * 用户的活动列表
	@RequestMapping("/api/activity/list/member.xhtml")
	 * @param memberid
	 * @param citycode
	 * @param timetype
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getMemberActivityList(
			Long memberid, String citycode, int timetype, String tag,
			Long relatedId, int from, int maxnum);

	/**
	 * 获取活动列表必杀方法
	@RequestMapping("/api/activity/list/allCondition.xhtml")
	 * @param model
	 * @param title 	活动标题，模糊查询
	 * @param cityCode 	城市编码
	 * @param type 		活动类型："common"：普通活动"user"：用户活动，认证用户"buss"：商家活动，主办方"gewa"：gewa活动，官方
	 * @param status 	活动状态
	 * @param memberid 	活动发起人id
	 * @param timetype 	活动时间类型 3：未过期的活动 2：过期（结束）的活动 1：所有活动
	 * @param flag 		推荐，置顶
	 * @param tag 		活动类别，如cinema
	 * @param relatedids tag对应的id
	 * @param startTime 查询范围的开始时间，活动报名开始时间大于当前值
	 * @param endTime 	查询范围结束时间，活动报名结束时间小于当前值
	 * @param category 	活动子类别，如movie
	 * @param categoryids category关联的id
	 * @param activityids 活动id集合，用“,”分隔
	 * @param sources 	活动来源： 1网站，2andrio，3iphone 暂时不做处理
	 * @param isFee 	是否收费 Y 收费
	 * @param order 	排序字段
	 * @param asc 		排序方式 Y升序
	 * @param from 
	 * @param maxnum
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getActivityList(
			String signname, String title, String citycode, String countycode,
			String type, String datetype, String status, String memberid,
			int timetype, String flag, String tag, String relatedids,
			Timestamp starttime, Timestamp endtime, String category,
			String categoryids, String activityids, String sources,
			String isfee, String order, String asc, int from, int maxnum);
	
	/**
	 * 获取活动列表必杀方法(增加多个排序)
	 * @param model
	 * @param title 	活动标题，模糊查询
	 * @param cityCode 	城市编码
	 * @param type 		活动类型："common"：普通活动"user"：用户活动，认证用户"buss"：商家活动，主办方"gewa"：gewa活动，官方
	 * @param status 	活动状态
	 * @param memberid 	活动发起人id
	 * @param timetype 	活动时间类型 3：未过期的活动 2：过期（结束）的活动 1：所有活动
	 * @param flag 		推荐，置顶
	 * @param tag 		活动类别，如cinema
	 * @param relatedids tag对应的id
	 * @param startTime 查询范围的开始时间，活动报名开始时间大于当前值
	 * @param endTime 	查询范围结束时间，活动报名结束时间小于当前值
	 * @param category 	活动子类别，如movie
	 * @param categoryids category关联的id
	 * @param activityids 活动id集合，用“,”分隔
	 * @param sources 	活动来源： 1网站，2andrio，3iphone 暂时不做处理
	 * @param isFee 	是否收费 Y 收费
	 * @param order 	排序字段
	 * @param asc 		排序方式 Y升序
	 * @param from 
	 * @param maxnum
	 * @return
	 */
	public  ResultCode<List<ActivityVo>> getActivityListByOrders(
			String signname, String title, String citycode, String countycode,
			String type, String datetype, String status, String memberid,
			int timetype, String flag, String tag, String relatedids,
			Timestamp starttime, Timestamp endtime, String category,
			String categoryids, String activityids, String sources,
			String isfee, String[] order, String asc, int from, int maxnum);
	
	/**
	 * 
	@RequestMapping("/api/activity/count/allCondition.xhtml")
	 * @param title
	 * @param citycode
	 * @param countycode
	 * @param type
	 * @param datetype
	 * @param status
	 * @param memberid
	 * @param timetype
	 * @param flag
	 * @param tag
	 * @param relatedids
	 * @param starttime
	 * @param endtime
	 * @param category
	 * @param categoryids
	 * @param activityids
	 * @param sources
	 * @param isfee
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:29:15
	 */
	public  ResultCode<String> getActivityCount(String title,
			String citycode, String countycode, String type, String datetype,
			String status, Long memberid, int timetype, String flag,
			String tag, String relatedids, Timestamp starttime,
			Timestamp endtime, String category, String categoryids,
			String activityids, String sources, String isfee);


	/**
	 * 
	@RequestMapping("/api/activity/categoryMap.xhtml")
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:29:46
	 */
	public  ResultCode<List<CategoryCountVo>> getCategoryMap();

	/**
	 * 
	@RequestMapping("/api/activity/getCurActivityList.xhtml")
	 * @param citycode
	 * @param tag
	 * @param signname
	 * @param type
	 * @param relatedid
	 * @param category
	 * @param categoryid
	 * @param order
	 * @param from
	 * @param maxnum
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:30:24
	 */
	public  ResultCode<List<ActivityVo>> getActivityList(
			String citycode, String tag, String signname, String type,
			String relatedid, String category, String categoryid, String order,
			int from, int maxnum);

	/**
	 * 
	@RequestMapping("/api/activity/getRecommendActivityBySignNameList.xhtml")
	 * @param signname
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:30:37
	 */
	public  ResultCode<List<ActivityVo>> getRecommendActivityBySignNameList(
			String signname, String citycode, int from, int maxnum);

	/**
	 * 
	@RequestMapping("/api/activity/getActivityMpi.xhtml")
	 * @param activityid
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:30:44
	 */
	//根据活动ID查询场次
	public  ResultCode<String> getActivityMpi(Long activityid);


	/**
	 * @RequestMapping("/api/activity/getJoinInfo.xhtml")
	 * @param memberid
	 * @param relatedid
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:30:55
	 */
	public  ResultCode<String> getJoinInfo(Long memberid, Long relatedid);

	/**
	 * @RequestMapping("/api/activity/getMpiGuest.xhtml")
	 * @param activityid
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:31:03
	 */
	public  ResultCode<List<ActivityMpiVo>> getMpiGuest(Long activityid);


	/**
	 * @RequestMapping("/api/activity/getActivityRelatedidByTag.xhtml")
	 * @param citycode
	 * @param timetype
	 * @param tag
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:31:19
	 */
	public  ResultCode<String> getActivityRelatedidByTag(
			String citycode, Integer timetype, String tag);

	/**
	 * @RequestMapping("/api/activity/getMobileAdvertList.xhtml")
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @param model
	 * @return
	 * @author leo
	 * @addTime 2014年6月25日下午5:31:24
	 */
	public  ResultCode<List<MobileAdvertRecommendVo>> getMobileAdvert(
			String citycode, int from, int maxnum);
	
	public ResultCode<Long> addActivity(ActivityVo activityVo, Map map);

	public ResultCode<Long> applyActivityStatus(Long activityid, Long memberid);
	
	/**
	 * 获取推荐数据
	 * @return
	 */
	public  ResultCode<List<RecommandData>> getRecommendData();
	
	
	/**
	 * 同步专题活动数据
	 * @param   ztid   专题ID
	 * @param   title  专题标题
	 * @param   url    专题链接地址(完整路径)
	 * @param   logo    专题封面图片地址(完整路径)
	 * @param   support  专题支持方式（PC、WAP、ALL）
	 * @param   starttime 专题发布时间   
	 * @param  	otherMap  其它信息Map<String,String>
	 */
	public ResultCode synchronActivitySpecial(Long ztid,String title,String url,String logo,String support,Timestamp starttime,Map<String,String> otherMap);
	
	/**
	 * 获取活动兴趣板块设置数据
	 * @param sign 活动标识  starmeet -->明星见面会 、cinephiles -->影展 、 filmreviews --->写影评、cinema -->影院活动
	 * @return
	 */
	public ResultCode<ActivityInterestVo> getActivityInterestBySign(String sign);
	
	
	/**
	 * 获取专题活动数据(带缓存10分钟)
	 * @param starttime 发布开始时间时间范围
	 * @param endtime 发布开始时间时间范围
	 * @param from
	 * @param maxnum
	 * @return
	 */
	public ResultCode<List<ActivitySpecialVo>> getActivitySpecialList(Timestamp starttime,Timestamp endtime,int from,int maxnum);
	/**
	 * 获取支付成功的人数
	 * @param activityid
	 * @param virtualcount
	 * @param quantity
	 * @return
	 */
	public ResultCode<Integer> getOrderNumForSuccess(Long activityid);
	
	/**
	 * 查询mongo中保存的电影活动顺序信息
	 * @param category
	 * @param categoryid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	public  ResultCode<VoMap<Long,Integer>> getMongoActivityVoMap(String category, Long categoryid, int from, int maxnum);

}
