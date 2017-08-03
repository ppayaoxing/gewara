package com.gewara.api.pay.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

/**
 * 支付金额汇总
 * @author songshi.wang
 *
 */
public interface PaySumApiService {

	/**
	 * 获得指定商户号指定期间的支付信息
	 * @param merchantNo 商户号
	 * @param startDate	开始日期 yyyyMMdd 包含
	 * @param endDate	结束日期 yyyyMMdd 不包含
	 * @return [{"merchantNo":"xxx","sumValue":9999,"sumDate":"yyyyMMdd"}]
	 */
	ResultCode<List<Map<String, Object>>> getSum(String merchantNo, String startDate, String endDate);
	
}
