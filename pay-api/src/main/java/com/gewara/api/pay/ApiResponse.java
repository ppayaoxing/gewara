package com.gewara.api.pay;

import java.io.Serializable;

public abstract class ApiResponse implements Serializable{
	
	public final static String CODE_SUCCESS = "0000";
	
	public final static String CODE_FAIL = "9999";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5249491982205094684L;
	
	public ApiResponse(){
		this.code = CODE_FAIL;
	}

	private String code;

	private String msg;
	
	public boolean isSuccess() {
		return code != null ? "0000".equals(code) : false;
	}
	
	/**
	 * “0000”：表示成功；“9999”：表示错误
	 * 
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Jan 15, 2013 11:19:31 AM
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 获取相关信息
	 * 
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Jan 15, 2013 11:20:54 AM
	 */
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
		
}
