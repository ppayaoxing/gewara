package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class OrderNoteVo extends BaseVo {

	private static final long serialVersionUID = -135038508746485007L;
	private Long id;
	private Long orderid;				//����ID
	private String tradeno;				//������
	private String ordertype;			//��������
	private String mobile;				//�ֻ���
	private String placename;			//��������
	private String placetype;			//��������
	private Long placeid;				//����ID
	private String itemname;			//��Ŀ����
	private String itemtype;			//��Ŀ����
	private Long itemid;				//��ĿID
	private String checkpass;			//ȡƱ����
	private Integer ticketnum;			//Ʊ����
	private String smallitemtype;		//��������
	private Long smallitemid;			//��������(���λ���Ʒ)
	private Timestamp addtime;			//���ʱ��
	private Timestamp updatetime;		//����ʱ��
	private Timestamp validtime;		//��Чʱ��
	private String message;				//��������
	
	private Timestamp playtime;			//��ӳʱ��
	private Timestamp taketime;			//ȡƱʱ��
	private String status;
	private String serialno;			//��ˮ��
	private Timestamp modifytime;		//һ���ͬ��
	private String result;				//ͬ��״̬
	private String description;			//˵��
	
	private String fromup;
	private String express;
	private String otherinfo;
	private Integer convertnum;				//��Ʊ��
	private String converttype;				//��������
	private Integer totalfee;					//�ܷ���
	private Integer totaldisfee;				//����Ʊ�Ż�
	private Integer convertfee;				//�һ�����
	private Integer convertdisfee;			//�һ���Ʊ�Żݷ���
	public OrderNoteVo(){}
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderid() {
		return orderid;
	}
	
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	
	public String getTradeno() {
		return tradeno;
	}
	
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPlacetype() {
		return placetype;
	}

	public void setPlacetype(String placetype) {
		this.placetype = placetype;
	}

	public Long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getCheckpass() {
		return checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public Integer getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getSmallitemtype() {
		return smallitemtype;
	}

	public void setSmallitemtype(String smallitemtype) {
		this.smallitemtype = smallitemtype;
	}

	public Long getSmallitemid() {
		return smallitemid;
	}

	public void setSmallitemid(Long smallitemid) {
		this.smallitemid = smallitemid;
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

	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String gainSynchtype(){
		if(StringUtils.equals(result, "U")) {
            return "1";
        }
		if(StringUtils.equals(result, "D")) {
            return "2";
        }
		return "0";
	}
	
	public Timestamp getModifytime() {
		return modifytime;
	}
	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String gainSmsKey(){
		return tradeno + smallitemtype + smallitemid;
	}
	public Timestamp getTaketime() {
		return taketime;
	}
	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}
	public String getFromup() {
		return fromup;
	}
	public void setFromup(String fromup) {
		this.fromup = fromup;
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
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public Integer getConvertnum() {
		return convertnum;
	}
	public void setConvertnum(Integer convertnum) {
		this.convertnum = convertnum;
	}
	public String getConverttype() {
		return converttype;
	}
	public void setConverttype(String converttype) {
		this.converttype = converttype;
	}
	public Integer getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}
	public Integer getTotaldisfee() {
		return totaldisfee;
	}
	public void setTotaldisfee(Integer totaldisfee) {
		this.totaldisfee = totaldisfee;
	}
	public Integer getConvertfee() {
		return convertfee;
	}
	public void setConvertfee(Integer convertfee) {
		this.convertfee = convertfee;
	}
	public Integer getConvertdisfee() {
		return convertdisfee;
	}
	public void setConvertdisfee(Integer convertdisfee) {
		this.convertdisfee = convertdisfee;
	}
	
}
