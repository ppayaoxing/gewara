package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;

/**
 * 消息发送状态查询参数
 * 
 * @author 董明
 * @createDate 2015年12月3日
 */
public class SendStateQueryParam implements Serializable{

	private static final long serialVersionUID = 2804118341623987745L;

	/** 页码，默认第一页 */
	private int pageNo = 1;// 页码，默认第一页

	/** 每页的记录数。默认50 */
	private int pageSize = 50;// 每页的记录数。默认50；

	private MCategory category = null; // 消息种类
	private String relateIDType = null;// 业务主键类型
	private String relateID = null;// 业务主键ID

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
		if(relateIDType==null||relateID==null) return null;
		return relateIDType+"-"+relateID;
	}

}
