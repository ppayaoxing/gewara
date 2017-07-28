/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.json;

import java.util.Date;

public class PageView {
	private Date validtime;
	private String content;

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PageView(Long cachedtime, String content) {
		this.content = content;
		this.validtime = new Date(cachedtime.longValue());
	}

	public Date getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}
}