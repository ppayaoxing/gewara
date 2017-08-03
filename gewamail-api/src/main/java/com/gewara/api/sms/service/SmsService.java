package com.gewara.api.sms.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.sms.request.MTRequest;
import com.gewara.api.sms.response.BatchSmsStatusResponse;
import com.gewara.api.sms.response.MTResponse;
import com.gewara.api.vo.ResultCode;

/**
 * 短信接口服务
 * 
 * @author leo.li
 * Modify Time Jan 4, 2013 6:07:31 PM
 */
public interface SmsService {
	
	/**
	 * 短信发送统一接口。
	 * 支持避免重复发送功能；支持定时发送。
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Jan 4, 2013 6:07:46 PM
     * @see #sendSMS2
	 */
	@Deprecated
	public MTResponse sendSMS(MTRequest request);
	
	/**
	 * 短信发送统一接口。
	 * 支持避免重复发送功能；支持定时发送。
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Jan 4, 2013 6:07:46 PM
	 */
	public ResultCode sendSMS2(MTRequest request);
	
	/**
	 * 查询mongo手机号批次短信发送状态
	 * @param batchId mongo手机号批次ID
	 * @return
     * @see #queryBatchSmsStatus2
	 */
	@Deprecated
	public BatchSmsStatusResponse queryBatchSmsStatus(String batchId);
	
	/**
	 * 查询mongo手机号批次短信发送状态
	 * @param batchId mongo手机号批次ID
	 * @return
	 */
	public ResultCode<BatchSmsStatusResponse> queryBatchSmsStatus2(String batchId);
	
	/**
	 * 查找上海系统昨天发送的短信记录的状态
	 * @param smsIdList 短信ID，个数不能长于100; 短信发送接口传的值；
	 * @return  Map， key :  smsId, value: 状态
	 * @author leo
	 * @addTime 2015年11月27日下午6:14:30
	 */
	public ResultCode<Map<String, String>> findYesterdayStatus4Shanghai(List<String> smsIdList);
}
