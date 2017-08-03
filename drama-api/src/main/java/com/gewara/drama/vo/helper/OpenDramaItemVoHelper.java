package com.gewara.drama.vo.helper;

import org.apache.commons.lang.StringUtils;

import com.gewara.drama.vo.OpenDramaItemVo;

public abstract class OpenDramaItemVoHelper {

	public static boolean hasOpenCardPay(OpenDramaItemVo item){
		return notNullOpenDramaItemVo(item) 
				&& StringUtils.containsAny(item.getElecard(), "ABD");
	}
	
	private static boolean notNullOpenDramaItemVo(OpenDramaItemVo item){
		if(item == null){
			return false;
		}
		return true;
	}
	
	public static boolean hasDisCountPay(OpenDramaItemVo item){
		return notNullOpenDramaItemVo(item) 
				&& StringUtils.contains(item.getElecard(), "M");
	}
	
	public static boolean hasOpenPointPay(OpenDramaItemVo item){
		return notNullOpenDramaItemVo(item) 
				&&  item.getMaxpoint() !=null && item.getMaxpoint() > 0 ;
	}
	
	public static boolean hasDiscount(OpenDramaItemVo item){
		return hasOpenPointPay(item) || hasDisCountPay(item) || hasOpenCardPay(item);
	}
}
