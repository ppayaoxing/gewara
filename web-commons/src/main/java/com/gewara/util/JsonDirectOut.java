/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.JsonUtils;
import com.gewara.web.support.DirectOut;
import java.io.Writer;

public class JsonDirectOut implements DirectOut {
	private Writer writer;
	private Object json;

	public JsonDirectOut(Object json) {
		this.json = json;
	}

	public void write() {
		JsonUtils.writeObjectToWriter(this.writer, this.json, false);
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}