/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

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
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import net.spy.memcached.MemcachedClient;
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

@Controller("_serverStatusController_")
public class ServerStatusController implements ApplicationContextAware, InitializingBean {
	@Autowired(required = false)
	private AttackTestService attackTestService;
	private WebApplicationContext applicationContext;
	@Autowired(required = false)
	private ZookeeperService keeperService;
	@Autowired(required = false)
	private MemcachedClient memcachedClient;

	@RequestMapping({"/server.xhtml"})
	@ResponseBody
	public String serverD(ModelMap model, HttpServletRequest request) {
		return this.server(model, request);
	}

	@RequestMapping({"/ip.xhtml"})
	@ResponseBody
	public String ip(HttpServletRequest request) {
		return BaseWebUtils.getRemoteIp(request);
	}

	@RequestMapping({"/sysmgr/server.xhtml"})
	@ResponseBody
	public String server(ModelMap model, HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		if (!GewaIpConfig.allowOffice(ip)) {
			return "invalid ip!";
		} else {
			try {
				SysSelfCheckingService e = (SysSelfCheckingService) this.applicationContext
						.getBean(SysSelfCheckingService.class);
				if (e == null) {
					return "noCheckList";
				} else {
					Map map = e.checkSysStatus();
					StringBuilder sb = new StringBuilder(100);
					Iterator arg6 = map.entrySet().iterator();

					while (true) {
						while (arg6.hasNext()) {
							Entry entry = (Entry) arg6.next();
							if (((String) entry.getKey()).equals("TASK") && !"false".equals(entry.getValue())) {
								sb.append((String) entry.getKey() + "=<span title=\'" + (String) entry.getValue()
										+ "\'>true</span><br/>");
							} else {
								sb.append((String) entry.getKey() + "=" + (String) entry.getValue() + "<br/>");
							}
						}

						return sb.toString();
					}
				}
			} catch (Exception arg8) {
				return "error" + arg8;
			}
		}
	}

	@RequestMapping({"/sysmgr/getPid.xhtml"})
	@ResponseBody
	public String getPid(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		String name = runtime.getName();

		try {
			return name.substring(0, name.indexOf(64));
		} catch (Exception arg5) {
			return "error:" + arg5;
		}
	}

	@RequestMapping({"/sysmgr/vmArgs.xhtml"})
	@ResponseBody
	public String getVmParams(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		List vmParams = ManagementFactory.getRuntimeMXBean().getInputArguments();
		return JsonUtils.writeObjectToJson(vmParams);
	}

	@RequestMapping({"/sysmgr/vmStartTime.xhtml"})
	@ResponseBody
	public String getVmStartTime() {
		return DateUtil.formatTimestamp(Long.valueOf(ManagementFactory.getRuntimeMXBean().getStartTime()));
	}

	@RequestMapping({"/sysmgr/attack.xhtml"})
	public String showAttackLogService(HttpServletRequest req, ModelMap model) {
		String ip = BaseWebUtils.getRemoteIp(req);
		GewaIpConfig.filterOfficeIp(ip);
		StringBuilder sb = new StringBuilder();
		sb.append("当前系统 : " + Config.SYSTEMID + "," + Config.getHostname());
		sb.append("@@防功击是否开启 : " + (this.attackTestService.isDisabled() ? "关闭" : "开启"));
		sb.append("@@黑名单数量: " + this.attackTestService.getBlackMap().size());
		sb.append("@@白名单数量: " + this.attackTestService.getWhiteList().size());
		sb.append("@@当前系统用于过滤的黑名单 : @@" + this.turnBlackMap(this.attackTestService.getBlackMap()));
		sb.append("@@当前系统用于过滤的白名单: @@" + this.parseWhiteList(new ArrayList(this.attackTestService.getWhiteList())));
		sb.append("@@当前系统用于过滤的黑名单2 : @@" + this.turnBlackMap(this.attackTestService.getBlackMap2()));
		return this.forwardMessage(model, sb.toString());
	}

	@RequestMapping({"/sysmgr/mcStats.xhtml"})
	@ResponseBody
	public String memcacheStats() {
		if (this.memcachedClient == null) {
			return "not install memcachedClient!";
		} else {
			Map stats = this.memcachedClient.getStats();
			LinkedHashMap result = new LinkedHashMap(stats.size());
			Set entrySet = stats.entrySet();
			Iterator arg3 = entrySet.iterator();

			while (arg3.hasNext()) {
				Entry entry = (Entry) arg3.next();
				Map value = (Map) entry.getValue();
				if (value != null) {
					result.put(((SocketAddress) entry.getKey()).toString(), value.get("pid") != null ? "OK" : "ERROR");
				} else {
					result.put(((SocketAddress) entry.getKey()).toString(), "OK");
				}
			}

			return "" + result;
		}
	}

	@RequestMapping({"/sysmgr/stopScheduler.xhtml"})
	@ResponseBody
	public String stopScheduler(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		if (!GewaIpConfig.isGewaInnerIp(ip)) {
			return "ipError";
		} else {
			try {
				Scheduler e = (Scheduler) this.applicationContext.getBean(Scheduler.class);
				if (e != null) {
					e.shutdown(true);
					return "stopSuccess";
				} else {
					return "noscheduler";
				}
			} catch (Exception arg3) {
				return "stopError:" + arg3;
			}
		}
	}

	@RequestMapping({"/sysmgr/startScheduler.xhtml"})
	@ResponseBody
	public String startScheduler(HttpServletRequest req) {
		String ip = BaseWebUtils.getRemoteIp(req);
		if (!GewaIpConfig.isGewaInnerIp(ip)) {
			return "ipError";
		} else {
			try {
				Scheduler e = (Scheduler) this.applicationContext.getBean(Scheduler.class);
				if (e != null) {
					e.start();
					return "startSuccess";
				} else {
					return "noscheduler";
				}
			} catch (Exception arg3) {
				return "startError:" + arg3;
			}
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (WebApplicationContext) applicationContext;
	}

	private String parseWhiteList(List<String> whiteList) {
		Collections.sort(whiteList);
		StringBuffer whitesb = new StringBuffer();

		for (int i = 0; i < whiteList.size(); ++i) {
			if (i % 12 == 0) {
				whitesb.append("@@");
			}

			String ip = (String) whiteList.get(i);
			whitesb.append(ip + StringUtils.rightPad("", (15 - ip.length()) * 6, " ") + " , ");
		}

		return whitesb.toString();
	}

	private String turnBlackMap(Map<String, BlackMatcher> blackMap) {
		if (blackMap != null && !blackMap.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			Iterator it = blackMap.entrySet().iterator();

			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				sb.append("ip=" + (String) entry.getKey() + ":");
				Iterator mit = ((BlackMatcher) entry.getValue()).getMatcherMap().entrySet().iterator();

				while (mit.hasNext()) {
					Entry mentry = (Entry) mit.next();
					sb.append("uri=" + (String) mentry.getKey() + ", releaseTime="
							+ DateUtil.formatTimestamp((Long) mentry.getValue()) + ";");
				}

				sb.append("@@");
			}

			return sb.toString();
		} else {
			return "";
		}
	}

	private final String forwardMessage(ModelMap model, String msg) {
		model.put("successMsgs", msg);
		return "showResult.vm";
	}

	public void afterPropertiesSet() throws Exception {
		if (this.keeperService != null) {
			TimerHelper.TIMER.schedule(new TimerTask() {
				public void run() {
					ServerStatusController.this.processServiceRegistry();
				}
			}, 30000L);
		}

	}

	private void processServiceRegistry() {
		this.registerMongo();
		this.registerScheduler();
		this.registerCamel();
	}

	private void registerMongo() {
		Class mongo = null;

		try {
			mongo = Class.forName("com.gewara.mongo.MongoService3");
		} catch (Exception arg4) {
			;
		}

		if (mongo != null) {
			try {
				Object mongoBean = this.applicationContext.getBean(mongo);
				if (mongoBean != null) {
					String path = "/server/mongo/" + Config.SYSTEMID;
					if (!this.keeperService.exist(path)) {
						this.keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
					}

					this.keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|"
							+ DateUtil.formatTimestamp(Long.valueOf(System.currentTimeMillis())));
				}
			} catch (Exception arg3) {
				;
			}
		}

	}

	private void registerScheduler() {
		try {
			Scheduler scheduler = (Scheduler) this.applicationContext.getBean(Scheduler.class);
			if (scheduler != null) {
				String path = "/server/scheduler/" + Config.SYSTEMID;
				if (!this.keeperService.exist(path)) {
					this.keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
				}

				this.keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|"
						+ DateUtil.formatTimestamp(Long.valueOf(System.currentTimeMillis())));
			}
		} catch (Exception arg2) {
			;
		}

	}

	private void registerCamel() {
		Class camel = null;

		try {
			camel = Class.forName("org.apache.camel.CamelContext");
		} catch (Exception arg4) {
			;
		}

		if (camel != null) {
			try {
				Object context = this.applicationContext.getBean("camel", camel);
				if (context != null) {
					String path = "/server/camel/" + Config.SYSTEMID;
					if (!this.keeperService.exist(path)) {
						this.keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
					}

					this.keeperService.registerNode(path + "/s", Config.getServerIp() + "|" + Config.getHostname() + "|"
							+ DateUtil.formatTimestamp(Long.valueOf(System.currentTimeMillis())));
				}
			} catch (Exception arg3) {
				;
			}
		}

	}
}