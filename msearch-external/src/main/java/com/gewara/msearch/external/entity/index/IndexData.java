/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import java.io.Serializable;

public abstract class IndexData implements Serializable {
	protected String dataID = null;
	protected Long order1 = Long.valueOf(0L);
	protected Long order2 = Long.valueOf(0L);
	protected Long order3 = Long.valueOf(0L);

	public String getDataID() {
		return this.dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}

	public Long getOrder1() {
		return this.order1;
	}

	public void setOrder1(Long order1) {
		this.order1 = order1;
	}

	public Long getOrder2() {
		return this.order2;
	}

	public void setOrder2(Long order2) {
		this.order2 = order2;
	}

	public Long getOrder3() {
		return this.order3;
	}

	public void setOrder3(Long order3) {
		this.order3 = order3;
	}
}