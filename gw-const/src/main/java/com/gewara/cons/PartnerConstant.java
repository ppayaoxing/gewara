/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import java.util.List;

public class PartnerConstant {
	public static final long GEWA_SELF = 1L;
	public static final Long GEWAP = Long.valueOf(50000010L);
	public static final Long WEIXIN = Long.valueOf(50000012L);
	public static final Long IPHONE = Long.valueOf(50000070L);
	public static final Long IPHONE_FILM = Long.valueOf(50000071L);
	public static final Long ANDROID = Long.valueOf(50000020L);
	public static final Long GEWA_DRAMA_ANDROID = Long.valueOf(50000080L);
	public static final Long GEWA_DRAMA_IPHONE = Long.valueOf(50000081L);
	public static final Long GEWA_DRAMA_ADMIN_MOBILE = Long.valueOf(50000082L);
	public static final Long GEWA_DRAMA_ADMIN_OFFLINE = Long.valueOf(50000083L);
	public static final Long GEWA_HTC = Long.valueOf(50000091L);
	public static final Long GEWA_WOMOVIE_PC = Long.valueOf(50000089L);
	public static final Long GEWA_WOMOVIE_ANDROID = Long.valueOf(50000092L);
	public static final Long GEWA_WOMOVIE_IOS = Long.valueOf(50000093L);
	public static final Long CMCC_ANDROID = Long.valueOf(50000099L);
	public static final Long GEWA_CLIENT = Long.valueOf(50000100L);
	public static final Long MIN_PARTNERID = Long.valueOf(50000000L);
	public static final Long MAX_PARTNERID = Long.valueOf(51000000L);
	public static final Long PARTNER_CHANGTU = Long.valueOf(50000040L);
	public static final Long PARTNER_CUS = Long.valueOf(50000240L);
	public static final Long PARTNER_SHOKW = Long.valueOf(50000130L);
	public static final Long PARTNER_SPSDO = Long.valueOf(50000145L);
	public static final Long PARTNER_ONLINE = Long.valueOf(50000150L);
	public static final Long PARTNER_UNION = Long.valueOf(50000160L);
	public static final Long PARTNER_ANXIN_TERM = Long.valueOf(50000170L);
	public static final Long PARTNER_SRCB = Long.valueOf(50000547L);
	public static final Long PARTNER_JIFUTONG = Long.valueOf(50000630L);
	public static final Long PARTNER_TAOBAO = Long.valueOf(50000700L);
	public static final Long PARTNER_SAND = Long.valueOf(50000800L);
	public static final Long PARTNER_JU_XIANG = Long.valueOf(50000501L);
	public static final Long PARTNER_12580 = Long.valueOf(50000890L);
	public static final Long PARTNER_SHOP10086 = Long.valueOf(50000703L);
	public static final Long PARTNER_FILMSH = Long.valueOf(50000899L);
	public static final Long PARTNER_BOX_PAY = Long.valueOf(50000420L);
	public static final Long PARTNER_PUFABANK = Long.valueOf(50000891L);
	public static final Long PARTNER_MOBILETICKET = Long.valueOf(50000885L);
	public static final Long PARTNER_VERYCD = Long.valueOf(50000900L);
	public static final Long PARTNER_SXFILM = Long.valueOf(50000901L);
	public static final Long PARTNER_ZHOUKANG = Long.valueOf(50000994L);
	public static final Long PARTNER_SUN0575 = Long.valueOf(50000997L);
	public static final Long PARTNER_SXOL = Long.valueOf(50000886L);
	public static final Long PARTNER_SRCBSHOP = Long.valueOf(50000770L);
	public static final Long PARTNER_CE9 = Long.valueOf(50000771L);
	public static final Long PARTNER_UNIONPAY = Long.valueOf(50000772L);
	public static final Long PARTNER_BAIDU = Long.valueOf(50000778L);
	public static final Long PARTNER_HANGZHOUAPP = Long.valueOf(50000986L);
	public static final Long PARTNER_IMAX = Long.valueOf(50000987L);
	public static final Long PARTNER_LEWA = Long.valueOf(50000701L);
	public static final Long PARTNER_ALIBABAYUN = Long.valueOf(50000702L);
	public static final Long PARTNER_91MOBILE = Long.valueOf(50000705L);
	public static final Long PARTNER_91MOBILE_IOS = Long.valueOf(50000706L);
	public static final Long PARTNER_WEIBO_H5 = Long.valueOf(50000088L);
	public static final Long PARTNER_MOVIE_TERMINAL = Long.valueOf(50000124L);
	public static final Long PARTNER_WEIPIAO = Long.valueOf(50000119L);
	public static final Long PARTNER_DISNEY_PC = Long.valueOf(51000001L);
	public static final Long PARTNER_DISNEY_WAP = Long.valueOf(51000002L);

	public static boolean isMobilePartner(List<String> mList, Long partnerid) {
		return partnerid == null ? false : mList.contains(partnerid + "");
	}

	public static boolean isOutPartner(Long memberid) {
		return memberid.longValue() >= MIN_PARTNERID.longValue() && memberid.longValue() <= MAX_PARTNERID.longValue();
	}

	public static boolean isGewaPartner(Long memberid, Long partnerid) {
		return partnerid.longValue() > 1L && (memberid.longValue() < MIN_PARTNERID.longValue()
				|| memberid.longValue() > MAX_PARTNERID.longValue());
	}

	public static boolean isGewaMember(Long memberid) {
		return memberid.longValue() < MIN_PARTNERID.longValue() || memberid.longValue() > MAX_PARTNERID.longValue();
	}

	public static boolean isDisneyPartner(Long memberid) {
		return PARTNER_DISNEY_PC.equals(memberid) || PARTNER_DISNEY_WAP.equals(memberid);
	}
}