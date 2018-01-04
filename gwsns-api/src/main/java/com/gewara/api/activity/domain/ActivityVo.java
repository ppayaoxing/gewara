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
	public static final int TIME_CURRENT = 3; // δ���ڵĻ
	public static final int TIME_OVER = 2; // ���ڣ��������Ļ
	public static final int TIME_ALL = 1; // ���л
	public static final int TIME_RECORD = 10; // 
	public static final String FLAG_TOP_HEAD = "tophead";// ����̳�ö�
	public static final String FLAG_TOP_RELATED = "toprelated";// ����̳�ö�
	public static final String FLAG_TOP_CATEGORY = "topcategory";// ����̳����Ŀ�ö�
	public static final String FLAG_RECOMMEND = "recommend";// �Ƽ�
	public static final String FLAG_RECOMMEND_WAP = "redwap";// �Ƽ��ֻ�
	public static final String FLAG_HOME = "home";// ��ҳ
	public static final String FLAG_HOT = "hot";// ����
	public static final String FLAG_APP_HEAD = "apphead";// app�Ƽ�
	public static final String ATYPE_NOMARL = "common"; //��ͨ�
	public static final String ATYPE_USER = "user"; // �û������֤�û�
	public static final String ATYPE_BUSS = "buss"; // �̼һ�����췽
	public static final String ATYPE_GEWA = "gewa"; // gewa����ٷ�
	public static final Integer MAX_DAYS = 31; //���ʼʱ��������ڣ������ʱ��-���ʼʱ��
	public static final String SIGN_PRICE5 = "price5"; // 5Ԫ��Ʊ
	public static final String SIGN_PUBSALE = "pubsale";	// ����
	public static final String SIGN_STARMEET = "starmeet";// ���Ǽ����
	public static final String SIGN_TROUPE = "troupe";// ׷����
	public static final String SIGN_CLASS = "class";// ������
	public static final String SIGN_ONLINE = "online";// ���ϻ
	public static final String SIGN_RESERVE = "reserve";//Լս
	public static final String SIGN_DISCOUNT = "discount";//�Ż�
	public static final String SIGN_IMAX = "imax";//IMAX
	public static final String SIGN_CINEPHILES = "cinephiles";//һȺӰ�ԣ���Ӱ�ţ�
	public static final String SIGN_CINEMA = "cinema";// ӰԺ�
	public static final String SIGN_FILMREVIEWS = "filmreviews";// дӰ���
	public static final String SIGN_SPECIAL_NEW = "specialnew";// ר��
	public static final String TAG_ACTIVITY = "activity";
	public static final String OTHER_BINDMOBILE = "bindMobile";	//�û��μӻ����ֻ�
	public static final String OTHER_BINDEMAIL = "bindEmail";	//�û��μӻ�������
	public static final String OTHER_HASHEADURL = "hasHeadUrl";	//�û��μӻ���ϴ�ͷ��
	public static final String OTHER_HASADDRESS = "hasAddress";	//�û��μӻ����д��ַ
	public static final String OTHER_WALA = "wala";				//�û��μӻ����ܷ�WALA
	public static final String OTHER_NEWMEMBER = "newMember";	//���û����ܲμӻ
	public static final String OTHER_USEPOINT = "usePoint";		//�û��μӻ�����Ļ���
	public static final String OTHER_TICKET = "ticket";			//�����ض���Ӱ�û����ܲμ�
	public static final String OTHER_LONGWALA = "longWala";		//��¥���������
	public static final String OTHER_EASYJOIN = "easyJoin";		//�򵥲μӻ��������д������Ϣ
	
	public static final String CLIENT_TYPE_PC = "PC";
	
	public static final String CLIENT_TYPE_WAP = "WAP";
	
	public static final String CLIENT_TYPE_IOS = "IOS";
	
	public static final String CLIENT_TYPE_ANDROID = "ANDROID";
	
	/** ��PC�PC��-(����) */
	public static final String PC_SHOW_TYPE_DOWNLOAD = "DOWNLOAD";
	
	/** ��PC�PC��-(����ʾ) */
	public static final String PC_SHOW_TYPE_HIDDEN   = "HIDDEN";
	
	private Integer version;			//���°汾
	private Long id;
	private String title;// ����
	private String contentdetail;// ����
	private String atype;// ����,ֵΪ���� ATYPE_*�е�һ��
	private Date startdate;
	private String starttime;
	private Date enddate;
	private String endtime;
	private String address;
	private String contactway;// ��ϵ��ʽ
	private String summary;// �Ƽ�˵��
	private Integer capacity;
	private Long memberid;// ������
	private Integer clickedtimes;
	private String citycode; //310000,330100,330200
	private String countycode;
	private String indexareacode;
	private Timestamp addtime;
	private Long relatedid;
	private String tag;
	private String category;
	private Long categoryid;
	private Integer membercount;//�Ѳμӻ����
	private String status;//N_DELETE��ɾ��,N_AUDIT���δͨ��,Y_STOPֹͣ����,Y_PROCESS���������Ա���,Y_TREAT������,Y_CREATED����
	private Timestamp replytime;
	private Integer replycount;
	private Long replyid;// �ظ���
	private Long communityid;// Ȧ��
	private Timestamp updatetime;
	private String flag;	//recommend�Ƽ���վ,redwap�Ƽ�wap,hot��Ʒ,tophead�ö�,renzheng��֤����������","�ָ�
	private String logo;
	private String priceinfo;//������Ϣ
	//������
	private String searchkey;
	private String seotitle;
	private String seodescription;
	private String repeat;
	private String membername;
	private String replyname;
	private String sign; //���ʶ ,ֵΪ����SIGN_*�е�һ��
	private Timestamp duetime; // ������ֹʱ��
	private String activityurl;// ���ϻ������ַ
	private String mobilemsg;//��ֻ�����
	private String qq;//��ϵqq��
	
	// 20101111 hubo ��ӻԤ����
	private String needprepay;		// �Ƿ�Ԥ����
	
	private Integer totalFee;	// ��ʱ����, ����û�ܵ��շ�
	private String joinLimit;	//�û��μӻʱ�ļ�����������
	
	//20110829
	private Timestamp fromtime; //�������ʼʱ��
	//20120420
	private Long signid;//sign�������id��5Ԫ��Ʊ��1Ԫ����ʱʹ��
	private String otherinfo;//{"bindMobile":"Y","bindEmail":"Y","hasHeadUrl":"Y","hasAddress":"Y","wala":"Y","newMember":"Y","usePoint":"12","ticket":"123","longWala":"Y","easyJoin":"Y"}
							 //���ֻ�                              ��email        �ϴ�ͷ��                         �û���ַ                         �μӲ��ܻظ�����                                 �û�����                      �ض���Ӱid      ��¥                            �򵥲μ�
	private Integer collectedtimes;//����Ȥ
	private String linkman;//��ϵ��
	private Integer memberLimit=0;//�������
	private String ip;
	
	private String lotterytag;	//�齱��ʶ
	
	private Integer hotvalue=0;
	
	private Integer focusvalue=0;//��߹�ע���Ƽ�
	private String getCash;//��������
	private String containMPI;				//�Ƿ��г���
	private String containGoods;			//�Ƿ����շ���Ʒ
	private String operated;			//������Ƿ񱻲����� (Y ������)
	private String getway;		//���׷�ʽ
	private String feetype;
	private String isOfficial;
	private String relateMobileUrl;
	
	/**
	 * ���һ��ͼ
	 */
	private String firstLogo;
	
	/**
	 * �ͻ�����ʾ����(PC,WAP,IOS,ANDROID)
	 */
	private String clientType;
	
	/**
	 * ��PC���PC����ʾ��ʽ(����ʾ/����)
	 * @return
	 */
	private String showType;
	
	private String usePoint;
	private String joinForm;
	private String onlinePay;		//����֧��
	
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
		char char8 = 8;//���ݰ������ַ�""ʱ���ӿڽ����������
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
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~��������~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
	 * ���ٲμ�����
	 * @param cutNum
	 */
	public void cutJoinnum(Integer cutNum){
		this.membercount -= cutNum;
		if(this.membercount<0) {
            this.membercount = 0;
        }
	}
	

	/**
	 * �ظ���+1
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
		String str1 = DateUtil.format(startdate, "M��d��");
		String str2 = (enddate==null ? "": DateUtil.format(enddate, "M��d��"));
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
	 * ��ȡ���ʼʱ��
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
	 * ��ȡ�����ʱ��
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
            sb.append("��" + DateUtil.format(enddate, "MM-dd"));
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
	 * �������ʼ
	 * @return true������ʼ
	 */
	public boolean isPreStart(){
		if (this.getActivityStartTime() == null || this.duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.before(cur) && this.getActivityStartTime().after(cur);
	}
	/**
	 * ����ڽ�����
	 * @return true ���ڽ�����
	 */
	public boolean isProcessing(){
		if (this.getActivityStartTime() == null || this.getActivityEndTime() == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.getActivityEndTime().after(cur) && this.getActivityStartTime().before(cur);
	}
	/**
	 * ��Ƿ���Ա���
	 * @return true���Ա���
	 */
	public boolean isJoining(){
		if (fromtime == null || duetime == null) {
			return false;
		}
		Timestamp cur=new Timestamp(System.currentTimeMillis());
		return this.duetime.after(cur) && this.fromtime.before(cur)&&isValid();
	}

	/**
	 * �״̬�Ƿ���Ч
	 * @return ture��Ч
	 */
	public boolean isValid(){
		return (Status.Y_NEW.equals(this.status) || Status.Y_PROCESS.equals(this.status)); 
	}

	/**
	 * ��Ƿ�ֹͣ
	 * @return
	 */
	public boolean isStop(){
		return StringUtils.equals(Status.Y_STOP, this.status);
	}
	
	/**
	 * ��Ƿ����
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
	 * ��Ƿ�ʼ
	 * @return true��δ��ʼ
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
	 * �ղ���+1
	 */
	public void addCollectedtimes(){
		this.collectedtimes+=1;
	}
	
	/**
	 * �����ղ���
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
