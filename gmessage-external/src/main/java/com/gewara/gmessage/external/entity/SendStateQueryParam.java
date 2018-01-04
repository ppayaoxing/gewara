package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;

/**
 * ��Ϣ����״̬��ѯ����
 * 
 * @author ����
 * @createDate 2015��12��3��
 */
public class SendStateQueryParam implements Serializable{

	private static final long serialVersionUID = 2804118341623987745L;

	/** ҳ�룬Ĭ�ϵ�һҳ */
	private int pageNo = 1;// ҳ�룬Ĭ�ϵ�һҳ

	/** ÿҳ�ļ�¼����Ĭ��50 */
	private int pageSize = 50;// ÿҳ�ļ�¼����Ĭ��50��

	private MCategory category = null; // ��Ϣ����
	private String relateIDType = null;// ҵ����������
	private String relateID = null;// ҵ������ID

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public MCategory getCategory() {
		return category;
	}

	public String getRelateIDType() {
		return relateIDType;
	}

	public String getRelateID() {
		return relateID;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCategory(MCategory category) {
		this.category = category;
	}

	public void setRelateIDType(String relateIDType) {
		this.relateIDType = relateIDType;
	}

	public void setRelateID(String relateID) {
		this.relateID = relateID;
	}
	
	public String getUreaid(){
		if(relateIDType==null||relateID==null) {
            return null;
        }
		return relateIDType+"-"+relateID;
	}

}
