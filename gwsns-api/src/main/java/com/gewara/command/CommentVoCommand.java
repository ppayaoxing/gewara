/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.command;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class CommentVoCommand extends BaseVo implements Serializable {
	private static final long serialVersionUID = -4003691784832936833L;
	private Integer pageNumber;
	private Integer maxCount;
	private Integer fromcount;
	private String topic;
	private String tag;
	private Long relatedid;
	private String status;
	private Integer bodyLength;
	private Timestamp startTime;
	private Timestamp endTime;
	private String flag;
	private Long mincommentid;
	private List<Long> memberidList;
	private Long transferid;
	private String micrbody;
	private String queryType;
	private String order;
	private boolean asc;
	private Long moderatorid;
	private String mtids;
	private Integer basicweight;
	private boolean gt;
	private String source;
	private Integer marks;
	private String pic;
	private String video;
	private String title;
	private String qa;
	private Long memberid;
	private String nickname;
	private String mtName;
	private String pointx;
	private String pointy;
	private String ip;
	private String otherinfo;
	private String type;
	private String citycode;
	private List<Long> biglabelidList;

	public List<Long> getBiglabelidList() {
		return this.biglabelidList;
	}

	public void setBiglabelidList(List<Long> biglabelidList) {
		this.biglabelidList = biglabelidList;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getMaxCount() {
		return this.maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBodyLength() {
		return this.bodyLength;
	}

	public void setBodyLength(Integer bodyLength) {
		this.bodyLength = bodyLength;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getMincommentid() {
		return this.mincommentid;
	}

	public void setMincommentid(Long mincommentid) {
		this.mincommentid = mincommentid;
	}

	public List<Long> getMemberidList() {
		return this.memberidList;
	}

	public void setMemberidList(List<Long> memberidList) {
		this.memberidList = memberidList;
	}

	public Long getTransferid() {
		return this.transferid;
	}

	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}

	public String getMicrbody() {
		return this.micrbody;
	}

	public void setMicrbody(String micrbody) {
		this.micrbody = micrbody;
	}

	public String getQueryType() {
		return this.queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isAsc() {
		return this.asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public Long getModeratorid() {
		return this.moderatorid;
	}

	public void setModeratorid(Long moderatorid) {
		this.moderatorid = moderatorid;
	}

	public String getMtids() {
		return this.mtids;
	}

	public void setMtids(String mtids) {
		this.mtids = mtids;
	}

	public Integer getBasicweight() {
		return this.basicweight;
	}

	public void setBasicweight(Integer basicweight) {
		this.basicweight = basicweight;
	}

	public boolean isGt() {
		return this.gt;
	}

	public void setGt(boolean gt) {
		this.gt = gt;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getMarks() {
		return this.marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQa() {
		return this.qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public Long getMemberid() {
		return this.memberid;
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

	public String getMtName() {
		return this.mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
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

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Serializable realId() {
		return Integer.valueOf(0);
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Integer getFromcount() {
		return this.fromcount;
	}

	public void setFromcount(Integer fromcount) {
		this.fromcount = fromcount;
	}
}