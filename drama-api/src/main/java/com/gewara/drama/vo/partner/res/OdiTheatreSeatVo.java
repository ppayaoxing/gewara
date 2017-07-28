/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.res;

import com.gewara.drama.vo.DisQuantityVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import java.util.ArrayList;
import java.util.List;

public class OdiTheatreSeatVo extends TheatreSeatAreaVo {
	private static final long serialVersionUID = -2968993634970429727L;
	private OpenDramaItemVo odiVo;
	private List<TheatreSeatPriceVo> priceList = new ArrayList();
	private List<DisQuantityVo> disList = new ArrayList();

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

	public OpenDramaItemVo getOdiVo() {
		return this.odiVo;
	}

	public void setOdiVo(OpenDramaItemVo odiVo) {
		this.odiVo = odiVo;
	}
}