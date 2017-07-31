package com.gewara.api.vo.order;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.OrderConstant;
import com.gewara.cons.PartnerConstant;
import com.gewara.cons.PaymethodConstant;
import com.gewara.cons.Status;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;

public class GewaOrderVo extends BaseVo{
	private static final long serialVersionUID = 4914995483381697551L;
	public static final String RESTATUS_DELETE = "D";// 订单删除状态
	//交易状态
	private Long id;					//ID
	private Integer version;			//更新版本
	private String ordertitle;		//订单标题
	private String tradeNo;			//订单号
	private String mobile;			//联系手机
	private Timestamp createtime;		//用户下单时间
	private Timestamp addtime;		//增加时间：第一次创建时间、待处理创建时间、火凤凰锁定时间
	private Timestamp updatetime;		//用户修改时间
	private Timestamp validtime;		//有效时间
	private Timestamp paidtime;		//付款时间
	private Timestamp playtime;		//场次时间
	private Timestamp taketime;		//取票时间
	private String status;			//付款状态
	private Long memberid;			//关联用户
	private Long partnerid;			//关联商家
	private String membername;		//用户名/单位代码
	private String paymethod;			//支付方法:站内账户、淘宝余额、银行支付
	private String paybank;			//支付银行
	private String payseqno;			//外部订单号
	private String description2;		//商品描述
	private Long clerkid;				//订单经办人
	private String remark;			//特别说明
	private Integer gewapaid;			//账户余额支付的金额
	private Integer alipaid;			//淘宝或汇付支付的金额
	private Integer wabi;				//瓦币消费
	private Integer totalcost;		//总成本价
	private Integer totalfee;			//订单总金额
	private Integer discount;			//订单优惠
	private String disreason;			//优惠理由
	private String changehis;			//操作历史记录
	private Integer costprice;		//成本价
	private Integer unitprice;		//单价
	private Integer quantity;			//数量
	private String ukey;				//标识Partner订单唯一用户
	private String checkpass;			//取票密码
	private Integer itemfee;			//订单附属品总价
	private String otherinfo;			//其他信息
	private String citycode;			//城市代码
	private Integer otherfee;			//手续费
	private String settle;			//是否与第三方结算：Y，N
	private String restatus;			//是否删除
	private String pricategory;		//订单分类（模块）
	private String category;			//订单类别
	private String otherFeeRemark;	//手续费明细
	private String express;
	private String prepay;			//预售订单 Y, 来宾订单S, 非预售订单N
	private Long placeid;				//关联场馆：Cinema、Theatre
	private String gatewayCode;		//支付网关代码	
	private String merchantCode;		//商户号标识
	private String origin;			//订单来源
	private Long relatedid;			//mpid,goodsid,dpid(drama),pubid(pubsale),mctid(membercard)
	private Long itemid;				//movieid,dramaid
	private String ordertype;		//订单类型
	private String hfhpass;
	private Long areaid;				//DramaOrder, cardid()
	private String seats;			//SellSeatID
	private Long cardid;	
	private Long sdid;
	

	
	public GewaOrderVo() {}
	
	public GewaOrderVo(Long memberId){
		this.version = 0;
		this.itemfee = 0;
		this.otherfee = 0;
		this.wabi = 0;
		this.memberid = memberId;
		this.pricategory = OrderConstant.ORDER_PRICATEGORY_MOVIE;
		this.otherinfo = "{}";
		this.settle = OrderConstant.SETTLE_NONE;
		this.prepay = OrderConstant.PREPAY_N;
	}
	public GewaOrderVo(Long memberId, String membername, String ukey){
		this.version = 0;
		this.otherfee = 0;
		this.wabi = 0;
		this.createtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.createtime;
		this.addtime = this.createtime;
		this.paymethod = PaymethodConstant.PAYMETHOD_UNKNOWN;	//默认PNR
		this.validtime = DateUtil.addDay(this.addtime, 1);		//默认一天
		this.status = OrderConstant.STATUS_NEW_UNLOCK;
		this.pricategory = OrderConstant.ORDER_PRICATEGORY_MOVIE;
		this.alipaid = 0;
		this.gewapaid = 0;
		this.discount = 0;
		this.memberid = memberId;
		this.membername = membername;
		//this.relatedid = opi.getMpid();
		//this.placeid = opi.getCinemaid();
		//this.citycode = opi.getCitycode();
		//this.itemid = opi.getMovieid();
		//this.playtime = opi.getPlaytime();
		this.ukey = ukey;
		this.itemfee = 0;
		this.otherinfo = "{}";
		this.settle = OrderConstant.SETTLE_NONE;
		this.express = Status.N;
		this.prepay = OrderConstant.PREPAY_N;
	}

	@Override
	public Serializable realId() {
		return id;
	}
	
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Integer getItemfee() {
		return itemfee;
	}
	public void setItemfee(Integer itemfee) {
		this.itemfee = itemfee;
	}
	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public Integer getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getPricategory() {
		return pricategory;
	}

	public void setPricategory(String pricategory) {
		this.pricategory = pricategory;
	}
	
	public Long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}


	public String getCheckpass() {
		return checkpass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public String getOrdertitle() {
		return ordertitle;
	}
	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}
	public Long getClerkid() {
		return clerkid;
	}
	public void setClerkid(Long clerkid) {
		this.clerkid = clerkid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getAlipaid() {
		return alipaid;
	}
	public void setAlipaid(Integer alipaid) {
		this.alipaid = alipaid;
	}

	public String getPaymethodText(){
		return PaymethodConstant.getPaymethodText(paymethod);
	}
	public Integer getGewapaid() {
		return gewapaid;
	}
	public void setGewapaid(Integer gewapaid) {
		this.gewapaid = gewapaid;
	}
	
	public Timestamp getPaidtime() {
		return paidtime;
	}
	public void setPaidtime(Timestamp paidtime) {
		this.paidtime = paidtime;
	}
	
	public boolean isNetPaid(){
		return alipaid > 0;
	}
	//应付款
	public Integer getDue(){
		int due = totalfee + itemfee + otherfee - discount;
		return due < 0? 0 : due;
	}
	public Integer getTotalAmount(){
		return totalfee + itemfee + otherfee;
	}
	public String getPaybank() {
		return paybank;
	}
	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}
	public String getPayseqno() {
		return payseqno;
	}
	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getChangehis() {
		return changehis;
	}
	public void setChangehis(String changehis) {
		this.changehis = changehis;
	}
	public void addChangehis(String name, String change) {
		String result = JsonUtils.addJsonKeyValue(changehis, name, change);
		this.changehis = result;
	}
	public Integer getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}
	public String getDisreason() {
		return disreason;
	}
	public void setDisreason(String disreason) {
		this.disreason = disreason;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getUkey() {
		return ukey;
	}
	public void setUkey(String ukey) {
		this.ukey = ukey;
	}
	public Long getPartnerid() {
		return partnerid;
	}
	public Integer getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}
	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getOtherfee() {
		return otherfee;
	}
	public void setOtherfee(Integer otherfee) {
		this.otherfee = otherfee;
	}

	public String getSettle() {
		return settle;
	}

	public void setSettle(String settle) {
		this.settle = settle;
	}

	public Integer getWabi() {
		return wabi;
	}

	public void setWabi(Integer wabi) {
		this.wabi = wabi;
	}
	public String getRestatus() {
		return restatus;
	}

	public void setRestatus(String restatus) {
		this.restatus = restatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOtherFeeRemark() {
		return otherFeeRemark;
	}

	public void setOtherFeeRemark(String otherFeeRemark) {
		this.otherFeeRemark = otherFeeRemark;
	}

	public Timestamp getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getPrepay() {
		return prepay;
	}

	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}

	public String getGatewayCode() {
		return gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String getStatusText(){
		return OrderConstant.statusMap.get(getFullStatus());
	}
	public String getFullStatus(){
		if(status.startsWith(OrderConstant.STATUS_NEW) && isTimeout()) return OrderConstant.STATUS_TIMEOUT;
		return status;
	}
	public String getStatusText2(){//显示给用户看
		if(isCancel()) return "超时取消";
		if(isPaidSuccess()) return "交易成功";
		if(StringUtils.equals(status, OrderConstant.STATUS_PAID_RETURN)) return "已退款";
		if(isAllPaid()) return "已付款，确认中";
		return OrderConstant.statusMap.get(status);
	}
	public boolean isNew(){
		return status.startsWith(OrderConstant.STATUS_NEW) && !isTimeout();
	}
	/**
	 * 订单状态为确定去付款
	 * @return
	 */
	public boolean isNewConfirm(){
		return OrderConstant.STATUS_NEW_CONFIRM.equals(status) && !isTimeout();
	}
	public boolean isPaidFailure(){
		return OrderConstant.STATUS_PAID_FAILURE.equals(status) && (getDue() - gewapaid - alipaid <= 0);
	}
	public boolean isPaidUnfix(){
		return (OrderConstant.STATUS_PAID_UNFIX.equals(status)) && (getDue() - gewapaid - alipaid <= 0);
	}
	public boolean isPaidSuccess(){
		return OrderConstant.STATUS_PAID_SUCCESS.equals(status) && (getDue() - gewapaid - alipaid <= 0);
	}
	public boolean isAllPaid(){
		return StringUtils.startsWith(status, OrderConstant.STATUS_PAID) && (getDue() - gewapaid - alipaid <= 0) ;
	}
	public boolean isNotAllPaid(){
		return StringUtils.startsWith(status, OrderConstant.STATUS_PAID) && (getDue() - gewapaid - alipaid > 0) ;
	}
	public Integer getRealPaid(){
		return gewapaid+alipaid;
	}
	/**
	 * 可用抵用券直接支付金额，抵用金额可超过订单金额
	 * @return
	 */
	public boolean isZeroPay() {
		return getDue()<= 0 && discount > 0;
	}
	public boolean isCancel(){
		return StringUtils.startsWith(status, OrderConstant.STATUS_CANCEL) || 
				StringUtils.startsWith(status, OrderConstant.STATUS_NEW) && isTimeout();
	}
	public boolean isTimeout(){
		return validtime!=null && validtime.before(new Timestamp(System.currentTimeMillis()));
	}
	/**
	 * 可以处理
	 * @return
	 */
	public boolean canProcess(){
		return this.updatetime.before(DateUtil.addMinute(new Timestamp(System.currentTimeMillis()), -3));
	}
	public boolean isTimeoutCancel(){
		return isTimeout() && status.equals(OrderConstant.STATUS_NEW);
	}
	public Integer gainInvoiceDue(){
		Integer due = this.getAlipaid() + this.getGewapaid() - this.getWabi();
		return due;
	}
	public Integer gainRealUnitprice(){
		return totalfee/quantity;
	}
	public boolean surePartner(){
		return this.partnerid>1;
	}
	public boolean sureOutPartner(){//外部商家
		return PartnerConstant.isOutPartner(memberid);
	}
	public boolean sureGewaPartner(){//内部WAP,IPHONE...
		return PartnerConstant.isGewaPartner(memberid, partnerid);
	}
	
/*	public boolean sureOutPartner(){//外部商家
		return PartnerConstant.isOutPartner(memberid);
	}
	public boolean sureGewaPartner(){//内部WAP,IPHONE...
		return PartnerConstant.isGewaPartner(memberid, partnerid);
	}
*/

	public Timestamp getTaketime() {
		return taketime;
	}

	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	
	public boolean hasMemberCardPay(){
		return StringUtils.equals(paymethod, PaymethodConstant.PAYMETHOD_MEMBERCARDPAY);
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getHfhpass() {
		return hfhpass;
	}

	public void setHfhpass(String hfhpass) {
		this.hfhpass = hfhpass;
	}

	public String getOrdertype(){
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
	
	public boolean hasUnlock() {
		return status.equals(OrderConstant.STATUS_NEW_UNLOCK);
	}
	
	//~~~~~~~~~~~~~for compatible~~~~~~~~~~~~~~~~~~
	@Transient
	public Long getMpid(){
		return relatedid;
	}

	@Transient
	public Long getDramaid(){
		return itemid;
	}

	@Transient
	public Long getOci(){
		return itemid;
	}
	
	@Transient
	public Long getMovieid() {
		return itemid;
	}
	
	@Transient
	public Long getOttid(){
		return relatedid;
	}
	@Transient
	public Long getGoodsid(){
		return relatedid;
	}
	@Transient
	public Long getDpid(){
		return relatedid;
	}
	@Transient
	public Long getPubid(){
		return relatedid;
	}
	@Transient
	public Long getGci(){
		return relatedid;
	}
	


	public Long getCardid() {
		return cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public Long getSdid() {
		return sdid;
	}

	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}
	public String getTradeno(){
		return tradeNo;
	}

}
