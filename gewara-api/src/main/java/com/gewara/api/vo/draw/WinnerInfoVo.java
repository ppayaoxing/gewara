package com.gewara.api.vo.draw;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.Status;

/**
 * 锟斤拷锟矫伙拷锟斤拷息
 * @author Administrator
 */
public class WinnerInfoVo extends BaseVo {
	private static final long serialVersionUID = -7691160993786955260L;
	public static final String TAG_SYSTEM = "system";
	public static final String TAG_USER = "user";
	public final static String SUM_PRIZECOUNT = "sumprizecount";//锟斤拷品锟斤拷锟斤拷
	public final static String PROBABILTY_STATUS = "probabiltystatus";//锟叫断硷拷锟斤拷锟斤拷锟角凤拷锟角碉拷一锟斤拷锟斤拷锟斤拷
	private Long id;
	private Long activityid;
	private Long memberid;
	private String nickname;
	private Long prizeid;
	private String mobile;
	private Timestamp addtime;
	private String status;//锟斤拷品锟角凤拷锟窖撅拷锟酵筹拷Y:锟斤拷锟酵筹拷锟斤拷N锟斤拷未锟酵筹拷
	private String tag;//默锟斤拷system,锟斤拷锟斤拷员锟斤拷台锟斤拷锟絬ser
	private Long relatedid; 	//锟斤拷品锟斤拷锟斤拷ID锟斤拷锟界卡ID
	private String remark;		//锟斤拷品说锟斤拷锟斤拷锟界卡锟脚碉拷
	private String ip;
	public WinnerInfoVo(){
	}
	public WinnerInfoVo(Long activityid, Timestamp addtime){
		this.addtime = addtime;
		this.status = Status.N;
		this.tag = TAG_SYSTEM;
		this.activityid = activityid;
	}
	public WinnerInfoVo(Long activityid, Long prizeid, String mobile, Timestamp addtime, String tag){
		this(activityid, addtime);
		this.prizeid = prizeid;
		this.mobile = mobile;
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityid() {
		return activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getPrizeid() {
		return prizeid;
	}

	public void setPrizeid(Long prizeid) {
		this.prizeid = prizeid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getEnmobile(){
		String result = mobile;
		if(StringUtils.length(result)<=4) {
            return result;
        }
		return "*******" + result.substring(result.length()-4);
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
