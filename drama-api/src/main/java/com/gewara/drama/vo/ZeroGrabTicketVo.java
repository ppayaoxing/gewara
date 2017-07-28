/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ZeroGrabTicketVo extends BaseVo {
	private static final long serialVersionUID = -3298655438669790832L;
	private Long priceid;
	private String flag;
	private String title;
	private Timestamp starttime;
	private Timestamp endtime;
	private Long dpid;
	private Long dramaid;
	private String status;
	private Integer sortnum;
	private String uniqueby;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.priceid;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getUniqueby() {
		return this.uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
}