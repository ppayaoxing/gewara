package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class CastWorksVo extends BaseVo {

	private static final long serialVersionUID = -1527835351959168455L;
	private Long id;
	private Long castid;					//人物ID
	private Long worksid;					//项目ID
	private String workstype;				//作品类型
	private String achievement;			    //是否成就作品
	private Timestamp addtime;			    //新增时间
	private Timestamp updatetime;	        //更新时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCastid() {
		return castid;
	}
	public void setCastid(Long castid) {
		this.castid = castid;
	}
	public Long getWorksid() {
		return worksid;
	}
	public void setWorksid(Long worksid) {
		this.worksid = worksid;
	}
	public String getWorkstype() {
		return workstype;
	}
	public void setWorkstype(String workstype) {
		this.workstype = workstype;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
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
