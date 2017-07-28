/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class CinemaRoomVo extends BaseVo implements Comparable<CinemaRoomVo> {
	public static final String OPEN_GEWARA = "GEWA";
	private static final long serialVersionUID = -1894201195221566397L;
	private Long id;
	private String roomname;
	private String content;
	private Integer linenum;
	private Integer ranknum;
	private Integer seatnum;
	private String num;
	private String sections;
	private String roomtype;
	private Timestamp updatetime;
	private Integer firstline;
	private Integer firstrank;
	private String logo;
	private Long cinemaid;
	private Integer screenheight;
	private Integer screenwidth;
	private Integer allowsellnum;
	private String vipflag;
	private String seatmap;
	private String loveflag;
	private Date effectivedate;
	private String playtype;
	private String roomDoor;
	private String otherinfo;
	private String characteristic;
	private String defaultEdition;
	protected String roomnum;
	protected String buylimit;
	private String newCharacteristic;
	private String status;
	private String secid;
	private Integer lovstExtraFee;
	private String secretKey;
	private String isLoveSeatRoom;

	public CinemaRoomVo() {
	}

	public CinemaRoomVo(Long cinemaId, String roomtype) {
		this.cinemaid = cinemaId;
		this.roomtype = roomtype;
		this.roomnum = "0";
		this.linenum = Integer.valueOf(0);
		this.ranknum = Integer.valueOf(0);
		this.seatnum = Integer.valueOf(0);
		this.vipflag = "N";
		this.loveflag = "Y";
		this.allowsellnum = Integer.valueOf(9999);
		this.status = "open";
		this.lovstExtraFee = Integer.valueOf(0);
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getRanknum() {
		return this.ranknum;
	}

	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}

	public Integer getSeatnum() {
		return this.seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public String getSections() {
		return this.sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getLogo() {
		return this.logo;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getFirstline() {
		return this.firstline;
	}

	public void setFirstline(Integer firstline) {
		this.firstline = firstline;
	}

	public Integer getFirstrank() {
		return this.firstrank;
	}

	public void setFirstrank(Integer firstrank) {
		this.firstrank = firstrank;
	}

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.num = roomnum;
		this.roomnum = roomnum;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
		this.roomnum = num;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public Integer getScreenheight() {
		return this.screenheight;
	}

	public void setScreenheight(Integer screenheight) {
		this.screenheight = screenheight;
	}

	public Integer getScreenwidth() {
		return this.screenwidth;
	}

	public void setScreenwidth(Integer screenwidth) {
		this.screenwidth = screenwidth;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getVipflag() {
		return this.vipflag;
	}

	public void setVipflag(String vipflag) {
		this.vipflag = vipflag;
	}

	public Date getEffectivedate() {
		return this.effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public int compareTo(CinemaRoomVo o) {
		return StringUtils.leftPad("" + this.num, 3, '0').compareTo(StringUtils.leftPad("" + o.num, 3, '0'));
	}

	public String getSeatmap() {
		return this.seatmap;
	}

	public void setSeatmap(String seatmap) {
		this.seatmap = seatmap;
	}

	public String getLoveflag() {
		return this.loveflag;
	}

	public void setLoveflag(String loveflag) {
		this.loveflag = loveflag;
	}

	public Integer getAllowsellnum() {
		return this.allowsellnum;
	}

	public void setAllowsellnum(Integer allowsellnum) {
		this.allowsellnum = allowsellnum;
	}

	public String getPlaytype() {
		return this.playtype;
	}

	public void setPlaytype(String playtype) {
		this.playtype = playtype;
	}

	public boolean hasGewaRoom() {
		return StringUtils.equals(this.roomtype, "GEWA");
	}

	public boolean hasRemoteRoom() {
		return !this.hasGewaRoom();
	}

	public String getRoomDoor() {
		return this.roomDoor;
	}

	public void setRoomDoor(String roomDoor) {
		this.roomDoor = roomDoor;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getDefaultEdition() {
		return this.defaultEdition;
	}

	public void setDefaultEdition(String defaultEdition) {
		this.defaultEdition = defaultEdition;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isClosed() {
		return this.status != null && this.status.equals("close");
	}

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public String getBuylimit() {
		return this.buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public String getNewCharacteristic() {
		return this.newCharacteristic;
	}

	public void setNewCharacteristic(String newCharacteristic) {
		this.newCharacteristic = newCharacteristic;
	}

	public Integer getLovstExtraFee() {
		return this.lovstExtraFee;
	}

	public void setLovstExtraFee(Integer lovstExtraFee) {
		this.lovstExtraFee = lovstExtraFee;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getIsLoveSeatRoom() {
		return this.isLoveSeatRoom;
	}

	public void setIsLoveSeatRoom(String isLoveSeatRoom) {
		this.isLoveSeatRoom = isLoveSeatRoom;
	}
}