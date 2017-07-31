package com.gewara.bean.config;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.gewara.Config;
public class GwPropertyPlaceholderConfigurer extends  PropertyPlaceholderConfigurer{
	@Override
	protected void convertProperties(Properties props){
		props.setProperty("dubbo.host", Config.getServerIp());
		super.convertProperties(props);
	}
}
