/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.constant;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.util.DateUtil;
import com.gewara.util.StringUtil;
import java.sql.Timestamp;

public class OpiUtils {
	public static String getStatusStr(MovieItemVo opi) {
		if (!opi.hasOpenid()) {
			return "本场次未开放购票";
		} else {
			Timestamp curtime = new Timestamp(System.currentTimeMillis());
			if (opi.getPlaytime().before(curtime)) {
				return "本场次已经过时";
			} else {
				String time = DateUtil.format(curtime, "HHmm");
				boolean open = opi.getOpentime().before(curtime) && opi.getClosetime().after(curtime)
						&& opi.getStatus().equals("Y") && StringUtil.between(time, opi.getDayotime(), opi.getDayctime())
						&& opi.getGsellnum().intValue() < opi.getAsellnum().intValue();
				return open ? "售票中"
						: (!opi.getStatus().equals("Y") ? "本场次暂不开放订票"
								: (opi.getOpentime().after(curtime)
										? "本场次" + DateUtil.formatTimestamp(opi.getOpentime()) + "开放订票"
										: (opi.getClosetime().before(curtime) ? "本场次已关闭订票"
												: (opi.getGsellnum().intValue() >= opi.getAsellnum().intValue()
														? "本场次座位已售完"
														: (!StringUtil.between(time, opi.getDayotime(),
																opi.getDayctime())
																		? "本场次只在每天"
																				+ opi.getDayotime().substring(0, 2)
																				+ ":"
																				+ opi.getDayotime().substring(2, 4)
																				+ "~"
																				+ opi.getDayctime().substring(0, 2)
																				+ ":"
																				+ opi.getDayctime().substring(2, 4)
																				+ "开放"
																		: "未知")))));
			}
		}
	}
}