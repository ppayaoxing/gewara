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
			return "锟斤拷锟斤拷锟斤拷未锟斤拷锟脚癸拷票";
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		if(opi.getPlaytime().before(curtime)) {
            return "锟斤拷锟斤拷锟斤拷锟窖撅拷锟斤拷时";
        }

		String time = DateUtil.format(curtime, "HHmm");
		boolean open = opi.getOpentime().before(curtime) && opi.getClosetime().after(curtime) 
				&& opi.getStatus().equals(OpiConstant.STATUS_BOOK) 
				&& StringUtil.between(time, opi.getDayotime(), opi.getDayctime())
				&& opi.getGsellnum() < opi.getAsellnum();
		if(open) {
            return "锟斤拷票锟斤拷";
        }
		if(!opi.getStatus().equals(OpiConstant.STATUS_BOOK)) {
            return "锟斤拷锟斤拷锟斤拷锟捷诧拷锟斤拷锟脚讹拷票";
        }
		if(opi.getOpentime().after(curtime)) {
            return "锟斤拷锟斤拷锟斤拷" + DateUtil.formatTimestamp(opi.getOpentime()) + "锟斤拷锟脚讹拷票";
        }
		if(opi.getClosetime().before(curtime)) {
            return "锟斤拷锟斤拷锟斤拷锟窖关闭讹拷票";
        }
		if(opi.getGsellnum() >= opi.getAsellnum()) {
            return "锟斤拷锟斤拷锟斤拷锟斤拷位锟斤拷锟斤拷锟斤拷";
        }
		if(!StringUtil.between(time, opi.getDayotime(), opi.getDayctime())) {
            return "锟斤拷锟斤拷锟斤拷只锟斤拷每锟斤拷" + opi.getDayotime().substring(0, 2) + ":" + opi.getDayotime().substring(2, 4) +
                    "~" + opi.getDayctime().substring(0, 2) + ":" + opi.getDayctime().substring(2, 4) + "锟斤拷锟斤拷";
        }
		return "未知";
	}
}
