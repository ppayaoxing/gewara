package com.gewara.api.gworder.vo;

import java.sql.Timestamp;
import java.util.Map;

public class CreateMallOrderReq extends CreateOrderReq{
	private static final long serialVersionUID = -8039360836554659139L;
	private Long partnerid;
	private String mobile;
	private Integer totalcost;
	private Integer totalfee;
	private Integer otherfee;
	private Integer usedPoint;
	private Long sdid;			//�ؼۻid
	private String category;
	private String ukey;		
	private String citycode;
	private String origin;
	private Timestamp validtime;
	private String membername;
	private String ordertitle;
	private String otherinfo;
	private String paymethod;
	private String remark;
	private Map<String, String> descMap;
	public CreateMallOrderReq(){
		
	}
	public CreateMallOrderReq(String ordertitle, String citycode,
			Long memberId, Long parnterid, String mobile, 
			Integer totalfee, Integer totalcost, Integer otherfee, Integer usedPoint, String category, Timestamp validtime){
		this.ordertitle = ordertitle;
		this.citycode = citycode;
		this.memberId = memberId;
		this.partnerid = parnterid;
		this.mobile = mobile;
		this.totalfee = totalfee;
		this.totalcost = totalcost;
		this.otherfee = otherfee;
		this.usedPoint = usedPoint;
		this.category = category;
		this.validtime = validtime;
	}
	public Long getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}
	public Integer getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}
	public Long getSdid() {
		return sdid;
	}
	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
    public String getRemoteIp() {
		return remoteIp;
	}
	@Override
    public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public Map<String, String> getDescMap() {
		return descMap;
	}
	public void setDescMap(Map<String, String> descMap) {
		this.descMap = descMap;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Integer getOtherfee() {
		return otherfee;
	}
	public void setOtherfee(Integer otherfee) {
		this.otherfee = otherfee;
	}

	public String getUkey() {
		return ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getOrdertitle() {
		return ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(Integer usedPoint) {
		this.usedPoint = usedPoint;
	}
}
