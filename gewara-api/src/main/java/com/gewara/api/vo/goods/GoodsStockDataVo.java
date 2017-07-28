/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.goods;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class GoodsStockDataVo extends BaseVo {
	private static final long serialVersionUID = -5396346712368888868L;
	private Long goodsId;
	private int sellRatio;
	private int allGoodsStock;
	private int remainderGoodsStock;
	private int sellCount;

	public Serializable realId() {
		return this.goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public int getSellRatio() {
		return this.sellRatio;
	}

	public void setSellRatio(int sellRatio) {
		this.sellRatio = sellRatio;
	}

	public int getAllGoodsStock() {
		return this.allGoodsStock;
	}

	public void setAllGoodsStock(int allGoodsStock) {
		this.allGoodsStock = allGoodsStock;
	}

	public int getRemainderGoodsStock() {
		return this.remainderGoodsStock;
	}

	public void setRemainderGoodsStock(int remainderGoodsStock) {
		this.remainderGoodsStock = remainderGoodsStock;
	}

	public int getSellCount() {
		return this.sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
}