package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28锟斤拷锟斤拷02:05:17
 */
public class CinemaRoomVo extends BaseVo implements Comparable<CinemaRoomVo>{
	public static final String OPEN_GEWARA = "GEWA";		//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷硕越锟�
	private static final long serialVersionUID = -1894201195221566397L;
	private Long id;
	private String roomname;			//锟斤拷锟斤拷
	private String content;			//锟斤拷细锟斤拷锟斤拷
	private Integer linenum;			//锟斤拷位锟斤拷锟斤拷
	private Integer ranknum;			//锟斤拷位锟斤拷锟斤拷
	private Integer seatnum;			//锟斤拷位锟斤拷锟斤拷
	private String num;				//锟斤拷锟斤拷
	private String sections;			//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷枚锟斤拷鸥锟斤拷锟�
	private String roomtype;
	private Timestamp updatetime;		//锟斤拷位锟斤拷锟斤拷时锟斤拷
	private Integer firstline;
	private Integer firstrank;		
	private String logo;				//LOGO
	private Long cinemaid;
	private Integer screenheight; 		//锟斤拷幕锟斤拷
	private Integer screenwidth; 		//锟斤拷幕锟斤拷
	private Integer allowsellnum;		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	private String vipflag;				//锟角凤拷为VIP
	private String seatmap;				//锟斤拷位图锟斤拷位图锟斤拷
	private String loveflag;			//锟角凤拷锟斤拷锟斤拷锟斤拷锟斤拷
	private Date effectivedate;			//锟斤拷位锟斤拷效锟斤拷锟斤拷
	private String playtype;			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷映3D锟斤拷2D锟斤拷IMAX
	private String roomDoor;         //影锟斤拷锟斤拷锟斤拷
	private String otherinfo;
	private String characteristic;	//锟斤拷色锟斤拷锟斤拷锟斤拷
	private String defaultEdition; //默锟较版本锟斤拷锟斤拷锟接拷亩锟斤拷锟�,锟街割开 
	protected String roomnum;			//锟斤拷锟斤拷
	protected String buylimit;		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟狡ｏ拷1,2,3,4,5
	private String newCharacteristic;	//锟铰帮拷锟斤拷色锟斤拷锟斤拷锟斤拷 支锟街讹拷锟斤拷锟斤拷效锟矫讹拷锟脚分匡拷  注锟解：锟斤拷台锟斤拷锟斤拷维锟斤拷锟斤拷4D锟斤拷4DX锟斤拷锟斤拷同时锟斤拷锟节ｏ拷锟斤拷锟皆诧拷询4D锟斤拷时锟斤拷锟矫碉拷锟斤拷4DX锟斤拷锟斤拷锟�
	private String status; 				// 影锟斤拷状态锟斤拷open/close
	private String secid;				//锟节讹拷锟斤拷锟斤拷锟斤拷锟斤拷
	private Integer lovstExtraFee;		//锟斤拷锟斤拷锟斤拷锟接价斤拷锟�
	private String secretKey;			//锟斤拷映锟斤拷锟斤拷钥
	private String isLoveSeatRoom;          //锟角凤拷锟斤拷锟斤拷锟斤拷影锟斤拷锟斤拷锟角ｏ拷"1"锟斤拷锟斤拷"0"
	
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
		this.status = "open";	// 影锟斤拷默锟较匡拷锟斤拷
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
		if(StringUtils.isBlank(logo)) {
            return "img/default_head.png";
        }
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
		return (this.status != null) && ("close".equals(this.status));
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
