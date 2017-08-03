package com.gewara.drama.constant;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.gewara.util.DateUtil;

public abstract class OdiConstant {
	
	public static final String PREPAY_Y = "Y";		//预售订单
	public static final String PREPAY_N = "N";		//非预售订单
	public static final String PREPAY_S = "S";		//来宾订单
	public static final String PREPAY_G = "G";		//演出抢票
	public static final String PREPAY_T = "T";		//演出团销
	public static final String PREPAY_P = "P";		//演出特惠票
	public static final String PREPAY_C = "C";		//CRM商户

	public static final String STATUS_BOOK = "Y"; // 接受预订
	public static final String STATUS_NOBOOK = "N"; // 不接受预订
	public static final String STATUS_DISCARD = "D"; // 废弃
	
	public static final String ORDER_NEW = "orderNew";
	
	public static final Integer MINPOINT = 500;
	public static final Integer MAXPOINT = 10000;
	
	public static final List<String> STATUS_LIST = Arrays.asList(STATUS_BOOK, STATUS_NOBOOK, STATUS_DISCARD);
	
	public static final int CLOSE_MIN = 60; // 提前关闭时间
	public static final String OPEN_TYPE_SEAT = "seat";
	public static final String OPEN_TYPE_PRICE = "price";
	
	public static final String TAKEMETHOD_ID = "I";			//身份证电子票
	public static final String TAKEMETHOD_QUPIAOJI = "A";	//电子票
	public static final String TAKEMETHOD_KUAIDI = "E";		//快递
	public static final String TAKEMETHOD_NUMCODE = "C";		//数字二维码
	
	public static final String ADDORDERQUEUE_LOG_FROM_PC = "PC";
	public static final String ADDORDERQUEUE_LOG_FROM_API = "API";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_PRICE = "priceAndAddOrder";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_SEAT = "seatAndAddOrder";
	
	public static final List<String> TAKEMETHOD_LIST = Arrays.asList(TAKEMETHOD_QUPIAOJI, TAKEMETHOD_ID, TAKEMETHOD_KUAIDI, TAKEMETHOD_NUMCODE);
	
	public static final String UNOPENGEWA = "unopengewa";					//场次不对格瓦拉开放
	public static final String UNSHOWGEWA = "unshowgewa";					//场次不对格瓦拉显示
	public static final String UNOPENSPECIAL = "unopenspecial";			//场次不对特惠用户开放
	
	public static final String ODIOPTION = "odioption";					//场次购票限制
	public static final String OPENTOAPP = "app";							//对app开放
	public static final String OPENTOWAP = "wap";							//对wap开放
	public static final String OPENTOPC	= "pc";								//对pc开放
	public static final String OPENTOALL	= "all";							//对所有开放
	
	public static final String DPI_OPENSTATUS_INIT = "init";
	public static final String DPI_OPENSTATUS_OPEN = "open";
	
	public static final String SHOWTYPE_NORMAL = "NORMAL";		//
	public static final String SHOWTYPE_SPECIAL = "SPECIAL";		//
	
	public static final String CHECK_THEATRE_PRICE = "price";
	public static final String CHECK_THEATRE_DISCOUNT = "discount";
	public static final List<String> CHECK_THEATRELIST = Arrays.asList(CHECK_THEATRE_PRICE, CHECK_THEATRE_DISCOUNT);
	
	public static final List<String> SEATTYPE_LIST;
	public static final String SEATTYPE_A = "A";
	public static final double DEFAULT_DISCOUNT = 100.0;
	
	public static final int MAX_MINUTS_TICKETS = 15;
	
	public static final int MAX_BUY = 6;					//每单最多购票数量
	public static final int ODI_MAX_BUY = 30;				//场次每单最多购票数量
	public static final int SEND_MSG_3H = 180;				//提醒短信时间(分钟)
	
	//座位图刷新频率
	public static final int SECONDS_SHOW_SEAT = 900;		//显示座位图，20分钟
	public static final int SECONDS_ADDORDER = 300;		//下单，5分钟
	public static final int SECONDS_UPDATE_SEAT = 60;		//更新，1分钟
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;		//更新，10秒
	
	public static final String PAUSE_ALL = "ALL";				//关闭所有合作商
	public static final String PARTNER_GEWA = "GEWA";		
	public static final String PARTNER_GPTBS = "GPTBS";		//开放类型：与票务系统对接
	public static final String PARTNER_YONGLE = "YONGLE";		//开放类型：与永乐票务系统对接
	public static final String PARTNER_WP = "WP";			//开放类型：与微票系统对接
	public static final String PARTNER_DY = "SHOAC";		//开放类型：与东艺系统对接
	public static final String PARTNER_KXMH = "KXMH";		//开放类型：与开心麻花对接
	
	public static final String DISQUANTITY_DITYPE_G = "G";	//优惠类型 G(格瓦拉的优惠)
	public static final String DISQUANTITY_DITYPE_P = "P";  //优惠类型 P(主办方优惠)
	
	public static final String PTYPE_P = "P";
	public static final String PTYPE_Q = "Q";
	
	public static final String PRICE_FLAG_ORDINARY = "O";		//普通票
	public static final String PRICE_FLAG_CHARITY = "C";		//公益票
	public static final String PRICE_FLAG_MEITI = "M";			//媒体票
	
	public static final String PRICE_ORIGN_INVENTED = "invented";	//虚拟
	public static final String PRICE_ORIGN_ENTITY = "entity";		//实物
	
	public static final String PRICE_OTHERINFO_KEY_SHOWREMARK = "showremark";		//选座是否展示remark信息
	
	public static final String CORRECT_ADD = "add";					
	public static final String CORRECT_ADD_SYS = "add_sys";			//管理员操作
	public static final String CORRECT_ADD_REFUND = "add_refund";	//退款增加
	public static final String CORRECT_SUB = "sub";
	public static final String CORRECT_SUB_ORDER = "sub_order";		//订单减少
	public static final String CORRECT_SUB_SYS = "sub_sys";			//管理员减少
	
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String>	opentypeTextMap;
	public static final Map<String, String> correctTextMap;
	public static final Map<String, String> showtypeTextMap;
	
	public static final String IDCARD_N = "N";	//下单是否使用身份证:无
	public static final String IDCARD_W = "W";	//下单是否使用身份证:身份证验证	
	public static final String IDCARD_F = "F";	//下单是否使用身份证:实名制验证
	
	static{
		SEATTYPE_LIST = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
						,"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		CollectionUtils.unmodifiableCollection(SEATTYPE_LIST);
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(PARTNER_GPTBS, "票务系统");
		tmp.put(PARTNER_GEWA, "格瓦拉");
		tmp.put(PARTNER_YONGLE, "永乐票务");
		tmp.put(PARTNER_WP, "微票票务");
		tmp.put(PARTNER_DY, "东艺票务");
		tmp.put(PARTNER_KXMH, "开心麻花");
		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		Map<String, String> openTextTmp = new HashMap<String, String>();
		openTextTmp.put(OPEN_TYPE_SEAT, "选座");
		openTextTmp.put(OPEN_TYPE_PRICE, "价格");
		opentypeTextMap = MapUtils.unmodifiableMap(openTextTmp);
		Map<String, String> correctTmp = new HashMap<String, String>();
		correctTmp.put(CORRECT_ADD_SYS, "管理员入库");
		correctTmp.put(CORRECT_ADD_REFUND, "退款入库");
		correctTmp.put(CORRECT_SUB_ORDER, "订单出库");
		correctTmp.put(CORRECT_SUB_SYS, "管理员出库");
		correctTextMap = MapUtils.unmodifiableMap(correctTmp);
		Map<String, String> showtypeTmp = new HashMap<String, String>();
		showtypeTmp.put(SHOWTYPE_NORMAL, "普通");
		showtypeTmp.put(SHOWTYPE_SPECIAL, "特惠");
		showtypeTextMap = MapUtils.unmodifiableMap(showtypeTmp);
	}
	
	
	public static Timestamp getFullPlaytime(Date playdate, String playtime){
		if(playdate == null || StringUtils.isBlank(playtime)) return null;
		String playdatestr = DateUtil.formatDate(playdate);
		String playtimestr = playdatestr + " " + playtime + ":00";
		return DateUtil.parseTimestamp(playtimestr);
	}
	
	public static String getUsertype(String usertype){
		if(StringUtils.equals(usertype, PREPAY_P)){
			return usertype;
		}else if(StringUtils.equals(usertype, PREPAY_C)){
			return usertype;
		}
		return "";
	}
}
