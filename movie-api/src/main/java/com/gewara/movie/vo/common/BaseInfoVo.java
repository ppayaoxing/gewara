/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.movie.vo.common.BaseEntityVo;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class BaseInfoVo extends BaseEntityVo {
	private static final long serialVersionUID = 9098176104145634257L;
	protected String brandname;
	protected String citycode;
	protected String countycode;
	protected String countyname;
	protected String indexareacode;
	protected String indexareaname;
	protected String address;
	protected String postalcode;
	protected String contactphone;
	protected String fax;
	protected String website;
	protected String email;
	protected String transport;
	protected Long stationid;
	protected String stationname;
	protected String exitnumber;
	protected String googlemap;
	protected String opentime;
	protected String feature;
	protected String remark;
	protected String discount;
	protected String coupon;
	protected String pointx;
	protected String pointy;
	protected String bpointx;
	protected String bpointy;
	protected String briefaddress;
	protected String lineidlist;
	protected String otherinfo;

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactphone() {
		return this.contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getFeature() {
		return this.feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getCountyname() {
		return this.countyname;
	}

	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}

	public String getPointx() {
		return this.pointx;
	}

	public void setPointx(String pointx) {
		this.pointx = pointx;
	}

	public String getPointy() {
		return this.pointy;
	}

	public void setPointy(String pointy) {
		this.pointy = pointy;
	}

	public String getBpointx() {
		return this.bpointx;
	}

	public void setBpointx(String bpointx) {
		this.bpointx = bpointx;
	}

	public String getBpointy() {
		return this.bpointy;
	}

	public void setBpointy(String bpointy) {
		this.bpointy = bpointy;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_logo.png" : this.logo;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public String getIndexareaname() {
		return this.indexareaname;
	}

	public void setIndexareaname(String indexareaname) {
		this.indexareaname = indexareaname;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getStationid() {
		return this.stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}

	public String getStationname() {
		return this.stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public String getExitnumber() {
		return this.exitnumber;
	}

	public void setExitnumber(String exitnumber) {
		this.exitnumber = exitnumber;
	}

	public String getGooglemap() {
		return this.googlemap;
	}

	public void setGooglemap(String googlemap) {
		this.googlemap = googlemap;
	}

	public String getOpentime() {
		return this.opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCoupon() {
		return this.coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getBriefaddress() {
		return this.briefaddress;
	}

	public void setBriefaddress(String briefaddress) {
		this.briefaddress = briefaddress;
	}

	public String getLineidlist() {
		return this.lineidlist;
	}

	public void setLineidlist(String lineidlist) {
		this.lineidlist = lineidlist;
	}

	public String getRTransport() {
		return this.transport == null ? null : this.transport.replace("@", ";");
	}

	public String getDividePhone() {
		return !StringUtils.isBlank(this.contactphone) && this.contactphone.length() == 8
				? this.contactphone.substring(0, 4) + " " + this.contactphone.substring(4) : this.contactphone;
	}

	public boolean havaCoupon() {
		return StringUtils.isNotBlank(this.coupon) && "Y".equals(this.coupon);
	}

	public String getLineName(Map<String, String> lineMap) {
		String result = "";
		if (lineMap == null) {
			return result;
		} else {
			if (StringUtils.isNotBlank(this.lineidlist)) {
				String[] arg2 = this.lineidlist.split(",");
				int arg3 = arg2.length;

				for (int arg4 = 0; arg4 < arg3; ++arg4) {
					String lineid = arg2[arg4];
					String linename = (String) lineMap.get(lineid);
					if (StringUtils.isNotBlank(linename)) {
						result = result + "," + linename;
					}
				}
			}

			return StringUtils.isNotBlank(result) ? result.substring(1) : result;
		}
	}
}