/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ShowSeatVo extends BaseVo {
	private static final long serialVersionUID = -2879362811381467253L;
	private Long id;
	private String siseqno;
	private String arseqno;
	private String priceseq;
	private Integer lineno;
	private Integer rankno;
	private String seatline;
	private String seatrank;
	private String status;
	private String ticketid;
	private Integer price;
	private String loveInd;
	private String seatno;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiseqno() {
		return this.siseqno;
	}

	public void setSiseqno(String siseqno) {
		this.siseqno = siseqno;
	}

	public String getArseqno() {
		return this.arseqno;
	}

	public void setArseqno(String arseqno) {
		this.arseqno = arseqno;
	}

	public String getPriceseq() {
		return this.priceseq;
	}

	public void setPriceseq(String priceseq) {
		this.priceseq = priceseq;
	}

	public Integer getLineno() {
		return this.lineno;
	}

	public void setLineno(Integer lineno) {
		this.lineno = lineno;
	}

	public Integer getRankno() {
		return this.rankno;
	}

	public void setRankno(Integer rankno) {
		this.rankno = rankno;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getLoveInd() {
		return this.loveInd;
	}

	public void setLoveInd(String loveInd) {
		this.loveInd = loveInd;
	}

	public String getSeatno() {
		return this.seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public String getSeatLabel() {
		return this.seatline + "ÅÅ" + this.seatrank + "×ù";
	}
}