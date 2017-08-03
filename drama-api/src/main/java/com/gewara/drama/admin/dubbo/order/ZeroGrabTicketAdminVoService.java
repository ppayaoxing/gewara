package com.gewara.drama.admin.dubbo.order;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.drama.vo.ZeroGrabTicketVo;
import com.gewara.drama.vo.ZgCounterVo;
import com.gewara.drama.vo.req.common.ZeroGrabReqVo;

public interface ZeroGrabTicketAdminVoService {
	
	ResultCode<ZeroGrabTicketVo> getZeroGrabTicketById(Long id);
	
	ResultCode<ZeroGrabTicketVo> saveZeroGrabTicket(RequestParamVo paramVo);
	
	ResultCode delZeroGrabTicket(Long id);
	
	/**
	 * 查询零元抢票信息
	 * @param title
	 * @param starttime
	 * @param endtime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<ZeroGrabTicketVo>> getZeroGrabTicketList(String title, Timestamp starttime, Timestamp endtime, int from, int maxnum);
	
	/**
	 * 通过抢票活动ID编号获取抢票人信息
	 * @param priceid
	 * @param mobile
	 * @param tradeno
	 * @return
	 */
	ResultCode<List<ZeroGrabRosterVo>> getZeroGrabRosterList(Long priceid, String mobile, String tradeno);

	ResultCode<List<ZeroGrabRosterVo>> getZeroGrabRosterPageList(ZeroGrabReqVo zeroGrabReqVo);

	/**
	 * 通过ID编号获取抢票人信息
	 * @param id
	 * @return
	 */
	ResultCode<ZeroGrabRosterVo> getZeroGrabRoster(Long id);
	
	/**
	 * 通过IDList获取ZgCounter列表
	 * @param ids
	 * @return
	 */
	ResultCode<List<ZgCounterVo>> getZgCounterList(Long ... ids);
	
	ResultCode<ZgCounterVo> getZgCounter(Long id);
	
	ResultCode<ZgCounterVo> saveZgCounter(RequestParamVo paramVo);
	
	
	

}
