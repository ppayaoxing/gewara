package com.gewara.web.component.mon;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.Config;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.GcacheNotifier;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.VmBaseUtil;
@Controller("_sysBackController_")
public class SysBackController  implements InitializingBean{
	public static final String KEY_CACHE_VERSION = "cacheVersion";			//缓存版本

	@Autowired(required=false)
	private ConfigCenter configCenter;
	@Autowired(required=false)@Qualifier("cacheService")
	private CacheService cacheService;
	@Autowired(required=false)@Qualifier("gcacheNotifier")
	private GcacheNotifier gcacheNotifier;
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(configCenter!=null){
			configCenter.register(Config.SYSTEMID, KEY_CACHE_VERSION, new ConfigTrigger() {
				@Override
				public void refreshCurrent(String newConfig) {
					cacheService.refreshVersion();
				}
			});
		}
	}
	/**
	 * @param request
	 * @param regions
	 * @param enable
	 * @return
	 */
	@RequestMapping("/sysmgr/cache/clearGcache.xhtml")
	@ResponseBody
	public String clearGcache(HttpServletRequest request, String tag, String ids){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(gcacheNotifier!=null){
			gcacheNotifier.notifyClean(tag, ids);
		}
		return "success:" + Config.getServerIp();
	}
	/**
	 * 刷新Memcache缓存版本
	 * @return
	 */
	@RequestMapping("/sysmgr/cache/refreshCacheVersion.xhtml")
	@ResponseBody
	public String refreshCacheVersion(HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		configCenter.refresh(Config.SYSTEMID, KEY_CACHE_VERSION);
		return "success!";
	}

	@RequestMapping("/sysmgr/updateJsVersion.xhtml")
	@ResponseBody
	public String updateJsVersion(HttpServletRequest request, String version){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(StringUtils.isBlank(version)) {
			version = DateUtil.format(new Date(), "yyyyMMddHH");
		}
		if(!StringUtils.isNumeric(version)){
			return "invalid: must number!";
		}
		if(StringUtils.length(version)>16){
			return "invalid: length must <=16!";
		}
		String oldVersion = VmBaseUtil.getJsVersion();
		VmBaseUtil.setJsVersion(version);
		return Config.getHostname()+ ",version:" + oldVersion + "--->" + version; 
	}

}
