/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class FieldAreaSeatVo extends BaseVo {
	private static final long serialVersionUID = -4016785855588367848L;
	private Long id;
	private Long areaid;
	private Integer lineno;
	private Integer rankno;
	private String seatline;
	private String seatrank;
	private String loveInd;
	private String seatno;

	public Serializable realId() {
		return this.id;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
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

	public String getSeatno() {
		return this.seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSeatLabel() {
		return this.seatline + "ÅÅ" + this.seatrank + "×ù";
	}

	public String getLoveInd() {
		return this.loveInd;
	}

	public void setLoveInd(String loveInd) {
		this.loveInd = loveInd;
	}

	public String getPosition() {
		return this.lineno + ":" + this.rankno;
	}

	public String getRelative() {
		return this.seatline + ":" + this.seatrank;
	}
}