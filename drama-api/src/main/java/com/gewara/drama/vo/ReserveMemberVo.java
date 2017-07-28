/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ReserveMemberVo extends BaseVo {
	private static final long serialVersionUID = 2601574347248957051L;
	private Long id;
	private Integer version;
	private Long dramaid;
	private Long memberid;
	private String membername;
	private Date reservedate;
	private Integer ordernum;
	private Integer ticketnum;
	private Integer reservenum;
	private String orderids;
	private String origin;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Long dpid;
	private String period;

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

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Date getReservedate() {
		return this.reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getTicketnum() {
		return this.ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}

	public Integer getReservenum() {
		return this.reservenum;
	}

	public void setReservenum(Integer reservenum) {
		this.reservenum = reservenum;
	}

	public String getOrderids() {
		return this.orderids;
	}

	public void setOrderids(String orderids) {
		this.orderids = orderids;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
}