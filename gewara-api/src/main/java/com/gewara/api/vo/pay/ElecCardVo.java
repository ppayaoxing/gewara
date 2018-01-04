package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ElecCardVo extends BaseVo {

	private static final long serialVersionUID = 3978900461424543223L;
	private Long id;
	private String cardno;			//卡号
	private String status;			//状态
	private ElecCardBatchVo ebatch;	//批次
	private Long deluserid;			//废弃人
	private Timestamp deltime;		//废弃时间
	private Long possessor;			//拥有者
	private Long gainer;			//领取者
	private String mobile;			//获取手机或绑定标志
	private Long orderid;			//使用的订单号
	private Integer version;		//
	private Timestamp begintime;
	private Timestamp endtime;
	private String remark;  //废弃备注说明
	private Double useAmount; //使用金额
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ElecCardBatchVo getEbatch() {
		return ebatch;
	}

	public void setEbatchVo(ElecCardBatchVo ebatch) {
		this.ebatch = ebatch;
	}

	public Long getDeluserid() {
		return deluserid;
	}

	public void setDeluserid(Long deluserid) {
		this.deluserid = deluserid;
	}

	public Timestamp getDeltime() {
		return deltime;
	}

	public void setDeltime(Timestamp deltime) {
		this.deltime = deltime;
	}

	public Long getPossessor() {
		return possessor;
	}

	public void setPossessor(Long possessor) {
		this.possessor = possessor;
	}

	public Long getGainer() {
		return gainer;
	}

	public void setGainer(Long gainer) {
		this.gainer = gainer;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Timestamp getBegintime() {
		return begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getUseAmount() {
		return useAmount;
	}

	public void setUseAmount(Double useAmount) {
		this.useAmount = useAmount;
	}
	
}
