/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ReserveOrderVo extends BaseVo {
	private static final long serialVersionUID = 7702516966463933142L;
	private Long id;
	private Long dramaid;
	private Long matcherid;
	private String mobile;
	private Long memberid;
	private Long partnerid;
	private Date reservedate;
	private Integer version;
	private String starttime;
	private String endtime;
	private Integer quantity;
	private String citycode;
	private String barcode;
	private String remark;
	private String ip;
	private Long reserveMemberid;
	private Timestamp validtime;
	private Timestamp createtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getMatcherid() {
		return this.matcherid;
	}

	public void setMatcherid(Long matcherid) {
		this.matcherid = matcherid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Date getReservedate() {
		return this.reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getReserveMemberid() {
		return this.reserveMemberid;
	}

	public void setReserveMemberid(Long reserveMemberid) {
		this.reserveMemberid = reserveMemberid;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
}