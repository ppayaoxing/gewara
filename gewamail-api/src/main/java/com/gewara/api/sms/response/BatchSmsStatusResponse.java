package com.gewara.api.sms.response;

import com.gewara.api.MsgResponse;
/**
 * 批次短信发送状态
 */
public class BatchSmsStatusResponse extends MsgResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7944063687032876841L;
	/**
	 * 批次短信发送状态，内容以Json格式
	 */
	private String statusInfo;

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	
	public BatchSmsStatusResponse(){
		
	}
	public BatchSmsStatusResponse(String statusInfo,String code,String msg){
		super.setCode(code);
		super.setMsg(msg);
		this.statusInfo = statusInfo;
	}
	
	public BatchSmsStatusResponse getSuccessReturn(String statusInfo){
		BatchSmsStatusResponse response = new BatchSmsStatusResponse();
		response.setStatusInfo(statusInfo);
		response.setSuccess();
		return response;
	}
	
}
