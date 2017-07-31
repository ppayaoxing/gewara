package com.gewara.msearch.external.entity;

import java.util.ArrayList;
import java.util.Collection;


public class PageQueryResult<K,V> {
	private int pageNo=1;
	private int pageSize=30;
	private int total=0;
	
	private Collection<KVObject<K,V>> datas=null;

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotal() {
		return total;
	}

	public Collection<KVObject<K, V>> getDatas() {
		if(datas==null) return new ArrayList<>(0);
		return datas;
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

	public void setDatas(Collection<KVObject<K,V>> datas) {
		this.datas = datas;
	}
	
}
