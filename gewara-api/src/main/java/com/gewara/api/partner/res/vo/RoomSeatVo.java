package com.gewara.api.partner.res.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class RoomSeatVo extends BaseVo{
	private static final long serialVersionUID = 6030230522663576759L;
	public static final String SECTION_UP = "up";		//楼上
	public static final String SECTION_DOWN = "dw";		//楼下
	private Long id;
	private Long roomid;		//影厅ID
	private Integer lineno;		//前起第几排,系统生成
	private Integer rankno;		//左起第几列,系统生产
	private String seatline;	//座位行号
	private String seatrank;	//座位列号
	private String loveInd;		//情侣座 0：普通座位 1：情侣座首座位标记 2：情侣座第二座位标记
	private String initstatus;	//每次开放初始状态
	private String secid;		//区域ID
	private String seatStatus;
	public RoomSeatVo(){
		
	}
	public String getSeatLabel(){
		if(StringUtils.isNotBlank(secid)){
			if(SECTION_UP.equals(secid)){
				return "楼上" + seatline + "排"+seatrank+"座";
			}else if(SECTION_DOWN.equals(secid)){
				return "楼下" + seatline + "排" + seatrank + "座";
			}
		}
		return seatline+"排"+seatrank+"座";
	}
	public String getKey(){
		return this.seatline+":"+this.seatrank;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoomid() {
		return roomid;
	}
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
	public Integer getLineno() {
		return lineno;
	}
	public void setLineno(Integer lineno) {
		this.lineno = lineno;
	}
	public Integer getRankno() {
		return rankno;
	}
	public void setRankno(Integer rankno) {
		this.rankno = rankno;
	}
	public String getSeatline() {
		return seatline;
	}
	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}
	public String getSeatrank() {
		return seatrank;
	}
	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}
	public String getLoveInd() {
		return loveInd;
	}
	public void setLoveInd(String loveInd) {
		this.loveInd = loveInd;
	}
	public String getInitstatus() {
		return initstatus;
	}
	public void setInitstatus(String initstatus) {
		this.initstatus = initstatus;
	}
	public String getSecid() {
		return secid;
	}
	public void setSecid(String secid) {
		this.secid = secid;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
}
