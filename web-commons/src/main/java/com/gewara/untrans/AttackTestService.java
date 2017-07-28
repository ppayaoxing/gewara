/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.bean.BlackMatcher;
import java.util.List;
import java.util.Map;

public interface AttackTestService {
	void addRealBlack(String arg0, String arg1, int arg2);

	void resetBlack();

	void resetWhite();

	void setDisabled(boolean arg0);

	boolean checkBlackReq(String arg0, String arg1);

	Map<String, BlackMatcher> getBlackMap();

	boolean isDisabled();

	List<String> getWhiteList();

	String getRegScript(String arg0);

	Map<String, BlackMatcher> getBlackMap2();

	void refreshBlack();

	void refreshWhite(String arg0, String arg1);
}