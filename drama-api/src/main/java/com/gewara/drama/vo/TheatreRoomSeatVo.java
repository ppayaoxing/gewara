/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class TheatreRoomSeatVo extends BaseVo implements Comparable<TheatreRoomSeatVo> {
	private static final long serialVersionUID = 2610922805158148972L;
	public static final String INITSTATUS_CLOSE = "C";
	public static final String INITSTATUS_OPEN = "O";
	private Long id;
	private Long roomid;
	private Integer lineno;
	private Integer rankno;
	private String seatline;
	private String seatrank;
	private String loveInd;
	private String initstatus;

	public Serializable realId() {
		return this.id;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
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

	public int compareTo(TheatreRoomSeatVo o) {
		return this.equals(o) ? 0
				: (!this.roomid.equals(o.roomid) ? this.roomid.compareTo(o.roomid)
						: o.lineno.intValue() * 100 + o.rankno.intValue() - this.lineno.intValue() * 100
								- this.rankno.intValue());
	}

	public String getLoveInd() {
		return this.loveInd;
	}

	public void setLoveInd(String loveInd) {
		this.loveInd = loveInd;
	}

	public String getInitstatus() {
		return this.initstatus;
	}

	public void setInitstatus(String initstatus) {
		this.initstatus = initstatus;
	}

	public String getPosition() {
		return this.lineno + ":" + this.rankno;
	}
}