/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.constant;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class MallOrderConstant {
	public static final String STATUS_NEW = "new";
	public static final String STATUS_CANCEL = "cancel";
	public static final String STATUS_REPEAT = "cancel_repeat";
	public static final String STATUS_TIMEOUT = "cancel_timeout";
	public static final String STATUS_NEW_CONFIRM = "new_confirm";
	public static final String STATUS_PAID_FAILURE = "paid_failure";
	public static final String STATUS_PAID_SUCCESS = "paid_success";
	public static final String STATUS_PAID_RETURN = "paid_return";
	public static final String STATUS_PAID_RETURN_PART = "paid_return_part";
	public static final String MALL_STATUS_PAID_DEPOSIT = "paid_deposit";
	public static final String MALL_STATUS_PAID_RETAINAGE = "paid_retainage";
	public static final String MALL_STATUS_PAID_EXCHANGE = "paid_exchange";
	public static final String EXP_STATUS_INIT = "init";
	public static final String EXP_STATUS_WAITSEND = "waitSend";
	public static final String EXP_EXPRESS_RECEIVE = "expressReceive";
	public static final String EXP_STATUS_SENDED = "sended";
	public static final String EXP_STATUS_RECEVIVE = "receive";
	public static final String EXP_STATUS_SENDED4ALL = "sended4All";
	public static final String EXP_STATUS_SENDED4PART = "sended4Part";
	public static final String EXP_STATUS_RECEVIVE4ALL = "receive4All";
	public static final String EXP_STATUS_RECEVIVE4PART = "receive4Part";
	public static final String EXP_STATUS_EXPRESS_RECEVIVE = "expressReceive";
	public static final String CATEGORY_PRODUCT = "product";
	public static final String CATEGORY_PRESELL_DEPOSIT = "presell_deposit";
	public static final String CATEGORY_PRESELL_RETAINAGE = "presell_retainage";
	public static Map<String, String> orderStatusMap;
	public static Map<String, String> expStatusMap;
	public static final String NS_HC_MOVIEORDER_ = "order4Movie";

	public static String getMovieHcTable(Long movieId) {
		return "order4Movie" + Math.abs(movieId.hashCode()) % 40;
	}

	static {
		LinkedHashMap linkedstatusMap = new LinkedHashMap();
		linkedstatusMap.put("new", "待付款");
		linkedstatusMap.put("cancel", "取消订单");
		linkedstatusMap.put("cancel_repeat", "重复订单");
		linkedstatusMap.put("cancel_timeout", "超时取消");
		linkedstatusMap.put("new_confirm", "等待付款");
		linkedstatusMap.put("cancel", "取消订单");
		linkedstatusMap.put("cancel_repeat", "重复订单");
		linkedstatusMap.put("cancel_timeout", "超时取消");
		linkedstatusMap.put("paid_failure", "待处理");
		linkedstatusMap.put("paid_success", "订单成功");
		linkedstatusMap.put("paid_return", "退款订单");
		linkedstatusMap.put("paid_return_part", "部分退款");
		linkedstatusMap.put("paid_deposit", "定金完成");
		linkedstatusMap.put("paid_retainage", "尾款完成");
		linkedstatusMap.put("paid_exchange", "换货订单");
		orderStatusMap = UnmodifiableMap.decorate(linkedstatusMap);
		expStatusMap = new LinkedHashMap();
		expStatusMap.put("waitSend", "等待发货");
		expStatusMap.put("sended", "卖家已发货");
		expStatusMap.put("receive", "买家已收货");
		expStatusMap.put("sended4All", "卖家已发货");
		expStatusMap.put("sended4Part", "部分发货");
		expStatusMap.put("receive4All", "买家已收货");
		expStatusMap.put("receive4Part", "部分收货");
		expStatusMap.put("expressReceive", "快递公司已揽件");
	}
}