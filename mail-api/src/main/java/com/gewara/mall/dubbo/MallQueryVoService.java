/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.MallOrderItemVo;
import com.gewara.mall.vo.MemberUsefulAddressVo;
import com.gewara.mall.vo.OrderDetailShowVo;
import com.gewara.mall.vo.OrderParamsVo;
import com.gewara.mall.vo.ProductVo;
import com.gewara.mall.vo.ShipperOrderVo;
import com.gewara.mall.vo.SkuVo;
import java.util.List;

public interface MallQueryVoService {
	ResultCode<ProductVo> getProductVo(Long arg0);

	ResultCode<List<MallOrderItemVo>> getMallOrderItemVoList(String arg0);

	ResultCode<List<ProductVo>> getProductVoList(String arg0);

	ResultCode<SkuVo> getSkuVo(Long arg0);

	ResultCode<List<SkuVo>> getSkuVoList(List<Long> arg0);

	ResultCode<List<SkuVo>> getSkuVoList(String arg0);

	ResultCode<List<OrderDetailShowVo>> getOrderDetailShowVoList(OrderParamsVo arg0, int arg1, int arg2);

	ResultCode<List<ShipperOrderVo>> getShipperOrderVoList(Long arg0, String arg1);

	ResultCode<OrderDetailShowVo> getOrderDetailShowVo(Long arg0);

	ResultCode<OrderDetailShowVo> getOrderDetailShowVoByMallOrderId(Long arg0);

	ResultCode<MemberUsefulAddressVo> getMemberUsefulAddressByMallOrderId(Long arg0);
}