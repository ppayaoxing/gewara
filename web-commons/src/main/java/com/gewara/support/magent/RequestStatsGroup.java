/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.AbstractCommandProcessor;
import com.gewara.support.magent.CmdMessage;
import com.gewara.support.magent.CommandProcessor;
import com.gewara.support.magent.CommandProcessorGroup;
import com.gewara.util.ServiceCacheHelper;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;

public class RequestStatsGroup implements CommandProcessorGroup {
	public List<CommandProcessor> getCommandList() {
		ArrayList commandList = new ArrayList();
		commandList.add(new RequestStatsGroup.InnerCommand("aurl", "[minreq=10]：显示项目所有的URL处理请求数"));
		commandList.add(new RequestStatsGroup.InnerCommand("burl", "显示不存在网址访问数"));
		commandList.add(new RequestStatsGroup.InnerCommand("unused", "上次启动至现在从末访问过的url"));
		commandList.add(new RequestStatsGroup.InnerCommand("req", "未处理完的请求"));
		commandList.add(new RequestStatsGroup.InnerCommand("dreq", "[max=100]：下载当前未完成请求参数"));
		commandList.add(new RequestStatsGroup.InnerCommand("call", "正在运行的方法（jms、job）"));
		commandList.add(new RequestStatsGroup.InnerCommand("jms", "JMS发送消息统计"));
		commandList.add(new RequestStatsGroup.InnerCommand("pc", "PageCache页面缓存"));
		commandList.add(new RequestStatsGroup.InnerCommand("sc", "ServiceCache缓存"));
		commandList.add(new RequestStatsGroup.InnerCommand("api", "正在处理的dubbo调用"));
		return commandList;
	}

	private String getApi() {
		List result = ResourceStatsUtil.getApiMethodStats().getProcessingList(0);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder reply = (new StringBuilder("\n"))
					.append(StringUtils.join(((Map) result.get(0)).keySet(), "\t")).append("\n");
			Iterator arg2 = result.iterator();

			while (arg2.hasNext()) {
				Map row = (Map) arg2.next();
				reply.append(StringUtils.join(row.values(), "\t")).append("\n");
			}

			return reply.toString();
		}
	}

	private String getReqParams(int maxcount) {
		List result = ResourceStatsUtil.dumpRequest(maxcount);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder sb = new StringBuilder("\n");
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Map row = (Map) arg3.next();
				Iterator arg5 = row.keySet().iterator();

				while (arg5.hasNext()) {
					Object key = arg5.next();
					sb.append(key).append(":").append(row.get(key)).append("\n");
				}

				sb.append("---------------------------------------------------\n");
			}

			return sb.toString();
		}
	}

	private String getReq(int waitmill) {
		List result = ResourceStatsUtil.getUriStats().getProcessingList(waitmill);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder reply = (new StringBuilder("\n"))
					.append(StringUtils.join(((Map) result.get(0)).keySet(), "\t")).append("\n");
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Map row = (Map) arg3.next();
				reply.append(StringUtils.join(row.values(), "\t")).append("\n");
			}

			return reply.toString();
		}
	}

	private String getCall(int waitmill) {
		List result = ResourceStatsUtil.getCallStats().getProcessingList(waitmill);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder reply = (new StringBuilder("\n"))
					.append(StringUtils.join(((Map) result.get(0)).keySet(), "\t")).append("\n");
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Map row = (Map) arg3.next();
				reply.append(StringUtils.join(row.values(), "\t")).append("\n");
			}

			return reply.toString();
		}
	}

	private String getJms(int waitmill) {
		List result = ResourceStatsUtil.getJmsStats().getProcessingList(waitmill);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder reply = (new StringBuilder("\n"))
					.append(StringUtils.join(((Map) result.get(0)).keySet(), "\t")).append("\n");
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Map row = (Map) arg3.next();
				reply.append(StringUtils.join(row.values(), "\t")).append("\n");
			}

			return reply.toString();
		}
	}

	private String getPageCache() {
		TreeMap result = new TreeMap(ResourceStatsUtil.getPageCacheStats().getStatsMap());
		return "" + result;
	}

	private String getServiceCache() {
		List schList = ResourceStatsUtil.getServiceCacheHelperList();
		String result = "";
		Iterator arg2 = schList.iterator();

		while (arg2.hasNext()) {
			ServiceCacheHelper sch = (ServiceCacheHelper) arg2.next();
			Map data = sch.getStats();
			if (data != null) {
				result = result + data + "\n";
			}
		}

		return result;
	}

	private String getUnused() {
		TreeSet unused = new TreeSet(ResourceStatsUtil.getUriStats().getUnusedList());
		if (unused.isEmpty()) {
			return "!!nodata!!";
		} else {
			String result = StringUtils.join(unused, "\n");
			return result;
		}
	}

	private String getAllUrl(int mincount) {
		List result = ResourceStatsUtil.getUriStats().getCountList(mincount, true);
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder sb = new StringBuilder("\n");
			sb.append(StringUtils.join(((Map) result.get(0)).keySet(), "\t")).append("\n");
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Map row = (Map) arg3.next();
				sb.append(StringUtils.join(row.values(), "\t")).append("\n");
			}

			return sb.toString();
		}
	}

	private String getBadUrl() {
		Map result = ResourceStatsUtil.getBadUrlStats().getStatsMap();
		if (result.isEmpty()) {
			return "!!nodata!!";
		} else {
			StringBuilder sb = new StringBuilder("\n");
			Iterator arg2 = result.keySet().iterator();

			while (arg2.hasNext()) {
				String key = (String) arg2.next();
				sb.append(StringUtils.rightPad(key, 80)).append("\t").append(result.get(key)).append("\n");
			}

			return sb.toString();
		}
	}

	public String getGroupName() {
		return "reqcmd";
	}

	private class InnerCommand extends AbstractCommandProcessor {
		public InnerCommand(String name, String help) {
			this.group = RequestStatsGroup.this.getGroupName();
			this.name = name;
			this.help = help;
		}

		public String getReply(CmdMessage cmdMsg) {
			String reply = "";
			int waitmill;
			if (StringUtils.equalsIgnoreCase("req", cmdMsg.getCmd())) {
				waitmill = 0;
				if (StringUtils.isNotBlank(cmdMsg.getParams())) {
					waitmill = Integer.parseInt(cmdMsg.getParams());
				}

				return RequestStatsGroup.this.getReq(waitmill);
			} else {
				if (StringUtils.equalsIgnoreCase("aurl", cmdMsg.getCmd())) {
					waitmill = 10;
					if (StringUtils.isNotBlank(cmdMsg.getParams())) {
						waitmill = Integer.parseInt(cmdMsg.getParams());
					}

					reply = RequestStatsGroup.this.getAllUrl(waitmill);
				} else if (StringUtils.equalsIgnoreCase("dreq", cmdMsg.getCmd())) {
					waitmill = 100;
					if (StringUtils.isNotBlank(cmdMsg.getParams())) {
						waitmill = Integer.parseInt(cmdMsg.getParams());
					}

					reply = RequestStatsGroup.this.getReqParams(waitmill);
				} else if (StringUtils.equalsIgnoreCase("burl", cmdMsg.getCmd())) {
					reply = RequestStatsGroup.this.getBadUrl();
				} else if (StringUtils.equalsIgnoreCase("unused", cmdMsg.getCmd())) {
					reply = RequestStatsGroup.this.getUnused();
				} else if (StringUtils.equalsIgnoreCase("call", cmdMsg.getCmd())) {
					waitmill = 0;
					if (StringUtils.isNotBlank(cmdMsg.getParams())) {
						waitmill = Integer.parseInt(cmdMsg.getParams());
					}

					reply = RequestStatsGroup.this.getCall(waitmill);
				} else if (StringUtils.equalsIgnoreCase("jms", cmdMsg.getCmd())) {
					waitmill = 0;
					if (StringUtils.isNotBlank(cmdMsg.getParams())) {
						waitmill = Integer.parseInt(cmdMsg.getParams());
					}

					reply = RequestStatsGroup.this.getJms(waitmill);
				} else if (StringUtils.equalsIgnoreCase("pc", cmdMsg.getCmd())) {
					reply = RequestStatsGroup.this.getPageCache();
				} else if (StringUtils.equalsIgnoreCase("sc", cmdMsg.getCmd())) {
					reply = RequestStatsGroup.this.getServiceCache();
				} else if (StringUtils.equalsIgnoreCase("api", cmdMsg.getCmd())) {
					reply = RequestStatsGroup.this.getApi();
				}

				return reply;
			}
		}
	}
}