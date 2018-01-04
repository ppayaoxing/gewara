package com.gewara.cons;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

public class OrderConstant {
	public static final String CHANGEHIS_KEY_CHANGESEAT = "changeSeat";			//锟斤拷锟斤拷锟斤拷位
	public static final String CHANGEHIS_KEY_SUCCESSCHANGE = "successChange";	//锟缴癸拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷位
	public static final String CHANGEHIS_KEY_MPITO = "mpito";					//锟斤拷锟斤拷锟斤拷锟轿碉拷
	public static final String CHANGEHIS_KEY_MPIFROM = "mpifrom";				//锟接筹拷锟斤拷锟斤拷
	public static final String CHANGEHIS_KEY_RECONFIRMS = "reconfirms";			//锟斤拷锟斤拷确锟较讹拷锟斤拷锟斤拷锟斤拷
	public static final String CHANGEHIS_KEY_MOBILE_BUYTIMES = "buytimes";		//锟斤拷锟街伙拷锟斤拷史锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String CHANGEHIS_KEY_MEMBER_BUYTIMES = "mbtimes";		//锟斤拷锟矫伙拷锟斤拷史锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String CHANGEHIS_KEY_PROCESSTIMES = "processtimes";		//锟矫讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	public static final String CHANGEHIS_KEY_PROCESSMSG = "processError";		//
	public static final String CHANGEHIS_KEY_PROCESSCODE = "processCode";		//

	
	public static final String OTHERKEY_CREDENTIALSID = "credentialsId";		//锟教硷拷锟斤拷证ID
	public static final String OTHERKEY_BINDMEMBER = "bindMember";				//锟界话锟铰碉拷锟斤拷锟矫伙拷
	public static final String OTHERKEY_TELEPHONE = "telephone";				//锟界话锟铰碉拷锟斤拷锟斤拷锟界话
	public static final String OTHERKEY_BINDMOBILE = "bindMobile";				//锟界话锟铰碉拷锟斤拷锟街伙拷
	public static final String OTHERKEY_USE_INSURE = "isUseInsure"; 			//锟斤拷锟斤拷使锟斤拷平锟斤拷锟斤拷票锟斤拷锟斤拷
	public static final String OTHERKEY_CREATEMEMBER = "createMember";			//锟界话锟铰碉拷锟角否创斤拷
	public static final String OTHERKEY_DELAY_CARDNO = "delayCardNo";      		//锟斤拷锟斤拷票券锟叫筹拷锟斤拷锟斤拷票券锟斤拷
	public static final String OTHERKEY_TAKEMETHOD_ID = "takemethodID";			//锟斤拷锟街わ拷锟斤拷锟狡�
	public static final String OTHERKEY_CHARITY = "charity";							//锟斤拷锟斤拷票锟斤拷识
	public static final String OTHERKEY_GREETINGS = "greetings";				//锟斤拷锟皆伙拷票锟斤拷
	public static final String OTHERKEY_DISTYPE = "p_distype";						//锟斤拷锟斤拷
	public static final String OTHERKEY_DISCOUNT = "p_discount";					//
	public static final String OTHERKEY_DISAMOUNT = "p_disamount";				
	public static final String OTHERKEY_CARDNO = "cardno";						//锟斤拷锟斤拷票券锟斤拷锟斤拷
	public static final String OTHERKEY_SHARECODE = "sharecode";				//锟斤拷锟斤拷ID
	public static final String OTHERKEY_CONVERTSTATUS = "convertStatus";	//转锟斤拷状态
	public static final String OTHERKEY_EXTERNALORDERNO  = "externalOrderNo";			//锟解部锟斤拷锟斤拷锟斤拷
	public static final String OTHERKEY_COUNTRY_CODE  = "countryCode";			//锟斤拷锟揭憋拷锟斤拷
	public static final String OTHERKEY_CUST_FIRSTNAME  = "firstName";			//锟酵伙拷锟斤拷
	public static final String OTHERKEY_CUST_LASTNAME  = "lastName";			//锟酵伙拷锟斤拷
	public static final String OTHERKEY_CLIENTIP = "clientIp";					//锟酵伙拷IP

	
	public static final String STATUS_NEW = "new";						//锟铰讹拷锟斤拷锟斤拷锟斤拷位锟斤拷锟斤拷锟斤拷
	public static final String STATUS_NEW_UNLOCK = "new_unlock";		//锟铰讹拷锟斤拷锟斤拷未锟斤拷锟斤拷锟斤拷锟斤拷时状态锟斤拷
	public static final String STATUS_NEW_CONFIRM = "new_confirm";		//锟铰讹拷锟斤拷锟斤拷确锟斤拷去锟斤拷锟斤拷
	public static final String STATUS_PAID = "paid";					//锟斤拷锟斤拷睿拷锟斤拷锟轿达拷锟斤拷浅山锟斤拷锟�
	public static final String STATUS_PAID_FAILURE = "paid_failure";	//锟斤拷锟斤拷睿拷锟斤拷锟斤拷写锟斤拷锟�
	public static final String STATUS_PAID_SPECIAL = "paid_special";	//锟斤拷锟斤拷睿拷锟斤拷锟斤拷胁锟斤拷晒锟斤拷锟揭诧拷锟斤拷丝睿拷锟斤拷锟斤拷锟斤拷獯︼拷锟斤拷锟斤拷绮癸拷锟饺�
	public static final String STATUS_PAID_UNFIX = "paid_failure_unfix";//锟斤拷锟斤拷睿拷锟斤拷锟斤拷锟轿晃慈凤拷锟�
	public static final String STATUS_PAID_SUCCESS = "paid_success";	//锟斤拷锟斤拷螅锟斤拷锟斤拷山锟�
	public static final String STATUS_PAID_RETURN = "paid_return";		//锟斤拷锟斤拷睿拷锟斤拷锟饺★拷锟斤拷丝畹斤拷锟斤拷
	public static final String STATUS_EMAIL_ID = "email_id";				//锟绞硷拷ID

	public static final String STATUS_CANCEL = "cancel";					//锟斤拷锟斤拷取锟斤拷锟斤拷
	public static final String STATUS_SYS_CANCEL = "cancel_sys";		//系统取锟斤拷
	public static final String STATUS_SYS_CHANGE_CANCEL = "cancel_sys_change";	//锟缴癸拷锟斤拷锟斤拷系统锟斤拷锟斤拷取锟斤拷
	public static final String STATUS_REPEAT = "cancel_repeat";			//锟截革拷锟斤拷锟斤拷
	public static final String STATUS_USER_CANCEL = "cancel_user";		//锟矫伙拷取锟斤拷锟斤拷
	public static final String STATUS_TIMEOUT = "cancel_timeout";		//锟斤拷时取锟斤拷
	public static final Map<String, String> statusMap = new HashMap<String, String>();
	public static final Map<String, String> manualOrderMap;
	
	public static final String UNIQUE_BY_MEMBERID = "memberid";			//锟斤拷锟斤拷锟斤拷锟斤拷疃ㄒ伙拷员锟绞讹拷锟绞癸拷锟斤拷没锟轿ㄒ伙拷锟�
	public static final String UNIQUE_BY_MOBILE = "mobile";				//锟斤拷锟斤拷锟斤拷锟斤拷疃ㄒ伙拷员锟绞讹拷锟绞癸拷锟斤拷只锟�
	public static final String UNIQUE_BY_MEMBER_AND_MOBILE = "all";	//锟斤拷锟斤拷锟斤拷锟斤拷疃ㄒ伙拷员锟绞讹拷锟绞癸拷锟斤拷只锟�+锟剿猴拷
	public static final String UNIQUE_BY_PARTNERNAME = "partnername";	//锟斤拷锟斤拷锟斤拷锟斤拷疃ㄒ伙拷员锟绞讹拷锟绞癸拷锟斤拷只锟�+锟剿猴拷
	public static final String UNIQUE_BY_DEVICEID = "deviceid";				//锟矫伙拷id+mobile+锟借备id
	
	public static final String ORDER_EXPRESSNO = "expressNo";			//锟斤拷荻锟斤拷锟斤拷锟�
	public static final String ORDER_EXPRESSMode = "expressMode";			//锟斤拷荻锟斤拷锟斤拷锟�
	public static final String SYSBANK_BUY = "buy";
	public static final String SYSBANK_GIFT = "gift";
	
	public static final String ORDER_BANKMEMBERUKEY = "bankMemberUkey";
	
	public static final String ORDER_HASLOVESEAT = "hasLoveSeat";
	
	//锟斤拷训锟教伙拷确锟较讹拷锟斤拷
	public static final String TRAINING_ORDER_IS_SURE = "isSure";
	
	//锟斤拷锟教家斤拷锟斤拷状态
	public static final String SETTLE_NONE = "O";	//未知
	public static final String SETTLE_N = "N";		//锟斤拷锟斤拷锟斤拷
	public static final String SETTLE_Y = "Y";		//锟斤拷锟斤拷
	
	public static final String DISCOUNT_STATUS_Y = "Y";		//锟斤拷使锟矫成癸拷
	public static final String DISCOUNT_STATUS_N = "N";		//未使锟矫成癸拷
	
	public static final String PREPAY_Y = "Y";		//预锟桔讹拷锟斤拷
	public static final String PREPAY_N = "N";		//锟斤拷预锟桔讹拷锟斤拷
	public static final String PREPAY_S = "S";		//锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String PREPAY_G = "G";		//锟捷筹拷锟斤拷票
	public static final String PREPAY_T = "T";		//锟捷筹拷锟斤拷锟斤拷
	public static final String PREPAY_P = "P";		//锟捷筹拷锟截伙拷票
	public static final String PREPAY_C = "C";		//CRM锟教伙拷
	public static final String PREPAY_A = "A";		//锟皆讹拷选锟斤拷锟斤拷锟斤拷

	//锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String ORDER_TYPE_TICKET = "ticket";		//锟斤拷影票
	public static final String ORDER_TYPE_GOODS = "goods";			//锟斤拷品
	public static final String ORDER_TYPE_DRAMA = "drama";			//锟斤拷锟斤拷
	public static final String ORDER_TYPE_PUBSALE = "pubsale";		//锟斤拷锟斤拷
	public static final String ORDER_TYPE_GUARANTEE = "guarantee";	//锟斤拷证锟斤拷
	public static final String ORDER_TYPE_MALL = "mall";			//锟教筹拷
	public static final String ORDER_TYPE_BAOCHANG = "baoChang";	//锟斤拷锟斤拷
	
	//锟斤拷锟斤拷模锟斤拷
	public static final String ORDER_PRICATEGORY_MOVIE = "movie";		//锟斤拷影模锟斤拷	
	public static final String ORDER_PRICATEGORY_DRAMA = "drama";		//锟捷筹拷模锟斤拷	
	public static final String ORDER_PRICATEGORY_ACTIVITY = "activity";	//锟筋动模锟斤拷	
	public static final String ORDER_PRICATEGORY_PUBSALE = "pubsale";	//锟斤拷锟斤拷模锟斤拷	
	public static final String ORDER_PRICATEGORY_POINT = "point";		//锟斤拷锟街对讹拷模锟斤拷	
	public static final String ORDER_PRICATEGORY_MAll = "mall";			//锟教筹拷模锟斤拷	
	//远锟教讹拷锟斤拷状态
	public static final String REMOTE_STATUS_NEW = "N";		//锟铰讹拷锟斤拷
	public static final String REMOTE_STATUS_LOCK = "0";		//锟斤拷位锟斤拷锟斤拷
	public static final String REMOTE_STATUS_FIXED = "1";		//锟斤拷锟斤拷锟缴癸拷
	public static final String REMOTE_STATUS_UNLOCK = "2";		//锟斤拷位锟斤拷锟斤拷
	public static final String REMOTE_STATUS_FAILED = "F";		//失锟斤拷
	public static final String REMOTE_STATUS_ERROR = "X";		//锟斤拷锟斤拷
	public static final String REMOTE_STATUS_CANCEL = "C";		//锟斤拷票 
	public static final String REMOTE_STATUS_UNKNOWN = "U";		//未知

	public static final String CHECKMARK_N = "N";		//未锟斤拷锟�
	public static final String CHECKMARK_Y = "Y";		//锟斤拷锟�
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫碉拷原锟斤拷
	public static final String OTHERFEE_REASON_UMPAY = "umPay";						//锟斤拷锟斤拷支锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String OTHERFEE_REASON_UMPAY_SH = "umPay_sh";				//锟斤拷锟斤拷支锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String OTHERFEE_REASON_EXPRESS = "express";					//锟斤拷莘锟斤拷锟�
	
	
	public static final Long CARD_DELAY_GOODSID = 152385164L;//锟斤拷锟斤拷锟斤拷品id    152385164
	
	public static final String MANUAL_STATUS_NEW = "new";			//锟铰讹拷锟斤拷未锟斤拷锟�
	public static final String MANUAL_STATUS_CHECK = "checked";     //锟斤拷锟酵拷锟�
	public static final String MANUAL_STATUS_CANCEL = "cancel";     //锟斤拷锟斤拷
	public static final String MANUAL_STATUS_PAY = "pay";			//锟斤拷锟酵拷锟斤拷迅锟斤拷锟�
	public static final String MANUAL_STATUS_NOISSUE = "noissue";	//未锟斤拷票
	public static final String MANUAL_STATUS_CANISSUE = "canissue";	//锟缴筹拷票
	public static final String MANUAL_STATUS_ISSUE = "issue";		//锟窖筹拷票
	
	public static final String MANUAL_SETTLETYPE_NORM = "norm";		//锟街讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷准
	public static final String MANUAL_SETTLETYPE_MANUAL = "manual"; //锟街讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟街讹拷
	
	public static final Integer MINPOINT = 500;
	public static final Integer MAXPOINT = 10000;
	
	public static final String PUBSALE_MSG = "锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷馨锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷母锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷幕疃拷丫锟斤拷某晒锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷诙愿枚锟斤拷锟斤拷锟斤拷锟饺凤拷霞锟街э拷锟斤拷锟叫恍伙拷锟�";

	static{
		statusMap.put(STATUS_CANCEL, "锟斤拷锟斤拷锟斤拷取锟斤拷");
		statusMap.put(STATUS_REPEAT, "锟截革拷锟斤拷锟斤拷");
		statusMap.put(STATUS_USER_CANCEL, "锟矫伙拷取锟斤拷");
		statusMap.put(STATUS_SYS_CANCEL, "系统取锟斤拷");
		statusMap.put(STATUS_SYS_CHANGE_CANCEL, "系统锟斤拷锟斤拷取锟斤拷");
		statusMap.put(STATUS_NEW, "锟铰讹拷锟斤拷");
		statusMap.put(STATUS_NEW_CONFIRM, "锟饺达拷锟斤拷锟斤拷");
		statusMap.put(STATUS_NEW_UNLOCK, "锟斤拷时锟斤拷锟斤拷");
		statusMap.put(STATUS_PAID, "锟斤拷锟斤拷晒锟�");
		statusMap.put(STATUS_PAID_SUCCESS, "锟斤拷锟阶成癸拷");
		statusMap.put(STATUS_PAID_FAILURE, "锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷");
		statusMap.put(STATUS_PAID_SPECIAL, "锟斤拷锟斤拷锟斤拷锟解处锟斤拷");
		statusMap.put(STATUS_PAID_UNFIX, "锟斤拷位锟斤拷锟斤拷锟斤拷");
		statusMap.put(STATUS_PAID_RETURN, "锟剿匡拷取锟斤拷");
		statusMap.put(STATUS_TIMEOUT, "锟斤拷时取锟斤拷");
		Map<String, String> tmpManualOrderMap = new HashMap<String, String>();
		tmpManualOrderMap.put(MANUAL_STATUS_NEW, "未锟斤拷锟�");
		tmpManualOrderMap.put(MANUAL_STATUS_CHECK, "锟斤拷锟酵拷锟�");
		tmpManualOrderMap.put(MANUAL_STATUS_CANCEL, "锟斤拷锟斤拷");
		tmpManualOrderMap.put(MANUAL_STATUS_PAY, "锟斤拷锟酵拷锟斤拷迅锟斤拷锟�");
		tmpManualOrderMap.put(MANUAL_STATUS_NOISSUE, "未锟斤拷票");
		tmpManualOrderMap.put(MANUAL_STATUS_CANISSUE, "锟缴筹拷票");
		tmpManualOrderMap.put(MANUAL_STATUS_ISSUE, "锟窖筹拷票");
		manualOrderMap = MapUtils.unmodifiableMap(tmpManualOrderMap);
	}
	public static Map convert2Chinese(Map params){
		Map map = new HashMap();
		if(params==null||params.isEmpty()){
			return map;
		}
		for(Object key : params.keySet()){
			if("address".equals(key)){
				map.put("锟秸伙拷锟斤拷址", params.get("address"));
				continue;
			}
			if("remark".equals(key)){
				if(StringUtils.isNotBlank((String)params.get(key))) {
                    map.put("锟斤拷注", params.get(key));
                }
				continue;
			}
			if("preType".equals(key)){
				continue;
			}
			if("category".equals(key)){
				map.put("锟斤拷品锟斤拷锟�", params.get("category"));
				continue;
			}
			map.put(key, params.get(key));
		}
		return map;
	}
}
