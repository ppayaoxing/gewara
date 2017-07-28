/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.support.TraceErrorException;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;

public class CustomTimestampEditor extends PropertyEditorSupport {
	private final boolean allowEmpty;

	public CustomTimestampEditor(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			this.setValue((Object) null);
		} else {
			try {
				this.setValue(Timestamp.valueOf(text));
			} catch (Exception arg3) {
				TraceErrorException iae = new TraceErrorException("Could not parse date: " + arg3.getMessage());
				iae.initCause(arg3);
				throw iae;
			}
		}

	}

	public String getAsText() {
		Timestamp value = (Timestamp) this.getValue();
		return value != null ? (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(value) : "";
	}
}