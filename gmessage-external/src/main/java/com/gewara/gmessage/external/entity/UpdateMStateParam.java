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
	 * @param receiver 锟斤拷锟斤拷为锟秸★拷 
	 * @param opertionType 1锟斤拷-1锟斤拷 
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
	 * 锟斤拷锟斤拷锟斤拷锟酵ｏ拷 1锟斤拷示 锟窖讹拷锟斤拷锟斤拷锟斤拷 -1锟斤拷示删锟斤拷锟斤拷锟斤拷锟斤拷
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
		if(realeaIDType==null||realeaID==null) {
            return null;
        }
		return realeaIDType+"-"+realeaID;
	}
	
	/**
	 * 锟斤拷锟斤拷锟矫伙拷锟斤拷息ID锟叫憋拷锟斤拷锟斤拷锟矫伙拷锟斤拷息状态锟斤拷
	 * @param messageIDs 锟矫伙拷锟斤拷息ID锟叫憋拷
	 */
	public void setMessageIDs(Collection<Long> messageIDs) {
		this.messageIDs = messageIDs;
	}
	
	public void addMessageIDs(long messageID){
		if(this.messageIDs==null) {
            this.messageIDs = new HashSet<>();
        }
		this.messageIDs.add(messageID);
	}


	/**
	 * 锟斤拷锟捷癸拷锟斤拷锟斤拷 目锟斤拷ID锟斤拷锟斤拷锟斤拷锟酵斤拷锟叫革拷锟斤拷锟斤拷息状态锟斤拷
	 * 锟截憋拷注锟解，锟斤拷锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷息ID锟叫憋拷墓锟较碉拷腔锟侥癸拷系锟斤拷
	 * @param realeaID  锟矫伙拷锟斤拷息锟叫癸拷锟斤拷锟斤拷 锟斤拷锟斤拷目锟斤拷ID
	 * @param realeaIDType 锟矫伙拷锟斤拷息锟叫癸拷锟斤拷锟斤拷 锟斤拷锟斤拷目锟斤拷ID锟斤拷锟斤拷锟斤拷
	 */
	public void setRealeaID(MCategory category,String realeaID,String realeaIDType) {
		this.category=category;
		this.realeaID = realeaID;
		this.realeaIDType= realeaIDType;
	}
}
