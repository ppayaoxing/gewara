package com.gewara.support.magent;


public abstract class AbstractCommandProcessor implements CommandProcessor{
	protected String group;//分类
	protected String name;
	protected String help;
	/**
	 * 命令名称
	 * @return
	 */
	@Override
	public String getName(){
		return name;
	}
	/**
	 * 帮助信息
	 * @return
	 */
	@Override
	public String getHelp(){
		return help;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	@Override
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}
