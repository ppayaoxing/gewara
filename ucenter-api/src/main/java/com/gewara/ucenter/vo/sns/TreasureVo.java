package com.gewara.ucenter.vo.sns;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class TreasureVo extends BaseVo{
	private static final long serialVersionUID = -6783731167904266671L;
	public static final String ACTION_COLLECT = "collect";
	public static final String TAG_MEMBER = "member";
	private Long id;
	private Long memberid; 		//动作发出者
	private String tag; 		//模块
	private String action;		//分类
	private Long relatedid;		//关联的对象
	private Timestamp addtime; 
	private String actionlabel; //标签
	public TreasureVo(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getActionlabel() {
		return actionlabel;
	}
	public void setActionlabel(String actionlabel) {
		this.actionlabel = actionlabel;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	
}
