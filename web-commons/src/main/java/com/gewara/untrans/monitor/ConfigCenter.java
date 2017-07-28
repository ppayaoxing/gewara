/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.ConfigData;
import com.gewara.untrans.monitor.ConfigTrigger;

public interface ConfigCenter {
	void register(String arg0, String arg1, ConfigTrigger arg2);

	void registerGlobal(String arg0, ConfigTrigger arg1);

	void register(String arg0, String arg1, ConfigTrigger arg2, int arg3);

	void registerGlobal(String arg0, ConfigTrigger arg1, int arg2);

	void refresh(String arg0, String arg1);

	void refresh(String arg0, String arg1, String arg2);

	void refreshGlobal(String arg0);

	void refreshGlobal(String arg0, String arg1);

	void reloadGlobal(String arg0);

	void reloadCurrent(String arg0, String arg1);

	ConfigData getConfigData(String arg0, String arg1);
}