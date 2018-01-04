package com.gewara.api.service.subscribe;


import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.movie.SubscribeVo;

/**
 * 获取预约
 * @author pengdi
 *
 */
public interface SubscirbeVoService {
  
	ResultCode<String>getSubscribeList(String startTime,String endTime,int from,int maxnum);

	/**
	 * 查询用户有效预约列表</br>
	 * addtime大于等于当前日期，并按addtime升序排序
	 * @param memberId 用户ID
	 * @param from
	 * @param maxnum
	 * @return
	 * @author leo
	 * @addTime 2016年10月14日上午11:31:31
	 */
	ResultCode<List<SubscribeVo>> getSubscribeList(Long memberId, int from, int maxnum);
	
	
}
