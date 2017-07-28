/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay;

import java.io.Serializable;
import java.util.Map;

public abstract class ApiRequest implements Serializable {
	private static final long serialVersionUID = 549424954702608094L;

	public abstract Map<String, String> getTextParams();

	public abstract boolean checkParams();
}