package com.gewara.web.context.request.async;

import com.gewara.web.support.DynamicStats.LogCounter;
import com.gewara.web.support.ResourceStatsUtil;

public class ResourceStatsContainer {
	public static String RESOURCE_STATS = "ResourceStatsContainer.RESOURCE_STATS";
	private LogCounter counter;
	private long lastTime;
	private Integer locIndex;
	private boolean processed = false;
	public ResourceStatsContainer(LogCounter counter, long lastTime, Integer locIndex){
		this.counter = counter;
		this.lastTime = lastTime;
		this.locIndex = locIndex;
	}
	
	public void processStats(){
		if(!processed){
			processed = true;
			ResourceStatsUtil.getUriStats().afterProcess(counter, lastTime, false);
			ResourceStatsUtil.clearRequest(locIndex);
		}
	}
}
