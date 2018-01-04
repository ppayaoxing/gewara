package com.gewara.movie.vo.brand;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * @author zhoufy
 * @since 2015-9-15
 */
public class BSGoodsStoreVo  extends BaseVo{
	
private static final long serialVersionUID = 8688622692815979865L;
	
	private Long id;			//ID
	private Long goodsid;		//活动名称
	private Long storeid;		//活动名称
	private Timestamp addtime;	//创建时间
	
	/**构造子函数**/
	public BSGoodsStoreVo() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	@Override
	public Serializable realId() {
		return id;
	}
}

