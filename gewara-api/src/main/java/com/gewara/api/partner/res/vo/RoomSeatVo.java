/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class RoomSeatVo extends BaseVo {
	private static final long serialVersionUID = 6030230522663576759L;
	public static final String SECTION_UP = "up";
	public static final String SECTION_DOWN = "dw";
	private Long id;
	private Long roomid;
	private Integer lineno;
	private Integer rankno;
	private String seatline;
	private String seatrank;
	private String loveInd;
	private String initstatus;
	private String secid;
	private String seatStatus;

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

	public String getKey() {
		return this.seatline + ":" + this.seatrank;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getSeatStatus() {
		return this.seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
}