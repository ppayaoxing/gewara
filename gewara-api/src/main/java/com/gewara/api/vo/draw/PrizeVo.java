/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.draw;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class PrizeVo extends BaseVo {
	private static final long serialVersionUID = -953298279131566566L;
	public static final String PRIZE_TYPE_DRAMA = "drama";
	public static final String PRIZE_REMARK = "remark";
	public static final String PRIZE_TYPE_WAIBI = "waibi";
	public static final String PRIZE_TYPE_SPDISCOUNT = "sd";
	private Long id;
	private Long activityid;
	private String ptype;
	private Integer pvalue;
	private Integer chancenum;
	private Integer pnumber;
	private Integer psendout;
	private Timestamp addtime;
	private String remark;
	private String tag;
	private String plevel;
	private String msgcontent;
	private String otype;
	private String otherinfo;
	private String topPrize;

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getMsgcontent() {
		return this.msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

	public Integer getLeavenum() {
		return Integer.valueOf(this.pnumber.intValue() - this.psendout.intValue());
	}

	public void addPsendout() {
		this.psendout = Integer.valueOf(this.psendout.intValue() + 1);
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PrizeVo() {
	}

	public PrizeVo(String tag) {
		this.pvalue = Integer.valueOf(0);
		this.pnumber = Integer.valueOf(0);
		this.psendout = Integer.valueOf(0);
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.tag = tag;
		this.topPrize = "N";
	}

	public PrizeVo(Long activityid, String ptype, Integer pvalue, Integer pnumber, String remark, String tag,
			String plevel, String msgcontent, String otype) {
		this.activityid = activityid;
		this.ptype = ptype;
		this.pvalue = pvalue;
		this.pnumber = pnumber;
		this.remark = remark;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.psendout = Integer.valueOf(0);
		this.tag = tag;
		this.plevel = plevel;
		this.msgcontent = msgcontent;
		this.chancenum = Integer.valueOf(0);
		this.otype = otype;
		this.topPrize = "N";
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public String getPtype() {
		return this.ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Integer getPvalue() {
		return this.pvalue;
	}

	public void setPvalue(Integer pvalue) {
		this.pvalue = pvalue;
	}

	public Integer getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public Integer getPsendout() {
		return this.psendout;
	}

	public void setPsendout(Integer psendout) {
		this.psendout = psendout;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPlevel() {
		return this.plevel;
	}

	public void setPlevel(String plevel) {
		this.plevel = plevel;
	}

	public Integer getChancenum() {
		return this.chancenum;
	}

	public void setChancenum(Integer chancenum) {
		this.chancenum = chancenum;
	}

	public String getOtype() {
		return this.otype;
	}

	public void setOtype(String otype) {
		this.otype = otype;
	}

	public String getTopPrize() {
		return this.topPrize;
	}

	public void setTopPrize(String topPrize) {
		this.topPrize = topPrize;
	}
}