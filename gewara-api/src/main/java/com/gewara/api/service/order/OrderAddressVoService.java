package com.gewara.api.service.order;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.OrderAddressVo;

public interface OrderAddressVoService {

	/**
	 * 获取用户最近买购过的订单快递地址编号  @see  MemberUsefullAddress.id
	 * @param memberid
	 * @param departmentFlag
	 * @param starttime
	 * @return
	 */
	ResultCode<List<OrderAddressVo>> getPostOrderAddressList(Long memberid, String departmentFlag, Timestamp starttime);
}
