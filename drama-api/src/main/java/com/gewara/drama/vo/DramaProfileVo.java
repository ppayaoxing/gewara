package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.Status;

public class DramaProfileVo extends BaseVo {

	private static final long serialVersionUID = 2713318692410184246L;
	private Long dramaid;
	private String limittype;			//限制类型（每天，每个场次，项目周期）
	private Integer limitnum;			//限制张数
	private String limitsite;			//限制站点:Web, Wap
	private String uniqueby;			//限制唯一标识
	private String itemid;				//限制场次ID集合
	private String opustype;			//作品类型(Y音频)
	private String opuslink;
	private String reserve;				//是否可预约(Y,N)
	private String validorder;			//预约验证订单(Y,N)
	private Integer rmaxnum;			//单次可预约最大人数
	private Integer rlimitnum;			//总预约次数
	private Integer delayedday;			//延迟天数
	private Timestamp rstarttime;		//预约开放开始时间
	private Timestamp rendtime;			//预约开放结束时间
	private Date rstartdate;			//预约开始日期
	private String reserveexp;
	private String businessname;		//预约合作商户名称
	private String businessurl;			//预约合作商户网址
	private String remind;				//开票提醒
	private String remindcontent;		//提醒内容
	private String remindtext;			//提醒内容2
	private Timestamp remindtime;		//开票提醒时间
	private Timestamp addtime;
	private Timestamp updatetime;

	private String unlimituser; 		//不受限制用户
	private String prioritize;			//优先购
	private Timestamp pstarttime;
	private Timestamp pendtime;
	private String checkprice;			//预约验证价格(Y,N)
	private String reserverlogo;		//预约背景图
	private String reservercolor;		//预约背景色
	private String sharepic;  			//项目分享图片
	private String appTopPic;
	private String pcToText;
	private String pcToLink;
	private String wapToText;
	private String wapToLink;
	private String appToText;
	private String appToLink;
	private String sellOutMark;

	private String wplogo;				//第三方海报logo
	private String origin;
	private String autoseat;			//Y/N
	private String secondtype;			//第二类型
	
	private String domain;		//短链接域名
	private String shortUrl;	//短链接访问地址
	private Integer remnantnum;		//余票提醒限制数量
	private String remnantnotice;	//余票提醒文案
	
	@Override
	public Serializable realId() {
		return dramaid;
	}

	public String getWpLimg(){
		if(StringUtils.isBlank(wplogo)) return "img/default_logo.png";
		return wplogo;
	}
	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getLimittype() {
		return limittype;
	}

	public void setLimittype(String limittype) {
		this.limittype = limittype;
	}

	public Integer getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public String getLimitsite() {
		return limitsite;
	}

	public void setLimitsite(String limitsite) {
		this.limitsite = limitsite;
	}

	public String getUniqueby() {
		return uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getOpustype() {
		return opustype;
	}

	public void setOpustype(String opustype) {
		this.opustype = opustype;
	}

	public String getOpuslink() {
		return opuslink;
	}

	public void setOpuslink(String opuslink) {
		this.opuslink = opuslink;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public String getValidorder() {
		return validorder;
	}

	public void setValidorder(String validorder) {
		this.validorder = validorder;
	}

	public Integer getRmaxnum() {
		return rmaxnum;
	}

	public void setRmaxnum(Integer rmaxnum) {
		this.rmaxnum = rmaxnum;
	}

	public Integer getRlimitnum() {
		return rlimitnum;
	}

	public void setRlimitnum(Integer rlimitnum) {
		this.rlimitnum = rlimitnum;
	}

	public Integer getDelayedday() {
		return delayedday;
	}

	public void setDelayedday(Integer delayedday) {
		this.delayedday = delayedday;
	}

	public Timestamp getRstarttime() {
		return rstarttime;
	}

	public void setRstarttime(Timestamp rstarttime) {
		this.rstarttime = rstarttime;
	}

	public Timestamp getRendtime() {
		return rendtime;
	}

	public void setRendtime(Timestamp rendtime) {
		this.rendtime = rendtime;
	}

	public Date getRstartdate() {
		return rstartdate;
	}

	public void setRstartdate(Date rstartdate) {
		this.rstartdate = rstartdate;
	}

	public String getReserveexp() {
		return reserveexp;
	}

	public void setReserveexp(String reserveexp) {
		this.reserveexp = reserveexp;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinessurl() {
		return businessurl;
	}

	public void setBusinessurl(String businessurl) {
		this.businessurl = businessurl;
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

	public String getUnlimituser() {
		return unlimituser;
	}

	public void setUnlimituser(String unlimituser) {
		this.unlimituser = unlimituser;
	}

	public String getPrioritize() {
		return prioritize;
	}

	public void setPrioritize(String prioritize) {
		this.prioritize = prioritize;
	}

	public Timestamp getPstarttime() {
		return pstarttime;
	}

	public void setPstarttime(Timestamp pstarttime) {
		this.pstarttime = pstarttime;
	}

	public Timestamp getPendtime() {
		return pendtime;
	}

	public void setPendtime(Timestamp pendtime) {
		this.pendtime = pendtime;
	}

	public String getRemind() {
		return remind;
	}

	public void setRemind(String remind) {
		this.remind = remind;
	}

	public String getRemindcontent() {
		return remindcontent;
	}

	public void setRemindcontent(String remindcontent) {
		this.remindcontent = remindcontent;
	}

	public String getRemindtext() {
		return remindtext;
	}

	public void setRemindtext(String remindtext) {
		this.remindtext = remindtext;
	}

	public Timestamp getRemindtime() {
		return remindtime;
	}

	public void setRemindtime(Timestamp remindtime) {
		this.remindtime = remindtime;
	}

	public String getCheckprice() {
		return checkprice;
	}

	public void setCheckprice(String checkprice) {
		this.checkprice = checkprice;
	}
	public String getReserverlogo() {
		return reserverlogo;
	}

	public void setReserverlogo(String reserverlogo) {
		this.reserverlogo = reserverlogo;
	}

	public String getReservercolor() {
		return reservercolor;
	}

	public void setReservercolor(String reservercolor) {
		this.reservercolor = reservercolor;
	}
	public String getSharepic() {
		return sharepic;
	}

	public void setSharepic(String sharepic) {
		this.sharepic = sharepic;
	}

	public String getAppTopPic() {
		return appTopPic;
	}

	public void setAppTopPic(String appTopPic) {
		this.appTopPic = appTopPic;
	}

	public String getPcToText() {
		return pcToText;
	}

	public void setPcToText(String pcToText) {
		this.pcToText = pcToText;
	}

	public String getPcToLink() {
		return pcToLink;
	}

	public void setPcToLink(String pcToLink) {
		this.pcToLink = pcToLink;
	}

	public String getWapToText() {
		return wapToText;
	}

	public void setWapToText(String wapToText) {
		this.wapToText = wapToText;
	}

	public String getWapToLink() {
		return wapToLink;
	}

	public void setWapToLink(String wapToLink) {
		this.wapToLink = wapToLink;
	}

	public String getAppToText() {
		return appToText;
	}

	public void setAppToText(String appToText) {
		this.appToText = appToText;
	}

	public String getAppToLink() {
		return appToLink;
	}

	public void setAppToLink(String appToLink) {
		this.appToLink = appToLink;
	}

	public String getSellOutMark() {
		return sellOutMark;
	}

	public void setSellOutMark(String sellOutMark) {
		this.sellOutMark = sellOutMark;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getWplogo() {
		return wplogo;
	}

	public void setWplogo(String wplogo) {
		this.wplogo = wplogo;
	}

	public String getAutoseat() {
		return autoseat;
	}

	public void setAutoseat(String autoseat) {
		this.autoseat = autoseat;
	}
	
	public boolean isAuto() {
		return StringUtils.equals(this.autoseat, Status.Y);
	}
	
	public String getSecondtype() {
		return secondtype;
	}

	public void setSecondtype(String secondtype) {
		this.secondtype = secondtype;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Integer getRemnantnum() {
		return remnantnum;
	}

	public void setRemnantnum(Integer remnantnum) {
		this.remnantnum = remnantnum;
	}

	public String getRemnantnotice() {
		return remnantnotice;
	}

	public void setRemnantnotice(String remnantnotice) {
		this.remnantnotice = remnantnotice;
	}
	
}
