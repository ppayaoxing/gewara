/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.command.EmailRecord;
import com.gewara.util.HttpResult;
import java.util.Map;

public interface MailService {
	String SENDTYPE_TEST = "test";
	String SENDTYPE_FIRST = "first";
	String SENDTYPE_SECOND = "second";
	String SENDTYPE_BATCH = "batch";
	String SENDTYPE_DEFAULT = "default";

	HttpResult sendHtmlMessageUsingApi(EmailRecord arg0);

	void sendEmail(String arg0, String arg1, String arg2, String arg3);

	void sendTemplateEmail(String arg0, String arg1, String arg2, Map arg3, String arg4);

	void cancelSendEmailApi(String arg0);
}