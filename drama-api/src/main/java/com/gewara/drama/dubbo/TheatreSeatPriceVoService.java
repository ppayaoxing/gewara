package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;


public interface TheatreSeatPriceVoService {
	
	/**
	 * 订单出库或订单退票入库
	 * @param tradeno
	 * @param correcttype
	 * FIXME:订单类型
	 */
	ResultCode createPriceExt(String tradeno, String correcttype);
}
