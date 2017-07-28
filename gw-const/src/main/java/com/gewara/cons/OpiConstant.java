/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

public abstract class OpiConstant {
	public static final String STATUS_BOOK = "Y";
	public static final String STATUS_NOBOOK = "N";
	public static final String STATUS_RECOVER = "R";
	public static final String STATUS_DISCARD = "D";
	public static final String STATUS_CLOSE = "C";
	public static final String STATUS_PAST = "P";
	public static final String PARTNER_OPEN = "Y";
	public static final String PARTNER_CLOSE = "N";
	public static final String OPEN_DADI = "DADI";
	public static final String OPEN_HFH = "HFH";
	public static final String OPEN_WD = "WD";
	public static final String OPEN_VISTA = "VISTA";
	public static final String OPEN_JY = "JY";
	public static final String OPEN_FB = "FB";
	public static final String OPEN_XFLH = "XFLH";
	public static final String OPEN_LMA = "LMA";
	public static final String OPEN_NJY = "NJY";
	public static final String OPEN_TXPC = "TXPC";
	public static final String OPEN_UL = "UL";
	public static final String OPEN_MJ = "MJ";
	public static final String OPEN_MJY = "MJY";
	public static final String OPEN_WD2 = "WD2";
	public static final String OPEN_FB2 = "FB2";
	public static final String OPEN_DADI2 = "DADI2";
	public static final String OPEN_YXLT = "YXLT";
	public static final String OPEN_WM = "WM";
	public static final String OPEN_VISTA2 = "VISTA2";
	public static final String OPEN_MJY2 = "MJY2";
	public static final String OPEN_GEWARA = "GEWA";
	public static final String OPEN_MTX = "MTX";
	public static final String OPEN_DX = "DX";
	public static final String OPEN_GPTBS = "GPTBS";
	public static final String OPEN_STPF = "STPF";
	public static final String OPEN_FB3 = "FB3";
	public static final String OPEN_XFLH2 = "XFLH2";
	public static final String OPEN_M1905 = "M1905";
	public static final String OPEN_DADI3 = "DADI3";
	public static final String OPEN_DADI4 = "DADI4";
	public static final String OPEN_CGV = "CGV";
	public static final String OPEN_CFC = "CFC";
	public static final String OPEN_TXPC2 = "TXPC2";
	public static final String OPEN_SDZX = "SDZX";
	public static final String OPEN_VISTA3 = "VISTA3";
	public static final String OPEN_WP = "WP";
	public static final String OPEN_BL = "BL";
	public static final String OPEN_HFH2 = "HFH2";
	public static final String OPEN_CTJH = "CTJH";
	public static final String OPEN_WD3 = "WD3";
	public static final String OPEN_CGV2 = "CGV2";
	public static final List<String> OPEN_LOWEST_IS_COST = Arrays.asList(new String[] { "STPF", "XFLH2", "M1905",
			"DADI3", "DADI4", "CFC", "CGV", "TXPC2", "SDZX", "VISTA3", "WP", "BL", "CTJH", "WD3", "CGV2" });
	public static final String OPERATION_DISCARD = "discard";
	public static final String PAYOPTION = "payoption";
	public static final String PAYCMETHODLIST = "paymethodlist";
	public static final String CARDOPTION = "cardoption";
	public static final String BATCHIDLIST = "batchidlist";
	public static final String DEFAULTPAYMETHOD = "defaultpaymethod";
	public static final String MEALOPTION = "mealoption";
	public static final String UNVALIDSEATPOS = "unvalidseatpos";
	public static final String ISREFUND = "isRefund";
	public static final String AUTO_OPEN_INFO = "autoOpen";
	public static final String AUTO_OPEN_INFO_STATUS = "autoOpenStatus";
	public static final String AUTO_OPEN_SETTER_ID = "setterId";
	public static final String AUTO_OPEN_DISCARD = "autoOpenDiscard";
	public static final String SMPNO = "smpno";
	public static final String SIGN = "sign";
	public static final String AREADESC = "areadesc";
	public static final String LYMOVIEIDS = "lymovieids";
	public static final String SHOWLABEL = "showLabel";
	public static final String SDIDS = "sdids";
	public static final String SDIDSREMARK = "sdidsRemark";
	public static final String FROM_SPID = "fromSpid";
	public static final String ADDRESS = "address";
	public static final String UNOPENGEWA = "unopengewa";
	public static final String UNSHOWGEWA = "unshowgewa";
	public static final String OPENCLIENT = "openclient";
	public static final String MPI_OPENSTATUS_INIT = "init";
	public static final String MPI_OPENSTATUS_OPEN = "open";
	public static final String MPI_OPENSTATUS_CLOSE = "close";
	public static final String MPI_OPENSTATUS_DISABLED = "disabled";
	public static final String MPI_OPENSTATUS_PAST = "past";
	public static final String MPITYPE_FILMFEST = "filmfest";
	public static final String MPITYPE_BAOCHANG = "baoChang";
	public static final String MPITYPE_GWBAOCHANG = "gwBaoChang";
	public static final int SECONDS_SHOW_SEAT = 900;
	public static final int SECONDS_ADDORDER = 300;
	public static final int SECONDS_UPDATE_SEAT = 60;
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;
	public static final int MAX_MINUTS_TICKETS = 15;
	public static final int MAX_MINUTS_TICKETS_MTX = 10;
	public static final int MAX_MINUTS_TICKETS_PNX = 5;
	public static final int MAXSEAT_PER_ORDER = 5;
	public static final int MAXSEAT_PER_ORDER_PNX = 4;
	public static final List<String> EDITIONS = Arrays
			.asList(new String[] { "2D", "3D", "IMAX2D", "IMAX3D", "双机3D", "巨幕2D", "巨幕3D", "4D", "4DX", "5D", "6D" });
	public static final List<String> EDITIONS_3D = Arrays
			.asList(new String[] { "3D", "IMAX3D", "双机3D", "巨幕3D", "4D", "4DX", "5D", "6D" });
	public static final List<String> ADV_EDITION = Arrays.asList(new String[] { "6D", "5D", "4DX" });
	public static final List<String> LANGUAGES = Arrays.asList(new String[] { "国语", "英语", "粤语", "法语", "韩语", "赛德克语",
			"西班牙语", "德语", "俄语", "日语", "泰语", "意大利语", "印度语", "土耳其语", "希腊语", "波斯语", "芬兰语", "丹麦语", "荷兰语", "葡萄牙语", "波兰语",
			"阿拉伯语", "印尼语", "乌克兰语", "匈牙利语", "马来语", "越南语", "陕西话", "闽南语", "闽南话", "巴西语", "原版", "藏语", "沪语" });
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String> partnerFlagMap;
	public static final Map<String, String> takemethodMap;
	public static final Map<String, String> invaildPartnerMap;

	public static boolean isValidEdition(String edition) {
		return StringUtils.isNotBlank(edition) && EDITIONS.contains(edition);
	}

	public static boolean hasPartner(String opentype) {
		return StringUtils.equals("GEWA", opentype) ? false
				: !StringUtils.isBlank((String) partnerTextMap.get(opentype));
	}

	public static String getParnterText(String opentype) {
		if (StringUtils.isBlank(opentype)) {
			return "";
		} else {
			String tmpText = (String) partnerTextMap.get(opentype);
			return StringUtils.isNotBlank(tmpText) ? tmpText : "未知";
		}
	}

	public static String validateRoomPlaytype(String roomPlaytype, String opiEdition) {
		if (StringUtils.isBlank(roomPlaytype)) {
			return "";
		} else {
			if (opiEdition.equals("3D")) {
				if (roomPlaytype.equals("3D")) {
					return "";
				}
			} else if (opiEdition.equals("IMAX")) {
				if (roomPlaytype.equals("IMAX")) {
					return "";
				}
			} else if (roomPlaytype.equals("2D")) {
				return "";
			}

			return "场次和影厅放映版本不匹配：" + roomPlaytype + "<---->" + opiEdition;
		}
	}

	public static String getDefaultEdition(String synchEdition, String roomDefaultEdition) {
		if (!StringUtils.isBlank(synchEdition) && !StringUtils.isBlank(roomDefaultEdition)) {
			Iterator defaults = ADV_EDITION.iterator();

			String edition;
			do {
				if (!defaults.hasNext()) {
					String[] arg6 = StringUtils.split(roomDefaultEdition, ",");
					String[] arg7 = arg6;
					int arg3 = arg6.length;

					for (int arg4 = 0; arg4 < arg3; ++arg4) {
						String defaultEdition = arg7[arg4];
						if (defaultEdition.contains(synchEdition)) {
							return defaultEdition;
						}
					}

					return synchEdition;
				}

				edition = (String) defaults.next();
			} while (!roomDefaultEdition.contains(edition));

			return edition;
		} else {
			return synchEdition;
		}
	}

	public static String getLastChangeKey(Long mpid) {
		return "LastChange" + mpid;
	}

	static {
		HashMap tmp = new HashMap();
		tmp.put("HFH", "火凤凰");
		tmp.put("MTX", "满天星");
		tmp.put("DX", "鼎新");
		tmp.put("WD", "万达");
		tmp.put("VISTA", "Vista");
		tmp.put("GEWA", "格瓦拉");
		tmp.put("JY", "老金逸");
		tmp.put("DADI", "大地");
		tmp.put("FB", "火烈鸟");
		tmp.put("XFLH", "幸福蓝海");
		tmp.put("LMA", "卢米埃");
		tmp.put("GPTBS", "票务系统");
		tmp.put("NJY", "金逸（新）");
		tmp.put("TXPC", "天下票仓");
		tmp.put("UL", "UL系统");
		tmp.put("MJ", "美嘉");
		tmp.put("MJY", "金逸");
		tmp.put("WD2", "万达2");
		tmp.put("STPF", "辰星");
		tmp.put("FB2", "火烈鸟2");
		tmp.put("FB3", "火烈鸟3");
		tmp.put("DADI2", "大地2");
		tmp.put("YXLT", "银兴乐天");
		tmp.put("WM", "沃美");
		tmp.put("XFLH2", "幸福蓝海2");
		tmp.put("M1905", "1905电影");
		tmp.put("DADI3", "大地3");
		tmp.put("DADI4", "大地4");
		tmp.put("CGV", "CGV");
		tmp.put("CFC", "中影");
		tmp.put("TXPC2", "天下票仓2");
		tmp.put("VISTA2", "vista2");
		tmp.put("SDZX", "时代在线");
		tmp.put("MJY2", "M金逸2");
		tmp.put("VISTA3", "VISTA3");
		tmp.put("WP", "微票");
		tmp.put("BL", "保利");
		tmp.put("HFH2", "火凤凰2");
		tmp.put("CTJH", "橙天嘉禾");
		tmp.put("WD3", "万达3");
		tmp.put("CGV2", "CGV2");
		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		HashMap tmpFlag = new HashMap();
		tmpFlag.put("HFH", "H");
		tmpFlag.put("MTX", "M");
		tmpFlag.put("DX", "DX");
		tmpFlag.put("WD", "W");
		tmpFlag.put("VISTA", "V");
		tmpFlag.put("GEWA", "G");
		tmpFlag.put("JY", "J");
		tmpFlag.put("DADI", "DD");
		tmpFlag.put("FB", "FB");
		tmpFlag.put("XFLH", "XF");
		tmpFlag.put("LMA", "L");
		tmpFlag.put("GPTBS", "GP");
		tmpFlag.put("NJY", "NJ");
		tmpFlag.put("TXPC", "T");
		tmpFlag.put("UL", "UL");
		tmpFlag.put("MJ", "MJ");
		tmpFlag.put("MJY", "MJY");
		tmpFlag.put("WD2", "W2");
		tmpFlag.put("STPF", "C");
		tmpFlag.put("FB2", "FB2");
		tmpFlag.put("FB3", "FB3");
		tmpFlag.put("DADI2", "DADI2");
		tmpFlag.put("YXLT", "Y");
		tmpFlag.put("WM", "WM");
		tmpFlag.put("XFLH2", "XFLH2");
		tmpFlag.put("M1905", "M1905");
		tmpFlag.put("DADI3", "DADI3");
		tmpFlag.put("DADI4", "DADI4");
		tmpFlag.put("CGV", "CGV");
		tmpFlag.put("CFC", "CFC");
		tmpFlag.put("TXPC2", "TXPC2");
		tmpFlag.put("VISTA2", "VISTA2");
		tmpFlag.put("SDZX", "SDZX");
		tmpFlag.put("MJY2", "MJY2");
		tmpFlag.put("VISTA3", "VISTA3");
		tmpFlag.put("WP", "WP");
		tmpFlag.put("BL", "BL");
		tmpFlag.put("HFH2", "HFH2");
		tmpFlag.put("CTJH", "CTJH");
		tmpFlag.put("WD3", "WD3");
		tmpFlag.put("CGV2", "CGV2");
		partnerFlagMap = MapUtils.unmodifiableMap(tmpFlag);
		LinkedHashMap tmpTakemethod = new LinkedHashMap();
		tmpTakemethod.put("P", "现场派送");
		tmpTakemethod.put("W", "影院售票窗口");
		tmpTakemethod.put("A", "格瓦拉取票机");
		tmpTakemethod.put("F", "格瓦拉全网取票机");
		tmpTakemethod.put("U", "联和院线自助取票机");
		tmpTakemethod.put("L", "卢米埃影院自助取票机");
		tmpTakemethod.put("D", "万达院线自助取票机");
		tmpTakemethod.put("J", "金逸院线自助取票机");
		tmpTakemethod.put("M", "影院会员自助取票机");
		tmpTakemethod.put("E", "大地会员取票机");
		tmpTakemethod.put("T", "天下票仓取票机");
		takemethodMap = MapUtils.unmodifiableMap(tmpTakemethod);
		HashMap tmpInvalidMap = new HashMap();
		tmpInvalidMap.put("FB", "火烈鸟");
		tmpInvalidMap.put("FB2", "火烈鸟2");
		tmpInvalidMap.put("JY", "老金逸");
		tmpInvalidMap.put("DADI", "大地");
		tmpInvalidMap.put("XFLH", "幸福蓝海");
		invaildPartnerMap = MapUtils.unmodifiableMap(tmpInvalidMap);
	}
}