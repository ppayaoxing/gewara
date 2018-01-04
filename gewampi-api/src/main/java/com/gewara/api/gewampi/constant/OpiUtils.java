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
			return "������δ���Ź�Ʊ";
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		if(opi.getPlaytime().before(curtime)) {
            return "�������Ѿ���ʱ";
        }

		String time = DateUtil.format(curtime, "HHmm");
		boolean open = opi.getOpentime().before(curtime) && opi.getClosetime().after(curtime) 
				&& opi.getStatus().equals(OpiConstant.STATUS_BOOK) 
				&& StringUtil.between(time, opi.getDayotime(), opi.getDayctime())
				&& opi.getGsellnum() < opi.getAsellnum();
		if(open) {
            return "��Ʊ��";
        }
		if(!opi.getStatus().equals(OpiConstant.STATUS_BOOK)) {
            return "�������ݲ����Ŷ�Ʊ";
        }
		if(opi.getOpentime().after(curtime)) {
            return "������" + DateUtil.formatTimestamp(opi.getOpentime()) + "���Ŷ�Ʊ";
        }
		if(opi.getClosetime().before(curtime)) {
            return "�������ѹرն�Ʊ";
        }
		if(opi.getGsellnum() >= opi.getAsellnum()) {
            return "��������λ������";
        }
		if(!StringUtil.between(time, opi.getDayotime(), opi.getDayctime())) {
            return "������ֻ��ÿ��" + opi.getDayotime().substring(0, 2) + ":" + opi.getDayotime().substring(2, 4) +
                    "~" + opi.getDayctime().substring(0, 2) + ":" + opi.getDayctime().substring(2, 4) + "����";
        }
		return "δ֪";
	}
}
