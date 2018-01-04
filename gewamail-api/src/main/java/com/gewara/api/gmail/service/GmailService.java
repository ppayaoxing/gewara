package com.gewara.api.gmail.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.Response;
import com.gewara.api.gmail.request.SendMailByOutboxRequest;
import com.gewara.api.gmail.response.SendMailByOutboxResponse;
import com.gewara.api.gmail.service.vo.EmailRecordVO;
import com.gewara.api.vo.ResultCode;


/**
 * 邮件管理
 * @author zhaorq
 *
 */
public interface GmailService {

	/**
	 * 发送邮件
     * @see #sendMail2
	 */
	@Deprecated
	public Response sendMail(EmailRecordVO msg);
	
	//发送邮件
	public ResultCode sendMail2(EmailRecordVO msg);
	
	//发送邮件
	/**
	 * 
     * @see #sendMailWithAttachments2
	 */
	@Deprecated
	public Response sendMailWithAttachments(EmailRecordVO msg, List<Map<String, Object>> attachments);
	
	//发送邮件
	public ResultCode sendMailWithAttachments2(EmailRecordVO msg, List<Map<String, Object>> attachments);
	
	/**
	 * 指定发件箱发送邮件
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 15, 2013 7:52:38 PM
     * @see #sendMailByOutbox2
	 */
	@Deprecated
	public SendMailByOutboxResponse sendMailByOutbox(SendMailByOutboxRequest request);
	
	/**
	 * 指定发件箱发送邮件
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 15, 2013 7:52:38 PM
	 */
	public ResultCode sendMailByOutbox2(SendMailByOutboxRequest request);
	
	/**
	 * 指定发件箱发送邮件，不是即时发送，按限制配额定时发送
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time 2014年2月27日 下午2:26:23
     * @see #limitSendMailByOutbox2
	 */
	@Deprecated
	public SendMailByOutboxResponse limitSendMailByOutbox(SendMailByOutboxRequest request);
	
	/**
	 * 指定发件箱发送邮件，不是即时发送，按限制配额定时发送
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time 2014年2月27日 下午2:26:23
	 */
	public ResultCode limitSendMailByOutbox2(SendMailByOutboxRequest request);
}
