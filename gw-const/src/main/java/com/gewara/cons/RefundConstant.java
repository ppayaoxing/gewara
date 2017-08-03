package com.gewara.cons;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class RefundConstant {
	//public static final String STATUS_PREPAIR1 = "prepare"; 	//预处理
	public static final String STATUS_APPLY = "apply"; 		//申请
	public static final String STATUS_ACCEPT = "accept"; 	//接受
	public static final String STATUS_REJECT = "reject"; 	//拒绝退款
	public static final String STATUS_SUCCESS = "success";	//退款成功
	public static final String STATUS_FINISHED = "finish";	//处理结束
	public static final String STATUS_USER_APPLY = "user_apply";			// 用户申请退票
	public static final String STATUS_USER_REJECT = "user_reject"; 			// 用户取票拒绝退款
	//public static final String STATUS_CANCEL = "cancel";	//取消退款(prepair-->cancel)
	
	//需要执行的操作
	public static final String OP_CANCEL_TICKET = "cancelTicket";	//退票
	public static final String OP_ADJUST_SETTLE = "adjustSettle";	//结算调整
	public static final String OP_COMPENSATE = "compensate";		//补偿用户操作
	public static final String OP_RET2PARTNER = "ret2Partner";		//合作商家退款
	public static final String OP_LOCK_TICKET = "lockTicket";		//锁定订单
	
	public static final String OP_RESULT_CANCEL_SUCCESS = "cancelSuccess"; //退票成功
	public static final String OP_RESULT_CANCEL_FAILURE = "cancelFailure"; //退票失败
	
	//退款类型 all 全额退款：part 部分退款：supplement 增补
	public static final String REFUNDTYPE_FULL = "full";			//全额退款
	public static final String REFUNDTYPE_PART = "part";			//部分退款
	public static final String REFUNDTYPE_SUPPLEMENT = "supplement";//调价退款
	public static final String REFUNDTYPE_GEWARA = "gewara";		//格瓦拉退款
	
	// 订单锁定状态 
	public static final String LOCK_SUCCESS = "lock_success";		// 锁定成功
	public static final String LOCK_TAKE = "lock_take";				// 已取票
	public static final String LOCK_FAILURE = "lock_failure";		// 锁定失败
	// 解锁订单状态
	public static final String UN_LOCK_Y = "Y";		// 解锁成功
	public static final String UN_LOCK_N = "N";		// 解锁失败
	
	//退款原因
	public static final String REASON_UNKNOWN = "unknown";				//未知
	public static final String REASON_USER = "user";					//用户退款
	public static final String REASON_GEWA = "gewa";					//Gewa退款
	public static final String REASON_GEWA_SYS = "gewa_sys";			//Gewa系统错误
	public static final String REASON_MERCHANT = "merchant";			//商家（影院）退款
	public static final String REASON_MERCHANT_OPI = "merchant_opi";	//商家（影院）场次(更改或取消)退款
	public static final String REASON_PRICE = "price";					//价格调整
	public static final String REASON_CANCELTICKET = "cancelTicket";	//可退票场馆正常退票
	public static final String REASON_BAOCHANG = "baochang_fail";	//包场失败退款
	
	public static final int COUNT_MONTH_MEMBER = 3;			// 用户月退票次数
	public static final int COUNT_WEEK_MEMBER = 2;			// 用户周退票次数
	public static final int COUNT_MONTH_CINEMA = 400;		// 影院月退票次数
	public static final int COUNT_DAY_CINEMA = 30;			// 影院日退票次数
	
	//账户退款 Y：需要，N：不需要，O：未知, 参见描述(Other)，S: 已提交账务(Submit) R：财务已经返还(Refund)，F：财务返还出错(Failure)
	public static final String RETBACK_Y = "Y";
	public static final String RETBACK_N = "N";
	public static final String RETBACK_OTHER = "O";
	public static final String RETBACK_SUBMIT = "S";
	public static final String RETBACK_REFUND = "R";
	public static final String RETBACK_FAILURE = "F";
	
	//处理人
	public static final String REFUND_MANAGE_DEAL = "manageDeal";
	public static final String REFUND_FINANCE_DEAL = "financeDeal";
	public static final String REFUND_FINANCE_STATUS = "status";
	public static final String REFUND_FINANCE_RESON = "reson";
	
	public static final String TR_NORMAL_REFUND = "Y_NORMAL_R";			//正常退票不结算
	public static final String TR_MERCHANT_REFUND = "Y_MERCHANT_R";		//场馆已退票不结算
	public static final String TR_MERCHANT_NO = "Y_MERCHANT_N";			//场馆未退票不结算
	public static final String TR_SETTLE_MERCHANT_NO = "S_MERCHANT_N";	//场馆未退票需结算
	public static final String TR_SETTLE_GEWA_REFUND = "S_GEWA_R";		//格瓦拉单方退款
	
	// 退款订单来源
	public static final String ORIGIN_USER ="USER";			// 用户主动申请
	public static final String ORIGIN_KF = "KF";			// 客服申请
	
	// 客户端类型
	public static final String CLIENTTYPE_PC = "pc";		// pc
	public static final String CLIENTTYPE_WAP = "wap";		// wap
	public static final String CLIENTTYPE_APP = "app";		// app
	public static final String ClIENTTYPE_API = "api";      // api
	
	// 支持API退款的网关代码
	public static final String REFUND_API_METHOD_ALISCANPAY ="aliScanPay";			     // 支付宝扫码支付
	public static final String REFUND_API_METHOD_ALISMARTMOBILEPAY ="aliSmartMobilePay"; // 支付宝手机端-安全支付
	public static final String REFUND_API_METHOD_ALIWAPPAY ="aliwapPay";			     // 支付宝手机端-WAP支付
	public static final String REFUND_API_METHOD_DIRECTPAY ="directPay";			     // 支付宝PC端

	// 农行退款标识
	public static final String ABC_OTHERINFO_AMOUNT ="amount";			     // 金额
	public static final String ABC_OTHERINFO_POINT ="point";			     // 积分
	
	public static final Map<String, String> textMap;
	public static final Map<String, String> refundTypeMap;
	public static final Map<String, String> reasonTypeMap;
	public static final Map<String, String> supplementReasonMap;
	public static final Map<String, String> retbackMap;
	public static final Map<String, String> ticketRefundTextMap;
	public static final Map<String, String> refundApiPayMethodMap;
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(STATUS_APPLY, "新申请");
		tmp.put(STATUS_REJECT, "不接收退款");
		tmp.put(STATUS_SUCCESS, "退款成功");
		textMap = UnmodifiableMap.decorate(tmp);
		
		Map<String, String> tmpRefund = new HashMap<String, String>();
		tmpRefund.put(REFUNDTYPE_FULL, "全额退款");
		tmpRefund.put(REFUNDTYPE_PART, "部分退款");
		tmpRefund.put(REFUNDTYPE_SUPPLEMENT, "调价退款");
		tmpRefund.put(REFUNDTYPE_GEWARA, "格瓦拉退款");
		refundTypeMap = UnmodifiableMap.decorate(tmpRefund);
		
		Map<String, String> tmpReason = new LinkedHashMap<String, String>();
		tmpReason.put(REASON_CANCELTICKET, "可退票场馆正常退票");
		tmpReason.put(REASON_USER, "用户原因要求退款");
		tmpReason.put(REASON_MERCHANT, "场馆放映中故障退票");
		tmpReason.put(REASON_MERCHANT_OPI, "场馆通知场次更改或取票退票");
		tmpReason.put(REASON_PRICE, "场馆通知价格调整");
		tmpReason.put(REASON_GEWA, "Gewa场次设置错误");
		tmpReason.put(REASON_GEWA_SYS, "Gewa系统错误");
		tmpReason.put(REASON_BAOCHANG, "包场失败退款");
		tmpReason.put(REASON_UNKNOWN, "其它原因");
		reasonTypeMap = UnmodifiableMap.decorate(tmpReason);
		
		Map<String, String> tmpSupplementMap = new LinkedHashMap<String, String>();
		tmpSupplementMap.put(REASON_PRICE, "场馆通知价格调整");
		tmpSupplementMap.put(REASON_GEWA, "Gewa场次设置错误");
		supplementReasonMap = UnmodifiableMap.decorate(tmpSupplementMap);
		
		Map<String, String> tmpRetack = new LinkedHashMap<String, String>();
		tmpRetack.put(RETBACK_Y, "需要");
		tmpRetack.put(RETBACK_N, "不需要");
		tmpRetack.put(RETBACK_OTHER, "参见描述");
		tmpRetack.put(RETBACK_SUBMIT, "已提交财务");
		tmpRetack.put(RETBACK_REFUND, "财务成功");
		tmpRetack.put(RETBACK_FAILURE, "财务失败");
		retbackMap = UnmodifiableMap.decorate(tmpRetack);
		
		Map<String, String> settleTmpMap = new LinkedHashMap<String, String>();
		settleTmpMap.put(TR_NORMAL_REFUND, "正常退票不结算");
		settleTmpMap.put(TR_MERCHANT_REFUND, "影院已退票不结算");
		settleTmpMap.put(TR_MERCHANT_NO, "影院未退票不结算");
		settleTmpMap.put(TR_SETTLE_MERCHANT_NO, "影院未退票需结算");
		settleTmpMap.put(TR_SETTLE_GEWA_REFUND, "格瓦拉单方退票");
		ticketRefundTextMap = UnmodifiableMap.decorate(settleTmpMap);
		
		Map<String, String> payMethodMap = new HashMap<String, String>();
		payMethodMap.put(REFUND_API_METHOD_ALISCANPAY, "支付宝扫码支付");
		payMethodMap.put(REFUND_API_METHOD_ALISMARTMOBILEPAY, "支付宝手机端-安全支付");
		payMethodMap.put(REFUND_API_METHOD_ALIWAPPAY, "支付宝手机端-WAP支付");
		payMethodMap.put(REFUND_API_METHOD_DIRECTPAY, "支付宝PC端");
		refundApiPayMethodMap = UnmodifiableMap.decorate(payMethodMap);
	}
}
