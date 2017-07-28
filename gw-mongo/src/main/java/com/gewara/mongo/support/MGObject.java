/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.support;

import java.io.Serializable;

public class MGObject implements Serializable {
	private static final long serialVersionUID = 1548619945417324314L;
	private Object _id;

	public void set_id(Object _id) {
		this._id = _id;
	}

	public Object realId() {
		return this._id;
	}
}