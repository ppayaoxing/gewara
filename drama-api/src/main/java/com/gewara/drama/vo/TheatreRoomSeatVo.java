package com.gewara.drama.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class TheatreRoomSeatVo  extends BaseVo implements Comparable<TheatreRoomSeatVo>{
	private static final long serialVersionUID = 2610922805158148972L;
	public static final String INITSTATUS_CLOSE = "C";
	public static final String INITSTATUS_OPEN = "O";
	private Long id;
	private Long roomid;			//Ӱ��ID
	private Integer lineno;		//ǰ��ڼ���,ϵͳ����
	private Integer rankno;		//����ڼ���,ϵͳ����
	private String seatline;	//��λ�к�
	private String seatrank;	//��λ�к�
	private String loveInd;		//������ 0����ͨ��λ 1������������λ��� 2���������ڶ���λ���
	private String initstatus;	//ÿ�ο��ų�ʼ״̬
	
	public TheatreRoomSeatVo() {
	}
	
	@Override
	public Serializable realId() {
		return id;
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String getSeatLabel(){
		return seatline+"��"+seatrank+"��";
	}
	@Override
	public int compareTo(TheatreRoomSeatVo o) {
		if(this.equals(o)) {
            return 0;
        }
		if(!roomid.equals(o.roomid)) {
            return roomid.compareTo(o.roomid);
        }
		return o.lineno*100 + o.rankno - lineno*100 - rankno;
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
	
	public String getPosition(){
		return this.lineno+":" + this.rankno; 
	}
	
}
