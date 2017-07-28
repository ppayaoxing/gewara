/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.Config;
import java.util.Properties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class GewaPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private static final String LOCAL_SERVER_IP = "local.server.ip";

	protected void convertProperties(Properties props) {
		props.setProperty("local.server.ip", Config.getServerIp());
		super.convertProperties(props);
	}
}