package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class CinemaRoomVo extends BaseVo implements Comparable<CinemaRoomVo>{
	public static final String OPEN_GEWARA = "GEWA";		//开放类型：不与火凤凰对接
	private static final long serialVersionUID = -1894201195221566397L;
	private Long id;
	private String roomname;			//名称
	private String content;			//详细描述
	private Integer linenum;			//座位行数
	private Integer ranknum;			//座位列数
	private Integer seatnum;			//座位数量
	private String num;				//排序
	private String sections;			//多个场区，用逗号隔开
	private String roomtype;
	private Timestamp updatetime;		//座位更新时间
	private Integer firstline;
	private Integer firstrank;		
	private String logo;				//LOGO
	private Long cinemaid;
	private Integer screenheight; 		//银幕高
	private Integer screenwidth; 		//银幕宽
	private Integer allowsellnum;		//允许卖出数
	private String vipflag;				//是否为VIP
	private String seatmap;				//座位图（位图）
	private String loveflag;			//是否有情侣座
	private Date effectivedate;			//座位生效日期
	private String playtype;			//播放类型：放映3D、2D、IMAX
	private String roomDoor;         //影厅的门
	private String otherinfo;
	private String characteristic;	//特色厅类型
	private String defaultEdition; //默认版本，多个英文逗号,分割开 
	protected String roomnum;			//排序
	protected String buylimit;		//购买张数限制，1,2,3,4,5
	private String newCharacteristic;	//新版特色厅类型 支持多种特效用逗号分开  注意：后台数据维护，4D和4DX不会同时存在，所以查询4D的时候不用担心4DX会出现
	private String status; 				// 影厅状态：open/close
	private String secid;				//第二区域类型
	private Integer lovstExtraFee;		//情侣座加价金额
	private String secretKey;			//放映机密钥
	private String isLoveSeatRoom;          //是否情侣座影厅、是："1"；否："0"
	
	public CinemaRoomVo(){}
	public CinemaRoomVo(Long cinemaId, String roomtype){
		this.cinemaid = cinemaId;
		this.roomtype = roomtype;
		this.roomnum = "0";
		this.linenum = 0;
		this.ranknum = 0;
		this.seatnum = 0;
		this.vipflag = "N";
		this.loveflag = "Y";
		this.allowsellnum = 9999;
		this.status = "open";	// 影厅默认开放
		this.lovstExtraFee = 0; 
	}
	
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
	
	public String getRoomname() {
		return roomname;
	}
	
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getLinenum() {
		return linenum;
	}
	
	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}
	
	public Integer getRanknum() {
		return ranknum;
	}
	
	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}
	
	public Integer getSeatnum() {
		return seatnum;
	}
	
	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}
	
	public String getSections() {
		return sections;
	}
	
	public void setSections(String sections) {
		this.sections = sections;
	}
	
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public String getLimg() {
		if(StringUtils.isBlank(logo)) return "img/default_head.png";
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getRoomtype() {
		return roomtype;
	}
	
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	
	public Integer getFirstline() {
		return firstline;
	}
	
	public void setFirstline(Integer firstline) {
		this.firstline = firstline;
	}
	
	public Integer getFirstrank() {
		return firstrank;
	}
	
	public void setFirstrank(Integer firstrank) {
		this.firstrank = firstrank;
	}
	
	public String getRoomnum() {
		return roomnum;
	}
	
	public void setRoomnum(String roomnum) {
		this.num = roomnum;
		this.roomnum = roomnum;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
		this.roomnum = num;
	}
	
	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	
	public Integer getScreenheight() {
		return screenheight;
	}

	public void setScreenheight(Integer screenheight) {
		this.screenheight = screenheight;
	}

	public Integer getScreenwidth() {
		return screenwidth;
	}

	public void setScreenwidth(Integer screenwidth) {
		this.screenwidth = screenwidth;
	}

	public Long getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	public String getVipflag() {
		return vipflag;
	}
	public void setVipflag(String vipflag) {
		this.vipflag = vipflag;
	}
	public Date getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}
	@Override
	public int compareTo(CinemaRoomVo o) {
		return StringUtils.leftPad(""+num, 3, '0').compareTo(StringUtils.leftPad(""+o.num, 3, '0'));
	}
	public String getSeatmap() {
		return seatmap;
	}
	public void setSeatmap(String seatmap) {
		this.seatmap = seatmap;
	}
	public String getLoveflag() {
		return loveflag;
	}
	public void setLoveflag(String loveflag) {
		this.loveflag = loveflag;
	}

	public Integer getAllowsellnum() {
		return allowsellnum;
	}

	public void setAllowsellnum(Integer allowsellnum) {
		this.allowsellnum = allowsellnum;
	}

	public String getPlaytype() {
		return playtype;
	}

	public void setPlaytype(String playtype) {
		this.playtype = playtype;
	}
	
	public boolean hasGewaRoom(){
		return StringUtils.equals(roomtype, OPEN_GEWARA);
	}
	
	public boolean hasRemoteRoom(){
		return !hasGewaRoom();
	}

	public String getRoomDoor() {
		return roomDoor;
	}

	public void setRoomDoor(String roomDoor) {
		this.roomDoor = roomDoor;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getDefaultEdition() {
		return defaultEdition;
	}

	public void setDefaultEdition(String defaultEdition) {
		this.defaultEdition = defaultEdition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isClosed() {
		return (this.status != null) && (this.status.equals("close")); 
	}

	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public String getBuylimit() {
		return buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public String getNewCharacteristic() {
		return newCharacteristic;
	}

	public void setNewCharacteristic(String newCharacteristic) {
		this.newCharacteristic = newCharacteristic;
	}

	public Integer getLovstExtraFee() {
		return lovstExtraFee;
	}

	public void setLovstExtraFee(Integer lovstExtraFee) {
		this.lovstExtraFee = lovstExtraFee;
	}
	
	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public String getIsLoveSeatRoom() {
		return isLoveSeatRoom;
	}

	public void setIsLoveSeatRoom(String isLoveSeatRoom) {
		this.isLoveSeatRoom = isLoveSeatRoom;
	}
	
}
