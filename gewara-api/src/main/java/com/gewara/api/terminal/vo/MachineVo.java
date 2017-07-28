/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class MachineVo extends BaseVo {
	private static final long serialVersionUID = -5104357767286680035L;
	private Long id;
	private String macno;
	private String macname;
	private String openfireName;
	private String openfirepwd;
	private Long placeid;
	private String placeName;
	private String placeAddress;
	private String citycode;
	private String cityname;
	private String tag;
	private String privatekey;
	private String ticketNum;
	private Timestamp chgTickettime;
	private Timestamp lastSynchtime;
	private Timestamp synchtime;
	private Timestamp lastSuctime;
	private Timestamp suctime;
	private String macType;
	private String mainMac;
	private String description;
	private Timestamp addtime;
	private Integer unitTime;
	private String defClosetime;
	private String monitor;
	private String ip;
	private Long selfcityid;
	private String systag;
	private String filmtag;
	private String orderType;
	private Integer remainTicketNum;
	private Integer totalTicketNum;
	private String synTicketNumFlg;
	private Timestamp manualTicketnumTime;
	private String macStatus;
	private String screenVersion;
	private String systemVersion;
	private Timestamp barcodeTime;
	private String maintain_type;
	private String machine_type;
	private String monitor_type;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMacno() {
		return this.macno;
	}

	public void setMacno(String macno) {
		this.macno = macno;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getPrivatekey() {
		return this.privatekey;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getTicketNum() {
		return this.ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Timestamp getChgTickettime() {
		return this.chgTickettime;
	}

	public void setChgTickettime(Timestamp chgTickettime) {
		this.chgTickettime = chgTickettime;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getLastSynchtime() {
		return this.lastSynchtime;
	}

	public void setLastSynchtime(Timestamp lastSynchtime) {
		this.lastSynchtime = lastSynchtime;
	}

	public Timestamp getSynchtime() {
		return this.synchtime;
	}

	public void setSynchtime(Timestamp synchtime) {
		this.synchtime = synchtime;
	}

	public Timestamp getLastSuctime() {
		return this.lastSuctime;
	}

	public void setLastSuctime(Timestamp lastSuctime) {
		this.lastSuctime = lastSuctime;
	}

	public Timestamp getSuctime() {
		return this.suctime;
	}

	public void setSuctime(Timestamp suctime) {
		this.suctime = suctime;
	}

	public String getMacType() {
		return this.macType;
	}

	public void setMacType(String macType) {
		this.macType = macType;
	}

	public String getMainMac() {
		return this.mainMac;
	}

	public void setMainMac(String mainMac) {
		this.mainMac = mainMac;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceAddress() {
		return this.placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Integer getUnitTime() {
		return this.unitTime;
	}

	public void setUnitTime(Integer unitTime) {
		this.unitTime = unitTime;
	}

	public String getDefClosetime() {
		return this.defClosetime;
	}

	public void setDefClosetime(String defClosetime) {
		this.defClosetime = defClosetime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getMacname() {
		return this.macname;
	}

	public void setMacname(String macname) {
		this.macname = macname;
	}

	public String getMonitor() {
		return this.monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Long getSelfcityid() {
		return this.selfcityid;
	}

	public void setSelfcityid(Long selfcityid) {
		this.selfcityid = selfcityid;
	}

	public String getOpenfireName() {
		return this.openfireName;
	}

	public void setOpenfireName(String openfireName) {
		this.openfireName = openfireName;
	}

	public String getSystag() {
		return this.systag;
	}

	public void setSystag(String systag) {
		this.systag = systag;
	}

	public Integer getRemainTicketNum() {
		return this.remainTicketNum;
	}

	public void setRemainTicketNum(Integer remainTicketNum) {
		this.remainTicketNum = remainTicketNum;
	}

	public String getMacStatus() {
		return this.macStatus;
	}

	public void setMacStatus(String macStatus) {
		this.macStatus = macStatus;
	}

	public String getScreenVersion() {
		return this.screenVersion;
	}

	public void setScreenVersion(String screenVersion) {
		this.screenVersion = screenVersion;
	}

	public String getSystemVersion() {
		return this.systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getFilmtag() {
		return this.filmtag;
	}

	public void setFilmtag(String filmtag) {
		this.filmtag = filmtag;
	}

	public boolean hasFilmtag(String ft) {
		return StringUtils.equals(this.filmtag, ft);
	}

	public String getOpenfirepwd() {
		return this.openfirepwd;
	}

	public void setOpenfirepwd(String openfirepwd) {
		this.openfirepwd = openfirepwd;
	}

	public Timestamp getManualTicketnumTime() {
		return this.manualTicketnumTime;
	}

	public void setManualTicketnumTime(Timestamp manualTicketnumTime) {
		this.manualTicketnumTime = manualTicketnumTime;
	}

	public Timestamp getBarcodeTime() {
		return this.barcodeTime;
	}

	public void setBarcodeTime(Timestamp barcodeTime) {
		this.barcodeTime = barcodeTime;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getTotalTicketNum() {
		return this.totalTicketNum;
	}

	public void setTotalTicketNum(Integer totalTicketNum) {
		this.totalTicketNum = totalTicketNum;
	}

	public String getSynTicketNumFlg() {
		return this.synTicketNumFlg;
	}

	public void setSynTicketNumFlg(String synTicketNumFlg) {
		this.synTicketNumFlg = synTicketNumFlg;
	}

	public String getMachine_type() {
		return this.machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getMonitor_type() {
		return this.monitor_type;
	}

	public void setMonitor_type(String monitor_type) {
		this.monitor_type = monitor_type;
	}

	public String getMaintain_type() {
		return this.maintain_type;
	}

	public void setMaintain_type(String maintain_type) {
		this.maintain_type = maintain_type;
	}
}