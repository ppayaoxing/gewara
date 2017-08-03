package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;

public class CommentBaseVo extends BaseVo{

	private static final long serialVersionUID = 4476980910614491968L;
	public static final String POINT_MODERATOR = "moderator";	//发表哇啦话题加积分
	public static final String SUSPECTED_AD_T = "T";//疑似转票等广告哇啦
	public static final String SUSPECTED_AD_F = "F";//非疑似转票等广告哇啦
	public static final String TYPE_ADDREPLY = "add";//回复数加一
	public static final String TYPE_DOWNREPLY = "down";//回复数减一

	protected Long id;
	protected String body;
	protected Timestamp addtime;
	protected String tag;
	protected Long relatedid;
	protected Integer flowernum; //鲜花数
	protected String status;
	protected Long memberid;
	protected String nickname;
	protected String flag;
	protected Long transferid;//转载id
	protected String address;//发表来源
	protected Integer replycount;//回复数
	protected Integer transfercount;//转载数
	protected Timestamp replytime;
	protected String topic;	// WALA主题
	protected Integer generalmark;
	protected String otherinfo;
	protected String apptype;
	protected String link;
	protected String pointx;
	protected String pointy;
	protected String ip;
	protected Integer sumTRNum;//回复+ 转载数和
	protected Integer bodyLength;//发布哇啦的内容长度
	protected String suspectedAd;//是否疑似广告wala，这类哇啦排除在热门哇啦外
	protected Timestamp orderTime;//用来排序的时间，根据回复，转发或顶来权重加成
	protected Integer recommendTop;//置顶推荐排序  1做过置顶推荐
	protected String flowernumMember;//赞同的前10位用户
	
	protected String title;	//标题
	protected String videopath;	//视频路径
	protected String mtids;		//标签IDS
	protected Long moderatorid;//话题id
	protected Integer basicweight;	//基础权重
	protected Integer timeweight;		//时间权重
	
	protected String picturename;	//图片路径
	protected String type;		//哇啦类型  问答qa、话题debate
	protected String htmltext;	//是否有body
	
	protected Double bodyweight;	//主体权重值
	protected Double changeweight;//社区可变权重
	protected Double moviechangeweight;//电影可变权重
	protected Double weightorder;	//社区权重排序字段
	protected Double movieweightorder;	//电影权重排序字段
	protected Integer validflowernum;	//有效赞数
	
	protected List<Long> biglabelidList;	//大标签idList
	protected String biglabelids;
	protected String redUrl;//红包url
	protected String redTag;//红包tag
	protected String redToken;//红包Token
	private Integer score;//发哇啦赠送积分
	
	public Integer getValidflowernum() {
		return validflowernum;
	}
	public void setValidflowernum(Integer validflowernum) {
		this.validflowernum = validflowernum;
	}
	public String getHtmltext() {
		return htmltext;
	}
	public void setHtmltext(String htmltext) {
		this.htmltext = htmltext;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPointx() {
		return pointx;
	}
	public void setPointx(String pointx) {
		this.pointx = pointx;
	}
	public String getPointy() {
		return pointy;
	}
	public void setPointy(String pointy) {
		this.pointy = pointy;
	}
	
	public String getAddressInfo(){
		return AddressConstant.addressMap.get(address);
	}
	public Integer getTransfercount() {
		return transfercount;
	}
	public void setTransfercount(Integer transfercount) {
		this.transfercount = transfercount;
	}
	public Integer getReplycount() {
		return replycount;
	}
	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getTransferid() {
		return transferid;
	}
	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void addFlag(String sflag){
		if(StringUtils.isBlank(sflag)) this.flag = sflag;
		if(!StringUtils.contains(this.flag, sflag)) {
			if(StringUtils.isBlank(this.flag)) this.flag = sflag;
			else this.flag += "," + sflag;
		}
		
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return addtime;
	}
	
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	/*public CommentBase setAddtime(Timestamp addtime) {
		this.addtime = addtime;
		return this;
	}*/
	public void add2Replycount(String type1){
		if(TYPE_ADDREPLY.equals(type1))
			this.replycount +=1;
		else if(TYPE_DOWNREPLY.equals(type1))
			this.replycount -=1;
	}
	
	public void addTransfercount(){
		this.transfercount +=1;
	}
	

	public Integer getFlowernum() {
		return flowernum;
	}
	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}
	public void addFlowernum(){
		this.flowernum += 1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getMemberid(){
		return memberid;
	}
	public Timestamp getReplytime() {
		return replytime;
	}
	public void setReplytime(Timestamp replytime) {
		this.replytime = replytime;
	}
	public String getFromFlag(){
		return AddressConstant.addressMap.get(this.address);
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGeneralmark() {
		return generalmark;
	}
	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getApptype() {
		return apptype;
	}
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public Serializable realId() {
		return this.id;
	}
	public Integer getSumTRNum() {
		return sumTRNum;
	}
	public void setSumTRNum(Integer sumTRNum) {
		this.sumTRNum = sumTRNum;
	}
	public Integer getBodyLength() {
		return bodyLength;
	}
	public void setBodyLength(Integer bodyLength) {
		this.bodyLength = bodyLength;
	}
	public String getSuspectedAd() {
		return suspectedAd;
	}
	public void setSuspectedAd(String suspectedAd) {
		this.suspectedAd = suspectedAd;
	}
	
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getRecommendTop() {
		return recommendTop;
	}
	public void setRecommendTop(Integer recommendTop) {
		this.recommendTop = recommendTop;
	}
	public String getFlowernumMember() {
		return flowernumMember;
	}
	public void setFlowernumMember(String flowernumMember) {
		this.flowernumMember = flowernumMember;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideopath() {
		return videopath;
	}
	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}
	public String getMtids() {
		return mtids;
	}
	public void setMtids(String mtids) {
		this.mtids = mtids;
	}
	public Long getModeratorid() {
		return moderatorid;
	}
	public void setModeratorid(Long moderatorid) {
		this.moderatorid = moderatorid;
	}
	public Integer getBasicweight() {
		return basicweight;
	}
	public void setBasicweight(Integer basicweight) {
		this.basicweight = basicweight;
	}
	public Integer getTimeweight() {
		return timeweight;
	}
	public void setTimeweight(Integer timeweight) {
		this.timeweight = timeweight;
	}
	
	public Double getBodyweight() {
		return bodyweight;
	}
	public void setBodyweight(Double bodyweight) {
		this.bodyweight = bodyweight;
	}
	public Double getChangeweight() {
		return changeweight;
	}
	public void setChangeweight(Double changeweight) {
		this.changeweight = changeweight;
	}
	public Double getMoviechangeweight() {
		return moviechangeweight;
	}
	public void setMoviechangeweight(Double moviechangeweight) {
		this.moviechangeweight = moviechangeweight;
	}
	public Double getWeightorder() {
		return weightorder;
	}
	public void setWeightorder(Double weightorder) {
		this.weightorder = weightorder;
	}
	public Double getMovieweightorder() {
		return movieweightorder;
	}
	public void setMovieweightorder(Double movieweightorder) {
		this.movieweightorder = movieweightorder;
	}
	public List<Long> getBiglabelidList() {
		return biglabelidList;
	}
	public void setBiglabelidList(List<Long> biglabelidList) {
		this.biglabelidList = biglabelidList;
	}
	public String getBiglabelids() {
		return biglabelids;
	}
	public void setBiglabelids(String biglabelids) {
		this.biglabelids = biglabelids;
		if(StringUtils.isNotBlank(biglabelids)){
		   setBiglabelidList(BeanUtil.getIdList(biglabelids, ","));
		}

	}
	public String getRedUrl() {
		return redUrl;
	}
	public void setRedUrl(String redUrl) {
		this.redUrl = redUrl;
	}
	public String getRedTag() {
		return redTag;
	}
	public void setRedTag(String redTag) {
		this.redTag = redTag;
	}
	public String getRedToken() {
		return redToken;
	}
	public void setRedToken(String redToken) {
		this.redToken = redToken;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
