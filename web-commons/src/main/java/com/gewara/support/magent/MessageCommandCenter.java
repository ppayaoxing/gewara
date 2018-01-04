package com.gewara.support.magent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;

public class MessageCommandCenter {
	public static GewaLogger dbLogger = LoggerUtils.getLogger(MessageCommandCenter.class, Config.getServerIp(),
			Config.SYSTEMID);

	public MessageCommandCenter() {
	}

	private Map<String, CommandProcessor> commandMap = new TreeMap<String, CommandProcessor>();
	private Map<String, MessageCommand> messageCommandMap = new TreeMap<String, MessageCommand>();

	public List<CommandProcessor> getCommandList() {
		return new ArrayList<CommandProcessor>(commandMap.values());
	}

	private String helper = null;

	/**
	 * TODO 暂定
	 * 
	 * @return
	 */
	public static MessageCommandCenter getDefaultInstance() {
		MessageCommandCenter messageCommandCenter = null;
		try {
			messageCommandCenter = MessageCommandCenter.class.newInstance();
		} catch (Exception e) {
			dbLogger.error("初始化出错", e);
		}
		return messageCommandCenter;
	}

	// TODO 暂定
	public void registerGroup(MessageCommandGroup messageCommandGroup) {
		List<MessageCommand> cmdList = messageCommandGroup.getCommandList();

		for (MessageCommand command : cmdList) {
			String name = command.getName().toLowerCase();
			if (commandMap.containsKey(name)) {
				MessageCommand first = messageCommandMap.remove(name);
				messageCommandMap.put(first.getGroup() + name, first);
				messageCommandMap.put(command.getGroup() + name, command);
			} else {
				messageCommandMap.put(name, command);
			}
		}
		buildHelp();

	}

	public void registerGroup(CommandProcessorGroup group) {
		List<CommandProcessor> cmdList = group.getCommandList();

		for (CommandProcessor command : cmdList) {
			String name = command.getName().toLowerCase();
			if (commandMap.containsKey(name)) {
				CommandProcessor first = commandMap.remove(name);
				commandMap.put(first.getGroup() + name, first);
				commandMap.put(command.getGroup() + name, command);
			} else {
				commandMap.put(name, command);
			}
		}
		buildHelp();
	}

	private void buildHelp() {
		StringBuilder sb = new StringBuilder("\nplease type “help” or ? for help!\n");
		int i = 1;
		for (String key : commandMap.keySet()) {
			CommandProcessor cmd = commandMap.get(key);
			sb.append(i + "、").append(key).append(": ").append(cmd.getHelp()).append("\n");
			i++;
		}
		helper = sb.toString();
	}

	public String execCommand(String cmdMsg, String userFrom) {
		if (StringUtils.isBlank(cmdMsg)) {
			return CommandProcessor.UNKNOWN;
		}
		if (StringUtils.equals(cmdMsg, "help") || StringUtils.equals(cmdMsg, "?")) {
			return helper;
		}
		CmdMessage cmd = new CmdMessage(cmdMsg, userFrom);

		CommandProcessor command = commandMap.get(StringUtils.lowerCase(cmd.getCmd()));
		if (command == null) {
			return CommandProcessor.UNKNOWN;
		}
		return command.getReply(cmd);
	}

}
