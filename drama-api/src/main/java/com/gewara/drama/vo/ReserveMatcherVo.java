package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class ReserveMatcherVo extends BaseVo {

	private static final long serialVersionUID = 2364212550624963422L;
	private Long id;
	private Long dramaid;
	private Date reservedate;
	private Integer version;
	private String serialnum;					//编号
	private String starttime;
	private String endtime;
	private Integer totalnum;					//可预约总数
	private Integer displaynum;				//显示数
	private Integer reservenum;				//已预约数量
	private Integer reserveofflinenum;				//线下已预约数量
	private Integer totalofflinenum;					//线下可预约总数
	private Integer handmadenum;					//线上手工预约
	private String status;						//状态
	private Timestamp addtime;
	private Timestamp updatetime;
	private String priceids;				//区域价格ID
	private String prices;
	private String itempriceids;			//场次价格ID
	private String dpids;			//场次ID
	private String priceDpids;     //场次价格ID 对应的场次ID
	
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

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Date getReservedate() {
		return reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getDisplaynum() {
		return displaynum;
	}

	public void setDisplaynum(Integer displaynum) {
		this.displaynum = displaynum;
	}

	public Integer getReservenum() {
		return reservenum;
	}

	public void setReservenum(Integer reservenum) {
		this.reservenum = reservenum;
	}

	public Integer getReserveofflinenum() {
		return reserveofflinenum;
	}

	public void setReserveofflinenum(Integer reserveofflinenum) {
		this.reserveofflinenum = reserveofflinenum;
	}

	public Integer getTotalofflinenum() {
		return totalofflinenum;
	}

	public void setTotalofflinenum(Integer totalofflinenum) {
		this.totalofflinenum = totalofflinenum;
	}

	public Integer getHandmadenum() {
		return handmadenum;
	}

	public void setHandmadenum(Integer handmadenum) {
		this.handmadenum = handmadenum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPriceids() {
		return priceids;
	}

	public void setPriceids(String priceids) {
		this.priceids = priceids;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getItempriceids() {
		return itempriceids;
	}

	public void setItempriceids(String itempriceids) {
		this.itempriceids = itempriceids;
	}

	public String getDpids() {
		return dpids;
	}

	public void setDpids(String dpids) {
		this.dpids = dpids;
	}

	public String getPriceDpids() {
		return priceDpids;
	}

	public void setPriceDpids(String priceDpids) {
		this.priceDpids = priceDpids;
	}

}
