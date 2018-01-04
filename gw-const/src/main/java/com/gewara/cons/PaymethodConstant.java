package com.gewara.cons;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;

public abstract class PaymethodConstant implements Serializable {
	private static final long serialVersionUID = -8289964065497333210L;
	public static final String PAYMETHOD_UNKNOWN = "unknown";						//δ֪���û�δѡ��
	//������
	public static final String PAYMETHOD_GEWAPAY = "gewaPay";						//�û����
	public static final String PAYMETHOD_FCARDPAY = "fcardPay";						//�㿨֧��
	public static final String PAYMETHOD_SYSPAY = "sysPay";							//ϵͳ�û�
	public static final String PAYMETHOD_ELECARDPAY = "elecardPay";					//ȫ��ʹ��ȯ
	public static final String PAYMETHOD_GEWARA_OFFLINEPAY = "offlinePay";			//��̨����֧��
	//��ֵ
	public static final String PAYMETHOD_CHARGECARD = "ccardPay";					//��ֵ����ֻ������ֵ
	public static final String PAYMETHOD_LAKALA = "lakalaPay";						//������ ��ֻ������ֵ
	public static final String PAYMETHOD_ABCBANKPAY = "abcPay";						//ũ�к�����ֵ��ֻ������ֵ
	public static final String PAYMETHOD_WCANPAY = "wcanPay";						//΢�ܿƼ�������ֵ��ֻ������ֵ
	//֧��----�������
	public static final String PAYMETHOD_PARTNERPAY = "partnerPay";					//�������
	public static final String PAYMETHOD_OKCARDPAY = "okcardPay";					//����OK��
	public static final String PAYMETHOD_SPSDOPAY1 = "spsdoPay";					//ʢ��ʱ����֧��
	//֧��----������
	public static final String PAYMETHOD_ALIPAY = "directPay";						//֧����PC��
	public static final String PAYMETHOD_PNRPAY = "pnrPay";							//�㸶����PC��
	public static final String PAYMETHOD_CMPAY = "cmPay";							//�ƶ��ֻ�֧��PC��
	public static final String PAYMETHOD_TEMPUSPAY = "tempusPay";					//�ڸ�ͨPC��
	public static final String PAYMETHOD_SPSDOPAY2 = "spsdo2Pay";					//ʢ��ͨPC��
	public static final String PAYMETHOD_CHINAPAY1 = "chinaPay";					//����
	public static final String PAYMETHOD_CHINAPAY2 = "china2Pay";					//ChinapayPC��
	public static final String PAYMETHOD_CHINAPAYSRCB = "srcbPay";					//Chinapayũ����--->50000547
	
	public static final String PAYMETHOD_UNIONPAY = "unionPay";						//unionPay
	

	public static final String PAYMETHOD_UNIONPAY_JS = "unionPay_js";				//Unionpay����PC��
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY = "unionPay_activity";	//unionPay�
	public static final String PAYMETHOD_UNIONPAY_ACTIVITY_JS = "unionPay_activity_js";//unionPay���ջ
	public static final String PAYMETHOD_UNIONPAY_ZJ = "unionPay_zj";		//�㽭����ר��
	public static final String PAYMETHOD_UNIONPAY_SZ = "unionPay_sz";		//���ڵ���ר��
	public static final String PAYMETHOD_UNIONPAY_BJ = "unionPay_bj";		//��������ר��
	public static final String PAYMETHOD_UNIONPAY_GZ = "unionPay_gz";		//���ݵ���ר��

	
	public static final String PAYMETHOD_UNIONPAYFAST = "unionPayFast";				//unionPay V2.0.0 �汾֧��
	/**
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS = "unionPayFast_activity_js";//unionPay version 2.0.0�汾 unionPay���ջ
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ = "unionPayFast_activity_bj";//unionPay version 2.0.0�汾 unionPay�����
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ = "unionPayFast_activity_sz";//unionPay version 2.0.0�汾���ڵ����
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ = "unionPayFast_activity_gz";//unionPay version 2.0.0�汾���ݵ����
	public static final String PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ = "unionPayFast_activity_zj";//unionPay version 2.0.0�汾�㽭�����
	*/
	
	//֧��----ֱ��
	public static final String PAYMETHOD_BCPAY = "bcPay";							//����ֱ��PC��
	public static final String PAYMETHOD_SPDPAY = "spdPay";							//�ַ�ֱ��PC��
	public static final String PAYMETHOD_CMBPAY = "cmbPay";							//����ֱ��PC��
	public static final String PAYMETHOD_GDBPAY = "gdbPay";							//�㷢ֱ��PC��
	public static final String PAYMETHOD_GDB_UNION_PAY = "gdbUnionPay";  		    //�㷢ֱ��PC��(����)
	public static final String PAYMETHOD_PSBCPAY = "psbcPay";						//�ʴ�ֱ��PC��
	public static final String PAYMETHOD_HZBANKPAY = "hzbankPay";					//��������ֱ��
	//public static final String PAYMETHOD_CCBPOSPAY = "ccbposPay";					//����ֱ��PC��-���ÿ�
	public static final String PAYMETHOD_JSBCHINA = "jsbChina";						//��������ֱ��PC��-���ÿ�
	public static final String PAYMETHOD_SPDPAY_ACTIVITY = "spdPay_activity";		//�ַ�ֱ��PC��-�
	public static final String PAYMETHOD_BOCPAY = "bocPay";							//�й�����ֱ��PC��
	public static final String PAYMETHOD_BOCWAPPAY = "bocWapPay";					//�й�����ֱ��WAP��
	public static final String PAYMETHOD_BOCAGRMTPAY = "bocAgrmtPay";				//�й�����Э��֧��
	//֧��----����
	public static final String PAYMETHOD_UMPAY = "umPay";							//�ƶ�����֧��(��������)
	public static final String PAYMETHOD_UMPAY_SH = "umPay_sh";						//�ƶ�����֧��(��������) �Ϻ�����
	public static final String PAYMETHOD_TELECOM= "telecomPay";						//���Ź̻�����֧����������ֵ
	public static final String PAYMETHOD_MOBILE_TELECOM= "telecomMobilePay";		//�����ֻ�����֧��
	//֧��----��ҵ��
	public static final String PAYMETHOD_YAGAO = "yagaoPay";						//�Ÿ�
	public static final String PAYMETHOD_ONETOWN = "onetownPay";					//һ�ǿ�֧��(�»���ý)
	//֧��----�ֻ��ˣ�ֱ�� + ��������
	public static final String PAYMETHOD_ALIWAPPAY = "aliwapPay";					//֧�����ֻ���-WAP֧��
	public static final String PAYMETHOD_CMWAPPAY = "cmwapPay";						//�ƶ��ֻ�֧���ֻ���-WAP֧��
	public static final String PAYMETHOD_CMBWAPPAY = "cmbwapPay";					//����ֱ���ֻ���
	public static final String PAYMETHOD_CMBWAPSTOREPAY = "cmbwapStorePay";			//����ֱ���ֻ���CMSTORE
	public static final String PAYMETHOD_SPDWAPPAY = "spdWapPay";					//�ַ�ֱ���ֻ���-WAP
	public static final String PAYMETHOD_CMSMARTPAY = "cmSmartPay";					//�ƶ��ֻ�֧����׿��
	public static final String PAYMETHOD_SPDWAPPAY_ACTIVITY = "spdWapPay_activity";	//�ַ�ֱ���ֻ���-�
	public static final String PAYMETHOD_CHINASMARTMOBILEPAY = "chinaSmartMobilePay";//���������ֻ�֧��
	public static final String PAYMETHOD_CHINASMARTJSPAY = "chinaSmartJsPay";		//���������ֻ�֧��-����
	public static final String PAYMETHOD_ALISMARTMOBILEPAY = "aliSmartMobilePay";	//֧�����ֻ���-��ȫ֧��
	public static final String PAYMETHOD_HZWAPPAY = "hzwapPay";						//��������WAP
	public static final String PAYMETHOD_YEEPAY = "yeePay";       					//�ױ�֧��
	public static final String PAYMETHOD_PAYECO_DNA = "payecoDNAPay";       		// ����DNA֧��
	public static final String PAYMETHOD_MEMBERCARDPAY = "memberCardPay";       	// ��Ա��֧��
	public static final String PAYMETHOD_ICBCPAY = "icbcPay";       // ��������ֱ��֧��PC��
	public static final String PAYMETHOD_NJCBPAY = "njcbPay";       // �Ͼ�����ֱ��֧��PC��
	public static final String PAYMETHOD_ABCHINAPAY = "abchinaPay";       // ũҵ����ֱ��֧��PC��
	
	public static final String PAYMETHOD_WXAPPTENPAY = "wxAppTenPay";       //�Ƹ�ͨ΢��֧����App��֧����
	public static final String PAYMETHOD_WXAPPPAY = "wxAppPay";				//�Ƹ�ͨ΢��֧����App��֧����
	public static final String PAYMETHOD_WXMPNOPAY = "wxMPNoPay";				//΢�Ź��ں�֧��
	public static final String PAYMETHOD_WXSCANTENPAY = "wxScanTenPay";       //�Ƹ�ͨ΢��֧����WEBɨ�룩
	public static final String PAYMETHOD_WXWCPAY = "wxWCPay";				//΢�Ź��ں�֧��
	public static final String PAYMETHOD_CCBWAPPAY = "ccbWapPay";	//�����ֻ�wap֧��
	public static final String PAYMETHOD_ONECLICKTENPAY = "oneClickTenPay";	//�Ƹ�ͨ�ƶ��ն�һ��֧��
	public static final String PAYMETHOD_BESTPAY = "bestPay";	//��֧��
	public static final String PAYMETHOD_BFBWAPPAY = "bfbWapPay";	//�ٶ�Ǯ��wap֧��
	public static final String PAYMETHOD_BFBPAY = "bfbPay";		//�ٶ�Ǯ��֧��
	public static final String PAYMETHOD_ALISCANPAY = "aliScanPay";		//֧����ɨ��֧��
	public static final String PAYMETHOD_CCBMBCPAY = "ccbMBCPay";		//�����ֻ�����֧��
	public static final String PAYMETHOD_BCWAPPAY = "bcWapPay";//����Wap֧��	

	public static final String PAYMETHOD_BOCWAPV2PAY = "bocWapV2Pay";//�й�����ֱ��WAP֧����V2��
	public static final String PAYMETHOD_UNIONWAPPAYFAST = "unionWapPayFast";//�����޿�WAP֧��
	
	public static final String PAYMETHOD_ICBCWAPPAY = "icbcWapPay";//��������ֱ��WAP֧��
	
	public static final String PAYMETHOD_ALITVPAY = "aliTvPay";//����tv֧��
	
	public static final String PAYMETHOD_WEIBOPAY = "weiboPay";//΢��֧��
	
	public static final String PAYMETHOD_PINGAN1QBPAY = "pingan1qbPay";//ƽ��ҼǮ��֧��

	public static final String PAYMETHOD_CHUBAOPAY = "chubaoPay";					//����֧��
	public static final String PAYMETHOD_BJRCBPAY = "bjrcbPay";						//����ũ��֧��
	public static final String PAYMETHOD_ABCPAYFAST = "abcPayFast";					//ũҵ���п��֧��
	public static final String PAYMETHOD_ABCWAPPAYFAST = "abcWapPayFast";			//ũҵWAP֧��
	public static final String PAYMETHOD_ABCPOINTPAYFAST = "abcPointPayFast";		//ũҵ����֧��
	public static final String PAYMETHOD_HUAANPAY = "huaanPay";						//����PC֧��
	public static final String PAYMETHOD_HUAANWAPPAY = "huaanWapPay";				//����WAP֧��
	
	public static final String PAYMETHOD_ALIAPPPAY = "aliAppPay";				//֧����App֧��
	public static final String PAYMETHOD_PAYECOEPAY = "payecoEPay";				//�����ֻ�wap֧��

	public static final String PAYMETHOD_UNIONAPPPAY = "unionAppPay";			//�����ֻ�APP֧��
	public static final String PAYMETHOD_APPLEPAY = "applePay";					//ƻ��֧��֧������ʵ����unionAppPay֧��
	public static final String PAYMETHOD_UNIONWAPPAY = "unionWapPay";			//�����ֻ�WAP֧��
	public static final String PAYMETHOD_QQAPPPAY = "qqAppPay";					//QQǮ��֧��
	public static final String PAYMETHOD_QQTENSCANPAY = "qqTenScanPay";			//QQɨ��֧��
	
	public static final String PAYMETHOD_SPDCCCPAY = "spdcccPay";				//�ַ����ÿ�PC֧��
	public static final String PAYMETHOD_SPDCCCWAPPAY = "spdcccWapPay";			//�ַ����ÿ�WAP֧��
	public static final String PAYMETHOD_CCBAPPPAY = "ccbAppPay";				//��������APP֧��
	public static final String PAYMETHOD_CBHBPAY = "cbhbPay";					//����֧��
	public static final String PAYMETHOD_CBHBWAPPAY = "cbhbWapPay";				//����WAP֧��
	public static final String PAYMETHOD_SFAPPPAY = "sfAppPay";					//˳��APP֧��
	public static final String PAYMETHOD_WLTWAPPAY = "wltWapPay";				//����ͨWAP֧��
	public static final String PAYMETHOD_YLCFWAPPAY = "ylcfWapPay";				//һ·�Ƹ�WAP֧��
	public static final String PAYMETHOD_JDWAPPAY = "jdWapPay";					//����WAP֧��
	public static final String PAYMETHOD_JDPAY = "jdPay";					//����PC֧��
	public static final String PAYMETHOD_CCBWAPSECDPAY = "ccbWapSecdPay";		//�����˺�֧��
	
	public static final String PAYMETHOD_BOCWAPPAYFAST = "bocWapPayFast";	   //�й�����wap���֧��
	public static final String PAYMETHOD_FC99BILLPAY = "foreignCard99billPay";	//��Ǯ�⿨֧��
	public static final String PAYMETHOD_GZRCBPAY = "gzrcbPay";					//����ũ��֧��
	public static final String PAYMETHOD_GZRCBWAPPAY = "gzrcbWapPay";			//����ũ��Wap֧��
	public static final String PAYMETHOD_CHINATELEAPPPAY = "chinaTeleAppPay";	//������֧��
	public static final String PAYMETHOD_CHINATELEWAPPAY = "chinaTeleWapPay";	//������֧��
	public static final String PAYMETHOD_SUNINGWAPPAY = "suningWapPay";			//�����׸���֧��
	public static final String PAYMETHOD_INTELWAPPAY = "intelWapPay";			//Intel���ֱ�֧��
	public static final String PAYMETHOD_SPDCCCB2CPAY = "spdcccB2cPay";			//�ַ�B2C���ÿ�֧��
	public static final String PAYMETHOD_SPDCCCB2CWAPPAY = "spdcccB2cWapPay";	//�ַ�B2C���ÿ�WAP֧��
	
	public static final String PAYMETHOD_FQLPAY = "fqlPay";			//������֧��PC��
	public static final String PAYMETHOD_FQLWAPPAY = "fqlWapPay";	//������Wap֧��
	
	public static final String PAYMETHOD_BOSPAY = "bosPay";//�Ϻ�����B2C֧��
	
	public static final String PAYMETHOD_BOSWAPPAY = "bosWapPay";//�����츶
	
	public static final String PAYMETHOD_PINGANBANKPAY = "pinganBankPay";//ƽ������
	public static final String PAYMETHOD_PINGANBANKWAPPAY = "pinganBankWapPay";//ƽ������WAP
	public static final String PAYMETHOD_PAYECOWAPPAY = "payecoWapPay";//����WAP֧��
	public static final String PAYMETHOD_MSQMWAPPAY = "msqmWapPay";//��������֧��
	
	public static final String PAYMETHOD_SPDCCCFASTPAYPAY = "spdcccFastPay";//�ַ����п��֧��
	public static final String PAYMETHOD_BCOMCCFASTPAYPAY = "bcomccFastPay";	//��ͨ���п��֧��
	public static final String PAYMENTOD_MASAWAPPAY = "masaWapPay";               //�⿨֧��
	
	//֧��----����֧����ʽ����ʹ��
	public static final String PAYMETHOD_TENPAY = "tenPay";								//�Ƹ�ͨ
	//public static final String PAYMETHOD_BCWAPPAY_OLD = "bcwapPay";					//��ͨWAP���� 
	public static final String PAYMETHOD_ALIBANKPAY = "alibankPay";					//֧�����ֻ�����
	public static final String PAYMETHOD_HANDWAPPAY = "handwapPay";					//����ֻ�
	public static final String PAYMETHOD_HANDWEBPAY = "handwebPay";					//����ֻ�
	public static final String PAYMETHOD_PNRFASTPAY = "pnrfastPay";					//�㸶���֧�� --������������
	public static final String PAYMETHOD_PNRFASTPAY2 = "pnrfastPay2";					//�㸶���֧��2--������������
	public static final String PAYMETHOD_PNRFASTABCPAY = "pnrfastabcPay";			//�㸶���֧��--ũҵ�������ÿ�
	
	public static final String PAYMETHOD_YYPTPAY = "yyptPay";							//Ǯ���ƹ���֧��
	
	public static final String PAYMENTOD_UNICOMWOPAY = "unicomWoPay";					//��ͨ��֧��	
	public static final String PAYMENTOD_MSFPAY = "msfPay";                             //������
	
	/**�̻����֧������ֻ�Ժ����̻�ʹ�ã������Թ���������**/
	public static final String PAYMETHOD_MERCHANTPAY = "merchantPay";//�̻����֧��
	public static final String PAYMENTOD_XIYINPAY="xiyinPay";							//��������
	
	public static final String PAYMENTOD_CMBYWTPAY = "cmbywtPay"; //����һ��ͨ
	public static final String PAYMENTOD_WCFWAPPAY = "wcfWapPay";  //΢�Ƹ�
	//�ѷ���
	//public static final String PAYMETHOD_SDOPAY = "sdoPay";							//ʢ�����+�ֽ�
	//public static final String PAYMETHOD_IPSPAY= "ipsPay";							//��ѶPC��-���ÿ�֧��
	//public static final String PAYMETHOD_HAOBAIPAY = "haobaiPay";					//�Ű��ֻ���-�ͻ���
	//public static final String PAYMETHOD_ALLINPAY = "allinPay";						//ͨ��֧��
	
	public static final List<String> PAYMETHOD_LIST = 
			Arrays.asList(PAYMETHOD_GEWAPAY, PAYMETHOD_FCARDPAY, PAYMETHOD_CHARGECARD, PAYMETHOD_PNRPAY, 
					PAYMETHOD_ALIPAY, PAYMETHOD_ALIWAPPAY, PAYMETHOD_ALIBANKPAY, PAYMETHOD_LAKALA, PAYMETHOD_CCBWAPSECDPAY,
					PAYMETHOD_CHINAPAY1, PAYMETHOD_CHINAPAY2, PAYMETHOD_CHINAPAYSRCB, 
					PAYMETHOD_OKCARDPAY, PAYMETHOD_TENPAY, PAYMETHOD_PARTNERPAY, PAYMETHOD_SPSDOPAY1, PAYMETHOD_SPSDOPAY2, 
					PAYMETHOD_CMPAY, PAYMETHOD_YAGAO, PAYMETHOD_ONETOWN, PAYMETHOD_HANDWEBPAY, 
					PAYMETHOD_HANDWAPPAY, PAYMETHOD_CMBPAY, PAYMETHOD_CMBWAPPAY, PAYMETHOD_BCPAY, 
					PAYMETHOD_GDBPAY, PAYMETHOD_GDB_UNION_PAY, PAYMETHOD_ELECARDPAY, PAYMETHOD_SYSPAY, PAYMETHOD_CMWAPPAY, 
					PAYMETHOD_CHINASMARTMOBILEPAY, PAYMETHOD_CHINASMARTJSPAY, PAYMETHOD_ALISMARTMOBILEPAY, PAYMETHOD_UMPAY,PAYMETHOD_UMPAY_SH, 
					PAYMETHOD_SPDPAY, PAYMETHOD_SPDPAY_ACTIVITY,PAYMETHOD_PSBCPAY, PAYMETHOD_SPDWAPPAY, PAYMETHOD_SPDWAPPAY_ACTIVITY, PAYMETHOD_HZBANKPAY, PAYMETHOD_ABCBANKPAY, 
					PAYMETHOD_WCANPAY,PAYMETHOD_UNIONPAY,PAYMETHOD_TELECOM,PAYMETHOD_MOBILE_TELECOM,
					PAYMETHOD_JSBCHINA, PAYMETHOD_TEMPUSPAY, PAYMETHOD_PNRFASTPAY,PAYMETHOD_PNRFASTPAY2,PAYMETHOD_YEEPAY,
					PAYMETHOD_CMSMARTPAY, PAYMETHOD_PNRFASTABCPAY,PAYMETHOD_UNIONPAYFAST,
					PAYMETHOD_BOCPAY,PAYMETHOD_BOCWAPPAY,PAYMETHOD_BOCAGRMTPAY, PAYMETHOD_HZWAPPAY, PAYMETHOD_PAYECO_DNA, PAYMETHOD_MEMBERCARDPAY, 
					PAYMETHOD_ICBCPAY, PAYMETHOD_CMBWAPSTOREPAY,PAYMETHOD_NJCBPAY,PAYMETHOD_ABCHINAPAY,PAYMETHOD_WXAPPTENPAY,PAYMETHOD_WXAPPPAY,PAYMETHOD_WXSCANTENPAY,
					PAYMETHOD_CCBWAPPAY, PAYMETHOD_WXWCPAY, PAYMETHOD_ONECLICKTENPAY, PAYMETHOD_BESTPAY, PAYMETHOD_BFBWAPPAY, PAYMETHOD_GEWARA_OFFLINEPAY, PAYMETHOD_BFBPAY,PAYMETHOD_ALISCANPAY,PAYMETHOD_CCBMBCPAY,PAYMETHOD_BCWAPPAY
					,PAYMETHOD_BOCWAPV2PAY,PAYMETHOD_UNIONWAPPAYFAST, PAYMETHOD_ICBCWAPPAY, PAYMETHOD_ALITVPAY, PAYMETHOD_WEIBOPAY, PAYMETHOD_PINGAN1QBPAY, PAYMETHOD_CHUBAOPAY, PAYMETHOD_BJRCBPAY, PAYMETHOD_ABCPAYFAST,PAYMETHOD_ABCPOINTPAYFAST,
					PAYMETHOD_HUAANPAY,PAYMETHOD_HUAANWAPPAY,PAYMETHOD_ALIAPPPAY,PAYMETHOD_PAYECOEPAY,PAYMETHOD_WXMPNOPAY,PAYMETHOD_UNIONAPPPAY,PAYMETHOD_UNIONWAPPAY,PAYMETHOD_QQAPPPAY,PAYMETHOD_QQTENSCANPAY,PAYMETHOD_SPDCCCPAY,PAYMETHOD_SPDCCCWAPPAY,
					PAYMETHOD_CCBAPPPAY,PAYMETHOD_CBHBPAY,PAYMETHOD_CBHBWAPPAY,PAYMETHOD_ABCWAPPAYFAST,PAYMETHOD_SFAPPPAY,PAYMETHOD_WLTWAPPAY,PAYMETHOD_YLCFWAPPAY,PAYMETHOD_JDWAPPAY,PAYMETHOD_JDPAY,PAYMETHOD_BOCWAPPAYFAST,PAYMETHOD_FC99BILLPAY,
					PAYMETHOD_GZRCBPAY,PAYMETHOD_GZRCBWAPPAY,PAYMETHOD_CHINATELEAPPPAY,PAYMETHOD_SUNINGWAPPAY,PAYMETHOD_INTELWAPPAY,PAYMETHOD_SPDCCCB2CPAY,PAYMETHOD_SPDCCCB2CWAPPAY,PAYMETHOD_FQLPAY,PAYMETHOD_FQLWAPPAY,PAYMETHOD_BOSPAY,PAYMETHOD_BOSWAPPAY,
					PAYMETHOD_PINGANBANKPAY,PAYMETHOD_PINGANBANKWAPPAY,PAYMETHOD_PAYECOWAPPAY,PAYMETHOD_CHINATELEWAPPAY, PAYMETHOD_APPLEPAY, PAYMETHOD_MSQMWAPPAY,
					PAYMETHOD_SPDCCCFASTPAYPAY,PAYMETHOD_BCOMCCFASTPAYPAY,PAYMETHOD_YYPTPAY,PAYMENTOD_UNICOMWOPAY,PAYMENTOD_MSFPAY,PAYMENTOD_XIYINPAY,PAYMENTOD_MASAWAPPAY,PAYMENTOD_CMBYWTPAY,PAYMENTOD_WCFWAPPAY);
	/*����:PAYMETHOD_HAOBAIPAY, PAYMETHOD_IPSPAY, PAYMETHOD_SDOPAY, PAYMETHOD_ALLINPAY, PAYMETHOD_BCWAPPAY_OLD, */
		
	public static final List<String> MOBILE_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_ALIWAPPAY, PAYMETHOD_CMWAPPAY, PAYMETHOD_CMBWAPPAY, PAYMETHOD_CMBWAPSTOREPAY, PAYMETHOD_SPDWAPPAY, 
			PAYMETHOD_CMSMARTPAY, PAYMETHOD_SPDWAPPAY_ACTIVITY, PAYMETHOD_CHINASMARTMOBILEPAY, PAYMETHOD_CHINASMARTJSPAY, PAYMETHOD_BOCWAPPAY, PAYMETHOD_FCARDPAY,
			PAYMETHOD_ALISMARTMOBILEPAY, PAYMETHOD_HZWAPPAY ,PAYMETHOD_WXAPPTENPAY, PAYMETHOD_CCBWAPPAY, PAYMETHOD_WXWCPAY, PAYMETHOD_ONECLICKTENPAY, PAYMETHOD_BFBWAPPAY,PAYMETHOD_CCBMBCPAY,PAYMETHOD_BCWAPPAY
			,PAYMETHOD_BOCWAPV2PAY,PAYMETHOD_UNIONWAPPAYFAST, PAYMETHOD_ICBCWAPPAY, PAYMETHOD_ALITVPAY, PAYMETHOD_WEIBOPAY, PAYMETHOD_PINGAN1QBPAY, PAYMETHOD_CHUBAOPAY, PAYMETHOD_HUAANWAPPAY, PAYMETHOD_ALIAPPPAY,
			PAYMETHOD_PAYECOEPAY,PAYMETHOD_WXMPNOPAY,PAYMETHOD_UNIONAPPPAY,PAYMETHOD_UNIONWAPPAY,PAYMETHOD_QQAPPPAY,PAYMETHOD_SPDCCCWAPPAY,PAYMETHOD_CCBAPPPAY,PAYMETHOD_CBHBPAY,PAYMETHOD_CBHBWAPPAY,PAYMETHOD_ABCWAPPAYFAST,PAYMETHOD_ABCPAYFAST,PAYMETHOD_YLCFWAPPAY,
			PAYMETHOD_SFAPPPAY,PAYMETHOD_WLTWAPPAY,PAYMETHOD_ABCHINAPAY,PAYMETHOD_JDWAPPAY,PAYMETHOD_CCBWAPSECDPAY,PAYMETHOD_BOCWAPPAYFAST,PAYMETHOD_GZRCBWAPPAY,PAYMETHOD_CHINATELEAPPPAY,PAYMETHOD_SUNINGWAPPAY,PAYMETHOD_INTELWAPPAY,PAYMETHOD_SPDCCCB2CWAPPAY,PAYMETHOD_FQLWAPPAY,PAYMETHOD_BOSWAPPAY,
			PAYMETHOD_PINGANBANKWAPPAY,PAYMETHOD_PAYECOWAPPAY,PAYMETHOD_CHINATELEWAPPAY, PAYMETHOD_APPLEPAY, PAYMETHOD_MSQMWAPPAY,PAYMETHOD_SPDCCCFASTPAYPAY,PAYMETHOD_YYPTPAY,PAYMENTOD_UNICOMWOPAY,PAYMENTOD_MSFPAY,PAYMENTOD_XIYINPAY,PAYMENTOD_MASAWAPPAY,PAYMENTOD_CMBYWTPAY,PAYMENTOD_WCFWAPPAY);
	
	//������֧����ʽ���ж��˿���ܻ����á�
	public static final List<String> PARTNER_PAYMETHOD_LIST = Arrays.asList(PAYMETHOD_PARTNERPAY, PAYMETHOD_OKCARDPAY, PAYMETHOD_SPSDOPAY1);
	private static Map<String, String> payTextMap;	
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(PAYMETHOD_SYSPAY, "ϵͳ");
		tmp.put(PAYMETHOD_GEWAPAY, "�������");
		tmp.put(PAYMETHOD_FCARDPAY, "�㿨֧��");
		tmp.put(PAYMETHOD_ELECARDPAY, "����ȯ");
		tmp.put(PAYMETHOD_GEWARA_OFFLINEPAY, "��̨����֧��");
		tmp.put(PAYMETHOD_CHARGECARD, "���߳�ֵ��");
		tmp.put(PAYMETHOD_LAKALA, "������");
		tmp.put(PAYMETHOD_ABCBANKPAY,"ũ�к���");
		tmp.put(PAYMETHOD_WCANPAY,"΢�ܿƼ����ֶһ�");
		
		tmp.put(PAYMETHOD_PNRPAY, "�㸶����PC��");
		tmp.put(PAYMETHOD_ALIPAY, "֧����PC��");
		tmp.put(PAYMETHOD_CMPAY, "�ƶ��ֻ�֧��PC��");
		tmp.put(PAYMETHOD_CHINAPAY1, "��������");
		tmp.put(PAYMETHOD_CHINAPAY2, "ChinapayPC��");
		tmp.put(PAYMETHOD_SPSDOPAY2, "ʢ��ͨPC��");
		tmp.put(PAYMETHOD_PAYECO_DNA, "����DNA֧��");
		
		tmp.put(PAYMETHOD_CMBPAY, "����ֱ��PC��");
		tmp.put(PAYMETHOD_CMBWAPPAY, "����ֱ���ֻ���");
		tmp.put(PAYMETHOD_CMBWAPSTOREPAY, "�����ֻ���-STORE");
		tmp.put(PAYMETHOD_BCPAY, "����ֱ��PC��");
		tmp.put(PAYMETHOD_GDBPAY, "�㷢ֱ��PC��");
		tmp.put(PAYMETHOD_GDB_UNION_PAY, "�㷢����ֱ��PC��");
		tmp.put(PAYMETHOD_BOCPAY, "�й�����ֱ��PC��");
		tmp.put(PAYMETHOD_BOCAGRMTPAY, "�й�����Э��֧��");
		tmp.put(PAYMETHOD_SPDPAY, "�ַ�ֱ��PC��");
		tmp.put(PAYMETHOD_SPDPAY_ACTIVITY, "�ַ�ֱ��PC��-�");
		tmp.put(PAYMETHOD_SPDWAPPAY_ACTIVITY, "�ַ�ֱ���ֻ���-�");
		tmp.put(PAYMETHOD_PSBCPAY, "�ʴ�ֱ��PC��");
		tmp.put(PAYMETHOD_HZBANKPAY, "��������");
		tmp.put(PAYMETHOD_HZWAPPAY, "��������WAP");
		tmp.put(PAYMETHOD_JSBCHINA, "��������ֱ��PC��-���ÿ�");
		tmp.put(PAYMETHOD_TEMPUSPAY, "�ڸ�ͨPC��");
		tmp.put(PAYMETHOD_YEEPAY, "�ױ�֧��PC��");
		tmp.put(PAYMETHOD_ICBCPAY, "��������ֱ��֧��PC��");	
		tmp.put(PAYMETHOD_NJCBPAY, "�Ͼ�����ֱ��֧��PC��");
		tmp.put(PAYMETHOD_ABCHINAPAY, "ũҵ����ֱ��֧��PC��");	
		
		tmp.put(PAYMETHOD_ALIWAPPAY, "֧�����ֻ���-WAP֧��");
		tmp.put(PAYMETHOD_BOCWAPPAY, "�й�����ֱ��WAP��");
		tmp.put(PAYMETHOD_CMWAPPAY, "�ƶ��ֻ�֧���ֻ���-WAP֧��");
		tmp.put(PAYMETHOD_SPDWAPPAY, "�ַ�ֱ���ֻ���-WAP");
		tmp.put(PAYMETHOD_CHINASMARTMOBILEPAY, "�����ֻ�����֧��");
		tmp.put(PAYMETHOD_CHINASMARTJSPAY, "���������ֻ���-���������յ�");
		tmp.put(PAYMETHOD_ALISMARTMOBILEPAY, "֧�����ֻ���-��ȫ֧��");
		tmp.put(PAYMETHOD_CMSMARTPAY, "�ƶ��ֻ�֧����׿��");
		
		tmp.put(PAYMETHOD_UNIONPAY, "unionPay����֧��");
		

		tmp.put(PAYMETHOD_UNIONPAY_JS, "unionPay����");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY, "unionPay�");
		tmp.put(PAYMETHOD_UNIONPAY_ACTIVITY_JS, "unionPay���ջ");
		tmp.put(PAYMETHOD_UNIONPAY_ZJ, "unionPay�㽭");
		tmp.put(PAYMETHOD_UNIONPAY_SZ, "unionPay����");
		tmp.put(PAYMETHOD_UNIONPAY_BJ, "unionPay����");
		tmp.put(PAYMETHOD_UNIONPAY_GZ, "unionPay����");

		
		tmp.put(PAYMETHOD_UNIONPAYFAST, "unionPayFast�������֧��");
		/**
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_JS, "unionPayFast���ջ");	
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_BJ, "������֤2.0�����");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_SZ, "������֤2.0���ڻ");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_GZ, "������֤2.0���ݻ");
		tmp.put(PAYMETHOD_UNIONPAYFAST_ACTIVITY_ZJ, "������֤2.0�㽭");
		*/
		
		
		tmp.put(PAYMETHOD_PNRFASTPAY, "�㸶���֧��--�������ÿ�");
		tmp.put(PAYMETHOD_PNRFASTPAY2, "�㸶���֧��--�������ÿ�");
		tmp.put(PAYMETHOD_PNRFASTABCPAY, "�㸶���֧��--ũ�����ÿ�");
		
		
		tmp.put(PAYMETHOD_TELECOM, "���Ź̻�����֧��");
		tmp.put(PAYMETHOD_MOBILE_TELECOM, "�����ֻ�����֧��");
		tmp.put(PAYMETHOD_UMPAY, "�ƶ�����֧��(��������)");
		tmp.put(PAYMETHOD_UMPAY_SH, "�ƶ�����֧��(��������)_�Ϻ�");
		tmp.put(PAYMETHOD_YAGAO, "�Ÿ߿�֧��(�������)");
		tmp.put(PAYMETHOD_ONETOWN, "һ�ǿ�֧��(�»���ý)");
		
		tmp.put(PAYMETHOD_PARTNERPAY, "������");
		tmp.put(PAYMETHOD_OKCARDPAY, "����OK");
		tmp.put(PAYMETHOD_SPSDOPAY1, "ʢ�����");
		tmp.put(PAYMETHOD_CHINAPAYSRCB, "Chinapayũ����");
		tmp.put(PAYMETHOD_MEMBERCARDPAY, "��Ա��֧��");
		
		tmp.put(PAYMETHOD_WXAPPTENPAY, "�Ƹ�ͨ΢��֧����App��֧����");
		tmp.put(PAYMETHOD_WXAPPPAY, "΢�ſͻ���֧��");
		tmp.put(PAYMETHOD_WXSCANTENPAY, "�Ƹ�ͨ΢��֧����WEBɨ�룩");
		tmp.put(PAYMETHOD_WXWCPAY, "΢�Ź��ں�֧��");
		tmp.put(PAYMETHOD_WXMPNOPAY, "΢�Ź��ں�JS֧��");
		tmp.put(PAYMETHOD_CCBWAPPAY, "�����ֻ�wap֧��");
		tmp.put(PAYMETHOD_ONECLICKTENPAY, "�Ƹ�ͨ�ƶ��ն�һ��֧��");
		tmp.put(PAYMETHOD_BESTPAY, "��֧��");
		tmp.put(PAYMETHOD_BFBWAPPAY, "�ٶ�Ǯ��wap֧��");
		tmp.put(PAYMETHOD_BFBPAY, "�ٶ�Ǯ��֧��");
		tmp.put(PAYMETHOD_ALISCANPAY, "֧����ɨ��֧��");
		tmp.put(PAYMETHOD_CCBMBCPAY, "�����ֻ�����֧��");
		tmp.put(PAYMETHOD_BCWAPPAY, "����Wap֧��");			

		tmp.put(PAYMETHOD_BOCWAPV2PAY, "�й�����ֱ��WAP֧����V2��");	
		tmp.put(PAYMETHOD_UNIONWAPPAYFAST, "�����޿�WAP֧��");	
		
		tmp.put(PAYMETHOD_ICBCWAPPAY, "����e֧��");	
		tmp.put(PAYMETHOD_ALITVPAY, "����TV֧��");
		tmp.put(PAYMETHOD_WEIBOPAY, "΢��֧��");	
		tmp.put(PAYMETHOD_PINGAN1QBPAY, "ƽ��ҼǮ��֧��");	
		
		tmp.put(PAYMETHOD_CHUBAOPAY, "����֧��");
		tmp.put(PAYMETHOD_BJRCBPAY, "����ũ������֧��");
		tmp.put(PAYMETHOD_ABCPAYFAST, "ũҵ���п��֧��");
		tmp.put(PAYMETHOD_ABCWAPPAYFAST, "ũҵ���п��WAP֧��");
		tmp.put(PAYMETHOD_ABCPOINTPAYFAST, "ũҵ���л���֧��");
		tmp.put(PAYMETHOD_HUAANPAY, "��������֧��");
		tmp.put(PAYMETHOD_HUAANWAPPAY, "����΢Ǯ���ֻ�֧��");
		tmp.put(PAYMETHOD_ALIAPPPAY, "֧����App֧��");
		tmp.put(PAYMETHOD_PAYECOEPAY, "�����ֻ�WAP֧��");
		tmp.put(PAYMETHOD_SPDCCCPAY, "�ַ����ÿ�֧��");
		tmp.put(PAYMETHOD_SPDCCCWAPPAY, "�ַ����ÿ�WAP֧��");
		tmp.put(PAYMETHOD_GZRCBPAY, "����ũ������");
		tmp.put(PAYMETHOD_GZRCBWAPPAY, "����ũ������WAP֧��");
		tmp.put(PAYMENTOD_MASAWAPPAY, "�⿨֧��");
		
		tmp.put(PAYMETHOD_UNIONAPPPAY, "�����ֻ�APP֧��");
		tmp.put(PAYMETHOD_APPLEPAY, "ƻ��֧��");
		tmp.put(PAYMETHOD_MSQMWAPPAY, "��������֧��");
		
		tmp.put(PAYMETHOD_UNIONWAPPAY, "�����ֻ�WAP֧��");//,,,
		tmp.put(PAYMETHOD_QQAPPPAY, "QQǮ��");
		tmp.put(PAYMETHOD_QQTENSCANPAY, "QQɨ��֧��");
		tmp.put(PAYMETHOD_CCBAPPPAY, "����APP֧��");
		tmp.put(PAYMETHOD_CBHBPAY, "��������֧��");
		tmp.put(PAYMETHOD_CBHBWAPPAY, "��������WAP֧��");
		tmp.put(PAYMETHOD_SFAPPPAY, "˳��APP֧��");
		tmp.put(PAYMETHOD_YLCFWAPPAY, "һ·�Ƹ�WAP֧��");
		tmp.put(PAYMETHOD_JDWAPPAY, "�������¿��֧��");
		tmp.put(PAYMETHOD_JDPAY, "����֧��");
		tmp.put(PAYMETHOD_CCBWAPSECDPAY, "�����˺�֧��");
		tmp.put(PAYMETHOD_BOCWAPPAYFAST, "�й����п��֧��");
		tmp.put(PAYMETHOD_FC99BILLPAY, "��Ǯ�⿨֧��");
		tmp.put(PAYMETHOD_YYPTPAY, "Ǯ���ƹ�֧��");
		tmp.put(PAYMENTOD_UNICOMWOPAY, "��ͨ��֧��");
		tmp.put(PAYMENTOD_MSFPAY, "������");
		tmp.put(PAYMENTOD_XIYINPAY, "�������ߣ���������֧��ƽ̨��");
		tmp.put(PAYMENTOD_CMBYWTPAY, "����һ��ͨ");
		tmp.put(PAYMENTOD_WCFWAPPAY, "΢�Ƹ�");
		
		tmp.put(PAYMETHOD_CHINATELEAPPPAY, "������֧��");
		tmp.put(PAYMETHOD_CHINATELEWAPPAY, "������֧��WAP");
		tmp.put(PAYMETHOD_SUNINGWAPPAY, "�����׸���֧��");
		tmp.put(PAYMETHOD_INTELWAPPAY, "Intel���ֱ�֧��");
		tmp.put(PAYMETHOD_SPDCCCB2CPAY, "�ַ�B2C���ÿ�֧��");
		tmp.put(PAYMETHOD_SPDCCCB2CWAPPAY, "�ַ�B2C���ÿ�WAP֧��");
		tmp.put(PAYMETHOD_FQLPAY, "������֧��PC��");
		tmp.put(PAYMETHOD_FQLWAPPAY, "������Wap֧��");
		tmp.put(PAYMETHOD_BOSPAY, "�Ϻ�����B2C֧��");
		tmp.put(PAYMETHOD_BOSWAPPAY, "�����츶");
		
		tmp.put(PAYMETHOD_PINGANBANKPAY, "ƽ��֧��");
		tmp.put(PAYMETHOD_PINGANBANKWAPPAY, "ƽ��WAP֧��");
		tmp.put(PAYMETHOD_PAYECOWAPPAY, "����WAP֧��");
		tmp.put(PAYMETHOD_SPDCCCFASTPAYPAY, "�ַ����֧��");

		//����ʹ�õ�֧����ʽ
		tmp.put(PAYMETHOD_ALIBANKPAY, "֧������������WAP");
		tmp.put(PAYMETHOD_TENPAY, "�Ƹ�ͨ");
		tmp.put(PAYMETHOD_HANDWEBPAY, "����WEB");
		tmp.put(PAYMETHOD_HANDWAPPAY, "����WAP");		
		//tmp.put(PAYMETHOD_HAOBAIPAY, "�Ű��ֻ���-�ͻ���");
		//tmp.put(PAYMETHOD_SDOPAY, "ʢ�����");
		//tmp.put(PAYMETHOD_IPSPAY, "��ѶPC��-���ÿ�֧��");
		//tmp.put(PAYMETHOD_ALLINPAY, "ͨ��");
		//tmp.put(PAYMETHOD_BCWAPPAY_OLD, "��ͨWAP���ϵģ�");
		
		payTextMap = UnmodifiableMap.decorate(tmp);
	}
	
	public static String getPaymethodText(String paymethod){
		if(payTextMap.get(paymethod)!=null) {
            return payTextMap.get(paymethod);
        }
		if(StringUtils.equals("card", paymethod)) {
            return "�һ�ȯ";
        }
		return "δ֪";
	}
	public static final boolean isValidPayMethod(String paymethod){
		return StringUtils.isNotBlank(paymethod) && PaymethodConstant.PAYMETHOD_LIST.contains(paymethod);
	}
	public static Map<String, String> getPayTextMap(){
		return payTextMap;
	}
	
	
	private static Map<String, String> merchantPaymethodMap;	
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put("union_jsa","unionPay_activity_js");
		tmp.put("union_gz","unionPay_gz");
		tmp.put("union_sh",PAYMETHOD_UNIONPAY);
		tmp.put("union_sha","unionPay_activity");
		tmp.put("union_js","unionPay_js");
		tmp.put("union_zj","unionPay_zj");
		tmp.put("union_sz","unionPay_sz");
		tmp.put("union_bj","unionPay_bj");

		tmp.put("unionfast",PAYMETHOD_UNIONPAYFAST);
		tmp.put("unionfast_bj","unionPayFast_activity_bj");
		tmp.put("unionfast_js","unionPayFast_activity_js");
		tmp.put("unionfast_gz","unionPayFast_activity_gz");
		tmp.put("unionfast_zj","unionPayFast_activity_zj");
		tmp.put("unionfast_sz","unionPayFast_activity_sz");
		
		tmp.put("spd",PAYMETHOD_SPDPAY);
		tmp.put("spd_a",PAYMETHOD_SPDPAY_ACTIVITY);
		
		tmp.put("spdwap",PAYMETHOD_SPDWAPPAY);
		tmp.put("spdwap_a",PAYMETHOD_SPDWAPPAY_ACTIVITY);
		
		tmp.put("cmbwap",PAYMETHOD_CMBWAPPAY);
		tmp.put("cmbstore",PAYMETHOD_CMBWAPSTOREPAY);
		
		tmp.put("china2Pay",PAYMETHOD_CHINAPAY2);
		tmp.put("srcbPay",PAYMETHOD_CHINAPAYSRCB);
		tmp.put("chinaPay",PAYMETHOD_CHINAPAY1);
		
		tmp.put("um_sh",PAYMETHOD_UMPAY_SH);
		tmp.put("um",PAYMETHOD_UMPAY);
		
		tmp.put("chinasm",PAYMETHOD_CHINASMARTMOBILEPAY);
		tmp.put("chinasm_js",PAYMETHOD_CHINASMARTJSPAY);
		
		merchantPaymethodMap = UnmodifiableMap.decorate(tmp);
	}
	
	public static String getPaymethodByMercdoe(String merchantCode){
		if(StringUtils.isBlank(merchantCode)) {
            return null;
        }
		return merchantPaymethodMap.get(merchantCode);
	}
	
	//---------------------------------------------------------------------------------------
	/**֧�����أ���������֧��*/
	public static final String GATEWAY_CHINAPAY = "chinaPay";
	/**֧�����أ����Ź̻�֧��*/
	public static final String GATEWAY_CHARGETELECOMPAY = "chargeTelecomPay";
	
	
	
	/**�̻���ʶ��chinaPay*/
	public static final String MERCHANT_CHINA2PAY = "china2Pay";
	/**�̻���ʶ��chinaPay*/
	public static final String MERCHANT_CHINAPAY = "chinaPay";
	/**�̻���ʶ��chinaPay*/
	public static final String MERCHANT_SRCBPAY = "srcbPay";
	

	/**���д��룺0000��ʲô����Ҳ������*/
	public static final String BANK_NONE = "0000";
	
	/**���д��룺SRCB���Ϻ�ũ������*/
	public static final String BANK_SRCB = "SRCB";

	//---------------------------------------------------------------------------------------
	/**����֧����Դ��PC*/
	public static final String REQSOURCE_PC = "PC";
	
	/**����֧����Դ��WAP*/
	public static final String REQSOURCE_WAP = "WAP";
	
	/**����֧����Դ��APP*/
	public static final String REQSOURCE_APP = "APP";	
	
}
