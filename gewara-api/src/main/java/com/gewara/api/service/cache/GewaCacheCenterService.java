package com.gewara.api.service.cache;

import java.util.List;
import java.util.Map;

import com.gewara.support.ErrorCode;

public interface GewaCacheCenterService {

	//void clearCacheMoviesSpread(Long movieid);
	
	void clearCacheFilmfestMovie(Long belongToId);
	
	void refreshAppLoginImg(String apptype);
	
	void refreshDramaAppLoginImg(String apptype, String citycode);

	void refreshAppConfigPersonalseat();
	
	void refreshAppConfigSeatCheck(String appkey);
	
	void refreshAppConfigSeatCheck(String tag, Long relatedId, String citycode);
	
	void clearOpenSeatCache(Long mpid, String secid);
	
	void clearPhoneAdvertList(String apptype, String osType, String citycode, String advtype);
	
	void clearSpecialDiscount(String tag);	

	void clearSalesPromotion(String tag);
	
	void clearRemindSpecialDiscount();

	ErrorCode<String> refreshAccessToken(Long partnerid);

	ErrorCode<String> refreshJsapiTicket(String type);
	
	List<String> refreshLockSeatList(Long mpid, String secid);

	List<String> getLockSeatList(Long mpid, String secid);

	Map<String, String> getLockSeatStatusMap(Long mpid, String secid);
	
}
