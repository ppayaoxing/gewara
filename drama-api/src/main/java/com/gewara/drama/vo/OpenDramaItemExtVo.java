/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OpenDramaItemExtVo extends BaseVo {
	private static final long serialVersionUID = 7283568142530575779L;
	private Long dpid;
	private String reserve;
	private Timestamp rstarttime;
	private Timestamp rendtime;
	private Timestamp createtime;
	private Timestamp updatetime;
	private String pushText;
	private String pushType;
	private String pushLink;

	public Serializable realId() {
		return this.dpid;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getReserve() {
		return this.reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public Timestamp getRstarttime() {
		return this.rstarttime;
	}

	public void setRstarttime(Timestamp rstarttime) {
		this.rstarttime = rstarttime;
	}

	public Timestamp getRendtime() {
		return this.rendtime;
	}

	public void setRendtime(Timestamp rendtime) {
		this.rendtime = rendtime;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getPushText() {
		return this.pushText;
	}

	public void setPushText(String pushText) {
		this.pushText = pushText;
	}

	public String getPushType() {
		return this.pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public String getPushLink() {
		return this.pushLink;
	}

	public void setPushLink(String pushLink) {
		this.pushLink = pushLink;
	}
}