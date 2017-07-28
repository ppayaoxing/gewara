/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.json.mongo;

import com.gewara.mongo.annotation.MPK;
import com.gewara.mongo.annotation.OID;
import com.gewara.mongo.support.MGObject;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@OID({ "name" })
public class MaintainInfo extends MGObject {
	private static final long serialVersionUID = 1021020774560460505L;
	public static final String FIELD_NAME = "name";
	public static final String FIELD_CREATETIME = "createtime";
	public static final String FIELD_VALIDDATE = "validdate";
	public static final String FIELD_SYSTEM = "system";
	@MPK
	private String name;
	private String desc;
	private Date createtime;
	private Long rowcount;
	private Integer indexcount;
	private Long avgObjSize;
	private Long storageSize;
	private Date updatetime;

	public MaintainInfo() {
	}

	public MaintainInfo(String name) {
		this.name = name;
		this.createtime = new Date();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public boolean manualUpdated() {
		return StringUtils.isNotBlank(this.desc);
	}

	public Long getRowcount() {
		return this.rowcount;
	}

	public void setRowcount(Long rowcount) {
		this.rowcount = rowcount;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getIndexcount() {
		return this.indexcount;
	}

	public void setIndexcount(Integer indexcount) {
		this.indexcount = indexcount;
	}

	public Long getAvgObjSize() {
		return this.avgObjSize;
	}

	public void setAvgObjSize(Long avgObjSize) {
		this.avgObjSize = avgObjSize;
	}

	public Long getStorageSize() {
		return this.storageSize;
	}

	public void setStorageSize(Long storageSize) {
		this.storageSize = storageSize;
	}
}