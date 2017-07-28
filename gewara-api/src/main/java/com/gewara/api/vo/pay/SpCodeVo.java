/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class SpCodeVo extends BaseVo {
	private static final long serialVersionUID = -6167296620246800818L;
	public static final String PASSPRE = "I";
	private Long id;
	private Integer version;
	private Long sdid;
	private Long memberid;
	private String mobile;
	private Timestamp sendtime;
	private Long orderid;
	private Integer usedcount;
	private String temppass;

	public Serializable realId() {
		return this.id;
	}

	public boolean hasBound() {
		return this.memberid.longValue() > 0L || StringUtils.length(this.mobile) == 11 || this.usedcount.intValue() > 0;
	}

	public boolean canUseByMember(Long mid) {
		return this.memberid.longValue() <= 0L || this.memberid.equals(mid);
	}

	public Long getSdid() {
		return this.sdid;
	}

	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Timestamp getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getUsedcount() {
		return this.usedcount;
	}

	public void setUsedcount(Integer usedcount) {
		this.usedcount = usedcount;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gainTemppass() {
		return this.temppass;
	}

	public void setTemppass(String temppass) {
		this.temppass = temppass;
	}
}