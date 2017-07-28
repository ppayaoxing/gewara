/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.CmdMessage;
import com.gewara.support.magent.CommandProcessor;
import com.gewara.support.magent.CommandProcessorGroup;
import com.gewara.util.BeanUtil;
import com.gewara.util.LoggerUtils;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MethodCommandProcessorGroup implements CommandProcessorGroup {
	private List<CommandProcessor> cmdList = new ArrayList();

	public MethodCommandProcessorGroup() {
		this.cmdList.add(new MethodCommandProcessorGroup.ExceptionCountCmd());
	}

	public String getGroupName() {
		return "method";
	}

	public List<CommandProcessor> getCommandList() {
		return this.cmdList;
	}

	private class ExceptionCountCmd implements CommandProcessor {
		private ExceptionCountCmd() {
		}

		public String getName() {
			return "excnt";
		}

		public String getGroup() {
			return MethodCommandProcessorGroup.this.getGroupName();
		}

		public String getHelp() {
			return "系统Exception的统计数量";
		}

		public String getReply(CmdMessage cmd) {
			Map count = LoggerUtils.getExceptionCountMap();
			LinkedHashMap sorted = BeanUtil.sortMapByValue(count, false);
			StringBuilder sb = new StringBuilder("Critical:" + LoggerUtils.getCriticalExceptionCount());
			sb.append(", timeFrom:" + new Timestamp(LoggerUtils.getExceptionTimefrom().longValue()));
			Iterator arg4 = sorted.entrySet().iterator();

			while (arg4.hasNext()) {
				Entry entry = (Entry) arg4.next();
				sb.append("\n" + entry.getValue() + "\t" + (String) entry.getKey());
			}

			return sb.toString();
		}
	}
}