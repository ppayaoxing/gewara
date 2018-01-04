package com.gewara.cons;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;



/**
 * API订票系统中用到的常量
 * @author acerge(acerge@163.com)
 * @since 12:27:06 PM Apr 22, 2011
 * 0000	成功
 * 1001  场次不存在
 * 1002  场次当前未开放订票：1）关闭 2）只在10：00～18：00开放 3）影院关闭对外订票 等
 * 1003  影院场次信息不同步：需要等待Gewara系统更新影院信息
 *
 * 2001  无法连接影院
 * 2002  座位位置错误：产生孤座，单选情侣座等
 * 2003  座位被占用
 * 2004  座位数量限制错误：超出5个，某些场次中只能买两个或四个等
 * 2005  座位其他限制错误：有积分限制等
 * 2006  违反规则：如孤座等
 * 2098  正在更新影院数据
 * 2099  座位错误：未知错误
 * 4001  商家不存在  
 * 4002  商家无权限  
 * 4003  校验错误  
 * 4004  参数错误：缺少参数或格式不正确  
 * 4005  数据错误：如查询的数据不存在等
 * 4006  支付错误  
 *	
 * 5000	用户不存在
 * 5001	用户未登录
 * 5002	用户无权限
 * 5003	不能重复操作
 * 
 * 9999  未知错误：其他未分类的错误
 */
public abstract class ApiConstant {
	public static final String OPENAPI_AUTH_KEY = "__OPENAPI_AUTH_KEY__";//servlet request key for OpenApiAuth
	public static final String CODE_SUCCESS = "0000";				//成功
	public static final String CODE_OPI_NOT_EXISTS = "1001";		//场次不存在
	public static final String CODE_OPI_CLOSED = "1002";			//场次关闭
	public static final String CODE_OPI_UNSYNCH = "1003";			//场次信息不同步
	
	public static final String CODE_OPI_UNTO_OPENTIME = "1100";		//没到开放时间
	public static final String CODE_OPI_EXPIRE  = "1101";				//场次过期
	public static final String CODE_OPI_STATUS_CLOSE  = "1102";		//场次状态关闭
	public static final String CODE_OPI_BEFORE_CLOSETIME  = "1104";//场次已关闭
	public static final String CODE_OPI_SOLD_OUT  = "1105";			//座位已售完
	public static final String CODE_OPI_UN_MID_TIME  = "1106";		//不在每天开放时间段
	// 判断特价活动是否可用
	public static final String CODE_OPI_SD_QUOTA_FULL  = "1201";	//名额已满
	public static final String CODE_OPI_SD_QUTY_MORE = "1202";		//人数过度
	
	
	public static final String CODE_CONNECTION_ERROR = "2001";
	public static final String CODE_SEAT_POS_ERROR = "2002";
	public static final String CODE_SEAT_OCCUPIED = "2003";			//座位被占用
	public static final String CODE_SEAT_NUM_ERROR = "2004";			//座位数量错误
	public static final String CODE_SEAT_LIMITED = "2005";
	public static final String CODE_SEAT_BREAK_RULE = "2006";
	public static final String CODE_SEAT_SEATTYPE_ERROR = "2007";
	public static final String CODE_SEAT_LOCK_ERROR_CINEMA = "2010";	//锁定座位出错
	public static final String CODE_CCTO_ERROR = "2011";					//第三方与影院连接不正常
	public static final String CODE_TC_ERROR = "2012";						//第三方错误
	public static final String CODE_SEAT_RELEASED = "2013";				//座位已经释放或不存在
	public static final String CODE_SYNCH_DATA = "2098";					//正在更新影院数据
	public static final String CODE_SEAT_LOCK_ERROR = "2099";
	
	public static final String CODE_ORDER_NEED_CANCEL = "3100";		//订单需要取消，才能下单
	public static final String CODE_ORDER_SD_REPEAT = "3101";		//重复参加特价活动
	
	public static final String CODE_PARTNER_NOT_EXISTS = "4001";	//商家不存在
	public static final String CODE_PARTNER_NORIGHTS = "4002";		//商家无权限
	public static final String CODE_SIGN_ERROR = "4003";				//校验错误  
	public static final String CODE_PARAM_ERROR = "4004";				//参数错误：缺少参数或格式不正确  
	public static final String CODE_DATA_ERROR = "4005";				//数据错误：如查询的数据不存在等
	public static final String CODE_PAY_ERROR = "4006";				//支付错误
	public static final String CODE_SECURITY_VERIFY = "4999";		//手机短信进行安全认证
	
	public static final String CODE_SUBSCRIBE_ERROR = "4040";		//预约保存失败
	
	public static final String CODE_WEIBO_EXPRIES = "4100"; 			//微博过期
	public static final String CODE_UNBIND_MOBILE = "4101"; 			//没有绑定手机
	
	public static final String CODE_MEMBER_NOT_EXISTS = "5000";		//用户不存在
	public static final String CODE_NOTLOGIN = "5001";					//用户未登录
	public static final String CODE_USER_NORIGHTS = "5002";			//用户无权限
	public static final String CODE_REPEAT_OPERATION = "5003";		//不能重复操作
	public static final String CODE_NOT_EXISTS = "5004";
	public static final String CODE_DATA_NULL = "5005"; 				//数据为空
	//public static final String CODE_ERROR = "5006"; //异常

	
	public static final String CODE_TRAFFIC_CONTROL = "6000";	//被流量控制
	public static final String CODE_PAYPASS_ERROR = "6001";		//支付密码过于简单
	
	public static final String CODE_ELECARD_ISBIND = "8001";		// 券已经被绑定
	public static final String CODE_NIDE_BINDMOBILE = "8100";	// 需要绑定手机号
	public static final String CODE_MOBILE_NOTREG = "8101";		// 手机号未注册
	

	public static final String CODE_UNKNOWN_ERROR = "9999";
	
	public static final String CODE_GETED_POINT_STABLE_ERROR   = "9001";//红包已经领取过-稳赚型
	public static final String CODE_GETED_POINT_BIT_ERROR      = "9002";//红包已经领取过-冒险型
	public static final String CODE_GETED_POINT_BRT_ERROR      = "9003";//红包已经领取过-微博控
	public static final String CODE_GETED_POINT_FESTIVAL_ERROR = "9004";//红包已经领取过-节日

	public static final String CODE_MOBILE_VALID = "9900";// APP需要跳转到H5进行验证的code
	
	public static final String CODE_FCARD_ERROR = "9101";// 点卡支付与优惠互斥
	public static final String CODE_FCARD_CHANGE_ERROR = "9102";// 点卡支付不同卡重复使用
	public static final String CODE_FCARD_USE_ERROR = "9103";// 点卡正在使用
	public static final String CODE_FCARD_USEOUT = "9104";// 点卡余额不足
	
	public static final String CODE_FCARD_LOCK = "9201";//点卡已锁定
	public static final String CODE_FCARD_LOCK_FAIL = "9202";//点卡锁定失败
	public static final String CODE_FCARD_LOCK_NOT_MATCH="9203";//锁卡信息不匹配
	public static final String CODE_FCARD_NOT_LOCK="9204";//点卡未锁定
	
	public static final Map<String, String> ORDER_STATUS_MAP;
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(OrderConstant.STATUS_NEW, "new");
		tmp.put(OrderConstant.STATUS_NEW_UNLOCK, "new");
		tmp.put(OrderConstant.STATUS_NEW_CONFIRM, "new");
		tmp.put(OrderConstant.STATUS_PAID, "paid");
		tmp.put(OrderConstant.STATUS_PAID_FAILURE, "paid");
		tmp.put(OrderConstant.STATUS_PAID_UNFIX, "paid");
		tmp.put(OrderConstant.STATUS_PAID_SUCCESS, "success");
		tmp.put(OrderConstant.STATUS_PAID_RETURN, "refund");
		tmp.put(OrderConstant.STATUS_CANCEL, "cancel");
		tmp.put(OrderConstant.STATUS_SYS_CANCEL,"cancel");
		tmp.put(OrderConstant.STATUS_REPEAT,"repeat");
		tmp.put(OrderConstant.STATUS_USER_CANCEL,"cancel");
		tmp.put(OrderConstant.STATUS_TIMEOUT, "cancel");
		ORDER_STATUS_MAP = UnmodifiableMap.decorate(tmp);
	}
	public static Map<String, String> getOrderStatusMap(){
		return ORDER_STATUS_MAP;
	}
	public static String getMappedOrderStatus(String status){
		return ORDER_STATUS_MAP.get(status);
	}
	
}
