/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigData;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.untrans.monitor.ConfigWatcher;
import com.gewara.untrans.monitor.ZookeeperService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigCenterImpl implements ConfigCenter {
	private static final String GLOBAL = "global";
	private Map<String, ConfigTrigger> triggerMap = new ConcurrentHashMap();
	private Map<String, Integer> partitionMap = new ConcurrentHashMap();
	private Set<String> delayList = new HashSet();
	@Autowired
	private ZookeeperService keeperService;

	public void register(String systemid, String tag, ConfigTrigger trigger) {
		String path = this.createPath(systemid, tag);
		this.triggerMap.put(systemid + "," + tag, trigger);
		this.keeperService.addMonitor(new ConfigWatcher(path, trigger));
		this.processDelay();
	}

	public void registerGlobal(String tag, ConfigTrigger trigger) {
		this.register("global", tag, trigger);
	}

	public void register(String systemid, String tag, ConfigTrigger trigger, int partition) {
		this.register(systemid, tag, trigger);
		partition = Math.min(128, partition);
		if (partition > 0) {
			List partList = this.createPartitionPath(systemid, tag, partition);
			String key = systemid + "," + tag;
			this.partitionMap.put(key, Integer.valueOf(partition));
			Iterator arg6 = partList.iterator();

			while (arg6.hasNext()) {
				String part = (String) arg6.next();
				this.keeperService.addMonitor(new ConfigWatcher(part, trigger));
			}
		}

	}

	public void registerGlobal(String tag, ConfigTrigger trigger, int partition) {
		this.register("global", tag, trigger, partition);
	}

	public void refresh(String systemid, String tag) {
		this.refresh(systemid, tag, "" + new Timestamp(System.currentTimeMillis()));
	}

	public void refresh(String systemid, String tag, String data) {
		String path = "/config/" + systemid + "/" + tag;
		String key = systemid + "," + tag;
		Integer partcount = (Integer) this.partitionMap.get(key);
		if (partcount != null) {
			int curpart = RandomUtils.nextInt(partcount.intValue());
			path = path + "/part" + curpart;
		}

		if (!this.keeperService.exist(path)) {
			this.keeperService.addPresistentNode(path, data);
		} else {
			this.keeperService.updateNode(path, data);
		}

	}

	private void processDelay() {
		if (!this.delayList.isEmpty()) {
			Iterator it = this.delayList.iterator();

			while (it.hasNext()) {
				String s = (String) it.next();
				if (this.triggerMap.containsKey(s)) {
					it.remove();
					int idx = s.indexOf(44);
					String systemid = s.substring(0, idx);
					String tag = s.substring(idx + 1);
					this.reloadCurrent(systemid, tag);
				}
			}
		}

	}

	private String createPath(String systemid, String tag) {
		String path = "/config/" + systemid;
		if (!this.keeperService.exist(path)) {
			this.keeperService.addPresistentNode(path, "config trigger for " + systemid);
		}

		String[] dirs = StringUtils.split(tag, "/");
		String[] arg4 = dirs;
		int arg5 = dirs.length;

		for (int arg6 = 0; arg6 < arg5; ++arg6) {
			String dir = arg4[arg6];
			path = path + "/" + dir;
			if (!this.keeperService.exist(path)) {
				this.keeperService.addPresistentNode(path, "" + new Timestamp(System.currentTimeMillis()));
			}
		}

		return path;
	}

	private List<String> createPartitionPath(String systemid, String tag, int partition) {
		ArrayList result = new ArrayList();
		String path = "/config/" + systemid;
		if (!this.keeperService.exist(path)) {
			this.keeperService.addPresistentNode(path, "config trigger for " + systemid);
		}

		String[] dirs = StringUtils.split(tag, "/");
		String[] i = dirs;
		int part = dirs.length;

		for (int arg8 = 0; arg8 < part; ++arg8) {
			String dir = i[arg8];
			path = path + "/" + dir;
			if (!this.keeperService.exist(path)) {
				this.keeperService.addPresistentNode(path, "" + new Timestamp(System.currentTimeMillis()));
			}
		}

		for (int arg10 = 0; arg10 < partition; ++arg10) {
			String arg11 = path + "/part" + arg10;
			if (!this.keeperService.exist(arg11)) {
				this.keeperService.addPresistentNode(arg11, "");
			}

			result.add(arg11);
		}

		return result;
	}

	public void reloadCurrent(String systemid, String tag) {
		String key = systemid + "," + tag;
		if (!this.triggerMap.containsKey(key)) {
			this.delayList.add(systemid + "," + tag);
		} else {
			String path = this.createPath(systemid, tag);
			String data = this.keeperService.getNodeData(path);
			((ConfigTrigger) this.triggerMap.get(systemid + "," + tag)).refreshCurrent(data);
		}

	}

	public void refreshGlobal(String tag) {
		this.refresh("global", tag);
	}

	public void refreshGlobal(String tag, String data) {
		this.refresh("global", tag, data);
	}

	public void reloadGlobal(String tag) {
		this.reloadCurrent("global", tag);
	}

	public ConfigData getConfigData(String systemid, String tag) {
		ConfigTrigger cfg = (ConfigTrigger) this.triggerMap.get(systemid + "," + tag);
		return cfg instanceof ConfigData ? (ConfigData) cfg : null;
	}

	public void setKeeperService(ZookeeperService keeperService) {
		this.keeperService = keeperService;
	}
}