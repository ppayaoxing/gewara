package com.gewara.support.magent;

import java.util.List;

public interface CommandProcessorGroup {
	public String getGroupName();

	public List<CommandProcessor> getCommandList();
}
