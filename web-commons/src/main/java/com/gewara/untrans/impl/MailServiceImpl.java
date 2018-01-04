package com.gewara.untrans.impl;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.command.EmailRecord;
import com.gewara.untrans.MailService;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class MailServiceImpl implements MailService{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	public HttpResult sendHtmlMessageUsingApi(EmailRecord emailRecord) {
		String sendMailUrl = "http://gewamail.gewara.com/gewamail/email/sendMail.xhtml";
		HttpResult result = null;
		Map<String,String> params = new HashMap<String, String>();
		params.put("key", "MAILSYS");
		params.put("encryptCode", StringUtil.md5("MAILSYSMAILSYS_GEWARA"));
		params.put("sender", emailRecord.getSender());
		params.put("subject", emailRecord.getTitle());
		params.put("content", emailRecord.getContent());
		params.put("template", emailRecord.getTemplate());
		params.put("sendtime", DateUtil.formatTimestamp(emailRecord.getSendtime()));
		params.put("validtime", DateUtil.formatTimestamp(emailRecord.getValidtime()));
		params.put("mailtype", emailRecord.getMailtype());
		params.put("sendtype", SENDTYPE_FIRST);
		String[] mails = StringUtils.split(emailRecord.getEmail(), ",");
		for (int i = 0; i < mails.length; i++) {
			params.put("email",mails[i]);
			result = HttpUtils.postUrlAsString(sendMailUrl,params);
			if(!result.isSuccess()){
				dbLogger.warn("mail:"+mails[i]+"sender:"+emailRecord.getSender()+"msg:"+result.getMsg());
			}
		}
		return result;
	}
	
	@Override
	public void cancelSendEmailApi(String id) {
		String sendMailUrl = "http://gewamail.gewara.com/gewamail/email/cancelSend.xhtml";
		Map<String,String> params = new HashMap<String, String>();
		params.put("key", "MAILSYS");
		params.put("encryptCode", StringUtil.md5("MAILSYSMAILSYS_GEWARA"));
		params.put("id", id);
		HttpResult result  = HttpUtils.postUrlAsString(sendMailUrl,params);
		if(!result.isSuccess()){
			dbLogger.warn("cancel email id:" + id);
		}
	}
	

	@Override
	public void sendTemplateEmail(String sender, String title, String template, Map model, String email){
		String jsonData = JsonUtils.writeObjectToJson(model);
		EmailRecord er = new EmailRecord(sender, title, jsonData, email);
		er.setTemplate(template);
		sendHtmlMessageUsingApi(er);
	}

	@Override
	public void sendEmail(String sender, String title, String content, String email){
		EmailRecord er = new EmailRecord(sender, title, content, email);
		sendHtmlMessageUsingApi(er);
	}
}
