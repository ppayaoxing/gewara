package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class FieldVo extends BaseVo {
	private static final long serialVersionUID = 4944099097409524223L;
	
	private Long id;					//����ID
	private String name;				//��������
	private Long theatreid;				//����ID
	private String fieldnum;			//���ر��(TheareField-->fieldnum)
	private String fieldserial;			//�������
	private String status;
	private String fieldtype;			//��������: gewara��gptbs
	private String logo;				//
	private Timestamp updatetime;		//����ʱ��

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
