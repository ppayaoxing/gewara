/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.order;

import com.gewara.api.vo.goods.GoodsVo;
import java.io.Serializable;

public class CheckAddOrderGoodsGiftRes implements Serializable {
	private static final long serialVersionUID = -1237001182538322948L;
	private Integer quantity;
	private boolean isGiftExist;
	private GoodsVo goods;

	public CheckAddOrderGoodsGiftRes() {
	}

	public CheckAddOrderGoodsGiftRes(Integer quantity, boolean isGiftExist, GoodsVo goods) {
		this.quantity = quantity;
		this.isGiftExist = isGiftExist;
		this.goods = goods;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public GoodsVo getGoods() {
		return this.goods;
	}

	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}

	public boolean isGiftExist() {
		return this.isGiftExist;
	}

	public void setGiftExist(boolean isGiftExist) {
		this.isGiftExist = isGiftExist;
	}
}