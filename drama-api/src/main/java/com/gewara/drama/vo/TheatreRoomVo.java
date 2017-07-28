/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class TheatreRoomVo extends BaseVo implements Comparable<TheatreRoomVo> {
	private static final long serialVersionUID = -956032860612050805L;
	private Long id;
	private String roomname;
	private String content;
	private Integer linenum;
	private Integer ranknum;
	private Integer seatnum;
	private String roomnum;
	private String sections;
	private String roomtype;
	private Timestamp updatetime;
	private Integer firstline;
	private Integer firstrank;
	private String logo;
	private Long theatreid;
	private String seatmap;
	private String hotzone;
	private Long fieldid;
	private String fieldnum;
	private String svgpath;
	private String autotype;
	private String autosort;

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

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getSections() {
		return this.sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public int compareTo(TheatreRoomVo o) {
		return StringUtils.leftPad("" + this.roomnum, 3, '0').compareTo(StringUtils.leftPad("" + o.roomnum, 3, '0'));
	}

	public String getSeatmap() {
		return this.seatmap;
	}

	public void setSeatmap(String seatmap) {
		this.seatmap = seatmap;
	}

	public Long getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(Long fieldid) {
		this.fieldid = fieldid;
	}

	public String getHotzone() {
		return this.hotzone;
	}

	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public String getFieldnum() {
		return this.fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getAutotype() {
		return this.autotype;
	}

	public void setAutotype(String autotype) {
		this.autotype = autotype;
	}

	public String getAutosort() {
		return this.autosort;
	}

	public void setAutosort(String autosort) {
		this.autosort = autosort;
	}

	public String getSvgpath() {
		return this.svgpath;
	}

	public void setSvgpath(String svgpath) {
		this.svgpath = svgpath;
	}
}