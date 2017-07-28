/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class SellDramaSeatVo extends BaseVo {
	private static final long serialVersionUID = -7943952447862925974L;
	private Long id;
	private Integer version;
	private Long odiid;
	private Long dpid;
	private Long areaid;
	private Long orderid;
	private String seatline;
	private String seatrank;
	private Timestamp validtime;
	private Integer price;
	private Integer theatreprice;
	private Integer costprice;
	private String status;
	private String remark;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getOdiid() {
		return this.odiid;
	}

	public void setOdiid(Long odiid) {
		this.odiid = odiid;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getSeatline() {
		return this.seatline;
	}

	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}

	public String getSeatrank() {
		return this.seatrank;
	}

	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTheatreprice() {
		return this.theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean hasAvailable() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return StringUtils.equals(this.status, "A") && this.validtime.before(cur);
	}

	public boolean hasAvailableBy(Long sorderid) {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return StringUtils.equals(this.status, "A") && this.validtime.before(cur) || sorderid.equals(this.orderid);
	}

	public boolean hasSold() {
		return "S".equals(this.status);
	}

	public String getSeatLabel() {
		return this.seatline + "ÅÅ" + this.seatrank + "×ù";
	}

	public String getKey() {
		return this.seatline + ":" + this.seatrank;
	}
}