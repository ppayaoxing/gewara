/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;

public class UpGradeVo extends BaseVo {
	private static final long serialVersionUID = -202742904252314589L;
	private String id;
	private String tag;
	private Integer versionCode;
	private String versionName;
	private String upgradeUrl;
	private Integer upgradeStatus;
	private Date addTime;
	private String apptype;
	private String appsource;
	private String foceversion;
	private String specificversion;
	private String remark;
	private String downloadName;
	private Long modifytime;
	private String osVersion;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getUpgradeUrl() {
		return this.upgradeUrl;
	}

	public void setUpgradeUrl(String upgradeUrl) {
		this.upgradeUrl = upgradeUrl;
	}

	public Integer getUpgradeStatus() {
		return this.upgradeStatus;
	}

	public void setUpgradeStatus(Integer upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getAppsource() {
		return this.appsource;
	}

	public void setAppsource(String appsource) {
		this.appsource = appsource;
	}

	public String getFoceversion() {
		return this.foceversion;
	}

	public void setFoceversion(String foceversion) {
		this.foceversion = foceversion;
	}

	public String getSpecificversion() {
		return this.specificversion;
	}

	public void setSpecificversion(String specificversion) {
		this.specificversion = specificversion;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDownloadName() {
		return this.downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public Long getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Long modifytime) {
		this.modifytime = modifytime;
	}

	public String getOsVersion() {
		return this.osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
}