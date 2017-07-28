/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.order;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.OrderConstant;
import com.gewara.cons.PartnerConstant;
import com.gewara.cons.PaymethodConstant;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class GewaOrderVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	public static final String RESTATUS_DELETE = "D";
	private Long id;
	private Integer version;
	private String ordertitle;
	private String tradeNo;
	private String mobile;
	private Timestamp createtime;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Timestamp validtime;
	private Timestamp paidtime;
	private Timestamp playtime;
	private Timestamp taketime;
	private String status;
	private Long memberid;
	private Long partnerid;
	private String membername;
	private String paymethod;
	private String paybank;
	private String payseqno;
	private String description2;
	private Long clerkid;
	private String remark;
	private Integer gewapaid;
	private Integer alipaid;
	private Integer wabi;
	private Integer totalcost;
	private Integer totalfee;
	private Integer discount;
	private String disreason;
	private String changehis;
	private Integer costprice;
	private Integer unitprice;
	private Integer quantity;
	private String ukey;
	private String checkpass;
	private Integer itemfee;
	private String otherinfo;
	private String citycode;
	private Integer otherfee;
	private String settle;
	private String restatus;
	private String pricategory;
	private String category;
	private String otherFeeRemark;
	private String express;
	private String prepay;
	private Long placeid;
	private String gatewayCode;
	private String merchantCode;
	private String origin;
	private Long relatedid;
	private Long itemid;
	private String ordertype;
	private String hfhpass;
	private Long areaid;
	private String seats;
	private Long cardid;
	private Long sdid;

	public GewaOrderVo() {
	}

	public GewaOrderVo(Long memberId) {
		this.version = Integer.valueOf(0);
		this.itemfee = Integer.valueOf(0);
		this.otherfee = Integer.valueOf(0);
		this.wabi = Integer.valueOf(0);
		this.memberid = memberId;
		this.pricategory = "movie";
		this.otherinfo = "{}";
		this.settle = "O";
		this.prepay = "N";
	}

	public GewaOrderVo(Long memberId, String membername, String ukey) {
		this.version = Integer.valueOf(0);
		this.otherfee = Integer.valueOf(0);
		this.wabi = Integer.valueOf(0);
		this.createtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.createtime;
		this.addtime = this.createtime;
		this.paymethod = "unknown";
		this.validtime = (Timestamp) DateUtil.addDay(this.addtime, 1);
		this.status = "new_unlock";
		this.pricategory = "movie";
		this.alipaid = Integer.valueOf(0);
		this.gewapaid = Integer.valueOf(0);
		this.discount = Integer.valueOf(0);
		this.memberid = memberId;
		this.membername = membername;
		this.ukey = ukey;
		this.itemfee = Integer.valueOf(0);
		this.otherinfo = "{}";
		this.settle = "O";
		this.express = "N";
		this.prepay = "N";
	}

	public Serializable realId() {
		return this.id;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getItemfee() {
		return this.itemfee;
	}

	public void setItemfee(Integer itemfee) {
		this.itemfee = itemfee;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public Integer getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getPricategory() {
		return this.pricategory;
	}

	public void setPricategory(String pricategory) {
		this.pricategory = pricategory;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getCheckpass() {
		return this.checkpass;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getOrdertitle() {
		return this.ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public Long getClerkid() {
		return this.clerkid;
	}

	public void setClerkid(Long clerkid) {
		this.clerkid = clerkid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getAlipaid() {
		return this.alipaid;
	}

	public void setAlipaid(Integer alipaid) {
		this.alipaid = alipaid;
	}

	public String getPaymethodText() {
		return PaymethodConstant.getPaymethodText(this.paymethod);
	}

	public Integer getGewapaid() {
		return this.gewapaid;
	}

	public void setGewapaid(Integer gewapaid) {
		this.gewapaid = gewapaid;
	}

	public Timestamp getPaidtime() {
		return this.paidtime;
	}

	public void setPaidtime(Timestamp paidtime) {
		this.paidtime = paidtime;
	}

	public boolean isNetPaid() {
		return this.alipaid.intValue() > 0;
	}

	public Integer getDue() {
		int due = this.totalfee.intValue() + this.itemfee.intValue() + this.otherfee.intValue()
				- this.discount.intValue();
		return Integer.valueOf(due < 0 ? 0 : due);
	}

	public Integer getTotalAmount() {
		return Integer.valueOf(this.totalfee.intValue() + this.itemfee.intValue() + this.otherfee.intValue());
	}

	public String getPaybank() {
		return this.paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getChangehis() {
		return this.changehis;
	}

	public void setChangehis(String changehis) {
		this.changehis = changehis;
	}

	public void addChangehis(String name, String change) {
		String result = JsonUtils.addJsonKeyValue(this.changehis, name, change);
		this.changehis = result;
	}

	public Integer getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public String getDisreason() {
		return this.disreason;
	}

	public void setDisreason(String disreason) {
		this.disreason = disreason;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public Integer getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
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

	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getOtherfee() {
		return this.otherfee;
	}

	public void setOtherfee(Integer otherfee) {
		this.otherfee = otherfee;
	}

	public String getSettle() {
		return this.settle;
	}

	public void setSettle(String settle) {
		this.settle = settle;
	}

	public Integer getWabi() {
		return this.wabi;
	}

	public void setWabi(Integer wabi) {
		this.wabi = wabi;
	}

	public String getRestatus() {
		return this.restatus;
	}

	public void setRestatus(String restatus) {
		this.restatus = restatus;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOtherFeeRemark() {
		return this.otherFeeRemark;
	}

	public void setOtherFeeRemark(String otherFeeRemark) {
		this.otherFeeRemark = otherFeeRemark;
	}

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getPrepay() {
		return this.prepay;
	}

	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}

	public String getGatewayCode() {
		return this.gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getStatusText() {
		return (String) OrderConstant.statusMap.get(this.getFullStatus());
	}

	public String getFullStatus() {
		return this.status.startsWith("new") && this.isTimeout() ? "cancel_timeout" : this.status;
	}

	public String getStatusText2() {
		return this.isCancel() ? "超时取消"
				: (this.isPaidSuccess() ? "交易成功"
						: (StringUtils.equals(this.status, "paid_return") ? "已退款"
								: (this.isAllPaid() ? "已付款，确认中" : (String) OrderConstant.statusMap.get(this.status))));
	}

	public boolean isNew() {
		return this.status.startsWith("new") && !this.isTimeout();
	}

	public boolean isNewConfirm() {
		return "new_confirm".equals(this.status) && !this.isTimeout();
	}

	public boolean isPaidFailure() {
		return "paid_failure".equals(this.status)
				&& this.getDue().intValue() - this.gewapaid.intValue() - this.alipaid.intValue() <= 0;
	}

	public boolean isPaidUnfix() {
		return "paid_failure_unfix".equals(this.status)
				&& this.getDue().intValue() - this.gewapaid.intValue() - this.alipaid.intValue() <= 0;
	}

	public boolean isPaidSuccess() {
		return "paid_success".equals(this.status)
				&& this.getDue().intValue() - this.gewapaid.intValue() - this.alipaid.intValue() <= 0;
	}

	public boolean isAllPaid() {
		return StringUtils.startsWith(this.status, "paid")
				&& this.getDue().intValue() - this.gewapaid.intValue() - this.alipaid.intValue() <= 0;
	}

	public boolean isNotAllPaid() {
		return StringUtils.startsWith(this.status, "paid")
				&& this.getDue().intValue() - this.gewapaid.intValue() - this.alipaid.intValue() > 0;
	}

	public Integer getRealPaid() {
		return Integer.valueOf(this.gewapaid.intValue() + this.alipaid.intValue());
	}

	public boolean isZeroPay() {
		return this.getDue().intValue() <= 0 && this.discount.intValue() > 0;
	}

	public boolean isCancel() {
		return StringUtils.startsWith(this.status, "cancel")
				|| StringUtils.startsWith(this.status, "new") && this.isTimeout();
	}

	public boolean isTimeout() {
		return this.validtime != null && this.validtime.before(new Timestamp(System.currentTimeMillis()));
	}

	public boolean canProcess() {
		return this.updatetime.before((Timestamp) DateUtil.addMinute(new Timestamp(System.currentTimeMillis()), -3));
	}

	public boolean isTimeoutCancel() {
		return this.isTimeout() && this.status.equals("new");
	}

	public Integer gainInvoiceDue() {
		Integer due = Integer
				.valueOf(this.getAlipaid().intValue() + this.getGewapaid().intValue() - this.getWabi().intValue());
		return due;
	}

	public Integer gainRealUnitprice() {
		return Integer.valueOf(this.totalfee.intValue() / this.quantity.intValue());
	}

	public boolean surePartner() {
		return this.partnerid.longValue() > 1L;
	}

	public boolean sureOutPartner() {
		return PartnerConstant.isOutPartner(this.memberid);
	}

	public boolean sureGewaPartner() {
		return PartnerConstant.isGewaPartner(this.memberid, this.partnerid);
	}

	public Timestamp getTaketime() {
		return this.taketime;
	}

	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public boolean hasMemberCardPay() {
		return StringUtils.equals(this.paymethod, "memberCardPay");
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getHfhpass() {
		return this.hfhpass;
	}

	public void setHfhpass(String hfhpass) {
		this.hfhpass = hfhpass;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getSeats() {
		return this.seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public boolean hasUnlock() {
		return this.status.equals("new_unlock");
	}

	@Transient
	public Long getMpid() {
		return this.relatedid;
	}

	@Transient
	public Long getDramaid() {
		return this.itemid;
	}

	@Transient
	public Long getOci() {
		return this.itemid;
	}

	@Transient
	public Long getMovieid() {
		return this.itemid;
	}

	@Transient
	public Long getOttid() {
		return this.relatedid;
	}

	@Transient
	public Long getGoodsid() {
		return this.relatedid;
	}

	@Transient
	public Long getDpid() {
		return this.relatedid;
	}

	@Transient
	public Long getPubid() {
		return this.relatedid;
	}

	@Transient
	public Long getGci() {
		return this.relatedid;
	}

	public Long getCardid() {
		return this.cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public Long getSdid() {
		return this.sdid;
	}

	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}

	public String getTradeno() {
		return this.tradeNo;
	}
}