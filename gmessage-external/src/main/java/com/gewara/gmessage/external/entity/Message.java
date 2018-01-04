
package com.gewara.gmessage.external.entity;

import java.util.List;

import com.gewara.gmessage.external.constant.NoticeType;

/**
 * ��Ҫ������ʾ��������Ϣʱ����Ϣ�Ĺ���Ҫ�ء�
 * @author ����
 * @createDate 2015��3��6��
 */
public class Message extends MessageBaseInfo {
	private static final long serialVersionUID = -5568228175149691288L;
	private List<MUser> receivers=null;
	private MUser sender=null;
	private long sendTimes=-1;
	private Long expiryTimes=null;
	private NoticeType[] noticeType =null;

	public List<MUser> getReceivers() {
		return receivers;
	}

	public MUser getSender() {
		return sender;
	}

	public long getSendTimes() {
		return sendTimes;
	}
	
	
	public Long getExpiryTimes() {
		return expiryTimes;
	}
	
	public NoticeType[] getNoticeType() {
		return noticeType;
	}
	
	/**
	 * ��Ϣ�����ߣ�����
	 * @param receivers
	 */
	public void setReceivers(List<MUser> receivers) {
		this.receivers = receivers;
	}
	
	/**
	 * ��Ϣ������Ա��Ϣ������
	 * @param sender
	 */
	public void setSender(MUser sender) {
		this.sender = sender;
	}
	
	/**
	 * ��Ϣ����ʱ�䡣��λΪ���룬����
	 * @param sendTimes
	 */
	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}
	
	/**
	 * ��ϢʧЧʱ�䡣��λ���룬�Ǳ���
	 * @param effectTimes
	 */
	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes =expiryTimes;
	}
	
	/**
	 * ������Ϣ��֪ͨ���͡�������д��
	 * @param noticeType
	 */
	public void setNoticeType(NoticeType... noticeType) {
		this.noticeType = noticeType;
	}
	
	public String getUreaid(){
		if(getReleaseIDType()==null||getReleaseID()==null) {
            return null;
        }
		return getReleaseIDType()+"-"+getReleaseID();
	}
}
