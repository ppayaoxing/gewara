/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.StringUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class ChargeVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	public static final String STATUS_NEW = "new";
	public static final String STATUS_WAITPAY = "new_wait";
	public static final String STATUS_PAID = "paid_success";
	public static final String STATUS_CANCEL = "cancel";
	private Integer version = Integer.valueOf(0);
	private Long id;
	private String tradeNo;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Timestamp validtime;
	private String status;
	private Long memberid;
	private String membername;
	private String paymethod;
	private String paybank;
	private String payseqno;
	private Integer totalfee;
	private String chargetype;
	private Long outorderid;
	private String chargeto;

	public Serializable realId() {
		return this.id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getChargetype() {
		return this.chargetype;
	}

	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}

	public int getFee() {
		return this.totalfee.intValue();
	}

	public boolean isNew() {
		return this.status.startsWith("new");
	}

	public boolean isPaid() {
		return this.status.equals("paid_success");
	}

	public String getStatusText() {
		return this.isNew() ? "等待付款" : (this.isPaid() ? "充值成功" : (this.isCancel() ? "取消" : "待处理"));
	}

	public boolean isCancel() {
		return this.status.startsWith("cancel");
	}

	public String getDescription() {
		return "Gewara网站账户充值，可用来站内支付";
	}

	public int getTotalfee() {
		return this.totalfee.intValue();
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getOrdertitle() {
		return "Gewara账户充值*订单号：" + this.tradeNo;
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public String getPaybank() {
		return this.paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getSplitTradeno() {
		return StringUtil.getSplitString(this.tradeNo, " ", 4);
	}

	public Long getOutorderid() {
		return this.outorderid;
	}

	public void setOutorderid(Long outorderid) {
		this.outorderid = outorderid;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getChargeto() {
		return this.chargeto;
	}

	public void setChargeto(String chargeto) {
		this.chargeto = chargeto;
	}

	public boolean hasChargeto(String charge) {
		return StringUtils.isBlank(charge) ? false : StringUtils.equals(this.chargeto, charge);
	}

	public boolean isOvertime() {
		return this.validtime == null ? false : this.validtime.before(DateUtil.getMillTimestamp());
	}

	public boolean hasValid() {
		return StringUtils.startsWith(this.status, "new") && this.isOvertime();
	}
}