package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.StringUtil;

/**
 * @author acerge(acerge@163.com)
 * @since 6:31:46 PM Aug 13, 2009
 */
public class ChargeVo extends BaseVo{
	private static final long serialVersionUID = 4914995483381697551L;
	//锟斤拷锟斤拷状态
	public static final String STATUS_NEW = "new";						//锟铰讹拷锟斤拷
	public static final String STATUS_WAITPAY = "new_wait";			//锟铰讹拷锟斤拷,锟饺达拷锟斤拷锟斤拷
	public static final String STATUS_PAID = "paid_success";			//锟斤拷锟斤拷锟�
	public static final String STATUS_CANCEL = "cancel";				//锟斤拷锟斤拷取锟斤拷锟斤拷
	private Integer version;		//锟斤拷锟铰版本
	private Long id;				//ID
	private String tradeNo;			//锟斤拷锟斤拷锟斤拷
	private Timestamp addtime;		//锟斤拷锟斤拷时锟斤拷
	private Timestamp updatetime;	//锟睫革拷时锟斤拷
	private Timestamp validtime;	//锟斤拷效锟斤拷锟斤拷	
	private String status;			//锟斤拷锟斤拷状态
	private Long memberid;			//锟斤拷锟斤拷锟矫伙拷
	private String membername;		//锟矫伙拷锟斤拷
	private String paymethod;		//支锟斤拷锟斤拷锟斤拷:锟皆憋拷锟斤拷锟姐付
	private String paybank;			//支锟斤拷锟斤拷锟斤拷
	private String payseqno;		//锟解部锟斤拷锟阶猴拷
	private Integer totalfee;    	//锟斤拷值锟斤拷锟�
	private String chargetype;		//锟斤拷值锟斤拷锟斤拷:锟斤拷值 锟斤拷 为锟斤拷锟斤拷锟斤拷锟斤拷锟街�
	private Long outorderid;		//锟斤拷锟斤拷锟斤拷锟斤拷id
	private String chargeto;		//锟斤拷值锟斤拷式 bank, wabi
	
	public ChargeVo(){
		this.version = 0;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getChargetype() {
		return chargetype;
	}

	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}
	/**
	 * @return 锟斤拷锟斤拷锟侥斤拷锟�
	 */
	public int getFee(){
		return totalfee;
	}
	public boolean isNew(){
		return status.startsWith(STATUS_NEW);
	}
	public boolean isPaid(){
		return status.equals(STATUS_PAID);
	}
	public String getStatusText(){
		if(isNew()) {
            return "锟饺达拷锟斤拷锟斤拷";
        }
		if(isPaid()) {
            return "锟斤拷值锟缴癸拷";
        }
		if(isCancel()) {
            return "取锟斤拷";
        }
		return "锟斤拷锟斤拷锟斤拷";
	}
	public boolean isCancel() {
		return status.startsWith(STATUS_CANCEL);
	}
	public String getDescription() {
		return "Gewara锟斤拷站锟剿伙拷锟斤拷值锟斤拷锟斤拷锟斤拷锟斤拷站锟斤拷支锟斤拷";
	}
	public int getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getOrdertitle(){
		return "Gewara锟剿伙拷锟斤拷值" + "*锟斤拷锟斤拷锟脚ｏ拷" + tradeNo;
	}
	public String getPayseqno() {
		return payseqno;
	}
	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}
	public String getPaybank() {
		return paybank;
	}
	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getSplitTradeno(){
		return StringUtil.getSplitString(this.tradeNo, " ", 4);
	}
	public Long getOutorderid() {
		return outorderid;
	}

	public void setOutorderid(Long outorderid) {
		this.outorderid = outorderid;
	}
	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public String getChargeto() {
		return chargeto;
	}
	public void setChargeto(String chargeto) {
		this.chargeto = chargeto;
	}
	
	public boolean hasChargeto(String charge){
		if(StringUtils.isBlank(charge)){
			return false;
		}
		return StringUtils.equals(this.chargeto, charge);
	}
	
	public boolean isOvertime(){
		if(validtime==null) {
            return false;
        }
		return validtime.before(DateUtil.getMillTimestamp());
	}
	
	public boolean hasValid(){
		return StringUtils.startsWith(this.status, STATUS_NEW) && isOvertime(); 
	}
	/**
	 * FIXME: 使锟斤拷Helper锟斤拷锟斤拷
	 * public boolean isCanInvoice(){
		return status.equals(STATUS_PAID) && StringUtils.equals(chargeto, ChargeConstant.WABIPAY) && canInvoiceList.contains(paymethod);
	}
	public String getPaytext(){
		String result = PaymethodConstant.getPaymethodText(paymethod);
		if(PaymethodConstant.PAYMETHOD_CHARGECARD.equals(paymethod)) result="锟斤拷锟斤拷锟�"+ payseqno + "锟斤拷锟斤拷";
		return result;
	}*/

}
