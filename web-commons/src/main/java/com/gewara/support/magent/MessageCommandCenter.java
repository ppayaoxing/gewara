package com.gewara.support.magent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public class MessageCommandCenter {
	public MessageCommandCenter(){
	}
	private Map<String, CommandProcessor> commandMap = new TreeMap<String, CommandProcessor>();
	public List<CommandProcessor> getCommandList(){
		return new ArrayList<CommandProcessor>(commandMap.values());
	}
	private String helper = null;
	public void registerGroup(CommandProcessorGroup group){
		List<CommandProcessor> cmdList = group.getCommandList();
		for(CommandProcessor command: cmdList){
			String name = command.getName().toLowerCase();
			if(commandMap.containsKey(name)) {
				CommandProcessor first = commandMap.remove(name);
				commandMap.put(first.getGroup() + name, first);
				commandMap.put(command.getGroup() + name, command);
			}else{
				commandMap.put(name, command);
			}
		}
		buildHelp();
	}
	private void buildHelp(){
		StringBuilder sb = new StringBuilder("\nplease type ¡°help¡± or ? for help!\n");
		int i=1;
		for(String key: commandMap.keySet()){
			CommandProcessor cmd = commandMap.get(key);
			sb.append(i + "¡¢").append(key).append(": ").append(cmd.getHelp()).append("\n");
			i++;
		}
		helper = sb.toString();
	}
	public String execCommand(String cmdMsg, String userFrom){
		if(StringUtils.isBlank(cmdMsg)){
			return CommandProcessor.UNKNOWN;
		}
		if(StringUtils.equals(cmdMsg, "help") || StringUtils.equals(cmdMsg, "?")){
			return helper;
		}
		CmdMessage cmd = new CmdMessage(cmdMsg, userFrom);
		
		CommandProcessor command = commandMap.get(StringUtils.lowerCase(cmd.getCmd()));
		if(command == null){
			return CommandProcessor.UNKNOWN;
		}
		return command.getReply(cmd);
	}
}
