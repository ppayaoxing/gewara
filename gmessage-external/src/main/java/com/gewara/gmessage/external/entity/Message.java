
package com.gewara.gmessage.external.entity;

import java.util.List;

import com.gewara.gmessage.external.constant.NoticeType;

/**
 * 锟斤拷要锟斤拷锟斤拷锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷息时锟斤拷锟斤拷息锟侥癸拷锟斤拷要锟截★拷
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷3锟斤拷6锟斤拷
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
	 * 锟斤拷息锟斤拷锟斤拷锟竭ｏ拷锟斤拷锟斤拷
	 * @param receivers
	 */
	public void setReceivers(List<MUser> receivers) {
		this.receivers = receivers;
	}
	
	/**
	 * 锟斤拷息锟斤拷锟斤拷锟斤拷员锟斤拷息锟斤拷锟斤拷锟斤拷
	 * @param sender
	 */
	public void setSender(MUser sender) {
		this.sender = sender;
	}
	
	/**
	 * 锟斤拷息锟斤拷锟斤拷时锟戒。锟斤拷位为锟斤拷锟诫，锟斤拷锟斤拷
	 * @param sendTimes
	 */
	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}
	
	/**
	 * 锟斤拷息失效时锟戒。锟斤拷位锟斤拷锟诫，锟角憋拷锟斤拷
	 * @param effectTimes
	 */
	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes =expiryTimes;
	}
	
	/**
	 * 锟斤拷锟斤拷锟斤拷息锟斤拷通知锟斤拷锟酵★拷锟斤拷锟斤拷锟斤拷写锟斤拷
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
