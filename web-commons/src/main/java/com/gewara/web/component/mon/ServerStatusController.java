package com.gewara.web.component.mon;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.quartz.Scheduler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.gewara.Config;
import com.gewara.bean.BlackMatcher;
import com.gewara.untrans.AttackTestService;
import com.gewara.untrans.monitor.SysSelfCheckingService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;
import com.gewara.util.TimerHelper;

import net.spy.memcached.MemcachedClient;

@Controller("_serverStatusController_")
public class ServerStatusController implements ApplicationContextAware, InitializingBean {
	@Autowired(required = false)
	private AttackTestService attackTestService;
	private WebApplicationContext applicationContext;
	@Autowired(required = false)
	private ZookeeperService keeperService;
	@Autowired(required = false)
	private MemcachedClient memcachedClient;

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷状态
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/server.xhtml")
	@ResponseBody
	public String serverD(ModelMap model, HttpServletRequest request) {
		return server(model, request);
	}
	@RequestMapping("/ip.xhtml")
	@ResponseBody
	public String ip(HttpServletRequest request) {
		return BaseWebUtils.getRemoteIp(request);
	}
	
	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/sysmgr/server.xhtml")
	@ResponseBody
	public String server(ModelMap model, HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		if (!GewaIpConfig.allowOffice(ip)) {
			return "invalid ip!";
		}
		try {
			SysSelfCheckingService sysSelfCheckingService = this.applicationContext.getBean(SysSelfCheckingService.class);
			if (sysSelfCheckingService == null) {
				return "noCheckList";
			}
			Map<String, String> map = sysSelfCheckingService.checkSysStatus();
			StringBuilder sb = new StringBuilder(100);
			for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
				if ("TASK".equals(entry.getKey()) && !"false".equals(entry.getValue())) {
					sb.append(entry.getKey() + "=<span title='" + entry.getValue() + "'>" + "true</span><br/>");
				} else {
					sb.append(entry.getKey() + "=" + entry.getValue() + "<br/>");
				}
			}
			return sb.toString();
		} catch (Exception e) {
			return "error" + e;
		}
	}

	@RequestMapping("/sysmgr/getPid.xhtml")
	@ResponseBody
	public String getPid(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		String name = runtime.getName();
		try {
			return name.substring(0, name.indexOf('@'));
		} catch (Exception e) {
			return "error:" + e;
		}
	}

	@RequestMapping("/sysmgr/vmArgs.xhtml")
	@ResponseBody
	public String getVmParams(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		List<String> vmParams = ManagementFactory.getRuntimeMXBean().getInputArguments();
		return JsonUtils.writeObjectToJson(vmParams);
	}

	@RequestMapping("/sysmgr/vmStartTime.xhtml")
	@ResponseBody
	public String getVmStartTime() {
		return DateUtil.formatTimestamp(ManagementFactory.getRuntimeMXBean().getStartTime());
	}

	@RequestMapping("/sysmgr/attack.xhtml")
	public String showAttackLogService(HttpServletRequest req, ModelMap model) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		StringBuilder sb = new StringBuilder();
		sb.append("锟斤拷前系统 : " + Config.SYSTEMID + "," + Config.getHostname());
		sb.append("@@锟斤拷锟斤拷锟斤拷锟角凤拷锟斤拷 : " + (attackTestService.isDisabled() ? "锟截憋拷" : "锟斤拷锟斤拷"));
		sb.append("@@锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷: " + attackTestService.getBlackMap().size());
		sb.append("@@锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷: " + attackTestService.getWhiteList().size());
		sb.append("@@锟斤拷前系统锟斤拷锟节癸拷锟剿的猴拷锟斤拷锟斤拷 : @@" + turnBlackMap(attackTestService.getBlackMap()));
		sb.append("@@锟斤拷前系统锟斤拷锟节癸拷锟剿的帮拷锟斤拷锟斤拷: @@" + parseWhiteList(new ArrayList<String>(attackTestService.getWhiteList())));
		sb.append("@@锟斤拷前系统锟斤拷锟节癸拷锟剿的猴拷锟斤拷锟斤拷2 : @@" + turnBlackMap(attackTestService.getBlackMap2()));

		return forwardMessage(model, sb.toString());
	}

	@RequestMapping("/sysmgr/mcStats.xhtml")
	@ResponseBody
	public String memcacheStats() {
		if (memcachedClient == null) {
			return "not install memcachedClient!";
		}
		Map<SocketAddress, Map<String, String>> stats = memcachedClient.getStats();
		Map<String, String> result = new LinkedHashMap<String, String>(stats.size());
		Set<Map.Entry<SocketAddress, Map<String, String>>> entrySet = stats.entrySet();
		for (Map.Entry<SocketAddress, Map<String, String>> entry : entrySet) {
			Map<String, String> value = entry.getValue();
			if (value != null) {
				result.put(entry.getKey().toString(), (value.get("pid") != null ? "OK" : "ERROR"));
			} else {
				result.put(entry.getKey().toString(), "OK");
			}
		}
		return "" + result;
	}

	@RequestMapping("/sysmgr/stopScheduler.xhtml")
	@ResponseBody
	public String stopScheduler(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		if (!GewaIpConfig.isGewaInnerIp(ip)) {
			return "ipError";
		}
		try {
			Scheduler scheduler = applicationContext.getBean(Scheduler.class);
			if (scheduler != null) {
				scheduler.shutdown(true);
				return "stopSuccess";
			}
			return "noscheduler";
		} catch (Exception e) {
			return "stopError:" + e;
		}
	}

	@RequestMapping("/sysmgr/startScheduler.xhtml")
	@ResponseBody
	public String startScheduler(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		if (!GewaIpConfig.isGewaInnerIp(ip)) {
			return "ipError";
		}
		try {
			Scheduler scheduler = applicationContext.getBean(Scheduler.class);
			if (scheduler != null) {
				scheduler.start();
				return "startSuccess";
			}
			return "noscheduler";
		} catch (Exception e) {
			return "startError:" + e;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (WebApplicationContext) applicationContext;
	}

	private String parseWhiteList(List<String> whiteList) {
		Collections.sort(whiteList);
		StringBuffer whitesb = new StringBuffer();
		for (int i = 0; i < whiteList.size(); i++) {
			if (i % 12 == 0) {
                whitesb.append("@@");
            }
			String ip = whiteList.get(i);
			whitesb.append(ip + StringUtils.rightPad("", (15 - ip.length()) * 6, " ") + " , ");
		}
		return whitesb.toString();
	}

	private String turnBlackMap(Map<String, BlackMatcher> blackMap) {
		if (blackMap == null || blackMap.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<String, BlackMatcher>> it = blackMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, BlackMatcher> entry = it.next();
			sb.append("ip=" + entry.getKey() + ":");
			Iterator<Map.Entry<String, Long>> mit = entry.getValue().getMatcherMap().entrySet().iterator();
			while (mit.hasNext()) {
				Map.Entry<String, Long> mentry = mit.next();
				sb.append("uri=" + mentry.getKey() + ", releaseTime=" + DateUtil.formatTimestamp(mentry.getValue()) + ";");
			}
			sb.append("@@");
		}
		return sb.toString();
	}

	private final String forwardMessage(ModelMap model, String msg) {
		model.put("successMsgs", msg);
		return "showResult.vm";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (keeperService != null) {
			TimerHelper.TIMER.schedule(new TimerTask() {
				@Override
				public void run() {
					processServiceRegistry();
				}
			}, 30000L);
		}
	}

	private void processServiceRegistry() {
		registerMongo();
		registerScheduler();
		registerCamel();
	}

	private void registerMongo() {
		// 1锟斤拷mongo
		Class mongo = null;
		try {
			mongo = Class.forName("com.gewara.mongo.MongoService3");
		} catch (Exception e) {
		}
		if (mongo != null) {
			try {
				Object mongoBean = applicationContext.getBean(mongo);
				if (mongoBean != null) {
					String path = "/server/mongo/" + Config.SYSTEMID;
					if (!keeperService.exist(path)) {
						keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
					}
					keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|" + DateUtil.formatTimestamp(System.currentTimeMillis()));
				}
			} catch (Exception e) {
			}
		}
	}

	private void registerScheduler() {
		try {
			Scheduler scheduler = applicationContext.getBean(Scheduler.class);
			if (scheduler != null) {
				String path = "/server/scheduler/" + Config.SYSTEMID;
				if (!keeperService.exist(path)) {
					keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
				}
				keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|" + DateUtil.formatTimestamp(System.currentTimeMillis()));
			}
		} catch (Exception e) {
		}
	}

	private void registerCamel() {
		Class camel = null;
		try {
			camel = Class.forName("org.apache.camel.CamelContext");
		} catch (Exception e) {
		}
		if (camel != null) {
			try {
				Object context = applicationContext.getBean("camel", camel);
				if (context != null) {
					String path = "/server/camel/" + Config.SYSTEMID;
					if (!keeperService.exist(path)) {
						keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
					}
					keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|" + DateUtil.formatTimestamp(System.currentTimeMillis()));
				}
			} catch (Exception e) {
			}
		}

	}
}
