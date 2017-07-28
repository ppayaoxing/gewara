/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;

public class DramaOpusVo extends BaseVo {
	private static final long serialVersionUID = 5940746594893299685L;
	private Long id;
	private Long dramaid;
	private String title;
	private String entitle;
	private String logo;
	private String description;
	private String videourl;
	private Integer sortnum;
	private Timestamp addtime;
	private Timestamp updatetime;

	public DramaOpusVo() {
	}

	public DramaOpusVo(Long dramaid) {
		this.dramaid = dramaid;
		this.sortnum = Integer.valueOf(1);
		this.addtime = DateUtil.getCurFullTimestamp();
		this.updatetime = this.addtime;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLimg() {
		return this.logo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideourl() {
		return this.videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getEntitle() {
		return this.entitle;
	}

	public void setEntitle(String entitle) {
		this.entitle = entitle;
	}
}