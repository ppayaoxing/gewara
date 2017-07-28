/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.AccountRefundConstant;
import com.gewara.cons.PartnerConstant;
import com.gewara.util.JsonUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class AccountRefundVo extends BaseVo {
	private static final long serialVersionUID = 6029378080103301843L;
	public static final String ABC_OTHERINFO_AMOUNT = "amount";
	public static final String ABC_OTHERINFO_POINT = "point";
	private Long id;
	private Integer version;
	private String tradeno;
	private String reason;
	private String status;
	private String origin;
	private Integer amount;
	private Long memberid;
	private Long partnerid;
	private String mobile;
	private Timestamp addtime;
	private Timestamp dealtime;
	private String remark;
	private String paymethod;
	private Long applyuser;
	private Long dealuser;
	private String otherinfo;
	private String payseqno;
	private String refundOrigin;
	private String merchantCode;
	private String batchNo;
	private String tradenoBack;

	public Serializable realId() {
		return this.id;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getStatusText(String sstatus) {
		return AccountRefundConstant.getStatusText(sstatus);
	}

	public Timestamp getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Timestamp dealtime) {
		this.dealtime = dealtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Long getApplyuser() {
		return this.applyuser;
	}

	public void setApplyuser(Long applyuser) {
		this.applyuser = applyuser;
	}

	public Long getDealuser() {
		return this.dealuser;
	}

	public void setDealuser(Long dealuser) {
		this.dealuser = dealuser;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String takeAbcOtherInfo() {
		String returnValue = "";
		if (StringUtils.isNotBlank(this.otherinfo)) {
			Map otherInfoMap = JsonUtils.readJsonToMap(this.otherinfo);
			if (otherInfoMap.containsKey("amount")) {
				returnValue = returnValue + "½ð¶î£º" + (String) otherInfoMap.get("amount");
			}

			if (otherInfoMap.containsKey("point")) {
				returnValue = returnValue + "£»»ý·Ö£º" + (String) otherInfoMap.get("point");
			}
		}

		return returnValue;
	}

	public boolean isOutPartner() {
		return PartnerConstant.isOutPartner(this.memberid);
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public String getRefundOrigin() {
		return this.refundOrigin;
	}

	public void setRefundOrigin(String refundOrigin) {
		this.refundOrigin = refundOrigin;
	}

	public String getRefundOriginText() {
		return StringUtils.isNotBlank(this.refundOrigin)
				? (String) AccountRefundConstant.refundOriginTextMap.get(this.refundOrigin) : "";
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getTradenoBack() {
		return this.tradenoBack;
	}

	public void setTradenoBack(String tradenoBack) {
		this.tradenoBack = tradenoBack;
	}
}