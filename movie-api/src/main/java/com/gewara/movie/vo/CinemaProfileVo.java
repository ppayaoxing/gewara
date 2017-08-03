package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.movie.constant.Status;
import com.gewara.util.DateUtil;

/**
 * @author acerge(acerge@163.com)
 * @since 3:05:09 PM Jan 15, 2010
 */
public class CinemaProfileVo extends BaseVo{
	private static final long serialVersionUID = -3804714651086763962L;
	public static final String STATUS_OPEN = "open";
	public static final String STATUS_CLOSE = "close";
	public static final String POPCORN_STATUS_Y ="Y";//有爆米花
	public static final String POPCORN_STATUS_N ="N";//没有爆米花
	public static final String SERVICEFEE_Y ="Y";//有服务费
	public static final String SERVICEFEE_N ="N";//没有服务费
	public static final String INSURE_STATUS_OPEN = "open";
	public static final String INSURE_STATUS_CLOSE = "close";
	
	public static final String TAKEMETHOD_P = "P";//现场派送
	public static final String TAKEMETHOD_W = "W";//影院售票窗口
	public static final String TAKEMETHOD_A = "A";//格瓦拉取票机
	public static final String TAKEMETHOD_F = "F";//格瓦拉全网取票机
	public static final String TAKEMETHOD_U = "U";//联合院线
	public static final String TAKEMETHOD_L = "L";//卢米埃影院自助取票机
	public static final String TAKEMETHOD_D = "D";//万达院线自助取票机
	public static final String TAKEMETHOD_J = "J";//金逸院线自助取票机
	public static final String TAKEMETHOD_M = "M";//影院会员自助取票机
	public static final String TAKEMETHOD_E = "E";//大地会员自助取票机
	public static final String TAKEMETHOD_T = "T";//天下票仓自助取票机
	public static final String TAKEMETHOD_AFT = "AFT";//（格瓦拉自己的取票机）
	
	private Long id;				//与Cinema共用ID
	private String notifymsg1;		//取票短信
	private String notifymsg2;		//提前3小时提醒短信
	private String notifymsg3;		//微票取票短信
	private String notifymsg4;		//微票取票短信
	private String notifymsg5;		//微票取票短信
	private String takemethod; 		//取票方式: P：现场派送，W：影院售票窗口，A：自动取票机
	private Long topicid;			//取票帖子
	private String takeAddress;     //取票位置
	private String opentime;		//每天开放购票时间，如6:00开放写 0600
	private String closetime;		//每天关闭购票时间
	private String startsale;		//每天买套餐的开始时间 0800
	private String endsale;			//每天买套餐的结束时间 2300
	private String popcorn;      	//是否是含有爆米花影院
	private String servicefee;		//服务费
	private String status;			//开放状态
	private Integer cminute;		//提前多长时间关闭(分钟)
	private Integer openDay;         //提前开放时间(例如：1 表示1天)
	private String openDayTime;		 //提前开放几天的具体时间(例如：6:00开放写 0600)
	private Integer fee;			//服务费
	private String isRefund;		//是否可以退票Y or N
	private String isGewaRefund;	//是否支持Gewa退款（Y/N）
	private String opentype;		//影院开放类型：HFH, MTX, DX
	private String direct;			//是否直连Y or N
	private String prompting;		//提示说明
	private String isInsure;    	//是否支持购买平安保险  N或null值表示不支持。open表示开启支持，close表示暂停关闭售险
	private String openPriority;  	//场次设置开放优先级
	private String globalLimit;		//全局屏蔽器GlobalLimit，Y启用，N：禁用
	private Integer passlen;		//取票密码长度
	protected Timestamp updatetime;	//修改时间	
	private Boolean fromCache = false; //是否来自本地缓存

	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CinemaProfileVo(){
	}
	public CinemaProfileVo(Long cinemaid){
		this();
		this.opentime = "0000";
		this.closetime = "2400";
		this.cminute = 60;
		this.id = cinemaid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotifymsg1() {
		return notifymsg1;
	}
	public void setNotifymsg1(String notifymsg1) {
		this.notifymsg1 = notifymsg1;
	}
	public String getNotifymsg2() {
		return notifymsg2;
	}
	public void setNotifymsg2(String notifymsg2) {
		this.notifymsg2 = notifymsg2;
	}
	public Long getTopicid() {
		return topicid;
	}
	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}
	public String getTakemethod() {
		return takemethod;
	}
	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}
	public String getOpentime() {
		return opentime;
	}
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	public String getClosetime() {
		return closetime;
	}
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}
	public String getStartsale() {
		return startsale;
	}
	public void setStartsale(String startsale) {
		this.startsale = startsale;
	}
	public String getEndsale() {
		return endsale;
	}
	public void setEndsale(String endsale) {
		this.endsale = endsale;
	}
	public String getTakeAddress() {
		return takeAddress;
	}
	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
	}
	public boolean isBuyItem(Timestamp playtime){
		if(StringUtils.isNotBlank(startsale) && StringUtils.isNotBlank(endsale)){
			String time = DateUtil.format(playtime, "HHmm");
			if(time.compareTo(startsale)<0 || time.compareTo(endsale)>0) return false;
		}
		return true;
	}
	public String getPopcorn() {
		return popcorn;
	}
	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}
	public String getTakeInfo(){
		String result = "在位于影院的格瓦拉自助取票机取票";
		if(StringUtils.equals(takemethod, TAKEMETHOD_U)){
			result = "在位于影院的联和院线自助取票机取票";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_W)){
			result = "影院售票窗口取票";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_P)){
			result = "现场派送";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_L)){
			result = "在位于影院的卢米埃影院自助取票机";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_D)){
			result = "在位于影院的万达院线自助取票机";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_J)){
			result = "在位于影院的金逸院线自助取票机";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_M)){
			result = "在位于影院的影院会员自助取票机";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_E)){
			result = "在位于影院的大地会员自助取票机";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_T)){
			result = "在位于影院的天下票仓自助取票机";
		}
		return result;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public Integer getCminute() {
		return cminute;
	}
	public void setCminute(Integer cminute) {
		this.cminute = cminute;
	}
	public String getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}
	public String getIsGewaRefund() {
		return isGewaRefund;
	}
	public void setIsGewaRefund(String isGewaRefund) {
		this.isGewaRefund = isGewaRefund;
	}
	public boolean supportRefundEnabled() {
		return (StringUtils.equals(isRefund, "Y") || StringUtils.equals(isGewaRefund, "Y"));
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getPrompting() {
		return prompting;
	}
	public void setPrompting(String prompting) {
		this.prompting = prompting;
	}
	public boolean hasDirect(){
		return StringUtils.equals(this.direct, Status.Y);
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public Integer getOpenDay() {
		return openDay;
	}
	public void setOpenDay(Integer openDay) {
		this.openDay = openDay;
	}
	public String getOpenDayTime() {
		return openDayTime;
	}
	public void setOpenDayTime(String openDayTime) {
		this.openDayTime = openDayTime;
	}
	
	public boolean hasDefinePaper(){
		return StringUtils.isNotBlank(this.takemethod) && CinemaProfileVo.TAKEMETHOD_AFT.contains(this.takemethod)
			&& CinemaProfileVo.STATUS_OPEN.equals(this.status);
	}
	public String getOpenPriority() {
		return openPriority;
	}
	public void setOpenPriority(String openPriority) {
		this.openPriority = openPriority;
	}
	public String getIsInsure() {
		return isInsure;
	}
	public void setIsInsure(String isInsure) {
		this.isInsure = isInsure;
	}
	public String getGlobalLimit() {
		return globalLimit;
	}
	public void setGlobalLimit(String globalLimit) {
		this.globalLimit = globalLimit;
	}
	public Integer getPasslen() {
		return passlen;
	}
	public void setPasslen(Integer passlen) {
		this.passlen = passlen;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Boolean getFromCache() {
		return fromCache;
	}
	public void setFromCache(Boolean fromCache) {
		this.fromCache = fromCache;
	}
	public String getNotifymsg3() {
		return notifymsg3;
	}
	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}
	public String getNotifymsg4() {
		return notifymsg4;
	}
	public void setNotifymsg4(String notifymsg4) {
		this.notifymsg4 = notifymsg4;
	}
	public String getNotifymsg5() {
		return notifymsg5;
	}
	public void setNotifymsg5(String notifymsg5) {
		this.notifymsg5 = notifymsg5;
	}
}
