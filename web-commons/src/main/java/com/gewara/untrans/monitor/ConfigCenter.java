package com.gewara.untrans.monitor;


public interface ConfigCenter {
	/**
	 * 注册单系统配置
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param trigger
	 */
	void register(String systemid, String tag, ConfigTrigger trigger);
	/**
	 * 注册全局配置
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param trigger
	 */
	void registerGlobal(String tag, ConfigTrigger trigger);

	/**
	 * 注册单系统配置（多分区，防止单节点过快更新导致信息丢失）
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param partition  最大128个
	 * @param trigger
	 */
	void register(String systemid, String tag, ConfigTrigger trigger, int partition);
	/**
	 * 注册全局配置（多分区，防止单节点过快更新导致信息丢失）
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param trigger
	 * @param partition
	 */
	void registerGlobal(String tag, ConfigTrigger trigger, int partition);
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * 
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 */
	void refresh(String systemid, String tag);
	
	/**
	 * 
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param data
	 */
	void refresh(String systemid, String tag, String data);
	
	/**
	 * 
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 */
	void refreshGlobal(String tag);
	
	/**
	 * 
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 * @param data
	 */
	void refreshGlobal(String tag, String data);

	/**
	 * 
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 */
	void reloadGlobal(String tag);
	
	/**
	 * 
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 */
	void reloadCurrent(String systemid, String tag);
	
	/**
	 * 
	 * @param systemid
	 * @param tag 子目录，如果只有一级目录，直接传目录名称；如果是多级目录，目录间用“/”隔开，注意头尾不能加“/”
	 */
	ConfigData getConfigData(String systemid, String tag);
}
