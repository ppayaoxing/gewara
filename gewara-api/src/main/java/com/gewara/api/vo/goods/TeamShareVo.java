/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.goods;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class TeamShareVo extends BaseVo {
	private static final long serialVersionUID = -523579776327538390L;
	private Long id;
	private Integer version;
	private Long memberid;
	private Long goodsid;
	private Integer ordernum;
	private Integer ticketnum;
	private Long extid;
	private Long lastextid;
	private String notice;
	private Integer allowticketnum;
	private Integer allowtotalnum;
	private String sharestatus;
	private Timestamp addtime;
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

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
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

	public Long getExtid() {
		return this.extid;
	}

	public void setExtid(Long extid) {
		this.extid = extid;
	}

	public Long getLastextid() {
		return this.lastextid;
	}

	public void setLastextid(Long lastextid) {
		this.lastextid = lastextid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Integer getAllowtotalnum() {
		return this.allowtotalnum;
	}

	public void setAllowtotalnum(Integer allowtotalnum) {
		this.allowtotalnum = allowtotalnum;
	}

	public Integer getAllowticketnum() {
		return this.allowticketnum;
	}

	public void setAllowticketnum(Integer allowticketnum) {
		this.allowticketnum = allowticketnum;
	}

	public String getSharestatus() {
		return this.sharestatus;
	}

	public void setSharestatus(String sharestatus) {
		this.sharestatus = sharestatus;
	}
}