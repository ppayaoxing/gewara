/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.bean.config;

import com.gewara.Config;
import java.util.Properties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class GwPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	protected void convertProperties(Properties props) {
		props.setProperty("dubbo.host", Config.getServerIp());
		super.convertProperties(props);
	}
}