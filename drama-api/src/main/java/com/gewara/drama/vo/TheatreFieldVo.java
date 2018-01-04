package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class TheatreFieldVo extends BaseVo {
	
	private static final long serialVersionUID = -2692977270173145089L;

	private Long id;
	private Long theatreid;
	private String name;				//��������
	private String fieldnum;			//���ر��
	private String fieldtype;			//��������: GEWA��GPTBS
	private String logo;				//ͼƬ
	private String mobilelogo;			//ͼƬ
	private String description;			//����
	private String status;				//
	private String sortarea;			//�Զ�ѡ����������˳��
	private Timestamp addtime;
	private Timestamp updatetime;
	
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

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
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

	public String getMobilelogo() {
		return mobilelogo;
	}

	public void setMobilelogo(String mobilelogo) {
		this.mobilelogo = mobilelogo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	public boolean hasFieldtype(String type){
		if(StringUtils.isBlank(type)) {
            return false;
        }
		return StringUtils.equals(this.fieldtype, type);
	}
	
	public String getSortarea() {
		return sortarea;
	}

	public void setSortarea(String sortarea) {
		this.sortarea = sortarea;
	}
}
