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
	public static final String PAYMETHOD_UNKNOWN = "unknown";						//未知锟斤拷锟矫伙拷未选锟斤拷
	//锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_GEWAPAY = "gewaPay";						//锟矫伙拷锟斤拷锟�
	public static final String PAYMETHOD_FCARDPAY = "fcardPay";						//锟姐卡支锟斤拷
	public static final String PAYMETHOD_SYSPAY = "sysPay";							//系统锟矫伙拷
	public static final String PAYMETHOD_ELECARDPAY = "elecardPay";					//全锟斤拷使锟斤拷券
	public static final String PAYMETHOD_GEWARA_OFFLINEPAY = "offlinePay";			//锟斤拷台锟斤拷锟斤拷支锟斤拷
	//锟斤拷值
	public static final String PAYMETHOD_CHARGECARD = "ccardPay";					//锟斤拷值锟斤拷锟斤拷只锟斤拷锟斤拷锟斤拷值
	public static final String PAYMETHOD_LAKALA = "lakalaPay";						//锟斤拷锟斤拷锟斤拷 锟斤拷只锟斤拷锟斤拷锟斤拷值
	public static final String PAYMETHOD_ABCBANKPAY = "abcPay";						//农锟叫猴拷锟斤拷锟斤拷值锟斤拷只锟斤拷锟斤拷锟斤拷值
	public static final String PAYMETHOD_WCANPAY = "wcanPay";						//微锟杰科硷拷锟斤拷锟斤拷锟斤拷值锟斤拷只锟斤拷锟斤拷锟斤拷值
	//支锟斤拷----锟斤拷锟斤拷锟斤拷锟�
	public static final String PAYMETHOD_PARTNERPAY = "partnerPay";					//锟斤拷锟斤拷锟斤拷锟�
	public static final String PAYMETHOD_OKCARDPAY = "okcardPay";					//锟斤拷锟斤拷OK锟斤拷
	public static final String PAYMETHOD_SPSDOPAY1 = "spsdoPay";					//盛锟斤拷时锟斤拷锟斤拷支锟斤拷
	//支锟斤拷----锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_ALIPAY = "directPay";						//支锟斤拷锟斤拷PC锟斤拷
	public static final String PAYMETHOD_PNRPAY = "pnrPay";							//锟姐付锟斤拷锟斤拷PC锟斤拷
	public static final String PAYMETHOD_CMPAY = "cmPay";							//锟狡讹拷锟街伙拷支锟斤拷PC锟斤拷
	public static final String PAYMETHOD_TEMPUSPAY = "tempusPay";					//锟节革拷通PC锟斤拷
	public static final String PAYMETHOD_SPSDOPAY2 = "spsdo2Pay";					//盛锟斤拷通PC锟斤拷
	public static final String PAYMETHOD_CHINAPAY1 = "chinaPay";					//锟斤拷锟斤拷
	public static final String PAYMETHOD_CHINAPAY2 = "china2Pay";					//ChinapayPC锟斤拷
	public static final String PAYMETHOD_CHINAPAYSRCB = "srcbPay";					//Chinapay农锟斤拷锟斤拷--->50000547
	
	public static final String PAYMETHOD_UNIONPAY = "unionPay";						//unionPay
	

	public static final String PAYMETHOD_UNIONPAY_JS = "unionPay_js";				//Unionpay锟斤拷锟斤拷PC锟斤拷
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY = "unionPay_activity";	//unionPay锟筋动
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY_JS = "unionPay_activity_js";//unionPay锟斤拷锟秸活动
	public static final String PAYMETHOD_UNIONPAY_ZJ = "unionPay_zj";		//锟姐江锟斤拷锟斤拷专锟斤拷
	public static final String PAYMETHOD_UNIONPAY_SZ = "unionPay_sz";		//锟斤拷锟节碉拷锟斤拷专锟斤拷
	public static final String PAYMETHOD_UNIONPAY_BJ = "unionPay_bj";		//锟斤拷锟斤拷锟斤拷锟斤拷专锟斤拷
	public static final String PAYMETHOD_UNIONPAY_GZ = "unionPay_gz";		//锟斤拷锟捷碉拷锟斤拷专锟斤拷

	
	public static final String PAYMETHOD_UNIONPAYFAST = "unionPayFast";				//unionPay V2.0.0 锟芥本支锟斤拷
	/**
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS = "unionPayFast_activity_js";//unionPay version 2.0.0锟芥本 unionPay锟斤拷锟秸活动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ = "unionPayFast_activity_bj";//unionPay version 2.0.0锟芥本 unionPay锟斤拷锟斤拷锟筋动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ = "unionPayFast_activity_sz";//unionPay version 2.0.0锟芥本锟斤拷锟节碉拷锟斤拷锟筋动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ = "unionPayFast_activity_gz";//unionPay version 2.0.0锟芥本锟斤拷锟捷碉拷锟斤拷锟筋动
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ = "unionPayFast_activity_zj";//unionPay version 2.0.0锟芥本锟姐江锟斤拷锟斤拷锟筋动
	*/
	
	//支锟斤拷----直锟斤拷
	public static final String PAYMETHOD_BCPAY = "bcPay";							//锟斤拷锟斤拷直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_SPDPAY = "spdPay";							//锟街凤拷直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_CMBPAY = "cmbPay";							//锟斤拷锟斤拷直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_GDBPAY = "gdbPay";							//锟姐发直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_GDB_UNION_PAY = "gdbUnionPay";  		    //锟姐发直锟斤拷PC锟斤拷(锟斤拷锟斤拷)
	public static final String PAYMETHOD_PSBCPAY = "psbcPay";						//锟绞达拷直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_HZBANKPAY = "hzbankPay";					//锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷
	//public static final String PAYMETHOD_CCBPOSPAY = "ccbposPay";					//锟斤拷锟斤拷直锟斤拷PC锟斤拷-锟斤拷锟矫匡拷
	public static final String PAYMETHOD_JSBCHINA = "jsbChina";						//锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷PC锟斤拷-锟斤拷锟矫匡拷
	public static final String PAYMETHOD_SPDPAY_ACTIVITY = "spdPay_activity";		//锟街凤拷直锟斤拷PC锟斤拷-锟筋动
	public static final String PAYMETHOD_BOCPAY = "bocPay";							//锟叫癸拷锟斤拷锟斤拷直锟斤拷PC锟斤拷
	public static final String PAYMETHOD_BOCWAPPAY = "bocWapPay";					//锟叫癸拷锟斤拷锟斤拷直锟斤拷WAP锟斤拷
	public static final String PAYMETHOD_BOCAGRMTPAY = "bocAgrmtPay";				//锟叫癸拷锟斤拷锟斤拷协锟斤拷支锟斤拷
	//支锟斤拷----锟斤拷锟斤拷
	public static final String PAYMETHOD_UMPAY = "umPay";							//锟狡讹拷锟斤拷锟斤拷支锟斤拷(锟斤拷锟斤拷锟斤拷锟斤拷)
	public static final String PAYMETHOD_UMPAY_SH = "umPay_sh";						//锟狡讹拷锟斤拷锟斤拷支锟斤拷(锟斤拷锟斤拷锟斤拷锟斤拷) 锟较猴拷锟斤拷锟斤拷
	public static final String PAYMETHOD_TELECOM= "telecomPay";						//锟斤拷锟脚固伙拷锟斤拷锟斤拷支锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷值
	public static final String PAYMETHOD_MOBILE_TELECOM= "telecomMobilePay";		//锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷支锟斤拷
	//支锟斤拷----锟斤拷业锟斤拷
	public static final String PAYMETHOD_YAGAO = "yagaoPay";						//锟脚革拷
	public static final String PAYMETHOD_ONETOWN = "onetownPay";					//一锟角匡拷支锟斤拷(锟铰伙拷锟斤拷媒)
	//支锟斤拷----锟街伙拷锟剿ｏ拷直锟斤拷 + 锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_ALIWAPPAY = "aliwapPay";					//支锟斤拷锟斤拷锟街伙拷锟斤拷-WAP支锟斤拷
	public static final String PAYMETHOD_CMWAPPAY = "cmwapPay";						//锟狡讹拷锟街伙拷支锟斤拷锟街伙拷锟斤拷-WAP支锟斤拷
	public static final String PAYMETHOD_CMBWAPPAY = "cmbwapPay";					//锟斤拷锟斤拷直锟斤拷锟街伙拷锟斤拷
	public static final String PAYMETHOD_CMBWAPSTOREPAY = "cmbwapStorePay";			//锟斤拷锟斤拷直锟斤拷锟街伙拷锟斤拷CMSTORE
	public static final String PAYMETHOD_SPDWAPPAY = "spdWapPay";					//锟街凤拷直锟斤拷锟街伙拷锟斤拷-WAP
	public static final String PAYMETHOD_CMSMARTPAY = "cmSmartPay";					//锟狡讹拷锟街伙拷支锟斤拷锟斤拷卓锟斤拷
	public static final String PAYMETHOD_SPDWAPPAY_ACTIVITY = "spdWapPay_activity";	//锟街凤拷直锟斤拷锟街伙拷锟斤拷-锟筋动
	public static final String PAYMETHOD_CHINASMARTMOBILEPAY = "chinaSmartMobilePay";//锟斤拷锟斤拷锟斤拷锟斤拷锟街伙拷支锟斤拷
	public static final String PAYMETHOD_CHINASMARTJSPAY = "chinaSmartJsPay";		//锟斤拷锟斤拷锟斤拷锟斤拷锟街伙拷支锟斤拷-锟斤拷锟斤拷
	public static final String PAYMETHOD_ALISMARTMOBILEPAY = "aliSmartMobilePay";	//支锟斤拷锟斤拷锟街伙拷锟斤拷-锟斤拷全支锟斤拷
	public static final String PAYMETHOD_HZWAPPAY = "hzwapPay";						//锟斤拷锟斤拷锟斤拷锟斤拷WAP
	public static final String PAYMETHOD_YEEPAY = "yeePay";       					//锟阶憋拷支锟斤拷
	public static final String PAYMETHOD_PAYECO_DNA = "payecoDNAPay";       		// 锟斤拷锟斤拷DNA支锟斤拷
	public static final String PAYMETHOD_MEMBERCARDPAY = "memberCardPay";       	// 锟斤拷员锟斤拷支锟斤拷
	public static final String PAYMETHOD_ICBCPAY = "icbcPay";       // 锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷
	public static final String PAYMETHOD_NJCBPAY = "njcbPay";       // 锟较撅拷锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷
	public static final String PAYMETHOD_ABCHINAPAY = "abchinaPay";       // 农业锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷
	
	public static final String PAYMETHOD_WXAPPTENPAY = "wxAppTenPay";       //锟狡革拷通微锟斤拷支锟斤拷锟斤拷App锟斤拷支锟斤拷锟斤拷
	public static final String PAYMETHOD_WXAPPPAY = "wxAppPay";				//锟狡革拷通微锟斤拷支锟斤拷锟斤拷App锟斤拷支锟斤拷锟斤拷
	public static final String PAYMETHOD_WXMPNOPAY = "wxMPNoPay";				//微锟脚癸拷锟节猴拷支锟斤拷
	public static final String PAYMETHOD_WXSCANTENPAY = "wxScanTenPay";       //锟狡革拷通微锟斤拷支锟斤拷锟斤拷WEB扫锟诫）
	public static final String PAYMETHOD_WXWCPAY = "wxWCPay";				//微锟脚癸拷锟节猴拷支锟斤拷
	public static final String PAYMETHOD_CCBWAPPAY = "ccbWapPay";	//锟斤拷锟斤拷锟街伙拷wap支锟斤拷
	public static final String PAYMETHOD_ONECLICKTENPAY = "oneClickTenPay";	//锟狡革拷通锟狡讹拷锟秸讹拷一锟斤拷支锟斤拷
	public static final String PAYMETHOD_BESTPAY = "bestPay";	//锟斤拷支锟斤拷
	public static final String PAYMETHOD_BFBWAPPAY = "bfbWapPay";	//锟劫讹拷钱锟斤拷wap支锟斤拷
	public static final String PAYMETHOD_BFBPAY = "bfbPay";		//锟劫讹拷钱锟斤拷支锟斤拷
	public static final String PAYMETHOD_ALISCANPAY = "aliScanPay";		//支锟斤拷锟斤拷扫锟斤拷支锟斤拷
	public static final String PAYMETHOD_CCBMBCPAY = "ccbMBCPay";		//锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_BCWAPPAY = "bcWapPay";//锟斤拷锟斤拷Wap支锟斤拷	

	public static final String PAYMETHOD_BOCWAPV2PAY = "bocWapV2Pay";//锟叫癸拷锟斤拷锟斤拷直锟斤拷WAP支锟斤拷锟斤拷V2锟斤拷
	public static final String PAYMETHOD_UNIONWAPPAYFAST = "unionWapPayFast";//锟斤拷锟斤拷锟睫匡拷WAP支锟斤拷
	
	public static final String PAYMETHOD_ICBCWAPPAY = "icbcWapPay";//锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷WAP支锟斤拷
	
	public static final String PAYMETHOD_ALITVPAY = "aliTvPay";//锟斤拷锟斤拷tv支锟斤拷
	
	public static final String PAYMETHOD_WEIBOPAY = "weiboPay";//微锟斤拷支锟斤拷
	
	public static final String PAYMETHOD_PINGAN1QBPAY = "pingan1qbPay";//平锟斤拷壹钱锟斤拷支锟斤拷

	public static final String PAYMETHOD_CHUBAOPAY = "chubaoPay";					//锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_BJRCBPAY = "bjrcbPay";						//锟斤拷锟斤拷农锟斤拷支锟斤拷
	public static final String PAYMETHOD_ABCPAYFAST = "abcPayFast";					//农业锟斤拷锟叫匡拷锟街э拷锟�
	public static final String PAYMETHOD_ABCWAPPAYFAST = "abcWapPayFast";			//农业WAP支锟斤拷
	public static final String PAYMETHOD_ABCPOINTPAYFAST = "abcPointPayFast";		//农业锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_HUAANPAY = "huaanPay";						//锟斤拷锟斤拷PC支锟斤拷
	public static final String PAYMETHOD_HUAANWAPPAY = "huaanWapPay";				//锟斤拷锟斤拷WAP支锟斤拷
	
	public static final String PAYMETHOD_ALIAPPPAY = "aliAppPay";				//支锟斤拷锟斤拷App支锟斤拷
	public static final String PAYMETHOD_PAYECOEPAY = "payecoEPay";				//锟斤拷锟斤拷锟街伙拷wap支锟斤拷

	public static final String PAYMETHOD_UNIONAPPPAY = "unionAppPay";			//锟斤拷锟斤拷锟街伙拷APP支锟斤拷
	public static final String PAYMETHOD_APPLEPAY = "applePay";					//苹锟斤拷支锟斤拷支锟斤拷锟斤拷锟斤拷实锟斤拷锟斤拷unionAppPay支锟斤拷
	public static final String PAYMETHOD_UNIONWAPPAY = "unionWapPay";			//锟斤拷锟斤拷锟街伙拷WAP支锟斤拷
	public static final String PAYMETHOD_QQAPPPAY = "qqAppPay";					//QQ钱锟斤拷支锟斤拷
	public static final String PAYMETHOD_QQTENSCANPAY = "qqTenScanPay";			//QQ扫锟斤拷支锟斤拷
	
	public static final String PAYMETHOD_SPDCCCPAY = "spdcccPay";				//锟街凤拷锟斤拷锟矫匡拷PC支锟斤拷
	public static final String PAYMETHOD_SPDCCCWAPPAY = "spdcccWapPay";			//锟街凤拷锟斤拷锟矫匡拷WAP支锟斤拷
	public static final String PAYMETHOD_CCBAPPPAY = "ccbAppPay";				//锟斤拷锟斤拷锟斤拷锟斤拷APP支锟斤拷
	public static final String PAYMETHOD_CBHBPAY = "cbhbPay";					//锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_CBHBWAPPAY = "cbhbWapPay";				//锟斤拷锟斤拷WAP支锟斤拷
	public static final String PAYMETHOD_SFAPPPAY = "sfAppPay";					//顺锟斤拷APP支锟斤拷
	public static final String PAYMETHOD_WLTWAPPAY = "wltWapPay";				//锟斤拷锟斤拷通WAP支锟斤拷
	public static final String PAYMETHOD_YLCFWAPPAY = "ylcfWapPay";				//一路锟狡革拷WAP支锟斤拷
	public static final String PAYMETHOD_JDWAPPAY = "jdWapPay";					//锟斤拷锟斤拷WAP支锟斤拷
	public static final String PAYMETHOD_JDPAY = "jdPay";					//锟斤拷锟斤拷PC支锟斤拷
	public static final String PAYMETHOD_CCBWAPSECDPAY = "ccbWapSecdPay";		//锟斤拷锟斤拷锟剿猴拷支锟斤拷
	
	public static final String PAYMETHOD_BOCWAPPAYFAST = "bocWapPayFast";	   //锟叫癸拷锟斤拷锟斤拷wap锟斤拷锟街э拷锟�
	public static final String PAYMETHOD_FC99BILLPAY = "foreignCard99billPay";	//锟斤拷钱锟解卡支锟斤拷
	public static final String PAYMETHOD_GZRCBPAY = "gzrcbPay";					//锟斤拷锟斤拷农锟斤拷支锟斤拷
	public static final String PAYMETHOD_GZRCBWAPPAY = "gzrcbWapPay";			//锟斤拷锟斤拷农锟斤拷Wap支锟斤拷
	public static final String PAYMETHOD_CHINATELEAPPPAY = "chinaTeleAppPay";	//锟斤拷锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_CHINATELEWAPPAY = "chinaTeleWapPay";	//锟斤拷锟斤拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_SUNINGWAPPAY = "suningWapPay";			//锟斤拷锟斤拷锟阶革拷锟斤拷支锟斤拷
	public static final String PAYMETHOD_INTELWAPPAY = "intelWapPay";			//Intel锟斤拷锟街憋拷支锟斤拷
	public static final String PAYMETHOD_SPDCCCB2CPAY = "spdcccB2cPay";			//锟街凤拷B2C锟斤拷锟矫匡拷支锟斤拷
	public static final String PAYMETHOD_SPDCCCB2CWAPPAY = "spdcccB2cWapPay";	//锟街凤拷B2C锟斤拷锟矫匡拷WAP支锟斤拷
	
	public static final String PAYMETHOD_FQLPAY = "fqlPay";			//锟斤拷锟斤拷锟斤拷支锟斤拷PC锟斤拷
	public static final String PAYMETHOD_FQLWAPPAY = "fqlWapPay";	//锟斤拷锟斤拷锟斤拷Wap支锟斤拷
	
	public static final String PAYMETHOD_BOSPAY = "bosPay";//锟较猴拷锟斤拷锟斤拷B2C支锟斤拷
	
	public static final String PAYMETHOD_BOSWAPPAY = "bosWapPay";//锟斤拷锟斤拷锟届付
	
	public static final String PAYMETHOD_PINGANBANKPAY = "pinganBankPay";//平锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_PINGANBANKWAPPAY = "pinganBankWapPay";//平锟斤拷锟斤拷锟斤拷WAP
	public static final String PAYMETHOD_PAYECOWAPPAY = "payecoWapPay";//锟斤拷锟斤拷WAP支锟斤拷
	public static final String PAYMETHOD_MSQMWAPPAY = "msqmWapPay";//锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷
	
	public static final String PAYMETHOD_SPDCCCFASTPAYPAY = "spdcccFastPay";//锟街凤拷锟斤拷锟叫匡拷锟街э拷锟�
	public static final String PAYMETHOD_BCOMCCFASTPAYPAY = "bcomccFastPay";	//锟斤拷通锟斤拷锟叫匡拷锟街э拷锟�
	public static final String PAYMENTOD_MASAWAPPAY = "masaWapPay";               //锟解卡支锟斤拷
	
	//支锟斤拷----锟斤拷锟斤拷支锟斤拷锟斤拷式锟斤拷锟斤拷使锟斤拷
	public static final String PAYMETHOD_TENPAY = "tenPay";								//锟狡革拷通
	//public static final String PAYMETHOD_BCWAPPAY_OLD = "bcwapPay";					//锟斤拷通WAP锟斤拷锟斤拷 
	public static final String PAYMETHOD_ALIBANKPAY = "alibankPay";					//支锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷
	public static final String PAYMETHOD_HANDWAPPAY = "handwapPay";					//锟斤拷锟斤拷只锟�
	public static final String PAYMETHOD_HANDWEBPAY = "handwebPay";					//锟斤拷锟斤拷只锟�
	public static final String PAYMETHOD_PNRFASTPAY = "pnrfastPay";					//锟姐付锟斤拷锟街э拷锟� --锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_PNRFASTPAY2 = "pnrfastPay2";					//锟姐付锟斤拷锟街э拷锟�2--锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String PAYMETHOD_PNRFASTABCPAY = "pnrfastabcPay";			//锟姐付锟斤拷锟街э拷锟�--农业锟斤拷锟斤拷锟斤拷锟矫匡拷
	
	public static final String PAYMETHOD_YYPTPAY = "yyptPay";							//钱锟斤拷锟狡癸拷锟斤拷支锟斤拷
	
	public static final String PAYMENTOD_UNICOMWOPAY = "unicomWoPay";					//锟斤拷通锟斤拷支锟斤拷	
	public static final String PAYMENTOD_MSFPAY = "msfPay";                             //锟斤拷锟斤拷锟斤拷
	
	/**锟教伙拷锟斤拷锟街э拷锟斤拷锟斤拷锟街伙拷院锟斤拷锟斤拷袒锟绞癸拷茫锟斤拷锟斤拷锟斤拷怨锟斤拷锟斤拷锟斤拷锟斤拷锟�**/
	public static final String PAYMETHOD_MERCHANTPAY = "merchantPay";//锟教伙拷锟斤拷锟街э拷锟�
	public static final String PAYMENTOD_XIYINPAY="xiyinPay";							//锟斤拷锟斤拷锟斤拷锟斤拷
	
	public static final String PAYMENTOD_CMBYWTPAY = "cmbywtPay"; //锟斤拷锟斤拷一锟斤拷通
	public static final String PAYMENTOD_WCFWAPPAY = "wcfWapPay";  //微锟狡革拷
	//锟窖凤拷锟斤拷
	//public static final String PAYMETHOD_SDOPAY = "sdoPay";							//盛锟斤拷锟斤拷锟�+锟街斤拷
	//public static final String PAYMETHOD_IPSPAY= "ipsPay";							//锟斤拷讯PC锟斤拷-锟斤拷锟矫匡拷支锟斤拷
	//public static final String PAYMETHOD_HAOBAIPAY = "haobaiPay";					//锟脚帮拷锟街伙拷锟斤拷-锟酵伙拷锟斤拷
	//public static final String PAYMETHOD_ALLINPAY = "allinPay";						//通锟斤拷支锟斤拷
	
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
	/*锟斤拷锟斤拷:PAYMETHOD_HAOBAIPAY, PAYMETHOD_IPSPAY, PAYMETHOD_SDOPAY, PAYMETHOD_ALLINPAY, PAYMETHOD_BCWAPPAY_OLD, */
		
	public static final List<String> MOBILE_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_ALIWAPPAY, PAYMETHOD_CMWAPPAY, PAYMETHOD_CMBWAPPAY, PAYMETHOD_CMBWAPSTOREPAY, PAYMETHOD_SPDWAPPAY, 
			PAYMETHOD_CMSMARTPAY, PAYMETHOD_SPDWAPPAY_ACTIVITY, PAYMETHOD_CHINASMARTMOBILEPAY, PAYMETHOD_CHINASMARTJSPAY, PAYMETHOD_BOCWAPPAY, PAYMETHOD_FCARDPAY,
			PAYMETHOD_ALISMARTMOBILEPAY, PAYMETHOD_HZWAPPAY ,PAYMETHOD_WXAPPTENPAY, PAYMETHOD_CCBWAPPAY, PAYMETHOD_WXWCPAY, PAYMETHOD_ONECLICKTENPAY, PAYMETHOD_BFBWAPPAY,PAYMETHOD_CCBMBCPAY,PAYMETHOD_BCWAPPAY
			,PAYMETHOD_BOCWAPV2PAY,PAYMETHOD_UNIONWAPPAYFAST, PAYMETHOD_ICBCWAPPAY, PAYMETHOD_ALITVPAY, PAYMETHOD_WEIBOPAY, PAYMETHOD_PINGAN1QBPAY, PAYMETHOD_CHUBAOPAY, PAYMETHOD_HUAANWAPPAY, PAYMETHOD_ALIAPPPAY,
			PAYMETHOD_PAYECOEPAY,PAYMETHOD_WXMPNOPAY,PAYMETHOD_UNIONAPPPAY,PAYMETHOD_UNIONWAPPAY,PAYMETHOD_QQAPPPAY,PAYMETHOD_SPDCCCWAPPAY,PAYMETHOD_CCBAPPPAY,PAYMETHOD_CBHBPAY,PAYMETHOD_CBHBWAPPAY,PAYMETHOD_ABCWAPPAYFAST,PAYMETHOD_ABCPAYFAST,PAYMETHOD_YLCFWAPPAY,
			PAYMETHOD_SFAPPPAY,PAYMETHOD_WLTWAPPAY,PAYMETHOD_ABCHINAPAY,PAYMETHOD_JDWAPPAY,PAYMETHOD_CCBWAPSECDPAY,PAYMETHOD_BOCWAPPAYFAST,PAYMETHOD_GZRCBWAPPAY,PAYMETHOD_CHINATELEAPPPAY,PAYMETHOD_SUNINGWAPPAY,PAYMETHOD_INTELWAPPAY,PAYMETHOD_SPDCCCB2CWAPPAY,PAYMETHOD_FQLWAPPAY,PAYMETHOD_BOSWAPPAY,
			PAYMETHOD_PINGANBANKWAPPAY,PAYMETHOD_PAYECOWAPPAY,PAYMETHOD_CHINATELEWAPPAY, PAYMETHOD_APPLEPAY, PAYMETHOD_MSQMWAPPAY,PAYMETHOD_SPDCCCFASTPAYPAY,PAYMETHOD_YYPTPAY,PAYMENTOD_UNICOMWOPAY,PAYMENTOD_MSFPAY,PAYMENTOD_XIYINPAY,PAYMENTOD_MASAWAPPAY,PAYMENTOD_CMBYWTPAY,PAYMENTOD_WCFWAPPAY);
	
	//锟斤拷锟斤拷锟斤拷支锟斤拷锟斤拷式锟斤拷锟叫讹拷锟剿匡拷锟斤拷芑锟斤拷锟斤拷谩锟�
	public static final List<String> PARTNER_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_PARTNERPAY, PAYMETHOD_OKCARDPAY, PAYMETHOD_SPSDOPAY1);
	private static Map<String, String> payTextMap;	
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(PAYMETHOD_SYSPAY, "系统");
		tmp.put(PAYMETHOD_GEWAPAY, "锟斤拷锟斤拷锟斤拷锟�");
		tmp.put(PAYMETHOD_FCARDPAY, "锟姐卡支锟斤拷");
		tmp.put(PAYMETHOD_ELECARDPAY, "锟斤拷锟斤拷券");
		tmp.put(PAYMETHOD_GEWARA_OFFLINEPAY, "锟斤拷台锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CHARGECARD, "锟斤拷锟竭筹拷值锟斤拷");
		tmp.put(PAYMETHOD_LAKALA, "锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_ABCBANKPAY,"农锟叫猴拷锟斤拷");
		tmp.put(PAYMETHOD_WCANPAY,"微锟杰科硷拷锟斤拷锟街兑伙拷");
		
		tmp.put(PAYMETHOD_PNRPAY, "锟姐付锟斤拷锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_ALIPAY, "支锟斤拷锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_CMPAY, "锟狡讹拷锟街伙拷支锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_CHINAPAY1, "锟斤拷锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_CHINAPAY2, "ChinapayPC锟斤拷");
		tmp.put(PAYMETHOD_SPSDOPAY2, "盛锟斤拷通PC锟斤拷");
		tmp.put(PAYMETHOD_PAYECO_DNA, "锟斤拷锟斤拷DNA支锟斤拷");
		
		tmp.put(PAYMETHOD_CMBPAY, "锟斤拷锟斤拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_CMBWAPPAY, "锟斤拷锟斤拷直锟斤拷锟街伙拷锟斤拷");
		tmp.put(PAYMETHOD_CMBWAPSTOREPAY, "锟斤拷锟斤拷锟街伙拷锟斤拷-STORE");
		tmp.put(PAYMETHOD_BCPAY, "锟斤拷锟斤拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_GDBPAY, "锟姐发直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_GDB_UNION_PAY, "锟姐发锟斤拷锟斤拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_BOCPAY, "锟叫癸拷锟斤拷锟斤拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_BOCAGRMTPAY, "锟叫癸拷锟斤拷锟斤拷协锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_SPDPAY, "锟街凤拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_SPDPAY_ACTIVITY, "锟街凤拷直锟斤拷PC锟斤拷-锟筋动");
		tmp.put(PAYMETHOD_SPDWAPPAY_ACTIVITY, "锟街凤拷直锟斤拷锟街伙拷锟斤拷-锟筋动");
		tmp.put(PAYMETHOD_PSBCPAY, "锟绞达拷直锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_HZBANKPAY, "锟斤拷锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_HZWAPPAY, "锟斤拷锟斤拷锟斤拷锟斤拷WAP");
		tmp.put(PAYMETHOD_JSBCHINA, "锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷PC锟斤拷-锟斤拷锟矫匡拷");
		tmp.put(PAYMETHOD_TEMPUSPAY, "锟节革拷通PC锟斤拷");
		tmp.put(PAYMETHOD_YEEPAY, "锟阶憋拷支锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_ICBCPAY, "锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷");	
		tmp.put(PAYMETHOD_NJCBPAY, "锟较撅拷锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_ABCHINAPAY, "农业锟斤拷锟斤拷直锟斤拷支锟斤拷PC锟斤拷");	
		
		tmp.put(PAYMETHOD_ALIWAPPAY, "支锟斤拷锟斤拷锟街伙拷锟斤拷-WAP支锟斤拷");
		tmp.put(PAYMETHOD_BOCWAPPAY, "锟叫癸拷锟斤拷锟斤拷直锟斤拷WAP锟斤拷");
		tmp.put(PAYMETHOD_CMWAPPAY, "锟狡讹拷锟街伙拷支锟斤拷锟街伙拷锟斤拷-WAP支锟斤拷");
		tmp.put(PAYMETHOD_SPDWAPPAY, "锟街凤拷直锟斤拷锟街伙拷锟斤拷-WAP");
		tmp.put(PAYMETHOD_CHINASMARTMOBILEPAY, "锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CHINASMARTJSPAY, "锟斤拷锟斤拷锟斤拷锟斤拷锟街伙拷锟斤拷-锟斤拷锟斤拷锟斤拷锟斤拷锟秸碉拷");
		tmp.put(PAYMETHOD_ALISMARTMOBILEPAY, "支锟斤拷锟斤拷锟街伙拷锟斤拷-锟斤拷全支锟斤拷");
		tmp.put(PAYMETHOD_CMSMARTPAY, "锟狡讹拷锟街伙拷支锟斤拷锟斤拷卓锟斤拷");
		
		tmp.put(PAYMETHOD_UNIONPAY, "unionPay锟斤拷锟斤拷支锟斤拷");
		

		tmp.put(PAYMETHOD_UNIONPAY_JS, "unionPay锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY, "unionPay锟筋动");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY_JS, "unionPay锟斤拷锟秸活动");
		tmp.put(PAYMETHOD_UNIONPAY_ZJ, "unionPay锟姐江");
		tmp.put(PAYMETHOD_UNIONPAY_SZ, "unionPay锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_UNIONPAY_BJ, "unionPay锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_UNIONPAY_GZ, "unionPay锟斤拷锟斤拷");

		
		tmp.put(PAYMETHOD_UNIONPAYFAST, "unionPayFast锟斤拷锟斤拷锟斤拷锟街э拷锟�");
		/**
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS, "unionPayFast锟斤拷锟秸活动");	
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ, "锟斤拷锟斤拷锟斤拷证2.0锟斤拷锟斤拷锟筋动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ, "锟斤拷锟斤拷锟斤拷证2.0锟斤拷锟节活动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ, "锟斤拷锟斤拷锟斤拷证2.0锟斤拷锟捷活动");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ, "锟斤拷锟斤拷锟斤拷证2.0锟姐江");
		*/
		
		
		tmp.put(PAYMETHOD_PNRFASTPAY, "锟姐付锟斤拷锟街э拷锟�--锟斤拷锟斤拷锟斤拷锟矫匡拷");
		tmp.put(PAYMETHOD_PNRFASTPAY2, "锟姐付锟斤拷锟街э拷锟�--锟斤拷锟斤拷锟斤拷锟矫匡拷");
		tmp.put(PAYMETHOD_PNRFASTABCPAY, "锟姐付锟斤拷锟街э拷锟�--农锟斤拷锟斤拷锟矫匡拷");
		
		
		tmp.put(PAYMETHOD_TELECOM, "锟斤拷锟脚固伙拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_MOBILE_TELECOM, "锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_UMPAY, "锟狡讹拷锟斤拷锟斤拷支锟斤拷(锟斤拷锟斤拷锟斤拷锟斤拷)");
		tmp.put(PAYMETHOD_UMPAY_SH, "锟狡讹拷锟斤拷锟斤拷支锟斤拷(锟斤拷锟斤拷锟斤拷锟斤拷)_锟较猴拷");
		tmp.put(PAYMETHOD_YAGAO, "锟脚高匡拷支锟斤拷(锟斤拷锟斤拷锟斤拷锟�)");
		tmp.put(PAYMETHOD_ONETOWN, "一锟角匡拷支锟斤拷(锟铰伙拷锟斤拷媒)");
		
		tmp.put(PAYMETHOD_PARTNERPAY, "锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_OKCARDPAY, "锟斤拷锟斤拷OK");
		tmp.put(PAYMETHOD_SPSDOPAY1, "盛锟斤拷锟斤拷锟�");
		tmp.put(PAYMETHOD_CHINAPAYSRCB, "Chinapay农锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_MEMBERCARDPAY, "锟斤拷员锟斤拷支锟斤拷");
		
		tmp.put(PAYMETHOD_WXAPPTENPAY, "锟狡革拷通微锟斤拷支锟斤拷锟斤拷App锟斤拷支锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_WXAPPPAY, "微锟脚客伙拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_WXSCANTENPAY, "锟狡革拷通微锟斤拷支锟斤拷锟斤拷WEB扫锟诫）");
		tmp.put(PAYMETHOD_WXWCPAY, "微锟脚癸拷锟节猴拷支锟斤拷");
		tmp.put(PAYMETHOD_WXMPNOPAY, "微锟脚癸拷锟节猴拷JS支锟斤拷");
		tmp.put(PAYMETHOD_CCBWAPPAY, "锟斤拷锟斤拷锟街伙拷wap支锟斤拷");
		tmp.put(PAYMETHOD_ONECLICKTENPAY, "锟狡革拷通锟狡讹拷锟秸讹拷一锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_BESTPAY, "锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_BFBWAPPAY, "锟劫讹拷钱锟斤拷wap支锟斤拷");
		tmp.put(PAYMETHOD_BFBPAY, "锟劫讹拷钱锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_ALISCANPAY, "支锟斤拷锟斤拷扫锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CCBMBCPAY, "锟斤拷锟斤拷锟街伙拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_BCWAPPAY, "锟斤拷锟斤拷Wap支锟斤拷");			

		tmp.put(PAYMETHOD_BOCWAPV2PAY, "锟叫癸拷锟斤拷锟斤拷直锟斤拷WAP支锟斤拷锟斤拷V2锟斤拷");	
		tmp.put(PAYMETHOD_UNIONWAPPAYFAST, "锟斤拷锟斤拷锟睫匡拷WAP支锟斤拷");	
		
		tmp.put(PAYMETHOD_ICBCWAPPAY, "锟斤拷锟斤拷e支锟斤拷");	
		tmp.put(PAYMETHOD_ALITVPAY, "锟斤拷锟斤拷TV支锟斤拷");
		tmp.put(PAYMETHOD_WEIBOPAY, "微锟斤拷支锟斤拷");	
		tmp.put(PAYMETHOD_PINGAN1QBPAY, "平锟斤拷壹钱锟斤拷支锟斤拷");	
		
		tmp.put(PAYMETHOD_CHUBAOPAY, "锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_BJRCBPAY, "锟斤拷锟斤拷农锟斤拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_ABCPAYFAST, "农业锟斤拷锟叫匡拷锟街э拷锟�");
		tmp.put(PAYMETHOD_ABCWAPPAYFAST, "农业锟斤拷锟叫匡拷锟絎AP支锟斤拷");
		tmp.put(PAYMETHOD_ABCPOINTPAYFAST, "农业锟斤拷锟叫伙拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_HUAANPAY, "锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_HUAANWAPPAY, "锟斤拷锟斤拷微钱锟斤拷锟街伙拷支锟斤拷");
		tmp.put(PAYMETHOD_ALIAPPPAY, "支锟斤拷锟斤拷App支锟斤拷");
		tmp.put(PAYMETHOD_PAYECOEPAY, "锟斤拷锟斤拷锟街伙拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_SPDCCCPAY, "锟街凤拷锟斤拷锟矫匡拷支锟斤拷");
		tmp.put(PAYMETHOD_SPDCCCWAPPAY, "锟街凤拷锟斤拷锟矫匡拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_GZRCBPAY, "锟斤拷锟斤拷农锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMETHOD_GZRCBWAPPAY, "锟斤拷锟斤拷农锟斤拷锟斤拷锟斤拷WAP支锟斤拷");
		tmp.put(PAYMENTOD_MASAWAPPAY, "锟解卡支锟斤拷");
		
		tmp.put(PAYMETHOD_UNIONAPPPAY, "锟斤拷锟斤拷锟街伙拷APP支锟斤拷");
		tmp.put(PAYMETHOD_APPLEPAY, "苹锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_MSQMWAPPAY, "锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷");
		
		tmp.put(PAYMETHOD_UNIONWAPPAY, "锟斤拷锟斤拷锟街伙拷WAP支锟斤拷");//,,,
		tmp.put(PAYMETHOD_QQAPPPAY, "QQ钱锟斤拷");
		tmp.put(PAYMETHOD_QQTENSCANPAY, "QQ扫锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CCBAPPPAY, "锟斤拷锟斤拷APP支锟斤拷");
		tmp.put(PAYMETHOD_CBHBPAY, "锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CBHBWAPPAY, "锟斤拷锟斤拷锟斤拷锟斤拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_SFAPPPAY, "顺锟斤拷APP支锟斤拷");
		tmp.put(PAYMETHOD_YLCFWAPPAY, "一路锟狡革拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_JDWAPPAY, "锟斤拷锟斤拷锟斤拷锟铰匡拷锟街э拷锟�");
		tmp.put(PAYMETHOD_JDPAY, "锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CCBWAPSECDPAY, "锟斤拷锟斤拷锟剿猴拷支锟斤拷");
		tmp.put(PAYMETHOD_BOCWAPPAYFAST, "锟叫癸拷锟斤拷锟叫匡拷锟街э拷锟�");
		tmp.put(PAYMETHOD_FC99BILLPAY, "锟斤拷钱锟解卡支锟斤拷");
		tmp.put(PAYMETHOD_YYPTPAY, "钱锟斤拷锟狡癸拷支锟斤拷");
		tmp.put(PAYMENTOD_UNICOMWOPAY, "锟斤拷通锟斤拷支锟斤拷");
		tmp.put(PAYMENTOD_MSFPAY, "锟斤拷锟斤拷锟斤拷");
		tmp.put(PAYMENTOD_XIYINPAY, "锟斤拷锟斤拷锟斤拷锟竭ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷平台锟斤拷");
		tmp.put(PAYMENTOD_CMBYWTPAY, "锟斤拷锟斤拷一锟斤拷通");
		tmp.put(PAYMENTOD_WCFWAPPAY, "微锟狡革拷");
		
		tmp.put(PAYMETHOD_CHINATELEAPPPAY, "锟斤拷锟斤拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_CHINATELEWAPPAY, "锟斤拷锟斤拷锟斤拷支锟斤拷WAP");
		tmp.put(PAYMETHOD_SUNINGWAPPAY, "锟斤拷锟斤拷锟阶革拷锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_INTELWAPPAY, "Intel锟斤拷锟街憋拷支锟斤拷");
		tmp.put(PAYMETHOD_SPDCCCB2CPAY, "锟街凤拷B2C锟斤拷锟矫匡拷支锟斤拷");
		tmp.put(PAYMETHOD_SPDCCCB2CWAPPAY, "锟街凤拷B2C锟斤拷锟矫匡拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_FQLPAY, "锟斤拷锟斤拷锟斤拷支锟斤拷PC锟斤拷");
		tmp.put(PAYMETHOD_FQLWAPPAY, "锟斤拷锟斤拷锟斤拷Wap支锟斤拷");
		tmp.put(PAYMETHOD_BOSPAY, "锟较猴拷锟斤拷锟斤拷B2C支锟斤拷");
		tmp.put(PAYMETHOD_BOSWAPPAY, "锟斤拷锟斤拷锟届付");
		
		tmp.put(PAYMETHOD_PINGANBANKPAY, "平锟斤拷支锟斤拷");
		tmp.put(PAYMETHOD_PINGANBANKWAPPAY, "平锟斤拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_PAYECOWAPPAY, "锟斤拷锟斤拷WAP支锟斤拷");
		tmp.put(PAYMETHOD_SPDCCCFASTPAYPAY, "锟街凤拷锟斤拷锟街э拷锟�");

		//锟斤拷锟斤拷使锟矫碉拷支锟斤拷锟斤拷式
		tmp.put(PAYMETHOD_ALIBANKPAY, "支锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷WAP");
		tmp.put(PAYMETHOD_TENPAY, "锟狡革拷通");
		tmp.put(PAYMETHOD_HANDWEBPAY, "锟斤拷锟斤拷WEB");
		tmp.put(PAYMETHOD_HANDWAPPAY, "锟斤拷锟斤拷WAP");		
		//tmp.put(PAYMETHOD_HAOBAIPAY, "锟脚帮拷锟街伙拷锟斤拷-锟酵伙拷锟斤拷");
		//tmp.put(PAYMETHOD_SDOPAY, "盛锟斤拷锟斤拷锟�");
		//tmp.put(PAYMETHOD_IPSPAY, "锟斤拷讯PC锟斤拷-锟斤拷锟矫匡拷支锟斤拷");
		//tmp.put(PAYMETHOD_ALLINPAY, "通锟斤拷");
		//tmp.put(PAYMETHOD_BCWAPPAY_OLD, "锟斤拷通WAP锟斤拷锟较的ｏ拷");
		
		payTextMap = UnmodifiableMap.decorate(tmp);
	}
	
	public static String getPaymethodText(String paymethod){
		if(payTextMap.get(paymethod)!=null) {
            return payTextMap.get(paymethod);
        }
		if(StringUtils.equals("card", paymethod)) {
            return "锟揭伙拷券";
        }
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
		if(StringUtils.isBlank(merchantCode)) {
            return null;
        }
		return merchantPaymethodMap.get(merchantCode);
	}
	
	//---------------------------------------------------------------------------------------
	/**支锟斤拷锟斤拷锟截ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷支锟斤拷*/
	public static final String GATEWAY_CHINAPAY = "chinaPay";
	/**支锟斤拷锟斤拷锟截ｏ拷锟斤拷锟脚固伙拷支锟斤拷*/
	public static final String GATEWAY_CHARGETELECOMPAY = "chargeTelecomPay";
	
	
	
	/**锟教伙拷锟斤拷识锟斤拷chinaPay*/
	public static final String MERCHANT_CHINA2PAY = "china2Pay";
	/**锟教伙拷锟斤拷识锟斤拷chinaPay*/
	public static final String MERCHANT_CHINAPAY = "chinaPay";
	/**锟教伙拷锟斤拷识锟斤拷chinaPay*/
	public static final String MERCHANT_SRCBPAY = "srcbPay";
	

	/**锟斤拷锟叫达拷锟诫：0000锟斤拷什么锟斤拷锟斤拷也锟斤拷锟斤拷锟斤拷*/
	public static final String BANK_NONE = "0000";
	
	/**锟斤拷锟叫达拷锟诫：SRCB锟斤拷锟较猴拷农锟斤拷锟斤拷锟斤拷*/
	public static final String BANK_SRCB = "SRCB";

	//---------------------------------------------------------------------------------------
	/**锟斤拷锟斤拷支锟斤拷锟斤拷源锟斤拷PC*/
	public static final String REQSOURCE_PC = "PC";
	
	/**锟斤拷锟斤拷支锟斤拷锟斤拷源锟斤拷WAP*/
	public static final String REQSOURCE_WAP = "WAP";
	
	/**锟斤拷锟斤拷支锟斤拷锟斤拷源锟斤拷APP*/
	public static final String REQSOURCE_APP = "APP";	
	
}
