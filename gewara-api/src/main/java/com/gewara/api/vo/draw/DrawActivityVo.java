/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.draw;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DrawActivityVo extends BaseVo {
	private static final long serialVersionUID = -4034911891988110414L;
	public static final String SHOWSITE_WAP = "wap";
	public static final String SHOWSITE_WEB = "web";
	public static final String TAG_NEWTASK = "newtask";
	public static final String MOBILE_DRAW_TAG = "mobile_invite";
	private Long id;
	private String name;
	private String tag;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private Timestamp addtime;
	private String showsite;
	private String otherinfo;
	private Integer limitnum;
	private String projectid;

	public DrawActivityVo() {
	}

	public DrawActivityVo(String name, String tag, Timestamp startime, Timestamp endtime, String showsite) {
		this.name = name;
		this.tag = tag;
		this.starttime = startime;
		this.endtime = endtime;
		this.status = "Y_NEW";
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.showsite = showsite;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getShowsite() {
		return this.showsite;
	}

	public void setShowsite(String showsite) {
		this.showsite = showsite;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public boolean isOpen() {
		return this.starttime == null ? false : this.starttime.before(new Timestamp(System.currentTimeMillis()));
	}

	public boolean isClosed() {
		if (this.endtime == null) {
			return true;
		} else {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return cur.after(this.endtime);
		}
	}

	public boolean isJoin() {
		Timestamp curtime = DateUtil.getCurFullTimestamp();
		return StringUtils.equals("Y_NEW", this.status) && curtime.after(this.starttime)
				&& curtime.before(this.endtime);
	}

	public Integer getLimitnum() {
		return this.limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
}