package com.gewara.api.vo.goods;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class GoodsStockDataVo extends BaseVo {
	private static final long serialVersionUID = -5396346712368888868L;
	
	private Long goodsId;					//物品ID
	private int sellRatio;					//物品-已售比率  
	private int allGoodsStock;				//物品-总库存 (这里的库存有可能是虚拟的数据)
	private int remainderGoodsStock;		//物品-剩余库存
	private int sellCount; 					//已售多少
	
	public GoodsStockDataVo(){}

	@Override
	public Serializable realId() {
		return goodsId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public int getSellRatio() {
		return sellRatio;
	}

	public void setSellRatio(int sellRatio) {
		this.sellRatio = sellRatio;
	}

	public int getAllGoodsStock() {
		return allGoodsStock;
	}

	public void setAllGoodsStock(int allGoodsStock) {
		this.allGoodsStock = allGoodsStock;
	}

	public int getRemainderGoodsStock() {
		return remainderGoodsStock;
	}

	public void setRemainderGoodsStock(int remainderGoodsStock) {
		this.remainderGoodsStock = remainderGoodsStock;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	
}
