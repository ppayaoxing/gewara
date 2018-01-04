package com.gewara.support.magent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import com.gewara.util.ServiceCacheHelper;
import com.gewara.web.support.ResourceStatsUtil;

public class RequestStatsGroup implements CommandProcessorGroup{
	@Override
	public List<CommandProcessor> getCommandList() {
		List<CommandProcessor> commandList = new ArrayList<CommandProcessor>();
		commandList.add(new InnerCommand("aurl", "[minreq=10]锟斤拷锟斤拷示锟斤拷目锟斤拷锟叫碉拷URL锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷"));
		commandList.add(new InnerCommand("burl", "锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷址锟斤拷锟斤拷锟斤拷"));
		commandList.add(new InnerCommand("unused", "锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟节达拷末锟斤拷锟绞癸拷锟斤拷url"));
		commandList.add(new InnerCommand("req", "未锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�"));
		commandList.add(new InnerCommand("dreq", "[max=100]锟斤拷锟斤拷锟截碉拷前未锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷"));
		commandList.add(new InnerCommand("call", "锟斤拷锟斤拷锟斤拷锟叫的凤拷锟斤拷锟斤拷jms锟斤拷job锟斤拷"));
		commandList.add(new InnerCommand("jms", "JMS锟斤拷锟斤拷锟斤拷息统锟斤拷"));
		commandList.add(new InnerCommand("pc", "PageCache页锟芥缓锟斤拷"));
		commandList.add(new InnerCommand("sc", "ServiceCache锟斤拷锟斤拷"));
		commandList.add(new InnerCommand("api","锟斤拷锟节达拷锟斤拷锟絛ubbo锟斤拷锟斤拷"));
		return commandList;
	}
	private class InnerCommand extends AbstractCommandProcessor{
		public InnerCommand(String name, String help){
			this.group = getGroupName();
			this.name = name;
			this.help = help;
		}
		@Override
		public String getReply(CmdMessage cmdMsg) {
			String reply = "";
			if(StringUtils.equalsIgnoreCase("req", cmdMsg.getCmd())){
				int waitmill = 0;
				if(StringUtils.isNotBlank(cmdMsg.getParams())) {
                    waitmill = Integer.parseInt(cmdMsg.getParams());
                }
				return getReq(waitmill);
			}else if(StringUtils.equalsIgnoreCase("aurl", cmdMsg.getCmd())){
				int mincount = 10;
				if(StringUtils.isNotBlank(cmdMsg.getParams())) {
                    mincount = Integer.parseInt(cmdMsg.getParams());
                }
				reply = getAllUrl(mincount);
			}else if(StringUtils.equalsIgnoreCase("dreq", cmdMsg.getCmd())){
				int maxcount = 100;
				if(StringUtils.isNotBlank(cmdMsg.getParams())) {
                    maxcount = Integer.parseInt(cmdMsg.getParams());
                }
				reply = getReqParams(maxcount);
			}else if(StringUtils.equalsIgnoreCase("burl", cmdMsg.getCmd())){
				reply = getBadUrl();
			}else if(StringUtils.equalsIgnoreCase("unused", cmdMsg.getCmd())){
				reply = getUnused();
			}else if(StringUtils.equalsIgnoreCase("call", cmdMsg.getCmd())){
				int waitmill = 0;
				if(StringUtils.isNotBlank(cmdMsg.getParams())) {
					waitmill = Integer.parseInt(cmdMsg.getParams());
				}
				reply = getCall(waitmill);
			}else if(StringUtils.equalsIgnoreCase("jms", cmdMsg.getCmd())){
				int waitmill = 0;
				if(StringUtils.isNotBlank(cmdMsg.getParams())) {
					waitmill = Integer.parseInt(cmdMsg.getParams());
				}
				reply = getJms(waitmill);
			}else if(StringUtils.equalsIgnoreCase("pc", cmdMsg.getCmd())){
				reply = getPageCache();
			}else if(StringUtils.equalsIgnoreCase("sc", cmdMsg.getCmd())){
				reply = getServiceCache();
			}else if(StringUtils.equalsIgnoreCase("api", cmdMsg.getCmd())){
				reply = getApi();
			}
			return reply;
		}
	}
		

	private String getApi(){
		List<Map> result = ResourceStatsUtil.getApiMethodStats().getProcessingList(0);
		if(result.isEmpty()){
			return CommandProcessor.NODATA;
		}
		StringBuilder reply = new StringBuilder("\n").append(StringUtils.join(result.get(0).keySet(), "\t")).append("\n");
		for(Map row:result){
			reply.append(StringUtils.join(row.values(), "\t")).append("\n");
		}
		return reply.toString();
	}
	
	private String getReqParams(int maxcount) {
		List<Map> result = ResourceStatsUtil.dumpRequest(maxcount);
		if(result.isEmpty()) {
            return CommandProcessor.NODATA;
        }
		StringBuilder sb = new StringBuilder("\n");
		for(Map row:result){
			for(Object key:row.keySet()){
				sb.append(key).append(":").append(row.get(key)).append("\n");
			}
			sb.append("---------------------------------------------------\n");
		}
		return sb.toString();
	}
	private String getReq(int waitmill){
		List<Map> result = ResourceStatsUtil.getUriStats().getProcessingList(waitmill);
		if(result.isEmpty()) {
            return CommandProcessor.NODATA;
        }
		StringBuilder reply = new StringBuilder("\n").append(StringUtils.join(result.get(0).keySet(), "\t")).append("\n");
		for(Map row:result){
			reply.append(StringUtils.join(row.values(), "\t")).append("\n");
		}
		return reply.toString();
	}
	private String getCall(int waitmill){
		List<Map> result = ResourceStatsUtil.getCallStats().getProcessingList(waitmill);
		if(result.isEmpty()) {
            return CommandProcessor.NODATA;
        }
		StringBuilder reply = new StringBuilder("\n").append(StringUtils.join(result.get(0).keySet(), "\t")).append("\n");
		for(Map row:result){
			reply.append(StringUtils.join(row.values(), "\t")).append("\n");
		}
		return reply.toString();
	}
	private String getJms(int waitmill){
		List<Map> result = ResourceStatsUtil.getJmsStats().getProcessingList(waitmill);
		if(result.isEmpty()) {
            return CommandProcessor.NODATA;
        }
		StringBuilder reply = new StringBuilder("\n").append(StringUtils.join(result.get(0).keySet(), "\t")).append("\n");
		for(Map row:result){
			reply.append(StringUtils.join(row.values(), "\t")).append("\n");
		}
		return reply.toString();
	}
	private String getPageCache(){
		Map<String, Integer> result = new TreeMap<String, Integer>(ResourceStatsUtil.getPageCacheStats().getStatsMap());
		return "" + result;
	}
	private String getServiceCache(){
		List<ServiceCacheHelper> schList = ResourceStatsUtil.getServiceCacheHelperList();
		String result = "";
		for(ServiceCacheHelper sch: schList){
			Map data = sch.getStats();
			if(data!=null){
				result += data+"\n";
			}
		}
		return result;
	}
	private String getUnused() {
		Set<String> unused = new TreeSet<String>(ResourceStatsUtil.getUriStats().getUnusedList());
		if(unused.isEmpty()) {
			return CommandProcessor.NODATA;
		}
		String result = StringUtils.join(unused, "\n");
		return result;
	}
	private String getAllUrl(int mincount){
		List<Map> result = ResourceStatsUtil.getUriStats().getCountList(mincount, true);
		if(result.isEmpty()) {
			return CommandProcessor.NODATA;
		}
		StringBuilder sb = new StringBuilder("\n");
		sb.append(StringUtils.join(result.get(0).keySet(), "\t")).append("\n");
		for(Map row: result){
			sb.append(StringUtils.join(row.values(), "\t")).append("\n");
		}
		return sb.toString();
	}
	private String getBadUrl(){
		Map<String, Integer> result = ResourceStatsUtil.getBadUrlStats().getStatsMap();
		if(result.isEmpty()) {
            return CommandProcessor.NODATA;
        }
		StringBuilder sb = new StringBuilder("\n");
		for(String key:result.keySet()){
			sb.append(StringUtils.rightPad(key, 80)).append("\t").append(result.get(key)).append("\n");
		}
		return sb.toString();
	}
	@Override
	public String getGroupName() {
		return "reqcmd";
	}

}