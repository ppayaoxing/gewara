/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

import com.gewara.msearch.external.entity.KVObject;
import java.util.ArrayList;
import java.util.Collection;

public class PageQueryResult<K, V> {
	private int pageNo = 1;
	private int pageSize = 30;
	private int total = 0;
	private Collection<KVObject<K, V>> datas = null;

	public int getPageNo() {
		return this.pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getTotal() {
		return this.total;
	}

	public Collection<KVObject<K, V>> getDatas() {
		return (Collection) (this.datas == null ? new ArrayList(0) : this.datas);
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setDatas(Collection<KVObject<K, V>> datas) {
		this.datas = datas;
	}
}