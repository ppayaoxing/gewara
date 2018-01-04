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
	public static final String POPCORN_STATUS_Y ="Y";//锟叫憋拷锟阶伙拷
	public static final String POPCORN_STATUS_N ="N";//没锟叫憋拷锟阶伙拷
	public static final String SERVICEFEE_Y ="Y";//锟叫凤拷锟斤拷锟�
	public static final String SERVICEFEE_N ="N";//没锟叫凤拷锟斤拷锟�
	public static final String INSURE_STATUS_OPEN = "open";
	public static final String INSURE_STATUS_CLOSE = "close";
	
	public static final String TAKEMETHOD_P = "P";//锟街筹拷锟斤拷锟斤拷
	public static final String TAKEMETHOD_W = "W";//影院锟斤拷票锟斤拷锟斤拷
	public static final String TAKEMETHOD_A = "A";//锟斤拷锟斤拷锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_F = "F";//锟斤拷锟斤拷锟斤拷全锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_U = "U";//锟斤拷锟斤拷院锟斤拷
	public static final String TAKEMETHOD_L = "L";//卢锟阶帮拷影院锟斤拷锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_D = "D";//锟斤拷锟皆猴拷锟斤拷锟斤拷锟饺∑憋拷锟�
	public static final String TAKEMETHOD_J = "J";//锟斤拷锟斤拷院锟斤拷锟斤拷锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_M = "M";//影院锟斤拷员锟斤拷锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_E = "E";//锟斤拷鼗锟皆憋拷锟斤拷锟饺∑憋拷锟�
	public static final String TAKEMETHOD_T = "T";//锟斤拷锟斤拷票锟斤拷锟斤拷锟斤拷取票锟斤拷
	public static final String TAKEMETHOD_AFT = "AFT";//锟斤拷锟斤拷锟斤拷锟斤拷锟皆硷拷锟斤拷取票锟斤拷锟斤拷
	
	private Long id;				//锟斤拷Cinema锟斤拷锟斤拷ID
	private String notifymsg1;		//取票锟斤拷锟斤拷
	private String notifymsg2;		//锟斤拷前3小时锟斤拷锟窖讹拷锟斤拷
	private String notifymsg3;		//微票取票锟斤拷锟斤拷
	private String notifymsg4;		//微票取票锟斤拷锟斤拷
	private String notifymsg5;		//微票取票锟斤拷锟斤拷
	private String takemethod; 		//取票锟斤拷式: P锟斤拷锟街筹拷锟斤拷锟酵ｏ拷W锟斤拷影院锟斤拷票锟斤拷锟节ｏ拷A锟斤拷锟皆讹拷取票锟斤拷
	private Long topicid;			//取票锟斤拷锟斤拷
	private String takeAddress;     //取票位锟斤拷
	private String opentime;		//每锟届开锟脚癸拷票时锟戒，锟斤拷6:00锟斤拷锟斤拷写 0600
	private String closetime;		//每锟斤拷乇展锟狡笔憋拷锟�
	private String startsale;		//每锟斤拷锟斤拷锟阶餐的匡拷始时锟斤拷 0800
	private String endsale;			//每锟斤拷锟斤拷锟阶餐的斤拷锟斤拷时锟斤拷 2300
	private String popcorn;      	//锟角凤拷锟角猴拷锟叫憋拷锟阶伙拷影院
	private String servicefee;		//锟斤拷锟斤拷锟�
	private String status;			//锟斤拷锟斤拷状态
	private Integer cminute;		//锟斤拷前锟洁长时锟斤拷乇锟�(锟斤拷锟斤拷)
	private Integer openDay;         //锟斤拷前锟斤拷锟斤拷时锟斤拷(锟斤拷锟界：1 锟斤拷示1锟斤拷)
	private String openDayTime;		 //锟斤拷前锟斤拷锟脚硷拷锟斤拷木锟斤拷锟绞憋拷锟�(锟斤拷锟界：6:00锟斤拷锟斤拷写 0600)
	private Integer fee;			//锟斤拷锟斤拷锟�
	private String isRefund;		//锟角凤拷锟斤拷锟斤拷锟狡盰 or N
	private String isGewaRefund;	//锟角凤拷支锟斤拷Gewa锟剿款（Y/N锟斤拷
	private String opentype;		//影院锟斤拷锟斤拷锟斤拷锟酵ｏ拷HFH, MTX, DX
	private String direct;			//锟角凤拷直锟斤拷Y or N
	private String prompting;		//锟斤拷示说锟斤拷
	private String isInsure;    	//锟角凤拷支锟街癸拷锟斤拷平锟斤拷锟斤拷锟斤拷  N锟斤拷null值锟斤拷示锟斤拷支锟街★拷open锟斤拷示锟斤拷锟斤拷支锟街ｏ拷close锟斤拷示锟斤拷停锟截憋拷锟斤拷锟斤拷
	private String openPriority;  	//锟斤拷锟斤拷锟斤拷锟矫匡拷锟斤拷锟斤拷锟饺硷拷
	private String globalLimit;		//全锟斤拷锟斤拷锟斤拷锟斤拷GlobalLimit锟斤拷Y锟斤拷锟矫ｏ拷N锟斤拷锟斤拷锟斤拷
	private Integer passlen;		//取票锟斤拷锟诫长锟斤拷
	protected Timestamp updatetime;	//锟睫革拷时锟斤拷	
	private Boolean fromCache = false; //锟角凤拷锟斤拷锟皆憋拷锟截伙拷锟斤拷

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
			if(time.compareTo(startsale)<0 || time.compareTo(endsale)>0) {
                return false;
            }
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
		String result = "锟斤拷位锟斤拷影院锟侥革拷锟斤拷锟斤拷锟斤拷锟斤拷取票锟斤拷取票";
		if(StringUtils.equals(takemethod, TAKEMETHOD_U)){
			result = "锟斤拷位锟斤拷影院锟斤拷锟斤拷锟斤拷院锟斤拷锟斤拷锟斤拷取票锟斤拷取票";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_W)){
			result = "影院锟斤拷票锟斤拷锟斤拷取票";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_P)){
			result = "锟街筹拷锟斤拷锟斤拷";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_L)){
			result = "锟斤拷位锟斤拷影院锟斤拷卢锟阶帮拷影院锟斤拷锟斤拷取票锟斤拷";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_D)){
			result = "锟斤拷位锟斤拷影院锟斤拷锟斤拷锟皆猴拷锟斤拷锟斤拷锟饺∑憋拷锟�";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_J)){
			result = "锟斤拷位锟斤拷影院锟侥斤拷锟斤拷院锟斤拷锟斤拷锟斤拷取票锟斤拷";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_M)){
			result = "锟斤拷位锟斤拷影院锟斤拷影院锟斤拷员锟斤拷锟斤拷取票锟斤拷";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_E)){
			result = "锟斤拷位锟斤拷影院锟侥达拷鼗锟皆憋拷锟斤拷锟饺∑憋拷锟�";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_T)){
			result = "锟斤拷位锟斤拷影院锟斤拷锟斤拷锟斤拷票锟斤拷锟斤拷锟斤拷取票锟斤拷";
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
