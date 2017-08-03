package com.gewara.movie.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class BaoChangConstant {
	public static final String MSG_URL_ORDER_DETAIL = "gewara://com.gewara.movie?pageid=7";
	public static final String MSG_URL_PARTNER = "gewara://com.gewara.movie?pageid=23";
	public static final String MSG_URL_REDIRECT = "gewara://com.gewara.movie?pageid=5";
	
	public static final Integer DATA_VALID = 1;   //有效数据
	public static final Integer DATA_INVALID = 0; //无效数据
	
	public static final String SEND_MSG_CHANNEL_APPOINTMENT = "channel_appointment";   //包场预约交易成功（预约影院包场）
	public static final String SEND_MSG_CHANNEL_PAID = "channel_paid";   //包场交易成功（包括预约成功后，设置场次成功）
	public static final String SEND_MSG_CHANNEL_FAIL = "channel_fail";   //包场失败
	public static final String SEND_MSG_CHANNEL_RECEIPTOR = "channel_receiptor";   //领票人短信
	
	public static final String BAOCHANG_FROM_ANDROID = "android";   //安卓
	public static final String BAOCHANG_FROM_IOS = "ios";   //IOS
	
	public static final Integer PURCHASER_TICKET_NUM = 1000; //包场人最多选座个数
	public static final Integer RECEIPTOR_TICKET_NUM = 5; //领票人最多选座个数
	
	public static final String ORDER_TYPE_EXIST = "exist";//现有场次订单
	public static final String ORDER_TYPE_APPOINTMENT = "appointment";//预约场次订单
	
	public static final String CACHE_TAG_ADD_UPDATE = "add_update";//增加/修改对象
	public static final String CACHE_TAG_REMOVE = "remove";//删除
	
	public static final String MPI_STATUS_LOCK = "lock";//锁定场次
	public static final String MPI_STATUS_SUCCESS = "success";//包场成功
	public static final String MPI_STATUS_UNLOCK = "unlock";//未锁定
	
	public static final String TIME_TAG_MORNING = "morning";//上午
	public static final String TIME_TAG_AFTERNOON = "afternoon";//下午
	public static final String TIME_TAG_NIGHT = "night";//晚上
	
	public static final String ORDER_STATUS_ORDER_SUCCESS = "order_success"; //下单成功未支付
	public static final String ORDER_STATUS_PROCESSING = "processing"; //场次安排中
	public static final String ORDER_STATUS_SECCUSS = "seccuss"; //场次已开放
	public static final String ORDER_STATUS_FAIL = "fail"; //安排失败
	public static final String ORDER_STATUS_REFUND_SECCUSS = "refund_seccuss"; //退款成功
	public static final String ORDER_STATUS_REFUND_FAIL = "refund_fail"; //退款失败
	public static final String ORDER_STATUS_CANCEL = "cancel"; //订单取消
	public static final List<String> baoChangOrderStatusList = Arrays.asList(ORDER_STATUS_PROCESSING,
			ORDER_STATUS_SECCUSS, ORDER_STATUS_FAIL);
	public static final String[] baoChangMsgAppointmentIos = new String[]{"%username", "%appointmentDate", "%appointmentTime", 
		"%roomname", "%cinemaname", "%moviename", "%orderDetailUrl"};
	public static final String[] baoChangMsgPaidIos = new String[]{"%username", "%playdate", "%playtime", 
		"%roomname", "%cinemaname", "%moviename", "%partnerUrl"};
	public static final String[] baoChangMsgFailIos = new String[]{"%username", "%appointmentDate", "%appointmentTime", 
		"%roomname", "%cinemaname", "%moviename","%reason"};
	public static final String[] baoChangMsgReceiptorIos = new String[]{"%username", "%playdate", "%playtime", "%password", 
		"%roomname", "%cinemaname", "%moviename","%movieseat","%tuhaoname","%ticketcount"};
	public static final List<String> baoChangOrderStatusListAndroid = Arrays.asList(ORDER_STATUS_PROCESSING,
			ORDER_STATUS_SECCUSS, ORDER_STATUS_FAIL);
	public static final String[] baoChangMsgAppointmentAndroid = new String[]{"%username", "%appointmentDate", "%appointmentTime", 
		"%roomname", "%cinemaname", "%moviename"};
	public static final String[] baoChangMsgPaidAndroid = new String[]{"%username", "%playdate", "%playtime", 
		"%roomname", "%cinemaname", "%moviename"};
	public static final String[] baoChangMsgFailAndroid = new String[]{"%username", "%appointmentDate", "%appointmentTime", 
		"%roomname", "%cinemaname", "%moviename","%reason"};
	public static final String[] baoChangMsgReceiptorAndroid = new String[]{"%username", "%playdate", "%playtime", "%password", 
		"%roomname", "%cinemaname", "%moviename","%movieseat","%tuhaoname","%ticketcount"};
	public static final Map<String, String> baoChangOrderStatusMap;
	public static final Map<String, String> baoChangOrderTypeMap;
	public static final Map<String, String> baoChangMpiStatusMap;
	public static final Map<String, String> baoChangTimeTagMap;
	public static final Map<String, String> baoChangStatesMap;
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		
		tmp.put(ORDER_STATUS_ORDER_SUCCESS, "下单成功未支付");
		tmp.put(ORDER_STATUS_PROCESSING, "场次安排中");
		tmp.put(ORDER_STATUS_SECCUSS, "包场成功");
		tmp.put(ORDER_STATUS_FAIL, "安排失败");
		tmp.put(ORDER_STATUS_REFUND_SECCUSS, "退款成功");
		tmp.put(ORDER_STATUS_REFUND_FAIL, "退款失败");
		baoChangOrderStatusMap = UnmodifiableMap.decorate(tmp);
		
		tmp = new LinkedHashMap<String, String>();
		tmp.put(ORDER_TYPE_EXIST, "现有场次订单");
		tmp.put(ORDER_TYPE_APPOINTMENT, "预约场次订单");
		baoChangOrderTypeMap = UnmodifiableMap.decorate(tmp);
		
		tmp = new LinkedHashMap<String, String>();
		tmp.put(MPI_STATUS_LOCK, "场次已被锁定");
		tmp.put(MPI_STATUS_SUCCESS, "包场成功");
		tmp.put(MPI_STATUS_UNLOCK, "开放中");
		baoChangMpiStatusMap = UnmodifiableMap.decorate(tmp);
		
		tmp = new LinkedHashMap<String, String>();
		tmp.put(TIME_TAG_MORNING, "上午");
		tmp.put(TIME_TAG_AFTERNOON, "下午");
		tmp.put(TIME_TAG_NIGHT, "晚上");
		baoChangTimeTagMap = UnmodifiableMap.decorate(tmp);
		
		tmp = new LinkedHashMap<String, String>();
		tmp.put(ORDER_STATUS_PROCESSING, "css/wap/movie/private/phone/guide_bcz@3x.png?v=20150106");
		tmp.put(ORDER_STATUS_SECCUSS, "css/wap/movie/private/phone/guide_bccg@3x.png?v=20150106");
		tmp.put(ORDER_STATUS_REFUND_SECCUSS, "css/wap/movie/private/phone/guide_bcsb@3x.png?v=20150106");
		tmp.put(ORDER_STATUS_REFUND_FAIL, "css/wap/movie/private/phone/guide_bcsb@3x.png?v=20150106");
		baoChangStatesMap = UnmodifiableMap.decorate(tmp);
	}
}
