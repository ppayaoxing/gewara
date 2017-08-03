package com.gewara.drama.vo.partner.res;

import java.util.ArrayList;
import java.util.List;

import com.gewara.drama.vo.DisQuantityVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;

public class OdiTheatreSeatVo extends TheatreSeatAreaVo {

	private static final long serialVersionUID = -2968993634970429727L;
	private OpenDramaItemVo odiVo;
	private List<TheatreSeatPriceVo> priceList = new ArrayList<TheatreSeatPriceVo>();
	private List<DisQuantityVo> disList = new ArrayList<DisQuantityVo>();
	
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

	public OpenDramaItemVo getOdiVo() {
		return odiVo;
	}

	public void setOdiVo(OpenDramaItemVo odiVo) {
		this.odiVo = odiVo;
	}
	
	
	
}
