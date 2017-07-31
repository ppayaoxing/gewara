package com.gewara.constant;


public class AttackConstant {
	/**黑名单状态：有效的*/
	public static final String STATUS_ACTIVATED = "activated";
	/**黑名单状态：无有效的*/
	public static final String STATUS_DEACTIVATED = "deactivated";
	/**黑名单状态：已删除的*/
	public static final String STATUS_DELETED = "deleted";
	
	/**新增来源：手动*/
	public static final String ADDSOURCE_MANUAL = "manual";	
	/**新增来源：url*/
	public static final String ADDSOURCE_URL = "url";	
	/**新增来源：ip*/
	public static final String ADDSOURCE_IP = "ip";
	/**新增来源：Exception攻击*/
	public static final String ADDSOURCE_ATTACK = "attack";
	
	public static final String ACCESS_URL_ALL = "ALL";//限制IP所有访问


	/**重点uri防护同步前缀，通知到具体系统，需加上系统id*/
	public static final String CHANGE_URI = "attack.uri.change.";
	public static final String CHANGE_BLACK = "attack.black.change";
	public static final String CHANGE_WHITE = "attack.white.change";

	/**
	 * 重点url规则配置修改变动通知地址
	 */
	public static final String CHANGE_CONFIG = "attack.config.change";

	/**用来获取黑名单IP*/
	public static final String URI_GET_BLACKLIST = "/inner/ip/blackList.xhtml";
	/**用来获取变更的黑名单IP*/
	public static final String URI_GET_CHANGED_BLACK ="/inner/ip/black/getNewBlackList.xhtml";
	/**用来获取白名单IP*/
	public static final String URI_GET_ALLWHITE = "/inner/ip/white/getAll.xhtml";
	
	public static final String URI_GET_URL_CONFIG = "/inner/url/config/get.xhtml";
}
