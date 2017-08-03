package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class TheatreToDramaVo extends BaseVo {

	private static final long serialVersionUID = 763926967794753721L;
	
	private Long id;
	private Long theatreid;
	private Long dramaid;
	private Integer sortnum;
	private Timestamp addtime;
	private Timestamp updatetime;
	
	public TheatreToDramaVo(){}
	
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

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
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

}
