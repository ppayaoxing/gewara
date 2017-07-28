/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.context.request.async;

import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.DynamicStats.LogCounter;

public class ResourceStatsContainer {
	public static String RESOURCE_STATS = "ResourceStatsContainer.RESOURCE_STATS";
	private LogCounter counter;
	private long lastTime;
	private Integer locIndex;
	private boolean processed = false;

	public ResourceStatsContainer(LogCounter counter, long lastTime, Integer locIndex) {
		this.counter = counter;
		this.lastTime = lastTime;
		this.locIndex = locIndex;
	}

	public void processStats() {
		if (!this.processed) {
			this.processed = true;
			ResourceStatsUtil.getUriStats().afterProcess(this.counter, this.lastTime, false);
			ResourceStatsUtil.clearRequest(this.locIndex);
		}

	}
}