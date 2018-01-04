package com.gewara.gmessage.external.entity;

import java.io.Serializable;

/**
 * 操作结果。
 * @author 董明
 * @createDate 2015年3月6日
 */
public class OperateResult implements Serializable{
	private static final long serialVersionUID = -4280148580555226376L;

	/*操作是否成功*/
	private boolean success=true;//是否成功

	/**操作失败代码*/
	private String failCode=null;//失败代码；
	/**操作失败原因描述*/
	private String failMessage=null;//失败原因描述；
	
	public OperateResult(boolean success){
		this.success=success;
	}
	
	public OperateResult(boolean success,String failCode){
		this.success=success;
		this.failCode=failCode;
	}	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFailCode() {
		return failCode;
	}
	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}
	public String getFailMessage() {
		return failMessage;
	}
	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}
}
