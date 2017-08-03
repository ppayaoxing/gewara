package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class OurPlayConfigVo extends BaseVo {
	private static final long serialVersionUID = 2347082236569945065L;
	
	private String id;
	private String tag;
	private String context;

	@Override
	public Serializable realId() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
