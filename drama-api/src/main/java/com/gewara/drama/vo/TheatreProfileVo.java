package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class TheatreProfileVo extends BaseVo{
	private static final long serialVersionUID = 8293331615143909101L;
	private Long id;
	private Long topicid;			//ȡƱ����
	private String notifymsg1;		//ȡƱ����
	private String notifymsg2;		//��ǰ3Сʱ���Ѷ���
	private String notifymsg3;		//��ǰһ�����Ѷ���
	private String notifyRemark;	//ȡƱ����(���)
	private String qrcodeRemark; 	//ȡƱ����(��ά�����Ʊ)
	private String takemethod;		//ȡƱ��ʽ
	private String takemsg;			//ȡƱ����
	private String opentype;		//���ݿ������ͣ�GPTBS, GEWA
	private String status;			//����״̬
	private Integer eticketHour;		//��A,E Ĭ�ϵ���Ʊʱ��(Сʱ))
	private Integer eticketWeekHour;	//��A,E Ĭ�ϵ���Ʊʱ����ĩ(Сʱ))
	
	private Timestamp addtime;
	private Timestamp updatetime;
	
	public TheatreProfileVo(){}
	
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
	public Long getTopicid() {
		return topicid;
	}
	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}
	public String getTakemethod() {
		return takemethod;
	}
	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotifymsg1() {
		return notifymsg1;
	}
	public void setNotifymsg1(String notifymsg1) {
		this.notifymsg1 = notifymsg1;
	}
	public String getNotifymsg2() {
		return notifymsg2;
	}
	public void setNotifymsg2(String notifymsg2) {
		this.notifymsg2 = notifymsg2;
	}
	public String getNotifymsg3() {
		return notifymsg3;
	}
	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}

	public String getNotifyRemark() {
		return notifyRemark;
	}
	public void setNotifyRemark(String notifyRemark) {
		this.notifyRemark = notifyRemark;
	}
	
	public String getQrcodeRemark() {
		return qrcodeRemark;
	}

	public void setQrcodeRemark(String qrcodeRemark) {
		this.qrcodeRemark = qrcodeRemark;
	}

	public String getTakemsg() {
		return takemsg;
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public void setTakemsg(String takemsg) {
		this.takemsg = takemsg;
	}

	public Integer getEticketHour() {
		return eticketHour;
	}
	public void setEticketHour(Integer eticketHour) {
		this.eticketHour = eticketHour;
	}
	public Integer getEticketWeekHour() {
		return eticketWeekHour;
	}
	public void setEticketWeekHour(Integer eticketWeekHour) {
		this.eticketWeekHour = eticketWeekHour;
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
	public boolean hasOpentype(String htype){
		if(StringUtils.isBlank(htype)) {
            return false;
        }
		return StringUtils.equals(opentype, htype);
	}
}
