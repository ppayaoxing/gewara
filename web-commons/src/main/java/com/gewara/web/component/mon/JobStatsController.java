package com.gewara.web.component.mon;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.job.JobStatsService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;

@Controller("_jobstatsController_")
public class JobStatsController {
	@Autowired(required=false)
	private JobStatsService jobStatsService;
	@RequestMapping("/sysmgr/jobstats.xhtml")
	@ResponseBody
	public String getJobStats(HttpServletRequest request, Timestamp from, Timestamp to){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		Map data = new HashMap();
		if(jobStatsService==null){
			data.put("success", "false");
			data.put("msg", "no jobStatsService!");
		}else if(from==null ||to==null){
			data.put("success", "false");
			data.put("msg", "from and to not allow null!");
		}else{
			data.put("success", "true");
			data.put("data", jobStatsService.getJobStatsList(from, to));
		}
		return JsonUtils.writeObjectToJson(data);
	}
	@RequestMapping("/sysmgr/jobConfig.xhtml")
	@ResponseBody
	public String getJobConfig(HttpServletRequest request){
		return JsonUtils.writeMapToJson(jobStatsService.getJobConfig());
	}
}
