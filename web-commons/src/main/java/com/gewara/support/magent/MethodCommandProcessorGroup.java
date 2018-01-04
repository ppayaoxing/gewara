package com.gewara.support.magent;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gewara.util.BeanUtil;
import com.gewara.util.LoggerUtils;

public class MethodCommandProcessorGroup implements CommandProcessorGroup{
	private List<CommandProcessor> cmdList = new ArrayList<CommandProcessor>();
	public MethodCommandProcessorGroup(){
		cmdList.add(new ExceptionCountCmd());
	}
	@Override
	public String getGroupName() {
		return "method";
	}

	@Override
	public List<CommandProcessor> getCommandList() {
		return cmdList;
	}
	private class ExceptionCountCmd implements CommandProcessor {
		@Override
		public String getName() {
			return "excnt";
		}

		@Override
		public String getGroup() {
			return getGroupName();
		}

		@Override
		public String getHelp() {
			return "系统Exception的统计数量";
		}

		@Override
		public String getReply(CmdMessage cmd) {
			Map<String, Integer> count = LoggerUtils.getExceptionCountMap();
			LinkedHashMap<String, Integer> sorted = BeanUtil.sortMapByValue(count, false);
			StringBuilder sb = new StringBuilder("Critical:" + LoggerUtils.getCriticalExceptionCount());
			sb.append(", timeFrom:" + new Timestamp(LoggerUtils.getExceptionTimefrom()));
			for(Map.Entry<String, Integer> entry: sorted.entrySet()){
				sb.append("\n" + entry.getValue() + "\t" + entry.getKey());
			}
			return sb.toString();
		}
	}
}
