package com.gewara.api;

import java.io.Serializable;

public abstract class MsgResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8647520008960856935L;
	
	private String code;

	private String msg;
	
	
	public boolean isSuccess() {
		return code != null ? "0000".equals(code) : false;
	}
	
	public void setSuccess() {
		this.code = "0000";
		this.msg = "成功";
	}
	
	public void setSuccess(String msg) {
		setSuccess();
		setMsg(msg);
	}
	
	public void setFailure() {
		this.code = "9999";
		this.msg = "失败";
	}
	
	public void setFailure(String msg) {
		setFailure();
		setMsg(msg);
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
