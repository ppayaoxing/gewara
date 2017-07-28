/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.json.ourplay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class OurPlayConfigVo extends BaseVo {
	private static final long serialVersionUID = 2347082236569945065L;
	private String id;
	private String tag;
	private String context;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}