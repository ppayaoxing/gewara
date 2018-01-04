package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class CastBaseRelationVo extends BaseVo {
	private static final long serialVersionUID = -3007170459229696038L;
	private Long id;
	private Long castid;						//人物ID
	private Long baseinfoid;				//基本信息ID
	private String infotype;				//信息类型
	private Timestamp addtime;			//新增时间
	private Timestamp updatetime;	//更新时间
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCastid() {
		return castid;
	}

	public void setCastid(Long castid) {
		this.castid = castid;
	}

	public Long getBaseinfoid() {
		return baseinfoid;
	}

	public void setBaseinfoid(Long baseinfoid) {
		this.baseinfoid = baseinfoid;
	}

	public String getInfotype() {
		return infotype;
	}

	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}

	@Override
	public Serializable realId() {
		return id;
	}

}
