package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ShowItemPriceVo extends BaseVo {

	private static final long serialVersionUID = 2070277567753457378L;
	private Long id;
	private String siseq;			//场次ID
	private String partner;			//第三方标识
	private String pseqno;			//第三方场次编号
	private String ticketid;		//第三方场次价格编号
	private Long dramaid;			//项目编号
	private Integer price;			//卖价
	private Integer lowest;			//最低卖价
	private String flag;				//
	private Long color;				// 颜色
	private String status;			
	private String remark;			
	
	public ShowItemPriceVo(){}
	
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

	public String getSiseq() {
		return siseq;
	}

	public void setSiseq(String siseq) {
		this.siseq = siseq;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPseqno() {
		return pseqno;
	}

	public void setPseqno(String pseqno) {
		this.pseqno = pseqno;
	}

	public String getTicketid() {
		return ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getLowest() {
		return lowest;
	}

	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getColor() {
		return color;
	}

	public void setColor(Long color) {
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
