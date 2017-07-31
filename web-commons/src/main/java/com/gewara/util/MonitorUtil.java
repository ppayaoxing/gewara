package com.gewara.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.Config;

public class MonitorUtil {

	private static String monitorPath = null;
	
	static{
		if(monitorPath==null){
			try{
				Object path = Config.getPageTools().get("monitorPath");
				if(path != null){
					monitorPath = String.valueOf(path);
				}
			}catch(Exception e){
			}
			if(StringUtils.isBlank(monitorPath)){
				if(GewaIpConfig.isGewaInnerIp(GewaIpConfig.getServerip())){
					monitorPath = "http://monitor.gewara.com/monitor";
				}else if(System.getProperty("test")!=null){
					monitorPath = "http://localhost/monitor";
				}else if(GewaIpConfig.isNanhuiIp(GewaIpConfig.getServerip())){
					monitorPath = "http://nhmonitor.gewara.com/monitor";
				}else{
					monitorPath = "http://monitor.gewala.net/monitor";
				}
			}else{
				if(StringUtils.endsWith(monitorPath, "/")){
					monitorPath = StringUtils.substringBeforeLast(monitorPath, "/");
				}
			}
		}
	}
	
	/**
	 * ±¨¾¯ 
	 * @see http://monitor.gewara.com/monitor/admin/sysmgr/msggroovy.xhtml
	 * @see http://monitor.gewara.com/monitor/admin/sysmgr/testMsgGroovy.xhtml
	 * @param systemid
	 * @param hostname
	 * @param fromIp
	 * @param keyword
	 * @param msg
	 */
	public static String alarm(String systemid, String hostname, String keyword, String msg){
		String content = "";
		if(StringUtils.isNotBlank(keyword)){
			content = keyword+";";
		}
		if(StringUtils.isNotBlank(systemid)){
			content += systemid+";";
		}
		if(StringUtils.isNotBlank(hostname)){
			content += SystemUtils.getShortHostname(hostname)+";";
		}
		if(StringUtils.isNotBlank(msg)){
			content += msg+";";
		}
		if(StringUtils.isNotBlank(content)){
			String url = monitorPath + "/sendMobileMsg.xhtml";
			Map<String, String> params = new HashMap<>();
			params.put("msg", content);
			HttpResult result = HttpUtils.getUrlAsString(url, params);
			if(result.isSuccess()){
				return content;
			}else{
				return "send err!";
			}
		}
		return "conent err!";
	}
	
	public static String getMonitorPath(){
		return monitorPath;
	}
}
