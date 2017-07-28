/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd;

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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemSeatMapVo implements Serializable {
	private static final long serialVersionUID = 8761592214169246467L;
	private OpenDramaItemVo odi;
	private DramaPlayItemVo item;
	private TheatreFieldVo field;
	private TheatreVo theatre;
	private DramaVo drama;
	private TheatreSeatAreaVo currentArea;
	private List<SellDramaSeatVo> sellSeatList = new ArrayList();
	private List<TheatreSeatAreaVo> areaList = new ArrayList();
	private List<TheatreSeatPriceVo> priceList = new ArrayList();
	private List<DisQuantityVo> disList = new ArrayList();
	private List<OpenTheatreSeatVo> seatList = new ArrayList();
	private List<String> remoteLockList = new ArrayList();
	private String seatMap;
	private boolean connect;

	public OpenDramaItemVo getOdi() {
		return this.odi;
	}

	public void setOdi(OpenDramaItemVo odi) {
		this.odi = odi;
	}

	public DramaPlayItemVo getItem() {
		return this.item;
	}

	public void setItem(DramaPlayItemVo item) {
		this.item = item;
	}

	public TheatreFieldVo getField() {
		return this.field;
	}

	public void setField(TheatreFieldVo field) {
		this.field = field;
	}

	public List<TheatreSeatAreaVo> getAreaList() {
		return this.areaList;
	}

	public void setAreaList(List<TheatreSeatAreaVo> areaList) {
		this.areaList = areaList;
	}

	public List<TheatreSeatPriceVo> getPriceList() {
		return this.priceList;
	}

	public void setPriceList(List<TheatreSeatPriceVo> priceList) {
		this.priceList = priceList;
	}

	public List<DisQuantityVo> getDisList() {
		return this.disList;
	}

	public void setDisList(List<DisQuantityVo> disList) {
		this.disList = disList;
	}

	public List<OpenTheatreSeatVo> getSeatList() {
		return this.seatList;
	}

	public void setSeatList(List<OpenTheatreSeatVo> seatList) {
		this.seatList = seatList;
	}

	public List<String> getRemoteLockList() {
		return this.remoteLockList;
	}

	public void setRemoteLockList(List<String> remoteLockList) {
		this.remoteLockList = remoteLockList;
	}

	public TheatreVo getTheatre() {
		return this.theatre;
	}

	public void setTheatre(TheatreVo theatre) {
		this.theatre = theatre;
	}

	public DramaVo getDrama() {
		return this.drama;
	}

	public void setDrama(DramaVo drama) {
		this.drama = drama;
	}

	public String getSeatMap() {
		return this.seatMap;
	}

	public void setSeatMap(String seatMap) {
		this.seatMap = seatMap;
	}

	public boolean isConnect() {
		return this.connect;
	}

	public void setConnect(boolean connect) {
		this.connect = connect;
	}

	public List<SellDramaSeatVo> getSellSeatList() {
		return this.sellSeatList;
	}

	public void setSellSeatList(List<SellDramaSeatVo> sellSeatList) {
		this.sellSeatList = sellSeatList;
	}

	public TheatreSeatAreaVo getCurrentArea() {
		return this.currentArea;
	}

	public void setCurrentArea(TheatreSeatAreaVo currentArea) {
		this.currentArea = currentArea;
	}
}