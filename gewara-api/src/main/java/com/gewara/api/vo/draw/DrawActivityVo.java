package com.gewara.api.vo.draw;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.Status;
import com.gewara.util.DateUtil;

public class DrawActivityVo extends BaseVo {
	private static final long serialVersionUID = -4034911891988110414L;
	public static final String SHOWSITE_WAP = "wap";
	public static final String SHOWSITE_WEB = "web";
	public static final String TAG_NEWTASK = "newtask";
	public static final String MOBILE_DRAW_TAG="mobile_invite";
	
	private Long id;
	private String name;
	private String tag;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private Timestamp addtime;
	private String showsite;
	private String otherinfo;
	private Integer limitnum;			//限制次数
	private String projectid;			//项目id
	
	public DrawActivityVo(){
		
	}
	
	public DrawActivityVo(String name,String tag,Timestamp startime,Timestamp endtime,String showsite){
		this.name = name;
		this.tag = tag;
		this.starttime = startime;
		this.endtime = endtime;
		this.status = Status.Y_NEW;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.showsite = showsite;
	}
	
	
	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
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
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getShowsite() {
		return showsite;
	}

	public void setShowsite(String showsite) {
		this.showsite = showsite;
	}
	
	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
	public boolean isOpen(){
		if(starttime==null) return false;
		return starttime.before(new Timestamp(System.currentTimeMillis()));
	}
	public boolean isClosed() {
		if(endtime==null) return true;
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.after(endtime);
	}
	
	public boolean isJoin(){
		Timestamp curtime = DateUtil.getCurFullTimestamp();
		return StringUtils.equals(Status.Y_NEW, status) && curtime.after(starttime) && curtime.before(endtime);
	}

	public Integer getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
}
