/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sms.request;

import com.gewara.api.MsgRequest;
import java.sql.Timestamp;

public class MTRequest extends MsgRequest {
	private static final long serialVersionUID = -7958685800960343234L;
	private String smsId;
	private String countryCode;
	private String mobile;
	private String content;
	private String busType;
	private String smsUkey;
	private Timestamp attime;
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

	public MTRequest() {
	}

	public MTRequest(String smsId, String mobile, String content, String busType) {
		this.smsId = smsId;
		this.mobile = mobile;
		this.content = content;
		this.busType = busType;
	}

	public String getSmsId() {
		return this.smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBusType() {
		return this.busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getSmsUkey() {
		return this.smsUkey;
	}

	public void setSmsUkey(String smsUkey) {
		this.smsUkey = smsUkey;
	}

	public Timestamp getAttime() {
		return this.attime;
	}

	public void setAttime(Timestamp attime) {
		this.attime = attime;
	}

	public String getField01() {
		return this.field01;
	}

	public void setField01(String field01) {
		this.field01 = field01;
	}

	public String getField02() {
		return this.field02;
	}

	public void setField02(String field02) {
		this.field02 = field02;
	}

	public String getField03() {
		return this.field03;
	}

	public void setField03(String field03) {
		this.field03 = field03;
	}

	public String getField04() {
		return this.field04;
	}

	public void setField04(String field04) {
		this.field04 = field04;
	}

	public String getField05() {
		return this.field05;
	}

	public void setField05(String field05) {
		this.field05 = field05;
	}

	public String getField06() {
		return this.field06;
	}

	public void setField06(String field06) {
		this.field06 = field06;
	}

	public String getField07() {
		return this.field07;
	}

	public void setField07(String field07) {
		this.field07 = field07;
	}

	public String getField08() {
		return this.field08;
	}

	public void setField08(String field08) {
		this.field08 = field08;
	}

	public String getField09() {
		return this.field09;
	}

	public void setField09(String field09) {
		this.field09 = field09;
	}

	public String getField10() {
		return this.field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}
}