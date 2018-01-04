package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 人物、角色关系
 */
public class WorksStaffVo extends BaseVo {

	private static final long serialVersionUID = -1527845351959168455L;
	private Long id;
	private Long castid;				//人物ID
	private Long worksid;				//项目ID
	private String workstype;			//作品类型
	private Long stafllrole;			//人物在作品中的角色
	private Integer sortby;				//排序
	private String rolename;			//所扮演角色
	private Timestamp addtime;			//新增时间
	private Timestamp updatetime;	    //更新时间
	private String chinesename;			//中文名
	private String engname;				//英文名	
	private String headPicUrl;				//头像图片路径	
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
	
	public Long getStafllrole() {
		return stafllrole;
	}
	public void setStafllrole(Long stafllrole) {
		this.stafllrole = stafllrole;
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
	public Integer getSortby() {
		return sortby;
	}
	public void setSortby(Integer sortby) {
		this.sortby = sortby;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getChinesename() {
		return chinesename;
	}
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	public String getEngname() {
		return engname;
	}
	public void setEngname(String engname) {
		this.engname = engname;
	}
	public String getHeadPicUrl() {
		return headPicUrl;
	}
	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

}
