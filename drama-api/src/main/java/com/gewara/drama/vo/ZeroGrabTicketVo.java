package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ZeroGrabTicketVo extends BaseVo {

	private static final long serialVersionUID = -3298655438669790832L;
	private Long priceid;					//价格ID
	private String flag;					//特殊标识抢票
	private String title;					//说明
	private Timestamp starttime;			//开始时间
	private Timestamp endtime;				//结束时间
	private Long dpid;						//场次ID
	private Long dramaid;					//项目ID
	private String status;					//状态
	private Integer sortnum;				//每组抢票排序
	private String uniqueby;				//使用什么限制唯一性
	private Timestamp addtime;				//添加时间
	private Timestamp updatetime;			//更新时间
	
	@Override
	public Serializable realId() {
		return priceid;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getUniqueby() {
		return uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}
