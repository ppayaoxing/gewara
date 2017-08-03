package com.gewara.gmessage.external.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import com.gewara.gmessage.external.constant.MCategory;

public class UpdateMStateParam implements Serializable{
	private static final long serialVersionUID = 463982967827437920L;
	
	private MUser receiver=null;
	private MCategory category=null;
	private Integer opertionType=null;
	
	private Collection<Long> messageIDs=null;
	private String realeaID=null;
	private String realeaIDType=null;
	
	
	/**
	 * 
	 * @param receiver 不可为空。 
	 * @param opertionType 1或-1； 
	 */
	public UpdateMStateParam(MUser receiver,int opertionType){
		this.receiver=receiver;
		this.opertionType=opertionType;
	}
	
	public MUser getReceiver() {
		return receiver;
	}


	public MCategory getCategory() {
		return category;
	}


	/**
	 * 操作类型： 1表示 已读操作， -1表示删除操作。
	 * @return
	 */
	public Integer getOpertionType() {
		return opertionType;
	}


	public Collection<Long> getMessageIDs() {
		return messageIDs;
	}


	public String getRealeaID() {
		return realeaID;
	}


	public String getRealeaIDType() {
		return realeaIDType;
	}
	
	public String getUreaid(){
		if(realeaIDType==null||realeaID==null) return null;
		return realeaIDType+"-"+realeaID;
	}
	
	/**
	 * 根据用户消息ID列表，更新用户消息状态，
	 * @param messageIDs 用户消息ID列表
	 */
	public void setMessageIDs(Collection<Long> messageIDs) {
		this.messageIDs = messageIDs;
	}
	
	public void addMessageIDs(long messageID){
		if(this.messageIDs==null)  this.messageIDs=new HashSet<>();
		this.messageIDs.add(messageID);
	}


	/**
	 * 根据关联的 目标ID及其类型进行更新消息状态。
	 * 特别注意，该条件和用户消息ID列表的关系是或的关系。
	 * @param realeaID  用户消息中关联的 关联目标ID
	 * @param realeaIDType 用户消息中关联的 关联目标ID的类型
	 */
	public void setRealeaID(MCategory category,String realeaID,String realeaIDType) {
		this.category=category;
		this.realeaID = realeaID;
		this.realeaIDType= realeaIDType;
	}
}
