package com.gewara.api.partner.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.partner.res.vo.PhoneAdvertisementVo;
import com.gewara.api.vo.ResultCode;

public interface PhoneAdvertisementVoService {
	/**
	 * 查询推荐活动
	 * @param id 活动ID
	 * @return
	 */
	ResultCode<PhoneAdvertisementVo> getPhoneAdverVo(Long id);
	/**
	 * 根据批次查询城市列表
	 * @param batchid 批次ID
	 * @return
	 */
	ResultCode<Map<String, Long>> getCitycodesByBatchid(String batchid);
	/**
	 * 根据关联ID获取所有关联活动
	 * @param adverId
	 * @param sourceId
	 * @return
	 */
	ResultCode<List<Map<String, String>>> getLinkedListBySourceId(Long adverId, Long sourceId);
	/**
	 * 取得同等级活动中包含改citycode的活动ID
	 * @param adverId
	 * @param citycode
	 * @return
	 */
	ResultCode<Long> getSameLevelIdByCitycode(Long adverId, String citycode);
	
	/**
	 * 查询广告列表
	 * @param apptype
	 * @param osType
	 * @param citycode
	 * @param advtype
	 * @return
	 */
	ResultCode<List<PhoneAdvertisementVo>> getPhoneAdvertList(String apptype, String osType,String citycode,String advtype);
	
}
