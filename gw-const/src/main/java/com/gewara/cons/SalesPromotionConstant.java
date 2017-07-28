/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import java.util.ArrayList;
import java.util.List;

public class SalesPromotionConstant {
	public static final String APPLY_TAG_MOVIE = "movie";
	public static final String APPLY_TAG_DRAMA = "drama";
	public static final String APPLY_TAG_MALL = "mall";
	public static final String APPLY_TAG_BAOCHANG = "baoChang";
	public static final String APPLY_TAG_GOODS = "goods";
	public static final String APPLY_TAG_GENERAL = "general";
	public static final String APPLY_TAG_GOODSBINDMOBIE = "goodsbindmovie";
	public static final String TAG_MOVIE = "movie";
	public static final String TAG_GOODS = "goods";
	public static final String TAG_DRAMA = "drama";
	public static final String TAG_MALL = "mall";
	public static final String TAG_BAOCHANG = "baoChang";
	public static final String TAG_GOODSBINDMOVIE = "goodsbindmovie";
	public static final String TAG_GENERAL = "general";
	public static final List<String> TAG_LIST = new ArrayList();
	public static final String DISCOUNT_TYPE_PERORDER = "order";
	public static final String DISCOUNT_TYPE_PERTICKET = "uprice";
	public static final String DISCOUNT_TYPE_PERCENT = "percent";
	public static final String DISCOUNT_TYPE_BUYONE_GIVEONE = "one2one";
	public static final String DISCOUNT_TYPE_FIXPRICE = "fprice";
	public static final String DISCOUNT_TYPE_EXPRESSION = "exp";
	public static final String WEBVIEW_SIMPLE_TYPE = "sType";
	public static final String WEBVIEW_SIMPLE_TEXT = "sText";
	public static final String WEBVIEW_SIMPLE_ISHOW = "mpiIsShow";
	public static final String WEBVIEW_SIMPLE_INDEX = "mpiIndex";
	public static final String EXP_MINNUM = "exp_minnum";
	public static final String EXP_MAXNUM = "exp_maxnum";
	public static final String UNCHECKCARDNUM = "unCheckCardnum";
	public static final String ITEM_MAX_SELLNUM = "item_max_sellnum";
	public static final String APP_OPI_SHOW = "app_opi_show";
	public static final String DISCOUNT_PERIOD_A = "A";
	public static final String DISCOUNT_PERIOD_D = "D";
	public static final String DISCOUNT_PERIOD_W = "W";
	public static final String DISCOUNT_PERIOD_DW = "DW";
	public static final String DISCOUNT_PERIOD_M = "M";
	public static final String REBATES_CASH = "Y";
	public static final String REBATES_CARDA = "A";
	public static final String REBATES_CARDC = "C";
	public static final String REBATES_CARDD = "D";
	public static final String REBATES_POINT = "P";
	public static final String OPENTYPE_GEWA = "G";
	public static final String OPENTYPE_WAP = "W";
	public static final String OPENTYPE_PC_WAP = "M";
	public static final String OPENTYPE_PARTNER = "P";
	public static final String OPENTYPE_SPECIAL = "S";
	public static final List<String> OPENTYPELIST;
	public static final String ENABLE = "Y";
	public static final String DISABLE = "N";
	public static final String ENCODE_KEY = "KE3a&h@";
	public static final String VERIFYTYPE_FIXED = "fixed";
	public static final String VERIFYTYPE_ONLYONE = "onlyone";
	public static final String MSG_REENTER_CARD_NO = "reenter_card_no";
	public static final String MSG_CHECK_PAY_METHOD = "check_pay_method";
	public static final String MSG_INPUT_RIGHT_BANK_NO = "input_right_bank_no";
	public static final String MSG_WRONG_BANK_NO = "wrong_bank_no";
	public static final String MSG_NOT_SUPPORT_DISCOUNT = "not_support_discount";
	public static final String SEATTYPE_ALL = "A";
	public static final String SEATTYPE_NORMAL = "N";
	public static final String SEATTYPE_LOVESEAT = "L";

	static {
		TAG_LIST.add("movie");
		TAG_LIST.add("goods");
		TAG_LIST.add("drama");
		TAG_LIST.add("mall");
		TAG_LIST.add("goodsbindmovie");
		TAG_LIST.add("general");
		OPENTYPELIST = new ArrayList();
		OPENTYPELIST.add("S");
		OPENTYPELIST.add("W");
		OPENTYPELIST.add("P");
		OPENTYPELIST.add("G");
		OPENTYPELIST.add("M");
	}
}