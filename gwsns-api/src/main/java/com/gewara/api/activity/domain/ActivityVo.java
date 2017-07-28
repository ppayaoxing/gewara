/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class ActivityVo extends BaseVo {
	private static final long serialVersionUID = -2350551869062213327L;
	public static final int TIME_CURRENT = 3;
	public static final int TIME_OVER = 2;
	public static final int TIME_ALL = 1;
	public static final int TIME_RECORD = 10;
	public static final String FLAG_TOP_HEAD = "tophead";
	public static final String FLAG_TOP_RELATED = "toprelated";
	public static final String FLAG_TOP_CATEGORY = "topcategory";
	public static final String FLAG_RECOMMEND = "recommend";
	public static final String FLAG_RECOMMEND_WAP = "redwap";
	public static final String FLAG_HOME = "home";
	public static final String FLAG_HOT = "hot";
	public static final String FLAG_APP_HEAD = "apphead";
	public static final String ATYPE_NOMARL = "common";
	public static final String ATYPE_USER = "user";
	public static final String ATYPE_BUSS = "buss";
	public static final String ATYPE_GEWA = "gewa";
	public static final Integer MAX_DAYS = Integer.valueOf(31);
	public static final String SIGN_PRICE5 = "price5";
	public static final String SIGN_PUBSALE = "pubsale";
	public static final String SIGN_STARMEET = "starmeet";
	public static final String SIGN_TROUPE = "troupe";
	public static final String SIGN_CLASS = "class";
	public static final String SIGN_ONLINE = "online";
	public static final String SIGN_RESERVE = "reserve";
	public static final String SIGN_DISCOUNT = "discount";
	public static final String SIGN_IMAX = "imax";
	public static final String SIGN_CINEPHILES = "cinephiles";
	public static final String SIGN_CINEMA = "cinema";
	public static final String SIGN_FILMREVIEWS = "filmreviews";
	public static final String SIGN_SPECIAL_NEW = "specialnew";
	public static final String TAG_ACTIVITY = "activity";
	public static final String OTHER_BINDMOBILE = "bindMobile";
	public static final String OTHER_BINDEMAIL = "bindEmail";
	public static final String OTHER_HASHEADURL = "hasHeadUrl";
	public static final String OTHER_HASADDRESS = "hasAddress";
	public static final String OTHER_WALA = "wala";
	public static final String OTHER_NEWMEMBER = "newMember";
	public static final String OTHER_USEPOINT = "usePoint";
	public static final String OTHER_TICKET = "ticket";
	public static final String OTHER_LONGWALA = "longWala";
	public static final String OTHER_EASYJOIN = "easyJoin";
	public static final String CLIENT_TYPE_PC = "PC";
	public static final String CLIENT_TYPE_WAP = "WAP";
	public static final String CLIENT_TYPE_IOS = "IOS";
	public static final String CLIENT_TYPE_ANDROID = "ANDROID";
	public static final String PC_SHOW_TYPE_DOWNLOAD = "DOWNLOAD";
	public static final String PC_SHOW_TYPE_HIDDEN = "HIDDEN";
	private Integer version;
	private Long id;
	private String title;
	private String contentdetail;
	private String atype;
	private Date startdate;
	private String starttime;
	private Date enddate;
	private String endtime;
	private String address;
	private String contactway;
	private String summary;
	private Integer capacity;
	private Long memberid;
	private Integer clickedtimes;
	private String citycode;
	private String countycode;
	private String indexareacode;
	private Timestamp addtime;
	private Long relatedid;
	private String tag;
	private String category;
	private Long categoryid;
	private Integer membercount;
	private String status;
	private Timestamp replytime;
	private Integer replycount;
	private Long replyid;
	private Long communityid;
	private Timestamp updatetime;
	private String flag;
	private String logo;
	private String priceinfo;
	private String searchkey;
	private String seotitle;
	private String seodescription;
	private String repeat;
	private String membername;
	private String replyname;
	private String sign;
	private Timestamp duetime;
	private String activityurl;
	private String mobilemsg;
	private String qq;
	private String needprepay;
	private Integer totalFee;
	private String joinLimit;
	private Timestamp fromtime;
	private Long signid;
	private String otherinfo;
	private Integer collectedtimes;
	private String linkman;
	private Integer memberLimit;
	private String ip;
	private String lotterytag;
	private Integer hotvalue;
	private Integer focusvalue;
	private String getCash;
	private String containMPI;
	private String containGoods;
	private String operated;
	private String getway;
	private String feetype;
	private String isOfficial;
	private String relateMobileUrl;
	private String firstLogo;
	private String clientType;
	private String showType;
	private String usePoint;
	private String joinForm;
	private String onlinePay;

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getJoinLimit() {
		return this.joinLimit;
	}

	public void setJoinLimit(String joinLimit) {
		this.joinLimit = joinLimit;
	}

	public String getMobilemsg() {
		return this.mobilemsg;
	}

	public void setMobilemsg(String mobilemsg) {
		this.mobilemsg = mobilemsg;
	}

	public String getActivityurl() {
		return this.activityurl;
	}

	public void setActivityurl(String activityurl) {
		this.activityurl = activityurl;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getReplyname() {
		return this.replyname;
	}

	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	public String getRepeat() {
		return this.repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getSearchkey() {
		return this.searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	public String getSeotitle() {
		return this.seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeodescription() {
		return this.seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public String getPriceinfo() {
		return this.priceinfo;
	}

	public void setPriceinfo(String priceinfo) {
		this.priceinfo = priceinfo;
	}

	public String getLogo() {
		return this.logo;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_activity.png" : this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public ActivityVo() {
		this.memberLimit = Integer.valueOf(0);
		this.hotvalue = Integer.valueOf(0);
		this.focusvalue = Integer.valueOf(0);
	}

	public ActivityVo(Long memberid) {
		this.memberLimit = Integer.valueOf(0);
		this.hotvalue = Integer.valueOf(0);
		this.focusvalue = Integer.valueOf(0);
		this.memberid = memberid;
		this.membercount = Integer.valueOf(0);
		this.clickedtimes = Integer.valueOf(0);
		this.collectedtimes = Integer.valueOf(0);
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = new Timestamp(System.currentTimeMillis());
		this.replycount = Integer.valueOf(0);
		this.communityid = Long.valueOf(0L);
		this.atype = "common";
		this.hotvalue = Integer.valueOf(0);
		this.focusvalue = Integer.valueOf(0);
	}

	public ActivityVo(String atype, Long memberid, Date startdate, String starttime, String tag, Long relatedid,
			String category, Long categoryid) {
		this(memberid);
		this.atype = atype;
		this.startdate = startdate;
		this.starttime = starttime;
		this.tag = tag;
		this.relatedid = relatedid;
		this.category = category;
		this.categoryid = categoryid;
		this.hotvalue = Integer.valueOf(0);
		this.focusvalue = Integer.valueOf(0);
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getContactway() {
		return this.contactway;
	}

	public void setContactway(String contactway) {
		this.contactway = contactway;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getMembercount() {
		return this.membercount;
	}

	public void setMembercount(Integer membercount) {
		this.membercount = membercount;
	}

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public String getDtag() {
		return this.categoryid != null ? this.category : this.tag;
	}

	public Long getDrelatedid() {
		return this.categoryid != null ? this.categoryid : this.relatedid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Timestamp replytime) {
		this.replytime = replytime;
	}

	public Integer getReplycount() {
		return this.replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public Long getCommunityid() {
		return this.communityid;
	}

	public void setCommunityid(Long communityid) {
		this.communityid = communityid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getContentdetail() {
		return this.contentdetail;
	}

	public void setContentdetail(String contentdetail) {
		char char8 = 8;
		this.contentdetail = StringUtils.replaceChars(contentdetail, char8, ' ');
	}

	public String getName() {
		return this.title;
	}

	public Timestamp getDuetime() {
		return this.duetime;
	}

	public void setDuetime(Timestamp duetime) {
		this.duetime = duetime;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNeedprepay() {
		return this.needprepay;
	}

	public void setNeedprepay(String needprepay) {
		this.needprepay = needprepay;
	}

	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Timestamp getFromtime() {
		return this.fromtime;
	}

	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}

	public Integer getCollectedtimes() {
		return this.collectedtimes;
	}

	public void setCollectedtimes(Integer collectedtimes) {
		this.collectedtimes = collectedtimes;
	}

	public Long getSignid() {
		return this.signid;
	}

	public void setSignid(Long signid) {
		this.signid = signid;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Integer getMemberLimit() {
		return this.memberLimit;
	}

	public void setMemberLimit(Integer memberLimit) {
		this.memberLimit = memberLimit;
	}

	public String[] joinLimit() {
		if (StringUtils.isNotBlank(this.joinLimit)) {
			String[] strs = StringUtils.split(this.joinLimit, ",");
			return strs;
		} else {
			return new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		}
	}

	public void addJoinnum(Integer joinnum) {
		this.membercount = Integer.valueOf(this.membercount.intValue() + joinnum.intValue());
		if (this.membercount.intValue() < 0) {
			this.membercount = Integer.valueOf(0);
		}

	}

	public void cutJoinnum(Integer cutNum) {
		this.membercount = Integer.valueOf(this.membercount.intValue() - cutNum.intValue());
		if (this.membercount.intValue() < 0) {
			this.membercount = Integer.valueOf(0);
		}

	}

	public void addReplycount() {
		this.replycount = Integer.valueOf(this.replycount.intValue() + 1);
	}

	public String getTitle2() {
		if ("1".equals(this.atype)) {
			if (StringUtils.isBlank(this.title)) {
				StringBuilder sb = new StringBuilder();
				sb.append(DateUtil.formatDate(this.startdate));
				if (StringUtils.isNotBlank(this.address)) {
					sb.append(this.address);
				}

				return sb.toString();
			} else {
				return this.title;
			}
		} else {
			return this.title;
		}
	}

	public String getDateRange(String splitor) {
		String str1 = DateUtil.format(this.startdate, "M月d日");
		String str2 = this.enddate == null ? "" : DateUtil.format(this.enddate, "M月d日");
		return !StringUtils.isBlank(str2) && !StringUtils.equals(str1, str2) ? str1 + splitor + str2 : str1;
	}

	public String getTimeRange(String splitor) {
		return StringUtils.isBlank(this.starttime) ? ""
				: (StringUtils.isBlank(this.endtime) ? this.starttime : this.starttime + splitor + this.endtime);
	}

	public Timestamp getActivityStartTime() {
		String activitytime1 = DateUtil.formatDate(this.startdate);
		String activitytime2 = "";
		if (StringUtils.isNotBlank(this.starttime)) {
			activitytime2 = this.starttime + ":00";
		} else {
			activitytime2 = "00:00:00";
		}

		Timestamp agendatime = DateUtil.parseTimestamp(activitytime1 + " " + activitytime2);
		return agendatime;
	}

	public Timestamp getActivityEndTime() {
		String activitytime1 = DateUtil.formatDate(this.enddate);
		String activitytime2 = "";
		if (StringUtils.isNotBlank(this.endtime)) {
			activitytime2 = this.endtime + ":00";
		} else {
			activitytime2 = "00:00:00";
		}

		Timestamp agendatime = DateUtil.parseTimestamp(activitytime1 + " " + activitytime2);
		return agendatime;
	}

	public String getHeadHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<span>" + DateUtil.format(this.startdate, "MM-dd"));
		if (this.enddate != null) {
			sb.append("至" + DateUtil.format(this.enddate, "MM-dd"));
		}

		sb.append("</span>");
		if (StringUtils.isNotBlank(this.starttime)) {
			sb.append("<span class=\'ml5\'>" + this.starttime);
			if (StringUtils.isNotBlank(this.endtime)) {
				sb.append("-" + this.endtime);
			}

			sb.append("</span>");
		}

		return sb.toString();
	}

	public String getUrl() {
		return "activity/" + this.id;
	}

	public String getCname() {
		return this.title;
	}

	public boolean isPreStart() {
		if (this.getActivityStartTime() != null && this.duetime != null) {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.duetime.before(cur) && this.getActivityStartTime().after(cur);
		} else {
			return false;
		}
	}

	public boolean isProcessing() {
		if (this.getActivityStartTime() != null && this.getActivityEndTime() != null) {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.getActivityEndTime().after(cur) && this.getActivityStartTime().before(cur);
		} else {
			return false;
		}
	}

	public boolean isJoining() {
		if (this.fromtime != null && this.duetime != null) {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.duetime.after(cur) && this.fromtime.before(cur) && this.isValid();
		} else {
			return false;
		}
	}

	public boolean isValid() {
		return "Y_NEW".equals(this.status) || "Y_PROCESS".equals(this.status);
	}

	public boolean isStop() {
		return StringUtils.equals("Y_STOP", this.status);
	}

	public boolean isEnd() {
		if (this.enddate != null) {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.getActivityEndTime().before(cur);
		} else {
			return false;
		}
	}

	public boolean isStart() {
		if (null == this.fromtime) {
			return false;
		} else {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.fromtime.after(cur);
		}
	}

	public void updateSearchKey() {
		this.searchkey = this.title;
	}

	public void addCollectedtimes() {
		this.collectedtimes = Integer.valueOf(this.collectedtimes.intValue() + 1);
	}

	public void cutCollectedtimes(Integer cutNum) {
		this.collectedtimes = Integer.valueOf(this.collectedtimes.intValue() - cutNum.intValue());
		if (this.collectedtimes.intValue() < 0) {
			this.collectedtimes = Integer.valueOf(0);
		}

	}

	public boolean isApply() {
		if (this.fromtime == null) {
			return false;
		} else {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			Timestamp applyTime = (Timestamp) DateUtil.addMinute(this.fromtime, -30);
			return applyTime.after(cur);
		}
	}

	public String getLotterytag() {
		return this.lotterytag;
	}

	public void setLotterytag(String lotterytag) {
		this.lotterytag = lotterytag;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public String getContainMPI() {
		return this.containMPI;
	}

	public void setContainMPI(String containMPI) {
		this.containMPI = containMPI;
	}

	public String getContainGoods() {
		return this.containGoods;
	}

	public void setContainGoods(String containGoods) {
		this.containGoods = containGoods;
	}

	public String getFirstLogo() {
		return this.firstLogo;
	}

	public void setFirstLogo(String firstLogo) {
		this.firstLogo = firstLogo;
	}

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Boolean isMobileOnly() {
		return !StringUtils.isEmpty(this.clientType) && !StringUtils.contains(this.clientType, "PC")
				? Boolean.valueOf(true) : Boolean.valueOf(false);
	}

	public String getOperated() {
		return this.operated;
	}

	public void setOperated(String operated) {
		this.operated = operated;
	}

	public Integer getFocusvalue() {
		return this.focusvalue;
	}

	public void setFocusvalue(Integer focusvalue) {
		this.focusvalue = focusvalue;
	}

	public String getGetway() {
		return this.getway;
	}

	public void setGetway(String getway) {
		this.getway = getway;
	}

	public String getShowType() {
		return this.showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getFeetype() {
		return this.feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public String getGetCash() {
		return this.getCash;
	}

	public void setGetCash(String getCash) {
		this.getCash = getCash;
	}

	public String getIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public String getUsePoint() {
		return this.usePoint;
	}

	public void setUsePoint(String usePoint) {
		this.usePoint = usePoint;
	}

	public String getJoinForm() {
		return this.joinForm;
	}

	public void setJoinForm(String joinForm) {
		this.joinForm = joinForm;
	}

	public String getOnlinePay() {
		return this.onlinePay;
	}

	public void setOnlinePay(String onlinePay) {
		this.onlinePay = onlinePay;
	}

	public boolean isOver() {
		return this.enddate != null ? DateUtil.addDay(new Date(), -1).after(this.enddate)
				: (this.startdate == null ? true : DateUtil.addDay(new Date(), -1).after(this.startdate));
	}

	public boolean isOver2() {
		if (this.enddate != null && StringUtils.isNotBlank(this.endtime)) {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			String strDate = DateUtil.formatDate(this.enddate) + " " + this.endtime + ":00";
			return DateUtil.parseTimestamp(strDate).before(cur);
		} else {
			return false;
		}
	}

	public boolean isPlaying() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return this.duetime != null && this.fromtime != null ? this.duetime.after(cur) && this.fromtime.before(cur)
				: false;
	}

	public String getRelateMobileUrl() {
		return this.relateMobileUrl;
	}

	public void setRelateMobileUrl(String relateMobileUrl) {
		this.relateMobileUrl = relateMobileUrl;
	}
}