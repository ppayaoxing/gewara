/**
 * 
 */
package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
public abstract class OpiConstant {
	public static final String STATUS_BOOK = "Y";			//����Ԥ��
	public static final String STATUS_NOBOOK = "N";			//������Ԥ��
	public static final String STATUS_RECOVER = "R";		//��ɾ��״̬�ָ�����Ҫ����
	public static final String STATUS_DISCARD = "D";		//����
	public static final String STATUS_CLOSE = "C";			//����״̬	
	public static final String STATUS_PAST = "P";			//���ι���
	public static final String PARTNER_OPEN = "Y";			//���⿪��
	public static final String PARTNER_CLOSE = "N";			//�����⿪��

	//����
	//public static final String OPEN_PNX = "PNX";			//�������ͣ��붫Ʊ�Խ�
	public static final String OPEN_DADI = "DADI";			//�������Ժ��
	public static final String OPEN_HFH = "HFH";			//�������ͣ�����˶Խ�
	public static final String OPEN_WD = "WD";				//�������ͣ������Խ�
	public static final String OPEN_VISTA = "VISTA";		//�������ͣ���Vista�Խ�
	public static final String OPEN_JY = "JY";				//�������ͣ���JY�Խ�
	public static final String OPEN_FB = "FB";				//������
	public static final String OPEN_XFLH = "XFLH";			//�Ҹ�����
	public static final String OPEN_LMA = "LMA";			//¬�װ�
	public static final String OPEN_NJY = "NJY";			//����Ʊ��ӿڣ�����������
	public static final String OPEN_TXPC = "TXPC";			//����Ʊ��
	public static final String OPEN_UL = "UL";				//UL
	public static final String OPEN_MJ = "MJ";				//����
	public static final String OPEN_MJY = "MJY";				//���ݣ�2.4��
	public static final String OPEN_WD2 = "WD2";				//���2
	public static final String OPEN_FB2 = "FB2";				//������2
	public static final String OPEN_DADI2 = "DADI2";				//���vista
	public static final String OPEN_YXLT = "YXLT";				//��������
	public static final String OPEN_WM = "WM";					//����
	public static final String OPEN_VISTA2 = "VISTA2";			//vista2
	public static final String OPEN_MJY2 = "MJY2";				//M����2 
	
	//ʹ����
	public static final String OPEN_GEWARA = "GEWA";		//�������ͣ�������˶Խ�
	public static final String OPEN_MTX = "MTX";			//�������ͣ��������ǶԽ�
	public static final String OPEN_DX = "DX";				//�������ͣ��붦�¶Խ�
	public static final String OPEN_GPTBS = "GPTBS";		//Ʊ��ϵͳ
	public static final String OPEN_STPF = "STPF";			//���ǣ�����°棩
	public static final String OPEN_FB3 = "FB3";				//������3ƽ̨����
	public static final String OPEN_XFLH2 = "XFLH2";			//�Ҹ�����2
	public static final String OPEN_M1905 = "M1905";			//1905
	public static final String OPEN_DADI3 = "DADI3";			//���ֱӪƽ̨3
	public static final String OPEN_DADI4 = "DADI4";			//���ֱӪƽ̨4
	public static final String OPEN_CGV = "CGV";				//cgv
	public static final String OPEN_CFC = "CFC";				//��Ӱ
	public static final String OPEN_TXPC2 = "TXPC2";			//����Ʊ��2
	public static final String OPEN_SDZX = "SDZX";				//ʱ������
	public static final String OPEN_VISTA3 = "VISTA3";			//VISTA RESETƽ̨
	public static final String OPEN_WP = "WP";			//΢Ʊ
	public static final String OPEN_BL = "BL";			//����
	public static final String OPEN_HFH2 = "HFH2";		//����2
	public static final String OPEN_CTJH = "CTJH";		//����κ�
	public static final String OPEN_WD3 = "WD3";		//WD3
	public static final String OPEN_CGV2 = "CGV2";	//CGV2
	
	public static final List<String> OPEN_LOWEST_IS_COST = Arrays.asList(
			OPEN_STPF,OPEN_XFLH2,OPEN_M1905,OPEN_DADI3,OPEN_DADI4,OPEN_CFC,OPEN_CGV,OPEN_TXPC2,OPEN_SDZX,
			OPEN_VISTA3,OPEN_WP,OPEN_BL,OPEN_CTJH,OPEN_WD3,OPEN_CGV2);//��ͼۼ�����۵�����

	
	public static final String OPERATION_DISCARD = "discard";//��������

	public static final String PAYOPTION = "payoption";						//֧��ѡ��
	public static final String PAYCMETHODLIST = "paymethodlist";			//֧������
	public static final String CARDOPTION = "cardoption";					//ȯѡ��
	public static final String BATCHIDLIST = "batchidlist";					//����id����
	public static final String DEFAULTPAYMETHOD = "defaultpaymethod";		//Ĭ��֧����ʽ
	public static final String MEALOPTION = "mealoption";					//�ײ���
	public static final String UNVALIDSEATPOS = "unvalidseatpos";			//����֤ѡ�����λλ��
	public static final String ISREFUND = "isRefund";						//�Ƿ������Ʊ
	public static final String AUTO_OPEN_INFO = "autoOpen";					//�Զ�����
	public static final String AUTO_OPEN_INFO_STATUS = "autoOpenStatus";	//�Զ���������״̬���ֶ������Զ���
	public static final String AUTO_OPEN_SETTER_ID = "setterId";			//�Զ�������ID
	public static final String AUTO_OPEN_DISCARD = "autoOpenDiscard";					//�Զ����ŷ������ĳ���
	public static final String SMPNO = "smpno";								//�ض��ĳ��α��
	public static final String SIGN = "sign";									//�������α�ʶ
	public static final String	AREADESC = "areadesc";						//������������
	public static final String LYMOVIEIDS = "lymovieids";					//��ӳ���γ���ids
	public static final String SHOWLABEL = "showLabel";							//�Ƿ������ܱ�
	
	public static final String SDIDS = "sdids";								//�����ؼۻid
	public static final String SDIDSREMARK = "sdidsRemark";					//�����ؼۻid��ʾ���û�
	
	public static final String FROM_SPID = "fromSpid";						//��ĳ�������µĶ���
	public static final String ADDRESS = "address";							//��ַ����
	public static final String UNOPENGEWA = "unopengewa";					//���β��Ը���������
	public static final String UNSHOWGEWA = "unshowgewa";					//���β��Ը�������ʾ
	public static final String OPENCLIENT = "openclient";					//���ſͻ���
	
	public static final String MPI_OPENSTATUS_INIT = "init";
	public static final String MPI_OPENSTATUS_OPEN = "open";
	public static final String MPI_OPENSTATUS_CLOSE = "close";
	public static final String MPI_OPENSTATUS_DISABLED = "disabled";		//
	public static final String MPI_OPENSTATUS_PAST = "past";				//����
	
	
	public static final String MPITYPE_FILMFEST = "filmfest";			// ��Ӱ�ڱ�ʶ
	public static final String MPITYPE_BAOCHANG = "baoChang";			// ������ʶ
	public static final String MPITYPE_GWBAOCHANG = "gwBaoChang";			// �������Լ�������ʶ

	//��λͼˢ��Ƶ��
	public static final int SECONDS_SHOW_SEAT = 900;		//��ʾ��λͼ��20����
	public static final int SECONDS_ADDORDER = 300;		//�µ���5����
	public static final int SECONDS_UPDATE_SEAT = 60;		//���£�1����
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;		//���£�10��
	
	public static final int MAX_MINUTS_TICKETS = 15;		//��ӰƱ���������ʱ�䣨���ӣ�
	public static final int MAX_MINUTS_TICKETS_MTX = 10; 	//��������λ����ʱ��
	public static final int MAX_MINUTS_TICKETS_PNX = 5;		//Ʊ��ϵͳ��λ����ʱ��
	
	public static final int MAXSEAT_PER_ORDER = 5;			//���������
	public static final int MAXSEAT_PER_ORDER_PNX = 4;		//�������������Ʊ�������ǣ�
	
	
	public static final List<String> EDITIONS = Arrays.asList("2D","3D","IMAX2D","IMAX3D","˫��3D","��Ļ2D","��Ļ3D", "4D", "4DX", "5D", "6D");
	public static final List<String> EDITIONS_3D = Arrays.asList("3D", "IMAX3D", "˫��3D","��Ļ3D", "4D", "4DX", "5D", "6D");
	public static final List<String> ADV_EDITION = Arrays.asList("6D", "5D", "4DX");
	public static final List<String> LANGUAGES = Arrays.asList(
			"����","Ӣ��","����","����","����","���¿���","��������","����","����","����",
			"̩��","�������","ӡ����","��������","ϣ����","��˹��","������","������",
			"������","��������","������","��������","ӡ����","�ڿ�����","��������","������",
			"Խ����","������","������","���ϻ�","������","ԭ��","����","����");
	public static boolean isValidEdition(String edition){
		return StringUtils.isNotBlank(edition) && EDITIONS.contains(edition);
	}
	
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String> partnerFlagMap;
	public static final Map<String, String> takemethodMap;
	public static final Map<String, String> invaildPartnerMap;//��Ч������Map
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(OPEN_HFH, "����");
		tmp.put(OPEN_MTX, "������");
		tmp.put(OPEN_DX, "����");
		tmp.put(OPEN_WD, "���");
		tmp.put(OPEN_VISTA, "Vista");
		tmp.put(OPEN_GEWARA, "������");
		//tmp.put(OPEN_PNX, "��Ʊ");
		tmp.put(OPEN_JY, "�Ͻ���");
		tmp.put(OPEN_DADI, "���");
		tmp.put(OPEN_FB, "������");
		tmp.put(OPEN_XFLH, "�Ҹ�����");
		tmp.put(OPEN_LMA, "¬�װ�");
		tmp.put(OPEN_GPTBS, "Ʊ��ϵͳ");
		tmp.put(OPEN_NJY, "���ݣ��£�");
		tmp.put(OPEN_TXPC, "����Ʊ��");
		tmp.put(OPEN_UL, "ULϵͳ");
		tmp.put(OPEN_MJ, "����");
		tmp.put(OPEN_MJY, "����");
		tmp.put(OPEN_WD2, "���2");
		tmp.put(OPEN_STPF, "����");
		tmp.put(OPEN_FB2, "������2");
		tmp.put(OPEN_FB3, "������3");
		tmp.put(OPEN_DADI2, "���2");
		tmp.put(OPEN_YXLT, "��������");
		tmp.put(OPEN_WM, "����");
		tmp.put(OPEN_XFLH2, "�Ҹ�����2");
		tmp.put(OPEN_M1905, "1905��Ӱ");
		tmp.put(OPEN_DADI3, "���3");
		tmp.put(OPEN_DADI4, "���4");
		tmp.put(OPEN_CGV, "CGV");
		tmp.put(OPEN_CFC, "��Ӱ");
		tmp.put(OPEN_TXPC2, "����Ʊ��2");
		tmp.put(OPEN_VISTA2, "vista2");
		tmp.put(OPEN_SDZX, "ʱ������");
		tmp.put(OPEN_MJY2, "M����2");
		tmp.put(OPEN_VISTA3, "VISTA3");
		tmp.put(OPEN_WP, "΢Ʊ");
		tmp.put(OPEN_BL, "����");
		tmp.put(OPEN_HFH2, "����2");
		tmp.put(OPEN_CTJH, "����κ�");
		tmp.put(OPEN_WD3, "���3");
		tmp.put(OPEN_CGV2, "CGV2");

		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		Map<String, String> tmpFlag = new HashMap<String, String>();
		tmpFlag.put(OPEN_HFH, "H");
		tmpFlag.put(OPEN_MTX, "M");
		tmpFlag.put(OPEN_DX, "DX");
		tmpFlag.put(OPEN_WD, "W");
		tmpFlag.put(OPEN_VISTA, "V");
		tmpFlag.put(OPEN_GEWARA, "G");
		//tmpFlag.put(OPEN_PNX, "P");
		tmpFlag.put(OPEN_JY, "J");
		tmpFlag.put(OPEN_DADI, "DD");
		tmpFlag.put(OPEN_FB, "FB");
		tmpFlag.put(OPEN_XFLH, "XF");	
		tmpFlag.put(OPEN_LMA, "L");	
		tmpFlag.put(OPEN_GPTBS, "GP");	
		tmpFlag.put(OPEN_NJY, "NJ");
		tmpFlag.put(OPEN_TXPC, "T");	
		tmpFlag.put(OPEN_UL, "UL");	
		tmpFlag.put(OPEN_MJ, "MJ");	
		tmpFlag.put(OPEN_MJY, "MJY");
		tmpFlag.put(OPEN_WD2, "W2");
		tmpFlag.put(OPEN_STPF, "C");
		tmpFlag.put(OPEN_FB2, "FB2");
		tmpFlag.put(OPEN_FB3, "FB3");
		tmpFlag.put(OPEN_DADI2, "DADI2");
		tmpFlag.put(OPEN_YXLT, "Y");
		tmpFlag.put(OPEN_WM, "WM");
		tmpFlag.put(OPEN_XFLH2, "XFLH2");
		tmpFlag.put(OPEN_M1905, "M1905");
		tmpFlag.put(OPEN_DADI3, "DADI3");
		tmpFlag.put(OPEN_DADI4, "DADI4");
		tmpFlag.put(OPEN_CGV, "CGV");
		tmpFlag.put(OPEN_CFC, "CFC");
		tmpFlag.put(OPEN_TXPC2, "TXPC2");
		tmpFlag.put(OPEN_VISTA2, "VISTA2");
		tmpFlag.put(OPEN_SDZX, "SDZX");
		tmpFlag.put(OPEN_MJY2, "MJY2");
		tmpFlag.put(OPEN_VISTA3, "VISTA3");
		tmpFlag.put(OPEN_WP, "WP");
		tmpFlag.put(OPEN_BL, "BL");
		tmpFlag.put(OPEN_HFH2, "HFH2");
		tmpFlag.put(OPEN_CTJH, "CTJH");
		tmpFlag.put(OPEN_WD3, "WD3");
		tmpFlag.put(OPEN_CGV2, "CGV2");
		partnerFlagMap = MapUtils.unmodifiableMap(tmpFlag);
		Map<String, String> tmpTakemethod = new LinkedHashMap<String, String>();
		tmpTakemethod.put("P", "�ֳ�����");
		tmpTakemethod.put("W", "ӰԺ��Ʊ����");
		tmpTakemethod.put("A", "������ȡƱ��");
		tmpTakemethod.put("F", "������ȫ��ȡƱ��");
		tmpTakemethod.put("U", "����Ժ������ȡƱ��");
		tmpTakemethod.put("L", "¬�װ�ӰԺ����ȡƱ��");
		tmpTakemethod.put("D", "���Ժ������ȡƱ��");
		tmpTakemethod.put("J", "����Ժ������ȡƱ��");
		tmpTakemethod.put("M", "ӰԺ��Ա����ȡƱ��");
		tmpTakemethod.put("E", "��ػ�ԱȡƱ��");
		tmpTakemethod.put("T", "����Ʊ��ȡƱ��");
		takemethodMap = MapUtils.unmodifiableMap(tmpTakemethod);
		
		Map<String, String> tmpInvalidMap = new HashMap<String, String>();
		tmpInvalidMap.put(OPEN_FB, "������");
		tmpInvalidMap.put(OPEN_FB2, "������2");
		tmpInvalidMap.put(OPEN_JY, "�Ͻ���");
		tmpInvalidMap.put(OPEN_DADI, "���");
		tmpInvalidMap.put(OPEN_XFLH, "�Ҹ�����");
		invaildPartnerMap = MapUtils.unmodifiableMap(tmpInvalidMap);
	}
	
	public static boolean hasPartner(String opentype){
		if(StringUtils.equals(OPEN_GEWARA, opentype)) {
            return false;
        }
		if(StringUtils.isBlank(partnerTextMap.get(opentype))) {
            return false;
        }
		return true;
	}
	
	public static String getParnterText(String opentype){
		if(StringUtils.isBlank(opentype)) {
            return "";
        }
		String tmpText = partnerTextMap.get(opentype);
		if(StringUtils.isNotBlank(tmpText)) {
            return tmpText;
        }
		return "δ֪";
	}

	/**
	 * ��֤��ӳ�汾��Ӱ�����Ƿ�ƥ��
	 * @param roomPlaytype
	 * @param opiEdition
	 * @return
	 */
	public static String validateRoomPlaytype(String roomPlaytype, String opiEdition){
		if(StringUtils.isBlank(roomPlaytype)) {
            return "";
        }
		if("3D".equals(opiEdition)){
			if("3D".equals(roomPlaytype)) {
                return "";
            }
		}else if("IMAX".equals(opiEdition)){
			if("IMAX".equals(roomPlaytype)) {
                return "";
            }
		}else{//2D
			if("2D".equals(roomPlaytype)) {
                return "";
            }
		}
		return "���κ�Ӱ����ӳ�汾��ƥ�䣺" + roomPlaytype + "<---->" + opiEdition;
	}
	/**
	 * ���ص���Ƭ���Ӱ���ĳ����Զ�ת��Ϊ��Ӧ������
	 * ����дΪ˫��3D��ֻҪ���ص��ĳ���Ϊ3D���Զ�ת��Ϊ˫��3D�����ص�λ2D���β�ת����
	 * �磺��Ļ2D����Ļ3D�����ص���2D�����Զ�ת��Ϊ��Ļ2D��3D�����Զ�ת��Ϊ��Ļ3D��
	 * @param synchEdition
	 * @param roomDefaultEdition
	 * @return
	 */
	public static String getDefaultEdition(String synchEdition,String roomDefaultEdition){
		if(StringUtils.isBlank(synchEdition) || StringUtils.isBlank(roomDefaultEdition)){
			return synchEdition;
		}
		// ���ΰ汾��Ӱ���汾����һ�£�����˳��Ϊ6D��5D��4DX
		for(String edition : ADV_EDITION) {
			if(roomDefaultEdition.contains(edition)) {
				return edition;
			}
		}
        String[] defaults = StringUtils.split(roomDefaultEdition, ",");
		for(String defaultEdition : defaults){
			if(defaultEdition.contains(synchEdition)){
				return defaultEdition;
			}
		}
		return synchEdition;
	}
	
	//������¼���һ�θ���
	public static String getLastChangeKey(Long mpid) {
		return "LastChange" + mpid;
	}
}
