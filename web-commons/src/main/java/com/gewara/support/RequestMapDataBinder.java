/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.support.RequestMapPropertyValues;
import com.gewara.web.support.TimestampEditor;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.DataBinder;

public class RequestMapDataBinder extends DataBinder {
	public RequestMapDataBinder(Object target) {
		super(target);
		this.regEditor();
	}

	public RequestMapDataBinder(Object target, String objectName) {
		super(target, objectName);
		this.regEditor();
	}

	private void regEditor() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		TimestampEditor timestampEditor = new TimestampEditor();
		dateFormat.setLenient(false);
		this.registerCustomEditor(Date.class, (String) null, dateEditor);
		this.registerCustomEditor(Timestamp.class, (String) null, timestampEditor);
	}

	public void bind(Map dwrRequestMap) {
		RequestMapPropertyValues mpvs = new RequestMapPropertyValues(dwrRequestMap);
		this.doBind(mpvs);
	}
}