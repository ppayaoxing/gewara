/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

public interface SecurityModule {
	String getModuleurl();

	Long getId();

	String getMenucode();

	String getMenutitle();

	String getTarget();

	String getDisplay();

	boolean isTop();

	String getParentcode();

	String getTag();

	String getTopMenucode();

	String getRolenames();
}