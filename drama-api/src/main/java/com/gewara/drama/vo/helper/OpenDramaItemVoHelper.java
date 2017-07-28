/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.helper;

import com.gewara.drama.vo.OpenDramaItemVo;
import org.apache.commons.lang.StringUtils;

public abstract class OpenDramaItemVoHelper {
	public static boolean hasOpenCardPay(OpenDramaItemVo item) {
		return notNullOpenDramaItemVo(item) && StringUtils.containsAny(item.getElecard(), "ABD");
	}

	private static boolean notNullOpenDramaItemVo(OpenDramaItemVo item) {
		return item != null;
	}

	public static boolean hasDisCountPay(OpenDramaItemVo item) {
		return notNullOpenDramaItemVo(item) && StringUtils.contains(item.getElecard(), "M");
	}

	public static boolean hasOpenPointPay(OpenDramaItemVo item) {
		return notNullOpenDramaItemVo(item) && item.getMaxpoint() != null && item.getMaxpoint().intValue() > 0;
	}

	public static boolean hasDiscount(OpenDramaItemVo item) {
		return hasOpenPointPay(item) || hasDisCountPay(item) || hasOpenCardPay(item);
	}
}