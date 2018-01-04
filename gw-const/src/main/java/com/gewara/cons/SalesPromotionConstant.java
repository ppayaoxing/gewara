package com.gewara.cons;

import java.util.ArrayList;
import java.util.List;

public class SalesPromotionConstant {
	//折扣可使用的版块SpecialDiscount
	public static final String APPLY_TAG_MOVIE = "movie";
	public static final String APPLY_TAG_DRAMA = "drama";
	public static final String APPLY_TAG_MALL = "mall";
	public static final String APPLY_TAG_BAOCHANG = "baoChang";
	public static final String APPLY_TAG_GOODS = "goods";
	public static final String APPLY_TAG_GENERAL = "general";	//通用，特别复杂的规则使用，设置需程序员配合
	public static final String APPLY_TAG_GOODSBINDMOBIE = "goodsbindmovie";

	
	public static final String TAG_MOVIE = "movie";
	public static final String TAG_GOODS = "goods";
	public static final String TAG_DRAMA = "drama";
	public static final String TAG_MALL = "mall";
	public static final String TAG_BAOCHANG = "baoChang";
	public static final String TAG_GOODSBINDMOVIE = "goodsbindmovie";
	public static final String TAG_GENERAL = "general";	
	public static final List<String> TAG_LIST = new ArrayList<String>();
	static {
		TAG_LIST.add(TAG_MOVIE);
		TAG_LIST.add(TAG_GOODS);
		TAG_LIST.add(TAG_DRAMA);
		TAG_LIST.add(TAG_MALL);
		TAG_LIST.add(TAG_GOODSBINDMOVIE);
		TAG_LIST.add(TAG_GENERAL);
	}
	
	public static final String DISCOUNT_TYPE_PERORDER = "order";			//每笔订单折扣
	public static final String DISCOUNT_TYPE_PERTICKET = "uprice";			//每个物品折扣
	public static final String DISCOUNT_TYPE_PERCENT = "percent";			//订单总额百分比
	public static final String DISCOUNT_TYPE_BUYONE_GIVEONE = "one2one";	//买1送1
	public static final String DISCOUNT_TYPE_FIXPRICE = "fprice";			//fix price统一单价（单价固定）
	public static final String DISCOUNT_TYPE_EXPRESSION = "exp";				//表达式
	
	public static final String WEBVIEW_SIMPLE_TYPE = "sType";   //排片列表显示
	public static final String WEBVIEW_SIMPLE_TEXT = "sText";   //排片列表显示
	public static final String WEBVIEW_SIMPLE_ISHOW = "mpiIsShow";   //是否在排片列表显示
	public static final String WEBVIEW_SIMPLE_INDEX = "mpiIndex";   //排片列表中显示的顺序
	
	public static final String EXP_MINNUM = "exp_minnum";   	//公式中的最小购买数量
	public static final String EXP_MAXNUM = "exp_maxnum";   	//公式中的最大购买数量
	
	public static final String UNCHECKCARDNUM = "unCheckCardnum";	//不校验卡bin（防黄牛使用卡做限制：因为有支付宝和微信，所以可以不做校验）
	public static final String ITEM_MAX_SELLNUM = "item_max_sellnum";//每个场次最多卖出多少个座位
	public static final String APP_OPI_SHOW = "app_opi_show";	// APP 特价场次显示用
	
	public static final String DISCOUNT_PERIOD_A = "A";				//自动的周期
	public static final String DISCOUNT_PERIOD_D = "D";				//自然天
	public static final String DISCOUNT_PERIOD_W = "W";				//自然的周期(一周)
	public static final String DISCOUNT_PERIOD_DW = "DW";			//自然的周期(两周)
	public static final String DISCOUNT_PERIOD_M = "M";				//自然的周期(一个月)
	
	public static final String REBATES_CASH = "Y";		//现金
	public static final String REBATES_CARDA = "A";		//A卡
	public static final String REBATES_CARDC = "C";		//C卡
	public static final String REBATES_CARDD = "D";		//D卡
	public static final String REBATES_POINT = "P";		//积分
	
	public static final String OPENTYPE_GEWA = "G"; 	//GewaPC 
	public static final String OPENTYPE_WAP = "W";		//GewaPC 手机（app+wap）由ptnids限制
	public static final String OPENTYPE_PC_WAP = "M";	//GewaPC + 手机
	public static final String OPENTYPE_PARTNER = "P";	//商家渠道场次开放
	public static final String OPENTYPE_SPECIAL = "S";	//特别设置的才开放
	public static final List<String> OPENTYPELIST = new ArrayList<String>();
	static {
		OPENTYPELIST.add(SalesPromotionConstant.OPENTYPE_SPECIAL);
		OPENTYPELIST.add(SalesPromotionConstant.OPENTYPE_WAP);
		OPENTYPELIST.add(SalesPromotionConstant.OPENTYPE_PARTNER);
		OPENTYPELIST.add(SalesPromotionConstant.OPENTYPE_GEWA);
		OPENTYPELIST.add(SalesPromotionConstant.OPENTYPE_PC_WAP);
	}
	
	public static final String ENABLE = "Y";
	public static final String DISABLE = "N";
	
	
	public static final String ENCODE_KEY = "KE3a&h@";
	
	//电子支付方式
	public static final String VERIFYTYPE_FIXED = "fixed";		//固定码，多人多次重复使用
	public static final String VERIFYTYPE_ONLYONE = "onlyone";	//只用一次

	//配置信息对应key
	public static final String MSG_REENTER_CARD_NO = "reenter_card_no";				//当用户输入的卡号不在此次优惠中，提示用户重新输入卡号时，需要提示的信息。
	public static final String MSG_CHECK_PAY_METHOD = "check_pay_method";			//当用户支付方式选择错误时，需要提示的信息。
	public static final String MSG_INPUT_RIGHT_BANK_NO = "input_right_bank_no";		//当用户输入的银行卡号位数不对时，需要提示的信息。
	public static final String MSG_WRONG_BANK_NO = "wrong_bank_no";					//当用户输入的银行卡号错误时，，需要提示的信息。
	public static final String MSG_NOT_SUPPORT_DISCOUNT = "not_support_discount";	//当用户输入的卡号不在此次优惠中，需要提示的信息。
	
	public static final String SEATTYPE_ALL = "A";		// 所有座位（特价活动适用的座位类型）
	public static final String SEATTYPE_NORMAL = "N";	// 普通座位（非情侣座）
	public static final String SEATTYPE_LOVESEAT = "L";	// 情侣座
	
}
