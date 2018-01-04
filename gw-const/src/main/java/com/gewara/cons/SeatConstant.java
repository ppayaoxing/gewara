package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SeatConstant {
	public static final String STATUS_NEW = "A";//新座位
	public static final String STATUS_SELLING = "W";//售出待付款（数据库中不存在此状态，只有status==A and validtime<cur才会返回此状态）
	public static final String STATUS_SOLD = "S";//售出
	
	public static final String STATUS_LOCKB = "B";//影院售出锁定
	public static final String STATUS_LOCKC = "C";//保留座位锁定
	public static final String STATUS_LOCKD = "D";//赠票锁定
	
	public static final String STATUS_LOCKZ = "Z";//影院维修锁定
	
	public static final String STATUS_LOCKM = "M";	//普通用户锁定座位
	public static final String STATUS_LOCKG = "G";	//来宾用户锁定座位
	
	public static final String STATUS_LOCK_REMOTE = "R";//影院售出锁定
	
	private static final Map<String, String> statusTextMap = new HashMap<String, String>();
	static{
		statusTextMap.put(STATUS_LOCKB, "影院售出锁定");
		statusTextMap.put(STATUS_LOCKC, "保留座位锁定");
		statusTextMap.put(STATUS_LOCKD, "赠票锁定");
		statusTextMap.put(STATUS_LOCKZ, "影院维修锁定");
	}
	public static final List<String> STATUS_LOCK_LIST = Arrays.asList(STATUS_LOCKB, STATUS_LOCKC, STATUS_LOCKD);
	//包含维修座位
	public static final List<String> STATUS_LOCK_LIST2 = Arrays.asList(STATUS_LOCKB, STATUS_LOCKC, STATUS_LOCKD, STATUS_LOCKZ);


}
