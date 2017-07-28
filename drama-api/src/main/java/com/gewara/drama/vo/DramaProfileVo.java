/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class DramaProfileVo extends BaseVo {
	private static final long serialVersionUID = 2713318692410184246L;
	private Long dramaid;
	private String limittype;
	private Integer limitnum;
	private String limitsite;
	private String uniqueby;
	private String itemid;
	private String opustype;
	private String opuslink;
	private String reserve;
	private String validorder;
	private Integer rmaxnum;
	private Integer rlimitnum;
	private Integer delayedday;
	private Timestamp rstarttime;
	private Timestamp rendtime;
	private Date rstartdate;
	private String reserveexp;
	private String businessname;
	private String businessurl;
	private String remind;
	private String remindcontent;
	private String remindtext;
	private Timestamp remindtime;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String unlimituser;
	private String prioritize;
	private Timestamp pstarttime;
	private Timestamp pendtime;
	private String checkprice;
	private String reserverlogo;
	private String reservercolor;
	private String sharepic;
	private String appTopPic;
	private String pcToText;
	private String pcToLink;
	private String wapToText;
	private String wapToLink;
	private String appToText;
	private String appToLink;
	private String sellOutMark;
	private String wplogo;
	private String origin;
	private String autoseat;
	private String secondtype;
	private String domain;
	private String shortUrl;
	private Integer remnantnum;
	private String remnantnotice;

	public Serializable realId() {
		return this.dramaid;
	}

	public String getWpLimg() {
		return StringUtils.isBlank(this.wplogo) ? "img/default_logo.png" : this.wplogo;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getLimittype() {
		return this.limittype;
	}

	public void setLimittype(String limittype) {
		this.limittype = limittype;
	}

	public Integer getLimitnum() {
		return this.limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public String getLimitsite() {
		return this.limitsite;
	}

	public void setLimitsite(String limitsite) {
		this.limitsite = limitsite;
	}

	public String getUniqueby() {
		return this.uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getOpustype() {
		return this.opustype;
	}

	public void setOpustype(String opustype) {
		this.opustype = opustype;
	}

	public String getOpuslink() {
		return this.opuslink;
	}

	public void setOpuslink(String opuslink) {
		this.opuslink = opuslink;
	}

	public String getReserve() {
		return this.reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public String getValidorder() {
		return this.validorder;
	}

	public void setValidorder(String validorder) {
		this.validorder = validorder;
	}

	public Integer getRmaxnum() {
		return this.rmaxnum;
	}

	public void setRmaxnum(Integer rmaxnum) {
		this.rmaxnum = rmaxnum;
	}

	public Integer getRlimitnum() {
		return this.rlimitnum;
	}

	public void setRlimitnum(Integer rlimitnum) {
		this.rlimitnum = rlimitnum;
	}

	public Integer getDelayedday() {
		return this.delayedday;
	}

	public void setDelayedday(Integer delayedday) {
		this.delayedday = delayedday;
	}

	public Timestamp getRstarttime() {
		return this.rstarttime;
	}

	public void setRstarttime(Timestamp rstarttime) {
		this.rstarttime = rstarttime;
	}

	public Timestamp getRendtime() {
		return this.rendtime;
	}

	public void setRendtime(Timestamp rendtime) {
		this.rendtime = rendtime;
	}

	public Date getRstartdate() {
		return this.rstartdate;
	}

	public void setRstartdate(Date rstartdate) {
		this.rstartdate = rstartdate;
	}

	public String getReserveexp() {
		return this.reserveexp;
	}

	public void setReserveexp(String reserveexp) {
		this.reserveexp = reserveexp;
	}

	public String getBusinessname() {
		return this.businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinessurl() {
		return this.businessurl;
	}

	public void setBusinessurl(String businessurl) {
		this.businessurl = businessurl;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUnlimituser() {
		return this.unlimituser;
	}

	public void setUnlimituser(String unlimituser) {
		this.unlimituser = unlimituser;
	}

	public String getPrioritize() {
		return this.prioritize;
	}

	public void setPrioritize(String prioritize) {
		this.prioritize = prioritize;
	}

	public Timestamp getPstarttime() {
		return this.pstarttime;
	}

	public void setPstarttime(Timestamp pstarttime) {
		this.pstarttime = pstarttime;
	}

	public Timestamp getPendtime() {
		return this.pendtime;
	}

	public void setPendtime(Timestamp pendtime) {
		this.pendtime = pendtime;
	}

	public String getRemind() {
		return this.remind;
	}

	public void setRemind(String remind) {
		this.remind = remind;
	}

	public String getRemindcontent() {
		return this.remindcontent;
	}

	public void setRemindcontent(String remindcontent) {
		this.remindcontent = remindcontent;
	}

	public String getRemindtext() {
		return this.remindtext;
	}

	public void setRemindtext(String remindtext) {
		this.remindtext = remindtext;
	}

	public Timestamp getRemindtime() {
		return this.remindtime;
	}

	public void setRemindtime(Timestamp remindtime) {
		this.remindtime = remindtime;
	}

	public String getCheckprice() {
		return this.checkprice;
	}

	public void setCheckprice(String checkprice) {
		this.checkprice = checkprice;
	}

	public String getReserverlogo() {
		return this.reserverlogo;
	}

	public void setReserverlogo(String reserverlogo) {
		this.reserverlogo = reserverlogo;
	}

	public String getReservercolor() {
		return this.reservercolor;
	}

	public void setReservercolor(String reservercolor) {
		this.reservercolor = reservercolor;
	}

	public String getSharepic() {
		return this.sharepic;
	}

	public void setSharepic(String sharepic) {
		this.sharepic = sharepic;
	}

	public String getAppTopPic() {
		return this.appTopPic;
	}

	public void setAppTopPic(String appTopPic) {
		this.appTopPic = appTopPic;
	}

	public String getPcToText() {
		return this.pcToText;
	}

	public void setPcToText(String pcToText) {
		this.pcToText = pcToText;
	}

	public String getPcToLink() {
		return this.pcToLink;
	}

	public void setPcToLink(String pcToLink) {
		this.pcToLink = pcToLink;
	}

	public String getWapToText() {
		return this.wapToText;
	}

	public void setWapToText(String wapToText) {
		this.wapToText = wapToText;
	}

	public String getWapToLink() {
		return this.wapToLink;
	}

	public void setWapToLink(String wapToLink) {
		this.wapToLink = wapToLink;
	}

	public String getAppToText() {
		return this.appToText;
	}

	public void setAppToText(String appToText) {
		this.appToText = appToText;
	}

	public String getAppToLink() {
		return this.appToLink;
	}

	public void setAppToLink(String appToLink) {
		this.appToLink = appToLink;
	}

	public String getSellOutMark() {
		return this.sellOutMark;
	}

	public void setSellOutMark(String sellOutMark) {
		this.sellOutMark = sellOutMark;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getWplogo() {
		return this.wplogo;
	}

	public void setWplogo(String wplogo) {
		this.wplogo = wplogo;
	}

	public String getAutoseat() {
		return this.autoseat;
	}

	public void setAutoseat(String autoseat) {
		this.autoseat = autoseat;
	}

	public boolean isAuto() {
		return StringUtils.equals(this.autoseat, "Y");
	}

	public String getSecondtype() {
		return this.secondtype;
	}

	public void setSecondtype(String secondtype) {
		this.secondtype = secondtype;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getShortUrl() {
		return this.shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Integer getRemnantnum() {
		return this.remnantnum;
	}

	public void setRemnantnum(Integer remnantnum) {
		this.remnantnum = remnantnum;
	}

	public String getRemnantnotice() {
		return this.remnantnotice;
	}

	public void setRemnantnotice(String remnantnotice) {
		this.remnantnotice = remnantnotice;
	}
}