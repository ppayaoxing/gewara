package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.activity.constant.Status;
import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

public class ActivityVo extends BaseVo{
	private static final long serialVersionUID = -2350551869062213327L;
	public static final int TIME_CURRENT = 3; // 未锟斤拷锟节的活动
	public static final int TIME_OVER = 2; // 锟斤拷锟节ｏ拷锟斤拷锟斤拷锟斤拷锟侥活动
	public static final int TIME_ALL = 1; // 锟斤拷锟叫活动
	public static final int TIME_RECORD = 10; // 
	public static final String FLAG_TOP_HEAD = "tophead";// 锟斤拷锟斤拷坛锟矫讹拷
	public static final String FLAG_TOP_RELATED = "toprelated";// 锟斤拷锟斤拷坛锟矫讹拷
	public static final String FLAG_TOP_CATEGORY = "topcategory";// 锟斤拷锟斤拷坛锟斤拷锟斤拷目锟矫讹拷
	public static final String FLAG_RECOMMEND = "recommend";// 锟狡硷拷
	public static final String FLAG_RECOMMEND_WAP = "redwap";// 锟狡硷拷锟街伙拷
	public static final String FLAG_HOME = "home";// 锟斤拷页
	public static final String FLAG_HOT = "hot";// 锟斤拷锟斤拷
	public static final String FLAG_APP_HEAD = "apphead";// app锟狡硷拷
	public static final String ATYPE_NOMARL = "common"; //锟斤拷通锟筋动
	public static final String ATYPE_USER = "user"; // 锟矫伙拷锟筋动锟斤拷锟斤拷证锟矫伙拷
	public static final String ATYPE_BUSS = "buss"; // 锟教家活动锟斤拷锟斤拷锟届方
	public static final String ATYPE_GEWA = "gewa"; // gewa锟筋动锟斤拷锟劫凤拷
	public static final Integer MAX_DAYS = 31; //锟筋动锟斤拷始时锟斤拷锟斤拷锟斤拷锟斤拷冢锟斤拷疃拷锟斤拷锟绞憋拷锟�-锟筋动锟斤拷始时锟斤拷
	public static final String SIGN_PRICE5 = "price5"; // 5元锟斤拷票
	public static final String SIGN_PUBSALE = "pubsale";	// 锟斤拷锟斤拷
	public static final String SIGN_STARMEET = "starmeet";// 锟斤拷锟角硷拷锟斤拷锟�
	public static final String SIGN_TROUPE = "troupe";// 追锟斤拷锟斤拷
	public static final String SIGN_CLASS = "class";// 锟斤拷锟斤拷锟斤拷
	public static final String SIGN_ONLINE = "online";// 锟斤拷锟较活动
	public static final String SIGN_RESERVE = "reserve";//约战
	public static final String SIGN_DISCOUNT = "discount";//锟脚伙拷
	public static final String SIGN_IMAX = "imax";//IMAX
	public static final String SIGN_CINEPHILES = "cinephiles";//一群影锟皆ｏ拷锟斤拷影锟脚ｏ拷
	public static final String SIGN_CINEMA = "cinema";// 影院锟筋动
	public static final String SIGN_FILMREVIEWS = "filmreviews";// 写影锟斤拷锟筋动
	public static final String SIGN_SPECIAL_NEW = "specialnew";// 专锟斤拷疃�
	public static final String TAG_ACTIVITY = "activity";
	public static final String OTHER_BINDMOBILE = "bindMobile";	//锟矫伙拷锟轿加活动锟斤拷锟斤拷只锟�
	public static final String OTHER_BINDEMAIL = "bindEmail";	//锟矫伙拷锟轿加活动锟斤拷锟斤拷锟斤拷锟�
	public static final String OTHER_HASHEADURL = "hasHeadUrl";	//锟矫伙拷锟轿加活动锟斤拷锟较达拷头锟斤拷
	public static final String OTHER_HASADDRESS = "hasAddress";	//锟矫伙拷锟轿加活动锟斤拷锟斤拷写锟斤拷址
	public static final String OTHER_WALA = "wala";				//锟矫伙拷锟轿加活动锟斤拷锟斤拷芊锟絎ALA
	public static final String OTHER_NEWMEMBER = "newMember";	//锟斤拷锟矫伙拷锟斤拷锟杰参加活动
	public static final String OTHER_USEPOINT = "usePoint";		//锟矫伙拷锟轿加活动锟斤拷锟斤拷锟侥伙拷锟斤拷
	public static final String OTHER_TICKET = "ticket";			//锟斤拷锟斤拷锟截讹拷锟斤拷影锟矫伙拷锟斤拷锟杰参硷拷
	public static final String OTHER_LONGWALA = "longWala";		//锟斤拷楼锟筋动锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String OTHER_EASYJOIN = "easyJoin";		//锟津单参加活动锟斤拷锟斤拷锟斤拷锟斤拷写锟斤拷锟斤拷锟斤拷息
	
	public static final String CLIENT_TYPE_PC = "PC";
	
	public static final String CLIENT_TYPE_WAP = "WAP";
	
	public static final String CLIENT_TYPE_IOS = "IOS";
	
	public static final String CLIENT_TYPE_ANDROID = "ANDROID";
	
	/** 锟斤拷PC锟筋动PC锟斤拷-(锟斤拷锟斤拷) */
	public static final String PC_SHOW_TYPE_DOWNLOAD = "DOWNLOAD";
	
	/** 锟斤拷PC锟筋动PC锟斤拷-(锟斤拷锟斤拷示) */
	public static final String PC_SHOW_TYPE_HIDDEN   = "HIDDEN";
	
	private Integer version;			//锟斤拷锟铰版本
	private Long id;
	private String title;// 锟斤拷锟斤拷
	private String contentdetail;// 锟斤拷锟斤拷
	private String atype;// 锟斤拷锟斤拷,值为锟斤拷锟斤拷 ATYPE_*锟叫碉拷一锟斤拷
	private Date startdate;
	private String starttime;
	private Date enddate;
	private String endtime;
	private String address;
	private String contactway;// 锟斤拷系锟斤拷式
	private String summary;// 锟狡硷拷说锟斤拷
	private Integer capacity;
	private Long memberid;// 锟斤拷锟斤拷锟斤拷
	private Integer clickedtimes;
	private String citycode; //310000,330100,330200
	private String countycode;
	private String indexareacode;
	private Timestamp addtime;
	private Long relatedid;
	private String tag;
	private String category;
	private Long categoryid;
	private Integer membercount;//锟窖参加活动锟斤拷锟斤拷
	private String status;//N_DELETE锟斤拷删锟斤拷,N_AUDIT锟斤拷锟轿赐拷锟�,Y_STOP停止锟斤拷锟斤拷,Y_PROCESS锟斤拷锟斤拷锟斤拷锟斤拷锟皆憋拷锟斤拷,Y_TREAT锟斤拷锟斤拷锟斤拷,Y_CREATED锟斤拷锟斤拷
	private Timestamp replytime;
	private Integer replycount;
	private Long replyid;// 锟截革拷锟斤拷
	private Long communityid;// 圈锟斤拷
	private Timestamp updatetime;
	private String flag;	//recommend锟狡硷拷锟斤拷站,redwap锟狡硷拷wap,hot锟斤拷品,tophead锟矫讹拷,renzheng锟斤拷证锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷","锟街革拷
	private String logo;
	private String priceinfo;//锟斤拷锟斤拷锟斤拷息
	//锟斤拷锟斤拷锟斤拷
	private String searchkey;
	private String seotitle;
	private String seodescription;
	private String repeat;
	private String membername;
	private String replyname;
	private String sign; //锟筋动锟斤拷识 ,值为锟斤拷锟斤拷SIGN_*锟叫碉拷一锟斤拷
	private Timestamp duetime; // 锟斤拷锟斤拷锟斤拷止时锟斤拷
	private String activityurl;// 锟斤拷锟较活动锟斤拷锟斤拷锟斤拷址
	private String mobilemsg;//锟筋动锟街伙拷锟斤拷锟斤拷
	private String qq;//锟斤拷系qq锟斤拷
	
	// 20101111 hubo 锟斤拷踊疃わ拷锟斤拷锟�
	private String needprepay;		// 锟角凤拷预锟斤拷锟斤拷
	
	private Integer totalFee;	// 锟斤拷时锟斤拷锟斤拷, 锟斤拷锟斤拷没疃拷艿锟斤拷辗锟�
	private String joinLimit;	//锟矫伙拷锟轿加活动时锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	
	//20110829
	private Timestamp fromtime; //锟筋动锟斤拷锟斤拷锟斤拷始时锟斤拷
	//20120420
	private Long signid;//sign锟斤拷锟斤拷锟斤拷锟絠d锟斤拷5元锟斤拷票锟斤拷1元锟斤拷锟斤拷时使锟斤拷
	private String otherinfo;//{"bindMobile":"Y","bindEmail":"Y","hasHeadUrl":"Y","hasAddress":"Y","wala":"Y","newMember":"Y","usePoint":"12","ticket":"123","longWala":"Y","easyJoin":"Y"}
							 //锟斤拷锟街伙拷                              锟斤拷email        锟较达拷头锟斤拷                         锟矫伙拷锟斤拷址                         锟轿加诧拷锟杰回革拷锟斤拷锟斤拷                                 锟矫伙拷锟斤拷锟斤拷                      锟截讹拷锟斤拷影id      锟斤拷楼                            锟津单参硷拷
	private Integer collectedtimes;//锟斤拷锟斤拷趣
	private String linkman;//锟斤拷系锟斤拷
	private Integer memberLimit=0;//锟筋动锟斤拷锟斤拷锟斤拷
	private String ip;
	
	private String lotterytag;	//锟介奖锟斤拷识
	
	private Integer hotvalue=0;
	
	private Integer focusvalue=0;//锟斤拷吖锟阶拷锟斤拷萍锟�
	private String getCash;//锟斤拷锟斤拷锟斤拷锟斤拷
	private String containMPI;				//锟角凤拷锟叫筹拷锟斤拷
	private String containGoods;			//锟角凤拷锟斤拷锟秸凤拷锟斤拷品
	private String operated;			//锟筋动锟斤拷锟斤拷锟角否被诧拷锟斤拷锟斤拷 (Y 锟斤拷锟斤拷锟斤拷)
	private String getway;		//锟斤拷锟阶凤拷式
	private String feetype;
	private String isOfficial;
	private String relateMobileUrl;
	
	/**
	 * 锟筋动锟斤拷一锟斤拷图
	 */
	private String firstLogo;
	
	/**
	 * 锟酵伙拷锟斤拷锟斤拷示锟斤拷锟斤拷(PC,WAP,IOS,ANDROID)
	 */
	private String clientType;
	
	/**
	 * 锟斤拷PC锟筋动锟斤拷PC锟斤拷锟斤拷示锟斤拷式(锟斤拷锟斤拷示/锟斤拷锟斤拷)
	 * @return
	 */
	private String showType;
	
	private String usePoint;
	private String joinForm;
	private String onlinePay;		//锟斤拷锟斤拷支锟斤拷
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getJoinLimit() {
		return joinLimit;
	}
	public void setJoinLimit(String joinLimit) {
		this.joinLimit = joinLimit;
	}
	public String getMobilemsg() {
		return mobilemsg;
	}
	public void setMobilemsg(String mobilemsg) {
		this.mobilemsg = mobilemsg;
	}
	public String getActivityurl() {
		return activityurl;
	}
	public void setActivityurl(String activityurl) {
		this.activityurl = activityurl;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getReplyname() {
		return replyname;
	}
	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}
	public String getRepeat() {
		return repeat;
	}
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getSeotitle() {
		return seotitle;
	}
	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}
	public String getSeodescription() {
		return seodescription;
	}
	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}
	public String getPriceinfo() {
		return priceinfo;
	}
	public void setPriceinfo(String priceinfo) {
		this.priceinfo = priceinfo;
	}
	public String getLogo() {
		return logo;
	}
	public String getLimg() {
		if(StringUtils.isBlank(logo)) {
            return "img/default_activity.png";
        }
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getClickedtimes() {
		return clickedtimes;
	}
	public ActivityVo(){}
	
	public ActivityVo(Long memberid){
		this.memberid = memberid;
		this.membercount = 0;
		this.clickedtimes = 0 ;
		this.collectedtimes = 0;
		//this.status = Status.Y_PROCESS;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = new Timestamp(System.currentTimeMillis());
		this.replycount = 0;
		this.communityid = 0L;
		this.atype = ATYPE_NOMARL;
		this.hotvalue = 0;
		this.focusvalue = 0;
	}
	public ActivityVo(String atype, Long memberid, Date startdate, String starttime, 
			String tag, Long relatedid, String category, Long categoryid){
		this(memberid);
		this.atype = atype;
		this.startdate = startdate;
		this.starttime = starttime;
		this.tag = tag;
		this.relatedid = relatedid;
		this.category = category;
		this.categoryid = categoryid;
		this.hotvalue = 0;
		this.focusvalue = 0;
	}
	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCitycode() {
		return citycode;
	}
	
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
	public String getCountycode() {
		return countycode;
	}
	
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public String getContactway() {
		return contactway;
	}
	public void setContactway(String contactway) {
		this.contactway = contactway;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getMembercount() {
		return membercount;
	}
	public void setMembercount(Integer membercount) {
		this.membercount = membercount;
	}
	public String getIndexareacode() {
		return indexareacode;
	}
	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}
	public String getDtag(){
		if(this.categoryid != null) {
            return category;
        }
		return tag;
	}
	public Long getDrelatedid(){
		if(this.categoryid != null) {
            return categoryid;
        }
		return relatedid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getReplytime() {
		return replytime;
	}
	public void setReplytime(Timestamp replytime) {
		this.replytime = replytime;
	}
	public Integer getReplycount() {
		return replycount;
	}
	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}
	public Long getCommunityid() {
		return communityid;
	}
	public void setCommunityid(Long communityid) {
		this.communityid = communityid;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getReplyid() {
		return replyid;
	}
	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getContentdetail() {
		return contentdetail;
	}
	public void setContentdetail(String contentdetail) {
		//this.contentdetail = contentdetail;
		char char8 = 8;//锟斤拷锟捷帮拷锟斤拷锟斤拷锟街凤拷""时锟斤拷锟接口斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		this.contentdetail = StringUtils.replaceChars(contentdetail, char8, ' ');
	}
	public String getName(){
		return this.title;
	}
	public Timestamp getDuetime() {
		return duetime;
	}
	public void setDuetime(Timestamp duetime) {
		this.duetime = duetime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getNeedprepay() {
		return needprepay;
	}
	public void setNeedprepay(String needprepay) {
		this.needprepay = needprepay;
	}
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Timestamp getFromtime() {
		return fromtime;
	}
	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}
	public Integer getCollectedtimes() {
		return collectedtimes;
	}
	public void setCollectedtimes(Integer collectedtimes) {
		this.collectedtimes = collectedtimes;
	}
	public Long getSignid() {
		return signid;
	}
	public void setSignid(Long signid) {
		this.signid = signid;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}	
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public Integer getMemberLimit() {
		return memberLimit;
	}
	public void setMemberLimit(Integer memberLimit) {
		this.memberLimit = memberLimit;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~锟斤拷锟斤拷锟斤拷锟斤拷~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String[] joinLimit(){
		if(StringUtils.isNotBlank(joinLimit)){
			String[] strs = StringUtils.split(joinLimit, ",");
			return strs;
		}else {
			return new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9" ,"10"};
		}
	}
	public void addJoinnum(Integer joinnum) {
		this.membercount += joinnum;
		if(this.membercount<0) {
            this.membercount = 0;
        }
	}
	
	/**
	 * 锟斤拷锟劫参硷拷锟斤拷锟斤拷
	 * @param cutNum
	 */
	public void cutJoinnum(Integer cutNum){
		this.membercount -= cutNum;
		if(this.membercount<0) {
            this.membercount = 0;
        }
	}
	

	/**
	 * 锟截革拷锟斤拷+1
	 */
	public void addReplycount(){
		this.replycount += 1;
	}
	
	public String getTitle2(){
		if("1".equals(this.atype)){
			if(StringUtils.isBlank(this.title)){
				StringBuilder sb = new StringBuilder();
				sb.append(DateUtil.formatDate(this.startdate));
				if(StringUtils.isNotBlank(this.address)){
					sb.append(this.address);
				}
				return sb.toString();
			}
			return this.title;
		}
		return this.title;
	}
	public String getDateRange(String splitor){
		String str1 = DateUtil.format(startdate, "M锟斤拷d锟斤拷");
		String str2 = (enddate==null ? "": DateUtil.format(enddate, "M锟斤拷d锟斤拷"));
		if(StringUtils.isBlank(str2) || StringUtils.equals(str1, str2)) {
            return str1;
        }
		return str1+splitor+str2;
	}
	public String getTimeRange(String splitor){
		if(StringUtils.isBlank(starttime)) {
            return "";
        }
		if(StringUtils.isBlank(endtime)) {
            return starttime;
        }
		return starttime + splitor + endtime;
	}
	
	/**
	 * 锟斤拷取锟筋动锟斤拷始时锟斤拷
	 * @return
	 */
	public Timestamp getActivityStartTime(){
		String activitytime1 = DateUtil.formatDate(this.startdate);
		String activitytime2 ="";
		if(StringUtils.isNotBlank(this.starttime)){
			activitytime2 = this.starttime +":00"; 
		}else {
			activitytime2 = "00:00:00";
		}
		Timestamp agendatime = DateUtil.parseTimestamp(activitytime1 +" "+activitytime2);
		return agendatime;
	}
	
	/**
	 * 锟斤拷取锟筋动锟斤拷锟斤拷时锟斤拷
	 * @return
	 */
	public Timestamp getActivityEndTime(){
		String activitytime1 = DateUtil.formatDate(this.enddate);
		String activitytime2 ="";
		if(StringUtils.isNotBlank(this.endtime)){
			activitytime2 = this.endtime +":00"; 
		}else {
			activitytime2 = "00:00:00";
		}
		Timestamp agendatime = DateUtil.parseTimestamp(activitytime1 +" "+activitytime2);
		return agendatime;
	}
	public String getHeadHtml(){
		StringBuilder sb = new StringBuilder();
		sb.append("<span>" + DateUtil.format(startdate, "MM-dd"));
		if(enddate != null) {
            sb.append("锟斤拷" + DateUtil.format(enddate, "MM-dd"));
        }
		sb.append("</span>");
		if(StringUtils.isNotBlank(starttime)){
			sb.append("<span class='ml5'>" + starttime);
			if(StringUtils.isNotBlank(endtime)) {
                sb.append("-" + endtime);
            }
			sb.append("</span>");
		}
		return sb.toString();
	}
	public String getUrl(){
		return "activity/"+this.id;
	}
	public String getCname() {
		return this.title;
	}
	/**
	 * 锟筋动锟斤拷锟斤拷锟斤拷始
	 * @return true锟斤拷锟斤拷锟斤拷始
	 */
	public boolean isPreStart(){
		if (this.getActivityStartTime() == null || this.duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.before(cur) && this.getActivityStartTime().after(cur);
	}
	/**
	 * 锟筋动锟斤拷锟节斤拷锟斤拷锟斤拷
	 * @return true 锟斤拷锟节斤拷锟斤拷锟斤拷
	 */
	public boolean isProcessing(){
		if (this.getActivityStartTime() == null || this.getActivityEndTime() == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.getActivityEndTime().after(cur) && this.getActivityStartTime().before(cur);
	}
	/**
	 * 锟筋动锟角凤拷锟斤拷员锟斤拷锟�
	 * @return true锟斤拷锟皆憋拷锟斤拷
	 */
	public boolean isJoining(){
		if (fromtime == null || duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.after(cur) && this.fromtime.before(cur)&&isValid();
	}

	/**
	 * 锟筋动状态锟角凤拷锟斤拷效
	 * @return ture锟斤拷效
	 */
	public boolean isValid(){
		return (Status.Y_NEW.equals(this.status) || Status.Y_PROCESS.equals(this.status)); 
	}

	/**
	 * 锟筋动锟角凤拷停止
	 * @return
	 */
	public boolean isStop(){
		return StringUtils.equals(Status.Y_STOP, this.status);
	}
	
	/**
	 * 锟筋动锟角凤拷锟斤拷锟�
	 * @return true
	 */
	public boolean isEnd(){
		if(this.enddate != null){
			Timestamp cur=new Timestamp(System.currentTimeMillis());
			return this.getActivityEndTime().before(cur);
		}
		return false;
	}
	/**
	 * 锟筋动锟角凤拷始
	 * @return true锟斤拷未锟斤拷始
	 */
	public boolean isStart() {
		if(null == fromtime) {
            return false;
        }
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.fromtime.after(cur);
	}
	public void updateSearchKey(){
		this.searchkey = this.title;
	}
	/**
	 * 锟秸诧拷锟斤拷+1
	 */
	public void addCollectedtimes(){
		this.collectedtimes+=1;
	}
	
	/**
	 * 锟斤拷锟斤拷锟秸诧拷锟斤拷
	 * @param cutNum
	 */
	public void cutCollectedtimes(Integer cutNum){
		this.collectedtimes -= cutNum;
		if(this.collectedtimes<0) {
            this.collectedtimes = 0;
        }
	}
	
	public boolean isApply(){
		if(this.fromtime == null) {
            return false;
        }
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		Timestamp applyTime = DateUtil.addMinute(this.fromtime, -30);
		return applyTime.after(cur);
	}
	public String getLotterytag() {
		return lotterytag;
	}
	public void setLotterytag(String lotterytag) {
		this.lotterytag = lotterytag;
	}
	public Integer getHotvalue() {
		return hotvalue;
	}
	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}
	public String getContainMPI() {
		return containMPI;
	}
	public void setContainMPI(String containMPI) {
		this.containMPI = containMPI;
	}
	public String getContainGoods() {
		return containGoods;
	}
	public void setContainGoods(String containGoods) {
		this.containGoods = containGoods;
	}
	
	public String getFirstLogo() {
		return firstLogo;
	}
	
	public void setFirstLogo(String firstLogo) {
		this.firstLogo = firstLogo;
	}
	
	public String getClientType() {
		return clientType;
	}
	
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	public Boolean isMobileOnly(){
		if (StringUtils.isEmpty(clientType) || StringUtils.contains(clientType, CLIENT_TYPE_PC)) {
			return false;
		}
		return true;
	}
	public String getOperated() {
		return operated;
	}
	public void setOperated(String operated) {
		this.operated = operated;
	}
	public Integer getFocusvalue() {
		return focusvalue;
	}
	public void setFocusvalue(Integer focusvalue) {
		this.focusvalue = focusvalue;
	}
	public String getGetway() {
		return getway;
	}
	public void setGetway(String getway) {
		this.getway = getway;
	}
	
	public String getShowType() {
		return showType;
	}
	
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public String getGetCash() {
		return getCash;
	}
	public void setGetCash(String getCash) {
		this.getCash = getCash;
	}
	public String getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}
	public String getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(String usePoint) {
		this.usePoint = usePoint;
	}
	public String getJoinForm() {
		return joinForm;
	}
	public void setJoinForm(String joinForm) {
		this.joinForm = joinForm;
	}
	public String getOnlinePay() {
		return onlinePay;
	}
	public void setOnlinePay(String onlinePay) {
		this.onlinePay = onlinePay;
	}

	public boolean isOver(){
		if(enddate != null){
			return DateUtil.addDay(new Date(), -1).after(enddate);
		}else{
			if(startdate==null) {
                return true;
            }
			return DateUtil.addDay(new Date(), -1).after(startdate);
		}
	}
	public boolean isOver2(){
		if(this.enddate != null && StringUtils.isNotBlank(this.endtime)){
			Timestamp cur=new Timestamp(System.currentTimeMillis());
			String strDate = DateUtil.formatDate(this.enddate) + " " + this.endtime + ":00";
			return DateUtil.parseTimestamp(strDate).before(cur);
		}
		return false;
	}
	public boolean isPlaying(){
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		if(duetime==null || fromtime==null) {
            return false;
        }
		return duetime.after(cur) && this.fromtime.before(cur);
	}
	public String getRelateMobileUrl() {
		return relateMobileUrl;
	}
	public void setRelateMobileUrl(String relateMobileUrl) {
		this.relateMobileUrl = relateMobileUrl;
	}
}
