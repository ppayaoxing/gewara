/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

import com.gewara.Config;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.GcacheNotifier;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.VmBaseUtil;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("_sysBackController_")
public class SysBackController implements InitializingBean {
	public static final String KEY_CACHE_VERSION = "cacheVersion";
	@Autowired(required = false)
	private ConfigCenter configCenter;
	@Autowired(required = false)
	@Qualifier("cacheService")
	private CacheService cacheService;
	@Autowired(required = false)
	@Qualifier("gcacheNotifier")
	private GcacheNotifier gcacheNotifier;

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public void afterPropertiesSet() throws Exception {
		if (this.configCenter != null) {
			this.configCenter.register(Config.SYSTEMID, "cacheVersion", new ConfigTrigger() {
				public void refreshCurrent(String newConfig) {
					SysBackController.this.cacheService.refreshVersion();
				}
			});
		}

	}

	@RequestMapping({"/sysmgr/cache/clearGcache.xhtml"})
	@ResponseBody
	public String clearGcache(HttpServletRequest request, String tag, String ids) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (this.gcacheNotifier != null) {
			this.gcacheNotifier.notifyClean(tag, ids);
		}

		return "success:" + Config.getServerIp();
	}

	@RequestMapping({"/sysmgr/cache/refreshCacheVersion.xhtml"})
	@ResponseBody
	public String refreshCacheVersion(HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		this.configCenter.refresh(Config.SYSTEMID, "cacheVersion");
		return "success!";
	}

	@RequestMapping({"/sysmgr/updateJsVersion.xhtml"})
	@ResponseBody
	public String updateJsVersion(HttpServletRequest request, String version) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (StringUtils.isBlank(version)) {
			version = DateUtil.format(new Date(), "yyyyMMddHH");
		}

		if (!StringUtils.isNumeric(version)) {
			return "invalid: must number!";
		} else if (StringUtils.length(version) > 16) {
			return "invalid: length must <=16!";
		} else {
			String oldVersion = VmBaseUtil.getJsVersion();
			VmBaseUtil.setJsVersion(version);
			return Config.getHostname() + ",version:" + oldVersion + "--->" + version;
		}
	}
}