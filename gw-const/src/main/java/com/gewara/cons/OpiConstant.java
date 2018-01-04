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
	public static final String STATUS_BOOK = "Y";			//锟斤拷锟斤拷预锟斤拷
	public static final String STATUS_NOBOOK = "N";			//锟斤拷锟斤拷锟斤拷预锟斤拷
	public static final String STATUS_RECOVER = "R";		//锟斤拷删锟斤拷状态锟街革拷锟斤拷锟斤拷要锟斤拷锟斤拷
	public static final String STATUS_DISCARD = "D";		//锟斤拷锟斤拷
	public static final String STATUS_CLOSE = "C";			//锟斤拷锟斤拷状态	
	public static final String STATUS_PAST = "P";			//锟斤拷锟轿癸拷锟斤拷
	public static final String PARTNER_OPEN = "Y";			//锟斤拷锟解开锟斤拷
	public static final String PARTNER_CLOSE = "N";			//锟斤拷锟斤拷锟解开锟斤拷

	//锟斤拷锟斤拷
	//public static final String OPEN_PNX = "PNX";			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟诫东票锟皆斤拷
	public static final String OPEN_DADI = "DADI";			//锟斤拷锟斤拷锟斤拷锟皆猴拷锟�
	public static final String OPEN_HFH = "HFH";			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷硕越锟�
	public static final String OPEN_WD = "WD";				//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟皆斤拷
	public static final String OPEN_VISTA = "VISTA";		//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷Vista锟皆斤拷
	public static final String OPEN_JY = "JY";				//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷JY锟皆斤拷
	public static final String OPEN_FB = "FB";				//锟斤拷锟斤拷锟斤拷
	public static final String OPEN_XFLH = "XFLH";			//锟揭革拷锟斤拷锟斤拷
	public static final String OPEN_LMA = "LMA";			//卢锟阶帮拷
	public static final String OPEN_NJY = "NJY";			//锟斤拷锟斤拷票锟斤拷涌冢锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	public static final String OPEN_TXPC = "TXPC";			//锟斤拷锟斤拷票锟斤拷
	public static final String OPEN_UL = "UL";				//UL
	public static final String OPEN_MJ = "MJ";				//锟斤拷锟斤拷
	public static final String OPEN_MJY = "MJY";				//锟斤拷锟捷ｏ拷2.4锟斤拷
	public static final String OPEN_WD2 = "WD2";				//锟斤拷锟�2
	public static final String OPEN_FB2 = "FB2";				//锟斤拷锟斤拷锟斤拷2
	public static final String OPEN_DADI2 = "DADI2";				//锟斤拷锟絭ista
	public static final String OPEN_YXLT = "YXLT";				//锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String OPEN_WM = "WM";					//锟斤拷锟斤拷
	public static final String OPEN_VISTA2 = "VISTA2";			//vista2
	public static final String OPEN_MJY2 = "MJY2";				//M锟斤拷锟斤拷2 
	
	//使锟斤拷锟斤拷
	public static final String OPEN_GEWARA = "GEWA";		//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷硕越锟�
	public static final String OPEN_MTX = "MTX";			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷锟角对斤拷
	public static final String OPEN_DX = "DX";				//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟诫鼎锟铰对斤拷
	public static final String OPEN_GPTBS = "GPTBS";		//票锟斤拷系统
	public static final String OPEN_STPF = "STPF";			//锟斤拷锟角ｏ拷锟斤拷锟斤拷掳妫�
	public static final String OPEN_FB3 = "FB3";				//锟斤拷锟斤拷锟斤拷3平台锟斤拷锟斤拷
	public static final String OPEN_XFLH2 = "XFLH2";			//锟揭革拷锟斤拷锟斤拷2
	public static final String OPEN_M1905 = "M1905";			//1905
	public static final String OPEN_DADI3 = "DADI3";			//锟斤拷锟街庇教�3
	public static final String OPEN_DADI4 = "DADI4";			//锟斤拷锟街庇教�4
	public static final String OPEN_CGV = "CGV";				//cgv
	public static final String OPEN_CFC = "CFC";				//锟斤拷影
	public static final String OPEN_TXPC2 = "TXPC2";			//锟斤拷锟斤拷票锟斤拷2
	public static final String OPEN_SDZX = "SDZX";				//时锟斤拷锟斤拷锟斤拷
	public static final String OPEN_VISTA3 = "VISTA3";			//VISTA RESET平台
	public static final String OPEN_WP = "WP";			//微票
	public static final String OPEN_BL = "BL";			//锟斤拷锟斤拷
	public static final String OPEN_HFH2 = "HFH2";		//锟斤拷锟斤拷2
	public static final String OPEN_CTJH = "CTJH";		//锟斤拷锟斤拷魏锟�
	public static final String OPEN_WD3 = "WD3";		//WD3
	public static final String OPEN_CGV2 = "CGV2";	//CGV2
	
	public static final List<String> OPEN_LOWEST_IS_COST = Arrays.asList(
			OPEN_STPF,OPEN_XFLH2,OPEN_M1905,OPEN_DADI3,OPEN_DADI4,OPEN_CFC,OPEN_CGV,OPEN_TXPC2,OPEN_SDZX,
			OPEN_VISTA3,OPEN_WP,OPEN_BL,OPEN_CTJH,OPEN_WD3,OPEN_CGV2);//锟斤拷图奂锟斤拷锟斤拷锟桔碉拷锟斤拷锟斤拷

	
	public static final String OPERATION_DISCARD = "discard";//锟斤拷锟斤拷锟斤拷锟斤拷

	public static final String PAYOPTION = "payoption";						//支锟斤拷选锟斤拷
	public static final String PAYCMETHODLIST = "paymethodlist";			//支锟斤拷锟斤拷锟斤拷
	public static final String CARDOPTION = "cardoption";					//券选锟斤拷
	public static final String BATCHIDLIST = "batchidlist";					//锟斤拷锟斤拷id锟斤拷锟斤拷
	public static final String DEFAULTPAYMETHOD = "defaultpaymethod";		//默锟斤拷支锟斤拷锟斤拷式
	public static final String MEALOPTION = "mealoption";					//锟阶诧拷锟斤拷
	public static final String UNVALIDSEATPOS = "unvalidseatpos";			//锟斤拷锟斤拷证选锟斤拷锟斤拷锟轿晃伙拷锟�
	public static final String ISREFUND = "isRefund";						//锟角凤拷锟斤拷锟斤拷锟狡�
	public static final String AUTO_OPEN_INFO = "autoOpen";					//锟皆讹拷锟斤拷锟斤拷
	public static final String AUTO_OPEN_INFO_STATUS = "autoOpenStatus";	//锟皆讹拷锟斤拷锟斤拷锟斤拷锟斤拷状态锟斤拷锟街讹拷锟斤拷锟斤拷锟皆讹拷锟斤拷
	public static final String AUTO_OPEN_SETTER_ID = "setterId";			//锟皆讹拷锟斤拷锟斤拷锟斤拷ID
	public static final String AUTO_OPEN_DISCARD = "autoOpenDiscard";					//锟皆讹拷锟斤拷锟脚凤拷锟斤拷锟斤拷锟侥筹拷锟斤拷
	public static final String SMPNO = "smpno";								//锟截讹拷锟侥筹拷锟轿憋拷锟�
	public static final String SIGN = "sign";									//锟斤拷锟斤拷锟斤拷锟轿憋拷识
	public static final String	AREADESC = "areadesc";						//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String LYMOVIEIDS = "lymovieids";					//锟斤拷映锟斤拷锟轿筹拷锟斤拷ids
	public static final String SHOWLABEL = "showLabel";							//锟角凤拷锟斤拷锟斤拷锟杰憋拷
	
	public static final String SDIDS = "sdids";								//锟斤拷锟斤拷锟截价活动id
	public static final String SDIDSREMARK = "sdidsRemark";					//锟斤拷锟斤拷锟截价活动id锟斤拷示锟斤拷锟矫伙拷
	
	public static final String FROM_SPID = "fromSpid";						//锟斤拷某锟斤拷锟斤拷锟斤拷锟铰的讹拷锟斤拷
	public static final String ADDRESS = "address";							//锟斤拷址锟斤拷锟斤拷
	public static final String UNOPENGEWA = "unopengewa";					//锟斤拷锟轿诧拷锟皆革拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String UNSHOWGEWA = "unshowgewa";					//锟斤拷锟轿诧拷锟皆革拷锟斤拷锟斤拷锟斤拷示
	public static final String OPENCLIENT = "openclient";					//锟斤拷锟脚客伙拷锟斤拷
	
	public static final String MPI_OPENSTATUS_INIT = "init";
	public static final String MPI_OPENSTATUS_OPEN = "open";
	public static final String MPI_OPENSTATUS_CLOSE = "close";
	public static final String MPI_OPENSTATUS_DISABLED = "disabled";		//
	public static final String MPI_OPENSTATUS_PAST = "past";				//锟斤拷锟斤拷
	
	
	public static final String MPITYPE_FILMFEST = "filmfest";			// 锟斤拷影锟节憋拷识
	public static final String MPITYPE_BAOCHANG = "baoChang";			// 锟斤拷锟斤拷锟斤拷识
	public static final String MPITYPE_GWBAOCHANG = "gwBaoChang";			// 锟斤拷锟斤拷锟斤拷锟皆硷拷锟斤拷锟斤拷锟斤拷识

	//锟斤拷位图刷锟斤拷频锟斤拷
	public static final int SECONDS_SHOW_SEAT = 900;		//锟斤拷示锟斤拷位图锟斤拷20锟斤拷锟斤拷
	public static final int SECONDS_ADDORDER = 300;		//锟铰碉拷锟斤拷5锟斤拷锟斤拷
	public static final int SECONDS_UPDATE_SEAT = 60;		//锟斤拷锟铰ｏ拷1锟斤拷锟斤拷
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;		//锟斤拷锟铰ｏ拷10锟斤拷
	
	public static final int MAX_MINUTS_TICKETS = 15;		//锟斤拷影票锟斤拷锟斤拷锟斤拷锟斤拷锟绞憋拷洌拷锟斤拷樱锟�
	public static final int MAX_MINUTS_TICKETS_MTX = 10; 	//锟斤拷锟斤拷锟斤拷锟斤拷位锟斤拷锟斤拷时锟斤拷
	public static final int MAX_MINUTS_TICKETS_PNX = 5;		//票锟斤拷系统锟斤拷位锟斤拷锟斤拷时锟斤拷
	
	public static final int MAXSEAT_PER_ORDER = 5;			//锟斤拷锟斤拷锟斤拷锟斤拷锟�
	public static final int MAXSEAT_PER_ORDER_PNX = 4;		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟狡憋拷锟斤拷锟斤拷锟斤拷牵锟�
	
	
	public static final List<String> EDITIONS = Arrays.asList("2D","3D","IMAX2D","IMAX3D","双锟斤拷3D","锟斤拷幕2D","锟斤拷幕3D", "4D", "4DX", "5D", "6D");
	public static final List<String> EDITIONS_3D = Arrays.asList("3D", "IMAX3D", "双锟斤拷3D","锟斤拷幕3D", "4D", "4DX", "5D", "6D");
	public static final List<String> ADV_EDITION = Arrays.asList("6D", "5D", "4DX");
	public static final List<String> LANGUAGES = Arrays.asList(
			"锟斤拷锟斤拷","英锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟铰匡拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷",
			"泰锟斤拷","锟斤拷锟斤拷锟斤拷锟�","印锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","希锟斤拷锟斤拷","锟斤拷斯锟斤拷","锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷",
			"锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","印锟斤拷锟斤拷","锟节匡拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷",
			"越锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷","锟斤拷锟较伙拷","锟斤拷锟斤拷锟斤拷","原锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷");
	public static boolean isValidEdition(String edition){
		return StringUtils.isNotBlank(edition) && EDITIONS.contains(edition);
	}
	
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String> partnerFlagMap;
	public static final Map<String, String> takemethodMap;
	public static final Map<String, String> invaildPartnerMap;//锟斤拷效锟斤拷锟斤拷锟斤拷Map
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(OPEN_HFH, "锟斤拷锟斤拷");
		tmp.put(OPEN_MTX, "锟斤拷锟斤拷锟斤拷");
		tmp.put(OPEN_DX, "锟斤拷锟斤拷");
		tmp.put(OPEN_WD, "锟斤拷锟�");
		tmp.put(OPEN_VISTA, "Vista");
		tmp.put(OPEN_GEWARA, "锟斤拷锟斤拷锟斤拷");
		//tmp.put(OPEN_PNX, "锟斤拷票");
		tmp.put(OPEN_JY, "锟较斤拷锟斤拷");
		tmp.put(OPEN_DADI, "锟斤拷锟�");
		tmp.put(OPEN_FB, "锟斤拷锟斤拷锟斤拷");
		tmp.put(OPEN_XFLH, "锟揭革拷锟斤拷锟斤拷");
		tmp.put(OPEN_LMA, "卢锟阶帮拷");
		tmp.put(OPEN_GPTBS, "票锟斤拷系统");
		tmp.put(OPEN_NJY, "锟斤拷锟捷ｏ拷锟铰ｏ拷");
		tmp.put(OPEN_TXPC, "锟斤拷锟斤拷票锟斤拷");
		tmp.put(OPEN_UL, "UL系统");
		tmp.put(OPEN_MJ, "锟斤拷锟斤拷");
		tmp.put(OPEN_MJY, "锟斤拷锟斤拷");
		tmp.put(OPEN_WD2, "锟斤拷锟�2");
		tmp.put(OPEN_STPF, "锟斤拷锟斤拷");
		tmp.put(OPEN_FB2, "锟斤拷锟斤拷锟斤拷2");
		tmp.put(OPEN_FB3, "锟斤拷锟斤拷锟斤拷3");
		tmp.put(OPEN_DADI2, "锟斤拷锟�2");
		tmp.put(OPEN_YXLT, "锟斤拷锟斤拷锟斤拷锟斤拷");
		tmp.put(OPEN_WM, "锟斤拷锟斤拷");
		tmp.put(OPEN_XFLH2, "锟揭革拷锟斤拷锟斤拷2");
		tmp.put(OPEN_M1905, "1905锟斤拷影");
		tmp.put(OPEN_DADI3, "锟斤拷锟�3");
		tmp.put(OPEN_DADI4, "锟斤拷锟�4");
		tmp.put(OPEN_CGV, "CGV");
		tmp.put(OPEN_CFC, "锟斤拷影");
		tmp.put(OPEN_TXPC2, "锟斤拷锟斤拷票锟斤拷2");
		tmp.put(OPEN_VISTA2, "vista2");
		tmp.put(OPEN_SDZX, "时锟斤拷锟斤拷锟斤拷");
		tmp.put(OPEN_MJY2, "M锟斤拷锟斤拷2");
		tmp.put(OPEN_VISTA3, "VISTA3");
		tmp.put(OPEN_WP, "微票");
		tmp.put(OPEN_BL, "锟斤拷锟斤拷");
		tmp.put(OPEN_HFH2, "锟斤拷锟斤拷2");
		tmp.put(OPEN_CTJH, "锟斤拷锟斤拷魏锟�");
		tmp.put(OPEN_WD3, "锟斤拷锟�3");
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
		tmpTakemethod.put("P", "锟街筹拷锟斤拷锟斤拷");
		tmpTakemethod.put("W", "影院锟斤拷票锟斤拷锟斤拷");
		tmpTakemethod.put("A", "锟斤拷锟斤拷锟斤拷取票锟斤拷");
		tmpTakemethod.put("F", "锟斤拷锟斤拷锟斤拷全锟斤拷取票锟斤拷");
		tmpTakemethod.put("U", "锟斤拷锟斤拷院锟斤拷锟斤拷锟斤拷取票锟斤拷");
		tmpTakemethod.put("L", "卢锟阶帮拷影院锟斤拷锟斤拷取票锟斤拷");
		tmpTakemethod.put("D", "锟斤拷锟皆猴拷锟斤拷锟斤拷锟饺∑憋拷锟�");
		tmpTakemethod.put("J", "锟斤拷锟斤拷院锟斤拷锟斤拷锟斤拷取票锟斤拷");
		tmpTakemethod.put("M", "影院锟斤拷员锟斤拷锟斤拷取票锟斤拷");
		tmpTakemethod.put("E", "锟斤拷鼗锟皆比∑憋拷锟�");
		tmpTakemethod.put("T", "锟斤拷锟斤拷票锟斤拷取票锟斤拷");
		takemethodMap = MapUtils.unmodifiableMap(tmpTakemethod);
		
		Map<String, String> tmpInvalidMap = new HashMap<String, String>();
		tmpInvalidMap.put(OPEN_FB, "锟斤拷锟斤拷锟斤拷");
		tmpInvalidMap.put(OPEN_FB2, "锟斤拷锟斤拷锟斤拷2");
		tmpInvalidMap.put(OPEN_JY, "锟较斤拷锟斤拷");
		tmpInvalidMap.put(OPEN_DADI, "锟斤拷锟�");
		tmpInvalidMap.put(OPEN_XFLH, "锟揭革拷锟斤拷锟斤拷");
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
		return "未知";
	}

	/**
	 * 锟斤拷证锟斤拷映锟芥本锟斤拷影锟斤拷锟斤拷锟角凤拷匹锟斤拷
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
		return "锟斤拷锟轿猴拷影锟斤拷锟斤拷映锟芥本锟斤拷匹锟戒：" + roomPlaytype + "<---->" + opiEdition;
	}
	/**
	 * 锟斤拷锟截碉拷锟斤拷片锟斤拷锟接帮拷锟斤拷某锟斤拷锟斤拷远锟阶拷锟轿拷锟接︼拷锟斤拷锟斤拷锟�
	 * 锟斤拷锟斤拷写为双锟斤拷3D锟斤拷只要锟斤拷锟截碉拷锟侥筹拷锟斤拷为3D锟斤拷锟皆讹拷转锟斤拷为双锟斤拷3D锟斤拷锟斤拷锟截碉拷位2D锟斤拷锟轿诧拷转锟斤拷锟斤拷
	 * 锟界：锟斤拷幕2D锟斤拷锟斤拷幕3D锟斤拷锟斤拷锟截碉拷锟斤拷2D锟斤拷锟斤拷锟皆讹拷转锟斤拷为锟斤拷幕2D锟斤拷3D锟斤拷锟斤拷锟皆讹拷转锟斤拷为锟斤拷幕3D锟斤拷
	 * @param synchEdition
	 * @param roomDefaultEdition
	 * @return
	 */
	public static String getDefaultEdition(String synchEdition,String roomDefaultEdition){
		if(StringUtils.isBlank(synchEdition) || StringUtils.isBlank(roomDefaultEdition)){
			return synchEdition;
		}
		// 锟斤拷锟轿版本锟斤拷影锟斤拷锟芥本锟斤拷锟斤拷一锟铰ｏ拷锟斤拷锟斤拷顺锟斤拷为6D锟斤拷5D锟斤拷4DX
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
	
	//锟斤拷锟斤拷锟斤拷录锟斤拷锟揭伙拷胃锟斤拷锟�
	public static String getLastChangeKey(Long mpid) {
		return "LastChange" + mpid;
	}
}
