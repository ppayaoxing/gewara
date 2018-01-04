package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class FieldVo extends BaseVo {
	private static final long serialVersionUID = 4944099097409524223L;
	
	private Long id;					//锟斤拷锟斤拷ID
	private String name;				//锟斤拷锟斤拷锟斤拷锟斤拷
	private Long theatreid;				//锟斤拷锟斤拷ID
	private String fieldnum;			//锟斤拷锟截憋拷锟�(TheareField-->fieldnum)
	private String fieldserial;			//锟斤拷锟斤拷锟斤拷锟�
	private String status;
	private String fieldtype;			//锟斤拷锟斤拷锟斤拷锟斤拷: gewara锟斤拷gptbs
	private String logo;				//
	private Timestamp updatetime;		//锟斤拷锟斤拷时锟斤拷

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

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getFieldserial() {
		return fieldserial;
	}

	public void setFieldserial(String fieldserial) {
		this.fieldserial = fieldserial;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean hasStatus(String stats){
		if(StringUtils.isBlank(stats)) {
            return false;
        }
		return StringUtils.equals(this.status, stats);
	}
	
	public String getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}
