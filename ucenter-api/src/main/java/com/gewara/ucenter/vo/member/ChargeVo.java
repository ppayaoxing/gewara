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
	//����״̬
	public static final String STATUS_NEW = "new";						//�¶���
	public static final String STATUS_WAITPAY = "new_wait";			//�¶���,�ȴ�����
	public static final String STATUS_PAID = "paid_success";			//�����
	public static final String STATUS_CANCEL = "cancel";				//����ȡ����
	private Integer version;		//���°汾
	private Long id;				//ID
	private String tradeNo;			//������
	private Timestamp addtime;		//����ʱ��
	private Timestamp updatetime;	//�޸�ʱ��
	private Timestamp validtime;	//��Ч����	
	private String status;			//����״̬
	private Long memberid;			//�����û�
	private String membername;		//�û���
	private String paymethod;		//֧������:�Ա����㸶
	private String paybank;			//֧������
	private String payseqno;		//�ⲿ���׺�
	private Integer totalfee;    	//��ֵ���
	private String chargetype;		//��ֵ����:��ֵ �� Ϊ���������ֵ
	private Long outorderid;		//��������id
	private String chargeto;		//��ֵ��ʽ bank, wabi
	
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
	 * @return �����Ľ��
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
            return "�ȴ�����";
        }
		if(isPaid()) {
            return "��ֵ�ɹ�";
        }
		if(isCancel()) {
            return "ȡ��";
        }
		return "������";
	}
	public boolean isCancel() {
		return status.startsWith(STATUS_CANCEL);
	}
	public String getDescription() {
		return "Gewara��վ�˻���ֵ��������վ��֧��";
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
		return "Gewara�˻���ֵ" + "*�����ţ�" + tradeNo;
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
	 * FIXME: ʹ��Helper����
	 * public boolean isCanInvoice(){
		return status.equals(STATUS_PAID) && StringUtils.equals(chargeto, ChargeConstant.WABIPAY) && canInvoiceList.contains(paymethod);
	}
	public String getPaytext(){
		String result = PaymethodConstant.getPaymethodText(paymethod);
		if(PaymethodConstant.PAYMETHOD_CHARGECARD.equals(paymethod)) result="�����"+ payseqno + "����";
		return result;
	}*/

}
