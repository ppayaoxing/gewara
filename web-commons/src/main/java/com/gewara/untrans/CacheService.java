/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.support.CachePair;
import com.gewara.untrans.CacheTools;
import java.util.Collection;
import java.util.Map;

public interface CacheService extends CacheTools {
	String REGION_TENMIN = "tenMin";
	String REGION_ONEHOUR = "oneHour";
	String REGION_LOGINAUTH = "loginAuth";
	String REGION_SERVICE = "service";
	String REGION_FIVEDAY = "fiveDay";

	Map<String, Object> getBulk(String arg0, Collection<String> arg1);

	void set(String arg0, String arg1, Object arg2, int arg3);

	void updateValue(String arg0, String arg1, String arg2);

	void refreshVersion();

	Integer getCacheTime(String arg0);

	int incr(String arg0, String arg1, int arg2, int arg3);

	int incrementAndGet(String arg0, String arg1, int arg2, int arg3);

	CachePair getCachePair(String arg0, String arg1);

	boolean setCachePair(String arg0, String arg1, long arg2, Object arg4, int arg5);

	void add(String arg0, String arg1, Object arg2, int arg3);

	int decrAndGet(String arg0, String arg1, int arg2, int arg3);

	int incrementAndGet(String arg0, String arg1, int arg2, int arg3, int arg4);
}