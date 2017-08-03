package com.gewara.drama.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.drama.vo.ZeroGrabTicketVo;
import com.gewara.drama.vo.ZgCounterVo;
import com.gewara.drama.vo.cmd.GrabRosterParamsVo;
/**
 * 抢票业务处理
 * @author 赵雄鹰
 *@date 2015年4月15日 11:51:41
 */
public interface ZeroGrabRosterVoService {
	/**
	 * 抢票异步生成订单，出票（wap端）
	 * @param reqVo
	 * @return
	 */
	ResultCode<ZeroGrabRosterVo> addPartnerZeroGrabRoster(GrabRosterParamsVo reqVo);
	/**
	 * 抢票异步生成订单，出票（web zhuanti端）
	 * @param reqVo
	 * @return
	 */
	ResultCode<ZeroGrabRosterVo> addZeroGrabRoster(GrabRosterParamsVo reqVo);
	
	/**
	 * 验证是否已抢票
	 * @param priceid
	 * @return
	 */
	ResultCode<Boolean> validZeroGrabTicket(Long priceid, Long memberid, String mobile);
	
	/**
	 * 通过特殊标识查询预约信息
	 * @param flag
	 * @return
	 */
	ResultCode<ZeroGrabTicketVo> getZeroGrabTicketByFlag(String flag);
	
	/**
	 * 通过特殊标识查询预约信息
	 * @param flag
	 * @return
	 */
	ResultCode<List<ZeroGrabTicketVo>> getZeroGrabTicketListByFlag(String ...flag);
	
	/**
	 * 查询抢票预约库存数
	 * @param priceid
	 * @return
	 */
	ResultCode<ZgCounterVo> getZgCounterByPriceid(Long priceid);
	/**
	 * 查询抢票预约库存数
	 * @param priceid
	 * @return
	 */
	ResultCode<List<ZgCounterVo>> getZgCounterListByPriceid(Long ...priceid);
}