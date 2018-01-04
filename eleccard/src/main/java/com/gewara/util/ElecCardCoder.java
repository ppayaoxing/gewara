package com.gewara.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class ElecCardCoder {
	private static long newtime = 1273308687156L;
	private static boolean enabled = false;

	static {
		Map<String,String> hostMap = getServerAddrMap();
		for (String addr : hostMap.keySet()) {
            if (addr.startsWith("192.168")) {
                enabled = true;
            }
        }
	}

	public static String encode(String str) {
		return str;
	}

	public static String getEncodePk() {
		if (!(enabled)) {
            throw new IllegalArgumentException("only for test!");
        }
		return StringUtil.getRandomString(12, true, false, true);
	}

	public static String decode(String encodeStr) {
		return encodeStr;
	}

	public static boolean isValidPass(String pass, Long time) {
		if (time.longValue() <= newtime) {
            return true;
        }
		return (pass.length() == 12);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(isValidPass("L4TK9SXK4A86", Long.valueOf(System.currentTimeMillis())));
	}

	private static Map<String, String> getServerAddrMap() {
		Map hostMap = new TreeMap();
		try {
			Enumeration niList = NetworkInterface.getNetworkInterfaces();
			while (niList.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) niList.nextElement();
				Enumeration addrList = ni.getInetAddresses();
				while (addrList.hasMoreElements()) {
					InetAddress addr = (InetAddress) addrList.nextElement();
					if (addr instanceof Inet4Address) {
                        hostMap.put(addr.getHostAddress(), addr.getHostName());
                    }
				}
			}
		} catch (Exception localException) {
		}
		return hostMap;
	}
}