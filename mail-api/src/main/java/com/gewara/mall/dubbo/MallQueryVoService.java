package com.gewara.mall.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.MallOrderItemVo;
import com.gewara.mall.vo.MemberUsefulAddressVo;
import com.gewara.mall.vo.OrderDetailShowVo;
import com.gewara.mall.vo.OrderParamsVo;
import com.gewara.mall.vo.ProductVo;
import com.gewara.mall.vo.ShipperOrderVo;
import com.gewara.mall.vo.SkuVo;

public interface MallQueryVoService {
	/**
	 * 获取商品信息
	 * @param productId 商品Id
	 * @return
	 */
	ResultCode<ProductVo> getProductVo(Long productId);
	/**
	 * 获取订单购买的每个类目
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<MallOrderItemVo>> getMallOrderItemVoList(String tradeNo);
	/**
	 * 获取商品列表
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<ProductVo>> getProductVoList(String tradeNo);
	/**
	 * 获取SKU信息
	 * @param id
	 * @return
	 */
	ResultCode<SkuVo> getSkuVo(Long id);
	
	/**
	 * 获取SKU信息列表
	 * @param id
	 * @return
	 */
	ResultCode<List<SkuVo>> getSkuVoList(List<Long> idList);
	/**
	 * 更加订单号获取sku列表
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<SkuVo>> getSkuVoList(String tradeNo);
	
	/**
	 * 获取商场总订单
	 * @param command
	 * @return
	 */
	ResultCode<List<OrderDetailShowVo>> getOrderDetailShowVoList(OrderParamsVo command,int from,int maxnum);
	/**
	 * 获取商城拆分订单
	 * @param mallOrderId
	 * @param shipperOrderNo
	 * @return
	 */
	ResultCode<List<ShipperOrderVo>> getShipperOrderVoList(Long mallOrderId,String shipperOrderNo);
	
	/**
	 * 获取商城拆分订单明细
	 * @param shipperOrderId
	 * @return
	 */
	ResultCode<OrderDetailShowVo> getOrderDetailShowVo(Long shipperOrderId);
	/**
	 * 获取商城订单明细
	 * @param mallOrderId
	 * @return
	 */
	ResultCode<OrderDetailShowVo> getOrderDetailShowVoByMallOrderId(Long mallOrderId);
	/**
	 * 获取订单的快递地址
	 * @param mallOrderId
	 * @return
	 */
	ResultCode<MemberUsefulAddressVo> getMemberUsefulAddressByMallOrderId(Long mallOrderId);
}
