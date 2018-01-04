package com.gewara.json.mongo;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gewara.mongo.annotation.MPK;
import com.gewara.mongo.annotation.OID;
import com.gewara.mongo.support.MGObject;
@OID("name")
public class MaintainInfo extends MGObject {
	private static final long serialVersionUID = 1021020774560460505L;
	public final static String FIELD_NAME="name";
	public final static String FIELD_CREATETIME="createtime";
	public final static String FIELD_VALIDDATE="validdate";
	public final static String FIELD_SYSTEM="system";
	@MPK
	private String name;
	private String desc;
	private Date createtime;		//加入时间
	private Long rowcount;
	private Integer indexcount;	//索引数量
	private Long avgObjSize;
	private Long storageSize;
	private Date updatetime;		//更新时间

	public MaintainInfo(){
	}
	public MaintainInfo(String name){
		this.name = name;
		this.createtime = new Date();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
	            ToStringStyle.MULTI_LINE_STYLE);
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public boolean manualUpdated(){
		//是否人完整工维护过
		return StringUtils.isNotBlank(desc);
	}
	public Long getRowcount() {
		return rowcount;
	}
	public void setRowcount(Long rowcount) {
		this.rowcount = rowcount;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getIndexcount() {
		return indexcount;
	}
	public void setIndexcount(Integer indexcount) {
		this.indexcount = indexcount;
	}
	public Long getAvgObjSize() {
		return avgObjSize;
	}
	public void setAvgObjSize(Long avgObjSize) {
		this.avgObjSize = avgObjSize;
	}
	public Long getStorageSize() {
		return storageSize;
	}
	public void setStorageSize(Long storageSize) {
		this.storageSize = storageSize;
	}
}
