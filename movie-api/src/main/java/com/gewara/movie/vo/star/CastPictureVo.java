/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.star;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CastPictureVo extends BaseVo {
	private static final long serialVersionUID = -100677988174265653L;
	private Long id;
	private Long castid;
	private String picname;
	private String picurl;
	private String piccategory;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer picwidth;
	private Integer picheight;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCastid() {
		return this.castid;
	}

	public void setCastid(Long castid) {
		this.castid = castid;
	}

	public String getPicname() {
		return this.picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getPiccategory() {
		return this.piccategory;
	}

	public void setPiccategory(String piccategory) {
		this.piccategory = piccategory;
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

	public Serializable realId() {
		return this.id;
	}

	public Integer getPicwidth() {
		return this.picwidth;
	}

	public void setPicwidth(Integer picwidth) {
		this.picwidth = picwidth;
	}

	public Integer getPicheight() {
		return this.picheight;
	}

	public void setPicheight(Integer picheight) {
		this.picheight = picheight;
	}
}