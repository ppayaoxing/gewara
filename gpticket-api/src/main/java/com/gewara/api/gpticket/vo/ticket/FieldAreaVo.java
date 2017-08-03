package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class FieldAreaVo extends BaseVo{
	private static final long serialVersionUID = 1589781612588775506L;
	
	private Long id;					// 
	private String name;				//区域名称
	private Long theatreid;				//场馆ID
	private String fieldnum;			//场地序号(TheareField-->fieldnum)
	private String fieldserial;			//第三方场地ID
	private String areanum;				//区域编号(TheatreRoom-->num)
	private String areaserial;			//区域序号
	private Integer firstline;			//起始行座标
	private Integer firstrank;			//起始列座标
	private Integer linenum;			//座位行数
	private Integer ranknum;			//座位列数
	private Integer seatnum;			//座位数量
	private String areatype;			//类型：gptbs
	private String status;				//
	private String hotzone;				//座标
	private Timestamp updatetime;		//更新时间
	
	public FieldAreaVo(){}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getFieldserial() {
		return fieldserial;
	}

	public void setFieldserial(String fieldserial) {
		this.fieldserial = fieldserial;
	}

	public String getAreanum() {
		return areanum;
	}

	public void setAreanum(String areanum) {
		this.areanum = areanum;
	}

	public String getAreaserial() {
		return areaserial;
	}

	public void setAreaserial(String areaserial) {
		this.areaserial = areaserial;
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

	public String getAreatype() {
		return areatype;
	}

	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getHotzone() {
		return hotzone;
	}

	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public boolean hasStatus(String stats){
		if(StringUtils.isBlank(stats)) return false;
		return StringUtils.equals(this.status, stats);
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}
	
}
