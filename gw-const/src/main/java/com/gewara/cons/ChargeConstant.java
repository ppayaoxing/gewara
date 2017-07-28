/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import org.apache.commons.lang.StringUtils;

public abstract class ChargeConstant {
	public static final String TYPE_CHARGE = "charge";
	public static final String TYPE_WABI_CHARGE = "wabicharge";
	public static final String TYPE_ORDER = "order";
	public static final String BANKPAY = "bank";
	public static final String WABIPAY = "wabi";
	public static final String USESDNUM = "useSdNum";
	public static final String KEY_CHARGE_VALIDTIME_ = "CHARGE_VALIDTIME_";

	public static boolean isBankPay(String chargetype) {
		return StringUtils.equals(chargetype, "order");
	}
}