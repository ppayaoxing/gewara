package com.gewara.api.activity;

import java.io.Serializable;
import java.util.Map;

public abstract class ApiRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 549424954702608094L;

	public abstract Map<String, String> getTextParams();
	
	/**
	 * 检查参数
	 * 
	 * @return
	 *
	 * @author leo.li
	 * Modify Time 2014年3月28日 下午3:12:12
	 */
	public abstract boolean checkParams();
}
