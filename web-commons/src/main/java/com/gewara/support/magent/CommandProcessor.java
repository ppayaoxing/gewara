/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.CmdMessage;

public interface CommandProcessor {
	String NODATA = "!!nodata!!";
	String SUCCESS = "reply:success";
	String UNKNOWN = "unknown command, please type “help” for help!";

	String getName();

	String getGroup();

	String getHelp();

	String getReply(CmdMessage arg0);
}