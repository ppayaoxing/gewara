package com.gewara;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.generic.MathTool;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.ErrorCode;
import com.gewara.support.TraceErrorException;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.SystemUtils;

public class Config implements InitializingBean {
	public static final String SYSTEMID;
	public static final String DEPLOYID;
	public static final String SESSION_COOKIE_NAME;
	private static boolean isHoutai = false;
	private static boolean isPreEnv = false;
	private static boolean isTestEnv = false;
	
	private static final Properties props = new Properties();
	static{
		try {
			props.load(Config.class.getClassLoader().getResourceAsStream("gewa-global.properties"));
		} catch (IOException e) {
			throw new TraceErrorException("", e);
		}
		SYSTEMID = props.getProperty("systemid");
		//searchList = props.getProperty("searchIpList").split(",");
		DEPLOYID = SYSTEMID + "-" + SystemUtils.getShortHostname(GewaIpConfig.getHostname());
		if(StringUtils.isNotBlank(props.getProperty("sessionCookieName"))){
			SESSION_COOKIE_NAME = props.getProperty("sessionCookieName");
		}else{
			SESSION_COOKIE_NAME = Config.SYSTEMID.toLowerCase() + "_uskey_";
		}
		if(StringUtils.isNotBlank(System.getenv("HOUTAI_SYSTEMID"))){
			List<String> idList = Arrays.asList(StringUtils.split(System.getenv("HOUTAI_SYSTEMID"), ","));
			isHoutai =  idList.contains(SYSTEMID)||idList.contains("ALL");
		}
		if(StringUtils.isNotBlank(System.getenv("PRE_ENV_SYSTEMID"))){
			List<String> idList = Arrays.asList(StringUtils.split(System.getenv("PRE_ENV_SYSTEMID"), ","));
			isPreEnv =  idList.contains(SYSTEMID)||idList.contains("ALL");
		}
		if(StringUtils.isNotBlank(System.getenv("TEST_ENV_SYSTEMID"))){
			List<String> idList = Arrays.asList(StringUtils.split(System.getenv("TEST_ENV_SYSTEMID"), ","));
			isTestEnv = idList.contains(SYSTEMID)||idList.contains("ALL");
		}
	}
	/**
	 * 是否是测试环境
	 * @param systemId
	 * @return
	 */
	public static boolean isTestEnv(){
		return isTestEnv;
	}
	/**
	 * 是否是机房预发环境
	 * @param systemId
	 * @return
	 */
	public static boolean isPreEnv(){
		return isPreEnv;
	}
	
	public static boolean isHoutai(){
		return isHoutai;
	}
	
	private Map<String, String> configMap = new HashMap<String, String>();
	private Map<String, Object> pageMap = new HashMap<String, Object>();
	private static Map pageTools;
	public static Map getPageTools() {
		return pageTools;
	}
	private boolean initedConfig = false;
	private boolean initedPage = false;
	public String getGlobalProp(String key){
		return props.getProperty(key);
	}
	public String getString(String key){
		String result = configMap.get(key);
		if(StringUtils.isBlank(result)){
			result = pageTools.get(key)==null?null:""+pageTools.get(key);
		}
		return result;
	}
	public Long getLong(String key){
		String result = getString(key);
		if(StringUtils.isBlank(result)) return null;
		return Long.parseLong(result);
	}
	public void setConfigMap(Map<String, String> configMap) {
		if (!initedConfig) {
			this.configMap = configMap;
			this.initedConfig = true;
		} else{
			throw new IllegalStateException("不能再次调用");
		}
	}
	public void setPageMap(Map<String, Object> pageMap) {
		if (!initedPage) {
			this.pageMap = pageMap;
			this.initedPage = true;
		} else{
			throw new IllegalStateException("不能再次调用");
		}
	}
	public Map<String, Object> getPageMap(){
		return new HashMap<String, Object>(pageMap);
	}
	public static String getServerIp() {
		return GewaIpConfig.getServerip();
	}
	public static String getHostname() {
		return GewaIpConfig.getHostname();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.configMap = UnmodifiableMap.decorate(this.configMap);
		initPageTools();
	}
	public void initPageTools(){
		Map tmp = new HashMap();
		tmp.put("math", new MathTool());
		tmp.put("DateUtil", new DateUtil());
		tmp.putAll(pageMap);
		pageTools = UnmodifiableMap.decorate(tmp);
	}
	public ErrorCode replacePageTool(String property, Object value){
		Object old = pageTools.get(property);
		if(value == null || old == null) return ErrorCode.getFailure("参数错误:old 或 new 为空");
		if(!value.getClass().equals(old.getClass())) return ErrorCode.getFailure("参数类型不兼容");
		Map tmp = new HashMap(pageTools);
		tmp.put(property, value);
		pageTools = UnmodifiableMap.decorate(tmp);
		if(pageMap.containsKey(property)){
			pageMap.put(property, value);
		}
		return ErrorCode.SUCCESS;
	}	

	public String getBasePath() {
		return (String) pageMap.get("basePath");
	}

	public String getAbsPath() {
		return (String) pageMap.get("absPath");
	}
	public String getCacheVersionKey(){
		return getString("cacheVersionKey");
	}
	public static boolean isGewaServerIp(String ip){
		return GewaIpConfig.isGewaServerIp(ip);
	}
}
