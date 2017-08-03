package com.gewara.mall.constant;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class MallOrderConstant {
	//新订单
	public static final String STATUS_NEW = "new";									
	//取消订单
	public static final String STATUS_CANCEL = "cancel";							
	//重复订单
	public static final String STATUS_REPEAT = "cancel_repeat";
	//超时取消
	public static final String STATUS_TIMEOUT = "cancel_timeout";
	//去付款
	public static final String STATUS_NEW_CONFIRM = "new_confirm";	
	//已支付待处理
	public static final String STATUS_PAID_FAILURE = "paid_failure";				
	//交易成功（不包括物流状态）
	public static final String STATUS_PAID_SUCCESS = "paid_success";				
	//退款订单
	public static final String STATUS_PAID_RETURN = "paid_return";
	//部分退款
	public static final String STATUS_PAID_RETURN_PART = "paid_return_part";
	
	//定金完成
	public static final String MALL_STATUS_PAID_DEPOSIT = "paid_deposit";
	//尾款完成
	public static final String MALL_STATUS_PAID_RETAINAGE = "paid_retainage";
	//TODO 换货订单
	public static final String MALL_STATUS_PAID_EXCHANGE = "paid_exchange";			
	
	//初始
	public static final String EXP_STATUS_INIT = "init";
	//等待发货
	public static final String EXP_STATUS_WAITSEND = "waitSend";
	//快递公司已揽件
	public static final String EXP_EXPRESS_RECEIVE = "expressReceive";
	//卖家已发货
	public static final String EXP_STATUS_SENDED = "sended";
	//买家已收货
	public static final String EXP_STATUS_RECEVIVE = "receive";
		
	//全部发货
	public static final String EXP_STATUS_SENDED4ALL = "sended4All";
	//部分发货
	public static final String EXP_STATUS_SENDED4PART = "sended4Part";
	//全部收货
	public static final String EXP_STATUS_RECEVIVE4ALL = "receive4All";
	//部分收货
	public static final String EXP_STATUS_RECEVIVE4PART = "receive4Part";
	//快递公司已揽件
	public static final String EXP_STATUS_EXPRESS_RECEVIVE = "expressReceive";
	
	//普通商品
	public static final String CATEGORY_PRODUCT = "product";
	//预售定金
	public static final String CATEGORY_PRESELL_DEPOSIT = "presell_deposit";
	//预售尾款
	public static final String CATEGORY_PRESELL_RETAINAGE = "presell_retainage";
	
	public static Map<String, String>  orderStatusMap;
	public static Map<String, String>  expStatusMap;
	static{
		LinkedHashMap<String, String> linkedstatusMap = new LinkedHashMap<>();
		linkedstatusMap.put(STATUS_NEW, "待付款");
		linkedstatusMap.put(STATUS_CANCEL, "取消订单");
		linkedstatusMap.put(STATUS_REPEAT, "重复订单");
		linkedstatusMap.put(STATUS_TIMEOUT, "超时取消");
		
		linkedstatusMap.put(STATUS_NEW_CONFIRM, "等待付款");
		linkedstatusMap.put(STATUS_CANCEL, "取消订单");
		linkedstatusMap.put(STATUS_REPEAT, "重复订单");
		linkedstatusMap.put(STATUS_TIMEOUT, "超时取消");
		
		
		linkedstatusMap.put(STATUS_PAID_FAILURE, "待处理");
		linkedstatusMap.put(STATUS_PAID_SUCCESS, "订单成功");
		linkedstatusMap.put(STATUS_PAID_RETURN, "退款订单");
		linkedstatusMap.put(STATUS_PAID_RETURN_PART, "部分退款");
		
		linkedstatusMap.put(MALL_STATUS_PAID_DEPOSIT, "定金完成");
		linkedstatusMap.put(MALL_STATUS_PAID_RETAINAGE, "尾款完成");
		linkedstatusMap.put(MALL_STATUS_PAID_EXCHANGE, "换货订单");
		orderStatusMap = UnmodifiableMap.decorate(linkedstatusMap);
		
		expStatusMap = new LinkedHashMap<>();
		expStatusMap.put(EXP_STATUS_WAITSEND, "等待发货");
		expStatusMap.put(EXP_STATUS_SENDED, "卖家已发货");
		expStatusMap.put(EXP_STATUS_RECEVIVE, "买家已收货");
		
		expStatusMap.put(EXP_STATUS_SENDED4ALL, "卖家已发货");
		expStatusMap.put(EXP_STATUS_SENDED4PART, "部分发货");
		expStatusMap.put(EXP_STATUS_RECEVIVE4ALL, "买家已收货");
		expStatusMap.put(EXP_STATUS_RECEVIVE4PART, "部分收货");
		expStatusMap.put(EXP_STATUS_EXPRESS_RECEVIVE, "快递公司已揽件");
	}
	public static final String NS_HC_MOVIEORDER_ = "order4Movie";
	public static String getMovieHcTable(Long movieId){
		return NS_HC_MOVIEORDER_+ Math.abs(movieId.hashCode())%40;
	}
}
