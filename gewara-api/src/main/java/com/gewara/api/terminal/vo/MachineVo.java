package com.gewara.api.terminal.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class MachineVo extends BaseVo {
	private static final long serialVersionUID = -5104357767286680035L;
	private Long id;				
	private String macno;				//机器编号
	private String macname;				//机器名称
	private String openfireName;		//opfire登录名
	private String openfirepwd;			//opfire密码
	private Long placeid;				//场馆id
	private String placeName;			//场馆名称
	private String placeAddress;		//场馆名称
	private String citycode;			//城市代码
	private String cityname;			//城市名称
	private String tag;					//场馆类型
	
	private String privatekey;			//校验码
	
	private String ticketNum;			//当前剩余票纸数量
	private Timestamp chgTickettime;	//换票时间
	
	private Timestamp lastSynchtime;
	private Timestamp synchtime;
	
	private Timestamp lastSuctime;
	private Timestamp suctime;
	
	private String macType;
	private String mainMac;
	
	private String description;
	private Timestamp addtime;			//添加时间
	
	private Integer unitTime;			//单位时间
	private String defClosetime;		//关机时间
	
	private String monitor;				//是否监控
	private String ip;
	
	private Long selfcityid;
	private String systag;
	private String filmtag;				//电影节机器（专门取电影节的票，普通机器不取  film,film_vip）
	private String orderType;	// 取票类型Y所有，Y_M：电影，Y_G:物品,N：什么都不取
	/**
	 * 剩余票纸数量(单台机器)
	 */
	private Integer remainTicketNum;
	// 可以装的总票纸数
	private Integer totalTicketNum;
	private String synTicketNumFlg;
	/**
	 * 手工添加票纸的时间
	 */
	private Timestamp  manualTicketnumTime;
	
	/**
	 * 机器状态
	 */
	private String macStatus;
	
	/**
	 * 屏保版本
	 */
	private String screenVersion;
	
	/**
	 * 当前系统版本号
	 */
	private String systemVersion;
	private Timestamp barcodeTime;
	// 维护类型(影院全网取票、格瓦拉维护、影院协助维护)
	private String maintain_type;
	// 取票机类型(1代机、1.5代机、2代机、3代机、3.5代机、4代机、5代机)
	private String machine_type;
	// 是否监控(正常监控、等待回收、暂停监控)
	private String monitor_type;

	public MachineVo(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMacno() {
		return macno;
	}
	public void setMacno(String macno) {
		this.macno = macno;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	public Long getPlaceid() {
		return placeid;
	}
	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public Timestamp getChgTickettime() {
		return chgTickettime;
	}
	public void setChgTickettime(Timestamp chgTickettime) {
		this.chgTickettime = chgTickettime;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getLastSynchtime() {
		return lastSynchtime;
	}
	public void setLastSynchtime(Timestamp lastSynchtime) {
		this.lastSynchtime = lastSynchtime;
	}
	public Timestamp getSynchtime() {
		return synchtime;
	}
	public void setSynchtime(Timestamp synchtime) {
		this.synchtime = synchtime;
	}
	public Timestamp getLastSuctime() {
		return lastSuctime;
	}
	public void setLastSuctime(Timestamp lastSuctime) {
		this.lastSuctime = lastSuctime;
	}
	public Timestamp getSuctime() {
		return suctime;
	}
	public void setSuctime(Timestamp suctime) {
		this.suctime = suctime;
	}
	public String getMacType() {
		return macType;
	}
	public void setMacType(String macType) {
		this.macType = macType;
	}
	public String getMainMac() {
		return mainMac;
	}
	public void setMainMac(String mainMac) {
		this.mainMac = mainMac;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Integer getUnitTime() {
		return unitTime;
	}

	public void setUnitTime(Integer unitTime) {
		this.unitTime = unitTime;
	}

	public String getDefClosetime() {
		return defClosetime;
	}

	public void setDefClosetime(String defClosetime) {
		this.defClosetime = defClosetime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getMacname() {
		return macname;
	}

	public void setMacname(String macname) {
		this.macname = macname;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Long getSelfcityid() {
		return selfcityid;
	}

	public void setSelfcityid(Long selfcityid) {
		this.selfcityid = selfcityid;
	}

	public String getOpenfireName() {
		return openfireName;
	}

	public void setOpenfireName(String openfireName) {
		this.openfireName = openfireName;
	}

	public String getSystag() {
		return systag;
	}

	public void setSystag(String systag) {
		this.systag = systag;
	}

	public Integer getRemainTicketNum() {
		return remainTicketNum;
	}

	public void setRemainTicketNum(Integer remainTicketNum) {
		this.remainTicketNum = remainTicketNum;
	}

	public String getMacStatus() {
		return macStatus;
	}

	public void setMacStatus(String macStatus) {
		this.macStatus = macStatus;
	}

	public String getScreenVersion() {
		return screenVersion;
	}

	public void setScreenVersion(String screenVersion) {
		this.screenVersion = screenVersion;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getFilmtag() {
		return filmtag;
	}

	public void setFilmtag(String filmtag) {
		this.filmtag = filmtag;
	}
	public boolean hasFilmtag(String ft){
		return StringUtils.equals(filmtag, ft);
	}

	public String getOpenfirepwd() {
		return openfirepwd;
	}

	public void setOpenfirepwd(String openfirepwd) {
		this.openfirepwd = openfirepwd;
	}

	public Timestamp getManualTicketnumTime() {
		return manualTicketnumTime;
	}

	public void setManualTicketnumTime(Timestamp manualTicketnumTime) {
		this.manualTicketnumTime = manualTicketnumTime;
	}

	public Timestamp getBarcodeTime() {
		return barcodeTime;
	}

	public void setBarcodeTime(Timestamp barcodeTime) {
		this.barcodeTime = barcodeTime;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getTotalTicketNum() {
		return totalTicketNum;
	}

	public void setTotalTicketNum(Integer totalTicketNum) {
		this.totalTicketNum = totalTicketNum;
	}

	public String getSynTicketNumFlg() {
		return synTicketNumFlg;
	}

	public void setSynTicketNumFlg(String synTicketNumFlg) {
		this.synTicketNumFlg = synTicketNumFlg;
	}


	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getMonitor_type() {
		return monitor_type;
	}

	public void setMonitor_type(String monitor_type) {
		this.monitor_type = monitor_type;
	}

	public String getMaintain_type() {
		return maintain_type;
	}

	public void setMaintain_type(String maintain_type) {
		this.maintain_type = maintain_type;
	}
}
