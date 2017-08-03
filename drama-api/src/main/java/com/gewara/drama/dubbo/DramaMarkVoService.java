package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;

public interface DramaMarkVoService {
	
	/**
	 * 根据tag更新演出相关对象评分
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode saveOrUpdateMark(String tag, Long relatedid, String markname, Integer diffmark, boolean update);
	
	/**
	 * 根据tag更新演出相关对象地图坐标
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode saveOrUpdatePoint(String tag, Long relatedid, String pointx, String pointy, String pointType);
	
	/**
	 * 根据tag更新演出相关对象地图坐标
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode updateFirstPicture(String tag, Long relatedid, String picPath);

}
