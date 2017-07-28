/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ReserveMatcherVo extends BaseVo {
	private static final long serialVersionUID = 2364212550624963422L;
	private Long id;
	private Long dramaid;
	private Date reservedate;
	private Integer version;
	private String serialnum;
	private String starttime;
	private String endtime;
	private Integer totalnum;
	private Integer displaynum;
	private Integer reservenum;
	private Integer reserveofflinenum;
	private Integer totalofflinenum;
	private Integer handmadenum;
	private String status;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String priceids;
	private String prices;
	private String itempriceids;
	private String dpids;
	private String priceDpids;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Date getReservedate() {
		return this.reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSerialnum() {
		return this.serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getTotalnum() {
		return this.totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getDisplaynum() {
		return this.displaynum;
	}

	public void setDisplaynum(Integer displaynum) {
		this.displaynum = displaynum;
	}

	public Integer getReservenum() {
		return this.reservenum;
	}

	public void setReservenum(Integer reservenum) {
		this.reservenum = reservenum;
	}

	public Integer getReserveofflinenum() {
		return this.reserveofflinenum;
	}

	public void setReserveofflinenum(Integer reserveofflinenum) {
		this.reserveofflinenum = reserveofflinenum;
	}

	public Integer getTotalofflinenum() {
		return this.totalofflinenum;
	}

	public void setTotalofflinenum(Integer totalofflinenum) {
		this.totalofflinenum = totalofflinenum;
	}

	public Integer getHandmadenum() {
		return this.handmadenum;
	}

	public void setHandmadenum(Integer handmadenum) {
		this.handmadenum = handmadenum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPriceids() {
		return this.priceids;
	}

	public void setPriceids(String priceids) {
		this.priceids = priceids;
	}

	public String getPrices() {
		return this.prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getItempriceids() {
		return this.itempriceids;
	}

	public void setItempriceids(String itempriceids) {
		this.itempriceids = itempriceids;
	}

	public String getDpids() {
		return this.dpids;
	}

	public void setDpids(String dpids) {
		this.dpids = dpids;
	}

	public String getPriceDpids() {
		return this.priceDpids;
	}

	public void setPriceDpids(String priceDpids) {
		this.priceDpids = priceDpids;
	}
}