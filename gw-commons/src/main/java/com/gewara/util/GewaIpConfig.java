package com.gewara.util;

import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * �Զ����ñ���IP��
 * 1���Զ�ɨ�� 192.168.2., 192.168.8., 192.168.3., 172.28., 172.22.,10.47.,10.147.
 * 2���Զ�ɨ��searchip.txt�ļ��а�����IP
 * @author ge.biao(acerge@163.com)
 * @since 2016��9��19������4:59:38
 */
public abstract class GewaIpConfig {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(GewaIpConfig.class);

	private static final String serverIp;
	private static final String hostname;
	private static final List<String> searchList;
	//��������IP
	private static final List<String> innerLocalIp;

	private static final List<String> officeIp = Arrays.asList("101.95.157.134", "124.74.105.54");
	
	
	//private static final List<String> preEnvIp = Arrays.asList("172.28.15.41","172.28.80.41",
	//		"172.22.1.19","172.28.10.121", "172.28.16.41"/*report*/, "172.28.16.154"/*report test*/);
	
	private static final List<String> nhIpList = Arrays.asList(
			//nanhui
			"180.153.135.116","180.153.135.117","180.153.135.118","180.153.135.119",
			"180.153.135.120","180.153.135.121","180.153.135.122","180.153.135.123",
			"180.153.135.124","180.153.135.125","180.153.135.126","114.80.171.245",
			"114.80.171.247","114.80.171.248","114.80.171.250",
			"114.80.171.251","114.80.171.252","114.80.171.253");
	private static final List<String> aliyunIpList = new ArrayList<String>();
	
	static{
		searchList = new ArrayList<>();
		searchList.addAll(Arrays.asList(new String[]{"192.168.2.", "192.168.8.", "192.168.3.", "172.28."/*bs*/, "172.22."/*nh*/}));
		
		//aliyun local
		searchList.add("10.47.");
		searchList.add("10.147.");

		innerLocalIp = new ArrayList<>();
		innerLocalIp.addAll(Arrays.asList(new String[]{"172.22.1.", "172.28."}));
		
		//aliyun local
		innerLocalIp.add("10.47.");
		innerLocalIp.add("10.147.");
		try(InputStream is = GewaIpConfig.class.getClassLoader().getResourceAsStream("searchip.txt");){
			if(is!=null){
				List<String> ips = IOUtils.readLines(is);
				searchList.addAll(ips);
				aliyunIpList.addAll(ips);
			}
		} catch (Exception e) {
		}

		try(InputStream is = GewaIpConfig.class.getClassLoader().getResourceAsStream("inner_local_ip.txt");){
			if(is!=null){
				List<String> ips = IOUtils.readLines(is);
				innerLocalIp.addAll(ips);
			}
		} catch (Exception e) {
		}
				
		String[] host = GewaIpConfig.getServerAddr();
		serverIp = host[0];
		dbLogger.warn("GetServerIP:" + serverIp);
		//hostname = host[1];
		String h = "";
		try {
			h = java.net.InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if(StringUtils.isBlank(h)){
			h = host[1];
		}
		hostname = h;
	}
	
	public static boolean isNanhuiIp(String ip){
		return nhIpList.contains(ip);
	}
	public static boolean isAliyunIp(String ip){
		return aliyunIpList.contains(ip);
	}
	/**
	 * �Ƿ��ǻ�������IP
	 * @param ip
	 * @return
	 */
	public static boolean isGewaInnerIp(String ip){
		for(String inner:innerLocalIp){
			if(StringUtils.startsWith(ip, inner)){
				return true;
			}
		}
		return false;
	}
	public static boolean isOfficeIp(String ip){
		return officeIp.contains(ip);
	}

	public static final boolean isLocalIp(String ip) {
		// ����
		return ip.contains("192.168.") || "127.0.0.1".equals(ip) || ip.endsWith(":1")/*win10 local*/;
	}
	public static final boolean isGewaLocalIp(String ip) {
		// ����
		return ip.contains("192.168.") || "127.0.0.1".equals(ip) || ip.endsWith(":1")/*win10 local*/;
	}

	/**
	 * �ǿ�����Ա�����Ļ���
	 * @return
	 */
	public static final boolean isDevServer() {
		// ����
		return serverIp.contains("192.168.") || "127.0.0.1".equals(serverIp) || serverIp.endsWith(":1")/*win10 local*/;
	}

	public static void filterIp(String ip){
		if(isGewaInnerIp(ip) || isLocalIp(ip)){
			return;
		}
		throw new IllegalArgumentException("invalid ip");
	}
	public static boolean allowOffice(String ip){
		return isGewaInnerIp(ip) || isLocalIp(ip) || isOfficeIp(ip);
	}
	public static void filterOfficeIp(String ip){
		if(isGewaInnerIp(ip) || isLocalIp(ip) || isOfficeIp(ip)){
			return;
		}
		throw new IllegalArgumentException("invalid ip");
	}
	public static boolean isGewaServerIp(String ip){
		for(String search: searchList){
			if(StringUtils.startsWith(ip, search)) {
                return true;
            }
		}
		return false;
	}
	public static String[] getServerAddr(){
		Map<String, String> hostMap = getServerAddrMap();
		for(String search: searchList){
			for(String addr: hostMap.keySet()){
				if(addr.startsWith(search)){
					return new String[]{addr, hostMap.get(addr)};
				}
			}
		}
		return new String[]{"127.0.0.1", "localhost"};
	}
	private static Map<String, String> getServerAddrMap(){
		Map<String, String> hostMap = new TreeMap<String, String>();
		try{
			Enumeration<NetworkInterface> niList = NetworkInterface.getNetworkInterfaces();
			while(niList.hasMoreElements()){
				NetworkInterface ni = niList.nextElement();
				Enumeration<InetAddress> addrList = ni.getInetAddresses();
				while(addrList.hasMoreElements()){
					InetAddress addr = addrList.nextElement();
					if(addr instanceof Inet4Address) {//ֻ��IPV4
						hostMap.put(addr.getHostAddress(), addr.getHostName());
					}
				}
			}
		}catch(Exception e){
		}
		dbLogger.warn("SERVER-IP:" + hostMap);
		return hostMap;
	}
	public static String getServerip() {
		return serverIp;
	}
	public static String getHostname() {
		return hostname;
	}
}
