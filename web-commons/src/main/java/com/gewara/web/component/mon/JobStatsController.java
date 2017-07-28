/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

import com.gewara.job.JobStatsService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("_jobstatsController_")
public class JobStatsController {
	@Autowired(required = false)
	private JobStatsService jobStatsService;

	@RequestMapping({"/sysmgr/jobstats.xhtml"})
	@ResponseBody
	public String getJobStats(HttpServletRequest request, Timestamp from, Timestamp to) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		HashMap data = new HashMap();
		if (this.jobStatsService == null) {
			data.put("success", "false");
			data.put("msg", "no jobStatsService!");
		} else if (from != null && to != null) {
			data.put("success", "true");
			data.put("data", this.jobStatsService.getJobStatsList(from, to));
		} else {
			data.put("success", "false");
			data.put("msg", "from and to not allow null!");
		}

		return JsonUtils.writeObjectToJson(data);
	}

	@RequestMapping({"/sysmgr/jobConfig.xhtml"})
	@ResponseBody
	public String getJobConfig(HttpServletRequest request) {
		return JsonUtils.writeMapToJson(this.jobStatsService.getJobConfig());
	}
}