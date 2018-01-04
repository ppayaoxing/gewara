package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;


public class DramaRemoteOrderVo extends BaseVo {
	private static final long serialVersionUID = -318165413477507019L;
	private Long orderid;			//��GewaOrder����ID
	private String serial;			//��ǰ��ˮ��
	private String hisSerial;		//��ʷ��ˮ��:���ŷָ�
	private Timestamp addtime;		//��������ʱ��
	private Timestamp locktime;		//������Чʱ��
	private String seqno;			//����ID
	private String areaseqno;		//����ID ���ŷָ�
	private String mobile;			//�û��ֻ���
	private String bookingId;		//Զ�̶���ID
	private String confirmationId;	//Զ�̶�������
	private String tickets;			//ӰƱ�ţ����ŷָ�
	private String seatlabel;		//�µ����ݣ�{"1233":"01:22,01:23"} (areaseq:seatline:seatrank ��  areaseq:priceseq:quantity)
	private String seatno;			//��λ��ţ�1233:01:22,01:23 �� {"123_21":"32",}
	private String status;			//���������lock��fixed��cancel...
	private String seatText;		//��λ�ı�
	private String checkmark;		
	private String opentype;		//ѡ������ѡ��
	private String message;			//���һ�δ�����Ϣ
	private String ordertype;		//�������ͣ�GPTBS
	private Timestamp updatetime;	//����ʱ��
	private String otherinfo;		//Զ�̶�����ϸ
	private String manual;			//Y���˹��սᶩ��
	private String userkey;			//�û�ID
	private String takemethod;
	private String realname;
	private String address;
	private String telphone;
	private String expressno;
	private String expressname;
	private String bindMobile;		//�û����ֻ���
	private String clientIp;		//�ͻ���IP
	
	private Integer ticketnum;		//����Ʊ��
	private Double totalfee;		//�����ܽ��
	private Double payfee;			//����֧�����
	
	@Override
	public Serializable realId() {
		return orderid;
	}


	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public String getSerial() {
		return serial;
	}


	public void setSerial(String serial) {
		this.serial = serial;
	}


	public String getHisSerial() {
		return hisSerial;
	}


	public void setHisSerial(String hisSerial) {
		this.hisSerial = hisSerial;
	}


	public Timestamp getAddtime() {
		return addtime;
	}


	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}


	public Timestamp getLocktime() {
		return locktime;
	}

	public void setLocktime(Timestamp locktime) {
		this.locktime = locktime;
	}


	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getAreaseqno() {
		return areaseqno;
	}

	public void setAreaseqno(String areaseqno) {
		this.areaseqno = areaseqno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public String getSeatlabel() {
		return seatlabel;
	}


	public void setSeatlabel(String seatlabel) {
		this.seatlabel = seatlabel;
	}


	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatText() {
		return seatText;
	}

	public void setSeatText(String seatText) {
		this.seatText = seatText;
	}

	public String getCheckmark() {
		return checkmark;
	}


	public void setCheckmark(String checkmark) {
		this.checkmark = checkmark;
	}

	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public boolean hasStatus(String fixseat){
		return StringUtils.equals(this.status, fixseat);
	}
	public boolean hasManual() {
		return StringUtils.startsWith(manual, "Y");
	}
	
	public boolean hasOpentype(String type){
		if(StringUtils.isBlank(type)) {
            return false;
        }
		return StringUtils.equals(this.opentype, type);
	}

	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getExpressno() {
		return expressno;
	}

	public void setExpressno(String expressno) {
		this.expressno = expressno;
	}

	public String getExpressname() {
		return expressname;
	}

	public void setExpressname(String expressname) {
		this.expressname = expressname;
	}


	public String getBindMobile() {
		return bindMobile;
	}


	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
	

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}


	public Integer getTicketnum() {
		return ticketnum;
	}


	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}


	public Double getTotalfee() {
		return totalfee;
	}


	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}


	public Double getPayfee() {
		return payfee;
	}


	public void setPayfee(Double payfee) {
		this.payfee = payfee;
	}
	
}
