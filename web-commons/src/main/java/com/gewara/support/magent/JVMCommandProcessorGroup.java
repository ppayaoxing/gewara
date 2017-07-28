/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.Config;
import com.gewara.monitor.JVMHelper;
import com.gewara.support.magent.CmdMessage;
import com.gewara.support.magent.CommandProcessor;
import com.gewara.support.magent.CommandProcessorGroup;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class JVMCommandProcessorGroup implements CommandProcessorGroup {
	public String getGroupName() {
		return "jvm";
	}

	public List<CommandProcessor> getCommandList() {
		ArrayList result = new ArrayList();
		result.add(new JVMCommandProcessorGroup.ThreadDumpCmd());
		result.add(new JVMCommandProcessorGroup.ThreadDumpCmd2());
		return result;
	}

	private class ThreadDumpCmd2 implements CommandProcessor {
		private ThreadDumpCmd2() {
		}

		public String getName() {
			return "dth2";
		}

		public String getGroup() {
			return JVMCommandProcessorGroup.this.getGroupName();
		}

		public String getHelp() {
			return "[json]同dth，但包含锁信息，比较全面";
		}

		public String getReply(CmdMessage cmdMsg) {
			File savePath = new File("/opt/lamp/weblog/dump/");
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			String file = "full_" + Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_"
					+ DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
			File dump = new File(savePath, file);
			BufferedWriter writer = null;
			HashMap result = new HashMap();

			try {
				writer = new BufferedWriter(new FileWriter(dump));
				Map e = JVMHelper.exportMBeanThread(writer);
				result.putAll(e);
			} catch (Exception arg15) {
				result.put("exception", arg15.getMessage());
			} finally {
				try {
					writer.close();
				} catch (Exception arg14) {
					;
				}

			}

			if (dump.exists()) {
				result.put("file", file);
				result.put("filesize", "" + dump.length());
			}

			return StringUtils.equals(cmdMsg.getParams(), "json")
					? JsonUtils.writeMapToJson(result)
					: result.toString().replace('{', ' ').replace('}', ' ');
		}
	}

	private class ThreadDumpCmd implements CommandProcessor {
		private ThreadDumpCmd() {
		}

		public String getName() {
			return "dth";
		}

		public String getGroup() {
			return JVMCommandProcessorGroup.this.getGroupName();
		}

		public String getHelp() {
			return "[json] dump当前线程，保存在“/opt/lamp/weblog/dump/hostname_systemid_yyMMddHHmmss.tdump]”目录中。json表示结果返回Json格式(机器之间)";
		}

		public String getReply(CmdMessage cmdMsg) {
			File savePath = new File("/opt/lamp/weblog/dump/");
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			String file = Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_"
					+ DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
			File dump = new File(savePath, file);
			BufferedWriter writer = null;
			HashMap result = new HashMap();

			try {
				writer = new BufferedWriter(new FileWriter(dump));
				Map e = JVMHelper.exportThread(writer);
				result.putAll(e);
			} catch (Exception arg15) {
				result.put("exception", arg15.getMessage());
			} finally {
				try {
					writer.close();
				} catch (Exception arg14) {
					;
				}

			}

			result.put("file", file);
			if (dump.exists()) {
				result.put("filesize", "" + dump.length());
			}

			return StringUtils.equals(cmdMsg.getParams(), "json")
					? JsonUtils.writeMapToJson(result)
					: result.toString().replace('{', ' ').replace('}', ' ');
		}
	}
}