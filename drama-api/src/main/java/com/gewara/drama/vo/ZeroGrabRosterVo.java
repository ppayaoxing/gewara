package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ZeroGrabRosterVo extends BaseVo {

	private static final long serialVersionUID = 7936714131545652514L;
	private Long id;
	private Integer version;
	private Long dramaid;						//项目编号
	private Long dpid;							//场次ID
	private Long priceid;						//价格ID
	private Long memberid;						//用户Id
	private String mobile;						//手机号
	private Long partnerid;						//合作商ID
	private String membername;					//用户昵称
	private Integer quantity;					//数量
	private Timestamp addtime;					//抢票时间
	private Timestamp updatetime;				//更新时间
	private String processLevel;				//后期处理进程
	private String rosterinfo;					//其它信息｛"":""｝
	private String origin;						//来源
	private String ip;							//抢票Ip
	private String tradeno;						//订单号
	
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String getProcessLevel() {
		return processLevel;
	}

	public void setProcessLevel(String processLevel) {
		this.processLevel = processLevel;
	}

	public String getRosterinfo() {
		return rosterinfo;
	}

	public void setRosterinfo(String rosterinfo) {
		this.rosterinfo = rosterinfo;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

}
