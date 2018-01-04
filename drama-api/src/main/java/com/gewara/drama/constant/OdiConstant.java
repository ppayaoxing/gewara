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
	
	public static final String PREPAY_Y = "Y";		//Ԥ�۶���
	public static final String PREPAY_N = "N";		//��Ԥ�۶���
	public static final String PREPAY_S = "S";		//��������
	public static final String PREPAY_G = "G";		//�ݳ���Ʊ
	public static final String PREPAY_T = "T";		//�ݳ�����
	public static final String PREPAY_P = "P";		//�ݳ��ػ�Ʊ
	public static final String PREPAY_C = "C";		//CRM�̻�

	public static final String STATUS_BOOK = "Y"; // ����Ԥ��
	public static final String STATUS_NOBOOK = "N"; // ������Ԥ��
	public static final String STATUS_DISCARD = "D"; // ����
	
	public static final String ORDER_NEW = "orderNew";
	
	public static final Integer MINPOINT = 500;
	public static final Integer MAXPOINT = 10000;
	
	public static final List<String> STATUS_LIST = Arrays.asList(STATUS_BOOK, STATUS_NOBOOK, STATUS_DISCARD);
	
	public static final int CLOSE_MIN = 60; // ��ǰ�ر�ʱ��
	public static final String OPEN_TYPE_SEAT = "seat";
	public static final String OPEN_TYPE_PRICE = "price";
	
	public static final String TAKEMETHOD_ID = "I";			//���֤����Ʊ
	public static final String TAKEMETHOD_QUPIAOJI = "A";	//����Ʊ
	public static final String TAKEMETHOD_KUAIDI = "E";		//���
	public static final String TAKEMETHOD_NUMCODE = "C";		//���ֶ�ά��
	
	public static final String ADDORDERQUEUE_LOG_FROM_PC = "PC";
	public static final String ADDORDERQUEUE_LOG_FROM_API = "API";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_PRICE = "priceAndAddOrder";
	public static final String ADDORDERQUEUE_LOG_SEMAPHORE_SEAT = "seatAndAddOrder";
	
	public static final List<String> TAKEMETHOD_LIST = Arrays.asList(TAKEMETHOD_QUPIAOJI, TAKEMETHOD_ID, TAKEMETHOD_KUAIDI, TAKEMETHOD_NUMCODE);
	
	public static final String UNOPENGEWA = "unopengewa";					//���β��Ը���������
	public static final String UNSHOWGEWA = "unshowgewa";					//���β��Ը�������ʾ
	public static final String UNOPENSPECIAL = "unopenspecial";			//���β����ػ��û�����
	
	public static final String ODIOPTION = "odioption";					//���ι�Ʊ����
	public static final String OPENTOAPP = "app";							//��app����
	public static final String OPENTOWAP = "wap";							//��wap����
	public static final String OPENTOPC	= "pc";								//��pc����
	public static final String OPENTOALL	= "all";							//�����п���
	
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
	
	public static final int MAX_BUY = 6;					//ÿ����๺Ʊ����
	public static final int ODI_MAX_BUY = 30;				//����ÿ����๺Ʊ����
	public static final int SEND_MSG_3H = 180;				//���Ѷ���ʱ��(����)
	
	//��λͼˢ��Ƶ��
	public static final int SECONDS_SHOW_SEAT = 900;		//��ʾ��λͼ��20����
	public static final int SECONDS_ADDORDER = 300;		//�µ���5����
	public static final int SECONDS_UPDATE_SEAT = 60;		//���£�1����
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;		//���£�10��
	
	public static final String PAUSE_ALL = "ALL";				//�ر����к�����
	public static final String PARTNER_GEWA = "GEWA";		
	public static final String PARTNER_GPTBS = "GPTBS";		//�������ͣ���Ʊ��ϵͳ�Խ�
	public static final String PARTNER_YONGLE = "YONGLE";		//�������ͣ�������Ʊ��ϵͳ�Խ�
	public static final String PARTNER_WP = "WP";			//�������ͣ���΢Ʊϵͳ�Խ�
	public static final String PARTNER_DY = "SHOAC";		//�������ͣ��붫��ϵͳ�Խ�
	public static final String PARTNER_KXMH = "KXMH";		//�������ͣ��뿪���黨�Խ�
	
	public static final String DISQUANTITY_DITYPE_G = "G";	//�Ż����� G(���������Ż�)
	public static final String DISQUANTITY_DITYPE_P = "P";  //�Ż����� P(���췽�Ż�)
	
	public static final String PTYPE_P = "P";
	public static final String PTYPE_Q = "Q";
	
	public static final String PRICE_FLAG_ORDINARY = "O";		//��ͨƱ
	public static final String PRICE_FLAG_CHARITY = "C";		//����Ʊ
	public static final String PRICE_FLAG_MEITI = "M";			//ý��Ʊ
	
	public static final String PRICE_ORIGN_INVENTED = "invented";	//����
	public static final String PRICE_ORIGN_ENTITY = "entity";		//ʵ��
	
	public static final String PRICE_OTHERINFO_KEY_SHOWREMARK = "showremark";		//ѡ���Ƿ�չʾremark��Ϣ
	
	public static final String CORRECT_ADD = "add";					
	public static final String CORRECT_ADD_SYS = "add_sys";			//����Ա����
	public static final String CORRECT_ADD_REFUND = "add_refund";	//�˿�����
	public static final String CORRECT_SUB = "sub";
	public static final String CORRECT_SUB_ORDER = "sub_order";		//��������
	public static final String CORRECT_SUB_SYS = "sub_sys";			//����Ա����
	
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String>	opentypeTextMap;
	public static final Map<String, String> correctTextMap;
	public static final Map<String, String> showtypeTextMap;
	
	public static final String IDCARD_N = "N";	//�µ��Ƿ�ʹ�����֤:��
	public static final String IDCARD_W = "W";	//�µ��Ƿ�ʹ�����֤:���֤��֤	
	public static final String IDCARD_F = "F";	//�µ��Ƿ�ʹ�����֤:ʵ������֤
	
	static{
		SEATTYPE_LIST = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
						,"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		CollectionUtils.unmodifiableCollection(SEATTYPE_LIST);
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(PARTNER_GPTBS, "Ʊ��ϵͳ");
		tmp.put(PARTNER_GEWA, "������");
		tmp.put(PARTNER_YONGLE, "����Ʊ��");
		tmp.put(PARTNER_WP, "΢ƱƱ��");
		tmp.put(PARTNER_DY, "����Ʊ��");
		tmp.put(PARTNER_KXMH, "�����黨");
		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		Map<String, String> openTextTmp = new HashMap<String, String>();
		openTextTmp.put(OPEN_TYPE_SEAT, "ѡ��");
		openTextTmp.put(OPEN_TYPE_PRICE, "�۸�");
		opentypeTextMap = MapUtils.unmodifiableMap(openTextTmp);
		Map<String, String> correctTmp = new HashMap<String, String>();
		correctTmp.put(CORRECT_ADD_SYS, "����Ա���");
		correctTmp.put(CORRECT_ADD_REFUND, "�˿����");
		correctTmp.put(CORRECT_SUB_ORDER, "��������");
		correctTmp.put(CORRECT_SUB_SYS, "����Ա����");
		correctTextMap = MapUtils.unmodifiableMap(correctTmp);
		Map<String, String> showtypeTmp = new HashMap<String, String>();
		showtypeTmp.put(SHOWTYPE_NORMAL, "��ͨ");
		showtypeTmp.put(SHOWTYPE_SPECIAL, "�ػ�");
		showtypeTextMap = MapUtils.unmodifiableMap(showtypeTmp);
	}
	
	
	public static Timestamp getFullPlaytime(Date playdate, String playtime){
		if(playdate == null || StringUtils.isBlank(playtime)) {
            return null;
        }
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
