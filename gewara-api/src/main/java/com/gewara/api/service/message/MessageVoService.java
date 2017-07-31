package com.gewara.api.service.message;

import java.sql.Timestamp;

import com.gewara.support.ErrorCode;

public interface MessageVoService {
	ErrorCode addMessage(Long relatedid, String tradeNo, String contact, String content,Timestamp sendtime, Timestamp validtime, String smstype);
}
