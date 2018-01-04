package com.gewara.mall.dubbo;

import com.gewara.api.vo.ResultCode;

public interface MallVoService {
	/**
	 * 获取支付验证信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<String> getPayinfoByTradeNo(String tradeNo);
	/**
	 * 获取交易成功后要给用户发的手机短信内容
	 * @param tradeNo
	 * @return
	 */
	ResultCode<String> getSmsContentByTradeNo(String tradeNo);
	/**
	 * 订单中心通知mall系统该笔订单付款，mall系统返回该笔订单是否能处理成功
	 * @param tradeNo
	 * @return
	 */
	ResultCode processOrderConfirm(String tradeNo);
	/**
	 * 修改订单快递地址
	 * @param userId
	 * @param mallOrderId
	 * @param mobile
	 * @param realname
	 * @param citycode
	 * @param cityname
	 * @param countycode
	 * @param countyname
	 * @param address
	 * @return
	 */
	ResultCode modMemberUsefulAddress(Long userId, Long mallOrderId, String mobile, String realname, 
			String citycode, String cityname, String countycode, String countyname, String address);
}
