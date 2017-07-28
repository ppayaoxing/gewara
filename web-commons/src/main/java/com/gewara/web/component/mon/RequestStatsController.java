/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("_reqstatsController_")
public class RequestStatsController {
	@RequestMapping({"/sysmgr/longReqCount.xhtml"})
	@ResponseBody
	public String getLongReqCount(HttpServletRequest request, Integer seconds, Integer maxprocess, String type) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (seconds == null) {
			seconds = Integer.valueOf(125);
		}

		if (maxprocess == null) {
			maxprocess = Integer.valueOf(30);
		}

		List rowList = null;
		if (StringUtils.equals("api", type)) {
			rowList = ResourceStatsUtil.getApiMethodStats().getProcessingList(seconds.intValue() * 1000);
		} else {
			rowList = ResourceStatsUtil.getUriStats().getProcessingList(seconds.intValue() * 1000);
		}

		if (rowList.size() > 5) {
			Iterator arg6 = rowList.iterator();

			while (arg6.hasNext()) {
				Map row = (Map) arg6.next();
				if (StringUtils.equals("" + row.get("url"), "total")) {
					int processing = Integer.valueOf("" + row.get("processing")).intValue();
					int avgwait = Integer.valueOf("" + row.get("avgwait")).intValue();
					if (avgwait * processing > seconds.intValue() * maxprocess.intValue()) {
						return processing + "," + avgwait;
					}
				}
			}
		}

		return "ok";
	}

	@RequestMapping({"/sysmgr/request.xhtml"})
	@ResponseBody
	public String getCurrRequest(HttpServletRequest request, String type, Integer seconds) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (seconds == null) {
			seconds = Integer.valueOf(125);
		}

		List rowList = null;
		if (StringUtils.equals("api", type)) {
			rowList = ResourceStatsUtil.getApiMethodStats().getProcessingList(seconds.intValue() * 1000);
		} else {
			rowList = ResourceStatsUtil.getUriStats().getProcessingList(seconds.intValue() * 1000);
		}

		return JsonUtils.writeObjectToJson(rowList);
	}

	@RequestMapping({"/sysmgr/requestMapping.xhtml"})
	@ResponseBody
	public String requestMapping(HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		Set rowList = ResourceStatsUtil.getUriStats().getAllResources();
		return JsonUtils.writeObjectToJson(rowList);
	}
}