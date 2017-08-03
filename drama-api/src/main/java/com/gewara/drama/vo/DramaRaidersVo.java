package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class DramaRaidersVo extends BaseVo {

	private static final long serialVersionUID = -1158306639477608205L;

	private Long id;
	private Long dramaid;
	private String title;		//¹¥ÂÔ±êÌâ
	private String description;	//ÄÚÈÝ
	private Integer sortnum;		//ÅÅÐò×Ö¶Î
	private String raidersType;
	private String platform;
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

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRaidersType() {
		return raidersType;
	}

	public void setRaidersType(String raidersType) {
		this.raidersType = raidersType;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
