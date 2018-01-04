package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class FieldAreaVo extends BaseVo{
	private static final long serialVersionUID = 1589781612588775506L;
	
	private Long id;					// 
	private String name;				//锟斤拷锟斤拷锟斤拷锟斤拷
	private Long theatreid;				//锟斤拷锟斤拷ID
	private String fieldnum;			//锟斤拷锟斤拷锟斤拷锟�(TheareField-->fieldnum)
	private String fieldserial;			//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷ID
	private String areanum;				//锟斤拷锟斤拷锟斤拷(TheatreRoom-->num)
	private String areaserial;			//锟斤拷锟斤拷锟斤拷锟�
	private Integer firstline;			//锟斤拷始锟斤拷锟斤拷锟斤拷
	private Integer firstrank;			//锟斤拷始锟斤拷锟斤拷锟斤拷
	private Integer linenum;			//锟斤拷位锟斤拷锟斤拷
	private Integer ranknum;			//锟斤拷位锟斤拷锟斤拷
	private Integer seatnum;			//锟斤拷位锟斤拷锟斤拷
	private String areatype;			//锟斤拷锟酵ｏ拷gptbs
	private String status;				//
	private String hotzone;				//锟斤拷锟斤拷
	private Timestamp updatetime;		//锟斤拷锟斤拷时锟斤拷
	
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
		if(StringUtils.isBlank(stats)) {
            return false;
        }
		return StringUtils.equals(this.status, stats);
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}
	
}
