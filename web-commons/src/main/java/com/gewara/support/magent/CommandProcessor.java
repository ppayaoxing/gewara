package com.gewara.support.magent;

/**
 * 消息处理器，用来处理命令
 * @author gebiao(ge.biao@gewara.com)
 * @since Feb 28, 2014 10:04:10 PM
 */
public interface CommandProcessor{
	String NODATA = "!!nodata!!";
	String SUCCESS = "reply:success";
	String UNKNOWN = "unknown command, please type “help” for help!";

	String getName();
	String getGroup();
	String getHelp();
	String getReply(CmdMessage cmd);
}
