package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class ReserveMemberVo extends BaseVo {

	private static final long serialVersionUID = 2601574347248957051L;
	private Long id;
	private Integer version;
	private Long dramaid;
	private Long memberid;			
	private String membername;
	private Date reservedate;		//可预约日期
	private Integer ordernum;		//订单数
	private Integer ticketnum;		//票数
	private Integer reservenum;	//已预约数
	private String orderids;		//订单ID
	private String origin;
	private Timestamp addtime;
	private Timestamp updatetime;

	private Long dpid;    //场次ID
	private String period;	 //场次类型 Y固定时间场次，N非固定时间场次
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Date getReservedate() {
		return reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}

	public Integer getReservenum() {
		return reservenum;
	}

	public void setReservenum(Integer reservenum) {
		this.reservenum = reservenum;
	}

	public String getOrderids() {
		return orderids;
	}

	public void setOrderids(String orderids) {
		this.orderids = orderids;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
