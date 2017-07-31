package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class UpGradeVo extends BaseVo{
	private static final long serialVersionUID = -202742904252314589L;
	private String id;
	private String tag;
	private Integer versionCode;
	private String versionName;
	private String upgradeUrl;
	private Integer upgradeStatus;	//1，代表升级，0，不升级
	private Date addTime;
	private String apptype;
	private String appsource;
	private String foceversion;		//强制升级版本号
	private String specificversion;	//特殊版本号
	private String remark;
	private String downloadName;//下载文件名
	private Long modifytime;
	private String osVersion;
	@Override
	public Serializable realId() {
		return id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getUpgradeUrl() {
		return upgradeUrl;
	}
	public void setUpgradeUrl(String upgradeUrl) {
		this.upgradeUrl = upgradeUrl;
	}
	public Integer getUpgradeStatus() {
		return upgradeStatus;
	}
	public void setUpgradeStatus(Integer upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getApptype() {
		return apptype;
	}
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	public String getAppsource() {
		return appsource;
	}
	public void setAppsource(String appsource) {
		this.appsource = appsource;
	}
	public String getFoceversion() {
		return foceversion;
	}
	public void setFoceversion(String foceversion) {
		this.foceversion = foceversion;
	}
	public String getSpecificversion() {
		return specificversion;
	}
	public void setSpecificversion(String specificversion) {
		this.specificversion = specificversion;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDownloadName() {
		return downloadName;
	}
	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}
	public Long getModifytime() {
		return modifytime;
	}
	public void setModifytime(Long modifytime) {
		this.modifytime = modifytime;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
}
