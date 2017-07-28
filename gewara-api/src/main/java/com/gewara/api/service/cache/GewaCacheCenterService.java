/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.cache;

import com.gewara.support.ErrorCode;
import java.util.List;
import java.util.Map;

public interface GewaCacheCenterService {
	void clearCacheFilmfestMovie(Long arg0);

	void refreshAppLoginImg(String arg0);

	void refreshDramaAppLoginImg(String arg0, String arg1);

	void refreshAppConfigPersonalseat();

	void refreshAppConfigSeatCheck(String arg0);

	void refreshAppConfigSeatCheck(String arg0, Long arg1, String arg2);

	void clearOpenSeatCache(Long arg0, String arg1);

	void clearPhoneAdvertList(String arg0, String arg1, String arg2, String arg3);

	void clearSpecialDiscount(String arg0);

	void clearSalesPromotion(String arg0);

	void clearRemindSpecialDiscount();

	ErrorCode<String> refreshAccessToken(Long arg0);

	ErrorCode<String> refreshJsapiTicket(String arg0);

	List<String> refreshLockSeatList(Long arg0, String arg1);

	List<String> getLockSeatList(Long arg0, String arg1);

	Map<String, String> getLockSeatStatusMap(Long arg0, String arg1);
}