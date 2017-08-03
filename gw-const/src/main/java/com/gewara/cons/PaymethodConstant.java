package com.gewara.cons;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;

public abstract class PaymethodConstant implements Serializable {
	private static final long serialVersionUID = -8289964065497333210L;
	public static final String PAYMETHOD_UNKNOWN = "unknown";						//未知（用户未选择）
	//格瓦拉
	public static final String PAYMETHOD_GEWAPAY = "gewaPay";						//用户余额
	public static final String PAYMETHOD_FCARDPAY = "fcardPay";						//点卡支付
	public static final String PAYMETHOD_SYSPAY = "sysPay";							//系统用户
	public static final String PAYMETHOD_ELECARDPAY = "elecardPay";					//全部使用券
	public static final String PAYMETHOD_GEWARA_OFFLINEPAY = "offlinePay";			//后台线下支付
	//充值
	public static final String PAYMETHOD_CHARGECARD = "ccardPay";					//充值卡，只用来充值
	public static final String PAYMETHOD_LAKALA = "lakalaPay";						//拉卡拉 ，只用来充值
	public static final String PAYMETHOD_ABCBANKPAY = "abcPay";						//农行合作充值，只用来充值
	public static final String PAYMETHOD_WCANPAY = "wcanPay";						//微能科技合作充值，只用来充值
	//支付----合作伙伴
	public static final String PAYMETHOD_PARTNERPAY = "partnerPay";					//合作伙伴
	public static final String PAYMETHOD_OKCARDPAY = "okcardPay";					//联华OK卡
	public static final String PAYMETHOD_SPSDOPAY1 = "spsdoPay";					//盛大即时到账支付
	//支付----第三方
	public static final String PAYMETHOD_ALIPAY = "directPay";						//支付宝PC端
	public static final String PAYMETHOD_PNRPAY = "pnrPay";							//汇付天下PC端
	public static final String PAYMETHOD_CMPAY = "cmPay";							//移动手机支付PC端
	public static final String PAYMETHOD_TEMPUSPAY = "tempusPay";					//腾付通PC端
	public static final String PAYMETHOD_SPSDOPAY2 = "spsdo2Pay";					//盛付通PC端
	public static final String PAYMETHOD_CHINAPAY1 = "chinaPay";					//银联
	public static final String PAYMETHOD_CHINAPAY2 = "china2Pay";					//ChinapayPC端
	public static final String PAYMETHOD_CHINAPAYSRCB = "srcbPay";					//Chinapay农商行--->50000547
	
	public static final String PAYMETHOD_UNIONPAY = "unionPay";						//unionPay
	

	public static final String PAYMETHOD_UNIONPAY_JS = "unionPay_js";				//Unionpay江苏PC端
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY = "unionPay_activity";	//unionPay活动
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY_JS = "unionPay_activity_js";//unionPay江苏活动
	public static final String PAYMETHOD_UNIONPAY_ZJ = "unionPay_zj";		//浙江地区专用
	public static final String PAYMETHOD_UNIONPAY_SZ = "unionPay_sz";		//深圳地区专用
	public static final String PAYMETHOD_UNIONPAY_BJ = "unionPay_bj";		//北京地区专用
	public static final String PAYMETHOD_UNIONPAY_GZ = "unionPay_gz";		//广州地区专用

	
	public static final String PAYMETHOD_UNIONPAYFAST = "unionPayFast";				//unionPay V2.0.0 版本支付
	/**
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS = "unionPayFast_activity_js";//unionPay version 2.0.0版本 unionPay江苏活动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ = "unionPayFast_activity_bj";//unionPay version 2.0.0版本 unionPay北京活动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ = "unionPayFast_activity_sz";//unionPay version 2.0.0版本深圳地区活动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ = "unionPayFast_activity_gz";//unionPay version 2.0.0版本广州地区活动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ = "unionPayFast_activity_zj";//unionPay version 2.0.0版本浙江地区活动
	*/
	
	//支付----直连
	public static final String PAYMETHOD_BCPAY = "bcPay";							//交行直连PC端
	public static final String PAYMETHOD_SPDPAY = "spdPay";							//浦发直连PC端
	public static final String PAYMETHOD_CMBPAY = "cmbPay";							//招行直连PC端
	public static final String PAYMETHOD_GDBPAY = "gdbPay";							//广发直连PC端
	public static final String PAYMETHOD_GDB_UNION_PAY = "gdbUnionPay";  		    //广发直连PC端(银联)
	public static final String PAYMETHOD_PSBCPAY = "psbcPay";						//邮储直连PC端
	public static final String PAYMETHOD_HZBANKPAY = "hzbankPay";					//杭州银行直连
	//public static final String PAYMETHOD_CCBPOSPAY = "ccbposPay";					//建行直连PC端-信用卡
	public static final String PAYMETHOD_JSBCHINA = "jsbChina";						//江苏银行直连PC端-信用卡
	public static final String PAYMETHOD_SPDPAY_ACTIVITY = "spdPay_activity";		//浦发直连PC端-活动
	public static final String PAYMETHOD_BOCPAY = "bocPay";							//中国银行直连PC端
	public static final String PAYMETHOD_BOCWAPPAY = "bocWapPay";					//中国银行直连WAP端
	public static final String PAYMETHOD_BOCAGRMTPAY = "bocAgrmtPay";				//中国银行协议支付
	//支付----话费
	public static final String PAYMETHOD_UMPAY = "umPay";							//移动话费支付(联动优势)
	public static final String PAYMETHOD_UMPAY_SH = "umPay_sh";						//移动话费支付(联动优势) 上海地区
	public static final String PAYMETHOD_TELECOM= "telecomPay";						//电信固话话费支付，包括充值
	public static final String PAYMETHOD_MOBILE_TELECOM= "telecomMobilePay";		//电信手机话费支付
	//支付----行业卡
	public static final String PAYMETHOD_YAGAO = "yagaoPay";						//雅高
	public static final String PAYMETHOD_ONETOWN = "onetownPay";					//一城卡支付(新华传媒)
	//支付----手机端（直连 + 第三方）
	public static final String PAYMETHOD_ALIWAPPAY = "aliwapPay";					//支付宝手机端-WAP支付
	public static final String PAYMETHOD_CMWAPPAY = "cmwapPay";						//移动手机支付手机端-WAP支付
	public static final String PAYMETHOD_CMBWAPPAY = "cmbwapPay";					//招行直连手机端
	public static final String PAYMETHOD_CMBWAPSTOREPAY = "cmbwapStorePay";			//招行直连手机端CMSTORE
	public static final String PAYMETHOD_SPDWAPPAY = "spdWapPay";					//浦发直连手机端-WAP
	public static final String PAYMETHOD_CMSMARTPAY = "cmSmartPay";					//移动手机支付安卓版
	public static final String PAYMETHOD_SPDWAPPAY_ACTIVITY = "spdWapPay_activity";	//浦发直连手机端-活动
	public static final String PAYMETHOD_CHINASMARTMOBILEPAY = "chinaSmartMobilePay";//银联智能手机支付
	public static final String PAYMETHOD_CHINASMARTJSPAY = "chinaSmartJsPay";		//银联智能手机支付-江苏
	public static final String PAYMETHOD_ALISMARTMOBILEPAY = "aliSmartMobilePay";	//支付宝手机端-安全支付
	public static final String PAYMETHOD_HZWAPPAY = "hzwapPay";						//杭州银行WAP
	public static final String PAYMETHOD_YEEPAY = "yeePay";       					//易宝支付
	public static final String PAYMETHOD_PAYECO_DNA = "payecoDNAPay";       		// 易联DNA支付
	public static final String PAYMETHOD_MEMBERCARDPAY = "memberCardPay";       	// 会员卡支付
	public static final String PAYMETHOD_ICBCPAY = "icbcPay";       // 工商银行直连支付PC端
	public static final String PAYMETHOD_NJCBPAY = "njcbPay";       // 南京银行直连支付PC端
	public static final String PAYMETHOD_ABCHINAPAY = "abchinaPay";       // 农业银行直连支付PC端
	
	public static final String PAYMETHOD_WXAPPTENPAY = "wxAppTenPay";       //财付通微信支付（App间支付）
	public static final String PAYMETHOD_WXAPPPAY = "wxAppPay";				//财付通微信支付（App间支付）
	public static final String PAYMETHOD_WXMPNOPAY = "wxMPNoPay";				//微信公众号支付
	public static final String PAYMETHOD_WXSCANTENPAY = "wxScanTenPay";       //财付通微信支付（WEB扫码）
	public static final String PAYMETHOD_WXWCPAY = "wxWCPay";				//微信公众号支付
	public static final String PAYMETHOD_CCBWAPPAY = "ccbWapPay";	//建行手机wap支付
	public static final String PAYMETHOD_ONECLICKTENPAY = "oneClickTenPay";	//财付通移动终端一键支付
	public static final String PAYMETHOD_BESTPAY = "bestPay";	//翼支付
	public static final String PAYMETHOD_BFBWAPPAY = "bfbWapPay";	//百度钱包wap支付
	public static final String PAYMETHOD_BFBPAY = "bfbPay";		//百度钱包支付
	public static final String PAYMETHOD_ALISCANPAY = "aliScanPay";		//支付宝扫码支付
	public static final String PAYMETHOD_CCBMBCPAY = "ccbMBCPay";		//建行手机银行支付
	public static final String PAYMETHOD_BCWAPPAY = "bcWapPay";//交行Wap支付	

	public static final String PAYMETHOD_BOCWAPV2PAY = "bocWapV2Pay";//中国银行直连WAP支付（V2）
	public static final String PAYMETHOD_UNIONWAPPAYFAST = "unionWapPayFast";//银联无卡WAP支付
	
	public static final String PAYMETHOD_ICBCWAPPAY = "icbcWapPay";//工商银行直连WAP支付
	
	public static final String PAYMETHOD_ALITVPAY = "aliTvPay";//阿里tv支付
	
	public static final String PAYMETHOD_WEIBOPAY = "weiboPay";//微博支付
	
	public static final String PAYMETHOD_PINGAN1QBPAY = "pingan1qbPay";//平安壹钱包支付

	public static final String PAYMETHOD_CHUBAOPAY = "chubaoPay";					//触宝支付
	public static final String PAYMETHOD_BJRCBPAY = "bjrcbPay";						//北京农商支付
	public static final String PAYMETHOD_ABCPAYFAST = "abcPayFast";					//农业银行快捷支付
	public static final String PAYMETHOD_ABCWAPPAYFAST = "abcWapPayFast";			//农业WAP支付
	public static final String PAYMETHOD_ABCPOINTPAYFAST = "abcPointPayFast";		//农业积分支付
	public static final String PAYMETHOD_HUAANPAY = "huaanPay";						//华安PC支付
	public static final String PAYMETHOD_HUAANWAPPAY = "huaanWapPay";				//华安WAP支付
	
	public static final String PAYMETHOD_ALIAPPPAY = "aliAppPay";				//支付宝App支付
	public static final String PAYMETHOD_PAYECOEPAY = "payecoEPay";				//易联手机wap支付

	public static final String PAYMETHOD_UNIONAPPPAY = "unionAppPay";			//银联手机APP支付
	public static final String PAYMETHOD_APPLEPAY = "applePay";					//苹果支付支付，其实就是unionAppPay支付
	public static final String PAYMETHOD_UNIONWAPPAY = "unionWapPay";			//银联手机WAP支付
	public static final String PAYMETHOD_QQAPPPAY = "qqAppPay";					//QQ钱包支付
	public static final String PAYMETHOD_QQTENSCANPAY = "qqTenScanPay";			//QQ扫码支付
	
	public static final String PAYMETHOD_SPDCCCPAY = "spdcccPay";				//浦发信用卡PC支付
	public static final String PAYMETHOD_SPDCCCWAPPAY = "spdcccWapPay";			//浦发信用卡WAP支付
	public static final String PAYMETHOD_CCBAPPPAY = "ccbAppPay";				//建设银行APP支付
	public static final String PAYMETHOD_CBHBPAY = "cbhbPay";					//渤海支付
	public static final String PAYMETHOD_CBHBWAPPAY = "cbhbWapPay";				//渤海WAP支付
	public static final String PAYMETHOD_SFAPPPAY = "sfAppPay";					//顺丰APP支付
	public static final String PAYMETHOD_WLTWAPPAY = "wltWapPay";				//万里通WAP支付
	public static final String PAYMETHOD_YLCFWAPPAY = "ylcfWapPay";				//一路财富WAP支付
	public static final String PAYMETHOD_JDWAPPAY = "jdWapPay";					//京东WAP支付
	public static final String PAYMETHOD_JDPAY = "jdPay";					//京东PC支付
	public static final String PAYMETHOD_CCBWAPSECDPAY = "ccbWapSecdPay";		//建行账号支付
	
	public static final String PAYMETHOD_BOCWAPPAYFAST = "bocWapPayFast";	   //中国银行wap快捷支付
	public static final String PAYMETHOD_FC99BILLPAY = "foreignCard99billPay";	//快钱外卡支付
	public static final String PAYMETHOD_GZRCBPAY = "gzrcbPay";					//广州农商支付
	public static final String PAYMETHOD_GZRCBWAPPAY = "gzrcbWapPay";			//广州农商Wap支付
	public static final String PAYMETHOD_CHINATELEAPPPAY = "chinaTeleAppPay";	//电信翼支付
	public static final String PAYMETHOD_CHINATELEWAPPAY = "chinaTeleWapPay";	//电信翼支付
	public static final String PAYMETHOD_SUNINGWAPPAY = "suningWapPay";			//苏宁易付宝支付
	public static final String PAYMETHOD_INTELWAPPAY = "intelWapPay";			//Intel集分宝支付
	public static final String PAYMETHOD_SPDCCCB2CPAY = "spdcccB2cPay";			//浦发B2C信用卡支付
	public static final String PAYMETHOD_SPDCCCB2CWAPPAY = "spdcccB2cWapPay";	//浦发B2C信用卡WAP支付
	
	public static final String PAYMETHOD_FQLPAY = "fqlPay";			//分期乐支付PC端
	public static final String PAYMETHOD_FQLWAPPAY = "fqlWapPay";	//分期乐Wap支付
	
	public static final String PAYMETHOD_BOSPAY = "bosPay";//上海银行B2C支付
	
	public static final String PAYMETHOD_BOSWAPPAY = "bosWapPay";//上银快付
	
	public static final String PAYMETHOD_PINGANBANKPAY = "pinganBankPay";//平安银行
	public static final String PAYMETHOD_PINGANBANKWAPPAY = "pinganBankWapPay";//平安银行WAP
	public static final String PAYMETHOD_PAYECOWAPPAY = "payecoWapPay";//易联WAP支付
	public static final String PAYMETHOD_MSQMWAPPAY = "msqmWapPay";//民生齐妙支付
	
	public static final String PAYMETHOD_SPDCCCFASTPAYPAY = "spdcccFastPay";//浦发银行快捷支付
	public static final String PAYMETHOD_BCOMCCFASTPAYPAY = "bcomccFastPay";	//交通银行快捷支付
	public static final String PAYMENTOD_MASAWAPPAY = "masaWapPay";               //外卡支付
	
	//支付----以下支付方式不在使用
	public static final String PAYMETHOD_TENPAY = "tenPay";								//财富通
	//public static final String PAYMETHOD_BCWAPPAY_OLD = "bcwapPay";					//交通WAP银行 
	public static final String PAYMETHOD_ALIBANKPAY = "alibankPay";					//支付宝手机银行
	public static final String PAYMETHOD_HANDWAPPAY = "handwapPay";					//瀚银手机
	public static final String PAYMETHOD_HANDWEBPAY = "handwebPay";					//瀚银手机
	public static final String PAYMETHOD_PNRFASTPAY = "pnrfastPay";					//汇付快捷支付 --华夏银行信用
	public static final String PAYMETHOD_PNRFASTPAY2 = "pnrfastPay2";					//汇付快捷支付2--建设银行信用
	public static final String PAYMETHOD_PNRFASTABCPAY = "pnrfastabcPay";			//汇付快捷支付--农业银行信用卡
	
	public static final String PAYMETHOD_YYPTPAY = "yyptPay";							//钱大掌柜快捷支付
	
	public static final String PAYMENTOD_UNICOMWOPAY = "unicomWoPay";					//联通沃支付	
	public static final String PAYMENTOD_MSFPAY = "msfPay";                             //民生付
	
	/**商户余额支付：现只对合作商户使用，不可以公布在外面**/
	public static final String PAYMETHOD_MERCHANTPAY = "merchantPay";//商户余额支付
	public static final String PAYMENTOD_XIYINPAY="xiyinPay";							//西安银行
	
	public static final String PAYMENTOD_CMBYWTPAY = "cmbywtPay"; //招行一网通
	public static final String PAYMENTOD_WCFWAPPAY = "wcfWapPay";  //微财富
	//已废弃
	//public static final String PAYMETHOD_SDOPAY = "sdoPay";							//盛大积分+现金
	//public static final String PAYMETHOD_IPSPAY= "ipsPay";							//环讯PC端-信用卡支付
	//public static final String PAYMETHOD_HAOBAIPAY = "haobaiPay";					//号百手机端-客户端
	//public static final String PAYMETHOD_ALLINPAY = "allinPay";						//通联支付
	
	public static final List<String> PAYMETHOD_LIST = 
			Arrays.asList(PAYMETHOD_GEWAPAY, PAYMETHOD_FCARDPAY, PAYMETHOD_CHARGECARD, PAYMETHOD_PNRPAY, 
					PAYMETHOD_ALIPAY, PAYMETHOD_ALIWAPPAY, PAYMETHOD_ALIBANKPAY, PAYMETHOD_LAKALA, PAYMETHOD_CCBWAPSECDPAY,
					PAYMETHOD_CHINAPAY1, PAYMETHOD_CHINAPAY2, PAYMETHOD_CHINAPAYSRCB, 
					PAYMETHOD_OKCARDPAY, PAYMETHOD_TENPAY, PAYMETHOD_PARTNERPAY, PAYMETHOD_SPSDOPAY1, PAYMETHOD_SPSDOPAY2, 
					PAYMETHOD_CMPAY, PAYMETHOD_YAGAO, PAYMETHOD_ONETOWN, PAYMETHOD_HANDWEBPAY, 
					PAYMETHOD_HANDWAPPAY, PAYMETHOD_CMBPAY, PAYMETHOD_CMBWAPPAY, PAYMETHOD_BCPAY, 
					PAYMETHOD_GDBPAY, PAYMETHOD_GDB_UNION_PAY, PAYMETHOD_ELECARDPAY, PAYMETHOD_SYSPAY, PAYMETHOD_CMWAPPAY, 
					PAYMETHOD_CHINASMARTMOBILEPAY, PAYMETHOD_CHINASMARTJSPAY, PAYMETHOD_ALISMARTMOBILEPAY, PAYMETHOD_UMPAY,PAYMETHOD_UMPAY_SH, 
					PAYMETHOD_SPDPAY, PAYMETHOD_SPDPAY_ACTIVITY,PAYMETHOD_PSBCPAY, PAYMETHOD_SPDWAPPAY, PAYMETHOD_SPDWAPPAY_ACTIVITY, PAYMETHOD_HZBANKPAY, PAYMETHOD_ABCBANKPAY, 
					PAYMETHOD_WCANPAY,PAYMETHOD_UNIONPAY,PAYMETHOD_TELECOM,PAYMETHOD_MOBILE_TELECOM,
					PAYMETHOD_JSBCHINA, PAYMETHOD_TEMPUSPAY, PAYMETHOD_PNRFASTPAY,PAYMETHOD_PNRFASTPAY2,PAYMETHOD_YEEPAY,
					PAYMETHOD_CMSMARTPAY, PAYMETHOD_PNRFASTABCPAY,PAYMETHOD_UNIONPAYFAST,
					PAYMETHOD_BOCPAY,PAYMETHOD_BOCWAPPAY,PAYMETHOD_BOCAGRMTPAY, PAYMETHOD_HZWAPPAY, PAYMETHOD_PAYECO_DNA, PAYMETHOD_MEMBERCARDPAY, 
					PAYMETHOD_ICBCPAY, PAYMETHOD_CMBWAPSTOREPAY,PAYMETHOD_NJCBPAY,PAYMETHOD_ABCHINAPAY,PAYMETHOD_WXAPPTENPAY,PAYMETHOD_WXAPPPAY,PAYMETHOD_WXSCANTENPAY,
					PAYMETHOD_CCBWAPPAY, PAYMETHOD_WXWCPAY, PAYMETHOD_ONECLICKTENPAY, PAYMETHOD_BESTPAY, PAYMETHOD_BFBWAPPAY, PAYMETHOD_GEWARA_OFFLINEPAY, PAYMETHOD_BFBPAY,PAYMETHOD_ALISCANPAY,PAYMETHOD_CCBMBCPAY,PAYMETHOD_BCWAPPAY
					,PAYMETHOD_BOCWAPV2PAY,PAYMETHOD_UNIONWAPPAYFAST, PAYMETHOD_ICBCWAPPAY, PAYMETHOD_ALITVPAY, PAYMETHOD_WEIBOPAY, PAYMETHOD_PINGAN1QBPAY, PAYMETHOD_CHUBAOPAY, PAYMETHOD_BJRCBPAY, PAYMETHOD_ABCPAYFAST,PAYMETHOD_ABCPOINTPAYFAST,
					PAYMETHOD_HUAANPAY,PAYMETHOD_HUAANWAPPAY,PAYMETHOD_ALIAPPPAY,PAYMETHOD_PAYECOEPAY,PAYMETHOD_WXMPNOPAY,PAYMETHOD_UNIONAPPPAY,PAYMETHOD_UNIONWAPPAY,PAYMETHOD_QQAPPPAY,PAYMETHOD_QQTENSCANPAY,PAYMETHOD_SPDCCCPAY,PAYMETHOD_SPDCCCWAPPAY,
					PAYMETHOD_CCBAPPPAY,PAYMETHOD_CBHBPAY,PAYMETHOD_CBHBWAPPAY,PAYMETHOD_ABCWAPPAYFAST,PAYMETHOD_SFAPPPAY,PAYMETHOD_WLTWAPPAY,PAYMETHOD_YLCFWAPPAY,PAYMETHOD_JDWAPPAY,PAYMETHOD_JDPAY,PAYMETHOD_BOCWAPPAYFAST,PAYMETHOD_FC99BILLPAY,
					PAYMETHOD_GZRCBPAY,PAYMETHOD_GZRCBWAPPAY,PAYMETHOD_CHINATELEAPPPAY,PAYMETHOD_SUNINGWAPPAY,PAYMETHOD_INTELWAPPAY,PAYMETHOD_SPDCCCB2CPAY,PAYMETHOD_SPDCCCB2CWAPPAY,PAYMETHOD_FQLPAY,PAYMETHOD_FQLWAPPAY,PAYMETHOD_BOSPAY,PAYMETHOD_BOSWAPPAY,
					PAYMETHOD_PINGANBANKPAY,PAYMETHOD_PINGANBANKWAPPAY,PAYMETHOD_PAYECOWAPPAY,PAYMETHOD_CHINATELEWAPPAY, PAYMETHOD_APPLEPAY, PAYMETHOD_MSQMWAPPAY,
					PAYMETHOD_SPDCCCFASTPAYPAY,PAYMETHOD_BCOMCCFASTPAYPAY,PAYMETHOD_YYPTPAY,PAYMENTOD_UNICOMWOPAY,PAYMENTOD_MSFPAY,PAYMENTOD_XIYINPAY,PAYMENTOD_MASAWAPPAY,PAYMENTOD_CMBYWTPAY,PAYMENTOD_WCFWAPPAY);
	/*废弃:PAYMETHOD_HAOBAIPAY, PAYMETHOD_IPSPAY, PAYMETHOD_SDOPAY, PAYMETHOD_ALLINPAY, PAYMETHOD_BCWAPPAY_OLD, */
		
	public static final List<String> MOBILE_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_ALIWAPPAY, PAYMETHOD_CMWAPPAY, PAYMETHOD_CMBWAPPAY, PAYMETHOD_CMBWAPSTOREPAY, PAYMETHOD_SPDWAPPAY, 
			PAYMETHOD_CMSMARTPAY, PAYMETHOD_SPDWAPPAY_ACTIVITY, PAYMETHOD_CHINASMARTMOBILEPAY, PAYMETHOD_CHINASMARTJSPAY, PAYMETHOD_BOCWAPPAY, PAYMETHOD_FCARDPAY,
			PAYMETHOD_ALISMARTMOBILEPAY, PAYMETHOD_HZWAPPAY ,PAYMETHOD_WXAPPTENPAY, PAYMETHOD_CCBWAPPAY, PAYMETHOD_WXWCPAY, PAYMETHOD_ONECLICKTENPAY, PAYMETHOD_BFBWAPPAY,PAYMETHOD_CCBMBCPAY,PAYMETHOD_BCWAPPAY
			,PAYMETHOD_BOCWAPV2PAY,PAYMETHOD_UNIONWAPPAYFAST, PAYMETHOD_ICBCWAPPAY, PAYMETHOD_ALITVPAY, PAYMETHOD_WEIBOPAY, PAYMETHOD_PINGAN1QBPAY, PAYMETHOD_CHUBAOPAY, PAYMETHOD_HUAANWAPPAY, PAYMETHOD_ALIAPPPAY,
			PAYMETHOD_PAYECOEPAY,PAYMETHOD_WXMPNOPAY,PAYMETHOD_UNIONAPPPAY,PAYMETHOD_UNIONWAPPAY,PAYMETHOD_QQAPPPAY,PAYMETHOD_SPDCCCWAPPAY,PAYMETHOD_CCBAPPPAY,PAYMETHOD_CBHBPAY,PAYMETHOD_CBHBWAPPAY,PAYMETHOD_ABCWAPPAYFAST,PAYMETHOD_ABCPAYFAST,PAYMETHOD_YLCFWAPPAY,
			PAYMETHOD_SFAPPPAY,PAYMETHOD_WLTWAPPAY,PAYMETHOD_ABCHINAPAY,PAYMETHOD_JDWAPPAY,PAYMETHOD_CCBWAPSECDPAY,PAYMETHOD_BOCWAPPAYFAST,PAYMETHOD_GZRCBWAPPAY,PAYMETHOD_CHINATELEAPPPAY,PAYMETHOD_SUNINGWAPPAY,PAYMETHOD_INTELWAPPAY,PAYMETHOD_SPDCCCB2CWAPPAY,PAYMETHOD_FQLWAPPAY,PAYMETHOD_BOSWAPPAY,
			PAYMETHOD_PINGANBANKWAPPAY,PAYMETHOD_PAYECOWAPPAY,PAYMETHOD_CHINATELEWAPPAY, PAYMETHOD_APPLEPAY, PAYMETHOD_MSQMWAPPAY,PAYMETHOD_SPDCCCFASTPAYPAY,PAYMETHOD_YYPTPAY,PAYMENTOD_UNICOMWOPAY,PAYMENTOD_MSFPAY,PAYMENTOD_XIYINPAY,PAYMENTOD_MASAWAPPAY,PAYMENTOD_CMBYWTPAY,PAYMENTOD_WCFWAPPAY);
	
	//合作商支付方式，判断退款后不能换座用。
	public static final List<String> PARTNER_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_PARTNERPAY, PAYMETHOD_OKCARDPAY, PAYMETHOD_SPSDOPAY1);
	private static Map<String, String> payTextMap;	
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(PAYMETHOD_SYSPAY, "系统");
		tmp.put(PAYMETHOD_GEWAPAY, "格瓦余额");
		tmp.put(PAYMETHOD_FCARDPAY, "点卡支付");
		tmp.put(PAYMETHOD_ELECARDPAY, "电子券");
		tmp.put(PAYMETHOD_GEWARA_OFFLINEPAY, "后台下线支付");
		tmp.put(PAYMETHOD_CHARGECARD, "格瓦充值卡");
		tmp.put(PAYMETHOD_LAKALA, "拉卡拉");
		tmp.put(PAYMETHOD_ABCBANKPAY,"农行合作");
		tmp.put(PAYMETHOD_WCANPAY,"微能科技积分兑换");
		
		tmp.put(PAYMETHOD_PNRPAY, "汇付天下PC端");
		tmp.put(PAYMETHOD_ALIPAY, "支付宝PC端");
		tmp.put(PAYMETHOD_CMPAY, "移动手机支付PC端");
		tmp.put(PAYMETHOD_CHINAPAY1, "银联便民");
		tmp.put(PAYMETHOD_CHINAPAY2, "ChinapayPC端");
		tmp.put(PAYMETHOD_SPSDOPAY2, "盛付通PC端");
		tmp.put(PAYMETHOD_PAYECO_DNA, "易联DNA支付");
		
		tmp.put(PAYMETHOD_CMBPAY, "招行直连PC端");
		tmp.put(PAYMETHOD_CMBWAPPAY, "招行直连手机端");
		tmp.put(PAYMETHOD_CMBWAPSTOREPAY, "招行手机端-STORE");
		tmp.put(PAYMETHOD_BCPAY, "交行直连PC端");
		tmp.put(PAYMETHOD_GDBPAY, "广发直连PC端");
		tmp.put(PAYMETHOD_GDB_UNION_PAY, "广发银联直连PC端");
		tmp.put(PAYMETHOD_BOCPAY, "中国银行直连PC端");
		tmp.put(PAYMETHOD_BOCAGRMTPAY, "中国银行协议支付");
		tmp.put(PAYMETHOD_SPDPAY, "浦发直连PC端");
		tmp.put(PAYMETHOD_SPDPAY_ACTIVITY, "浦发直连PC端-活动");
		tmp.put(PAYMETHOD_SPDWAPPAY_ACTIVITY, "浦发直连手机端-活动");
		tmp.put(PAYMETHOD_PSBCPAY, "邮储直连PC端");
		tmp.put(PAYMETHOD_HZBANKPAY, "杭州银行");
		tmp.put(PAYMETHOD_HZWAPPAY, "杭州银行WAP");
		tmp.put(PAYMETHOD_JSBCHINA, "江苏银行直连PC端-信用卡");
		tmp.put(PAYMETHOD_TEMPUSPAY, "腾付通PC端");
		tmp.put(PAYMETHOD_YEEPAY, "易宝支付PC端");
		tmp.put(PAYMETHOD_ICBCPAY, "工商银行直连支付PC端");	
		tmp.put(PAYMETHOD_NJCBPAY, "南京银行直连支付PC端");
		tmp.put(PAYMETHOD_ABCHINAPAY, "农业银行直连支付PC端");	
		
		tmp.put(PAYMETHOD_ALIWAPPAY, "支付宝手机端-WAP支付");
		tmp.put(PAYMETHOD_BOCWAPPAY, "中国银行直连WAP端");
		tmp.put(PAYMETHOD_CMWAPPAY, "移动手机支付手机端-WAP支付");
		tmp.put(PAYMETHOD_SPDWAPPAY, "浦发直连手机端-WAP");
		tmp.put(PAYMETHOD_CHINASMARTMOBILEPAY, "银联手机在线支付");
		tmp.put(PAYMETHOD_CHINASMARTJSPAY, "江苏银联手机端-江苏银商收单");
		tmp.put(PAYMETHOD_ALISMARTMOBILEPAY, "支付宝手机端-安全支付");
		tmp.put(PAYMETHOD_CMSMARTPAY, "移动手机支付安卓版");
		
		tmp.put(PAYMETHOD_UNIONPAY, "unionPay银联支付");
		

		tmp.put(PAYMETHOD_UNIONPAY_JS, "unionPay江苏");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY, "unionPay活动");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY_JS, "unionPay江苏活动");
		tmp.put(PAYMETHOD_UNIONPAY_ZJ, "unionPay浙江");
		tmp.put(PAYMETHOD_UNIONPAY_SZ, "unionPay深圳");
		tmp.put(PAYMETHOD_UNIONPAY_BJ, "unionPay北京");
		tmp.put(PAYMETHOD_UNIONPAY_GZ, "unionPay广州");

		
		tmp.put(PAYMETHOD_UNIONPAYFAST, "unionPayFast银联快捷支付");
		/**
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS, "unionPayFast江苏活动");	
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ, "银联认证2.0北京活动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ, "银联认证2.0深圳活动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ, "银联认证2.0广州活动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ, "银联认证2.0浙江");
		*/
		
		
		tmp.put(PAYMETHOD_PNRFASTPAY, "汇付快捷支付--华夏信用卡");
		tmp.put(PAYMETHOD_PNRFASTPAY2, "汇付快捷支付--建行信用卡");
		tmp.put(PAYMETHOD_PNRFASTABCPAY, "汇付快捷支付--农行信用卡");
		
		
		tmp.put(PAYMETHOD_TELECOM, "电信固话话费支付");
		tmp.put(PAYMETHOD_MOBILE_TELECOM, "电信手机话费支付");
		tmp.put(PAYMETHOD_UMPAY, "移动话费支付(联动优势)");
		tmp.put(PAYMETHOD_UMPAY_SH, "移动话费支付(联动优势)_上海");
		tmp.put(PAYMETHOD_YAGAO, "雅高卡支付(艾登瑞德)");
		tmp.put(PAYMETHOD_ONETOWN, "一城卡支付(新华传媒)");
		
		tmp.put(PAYMETHOD_PARTNERPAY, "合作商");
		tmp.put(PAYMETHOD_OKCARDPAY, "联华OK");
		tmp.put(PAYMETHOD_SPSDOPAY1, "盛大合作");
		tmp.put(PAYMETHOD_CHINAPAYSRCB, "Chinapay农商行");
		tmp.put(PAYMETHOD_MEMBERCARDPAY, "会员卡支付");
		
		tmp.put(PAYMETHOD_WXAPPTENPAY, "财付通微信支付（App间支付）");
		tmp.put(PAYMETHOD_WXAPPPAY, "微信客户端支付");
		tmp.put(PAYMETHOD_WXSCANTENPAY, "财付通微信支付（WEB扫码）");
		tmp.put(PAYMETHOD_WXWCPAY, "微信公众号支付");
		tmp.put(PAYMETHOD_WXMPNOPAY, "微信公众号JS支付");
		tmp.put(PAYMETHOD_CCBWAPPAY, "建行手机wap支付");
		tmp.put(PAYMETHOD_ONECLICKTENPAY, "财付通移动终端一键支付");
		tmp.put(PAYMETHOD_BESTPAY, "翼支付");
		tmp.put(PAYMETHOD_BFBWAPPAY, "百度钱包wap支付");
		tmp.put(PAYMETHOD_BFBPAY, "百度钱包支付");
		tmp.put(PAYMETHOD_ALISCANPAY, "支付宝扫码支付");
		tmp.put(PAYMETHOD_CCBMBCPAY, "建行手机银行支付");
		tmp.put(PAYMETHOD_BCWAPPAY, "交行Wap支付");			

		tmp.put(PAYMETHOD_BOCWAPV2PAY, "中国银行直连WAP支付（V2）");	
		tmp.put(PAYMETHOD_UNIONWAPPAYFAST, "银联无卡WAP支付");	
		
		tmp.put(PAYMETHOD_ICBCWAPPAY, "工银e支付");	
		tmp.put(PAYMETHOD_ALITVPAY, "阿里TV支付");
		tmp.put(PAYMETHOD_WEIBOPAY, "微博支付");	
		tmp.put(PAYMETHOD_PINGAN1QBPAY, "平安壹钱包支付");	
		
		tmp.put(PAYMETHOD_CHUBAOPAY, "触宝支付");
		tmp.put(PAYMETHOD_BJRCBPAY, "北京农商银行支付");
		tmp.put(PAYMETHOD_ABCPAYFAST, "农业银行快捷支付");
		tmp.put(PAYMETHOD_ABCWAPPAYFAST, "农业银行快捷WAP支付");
		tmp.put(PAYMETHOD_ABCPOINTPAYFAST, "农业银行积分支付");
		tmp.put(PAYMETHOD_HUAANPAY, "华安基金支付");
		tmp.put(PAYMETHOD_HUAANWAPPAY, "华安微钱宝手机支付");
		tmp.put(PAYMETHOD_ALIAPPPAY, "支付宝App支付");
		tmp.put(PAYMETHOD_PAYECOEPAY, "易联手机WAP支付");
		tmp.put(PAYMETHOD_SPDCCCPAY, "浦发信用卡支付");
		tmp.put(PAYMETHOD_SPDCCCWAPPAY, "浦发信用卡WAP支付");
		tmp.put(PAYMETHOD_GZRCBPAY, "广州农商银行");
		tmp.put(PAYMETHOD_GZRCBWAPPAY, "广州农商银行WAP支付");
		tmp.put(PAYMENTOD_MASAWAPPAY, "外卡支付");
		
		tmp.put(PAYMETHOD_UNIONAPPPAY, "银联手机APP支付");
		tmp.put(PAYMETHOD_APPLEPAY, "苹果支付");
		tmp.put(PAYMETHOD_MSQMWAPPAY, "民生齐妙支付");
		
		tmp.put(PAYMETHOD_UNIONWAPPAY, "银联手机WAP支付");//,,,
		tmp.put(PAYMETHOD_QQAPPPAY, "QQ钱包");
		tmp.put(PAYMETHOD_QQTENSCANPAY, "QQ扫码支付");
		tmp.put(PAYMETHOD_CCBAPPPAY, "建行APP支付");
		tmp.put(PAYMETHOD_CBHBPAY, "渤海银行支付");
		tmp.put(PAYMETHOD_CBHBWAPPAY, "渤海银行WAP支付");
		tmp.put(PAYMETHOD_SFAPPPAY, "顺丰APP支付");
		tmp.put(PAYMETHOD_YLCFWAPPAY, "一路财富WAP支付");
		tmp.put(PAYMETHOD_JDWAPPAY, "京东旗下快捷支付");
		tmp.put(PAYMETHOD_JDPAY, "京东支付");
		tmp.put(PAYMETHOD_CCBWAPSECDPAY, "建行账号支付");
		tmp.put(PAYMETHOD_BOCWAPPAYFAST, "中国银行快捷支付");
		tmp.put(PAYMETHOD_FC99BILLPAY, "快钱外卡支付");
		tmp.put(PAYMETHOD_YYPTPAY, "钱大掌柜支付");
		tmp.put(PAYMENTOD_UNICOMWOPAY, "联通沃支付");
		tmp.put(PAYMENTOD_MSFPAY, "民生付");
		tmp.put(PAYMENTOD_XIYINPAY, "西银在线（西安银行支付平台）");
		tmp.put(PAYMENTOD_CMBYWTPAY, "招行一网通");
		tmp.put(PAYMENTOD_WCFWAPPAY, "微财富");
		
		tmp.put(PAYMETHOD_CHINATELEAPPPAY, "电信翼支付");
		tmp.put(PAYMETHOD_CHINATELEWAPPAY, "电信翼支付WAP");
		tmp.put(PAYMETHOD_SUNINGWAPPAY, "苏宁易付宝支付");
		tmp.put(PAYMETHOD_INTELWAPPAY, "Intel集分宝支付");
		tmp.put(PAYMETHOD_SPDCCCB2CPAY, "浦发B2C信用卡支付");
		tmp.put(PAYMETHOD_SPDCCCB2CWAPPAY, "浦发B2C信用卡WAP支付");
		tmp.put(PAYMETHOD_FQLPAY, "分期乐支付PC端");
		tmp.put(PAYMETHOD_FQLWAPPAY, "分期乐Wap支付");
		tmp.put(PAYMETHOD_BOSPAY, "上海银行B2C支付");
		tmp.put(PAYMETHOD_BOSWAPPAY, "上银快付");
		
		tmp.put(PAYMETHOD_PINGANBANKPAY, "平安支付");
		tmp.put(PAYMETHOD_PINGANBANKWAPPAY, "平安WAP支付");
		tmp.put(PAYMETHOD_PAYECOWAPPAY, "易联WAP支付");
		tmp.put(PAYMETHOD_SPDCCCFASTPAYPAY, "浦发快捷支付");

		//不在使用的支付方式
		tmp.put(PAYMETHOD_ALIBANKPAY, "支付宝招商银行WAP");
		tmp.put(PAYMETHOD_TENPAY, "财付通");
		tmp.put(PAYMETHOD_HANDWEBPAY, "翰银WEB");
		tmp.put(PAYMETHOD_HANDWAPPAY, "翰银WAP");		
		//tmp.put(PAYMETHOD_HAOBAIPAY, "号百手机端-客户端");
		//tmp.put(PAYMETHOD_SDOPAY, "盛大积分");
		//tmp.put(PAYMETHOD_IPSPAY, "环讯PC端-信用卡支付");
		//tmp.put(PAYMETHOD_ALLINPAY, "通联");
		//tmp.put(PAYMETHOD_BCWAPPAY_OLD, "交通WAP（老的）");
		
		payTextMap = UnmodifiableMap.decorate(tmp);
	}
	
	public static String getPaymethodText(String paymethod){
		if(payTextMap.get(paymethod)!=null) return payTextMap.get(paymethod);
		if(StringUtils.equals("card", paymethod)) return "兑换券";
		return "未知";
	}
	public static final boolean isValidPayMethod(String paymethod){
		return StringUtils.isNotBlank(paymethod) && PaymethodConstant.PAYMETHOD_LIST.contains(paymethod);
	}
	public static Map<String, String> getPayTextMap(){
		return payTextMap;
	}
	
	
	private static Map<String, String> merchantPaymethodMap;	
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put("union_jsa","unionPay_activity_js");
		tmp.put("union_gz","unionPay_gz");
		tmp.put("union_sh",PAYMETHOD_UNIONPAY);
		tmp.put("union_sha","unionPay_activity");
		tmp.put("union_js","unionPay_js");
		tmp.put("union_zj","unionPay_zj");
		tmp.put("union_sz","unionPay_sz");
		tmp.put("union_bj","unionPay_bj");

		tmp.put("unionfast",PAYMETHOD_UNIONPAYFAST);
		tmp.put("unionfast_bj","unionPayFast_activity_bj");
		tmp.put("unionfast_js","unionPayFast_activity_js");
		tmp.put("unionfast_gz","unionPayFast_activity_gz");
		tmp.put("unionfast_zj","unionPayFast_activity_zj");
		tmp.put("unionfast_sz","unionPayFast_activity_sz");
		
		tmp.put("spd",PAYMETHOD_SPDPAY);
		tmp.put("spd_a",PAYMETHOD_SPDPAY_ACTIVITY);
		
		tmp.put("spdwap",PAYMETHOD_SPDWAPPAY);
		tmp.put("spdwap_a",PAYMETHOD_SPDWAPPAY_ACTIVITY);
		
		tmp.put("cmbwap",PAYMETHOD_CMBWAPPAY);
		tmp.put("cmbstore",PAYMETHOD_CMBWAPSTOREPAY);
		
		tmp.put("china2Pay",PAYMETHOD_CHINAPAY2);
		tmp.put("srcbPay",PAYMETHOD_CHINAPAYSRCB);
		tmp.put("chinaPay",PAYMETHOD_CHINAPAY1);
		
		tmp.put("um_sh",PAYMETHOD_UMPAY_SH);
		tmp.put("um",PAYMETHOD_UMPAY);
		
		tmp.put("chinasm",PAYMETHOD_CHINASMARTMOBILEPAY);
		tmp.put("chinasm_js",PAYMETHOD_CHINASMARTJSPAY);
		
		merchantPaymethodMap = UnmodifiableMap.decorate(tmp);
	}
	
	public static String getPaymethodByMercdoe(String merchantCode){
		if(StringUtils.isBlank(merchantCode)) return null;
		return merchantPaymethodMap.get(merchantCode);
	}
	
	//---------------------------------------------------------------------------------------
	/**支付网关：银联电子支付*/
	public static final String GATEWAY_CHINAPAY = "chinaPay";
	/**支付网关：电信固话支付*/
	public static final String GATEWAY_CHARGETELECOMPAY = "chargeTelecomPay";
	
	
	
	/**商户标识：chinaPay*/
	public static final String MERCHANT_CHINA2PAY = "china2Pay";
	/**商户标识：chinaPay*/
	public static final String MERCHANT_CHINAPAY = "chinaPay";
	/**商户标识：chinaPay*/
	public static final String MERCHANT_SRCBPAY = "srcbPay";
	

	/**银行代码：0000，什么银行也不代表*/
	public static final String BANK_NONE = "0000";
	
	/**银行代码：SRCB，上海农商银行*/
	public static final String BANK_SRCB = "SRCB";

	//---------------------------------------------------------------------------------------
	/**发起支付来源：PC*/
	public static final String REQSOURCE_PC = "PC";
	
	/**发起支付来源：WAP*/
	public static final String REQSOURCE_WAP = "WAP";
	
	/**发起支付来源：APP*/
	public static final String REQSOURCE_APP = "APP";	
	
}
