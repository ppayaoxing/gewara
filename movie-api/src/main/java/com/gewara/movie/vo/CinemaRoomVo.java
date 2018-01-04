package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28����02:05:17
 */
public class CinemaRoomVo extends BaseVo implements Comparable<CinemaRoomVo>{
	public static final String OPEN_GEWARA = "GEWA";		//�������ͣ�������˶Խ�
	private static final long serialVersionUID = -1894201195221566397L;
	private Long id;
	private String roomname;			//����
	private String content;			//��ϸ����
	private Integer linenum;			//��λ����
	private Integer ranknum;			//��λ����
	private Integer seatnum;			//��λ����
	private String num;				//����
	private String sections;			//����������ö��Ÿ���
	private String roomtype;
	private Timestamp updatetime;		//��λ����ʱ��
	private Integer firstline;
	private Integer firstrank;		
	private String logo;				//LOGO
	private Long cinemaid;
	private Integer screenheight; 		//��Ļ��
	private Integer screenwidth; 		//��Ļ��
	private Integer allowsellnum;		//����������
	private String vipflag;				//�Ƿ�ΪVIP
	private String seatmap;				//��λͼ��λͼ��
	private String loveflag;			//�Ƿ���������
	private Date effectivedate;			//��λ��Ч����
	private String playtype;			//�������ͣ���ӳ3D��2D��IMAX
	private String roomDoor;         //Ӱ������
	private String otherinfo;
	private String characteristic;	//��ɫ������
	private String defaultEdition; //Ĭ�ϰ汾�����Ӣ�Ķ���,�ָ 
	protected String roomnum;			//����
	protected String buylimit;		//�����������ƣ�1,2,3,4,5
	private String newCharacteristic;	//�°���ɫ������ ֧�ֶ�����Ч�ö��ŷֿ�  ע�⣺��̨����ά����4D��4DX����ͬʱ���ڣ����Բ�ѯ4D��ʱ���õ���4DX�����
	private String status; 				// Ӱ��״̬��open/close
	private String secid;				//�ڶ���������
	private Integer lovstExtraFee;		//�������Ӽ۽��
	private String secretKey;			//��ӳ����Կ
	private String isLoveSeatRoom;          //�Ƿ�������Ӱ�����ǣ�"1"����"0"
	
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
		this.status = "open";	// Ӱ��Ĭ�Ͽ���
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
