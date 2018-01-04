package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class GlossaryBaseInfoVo extends BaseVo {
	private static final long serialVersionUID = 7936910831268916569L;
	private Long id;
	private String infoname;		//名称
	private String infotype;		//信息类型
	private Integer status;			//状态
	private Timestamp addtime;		//新增时间
	private Timestamp updatetime;	//更新时间
	
	public GlossaryBaseInfoVo() {
		this.status = 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInfoname() {
		return infoname;
	}
	public void setInfoname(String infoname) {
		this.infoname = infoname;
	}

	public String getInfotype() {
		return infotype;
	}
	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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
	@Override
	public Serializable realId() {
		return id;
	}

}
