package com.gewara.web.support;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 线程安全 
 * @author wangjg
 */
public class TimestampEditor extends PropertyEditorSupport {
	private String full_timeformat = "yyyy-MM-dd HH:mm:ss";

	public TimestampEditor(){
	}

	public TimestampEditor(String dateFormat){
		this.full_timeformat = dateFormat;
	}
	@Override
	public void setAsText(String value) {
		if(StringUtils.isBlank(value)){
			this.setValue(null);
			return;
		}
		String formtText = full_timeformat;
		if(value.length()<=full_timeformat.length()){
			formtText = StringUtils.substring(full_timeformat, 0, value.length());
		}
		Timestamp date = format(formtText, value);
		this.setValue(date);
	}
	
	protected Timestamp format(String formtText, String value){
		try {
			DateFormat format = new SimpleDateFormat(formtText);
			Timestamp date = new Timestamp(format.parse(value).getTime());
			return date;
		} catch (ParseException e) {
		}
		return null;
	}

	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? new SimpleDateFormat(full_timeformat).format(value) : "");
	}
}