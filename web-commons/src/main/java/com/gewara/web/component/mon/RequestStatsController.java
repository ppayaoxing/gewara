package com.gewara.web.component.mon;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;
import com.gewara.web.support.ResourceStatsUtil;

@Controller("_reqstatsController_")
public class RequestStatsController {
	@RequestMapping("/sysmgr/longReqCount.xhtml")
	@ResponseBody
	public String getLongReqCount(HttpServletRequest request, Integer seconds, Integer maxprocess, String type){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(seconds==null){
			seconds = 125;
		}
		if(maxprocess==null){
			maxprocess = 30;
		}
		//Map(url,avgwait,processing,processed)
		List<Map> rowList = null;
		if(StringUtils.equals("api", type)){
			rowList = ResourceStatsUtil.getApiMethodStats().getProcessingList(seconds*1000);
		}else{
			rowList = ResourceStatsUtil.getUriStats().getProcessingList(seconds*1000);
		}
		if(rowList.size()>5){
			for(Map row: rowList){
				if(StringUtils.equals(""+row.get("url"),"total")){
					int processing = Integer.valueOf("" +row.get("processing"));
					int avgwait =  Integer.valueOf("" + row.get("avgwait"));
					if(avgwait * processing > seconds*maxprocess){
						return processing + "," + avgwait; 
					}
				}
			}
		}
		return "ok";
	}
	@RequestMapping("/sysmgr/request.xhtml")
	@ResponseBody
	public String getCurrRequest(HttpServletRequest request, String type, Integer seconds){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(seconds==null){
			seconds = 125;
		}
		List<Map> rowList = null;
		if(StringUtils.equals("api", type)){
			rowList = ResourceStatsUtil.getApiMethodStats().getProcessingList(seconds*1000);
		}else{
			rowList = ResourceStatsUtil.getUriStats().getProcessingList(seconds*1000);
		}
		return JsonUtils.writeObjectToJson(rowList);
	}
	@RequestMapping("/sysmgr/requestMapping.xhtml")
	@ResponseBody
	public String requestMapping(HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		Set<String> rowList = ResourceStatsUtil.getUriStats().getAllResources();
		return JsonUtils.writeObjectToJson(rowList);
	}

}
