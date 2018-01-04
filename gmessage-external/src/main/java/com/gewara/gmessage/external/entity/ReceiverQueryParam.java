package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;
import com.gewara.gmessage.external.constant.MType;
import com.gewara.gmessage.external.constant.UserType;

/**
 * 按照消息接收者进行查询时的查询条件
 *
 */
public class ReceiverQueryParam implements Serializable{
	private static final long serialVersionUID = -841776701319728714L;
	
	private int pageNo=1;
	private int pageSize=50;//
	
	private MUser receiver=null;
	private Boolean read=false;//
	private MCategory messageCat=MCategory.INTERACT;
	private MType[] types=null;
	private Long reciveTimes=null;//
	
	
	/**
	 * @param receiver 消息接受者ID
	 * @param userType 消息接收者类型
	 */
	public ReceiverQueryParam(String receiver,UserType userType){
		this.receiver=new MUser(receiver,userType);
	}
	
	/**
	 * @param receiver 消息接受者ID
	 * @param userType 消息接收者类型
	 */
	public ReceiverQueryParam(MUser receiver){
		this.receiver=receiver;
	}
	
	public MUser getReceiver() {
		return receiver;
	}

	/**接收者*/
	public void setReceiver(MUser receiver) {
		this.receiver = receiver;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**页码，默认第一页*/
	public int getPageSize() {
		return pageSize;
	}
	
	/** 每页的记录数。默认50；*/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Boolean getRead() {
		return read;
	}
	
	/**true，返回已读消息， false，返回未读消息，设置为null返回所有。默认返回未读消息*/
	public void setRead(Boolean read) {
		this.read = read;
	}

	public MCategory getMessageCat() {
		return messageCat;
	}
	
	/**消息种类。必须填写。默认互动。*/
	public void setMessageCat(MCategory messageCat) {
		this.messageCat = messageCat;
	}

	public MType[] getTypes() {
		return types;
	}

	public void setTypes(MType... types) {
		this.types = types;
	}

	public Long getReciveTimes() {
		return reciveTimes;
	}
	
	/**收到消息的日期。返回指定日期之后的消息。该时间段设置请不要超过180.另外该字段为null，就默认为上次查询时间*/
	public void setReciveTimes(Long reciveTimes) {
		this.reciveTimes = reciveTimes;
	}

}
