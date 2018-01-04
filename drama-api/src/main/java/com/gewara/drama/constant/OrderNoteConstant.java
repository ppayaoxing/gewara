package com.gewara.drama.constant;

import java.util.Arrays;
import java.util.List;

public abstract class OrderNoteConstant {
	public static String STATUS_P = "P";
	public static String STATUS_R = "R";
	
	public static String RESULT_S = "S";	//已同步
	
	public static final String CONVERTTYPE_INIT = "init";
	public static final String CONVERTTYPE_CONVERT = "convert";
	public static final String CONVERTTYPE_REFUND = "refund";		//退款
	
	public static final String CONVERTTICKET_PEOPLE = "people";		//人工兑换
	public static final String CONVERTTICKET_POS = "pos";				//POS机兑换
	
	public static final List<String> VALID_CONVERTTYPELIST = Arrays.asList(CONVERTTYPE_REFUND, CONVERTTICKET_PEOPLE, CONVERTTICKET_POS); //验证操作类型
	
	
}
