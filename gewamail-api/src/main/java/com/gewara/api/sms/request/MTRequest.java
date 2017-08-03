package com.gewara.api.sms.request;

import java.sql.Timestamp;

import com.gewara.api.MsgRequest;

/**
 * 短信发送接口，请求信息
 * 
 * @author leo.li
 * Modify Time Jan 15, 2013 11:22:08 AM
 */
public class MTRequest extends MsgRequest{
	
	private static final long serialVersionUID = -7958685800960343234L;
	
	/**客户端短信ID，必须 */
	private String smsId; 
	/**国家编码，非必须*/
	private String countryCode;
	/**手机号，必须 */
	private String mobile; 
	/**短信内容，必须 */
	private String content; 
	/**业务类型，即在短信发送配置页配置的值，必须 */
	private String busType;
	/**短信唯一标识，若须避免短信重复发送，可提供这一参数，可选 */
	private String smsUkey;
	/**定时发送时间，若指定该值，系统将在该时间发送短信，可选 */
	private Timestamp attime;
	
	/**可选，提供6个冗余字段，长度英文字符150，汉字50 */
	private String field01;
	private String field02;
	private String field03;
	private String field04;
	private String field05;
	private String field06;
	private String field07;
	private String field08;
	private String field09;
	private String field10;
	
	public MTRequest(){}
	
	/**
	 * 构造MT请求
	 * 
	 * @param smsId   客户端短信ID，必须
	 * @param mobile  手机号，必须
	 * @param content 短信内容，必须 
	 * @param busType 业务类型，即在短信发送配置页配置的值，必须
	 *
	 * @author leo.li
	 * Modify Time Jan 15, 2013 11:25:52 AM
	 */
	public MTRequest(String smsId,String mobile,String content,String busType){
		this.smsId = smsId;
		this.mobile = mobile;
		this.content = content;
		this.busType = busType;
	}
	
	/**
	 * 获取客户端短信ID
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public String getSmsId() {
		return smsId;
	}
	
	/**
	 * 设置客户端短信ID，该值必须
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
	
	/**
	 * 获取国家编码
	 * 
	 * @return String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 获取手机号
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置手机号，该值必须
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取短信内容
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置短信内容，该值必须
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取业务类型，即在短信发送配置页配置的值
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public String getBusType() {
		return busType;
	}
	
	/**
	 * 设置业务类型，即在短信发送配置页配置的值，该值必须
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}
	
	/**
	 * 获取短信唯一标识，若须避免短信重复发送，可提供这一参数
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public String getSmsUkey() {
		return smsUkey;
	}
	
	/**
	 * 设置短信唯一标识，若须避免短信重复发送，可提供这一参数
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setSmsUkey(String smsUkey) {
		this.smsUkey = smsUkey;
	}
	
	/**
	 * 获取定时发送时间，若指定该值，系统将在该时间发送短信
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public Timestamp getAttime() {
		return attime;
	}
	
	/**
	 * 设置定时发送时间，若指定该值，系统将在该时间发送短信，该值可选
	 * 
	 * @return String
	 * Modify Time Jan 15, 2013 11:23:22 AM
	 */
	public void setAttime(Timestamp attime) {
		this.attime = attime;
	}

	public String getField01() {
		return field01;
	}

	public void setField01(String field01) {
		this.field01 = field01;
	}

	public String getField02() {
		return field02;
	}

	public void setField02(String field02) {
		this.field02 = field02;
	}

	public String getField03() {
		return field03;
	}

	public void setField03(String field03) {
		this.field03 = field03;
	}

	public String getField04() {
		return field04;
	}

	public void setField04(String field04) {
		this.field04 = field04;
	}

	public String getField05() {
		return field05;
	}

	public void setField05(String field05) {
		this.field05 = field05;
	}

	public String getField06() {
		return field06;
	}

	public void setField06(String field06) {
		this.field06 = field06;
	}

	public String getField07() {
		return field07;
	}

	public void setField07(String field07) {
		this.field07 = field07;
	}

	public String getField08() {
		return field08;
	}

	public void setField08(String field08) {
		this.field08 = field08;
	}

	public String getField09() {
		return field09;
	}

	public void setField09(String field09) {
		this.field09 = field09;
	}

	public String getField10() {
		return field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}
}
