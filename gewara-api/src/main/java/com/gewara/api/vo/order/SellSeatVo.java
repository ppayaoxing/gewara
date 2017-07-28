/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.order;

import com.gewara.api.partner.res.vo.RoomSeatVo;
import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class SellSeatVo extends BaseVo {
	private static final long serialVersionUID = 7220661632796433750L;
	public static final String SECTION_UP = "up";
	public static final String SECTION_DOWN = "dw";
	private Long id;
	private Integer version;
	private Long orderid;
	private Long mpid;
	private String seatline;
	private String seatrank;
	private String secid;
	private Timestamp validtime;
	private Integer price;
	private String status;

	public SellSeatVo() {
	}

	public SellSeatVo(RoomSeatVo rseat, Long mpid, Integer price, Timestamp validtime) {
		this.mpid = mpid;
		this.version = Integer.valueOf(0);
		this.status = "A";
		this.validtime = validtime;
		this.secid = rseat.getSecid();
		this.copyFrom(rseat, price);
	}

	public SellSeatVo(String seatline, String seatrank, Long mpid) {
		this.version = Integer.valueOf(0);
		this.status = "A";
		this.mpid = mpid;
		this.seatline = seatline;
		this.seatrank = seatrank;
	}

	public void copyFrom(RoomSeatVo rseat, Integer sprice) {
		this.seatline = rseat.getSeatline();
		this.seatrank = rseat.getSeatrank();
		this.secid = rseat.getSecid();
		this.price = sprice;
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

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public String getSeatrank() {
		return this.seatrank;
	}

	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}

	public String getSeatline() {
		return this.seatline;
	}

	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}

	public boolean isAvailable(Timestamp cur) {
		return this.status.equals("A") && this.validtime.before(cur);
	}

	public boolean isAvailableBy(Long sorderid, Timestamp cur) {
		return this.status.equals("A") && this.validtime.before(cur) || sorderid.equals(this.orderid);
	}

	public boolean isSold() {
		return "S".equals(this.status);
	}

	public String getKey() {
		return this.seatline + ":" + this.seatrank;
	}

	public String getSeatLabel() {
		if (StringUtils.isNotBlank(this.secid)) {
			if ("up".equals(this.secid)) {
				return "Â¥ÉÏ" + this.seatline + "ÅÅ" + this.seatrank + "×ù";
			}

			if ("dw".equals(this.secid)) {
				return "Â¥ÏÂ" + this.seatline + "ÅÅ" + this.seatrank + "×ù";
			}
		}

		return this.seatline + "ÅÅ" + this.seatrank + "×ù";
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public Serializable realId() {
		return this.id;
	}
}