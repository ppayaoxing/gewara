/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class TimestampEditor extends PropertyEditorSupport {
	private String full_timeformat = "yyyy-MM-dd HH:mm:ss";

	public TimestampEditor() {
	}

	public TimestampEditor(String dateFormat) {
		this.full_timeformat = dateFormat;
	}

	public void setAsText(String value) {
		if (StringUtils.isBlank(value)) {
			this.setValue((Object) null);
		} else {
			String formtText = this.full_timeformat;
			if (value.length() <= this.full_timeformat.length()) {
				formtText = StringUtils.substring(this.full_timeformat, 0, value.length());
			}

			Timestamp date = this.format(formtText, value);
			this.setValue(date);
		}
	}

	protected Timestamp format(String formtText, String value) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formtText);
			Timestamp date = new Timestamp(format.parse(value).getTime());
			return date;
		} catch (ParseException arg4) {
			return null;
		}
	}

	public String getAsText() {
		Date value = (Date) this.getValue();
		return value != null ? (new SimpleDateFormat(this.full_timeformat)).format(value) : "";
	}
}