/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.CmdMessage;
import com.gewara.support.magent.CommandProcessor;
import com.gewara.support.magent.CommandProcessorGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;

public class MessageCommandCenter {
	private Map<String, CommandProcessor> commandMap = new TreeMap();
	private String helper = null;

	public List<CommandProcessor> getCommandList() {
		return new ArrayList(this.commandMap.values());
	}

	public void registerGroup(CommandProcessorGroup group) {
		List cmdList = group.getCommandList();
		Iterator arg2 = cmdList.iterator();

		while (arg2.hasNext()) {
			CommandProcessor command = (CommandProcessor) arg2.next();
			String name = command.getName().toLowerCase();
			if (this.commandMap.containsKey(name)) {
				CommandProcessor first = (CommandProcessor) this.commandMap.remove(name);
				this.commandMap.put(first.getGroup() + name, first);
				this.commandMap.put(command.getGroup() + name, command);
			} else {
				this.commandMap.put(name, command);
			}
		}

		this.buildHelp();
	}

	private void buildHelp() {
		StringBuilder sb = new StringBuilder("\nplease type “help” or ? for help!\n");
		int i = 1;

		for (Iterator arg2 = this.commandMap.keySet().iterator(); arg2.hasNext(); ++i) {
			String key = (String) arg2.next();
			CommandProcessor cmd = (CommandProcessor) this.commandMap.get(key);
			sb.append(i + "、").append(key).append(": ").append(cmd.getHelp()).append("\n");
		}

		this.helper = sb.toString();
	}

	public String execCommand(String cmdMsg, String userFrom) {
		if (StringUtils.isBlank(cmdMsg)) {
			return "unknown command, please type “help” for help!";
		} else if (!StringUtils.equals(cmdMsg, "help") && !StringUtils.equals(cmdMsg, "?")) {
			CmdMessage cmd = new CmdMessage(cmdMsg, userFrom);
			CommandProcessor command = (CommandProcessor) this.commandMap.get(StringUtils.lowerCase(cmd.getCmd()));
			return command == null ? "unknown command, please type “help” for help!" : command.getReply(cmd);
		} else {
			return this.helper;
		}
	}
}