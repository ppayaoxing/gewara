package com.gewara.api.service.pay;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PubSaleVo;


public interface PubSaleVoService {

	/**
	 * 获取竞拍数据
	 * @param id
	 * @return
	 */
	ResultCode<PubSaleVo> getPubSale(Long id);
}
