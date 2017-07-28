/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.constant;

import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

public abstract class OdiConstant {
	public static final String PREPAY_Y = "Y";
	public static final String PREPAY_N = "N";
	public static final String PREPAY_S = "S";
	public static final String PREPAY_G = "G";
	public static final String PREPAY_T = "T";
	public static final String PREPAY_P = "P";
	public static final String PREPAY_C = "C";
	public static final String STATUS_BOOK = "Y";
	public static final String STATUS_NOBOOK = "N";
	public static final String STATUS_DISCARD = "D";
	public static final String ORDER_NEW = "orderNew";
	public static final Integer MINPOINT = Integer.valueOf(500);
	public static final Integer MAXPOINT = Integer.valueOf(10000);
	public static final List<String> STATUS_LIST = Arrays.asList(new String[] { "Y", "N", "D" });
	public static final int CLOSE_MIN = 60;
	public static final String OPEN_TYPE_SEAT = "seat";
	public static final String OPEN_TYPE_PRICE = "price";
	public static final String TAKEMETHOD_ID = "I";
	public static final String TAKEMETHOD_QUPIAOJI = "A";
	public static final String TAKEMETHOD_KUAIDI = "E";
	public static final String TAKEMETHOD_NUMCODE = "C";
	public static final String ADDORDERQUEUE_LOG_FROM_PC = "PC";
	public static final String ADDORDERQUEUE_LOG_FROM_API = "API";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_PRICE = "priceAndAddOrder";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_SEAT = "seatAndAddOrder";
	public static final List<String> TAKEMETHOD_LIST = Arrays.asList(new String[] { "A", "I", "E", "C" });
	public static final String UNOPENGEWA = "unopengewa";
	public static final String UNSHOWGEWA = "unshowgewa";
	public static final String UNOPENSPECIAL = "unopenspecial";
	public static final String ODIOPTION = "odioption";
	public static final String OPENTOAPP = "app";
	public static final String OPENTOWAP = "wap";
	public static final String OPENTOPC = "pc";
	public static final String OPENTOALL = "all";
	public static final String DPI_OPENSTATUS_INIT = "init";
	public static final String DPI_OPENSTATUS_OPEN = "open";
	public static final String SHOWTYPE_NORMAL = "NORMAL";
	public static final String SHOWTYPE_SPECIAL = "SPECIAL";
	public static final String CHECK_THEATRE_PRICE = "price";
	public static final String CHECK_THEATRE_DISCOUNT = "discount";
	public static final List<String> CHECK_THEATRELIST = Arrays.asList(new String[] { "price", "discount" });
	public static final List<String> SEATTYPE_LIST = Arrays
			.asList(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
					"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
					"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" });
	public static final String SEATTYPE_A = "A";
	public static final double DEFAULT_DISCOUNT = 100.0D;
	public static final int MAX_MINUTS_TICKETS = 15;
	public static final int MAX_BUY = 6;
	public static final int ODI_MAX_BUY = 30;
	public static final int SEND_MSG_3H = 180;
	public static final int SECONDS_SHOW_SEAT = 900;
	public static final int SECONDS_ADDORDER = 300;
	public static final int SECONDS_UPDATE_SEAT = 60;
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;
	public static final String PAUSE_ALL = "ALL";
	public static final String PARTNER_GEWA = "GEWA";
	public static final String PARTNER_GPTBS = "GPTBS";
	public static final String PARTNER_YONGLE = "YONGLE";
	public static final String PARTNER_WP = "WP";
	public static final String PARTNER_DY = "SHOAC";
	public static final String PARTNER_KXMH = "KXMH";
	public static final String DISQUANTITY_DITYPE_G = "G";
	public static final String DISQUANTITY_DITYPE_P = "P";
	public static final String PTYPE_P = "P";
	public static final String PTYPE_Q = "Q";
	public static final String PRICE_FLAG_ORDINARY = "O";
	public static final String PRICE_FLAG_CHARITY = "C";
	public static final String PRICE_FLAG_MEITI = "M";
	public static final String PRICE_ORIGN_INVENTED = "invented";
	public static final String PRICE_ORIGN_ENTITY = "entity";
	public static final String PRICE_OTHERINFO_KEY_SHOWREMARK = "showremark";
	public static final String CORRECT_ADD = "add";
	public static final String CORRECT_ADD_SYS = "add_sys";
	public static final String CORRECT_ADD_REFUND = "add_refund";
	public static final String CORRECT_SUB = "sub";
	public static final String CORRECT_SUB_ORDER = "sub_order";
	public static final String CORRECT_SUB_SYS = "sub_sys";
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String> opentypeTextMap;
	public static final Map<String, String> correctTextMap;
	public static final Map<String, String> showtypeTextMap;
	public static final String IDCARD_N = "N";
	public static final String IDCARD_W = "W";
	public static final String IDCARD_F = "F";

	public static Timestamp getFullPlaytime(Date playdate, String playtime) {
		if (playdate != null && !StringUtils.isBlank(playtime)) {
			String playdatestr = DateUtil.formatDate(playdate);
			String playtimestr = playdatestr + " " + playtime + ":00";
			return DateUtil.parseTimestamp(playtimestr);
		} else {
			return null;
		}
	}

	public static String getUsertype(String usertype) {
		return StringUtils.equals(usertype, "P") ? usertype : (StringUtils.equals(usertype, "C") ? usertype : "");
	}

	static {
		CollectionUtils.unmodifiableCollection(SEATTYPE_LIST);
		HashMap tmp = new HashMap();
		tmp.put("GPTBS", "票务系统");
		tmp.put("GEWA", "格瓦拉");
		tmp.put("YONGLE", "永乐票务");
		tmp.put("WP", "微票票务");
		tmp.put("SHOAC", "东艺票务");
		tmp.put("KXMH", "开心麻花");
		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		HashMap openTextTmp = new HashMap();
		openTextTmp.put("seat", "选座");
		openTextTmp.put("price", "价格");
		opentypeTextMap = MapUtils.unmodifiableMap(openTextTmp);
		HashMap correctTmp = new HashMap();
		correctTmp.put("add_sys", "管理员入库");
		correctTmp.put("add_refund", "退款入库");
		correctTmp.put("sub_order", "订单出库");
		correctTmp.put("sub_sys", "管理员出库");
		correctTextMap = MapUtils.unmodifiableMap(correctTmp);
		HashMap showtypeTmp = new HashMap();
		showtypeTmp.put("NORMAL", "普通");
		showtypeTmp.put("SPECIAL", "特惠");
		showtypeTextMap = MapUtils.unmodifiableMap(showtypeTmp);
	}
}