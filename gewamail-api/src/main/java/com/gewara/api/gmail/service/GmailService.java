/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gmail.service;

import com.gewara.api.Response;
import com.gewara.api.gmail.request.SendMailByOutboxRequest;
import com.gewara.api.gmail.response.SendMailByOutboxResponse;
import com.gewara.api.gmail.service.vo.EmailRecordVO;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface GmailService {

	@Deprecated
	Response sendMail(EmailRecordVO arg0);

	ResultCode sendMail2(EmailRecordVO arg0);

	@Deprecated
	Response sendMailWithAttachments(EmailRecordVO arg0, List<Map<String, Object>> arg1);

	ResultCode sendMailWithAttachments2(EmailRecordVO arg0, List<Map<String, Object>> arg1);

	@Deprecated
	SendMailByOutboxResponse sendMailByOutbox(SendMailByOutboxRequest arg0);

	ResultCode sendMailByOutbox2(SendMailByOutboxRequest arg0);

	@Deprecated
	SendMailByOutboxResponse limitSendMailByOutbox(SendMailByOutboxRequest arg0);

	ResultCode limitSendMailByOutbox2(SendMailByOutboxRequest arg0);
}