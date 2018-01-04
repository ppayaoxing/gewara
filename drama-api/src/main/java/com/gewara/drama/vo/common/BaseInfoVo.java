package com.gewara.drama.vo.common;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class BaseInfoVo extends BaseEntityVo{
	private static final long serialVersionUID = 9098176104145634257L;
	protected String citycode;
	protected String countycode;
	protected String countyname;
	protected String address;
	protected String contactphone;
	protected String transport;
	protected String feature;
	protected String remark;
	protected String pointx;
	protected String pointy;
	protected String bpointx;
	protected String bpointy;
	protected String gpointx;
	protected String gpointy;
	protected String otherinfo;
	
	protected String brandname;
	protected String indexareacode;
	protected String indexareaname;
	protected String postalcode;
	protected String fax;
	protected String website;
	protected String email;
	protected Long stationid;
	protected String stationname;
	protected String exitnumber;//����
	protected String googlemap;
	protected String opentime;//Ӫҵʱ��
	protected String briefaddress;//���Ƽ��
	protected String lineidlist;
	
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getIndexareacode() {
		return indexareacode;
	}
	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}
	public String getIndexareaname() {
		return indexareaname;
	}
	public void setIndexareaname(String indexareaname) {
		this.indexareaname = indexareaname;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getStationid() {
		return stationid;
	}
	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getExitnumber() {
		return exitnumber;
	}
	public void setExitnumber(String exitnumber) {
		this.exitnumber = exitnumber;
	}
	public String getGooglemap() {
		return googlemap;
	}
	public void setGooglemap(String googlemap) {
		this.googlemap = googlemap;
	}
	public String getOpentime() {
		return opentime;
	}
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	public String getBriefaddress() {
		return briefaddress;
	}
	public void setBriefaddress(String briefaddress) {
		this.briefaddress = briefaddress;
	}
	public String getLineidlist() {
		return lineidlist;
	}
	public void setLineidlist(String lineidlist) {
		this.lineidlist = lineidlist;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	public String getPointx() {
		return pointx;
	}
	public void setPointx(String pointx) {
		this.pointx = pointx;
	}
	public String getPointy() {
		return pointy;
	}
	public void setPointy(String pointy) {
		this.pointy = pointy;
	}
	public String getBpointx() {
		return bpointx;
	}
	public void setBpointx(String bpointx) {
		this.bpointx = bpointx;
	}
	public String getBpointy() {
		return bpointy;
	}
	public void setBpointy(String bpointy) {
		this.bpointy = bpointy;
	}
	public String getGpointx() {
		return gpointx;
	}
	public void setGpointx(String gpointx) {
		this.gpointx = gpointx;
	}
	public String getGpointy() {
		return gpointy;
	}
	public void setGpointy(String gpointy) {
		this.gpointy = gpointy;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}	
	
	public String getLineName(Map<String, String> lineMap){
		String result = "";
		if(lineMap==null) {
            return result;
        }
		if(StringUtils.isNotBlank(this.lineidlist)){
			for(String lineid : lineidlist.split(",")){
				String linename = lineMap.get(lineid);
				if(StringUtils.isNotBlank(linename)){
					result = result + "," + linename;
				}
			}
		}
		if(StringUtils.isNotBlank(result)) {
            return result.substring(1);
        }
		return result;
	}
	
	public String getRTransport() {
		return this.transport == null ? null : transport.replace("@", ";");
	}
}
