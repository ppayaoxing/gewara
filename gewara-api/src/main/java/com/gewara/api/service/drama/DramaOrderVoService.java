package com.gewara.api.service.drama;

import java.util.List;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.OrderParamsVo;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OrderOtherVo;
import com.gewara.drama.vo.cmd.AreaSeatParamsVo;
import com.gewara.drama.vo.cmd.ItemSeatMapVo;

public interface DramaOrderVoService {
	
	public ResultCode<ItemSeatMapVo> getChooseSeat(AreaSeatParamsVo paramsVo) ;
	/**
	 * 查询演出订单
	 * @param command
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getDramaOrderVoList(OrderParamsVo command, int from, int maxnum);
	
	/**
	 * 获取购买列表				
	 * @param orderId 订单id
	 * @return
	 * @author 赵雄鹰
	 * @date 2014年10月23日 14:37:58
	 */
	ResultCode<List<BuyItemVo>> getItemList(Long orderId);
	
	/**
	 * 查询演出订单
	 * @param orderid
	 * @deprecated 见gworder接口
	 * @see com.gewara.api.gworder.service.GwOrderService.getOrderById
	 * @return
	 */
	@Deprecated 
	ResultCode<GewaOrderVo> getDramaOrderVo(Long orderid);
	
	ResultCode<GewaOrderVo> getLastUnpaidDramaOrder(Long memberid, String ukey, Long areaid);
	
	ResultCode<List<String>> getDramaOrderSeatLabelList(Long orderid);
	
	
	/*****
	 * 
	* @Title: 
	* @Description: 获取积分
	* @param orderid
	* @return
	* @return ResultCode<OrderOtherVo>
	 */
	ResultCode<OrderOtherVo> getDramaOrderOtherData(Long orderid);
	
	/**
	 * 验证用户票券问题
	 * @param dramaid
	 * @param memberid
	 * @return 
	 * @see DramaPrioritizeVoService.checkDramaPrioritize
	 */
	@Deprecated 
	ResultCode checkPriorizite(Long dramaid, Long memberid);
	
	/**
	 * 保存远程打票信息
	 * @param orderid
	 * @param remotePrintInfo
	 * @return
	 */
	ResultCode saveOrderPrintInfo(Long orderid, String remotePrintInfo);
	
	/**
	 * 保存订单快递信息
	 * @param orderid
	 * @param addressid
	 * @return
	 */
	ResultCode<Integer> saveOrderAddress(Long orderid, Long addressid);
}
