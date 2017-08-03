package com.gewara.api.gewampi.constant;

import java.sql.Timestamp;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.cons.OpiConstant;
import com.gewara.util.DateUtil;
import com.gewara.util.StringUtil;

public class OpiUtils {
	/**
	 * @param opi
	 * @return
	 */
	public static String getStatusStr(MovieItemVo opi){
		if(!opi.hasOpenid()){
			return "本场次未开放购票";
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		if(opi.getPlaytime().before(curtime)) return "本场次已经过时";

		String time = DateUtil.format(curtime, "HHmm");
		boolean open = opi.getOpentime().before(curtime) && opi.getClosetime().after(curtime) 
				&& opi.getStatus().equals(OpiConstant.STATUS_BOOK) 
				&& StringUtil.between(time, opi.getDayotime(), opi.getDayctime())
				&& opi.getGsellnum() < opi.getAsellnum();
		if(open) return "售票中";
		if(!opi.getStatus().equals(OpiConstant.STATUS_BOOK)) return "本场次暂不开放订票";
		if(opi.getOpentime().after(curtime)) return "本场次" + DateUtil.formatTimestamp(opi.getOpentime()) + "开放订票";
		if(opi.getClosetime().before(curtime)) return "本场次已关闭订票";
		if(opi.getGsellnum() >= opi.getAsellnum()) return "本场次座位已售完";
		if(!StringUtil.between(time, opi.getDayotime(), opi.getDayctime())) 
			return "本场次只在每天" + opi.getDayotime().substring(0,2) + ":" + opi.getDayotime().substring(2,4) + 
				"~" + opi.getDayctime().substring(0,2) + ":" + opi.getDayctime().substring(2,4) + "开放";
		return "未知";
	}
}
