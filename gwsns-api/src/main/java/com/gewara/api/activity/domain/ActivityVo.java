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
	public static final int TIME_CURRENT = 3; // 未过期的活动
	public static final int TIME_OVER = 2; // 过期（结束）的活动
	public static final int TIME_ALL = 1; // 所有活动
	public static final int TIME_RECORD = 10; // 
	public static final String FLAG_TOP_HEAD = "tophead";// 总论坛置顶
	public static final String FLAG_TOP_RELATED = "toprelated";// 分论坛置顶
	public static final String FLAG_TOP_CATEGORY = "topcategory";// 分论坛中项目置顶
	public static final String FLAG_RECOMMEND = "recommend";// 推荐
	public static final String FLAG_RECOMMEND_WAP = "redwap";// 推荐手机
	public static final String FLAG_HOME = "home";// 首页
	public static final String FLAG_HOT = "hot";// 精华
	public static final String FLAG_APP_HEAD = "apphead";// app推荐
	public static final String ATYPE_NOMARL = "common"; //普通活动
	public static final String ATYPE_USER = "user"; // 用户活动，认证用户
	public static final String ATYPE_BUSS = "buss"; // 商家活动，主办方
	public static final String ATYPE_GEWA = "gewa"; // gewa活动，官方
	public static final Integer MAX_DAYS = 31; //活动开始时间距离现在，活动结束时间-活动开始时间
	public static final String SIGN_PRICE5 = "price5"; // 5元抢票
	public static final String SIGN_PUBSALE = "pubsale";	// 竞拍
	public static final String SIGN_STARMEET = "starmeet";// 明星见面会
	public static final String SIGN_TROUPE = "troupe";// 追剧团
	public static final String SIGN_CLASS = "class";// 公开课
	public static final String SIGN_ONLINE = "online";// 线上活动
	public static final String SIGN_RESERVE = "reserve";//约战
	public static final String SIGN_DISCOUNT = "discount";//优惠
	public static final String SIGN_IMAX = "imax";//IMAX
	public static final String SIGN_CINEPHILES = "cinephiles";//一群影迷（观影团）
	public static final String SIGN_CINEMA = "cinema";// 影院活动
	public static final String SIGN_FILMREVIEWS = "filmreviews";// 写影评活动
	public static final String SIGN_SPECIAL_NEW = "specialnew";// 专题活动
	public static final String TAG_ACTIVITY = "activity";
	public static final String OTHER_BINDMOBILE = "bindMobile";	//用户参加活动需绑定手机
	public static final String OTHER_BINDEMAIL = "bindEmail";	//用户参加活动需绑定邮箱
	public static final String OTHER_HASHEADURL = "hasHeadUrl";	//用户参加活动需上传头像
	public static final String OTHER_HASADDRESS = "hasAddress";	//用户参加活动需填写地址
	public static final String OTHER_WALA = "wala";				//用户参加活动后才能发WALA
	public static final String OTHER_NEWMEMBER = "newMember";	//新用户才能参加活动
	public static final String OTHER_USEPOINT = "usePoint";		//用户参加活动需消耗积分
	public static final String OTHER_TICKET = "ticket";			//购买特定电影用户才能参加
	public static final String OTHER_LONGWALA = "longWala";		//叠楼活动特殊哇啦
	public static final String OTHER_EASYJOIN = "easyJoin";		//简单参加活动，无需填写更多信息
	
	public static final String CLIENT_TYPE_PC = "PC";
	
	public static final String CLIENT_TYPE_WAP = "WAP";
	
	public static final String CLIENT_TYPE_IOS = "IOS";
	
	public static final String CLIENT_TYPE_ANDROID = "ANDROID";
	
	/** 非PC活动PC端-(下载) */
	public static final String PC_SHOW_TYPE_DOWNLOAD = "DOWNLOAD";
	
	/** 非PC活动PC端-(不显示) */
	public static final String PC_SHOW_TYPE_HIDDEN   = "HIDDEN";
	
	private Integer version;			//更新版本
	private Long id;
	private String title;// 标题
	private String contentdetail;// 内容
	private String atype;// 类型,值为常量 ATYPE_*中的一个
	private Date startdate;
	private String starttime;
	private Date enddate;
	private String endtime;
	private String address;
	private String contactway;// 联系方式
	private String summary;// 推荐说明
	private Integer capacity;
	private Long memberid;// 发起者
	private Integer clickedtimes;
	private String citycode; //310000,330100,330200
	private String countycode;
	private String indexareacode;
	private Timestamp addtime;
	private Long relatedid;
	private String tag;
	private String category;
	private Long categoryid;
	private Integer membercount;//已参加活动人数
	private String status;//N_DELETE被删除,N_AUDIT审核未通过,Y_STOP停止报名,Y_PROCESS正常，可以报名,Y_TREAT处理中,Y_CREATED创建
	private Timestamp replytime;
	private Integer replycount;
	private Long replyid;// 回复者
	private Long communityid;// 圈子
	private Timestamp updatetime;
	private String flag;	//recommend推荐网站,redwap推荐wap,hot精品,tophead置顶,renzheng认证，如果多个以","分割
	private String logo;
	private String priceinfo;//费用信息
	//新增加
	private String searchkey;
	private String seotitle;
	private String seodescription;
	private String repeat;
	private String membername;
	private String replyname;
	private String sign; //活动标识 ,值为常量SIGN_*中的一个
	private Timestamp duetime; // 报名截止时间
	private String activityurl;// 线上活动关联网址
	private String mobilemsg;//活动手机短信
	private String qq;//联系qq号
	
	// 20101111 hubo 添加活动预付费
	private String needprepay;		// 是否预付费
	
	private Integer totalFee;	// 临时变量, 保存该活动总的收费
	private String joinLimit;	//用户参加活动时的加入人数限制
	
	//20110829
	private Timestamp fromtime; //活动报名开始时间
	//20120420
	private Long signid;//sign相关联的id，5元抢票，1元竞拍时使用
	private String otherinfo;//{"bindMobile":"Y","bindEmail":"Y","hasHeadUrl":"Y","hasAddress":"Y","wala":"Y","newMember":"Y","usePoint":"12","ticket":"123","longWala":"Y","easyJoin":"Y"}
							 //绑定手机                              绑定email        上传头像                         用户地址                         参加才能回复哇啦                                 用户积分                      特定电影id      叠楼                            简单参加
	private Integer collectedtimes;//感兴趣
	private String linkman;//联系人
	private Integer memberLimit=0;//活动总人数
	private String ip;
	
	private String lotterytag;	//抽奖标识
	
	private Integer hotvalue=0;
	
	private Integer focusvalue=0;//最具关注的推荐
	private String getCash;//申请提现
	private String containMPI;				//是否有场次
	private String containGoods;			//是否有收费物品
	private String operated;			//活动哇啦是否被操作过 (Y 操作过)
	private String getway;		//交易方式
	private String feetype;
	private String isOfficial;
	private String relateMobileUrl;
	
	/**
	 * 活动第一张图
	 */
	private String firstLogo;
	
	/**
	 * 客户端显示类型(PC,WAP,IOS,ANDROID)
	 */
	private String clientType;
	
	/**
	 * 非PC活动在PC端显示方式(不显示/下载)
	 * @return
	 */
	private String showType;
	
	private String usePoint;
	private String joinForm;
	private String onlinePay;		//线上支付
	
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
		if(StringUtils.isBlank(logo)) return "img/default_activity.png";
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
		if(this.categoryid != null) return category;
		return tag;
	}
	public Long getDrelatedid(){
		if(this.categoryid != null) return categoryid;
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
		char char8 = 8;//内容包含该字符""时，接口解析会出问题
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
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~其他方法~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
		if(this.membercount<0) this.membercount = 0;
	}
	
	/**
	 * 减少参加人数
	 * @param cutNum
	 */
	public void cutJoinnum(Integer cutNum){
		this.membercount -= cutNum;
		if(this.membercount<0) this.membercount = 0;
	}
	

	/**
	 * 回复数+1
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
		String str1 = DateUtil.format(startdate, "M月d日");
		String str2 = (enddate==null ? "": DateUtil.format(enddate, "M月d日"));
		if(StringUtils.isBlank(str2) || StringUtils.equals(str1, str2)) return str1;
		return str1+splitor+str2;
	}
	public String getTimeRange(String splitor){
		if(StringUtils.isBlank(starttime)) return "";
		if(StringUtils.isBlank(endtime)) return starttime;
		return starttime + splitor + endtime;
	}
	
	/**
	 * 获取活动开始时间
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
	 * 获取活动结束时间
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
		if(enddate != null) sb.append("至" + DateUtil.format(enddate, "MM-dd"));
		sb.append("</span>");
		if(StringUtils.isNotBlank(starttime)){
			sb.append("<span class='ml5'>" + starttime);
			if(StringUtils.isNotBlank(endtime)) sb.append("-" + endtime);
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
	 * 活动即将开始
	 * @return true即将开始
	 */
	public boolean isPreStart(){
		if (this.getActivityStartTime() == null || this.duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.before(cur) && this.getActivityStartTime().after(cur);
	}
	/**
	 * 活动正在进行中
	 * @return true 正在进行中
	 */
	public boolean isProcessing(){
		if (this.getActivityStartTime() == null || this.getActivityEndTime() == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.getActivityEndTime().after(cur) && this.getActivityStartTime().before(cur);
	}
	/**
	 * 活动是否可以报名
	 * @return true可以报名
	 */
	public boolean isJoining(){
		if (fromtime == null || duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.after(cur) && this.fromtime.before(cur)&&isValid();
	}

	/**
	 * 活动状态是否有效
	 * @return ture有效
	 */
	public boolean isValid(){
		return (Status.Y_NEW.equals(this.status) || Status.Y_PROCESS.equals(this.status)); 
	}

	/**
	 * 活动是否停止
	 * @return
	 */
	public boolean isStop(){
		return StringUtils.equals(Status.Y_STOP, this.status);
	}
	
	/**
	 * 活动是否结束
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
	 * 活动是否开始
	 * @return true还未开始
	 */
	public boolean isStart() {
		if(null == fromtime) return false;
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.fromtime.after(cur);
	}
	public void updateSearchKey(){
		this.searchkey = this.title;
	}
	/**
	 * 收藏数+1
	 */
	public void addCollectedtimes(){
		this.collectedtimes+=1;
	}
	
	/**
	 * 减少收藏数
	 * @param cutNum
	 */
	public void cutCollectedtimes(Integer cutNum){
		this.collectedtimes -= cutNum;
		if(this.collectedtimes<0) this.collectedtimes = 0;
	}
	
	public boolean isApply(){
		if(this.fromtime == null) return false;
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
			if(startdate==null) return true;
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
		if(duetime==null || fromtime==null) return false;
		return duetime.after(cur) && this.fromtime.before(cur);
	}
	public String getRelateMobileUrl() {
		return relateMobileUrl;
	}
	public void setRelateMobileUrl(String relateMobileUrl) {
		this.relateMobileUrl = relateMobileUrl;
	}
}
