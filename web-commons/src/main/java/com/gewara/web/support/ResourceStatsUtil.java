package com.gewara.web.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.ServiceCacheHelper;


public class ResourceStatsUtil {
	private static DynamicStats badUrlStats = new DynamicStats("badurl");
	private static DynamicStats callStats = new DynamicStats("call");
	private static DynamicStats uriStats = new DynamicStats("uri");
	private static DynamicStats jmsStats = new DynamicStats("jms");
	private static DynamicStats pageCacheStats = new DynamicStats("pageCache");
	private static DynamicStats apiMethodStats = new DynamicStats("apiMethod");
	//�������ͳ��
	private static DynamicStats errorStats = new DynamicStats("errorStats");
	private static List<ServiceCacheHelper> schList = new ArrayList<ServiceCacheHelper>();
	//�첽�����Url��Spring��DefferedResult
	
	
	//��¼��ǰ����
	private static Map<Integer, HttpServletRequest> requestMap = new ConcurrentHashMap<Integer, HttpServletRequest>(4096, 0.75f, 32);
	private static AtomicInteger curreqLoc = new AtomicInteger(0);
	public static DynamicStats getErrorStats() {
		return errorStats;
	}

	public static DynamicStats getBadUrlStats() {
		return badUrlStats;
	}
	public static DynamicStats getUriStats() {
		return uriStats;
	}
	public static DynamicStats getCallStats() {
		return callStats;
	}
	public static DynamicStats getJmsStats(){
		return jmsStats;
	}
	public static DynamicStats getPageCacheStats(){
		return pageCacheStats;
	}
	public static List<ServiceCacheHelper> getServiceCacheHelperList(){
		return new ArrayList<ServiceCacheHelper>(schList);
	}
	public static void addServiceCacheHelper(ServiceCacheHelper sch){
		schList.add(sch);
	}
	public static DynamicStats getApiMethodStats(){
		return apiMethodStats;
	}

	/**
	 * ��¼��������
	 * @param request
	 * @param multiPart
	 * @return
	 */
	public static Integer recordRequest(HttpServletRequest request, boolean multiPart) {
		if(multiPart) {
            return -1;
        }
		Integer loc = curreqLoc.getAndIncrement();
		requestMap.put(loc, request);
		return loc;
	}
	/**
	 * �������ڴ�����������
	 * @param max
	 * @return
	 */
	public static List<Map> dumpRequest(int max){
		List<Map> result = new ArrayList<Map>();
		for(Map.Entry<Integer, HttpServletRequest> entry: requestMap.entrySet()){
			HttpServletRequest req = entry.getValue();
			if(req!=null){
				Map reqMap = new LinkedHashMap();
				reqMap.put("uri", req.getRequestURI());
				reqMap.put("params", BaseWebUtils.getParamStr(req, true));
				reqMap.put("header", BaseWebUtils.getHeaderStr(req));
				result.add(reqMap);
			}
		}
		return result;
	}

	/**
	 * �����������
	 * @param loc
	 */
	public static void clearRequest(Integer loc) {
		if(loc>=0) {
			requestMap.remove(loc);
		}
	}
	
	/**
	 * �����ڵ�URI
	 * @param uri
	 */
	public static void addUrlNoHandler(String uri){
		badUrlStats.incrementCount(uri);
	}
	public static Map<String, Integer> clearUriIfMaxClick(int maxcount) {
		Map<String, Integer> result = badUrlStats.getStatsAndClear(maxcount);
		return result;
	}
	
	/**
	 * ע�����б�
	 * @return
	 */
	public static void registerUri(Set<String> uriList, String contextPath){
		if(StringUtils.isBlank(contextPath)||StringUtils.equals(contextPath, "/")){
			contextPath = "";
		}else if(contextPath.endsWith("/")){
			contextPath = contextPath.substring(0, contextPath.length()-1);
		}
		long cur = System.currentTimeMillis();
		for(String uri: uriList){
			uriStats.register(contextPath + uri, cur);
		}
		uriStats.setInit(true);
	}

	public static void registerCall(String callName){
		long cur = System.currentTimeMillis();
		callStats.register(callName, cur);
	}
	
	public static Map<String, String> updateUriProcessTime(String uri, long elapsed, int maxcount) {
		return uriStats.updateProcessTime(uri, elapsed, maxcount);
	}
	public static void addAsynchUri(Set<String> uriList, String contextPath){
		if(StringUtils.isBlank(contextPath)||StringUtils.equals(contextPath, "/")){
			contextPath = "";
		}else if(contextPath.endsWith("/")){
			contextPath = contextPath.substring(0, contextPath.length()-1);
		}
		for(String uri: uriList){
			uriStats.addSpecialType(contextPath + uri, "asynch");
		}
	}
	
}
