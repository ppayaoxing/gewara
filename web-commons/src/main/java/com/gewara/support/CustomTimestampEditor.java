package com.gewara.support;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class CustomTimestampEditor extends PropertyEditorSupport {
	private final boolean allowEmpty;

	public CustomTimestampEditor(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}else {
			try {
				setValue(Timestamp.valueOf(text));
			}catch (Exception ex) {
				TraceErrorException iae = new TraceErrorException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		}
	}

	@Override
	public String getAsText() {
		Timestamp value = (Timestamp) getValue();
		return (value != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value) : "");
	}

}
