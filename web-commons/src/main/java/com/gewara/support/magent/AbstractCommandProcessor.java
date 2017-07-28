/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.CommandProcessor;

public abstract class AbstractCommandProcessor implements CommandProcessor {
	protected String group;
	protected String name;
	protected String help;

	public String getName() {
		return this.name;
	}

	public String getHelp() {
		return this.help;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}