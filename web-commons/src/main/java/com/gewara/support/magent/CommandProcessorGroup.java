package com.gewara.support.magent;

import java.util.List;

public interface CommandProcessorGroup {
	String getGroupName();
	List<CommandProcessor> getCommandList();
}
