package com.gewara.ucenter.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class BindConstant {
	public static final String KEY_BINDTIME = "bindTime";	//���ֻ�ʱ�䣬�ֻ�ע��ֱ����ע��ʱ��

	public static final String TAG_REGISTERCODE = "registercode"; 	//��ȡ�ֻ�ע�ᡢ���ٵ�¼��̬��
	public static final String TAG_DYNAMICCODE = "dynamiccode"; 	//��TAG_REGISTERCODE�ϲ�
	
	public static final String TAG_BINDMOBILE = "bindMobile"; 		//�ֻ���
	public static final String TAG_CHGBINDMOBILE = "chgbindMobile"; //�޸��ֻ��󶨣����ֻ�
	public static final String TAG_CHGBINDMOBILE2 = "chgbindN"; //�޸��ֻ��󶨣����ֻ�
	
	public static final String TAG_ACCOUNT_BACKPASS = "account_backpass"; //�ֻ��һ�֧������
	public static final String TAG_DYNAMICCODE_CARD = "dynamiccode_card"; //����Ʊȯ���ֻ���̬��
	public static final String TAG_BACKPASS = "backpass"; 		//�ֻ��һ�����
	public static final String TAG_MODIFYPASS = "modifypass"; 	//�޸�����

	public static final String TAG_SETPAYPASS = "setpaypass"; 	//����֧������
	public static final String TAG_MDYPAYPASS = "mdypaypass"; 	//�޸�֧������
	public static final String TAG_DRAWMOBILE = "drawMobile"; 	//�齱�ֻ���֤
	public static final String TAG_GETPAYPASS = "getpaypass"; 	//�һ�֧������
	public static final String TAG_CCBANKCODE = "ccbankcode";	//�������ж�̬��
	public static final String TAG_SECURITYVERIFY = "securityVerify"; 	//�û���ȫ��֤

	public static final String TAG_VDEMAIL_BY_UPDATEPWD = "vdemailbyuppwd"; //�޸�����ǰ�����䰲ȫ��֤
	public static final String TAG_UNICOM_REGISTERCODE = "unicom_registercode"; 	//��ͨ�û�ע�ᶯ̬��
	public static final String TAG_UNICOM_BACKPASS = "unicom_backpass"; 	//��ͨ�û�ע�ᶯ̬��
	public static final String TAG_MESSAGE_CHECK = "message_check";			// ר���Ķ�����֤
	public static final String TAG_PRE_MES = "pre_mes";		// Ԥ�ۻ��������
	public static final String TAG_SMSVALID = "smsvalid"; 	//���Żظ���֤
	//public static final String PREFIX_SMSVALID = "yz";	//��֤����

	
	//��Ч��ǩlist��������֤�ñ�ǩ�Ƿ���Ч���������򷵻����ʹ����޷�����refreshBindMobile����
	public static final List<String> VALID_TAG_LIST = Arrays.asList(
			TAG_REGISTERCODE,
			TAG_DYNAMICCODE,
			TAG_BINDMOBILE,
			TAG_ACCOUNT_BACKPASS,
			TAG_DYNAMICCODE_CARD,
			TAG_BACKPASS,
			TAG_MODIFYPASS,
			TAG_SETPAYPASS,
			TAG_MDYPAYPASS,
			TAG_CHGBINDMOBILE,
			TAG_CHGBINDMOBILE2,
			TAG_DRAWMOBILE,
			TAG_CCBANKCODE,
			TAG_GETPAYPASS,
			TAG_VDEMAIL_BY_UPDATEPWD,
			TAG_UNICOM_REGISTERCODE,
			TAG_UNICOM_BACKPASS,
			TAG_MESSAGE_CHECK,
			TAG_PRE_MES,
			TAG_SMSVALID,
			TAG_SECURITYVERIFY
		);

	//Ĭ�϶���
	public static final String DEFAULT_TEMPLATE = "checkpass(��������̬��֤�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068";
	public static final String ADMIN_MOBILE_TEMPLATE = "checkpass(�������绰��ƱУ���룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068";
	public static final int VALID_MIN = 30;			//��Чʱ��(MINUTE)
	public static final int MAX_CHECKNUM = 5;
	public static final int MAX_SENDNUM = 99999;
	
	private static final Map<String, Integer> SENDNUM_MAP;
	private static final Map<String, Integer> MAXCHECK_MAP;
	private static final Map<String, String> TEMPLATE_MAP;
	//Ĭ�����������

	
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(TAG_REGISTERCODE, "checkpass(������ע�ᶯ̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_CCBANKCODE, "checkpass(������֧����̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		
		tmp.put(TAG_UNICOM_BACKPASS, "checkpass(��Ӱ�㶯̬��֤�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_UNICOM_REGISTERCODE, "���ڵ�Ӱ��ע��Ķ�̬���ǣ�checkpass�� 30��������Ч��ʹ�ú�ʧЧ��");
		
		tmp.put(TAG_BINDMOBILE, "checkpass(�������󶨶�̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_CHGBINDMOBILE, "checkpass(���������Ķ�̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_CHGBINDMOBILE2, "checkpass(���������Ķ�̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_PRE_MES, "checkpass(��������̬�룬����й©),30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		tmp.put(TAG_SMSVALID, "Ϊ���������˺Ű�ȫ����ظ�checkpass��֤�����˺�,15��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		
		tmp.put(TAG_SECURITYVERIFY, "checkpass(��������ȫ��̬�룬����й©)��30��������Ч���Ǳ��˻���Ȩ���������µ�1010-1068");
		
		TEMPLATE_MAP = UnmodifiableMap.decorate(tmp);
		
		Map<String, Integer> tmp2 = new HashMap<String, Integer>();
		tmp2.put(TAG_REGISTERCODE, 20);		//ע����һ�ֻ�ֻ����20��
		tmp2.put(TAG_UNICOM_REGISTERCODE, 20);
		tmp2.put(TAG_MODIFYPASS, 20);
		tmp2.put(TAG_BINDMOBILE, 20);
		SENDNUM_MAP = UnmodifiableMap.decorate(tmp2);
		
		tmp2 = new HashMap<String, Integer>();
		tmp2.put(TAG_MODIFYPASS, 8);
		tmp2.put(TAG_SETPAYPASS, 8);
		MAXCHECK_MAP = UnmodifiableMap.decorate(tmp2);
	}

	public static String getMsgTemplate(String tag) {
		if(TEMPLATE_MAP.containsKey(tag)) {
            return TEMPLATE_MAP.get(tag);
        }
		return DEFAULT_TEMPLATE;
	}
	public static int getMaxSendnum(String tag){
		if(SENDNUM_MAP.containsKey(tag)) {
            return SENDNUM_MAP.get(tag);
        }
		return MAX_SENDNUM;
	}
	public static int getMaxCheck(String tag){
		if(MAXCHECK_MAP.containsKey(tag)) {
            return MAXCHECK_MAP.get(tag);
        }
		return MAX_CHECKNUM;
	}
	public static String getChangeBindOldKey(Long memberid) {
		return TAG_CHGBINDMOBILE + memberid;
	}

}
