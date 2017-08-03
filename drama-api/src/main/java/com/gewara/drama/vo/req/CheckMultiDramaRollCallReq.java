package com.gewara.drama.vo.req;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.gewara.util.Assert;

public class CheckMultiDramaRollCallReq extends AbstractCheckDramaRollCallReq {

	private static final long serialVersionUID = 3700971175505988151L;

	private Collection<Long> dpidList = new HashSet<Long>();
	private Map<Long, Integer> buyCountMap = new HashMap<Long, Integer>();

	public Collection<Long> getDpidList() {
		return dpidList;
	}

	public void setDpidList(Collection<Long> dpidList) {
		Assert.notNull(dpidList);
		this.dpidList = dpidList;
	}

	public Map<Long, Integer> getBuyCountMap() {
		return buyCountMap;
	}

	public void setBuyCountMap(Map<Long, Integer> buyCountMap) {
		Assert.notNull(buyCountMap);
		this.buyCountMap = buyCountMap;
	}

}
