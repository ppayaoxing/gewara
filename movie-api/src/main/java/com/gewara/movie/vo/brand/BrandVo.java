/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.brand;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BrandVo extends BaseVo {
	private static final long serialVersionUID = 7873532222364050961L;
	private Long id;
	private String brandname;
	private String logourl;
	private Byte status;
	private Integer brandtype;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String brandcolor;

	public String getBrandcolor() {
		return this.brandcolor;
	}

	public void setBrandcolor(String brandcolor) {
		this.brandcolor = brandcolor;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getLogourl() {
		return this.logourl;
	}

	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	public Integer getBrandtype() {
		return this.brandtype;
	}

	public void setBrandtype(Integer brandtype) {
		this.brandtype = brandtype;
	}
}