package com.gewara.api.service.zhuanti;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.RedEnvelopeManagerVo;
import com.gewara.api.vo.order.GewaOrderVo;




public interface NewYearRedEnvelopeVoService {
	/**
	 * 
	 * 根据订单信息 查询 是否能生成红包
	 * @param GewaOrderVo  gewaOrder
	 * @return
	 */
	ResultCode<RedEnvelopeManagerVo> findRedEnvelopeManager(GewaOrderVo gewaOrder);
	/**
	 * 根据电影ID查询红包TAG
	* @remark
	* @param relatedId
	* @return
	*/
	ResultCode<String> findRedEnvelopeByRelatedId(Long relatedId);
}
