package com.gewara.api.partner.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;
/**
 * (签约支付)
 * @author chunhui.wang
 *
 */
public interface PartnerContractPayVoService {
	
	/**
	 * 发送签约短信
	 */
	ResultCode sendSignMsg(PartnerCommonReqVo reqVo);
	
	/**
	 * 快捷签约
	 * @param params 参数集合
	 * @return
	 */
	ResultCode doSign(PartnerCommonReqVo reqVo);
	
	/**
	 * 快速解约
	 * @param params
	 * @return
	 */
	ResultCode unSign(PartnerCommonReqVo reqVo);
	
	/**
	 * 支付短信
	 * @param params 参数集合
	 * @return
	 */
	ResultCode sendPayMsg(PartnerCommonReqVo reqVo);
	
	/**
	 * 支付
	 * @param tradeNo 订单号
	 * @return
	 */
	ResultCode doPay(PartnerCommonReqVo reqVo);
	
	/**
	 * 签约ID查询 
	 * @param merUserid 用户ID
	 * @return
	 */
	ResultCode<List<Map>> querySignContents(String merUserid,String payMethod);
}
