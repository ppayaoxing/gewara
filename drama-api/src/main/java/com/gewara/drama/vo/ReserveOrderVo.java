package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class ReserveOrderVo extends BaseVo {

	private static final long serialVersionUID = 7702516966463933142L;
	private Long id;
	private Long dramaid;					//演出ID
	private Long matcherid;					//关联ID
	private String mobile;					//手机号
	private Long memberid;					//关联用户
	private Long partnerid;					//合作商ID
	private Date reservedate;
	private Integer version;
	private String starttime;
	private String endtime;
	private Integer quantity;				//数量
	private String citycode;				//城市编码
	private String barcode;					//二维码值
	private String remark;
	private String ip;						//
	private Long reserveMemberid;
	private Timestamp validtime;			//
	private Timestamp createtime;
	private Timestamp updatetime;
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getMatcherid() {
		return matcherid;
	}

	public void setMatcherid(Long matcherid) {
		this.matcherid = matcherid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Date getReservedate() {
		return reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getReserveMemberid() {
		return reserveMemberid;
	}

	public void setReserveMemberid(Long reserveMemberid) {
		this.reserveMemberid = reserveMemberid;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

}
