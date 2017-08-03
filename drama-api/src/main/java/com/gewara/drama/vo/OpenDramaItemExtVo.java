package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OpenDramaItemExtVo extends BaseVo {

	private static final long serialVersionUID = 7283568142530575779L;
	private Long dpid;
	private String reserve;				//是否能预约
	private Timestamp rstarttime;		//预约开始时间
	private Timestamp rendtime;		//预约结束时间
	private Timestamp createtime;		//添加时间
	private Timestamp updatetime;		//更新时间

	private String pushText;				//成功后push内容
	private String pushType;				//成功后push类型
	private String pushLink;				//成功后push的链接
	
	public OpenDramaItemExtVo(){}
	
	@Override
	public Serializable realId() {
		return dpid;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public Timestamp getRstarttime() {
		return rstarttime;
	}

	public void setRstarttime(Timestamp rstarttime) {
		this.rstarttime = rstarttime;
	}

	public Timestamp getRendtime() {
		return rendtime;
	}

	public void setRendtime(Timestamp rendtime) {
		this.rendtime = rendtime;
	}


	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getPushText() {
		return pushText;
	}

	public void setPushText(String pushText) {
		this.pushText = pushText;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public String getPushLink() {
		return pushLink;
	}

	public void setPushLink(String pushLink) {
		this.pushLink = pushLink;
	}

}
