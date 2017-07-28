/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.service;

import com.gewara.api.activity.domain.ActivityInterestVo;
import com.gewara.api.activity.domain.ActivityMpiVo;
import com.gewara.api.activity.domain.ActivitySpecialVo;
import com.gewara.api.activity.domain.ActivityVo;
import com.gewara.api.activity.domain.CategoryCountVo;
import com.gewara.api.activity.domain.MobileAdvertRecommendVo;
import com.gewara.api.sns.vo.RecommandData;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ActivityApiService {
	ResultCode<ActivityVo> getActivitById(Long arg0);

	ResultCode<ActivityVo> getActivitById(Long arg0, boolean arg1);

	ResultCode<ActivityVo> joinActivity(Long arg0, Long arg1, String arg2, String arg3, String arg4, Integer arg5,
			Date arg6, String arg7, String arg8, String arg9);

	ResultCode<ActivityVo> quitActivity(Long arg0, Long arg1);

	ResultCode<String> collectActivity(Long arg0, Long arg1);

	ResultCode<String> cancelCollectActivity(Long arg0, Long arg1);

	ResultCode<List<ActivityVo>> getTopActivityList(String arg0, String arg1, String arg2, Long arg3);

	ResultCode<List<ActivityVo>> getActivityListByIds(String arg0);

	ResultCode<List<ActivityVo>> getMemberJoinActivityListByTag(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<String> getActivityCount(String arg0, String arg1, int arg2, String arg3, Long arg4);

	ResultCode<List<ActivityVo>> getActivityList(String arg0, String arg1, int arg2, String arg3, Long arg4,
			String arg5, int arg6, int arg7);

	ResultCode<List<ActivityVo>> getMemberActivityList(Long arg0, String arg1, int arg2, String arg3, Long arg4,
			int arg5, int arg6);

	ResultCode<List<ActivityVo>> getActivityList(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, int arg8, String arg9, String arg10, String arg11, Timestamp arg12,
			Timestamp arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19,
			String arg20, int arg21, int arg22);

	ResultCode<List<ActivityVo>> getActivityListByOrders(String arg0, String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, int arg8, String arg9, String arg10, String arg11,
			Timestamp arg12, Timestamp arg13, String arg14, String arg15, String arg16, String arg17, String arg18,
			String[] arg19, String arg20, int arg21, int arg22);

	ResultCode<String> getActivityCount(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			Long arg6, int arg7, String arg8, String arg9, String arg10, Timestamp arg11, Timestamp arg12, String arg13,
			String arg14, String arg15, String arg16, String arg17);

	ResultCode<List<CategoryCountVo>> getCategoryMap();

	ResultCode<List<ActivityVo>> getActivityList(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, int arg8, int arg9);

	ResultCode<List<ActivityVo>> getRecommendActivityBySignNameList(String arg0, String arg1, int arg2, int arg3);

	ResultCode<String> getActivityMpi(Long arg0);

	ResultCode<String> getJoinInfo(Long arg0, Long arg1);

	ResultCode<List<ActivityMpiVo>> getMpiGuest(Long arg0);

	ResultCode<String> getActivityRelatedidByTag(String arg0, Integer arg1, String arg2);

	ResultCode<List<MobileAdvertRecommendVo>> getMobileAdvert(String arg0, int arg1, int arg2);

	ResultCode<Long> addActivity(ActivityVo arg0, Map arg1);

	ResultCode<Long> applyActivityStatus(Long arg0, Long arg1);

	ResultCode<List<RecommandData>> getRecommendData();

	ResultCode synchronActivitySpecial(Long arg0, String arg1, String arg2, String arg3, String arg4, Timestamp arg5,
			Map<String, String> arg6);

	ResultCode<ActivityInterestVo> getActivityInterestBySign(String arg0);

	ResultCode<List<ActivitySpecialVo>> getActivitySpecialList(Timestamp arg0, Timestamp arg1, int arg2, int arg3);

	ResultCode<Integer> getOrderNumForSuccess(Long arg0);

	ResultCode<VoMap<Long, Integer>> getMongoActivityVoMap(String arg0, Long arg1, int arg2, int arg3);
}