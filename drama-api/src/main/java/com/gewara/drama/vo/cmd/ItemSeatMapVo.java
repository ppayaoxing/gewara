package com.gewara.drama.vo.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gewara.drama.vo.DisQuantityVo;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.OpenTheatreSeatVo;
import com.gewara.drama.vo.SellDramaSeatVo;
import com.gewara.drama.vo.TheatreFieldVo;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import com.gewara.drama.vo.TheatreVo;

public class ItemSeatMapVo implements Serializable {

	private static final long serialVersionUID = 8761592214169246467L;
	private OpenDramaItemVo odi;
	private DramaPlayItemVo item;
	private TheatreFieldVo field;
	private TheatreVo theatre;
	private DramaVo drama;
	private TheatreSeatAreaVo currentArea;
	private List<SellDramaSeatVo> sellSeatList = new ArrayList<SellDramaSeatVo>();
	private List<TheatreSeatAreaVo> areaList = new ArrayList<TheatreSeatAreaVo>();
	private List<TheatreSeatPriceVo> priceList = new ArrayList<TheatreSeatPriceVo>();
	private List<DisQuantityVo> disList = new ArrayList<DisQuantityVo>();
	private List<OpenTheatreSeatVo> seatList = new ArrayList<OpenTheatreSeatVo>();
	private List<String> remoteLockList = new ArrayList<String>();
	private String seatMap; 
	private boolean connect;
	
	public OpenDramaItemVo getOdi() {
		return odi;
	}
	public void setOdi(OpenDramaItemVo odi) {
		this.odi = odi;
	}
	public DramaPlayItemVo getItem() {
		return item;
	}
	public void setItem(DramaPlayItemVo item) {
		this.item = item;
	}
	public TheatreFieldVo getField() {
		return field;
	}
	public void setField(TheatreFieldVo field) {
		this.field = field;
	}
	public List<TheatreSeatAreaVo> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<TheatreSeatAreaVo> areaList) {
		this.areaList = areaList;
	}
	public List<TheatreSeatPriceVo> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<TheatreSeatPriceVo> priceList) {
		this.priceList = priceList;
	}
	public List<DisQuantityVo> getDisList() {
		return disList;
	}
	public void setDisList(List<DisQuantityVo> disList) {
		this.disList = disList;
	}
	public List<OpenTheatreSeatVo> getSeatList() {
		return seatList;
	}
	public void setSeatList(List<OpenTheatreSeatVo> seatList) {
		this.seatList = seatList;
	}
	public List<String> getRemoteLockList() {
		return remoteLockList;
	}
	public void setRemoteLockList(List<String> remoteLockList) {
		this.remoteLockList = remoteLockList;
	}
	public TheatreVo getTheatre() {
		return theatre;
	}
	public void setTheatre(TheatreVo theatre) {
		this.theatre = theatre;
	}
	public DramaVo getDrama() {
		return drama;
	}
	public void setDrama(DramaVo drama) {
		this.drama = drama;
	}
	public String getSeatMap() {
		return seatMap;
	}
	public void setSeatMap(String seatMap) {
		this.seatMap = seatMap;
	}
	public boolean isConnect() {
		return connect;
	}
	public void setConnect(boolean connect) {
		this.connect = connect;
	}
	public List<SellDramaSeatVo> getSellSeatList() {
		return sellSeatList;
	}
	public void setSellSeatList(List<SellDramaSeatVo> sellSeatList) {
		this.sellSeatList = sellSeatList;
	}
	public TheatreSeatAreaVo getCurrentArea() {
		return currentArea;
	}
	public void setCurrentArea(TheatreSeatAreaVo currentArea) {
		this.currentArea = currentArea;
	}

}
