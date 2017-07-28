/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.brand;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BSGoodsStoreVo extends BaseVo {
	private static final long serialVersionUID = 8688622692815979865L;
	private Long id;
	private Long goodsid;
	private Long storeid;
	private Timestamp addtime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getStoreid() {
		return this.storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Serializable realId() {
		return this.id;
	}
}