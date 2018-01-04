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
	 * @param receiver ����Ϊ�ա� 
	 * @param opertionType 1��-1�� 
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
	 * �������ͣ� 1��ʾ �Ѷ������� -1��ʾɾ��������
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
	 * �����û���ϢID�б������û���Ϣ״̬��
	 * @param messageIDs �û���ϢID�б�
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
	 * ���ݹ����� Ŀ��ID�������ͽ��и�����Ϣ״̬��
	 * �ر�ע�⣬���������û���ϢID�б�Ĺ�ϵ�ǻ�Ĺ�ϵ��
	 * @param realeaID  �û���Ϣ�й����� ����Ŀ��ID
	 * @param realeaIDType �û���Ϣ�й����� ����Ŀ��ID������
	 */
	public void setRealeaID(MCategory category,String realeaID,String realeaIDType) {
		this.category=category;
		this.realeaID = realeaID;
		this.realeaIDType= realeaIDType;
	}
}
