/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.req;

import com.gewara.drama.vo.req.AbstractCheckDramaRollCallReq;
import com.gewara.util.Assert;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckMultiDramaRollCallReq extends AbstractCheckDramaRollCallReq {
	private static final long serialVersionUID = 3700971175505988151L;
	private Collection<Long> dpidList = new HashSet();
	private Map<Long, Integer> buyCountMap = new HashMap();

	public Collection<Long> getDpidList() {
		return this.dpidList;
	}

	public void setDpidList(Collection<Long> dpidList) {
		Assert.notNull(dpidList);
		this.dpidList = dpidList;
	}

	public Map<Long, Integer> getBuyCountMap() {
		return this.buyCountMap;
	}

	public void setBuyCountMap(Map<Long, Integer> buyCountMap) {
		Assert.notNull(buyCountMap);
		this.buyCountMap = buyCountMap;
	}
}