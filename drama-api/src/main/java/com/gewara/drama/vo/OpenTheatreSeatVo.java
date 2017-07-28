/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class OpenTheatreSeatVo extends BaseVo {
	private static final long serialVersionUID = 7302103820051859243L;
	private Long id;
	private Long odiid;
	private Long dpid;
	private Long areaid;
	private Integer price;
	private Integer theatreprice;
	private Integer costprice;
	private String status;
	private String remark;
	private Integer lineno;
	private Integer rankno;
	private String seatline;
	private String seatrank;
	private String seattype;
	private String loveInd;
	private Long tipid;
	private Long tspid;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOdiid() {
		return this.odiid;
	}

	public void setOdiid(Long odiid) {
		this.odiid = odiid;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTheatreprice() {
		return this.theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getLineno() {
		return this.lineno;
	}

	public void setLineno(Integer lineno) {
		this.lineno = lineno;
	}

	public Integer getRankno() {
		return this.rankno;
	}

	public void setRankno(Integer rankno) {
		this.rankno = rankno;
	}

	public String getSeatline() {
		return this.seatline;
	}

	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}

	public String getSeatrank() {
		return this.seatrank;
	}

	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}

	public String getSeattype() {
		return this.seattype;
	}

	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}

	public String getLoveInd() {
		return this.loveInd;
	}

	public void setLoveInd(String loveInd) {
		this.loveInd = loveInd;
	}

	public String getPosition() {
		return this.lineno + ":" + this.rankno;
	}

	public String getSeatLabel() {
		return this.seatline + "ÅÅ" + this.seatrank + "×ù";
	}

	public String getKey() {
		return this.seatline + ":" + this.seatrank;
	}

	public Long getTipid() {
		return this.tipid;
	}

	public void setTipid(Long tipid) {
		this.tipid = tipid;
	}

	public Long getTspid() {
		return this.tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public boolean isAvailable() {
		return StringUtils.equals(this.status, "A");
	}
}