/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.common.CountyVo;
import java.io.Serializable;

public class IndexareaVo extends BaseVo {
	private static final long serialVersionUID = -886944461240705718L;
	private String indexareacode;
	private CountyVo county;
	private String indexareaname;

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public String getIndexareaname() {
		return this.indexareaname;
	}

	public void setIndexareaname(String indexareaname) {
		this.indexareaname = indexareaname;
	}

	public void setCounty(CountyVo county) {
		this.county = county;
	}

	public CountyVo getCounty() {
		return this.county;
	}

	public String getId() {
		return this.indexareacode;
	}

	public Serializable realId() {
		return this.indexareacode;
	}

	public String getCode() {
		return this.indexareacode;
	}

	public String getName() {
		return this.indexareaname;
	}
}