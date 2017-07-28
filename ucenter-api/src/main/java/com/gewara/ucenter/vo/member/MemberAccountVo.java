/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class MemberAccountVo extends BaseVo {
	private static final long serialVersionUID = 3832626162173359411L;
	private Long id;
	private Long memberid;
	private String realname;
	private String phone;
	private Integer banlance;
	private String idcard;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer version;
	private Integer bankcharge;
	private Integer othercharge;
	private Integer depositcharge;
	private String encryidcard;
	private String forbid;
	private Integer certtype;
	private String emcontact;
	private String emmobile;
	private String paymentAccount;
	private boolean incomplete;
	private boolean nopassword;
	private Integer vipcharge;
	private String password;

	public String getEncryidcard() {
		return this.encryidcard;
	}

	public void setEncryidcard(String encryidcard) {
		this.encryidcard = encryidcard;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getBanlance() {
		return this.banlance;
	}

	public void setBanlance(Integer banlance) {
		this.banlance = banlance;
	}

	public Integer getDepositcharge() {
		return this.depositcharge;
	}

	public void setDepositcharge(Integer depositcharge) {
		this.depositcharge = depositcharge;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public boolean isIncomplete() {
		return this.incomplete;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public boolean isNopassword() {
		return this.nopassword;
	}

	public void setIncomplete(boolean incomplete) {
		this.incomplete = incomplete;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getBankcharge() {
		return this.bankcharge;
	}

	public void setBankcharge(Integer bankcharge) {
		this.bankcharge = bankcharge;
	}

	public Integer getOthercharge() {
		return this.othercharge;
	}

	public void setOthercharge(Integer othercharge) {
		this.othercharge = othercharge;
	}

	public String getForbid() {
		return this.forbid;
	}

	public void setForbid(String forbid) {
		this.forbid = forbid;
	}

	public Integer getCerttype() {
		return this.certtype;
	}

	public void setCerttype(Integer certtype) {
		this.certtype = certtype;
	}

	public String getEmcontact() {
		return this.emcontact;
	}

	public void setEmcontact(String emcontact) {
		this.emcontact = emcontact;
	}

	public String getEmmobile() {
		return this.emmobile;
	}

	public void setEmmobile(String emmobile) {
		this.emmobile = emmobile;
	}

	public boolean hasRights() {
		return !StringUtils.equals(this.forbid, "Y");
	}

	public String getPaymentAccount() {
		return this.paymentAccount;
	}

	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public void setNopassword(boolean nopassword) {
		this.nopassword = nopassword;
	}

	public Integer getVipcharge() {
		return this.vipcharge;
	}

	public void setVipcharge(Integer vipcharge) {
		this.vipcharge = vipcharge;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}