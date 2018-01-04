package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;

/**
 * 锟斤拷息锟斤拷锟斤拷状态锟斤拷询锟斤拷锟斤拷
 * 
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷12锟斤拷3锟斤拷
 */
public class SendStateQueryParam implements Serializable{

	private static final long serialVersionUID = 2804118341623987745L;

	/** 页锟诫，默锟较碉拷一页 */
	private int pageNo = 1;// 页锟诫，默锟较碉拷一页

	/** 每页锟侥硷拷录锟斤拷锟斤拷默锟斤拷50 */
	private int pageSize = 50;// 每页锟侥硷拷录锟斤拷锟斤拷默锟斤拷50锟斤拷

	private MCategory category = null; // 锟斤拷息锟斤拷锟斤拷
	private String relateIDType = null;// 业锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	private String relateID = null;// 业锟斤拷锟斤拷锟斤拷ID

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
