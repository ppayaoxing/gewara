/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class CommentBaseVo extends BaseVo {
	private static final long serialVersionUID = 4476980910614491968L;
	public static final String POINT_MODERATOR = "moderator";
	public static final String SUSPECTED_AD_T = "T";
	public static final String SUSPECTED_AD_F = "F";
	public static final String TYPE_ADDREPLY = "add";
	public static final String TYPE_DOWNREPLY = "down";
	protected Long id;
	protected String body;
	protected Timestamp addtime;
	protected String tag;
	protected Long relatedid;
	protected Integer flowernum;
	protected String status;
	protected Long memberid;
	protected String nickname;
	protected String flag;
	protected Long transferid;
	protected String address;
	protected Integer replycount;
	protected Integer transfercount;
	protected Timestamp replytime;
	protected String topic;
	protected Integer generalmark;
	protected String otherinfo;
	protected String apptype;
	protected String link;
	protected String pointx;
	protected String pointy;
	protected String ip;
	protected Integer sumTRNum;
	protected Integer bodyLength;
	protected String suspectedAd;
	protected Timestamp orderTime;
	protected Integer recommendTop;
	protected String flowernumMember;
	protected String title;
	protected String videopath;
	protected String mtids;
	protected Long moderatorid;
	protected Integer basicweight;
	protected Integer timeweight;
	protected String picturename;
	protected String type;
	protected String htmltext;
	protected Double bodyweight;
	protected Double changeweight;
	protected Double moviechangeweight;
	protected Double weightorder;
	protected Double movieweightorder;
	protected Integer validflowernum;
	protected List<Long> biglabelidList;
	protected String biglabelids;
	protected String redUrl;
	protected String redTag;
	protected String redToken;
	private Integer score;

	public Integer getValidflowernum() {
		return this.validflowernum;
	}

	public void setValidflowernum(Integer validflowernum) {
		this.validflowernum = validflowernum;
	}

	public String getHtmltext() {
		return this.htmltext;
	}

	public void setHtmltext(String htmltext) {
		this.htmltext = htmltext;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPointx() {
		return this.pointx;
	}

	public void setPointx(String pointx) {
		this.pointx = pointx;
	}

	public String getPointy() {
		return this.pointy;
	}

	public void setPointy(String pointy) {
		this.pointy = pointy;
	}

	public String getAddressInfo() {
		return (String) AddressConstant.addressMap.get(this.address);
	}

	public Integer getTransfercount() {
		return this.transfercount;
	}

	public void setTransfercount(Integer transfercount) {
		this.transfercount = transfercount;
	}

	public Integer getReplycount() {
		return this.replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTransferid() {
		return this.transferid;
	}

	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void addFlag(String sflag) {
		if (StringUtils.isBlank(sflag)) {
			this.flag = sflag;
		}

		if (!StringUtils.contains(this.flag, sflag)) {
			if (StringUtils.isBlank(this.flag)) {
				this.flag = sflag;
			} else {
				this.flag = this.flag + "," + sflag;
			}
		}

	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public void add2Replycount(String type1) {
		if ("add".equals(type1)) {
			this.replycount = Integer.valueOf(this.replycount.intValue() + 1);
		} else if ("down".equals(type1)) {
			this.replycount = Integer.valueOf(this.replycount.intValue() - 1);
		}

	}

	public void addTransfercount() {
		this.transfercount = Integer.valueOf(this.transfercount.intValue() + 1);
	}

	public Integer getFlowernum() {
		return this.flowernum;
	}

	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}

	public void addFlowernum() {
		this.flowernum = Integer.valueOf(this.flowernum.intValue() + 1);
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public Timestamp getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Timestamp replytime) {
		this.replytime = replytime;
	}

	public String getFromFlag() {
		return (String) AddressConstant.addressMap.get(this.address);
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGeneralmark() {
		return this.generalmark;
	}

	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getPicturename() {
		return this.picturename;
	}

	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getSumTRNum() {
		return this.sumTRNum;
	}

	public void setSumTRNum(Integer sumTRNum) {
		this.sumTRNum = sumTRNum;
	}

	public Integer getBodyLength() {
		return this.bodyLength;
	}

	public void setBodyLength(Integer bodyLength) {
		this.bodyLength = bodyLength;
	}

	public String getSuspectedAd() {
		return this.suspectedAd;
	}

	public void setSuspectedAd(String suspectedAd) {
		this.suspectedAd = suspectedAd;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getRecommendTop() {
		return this.recommendTop;
	}

	public void setRecommendTop(Integer recommendTop) {
		this.recommendTop = recommendTop;
	}

	public String getFlowernumMember() {
		return this.flowernumMember;
	}

	public void setFlowernumMember(String flowernumMember) {
		this.flowernumMember = flowernumMember;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideopath() {
		return this.videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

	public String getMtids() {
		return this.mtids;
	}

	public void setMtids(String mtids) {
		this.mtids = mtids;
	}

	public Long getModeratorid() {
		return this.moderatorid;
	}

	public void setModeratorid(Long moderatorid) {
		this.moderatorid = moderatorid;
	}

	public Integer getBasicweight() {
		return this.basicweight;
	}

	public void setBasicweight(Integer basicweight) {
		this.basicweight = basicweight;
	}

	public Integer getTimeweight() {
		return this.timeweight;
	}

	public void setTimeweight(Integer timeweight) {
		this.timeweight = timeweight;
	}

	public Double getBodyweight() {
		return this.bodyweight;
	}

	public void setBodyweight(Double bodyweight) {
		this.bodyweight = bodyweight;
	}

	public Double getChangeweight() {
		return this.changeweight;
	}

	public void setChangeweight(Double changeweight) {
		this.changeweight = changeweight;
	}

	public Double getMoviechangeweight() {
		return this.moviechangeweight;
	}

	public void setMoviechangeweight(Double moviechangeweight) {
		this.moviechangeweight = moviechangeweight;
	}

	public Double getWeightorder() {
		return this.weightorder;
	}

	public void setWeightorder(Double weightorder) {
		this.weightorder = weightorder;
	}

	public Double getMovieweightorder() {
		return this.movieweightorder;
	}

	public void setMovieweightorder(Double movieweightorder) {
		this.movieweightorder = movieweightorder;
	}

	public List<Long> getBiglabelidList() {
		return this.biglabelidList;
	}

	public void setBiglabelidList(List<Long> biglabelidList) {
		this.biglabelidList = biglabelidList;
	}

	public String getBiglabelids() {
		return this.biglabelids;
	}

	public void setBiglabelids(String biglabelids) {
		this.biglabelids = biglabelids;
		if (StringUtils.isNotBlank(biglabelids)) {
			this.setBiglabelidList(BeanUtil.getIdList(biglabelids, ","));
		}

	}

	public String getRedUrl() {
		return this.redUrl;
	}

	public void setRedUrl(String redUrl) {
		this.redUrl = redUrl;
	}

	public String getRedTag() {
		return this.redTag;
	}

	public void setRedTag(String redTag) {
		this.redTag = redTag;
	}

	public String getRedToken() {
		return this.redToken;
	}

	public void setRedToken(String redToken) {
		this.redToken = redToken;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}