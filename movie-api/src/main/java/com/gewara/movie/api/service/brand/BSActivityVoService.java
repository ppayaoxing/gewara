package com.gewara.movie.api.service.brand;


import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.brand.BSActivityVo;

public interface BSActivityVoService {
	
	/**
	 * 获取活动数据
	 * @param id	活动ID
	 * @return
	 */
	ResultCode<BSActivityVo> getActivityDataById(Long id);
	

	/**
	 * 保存活动数据
	 * @return
	 */
	ResultCode<BSActivityVo> save(BSActivityVo activity);
	
	/**
	 * 查询活动列表
	 * @param citycode	城市code
	 * @param actType 活动列表
	 * @param
	 * @param
	 */
	ResultCode<List<BSActivityVo>> getActivityListByActType(String citycode, String actType);
	
	/**
	 * 查询活动列表
	 * @param citycode	城市code
	 * @param
	 * @param
	 * @param 
	 */
	ResultCode<List<BSActivityVo>> getActivityList(String citycode);
	
	/**
	 * 查询活动数据量
	 * @return
	 */
	ResultCode<Integer> getActivityCount();
	
	/**
	 * 获取活动列表
	 * @return
	 */
	ResultCode<List<BSActivityVo>> getActivityList(int from, int to, String time);
	
	/**
	 * 删除活动
	 * @param id
	 * @return
	 */
	ResultCode deleteById(Long id);
}
