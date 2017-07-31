package com.gewara.support.magent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.Config;
import com.gewara.monitor.JVMHelper;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;

public class JVMCommandProcessorGroup implements CommandProcessorGroup {

	@Override
	public String getGroupName() {
		return "jvm";
	}

	@Override
	public List<CommandProcessor> getCommandList() {
		List<CommandProcessor> result = new ArrayList<CommandProcessor>();
		result.add(new ThreadDumpCmd());
		result.add(new ThreadDumpCmd2());
		return result;
	}

	private class ThreadDumpCmd implements CommandProcessor {

		@Override
		public String getName() {
			return "dth";
		}

		@Override
		public String getGroup() {
			return getGroupName();
		}

		@Override
		public String getHelp() {
			return "[json] dump当前线程，保存在“/opt/lamp/weblog/dump/hostname_systemid_yyMMddHHmmss.tdump]”目录中。json表示结果返回Json格式(机器之间)";
		}

		@Override
		public String getReply(CmdMessage cmdMsg) {
			File savePath = new File("/opt/lamp/weblog/dump/");
			if (!savePath.exists()) {
				savePath.mkdirs();
			}
			String file = Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
			File dump = new File(savePath, file);
			Writer writer = null;
			Map<String, String> result = new HashMap<String, String>();
			try{
				writer = new BufferedWriter(new FileWriter(dump));
				Map<String, String> exp = JVMHelper.exportThread(writer);
				result.putAll(exp);
			}catch(Exception e){
				result.put("exception", e.getMessage());
			}finally{
				try{writer.close();}catch(Exception e){}
			}
			result.put("file", file);
			if(dump.exists()){
				result.put("filesize", "" + dump.length());
			}
			if (StringUtils.equals(cmdMsg.getParams(), "json")) {
				return JsonUtils.writeMapToJson(result);
			}
			return result.toString().replace('{', ' ').replace('}', ' ');
		}
	}

	private class ThreadDumpCmd2 implements CommandProcessor {

		@Override
		public String getName() {
			return "dth2";
		}

		@Override
		public String getGroup() {
			return getGroupName();
		}

		@Override
		public String getHelp() {
			return "[json]同dth，但包含锁信息，比较全面";
		}

		@Override
		public String getReply(CmdMessage cmdMsg) {
			File savePath = new File("/opt/lamp/weblog/dump/");
			if (!savePath.exists()) {
				savePath.mkdirs();
			}
			String file = "full_" + Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
			File dump = new File(savePath, file);
			Writer writer = null;
			Map<String, String> result = new HashMap<String, String>();
			try{
				writer = new BufferedWriter(new FileWriter(dump));
				Map<String, String> exp = JVMHelper.exportMBeanThread(writer);
				result.putAll(exp);
			}catch(Exception e){
				result.put("exception", e.getMessage());
			}finally{
				try{writer.close();}catch(Exception e){}
			}
			if(dump.exists()){
				 result.put("file", file);
				 result.put("filesize", "" + dump.length());	
			}
			if (StringUtils.equals(cmdMsg.getParams(), "json")) {
				return JsonUtils.writeMapToJson(result);
			}
			return result.toString().replace('{', ' ').replace('}', ' ');
		}
	}
}
