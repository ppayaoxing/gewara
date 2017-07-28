/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.pay.ElecCardBatchVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ElecCardVo extends BaseVo {
	private static final long serialVersionUID = 3978900461424543223L;
	private Long id;
	private String cardno;
	private String status;
	private ElecCardBatchVo ebatch;
	private Long deluserid;
	private Timestamp deltime;
	private Long possessor;
	private Long gainer;
	private String mobile;
	private Long orderid;
	private Integer version;
	private Timestamp begintime;
	private Timestamp endtime;
	private String remark;
	private Double useAmount;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ElecCardBatchVo getEbatch() {
		return this.ebatch;
	}

	public void setEbatchVo(ElecCardBatchVo ebatch) {
		this.ebatch = ebatch;
	}

	public Long getDeluserid() {
		return this.deluserid;
	}

	public void setDeluserid(Long deluserid) {
		this.deluserid = deluserid;
	}

	public Timestamp getDeltime() {
		return this.deltime;
	}

	public void setDeltime(Timestamp deltime) {
		this.deltime = deltime;
	}

	public Long getPossessor() {
		return this.possessor;
	}

	public void setPossessor(Long possessor) {
		this.possessor = possessor;
	}

	public Long getGainer() {
		return this.gainer;
	}

	public void setGainer(Long gainer) {
		this.gainer = gainer;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Timestamp getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getUseAmount() {
		return this.useAmount;
	}

	public void setUseAmount(Double useAmount) {
		this.useAmount = useAmount;
	}
}