package com.gewara.api.sms.service;

import java.sql.Timestamp;

import com.gewara.api.vo.ResultCode;

public interface VoiceCodeVoService {
	/**
	 * 发送语音短信验证码
	 * @param mobile
	 * @param checkcode
	 * @param memberid
	 * @param ip
	 * @param validtime
	 * @param tag
	 * @return
	 */
	ResultCode sendVoiceCode(String mobile, String checkcode, Long memberid, String ip, Timestamp validtime);
	ResultCode sendVoiceCode(String mobile, String checkcode, Long memberid, String ip, Timestamp validtime, String tag);
	
}
