/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
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
	public static final String PAYMETHOD_UNKNOWN = "unknown";
	public static final String PAYMETHOD_GEWAPAY = "gewaPay";
	public static final String PAYMETHOD_FCARDPAY = "fcardPay";
	public static final String PAYMETHOD_SYSPAY = "sysPay";
	public static final String PAYMETHOD_ELECARDPAY = "elecardPay";
	public static final String PAYMETHOD_GEWARA_OFFLINEPAY = "offlinePay";
	public static final String PAYMETHOD_CHARGECARD = "ccardPay";
	public static final String PAYMETHOD_LAKALA = "lakalaPay";
	public static final String PAYMETHOD_ABCBANKPAY = "abcPay";
	public static final String PAYMETHOD_WCANPAY = "wcanPay";
	public static final String PAYMETHOD_PARTNERPAY = "partnerPay";
	public static final String PAYMETHOD_OKCARDPAY = "okcardPay";
	public static final String PAYMETHOD_SPSDOPAY1 = "spsdoPay";
	public static final String PAYMETHOD_ALIPAY = "directPay";
	public static final String PAYMETHOD_PNRPAY = "pnrPay";
	public static final String PAYMETHOD_CMPAY = "cmPay";
	public static final String PAYMETHOD_TEMPUSPAY = "tempusPay";
	public static final String PAYMETHOD_SPSDOPAY2 = "spsdo2Pay";
	public static final String PAYMETHOD_CHINAPAY1 = "chinaPay";
	public static final String PAYMETHOD_CHINAPAY2 = "china2Pay";
	public static final String PAYMETHOD_CHINAPAYSRCB = "srcbPay";
	public static final String PAYMETHOD_UNIONPAY = "unionPay";
	public static final String PAYMETHOD_UNIONPAY_JS = "unionPay_js";
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY = "unionPay_activity";
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY_JS = "unionPay_activity_js";
	public static final String PAYMETHOD_UNIONPAY_ZJ = "unionPay_zj";
	public static final String PAYMETHOD_UNIONPAY_SZ = "unionPay_sz";
	public static final String PAYMETHOD_UNIONPAY_BJ = "unionPay_bj";
	public static final String PAYMETHOD_UNIONPAY_GZ = "unionPay_gz";
	public static final String PAYMETHOD_UNIONPAYFAST = "unionPayFast";
	public static final String PAYMETHOD_BCPAY = "bcPay";
	public static final String PAYMETHOD_SPDPAY = "spdPay";
	public static final String PAYMETHOD_CMBPAY = "cmbPay";
	public static final String PAYMETHOD_GDBPAY = "gdbPay";
	public static final String PAYMETHOD_GDB_UNION_PAY = "gdbUnionPay";
	public static final String PAYMETHOD_PSBCPAY = "psbcPay";
	public static final String PAYMETHOD_HZBANKPAY = "hzbankPay";
	public static final String PAYMETHOD_JSBCHINA = "jsbChina";
	public static final String PAYMETHOD_SPDPAY_ACTIVITY = "spdPay_activity";
	public static final String PAYMETHOD_BOCPAY = "bocPay";
	public static final String PAYMETHOD_BOCWAPPAY = "bocWapPay";
	public static final String PAYMETHOD_BOCAGRMTPAY = "bocAgrmtPay";
	public static final String PAYMETHOD_UMPAY = "umPay";
	public static final String PAYMETHOD_UMPAY_SH = "umPay_sh";
	public static final String PAYMETHOD_TELECOM = "telecomPay";
	public static final String PAYMETHOD_MOBILE_TELECOM = "telecomMobilePay";
	public static final String PAYMETHOD_YAGAO = "yagaoPay";
	public static final String PAYMETHOD_ONETOWN = "onetownPay";
	public static final String PAYMETHOD_ALIWAPPAY = "aliwapPay";
	public static final String PAYMETHOD_CMWAPPAY = "cmwapPay";
	public static final String PAYMETHOD_CMBWAPPAY = "cmbwapPay";
	public static final String PAYMETHOD_CMBWAPSTOREPAY = "cmbwapStorePay";
	public static final String PAYMETHOD_SPDWAPPAY = "spdWapPay";
	public static final String PAYMETHOD_CMSMARTPAY = "cmSmartPay";
	public static final String PAYMETHOD_SPDWAPPAY_ACTIVITY = "spdWapPay_activity";
	public static final String PAYMETHOD_CHINASMARTMOBILEPAY = "chinaSmartMobilePay";
	public static final String PAYMETHOD_CHINASMARTJSPAY = "chinaSmartJsPay";
	public static final String PAYMETHOD_ALISMARTMOBILEPAY = "aliSmartMobilePay";
	public static final String PAYMETHOD_HZWAPPAY = "hzwapPay";
	public static final String PAYMETHOD_YEEPAY = "yeePay";
	public static final String PAYMETHOD_PAYECO_DNA = "payecoDNAPay";
	public static final String PAYMETHOD_MEMBERCARDPAY = "memberCardPay";
	public static final String PAYMETHOD_ICBCPAY = "icbcPay";
	public static final String PAYMETHOD_NJCBPAY = "njcbPay";
	public static final String PAYMETHOD_ABCHINAPAY = "abchinaPay";
	public static final String PAYMETHOD_WXAPPTENPAY = "wxAppTenPay";
	public static final String PAYMETHOD_WXAPPPAY = "wxAppPay";
	public static final String PAYMETHOD_WXMPNOPAY = "wxMPNoPay";
	public static final String PAYMETHOD_WXSCANTENPAY = "wxScanTenPay";
	public static final String PAYMETHOD_WXWCPAY = "wxWCPay";
	public static final String PAYMETHOD_CCBWAPPAY = "ccbWapPay";
	public static final String PAYMETHOD_ONECLICKTENPAY = "oneClickTenPay";
	public static final String PAYMETHOD_BESTPAY = "bestPay";
	public static final String PAYMETHOD_BFBWAPPAY = "bfbWapPay";
	public static final String PAYMETHOD_BFBPAY = "bfbPay";
	public static final String PAYMETHOD_ALISCANPAY = "aliScanPay";
	public static final String PAYMETHOD_CCBMBCPAY = "ccbMBCPay";
	public static final String PAYMETHOD_BCWAPPAY = "bcWapPay";
	public static final String PAYMETHOD_BOCWAPV2PAY = "bocWapV2Pay";
	public static final String PAYMETHOD_UNIONWAPPAYFAST = "unionWapPayFast";
	public static final String PAYMETHOD_ICBCWAPPAY = "icbcWapPay";
	public static final String PAYMETHOD_ALITVPAY = "aliTvPay";
	public static final String PAYMETHOD_WEIBOPAY = "weiboPay";
	public static final String PAYMETHOD_PINGAN1QBPAY = "pingan1qbPay";
	public static final String PAYMETHOD_CHUBAOPAY = "chubaoPay";
	public static final String PAYMETHOD_BJRCBPAY = "bjrcbPay";
	public static final String PAYMETHOD_ABCPAYFAST = "abcPayFast";
	public static final String PAYMETHOD_ABCWAPPAYFAST = "abcWapPayFast";
	public static final String PAYMETHOD_ABCPOINTPAYFAST = "abcPointPayFast";
	public static final String PAYMETHOD_HUAANPAY = "huaanPay";
	public static final String PAYMETHOD_HUAANWAPPAY = "huaanWapPay";
	public static final String PAYMETHOD_ALIAPPPAY = "aliAppPay";
	public static final String PAYMETHOD_PAYECOEPAY = "payecoEPay";
	public static final String PAYMETHOD_UNIONAPPPAY = "unionAppPay";
	public static final String PAYMETHOD_APPLEPAY = "applePay";
	public static final String PAYMETHOD_UNIONWAPPAY = "unionWapPay";
	public static final String PAYMETHOD_QQAPPPAY = "qqAppPay";
	public static final String PAYMETHOD_QQTENSCANPAY = "qqTenScanPay";
	public static final String PAYMETHOD_SPDCCCPAY = "spdcccPay";
	public static final String PAYMETHOD_SPDCCCWAPPAY = "spdcccWapPay";
	public static final String PAYMETHOD_CCBAPPPAY = "ccbAppPay";
	public static final String PAYMETHOD_CBHBPAY = "cbhbPay";
	public static final String PAYMETHOD_CBHBWAPPAY = "cbhbWapPay";
	public static final String PAYMETHOD_SFAPPPAY = "sfAppPay";
	public static final String PAYMETHOD_WLTWAPPAY = "wltWapPay";
	public static final String PAYMETHOD_YLCFWAPPAY = "ylcfWapPay";
	public static final String PAYMETHOD_JDWAPPAY = "jdWapPay";
	public static final String PAYMETHOD_JDPAY = "jdPay";
	public static final String PAYMETHOD_CCBWAPSECDPAY = "ccbWapSecdPay";
	public static final String PAYMETHOD_BOCWAPPAYFAST = "bocWapPayFast";
	public static final String PAYMETHOD_FC99BILLPAY = "foreignCard99billPay";
	public static final String PAYMETHOD_GZRCBPAY = "gzrcbPay";
	public static final String PAYMETHOD_GZRCBWAPPAY = "gzrcbWapPay";
	public static final String PAYMETHOD_CHINATELEAPPPAY = "chinaTeleAppPay";
	public static final String PAYMETHOD_CHINATELEWAPPAY = "chinaTeleWapPay";
	public static final String PAYMETHOD_SUNINGWAPPAY = "suningWapPay";
	public static final String PAYMETHOD_INTELWAPPAY = "intelWapPay";
	public static final String PAYMETHOD_SPDCCCB2CPAY = "spdcccB2cPay";
	public static final String PAYMETHOD_SPDCCCB2CWAPPAY = "spdcccB2cWapPay";
	public static final String PAYMETHOD_FQLPAY = "fqlPay";
	public static final String PAYMETHOD_FQLWAPPAY = "fqlWapPay";
	public static final String PAYMETHOD_BOSPAY = "bosPay";
	public static final String PAYMETHOD_BOSWAPPAY = "bosWapPay";
	public static final String PAYMETHOD_PINGANBANKPAY = "pinganBankPay";
	public static final String PAYMETHOD_PINGANBANKWAPPAY = "pinganBankWapPay";
	public static final String PAYMETHOD_PAYECOWAPPAY = "payecoWapPay";
	public static final String PAYMETHOD_MSQMWAPPAY = "msqmWapPay";
	public static final String PAYMETHOD_SPDCCCFASTPAYPAY = "spdcccFastPay";
	public static final String PAYMETHOD_BCOMCCFASTPAYPAY = "bcomccFastPay";
	public static final String PAYMENTOD_MASAWAPPAY = "masaWapPay";
	public static final String PAYMETHOD_TENPAY = "tenPay";
	public static final String PAYMETHOD_ALIBANKPAY = "alibankPay";
	public static final String PAYMETHOD_HANDWAPPAY = "handwapPay";
	public static final String PAYMETHOD_HANDWEBPAY = "handwebPay";
	public static final String PAYMETHOD_PNRFASTPAY = "pnrfastPay";
	public static final String PAYMETHOD_PNRFASTPAY2 = "pnrfastPay2";
	public static final String PAYMETHOD_PNRFASTABCPAY = "pnrfastabcPay";
	public static final String PAYMETHOD_YYPTPAY = "yyptPay";
	public static final String PAYMENTOD_UNICOMWOPAY = "unicomWoPay";
	public static final String PAYMENTOD_MSFPAY = "msfPay";
	public static final String PAYMETHOD_MERCHANTPAY = "merchantPay";
	public static final String PAYMENTOD_XIYINPAY = "xiyinPay";
	public static final String PAYMENTOD_CMBYWTPAY = "cmbywtPay";
	public static final String PAYMENTOD_WCFWAPPAY = "wcfWapPay";
	public static final List<String> PAYMETHOD_LIST = Arrays.asList(new String[] { "gewaPay", "fcardPay", "ccardPay",
			"pnrPay", "directPay", "aliwapPay", "alibankPay", "lakalaPay", "ccbWapSecdPay", "chinaPay", "china2Pay",
			"srcbPay", "okcardPay", "tenPay", "partnerPay", "spsdoPay", "spsdo2Pay", "cmPay", "yagaoPay", "onetownPay",
			"handwebPay", "handwapPay", "cmbPay", "cmbwapPay", "bcPay", "gdbPay", "gdbUnionPay", "elecardPay", "sysPay",
			"cmwapPay", "chinaSmartMobilePay", "chinaSmartJsPay", "aliSmartMobilePay", "umPay", "umPay_sh", "spdPay",
			"spdPay_activity", "psbcPay", "spdWapPay", "spdWapPay_activity", "hzbankPay", "abcPay", "wcanPay",
			"unionPay", "telecomPay", "telecomMobilePay", "jsbChina", "tempusPay", "pnrfastPay", "pnrfastPay2",
			"yeePay", "cmSmartPay", "pnrfastabcPay", "unionPayFast", "bocPay", "bocWapPay", "bocAgrmtPay", "hzwapPay",
			"payecoDNAPay", "memberCardPay", "icbcPay", "cmbwapStorePay", "njcbPay", "abchinaPay", "wxAppTenPay",
			"wxAppPay", "wxScanTenPay", "ccbWapPay", "wxWCPay", "oneClickTenPay", "bestPay", "bfbWapPay", "offlinePay",
			"bfbPay", "aliScanPay", "ccbMBCPay", "bcWapPay", "bocWapV2Pay", "unionWapPayFast", "icbcWapPay", "aliTvPay",
			"weiboPay", "pingan1qbPay", "chubaoPay", "bjrcbPay", "abcPayFast", "abcPointPayFast", "huaanPay",
			"huaanWapPay", "aliAppPay", "payecoEPay", "wxMPNoPay", "unionAppPay", "unionWapPay", "qqAppPay",
			"qqTenScanPay", "spdcccPay", "spdcccWapPay", "ccbAppPay", "cbhbPay", "cbhbWapPay", "abcWapPayFast",
			"sfAppPay", "wltWapPay", "ylcfWapPay", "jdWapPay", "jdPay", "bocWapPayFast", "foreignCard99billPay",
			"gzrcbPay", "gzrcbWapPay", "chinaTeleAppPay", "suningWapPay", "intelWapPay", "spdcccB2cPay",
			"spdcccB2cWapPay", "fqlPay", "fqlWapPay", "bosPay", "bosWapPay", "pinganBankPay", "pinganBankWapPay",
			"payecoWapPay", "chinaTeleWapPay", "applePay", "msqmWapPay", "spdcccFastPay", "bcomccFastPay", "yyptPay",
			"unicomWoPay", "msfPay", "xiyinPay", "masaWapPay", "cmbywtPay", "wcfWapPay" });
	public static final List<String> MOBILE_PAYMETHOD_LIST = Arrays.asList(new String[] { "aliwapPay", "cmwapPay",
			"cmbwapPay", "cmbwapStorePay", "spdWapPay", "cmSmartPay", "spdWapPay_activity", "chinaSmartMobilePay",
			"chinaSmartJsPay", "bocWapPay", "fcardPay", "aliSmartMobilePay", "hzwapPay", "wxAppTenPay", "ccbWapPay",
			"wxWCPay", "oneClickTenPay", "bfbWapPay", "ccbMBCPay", "bcWapPay", "bocWapV2Pay", "unionWapPayFast",
			"icbcWapPay", "aliTvPay", "weiboPay", "pingan1qbPay", "chubaoPay", "huaanWapPay", "aliAppPay", "payecoEPay",
			"wxMPNoPay", "unionAppPay", "unionWapPay", "qqAppPay", "spdcccWapPay", "ccbAppPay", "cbhbPay", "cbhbWapPay",
			"abcWapPayFast", "abcPayFast", "ylcfWapPay", "sfAppPay", "wltWapPay", "abchinaPay", "jdWapPay",
			"ccbWapSecdPay", "bocWapPayFast", "gzrcbWapPay", "chinaTeleAppPay", "suningWapPay", "intelWapPay",
			"spdcccB2cWapPay", "fqlWapPay", "bosWapPay", "pinganBankWapPay", "payecoWapPay", "chinaTeleWapPay",
			"applePay", "msqmWapPay", "spdcccFastPay", "yyptPay", "unicomWoPay", "msfPay", "xiyinPay", "masaWapPay",
			"cmbywtPay", "wcfWapPay" });
	public static final List<String> PARTNER_PAYMETHOD_LIST = Arrays
			.asList(new String[] { "partnerPay", "okcardPay", "spsdoPay" });
	private static Map<String, String> payTextMap;
	private static Map<String, String> merchantPaymethodMap;
	public static final String GATEWAY_CHINAPAY = "chinaPay";
	public static final String GATEWAY_CHARGETELECOMPAY = "chargeTelecomPay";
	public static final String MERCHANT_CHINA2PAY = "china2Pay";
	public static final String MERCHANT_CHINAPAY = "chinaPay";
	public static final String MERCHANT_SRCBPAY = "srcbPay";
	public static final String BANK_NONE = "0000";
	public static final String BANK_SRCB = "SRCB";
	public static final String REQSOURCE_PC = "PC";
	public static final String REQSOURCE_WAP = "WAP";
	public static final String REQSOURCE_APP = "APP";

	public static String getPaymethodText(String paymethod) {
		return payTextMap.get(paymethod) != null ? (String) payTextMap.get(paymethod)
				: (StringUtils.equals("card", paymethod) ? "兑换券" : "未知");
	}

	public static final boolean isValidPayMethod(String paymethod) {
		return StringUtils.isNotBlank(paymethod) && PAYMETHOD_LIST.contains(paymethod);
	}

	public static Map<String, String> getPayTextMap() {
		return payTextMap;
	}

	public static String getPaymethodByMercdoe(String merchantCode) {
		return StringUtils.isBlank(merchantCode) ? null : (String) merchantPaymethodMap.get(merchantCode);
	}

	static {
		LinkedHashMap tmp = new LinkedHashMap();
		tmp.put("sysPay", "系统");
		tmp.put("gewaPay", "格瓦余额");
		tmp.put("fcardPay", "点卡支付");
		tmp.put("elecardPay", "电子券");
		tmp.put("offlinePay", "后台下线支付");
		tmp.put("ccardPay", "格瓦充值卡");
		tmp.put("lakalaPay", "拉卡拉");
		tmp.put("abcPay", "农行合作");
		tmp.put("wcanPay", "微能科技积分兑换");
		tmp.put("pnrPay", "汇付天下PC端");
		tmp.put("directPay", "支付宝PC端");
		tmp.put("cmPay", "移动手机支付PC端");
		tmp.put("chinaPay", "银联便民");
		tmp.put("china2Pay", "ChinapayPC端");
		tmp.put("spsdo2Pay", "盛付通PC端");
		tmp.put("payecoDNAPay", "易联DNA支付");
		tmp.put("cmbPay", "招行直连PC端");
		tmp.put("cmbwapPay", "招行直连手机端");
		tmp.put("cmbwapStorePay", "招行手机端-STORE");
		tmp.put("bcPay", "交行直连PC端");
		tmp.put("gdbPay", "广发直连PC端");
		tmp.put("gdbUnionPay", "广发银联直连PC端");
		tmp.put("bocPay", "中国银行直连PC端");
		tmp.put("bocAgrmtPay", "中国银行协议支付");
		tmp.put("spdPay", "浦发直连PC端");
		tmp.put("spdPay_activity", "浦发直连PC端-活动");
		tmp.put("spdWapPay_activity", "浦发直连手机端-活动");
		tmp.put("psbcPay", "邮储直连PC端");
		tmp.put("hzbankPay", "杭州银行");
		tmp.put("hzwapPay", "杭州银行WAP");
		tmp.put("jsbChina", "江苏银行直连PC端-信用卡");
		tmp.put("tempusPay", "腾付通PC端");
		tmp.put("yeePay", "易宝支付PC端");
		tmp.put("icbcPay", "工商银行直连支付PC端");
		tmp.put("njcbPay", "南京银行直连支付PC端");
		tmp.put("abchinaPay", "农业银行直连支付PC端");
		tmp.put("aliwapPay", "支付宝手机端-WAP支付");
		tmp.put("bocWapPay", "中国银行直连WAP端");
		tmp.put("cmwapPay", "移动手机支付手机端-WAP支付");
		tmp.put("spdWapPay", "浦发直连手机端-WAP");
		tmp.put("chinaSmartMobilePay", "银联手机在线支付");
		tmp.put("chinaSmartJsPay", "江苏银联手机端-江苏银商收单");
		tmp.put("aliSmartMobilePay", "支付宝手机端-安全支付");
		tmp.put("cmSmartPay", "移动手机支付安卓版");
		tmp.put("unionPay", "unionPay银联支付");
		tmp.put("unionPay_js", "unionPay江苏");
		tmp.put("unionPay_activity", "unionPay活动");
		tmp.put("unionPay_activity_js", "unionPay江苏活动");
		tmp.put("unionPay_zj", "unionPay浙江");
		tmp.put("unionPay_sz", "unionPay深圳");
		tmp.put("unionPay_bj", "unionPay北京");
		tmp.put("unionPay_gz", "unionPay广州");
		tmp.put("unionPayFast", "unionPayFast银联快捷支付");
		tmp.put("pnrfastPay", "汇付快捷支付--华夏信用卡");
		tmp.put("pnrfastPay2", "汇付快捷支付--建行信用卡");
		tmp.put("pnrfastabcPay", "汇付快捷支付--农行信用卡");
		tmp.put("telecomPay", "电信固话话费支付");
		tmp.put("telecomMobilePay", "电信手机话费支付");
		tmp.put("umPay", "移动话费支付(联动优势)");
		tmp.put("umPay_sh", "移动话费支付(联动优势)_上海");
		tmp.put("yagaoPay", "雅高卡支付(艾登瑞德)");
		tmp.put("onetownPay", "一城卡支付(新华传媒)");
		tmp.put("partnerPay", "合作商");
		tmp.put("okcardPay", "联华OK");
		tmp.put("spsdoPay", "盛大合作");
		tmp.put("srcbPay", "Chinapay农商行");
		tmp.put("memberCardPay", "会员卡支付");
		tmp.put("wxAppTenPay", "财付通微信支付（App间支付）");
		tmp.put("wxAppPay", "微信客户端支付");
		tmp.put("wxScanTenPay", "财付通微信支付（WEB扫码）");
		tmp.put("wxWCPay", "微信公众号支付");
		tmp.put("wxMPNoPay", "微信公众号JS支付");
		tmp.put("ccbWapPay", "建行手机wap支付");
		tmp.put("oneClickTenPay", "财付通移动终端一键支付");
		tmp.put("bestPay", "翼支付");
		tmp.put("bfbWapPay", "百度钱包wap支付");
		tmp.put("bfbPay", "百度钱包支付");
		tmp.put("aliScanPay", "支付宝扫码支付");
		tmp.put("ccbMBCPay", "建行手机银行支付");
		tmp.put("bcWapPay", "交行Wap支付");
		tmp.put("bocWapV2Pay", "中国银行直连WAP支付（V2）");
		tmp.put("unionWapPayFast", "银联无卡WAP支付");
		tmp.put("icbcWapPay", "工银e支付");
		tmp.put("aliTvPay", "阿里TV支付");
		tmp.put("weiboPay", "微博支付");
		tmp.put("pingan1qbPay", "平安壹钱包支付");
		tmp.put("chubaoPay", "触宝支付");
		tmp.put("bjrcbPay", "北京农商银行支付");
		tmp.put("abcPayFast", "农业银行快捷支付");
		tmp.put("abcWapPayFast", "农业银行快捷WAP支付");
		tmp.put("abcPointPayFast", "农业银行积分支付");
		tmp.put("huaanPay", "华安基金支付");
		tmp.put("huaanWapPay", "华安微钱宝手机支付");
		tmp.put("aliAppPay", "支付宝App支付");
		tmp.put("payecoEPay", "易联手机WAP支付");
		tmp.put("spdcccPay", "浦发信用卡支付");
		tmp.put("spdcccWapPay", "浦发信用卡WAP支付");
		tmp.put("gzrcbPay", "广州农商银行");
		tmp.put("gzrcbWapPay", "广州农商银行WAP支付");
		tmp.put("masaWapPay", "外卡支付");
		tmp.put("unionAppPay", "银联手机APP支付");
		tmp.put("applePay", "苹果支付");
		tmp.put("msqmWapPay", "民生齐妙支付");
		tmp.put("unionWapPay", "银联手机WAP支付");
		tmp.put("qqAppPay", "QQ钱包");
		tmp.put("qqTenScanPay", "QQ扫码支付");
		tmp.put("ccbAppPay", "建行APP支付");
		tmp.put("cbhbPay", "渤海银行支付");
		tmp.put("cbhbWapPay", "渤海银行WAP支付");
		tmp.put("sfAppPay", "顺丰APP支付");
		tmp.put("ylcfWapPay", "一路财富WAP支付");
		tmp.put("jdWapPay", "京东旗下快捷支付");
		tmp.put("jdPay", "京东支付");
		tmp.put("ccbWapSecdPay", "建行账号支付");
		tmp.put("bocWapPayFast", "中国银行快捷支付");
		tmp.put("foreignCard99billPay", "快钱外卡支付");
		tmp.put("yyptPay", "钱大掌柜支付");
		tmp.put("unicomWoPay", "联通沃支付");
		tmp.put("msfPay", "民生付");
		tmp.put("xiyinPay", "西银在线（西安银行支付平台）");
		tmp.put("cmbywtPay", "招行一网通");
		tmp.put("wcfWapPay", "微财富");
		tmp.put("chinaTeleAppPay", "电信翼支付");
		tmp.put("chinaTeleWapPay", "电信翼支付WAP");
		tmp.put("suningWapPay", "苏宁易付宝支付");
		tmp.put("intelWapPay", "Intel集分宝支付");
		tmp.put("spdcccB2cPay", "浦发B2C信用卡支付");
		tmp.put("spdcccB2cWapPay", "浦发B2C信用卡WAP支付");
		tmp.put("fqlPay", "分期乐支付PC端");
		tmp.put("fqlWapPay", "分期乐Wap支付");
		tmp.put("bosPay", "上海银行B2C支付");
		tmp.put("bosWapPay", "上银快付");
		tmp.put("pinganBankPay", "平安支付");
		tmp.put("pinganBankWapPay", "平安WAP支付");
		tmp.put("payecoWapPay", "易联WAP支付");
		tmp.put("spdcccFastPay", "浦发快捷支付");
		tmp.put("alibankPay", "支付宝招商银行WAP");
		tmp.put("tenPay", "财付通");
		tmp.put("handwebPay", "翰银WEB");
		tmp.put("handwapPay", "翰银WAP");
		payTextMap = UnmodifiableMap.decorate(tmp);
		tmp = new LinkedHashMap();
		tmp.put("union_jsa", "unionPay_activity_js");
		tmp.put("union_gz", "unionPay_gz");
		tmp.put("union_sh", "unionPay");
		tmp.put("union_sha", "unionPay_activity");
		tmp.put("union_js", "unionPay_js");
		tmp.put("union_zj", "unionPay_zj");
		tmp.put("union_sz", "unionPay_sz");
		tmp.put("union_bj", "unionPay_bj");
		tmp.put("unionfast", "unionPayFast");
		tmp.put("unionfast_bj", "unionPayFast_activity_bj");
		tmp.put("unionfast_js", "unionPayFast_activity_js");
		tmp.put("unionfast_gz", "unionPayFast_activity_gz");
		tmp.put("unionfast_zj", "unionPayFast_activity_zj");
		tmp.put("unionfast_sz", "unionPayFast_activity_sz");
		tmp.put("spd", "spdPay");
		tmp.put("spd_a", "spdPay_activity");
		tmp.put("spdwap", "spdWapPay");
		tmp.put("spdwap_a", "spdWapPay_activity");
		tmp.put("cmbwap", "cmbwapPay");
		tmp.put("cmbstore", "cmbwapStorePay");
		tmp.put("china2Pay", "china2Pay");
		tmp.put("srcbPay", "srcbPay");
		tmp.put("chinaPay", "chinaPay");
		tmp.put("um_sh", "umPay_sh");
		tmp.put("um", "umPay");
		tmp.put("chinasm", "chinaSmartMobilePay");
		tmp.put("chinasm_js", "chinaSmartJsPay");
		merchantPaymethodMap = UnmodifiableMap.decorate(tmp);
	}
}