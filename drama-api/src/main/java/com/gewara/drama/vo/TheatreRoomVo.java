package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class TheatreRoomVo extends BaseVo implements Comparable<TheatreRoomVo> {
	private static final long serialVersionUID = -956032860612050805L;
	private Long id;
	private String roomname;			//名称
	private String content;			//详细描述
	private Integer linenum;			//座位行数
	private Integer ranknum;			//座位列数
	private Integer seatnum;			//座位数量
	private String roomnum;			//排序
	private String sections;			//多个场区，用逗号隔开
	private String roomtype;
	private Timestamp updatetime;		//座位更新时间
	private Integer firstline;
	private Integer firstrank;		
	private String logo;				//LOGO
	private Long theatreid;
	private String seatmap;
	private String hotzone;
	private Long fieldid;
	private String fieldnum;
	private String svgpath;
	
	private String autotype;		//自动选座类型  S从左往右，R从右往左,M从中间往两边
	private String autosort;		//自动选座优先排号排序
	
	public TheatreRoomVo(){}

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

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getTheatreid() {
		return theatreid;
	}
	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}
	@Override
	public int compareTo(TheatreRoomVo o) {
		return StringUtils.leftPad(""+roomnum, 3, '0').compareTo(StringUtils.leftPad(""+o.roomnum, 3, '0'));
	}
	
	public String getSeatmap() {
		return seatmap;
	}
	public void setSeatmap(String seatmap) {
		this.seatmap = seatmap;
	}
	public Long getFieldid() {
		return fieldid;
	}
	public void setFieldid(Long fieldid) {
		this.fieldid = fieldid;
	}
	public String getHotzone() {
		return hotzone;
	}
	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}
	
	public String getAutotype() {
		return autotype;
	}

	public void setAutotype(String autotype) {
		this.autotype = autotype;
	}

	public String getAutosort() {
		return autosort;
	}

	public void setAutosort(String autosort) {
		this.autosort = autosort;
	}

	public String getSvgpath() {
		return svgpath;
	}

	public void setSvgpath(String svgpath) {
		this.svgpath = svgpath;
	}

}
