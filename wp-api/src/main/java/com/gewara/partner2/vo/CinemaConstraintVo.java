/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CinemaConstraintVo extends BaseVo {
	private static final long serialVersionUID = 1138307994529929676L;
	private long id;
	private String patnerkey;
	private String provincename;
	private String citycode;
	private String hidetype;
	private String cckey;
	private String hideconstraint;
	private Timestamp addtime;
	private Timestamp updatetime;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatnerkey() {
		return this.patnerkey;
	}

	public void setPatnerkey(String patnerkey) {
		this.patnerkey = patnerkey;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getHidetype() {
		return this.hidetype;
	}

	public void setHidetype(String hidetype) {
		this.hidetype = hidetype;
	}

	public String getCckey() {
		return this.cckey;
	}

	public void setCckey(String cckey) {
		this.cckey = cckey;
	}

	public String getHideconstraint() {
		return this.hideconstraint;
	}

	public void setHideconstraint(String hideconstraint) {
		this.hideconstraint = hideconstraint;
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
		return Long.valueOf(this.id);
	}
}