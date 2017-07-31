package com.gewara.untrans;

import java.util.Map;

import com.gewara.command.EmailRecord;
import com.gewara.util.HttpResult;

public interface MailService {
	String SENDTYPE_TEST ="test";
	String SENDTYPE_FIRST ="first";
	String SENDTYPE_SECOND ="second";
	String SENDTYPE_BATCH = "batch";
	String SENDTYPE_DEFAULT = "default";
	HttpResult sendHtmlMessageUsingApi(EmailRecord emailRecord);
	void sendEmail(String sender, String title, String content, String email);
	void sendTemplateEmail(String sender, String title, String template, Map model, String email);
	void cancelSendEmailApi(String id);
}
