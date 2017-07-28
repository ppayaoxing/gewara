/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.CommandProcessor;
import java.util.List;

public interface CommandProcessorGroup {
	String getGroupName();

	List<CommandProcessor> getCommandList();
}