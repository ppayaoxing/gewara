package com.alibaba.dubbo.config;

public class TrafficControlData {
	private static boolean IS_TRAFFIC_CONTROL = false;
	private static int SERVICE_EXECUTES_LIMIT = 50;
	
	public static boolean isTrafficControl() {
		return IS_TRAFFIC_CONTROL;
	}
	public static void setIS_TRAFFIC_CONTROL(boolean iS_TRAFFIC_CONTROL) {
		IS_TRAFFIC_CONTROL = iS_TRAFFIC_CONTROL;
	}
	public static int getSERVICE_EXECUTES_LIMIT() {
		return SERVICE_EXECUTES_LIMIT;
	}
	public static void setSERVICE_EXECUTES_LIMIT(int sERVICE_EXECUTES_LIMIT) {
		SERVICE_EXECUTES_LIMIT = sERVICE_EXECUTES_LIMIT;
	}
	
}
