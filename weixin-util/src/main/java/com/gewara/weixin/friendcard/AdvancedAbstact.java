/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class AdvancedAbstact implements Serializable {
	private static final long serialVersionUID = 3468254563155003748L;
	private String abstract1;
	private String[] icon_url_list;

	public AdvancedAbstact() {
	}

	public AdvancedAbstact(String abstract1, String[] icon_url_list) {
		this.abstract1 = abstract1;
		this.icon_url_list = icon_url_list;
	}

	public String getAbstract1() {
		return this.abstract1;
	}

	public void setAbstract1(String abstract1) {
		this.abstract1 = abstract1;
	}

	public String[] getIcon_url_list() {
		return this.icon_url_list;
	}

	public void setIcon_url_list(String[] icon_url_list) {
		this.icon_url_list = icon_url_list;
	}
}