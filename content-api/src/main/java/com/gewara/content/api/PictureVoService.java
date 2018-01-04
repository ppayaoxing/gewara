package com.gewara.content.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.PictureVo;

public interface PictureVoService {
	
	ResultCode<List<PictureVo>> getPictureList(String tag, Long relatedid, int from, int maxnum);
	/**
	 * 使用缓存(功能同方法：getPictureList )
	 * @param tag
	 * @param relatedid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<PictureVo>> getPictureListUseCache(String tag, Long relatedid, int from, int maxnum);
	/**
	 * 查询图片数量
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode<Integer> getPictureCount(String tag, Long relatedid);
	
	/**
	 * 保存活动项目传的图片信息
	 * @param memberid
	 * @param activityid
	 * @param fileName
	 * @param realName
	 * @return
	 */
	ResultCode saveActivityPicture(Long memberid, Long activityid, String fileName, String realName);
	
	ResultCode<PictureVo> getPicture(Long pid);
	
	/**
	 * 获取图片个数
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode<Integer> getPictureCountByRelatedid(String tag, Long relatedid);
	
	/**
	 * 得到关联对象的图片列表 使用10分钟缓存
	 * @param tag
	 * @param relatedid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<PictureVo>> getPictureListByRelatedidUseCache(String tag, Long relatedid, int from, int maxnum);
}
