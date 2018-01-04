package com.gewara.cons;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

public class OrderConstant {
	public static final String CHANGEHIS_KEY_CHANGESEAT = "changeSeat";			//������λ
	public static final String CHANGEHIS_KEY_SUCCESSCHANGE = "successChange";	//�ɹ�����������λ
	public static final String CHANGEHIS_KEY_MPITO = "mpito";					//�������ε�
	public static final String CHANGEHIS_KEY_MPIFROM = "mpifrom";				//�ӳ�����
	public static final String CHANGEHIS_KEY_RECONFIRMS = "reconfirms";			//����ȷ�϶�������
	public static final String CHANGEHIS_KEY_MOBILE_BUYTIMES = "buytimes";		//���ֻ���ʷ��������
	public static final String CHANGEHIS_KEY_MEMBER_BUYTIMES = "mbtimes";		//���û���ʷ��������
	public static final String CHANGEHIS_KEY_PROCESSTIMES = "processtimes";		//�ö����������
	public static final String CHANGEHIS_KEY_PROCESSMSG = "processError";		//
	public static final String CHANGEHIS_KEY_PROCESSCODE = "processCode";		//

	
	public static final String OTHERKEY_CREDENTIALSID = "credentialsId";		//�̼���֤ID
	public static final String OTHERKEY_BINDMEMBER = "bindMember";				//�绰�µ����û�
	public static final String OTHERKEY_TELEPHONE = "telephone";				//�绰�µ������绰
	public static final String OTHERKEY_BINDMOBILE = "bindMobile";				//�绰�µ����ֻ�
	public static final String OTHERKEY_USE_INSURE = "isUseInsure"; 			//����ʹ��ƽ����Ʊ����
	public static final String OTHERKEY_CREATEMEMBER = "createMember";			//�绰�µ��Ƿ񴴽�
	public static final String OTHERKEY_DELAY_CARDNO = "delayCardNo";      		//����Ʊȯ�г�����Ʊȯ��
	public static final String OTHERKEY_TAKEMETHOD_ID = "takemethodID";			//���֤����Ʊ
	public static final String OTHERKEY_CHARITY = "charity";							//����Ʊ��ʶ
	public static final String OTHERKEY_GREETINGS = "greetings";				//���Ի�Ʊ��
	public static final String OTHERKEY_DISTYPE = "p_distype";						//����
	public static final String OTHERKEY_DISCOUNT = "p_discount";					//
	public static final String OTHERKEY_DISAMOUNT = "p_disamount";				
	public static final String OTHERKEY_CARDNO = "cardno";						//����Ʊȯ����
	public static final String OTHERKEY_SHARECODE = "sharecode";				//����ID
	public static final String OTHERKEY_CONVERTSTATUS = "convertStatus";	//ת��״̬
	public static final String OTHERKEY_EXTERNALORDERNO  = "externalOrderNo";			//�ⲿ������
	public static final String OTHERKEY_COUNTRY_CODE  = "countryCode";			//���ұ���
	public static final String OTHERKEY_CUST_FIRSTNAME  = "firstName";			//�ͻ���
	public static final String OTHERKEY_CUST_LASTNAME  = "lastName";			//�ͻ���
	public static final String OTHERKEY_CLIENTIP = "clientIp";					//�ͻ�IP

	
	public static final String STATUS_NEW = "new";						//�¶�������λ������
	public static final String STATUS_NEW_UNLOCK = "new_unlock";		//�¶�����δ��������ʱ״̬��
	public static final String STATUS_NEW_CONFIRM = "new_confirm";		//�¶�����ȷ��ȥ����
	public static final String STATUS_PAID = "paid";					//��������δ���ǳɽ���
	public static final String STATUS_PAID_FAILURE = "paid_failure";	//���������д���
	public static final String STATUS_PAID_SPECIAL = "paid_special";	//���������в��ɹ���Ҳ���˿�������⴦�����粹��ȯ
	public static final String STATUS_PAID_UNFIX = "paid_failure_unfix";//����������λδȷ��
	public static final String STATUS_PAID_SUCCESS = "paid_success";	//����󣬶����ɽ�
	public static final String STATUS_PAID_RETURN = "paid_return";		//��������ȡ���˿���
	public static final String STATUS_EMAIL_ID = "email_id";				//�ʼ�ID

	public static final String STATUS_CANCEL = "cancel";					//����ȡ����
	public static final String STATUS_SYS_CANCEL = "cancel_sys";		//ϵͳȡ��
	public static final String STATUS_SYS_CHANGE_CANCEL = "cancel_sys_change";	//�ɹ�����ϵͳ����ȡ��
	public static final String STATUS_REPEAT = "cancel_repeat";			//�ظ�����
	public static final String STATUS_USER_CANCEL = "cancel_user";		//�û�ȡ����
	public static final String STATUS_TIMEOUT = "cancel_timeout";		//��ʱȡ��
	public static final Map<String, String> statusMap = new HashMap<String, String>();
	public static final Map<String, String> manualOrderMap;
	
	public static final String UNIQUE_BY_MEMBERID = "memberid";			//��������Ψһ�Ա�ʶ��ʹ���û�Ψһ��
	public static final String UNIQUE_BY_MOBILE = "mobile";				//��������Ψһ�Ա�ʶ��ʹ���ֻ�
	public static final String UNIQUE_BY_MEMBER_AND_MOBILE = "all";	//��������Ψһ�Ա�ʶ��ʹ���ֻ�+�˺�
	public static final String UNIQUE_BY_PARTNERNAME = "partnername";	//��������Ψһ�Ա�ʶ��ʹ���ֻ�+�˺�
	public static final String UNIQUE_BY_DEVICEID = "deviceid";				//�û�id+mobile+�豸id
	
	public static final String ORDER_EXPRESSNO = "expressNo";			//��ݶ�����
	public static final String ORDER_EXPRESSMode = "expressMode";			//��ݶ�����
	public static final String SYSBANK_BUY = "buy";
	public static final String SYSBANK_GIFT = "gift";
	
	public static final String ORDER_BANKMEMBERUKEY = "bankMemberUkey";
	
	public static final String ORDER_HASLOVESEAT = "hasLoveSeat";
	
	//��ѵ�̻�ȷ�϶���
	public static final String TRAINING_ORDER_IS_SURE = "isSure";
	
	//���̼ҽ���״̬
	public static final String SETTLE_NONE = "O";	//δ֪
	public static final String SETTLE_N = "N";		//������
	public static final String SETTLE_Y = "Y";		//����
	
	public static final String DISCOUNT_STATUS_Y = "Y";		//��ʹ�óɹ�
	public static final String DISCOUNT_STATUS_N = "N";		//δʹ�óɹ�
	
	public static final String PREPAY_Y = "Y";		//Ԥ�۶���
	public static final String PREPAY_N = "N";		//��Ԥ�۶���
	public static final String PREPAY_S = "S";		//��������
	public static final String PREPAY_G = "G";		//�ݳ���Ʊ
	public static final String PREPAY_T = "T";		//�ݳ�����
	public static final String PREPAY_P = "P";		//�ݳ��ػ�Ʊ
	public static final String PREPAY_C = "C";		//CRM�̻�
	public static final String PREPAY_A = "A";		//�Զ�ѡ������

	//��������
	public static final String ORDER_TYPE_TICKET = "ticket";		//��ӰƱ
	public static final String ORDER_TYPE_GOODS = "goods";			//��Ʒ
	public static final String ORDER_TYPE_DRAMA = "drama";			//����
	public static final String ORDER_TYPE_PUBSALE = "pubsale";		//����
	public static final String ORDER_TYPE_GUARANTEE = "guarantee";	//��֤��
	public static final String ORDER_TYPE_MALL = "mall";			//�̳�
	public static final String ORDER_TYPE_BAOCHANG = "baoChang";	//����
	
	//����ģ��
	public static final String ORDER_PRICATEGORY_MOVIE = "movie";		//��Ӱģ��	
	public static final String ORDER_PRICATEGORY_DRAMA = "drama";		//�ݳ�ģ��	
	public static final String ORDER_PRICATEGORY_ACTIVITY = "activity";	//�ģ��	
	public static final String ORDER_PRICATEGORY_PUBSALE = "pubsale";	//����ģ��	
	public static final String ORDER_PRICATEGORY_POINT = "point";		//���ֶԶ�ģ��	
	public static final String ORDER_PRICATEGORY_MAll = "mall";			//�̳�ģ��	
	//Զ�̶���״̬
	public static final String REMOTE_STATUS_NEW = "N";		//�¶���
	public static final String REMOTE_STATUS_LOCK = "0";		//��λ����
	public static final String REMOTE_STATUS_FIXED = "1";		//�����ɹ�
	public static final String REMOTE_STATUS_UNLOCK = "2";		//��λ����
	public static final String REMOTE_STATUS_FAILED = "F";		//ʧ��
	public static final String REMOTE_STATUS_ERROR = "X";		//����
	public static final String REMOTE_STATUS_CANCEL = "C";		//��Ʊ 
	public static final String REMOTE_STATUS_UNKNOWN = "U";		//δ֪

	public static final String CHECKMARK_N = "N";		//δ���
	public static final String CHECKMARK_Y = "Y";		//���
	
	//���������������õ�ԭ��
	public static final String OTHERFEE_REASON_UMPAY = "umPay";						//����֧��������
	public static final String OTHERFEE_REASON_UMPAY_SH = "umPay_sh";				//����֧��������
	public static final String OTHERFEE_REASON_EXPRESS = "express";					//��ݷ���
	
	
	public static final Long CARD_DELAY_GOODSID = 152385164L;//������Ʒid    152385164
	
	public static final String MANUAL_STATUS_NEW = "new";			//�¶���δ���
	public static final String MANUAL_STATUS_CHECK = "checked";     //���ͨ��
	public static final String MANUAL_STATUS_CANCEL = "cancel";     //����
	public static final String MANUAL_STATUS_PAY = "pay";			//���ͨ���Ѹ���
	public static final String MANUAL_STATUS_NOISSUE = "noissue";	//δ��Ʊ
	public static final String MANUAL_STATUS_CANISSUE = "canissue";	//�ɳ�Ʊ
	public static final String MANUAL_STATUS_ISSUE = "issue";		//�ѳ�Ʊ
	
	public static final String MANUAL_SETTLETYPE_NORM = "norm";		//�ֶ������������ͣ���׼
	public static final String MANUAL_SETTLETYPE_MANUAL = "manual"; //�ֶ������������ͣ��ֶ�
	
	public static final Integer MINPOINT = 500;
	public static final Integer MAXPOINT = 10000;
	
	public static final String PUBSALE_MSG = "��������������ܰ��ʾ��������ĸ��������������Ļ�Ѿ��ĳɹ�����������Чʱ���ڶԸö�������ȷ�ϼ�֧����лл��";

	static{
		statusMap.put(STATUS_CANCEL, "������ȡ��");
		statusMap.put(STATUS_REPEAT, "�ظ�����");
		statusMap.put(STATUS_USER_CANCEL, "�û�ȡ��");
		statusMap.put(STATUS_SYS_CANCEL, "ϵͳȡ��");
		statusMap.put(STATUS_SYS_CHANGE_CANCEL, "ϵͳ����ȡ��");
		statusMap.put(STATUS_NEW, "�¶���");
		statusMap.put(STATUS_NEW_CONFIRM, "�ȴ�����");
		statusMap.put(STATUS_NEW_UNLOCK, "��ʱ����");
		statusMap.put(STATUS_PAID, "����ɹ�");
		statusMap.put(STATUS_PAID_SUCCESS, "���׳ɹ�");
		statusMap.put(STATUS_PAID_FAILURE, "����������");
		statusMap.put(STATUS_PAID_SPECIAL, "�������⴦��");
		statusMap.put(STATUS_PAID_UNFIX, "��λ������");
		statusMap.put(STATUS_PAID_RETURN, "�˿�ȡ��");
		statusMap.put(STATUS_TIMEOUT, "��ʱȡ��");
		Map<String, String> tmpManualOrderMap = new HashMap<String, String>();
		tmpManualOrderMap.put(MANUAL_STATUS_NEW, "δ���");
		tmpManualOrderMap.put(MANUAL_STATUS_CHECK, "���ͨ��");
		tmpManualOrderMap.put(MANUAL_STATUS_CANCEL, "����");
		tmpManualOrderMap.put(MANUAL_STATUS_PAY, "���ͨ���Ѹ���");
		tmpManualOrderMap.put(MANUAL_STATUS_NOISSUE, "δ��Ʊ");
		tmpManualOrderMap.put(MANUAL_STATUS_CANISSUE, "�ɳ�Ʊ");
		tmpManualOrderMap.put(MANUAL_STATUS_ISSUE, "�ѳ�Ʊ");
		manualOrderMap = MapUtils.unmodifiableMap(tmpManualOrderMap);
	}
	public static Map convert2Chinese(Map params){
		Map map = new HashMap();
		if(params==null||params.isEmpty()){
			return map;
		}
		for(Object key : params.keySet()){
			if("address".equals(key)){
				map.put("�ջ���ַ", params.get("address"));
				continue;
			}
			if("remark".equals(key)){
				if(StringUtils.isNotBlank((String)params.get(key))) {
                    map.put("��ע", params.get(key));
                }
				continue;
			}
			if("preType".equals(key)){
				continue;
			}
			if("category".equals(key)){
				map.put("��Ʒ���", params.get("category"));
				continue;
			}
			map.put(key, params.get(key));
		}
		return map;
	}
}
