package com.gewara.command;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class CommentVoCommand extends BaseVo implements Serializable{
	private static final long serialVersionUID = -4003691784832936833L;
	private Integer pageNumber;	//分页页码
	private Integer maxCount;	//条数
	private Integer fromcount; //开始条数
	private String topic;		//话题
	private String tag;					//对象类型
	private Long relatedid;				//对象ID
	private String status;				//wala状态
	private Integer bodyLength;		//大于多少字数的
	private Timestamp startTime;			//查询哇啦带时间
	private Timestamp endTime;
	private String flag;  				//值为ticket查询购票用户发表哇啦。
	private Long mincommentid;			//查询commentid之后的哇啦
	private List<Long> memberidList;	//查询的用户id 不可超过1000个
	private Long transferid;			//转发的commentid
	private String micrbody;			// 模糊查询内容
	private String queryType;			//查询类型hot nothot					
	private String order;   			// 哇啦排序flowernum 热门哇啦
	private boolean asc;					//排序 (正倒序)
	private Long moderatorid;			//话题id
	private String mtids;					//标签id
	private Integer basicweight;		//基础权重
	private boolean gt;					//是否大于
	private String source;				//发哇啦来源 wap,web等等
	private Integer marks;				//是否有评分
	private String pic;					//是否有图片
	private String video;				//是否有视频
	private String title;				//是否有标题
	private String qa;					//是否为问答
	private Long memberid;				//发送用户id
	private String nickname;			//用户昵称
	private String mtName;				//标签名字
	private String pointx;
	private String pointy;
	private String ip;
	private String otherinfo;
	
	private String type;					//哇啦类型
	private String citycode;				//城市编码
	
	private List<Long> biglabelidList;	//大标签idList
	
	public List<Long> getBiglabelidList() {
		return biglabelidList;
	}

	public void setBiglabelidList(List<Long> biglabelidList) {
		this.biglabelidList = biglabelidList;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(Integer bodyLength) {
		this.bodyLength = bodyLength;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getMincommentid() {
		return mincommentid;
	}

	public void setMincommentid(Long mincommentid) {
		this.mincommentid = mincommentid;
	}

	public List<Long> getMemberidList() {
		return memberidList;
	}

	public void setMemberidList(List<Long> memberidList) {
		this.memberidList = memberidList;
	}

	public Long getTransferid() {
		return transferid;
	}

	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}

	public String getMicrbody() {
		return micrbody;
	}

	public void setMicrbody(String micrbody) {
		this.micrbody = micrbody;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public Long getModeratorid() {
		return moderatorid;
	}

	public void setModeratorid(Long moderatorid) {
		this.moderatorid = moderatorid;
	}

	public String getMtids() {
		return mtids;
	}

	public void setMtids(String mtids) {
		this.mtids = mtids;
	}

	public Integer getBasicweight() {
		return basicweight;
	}

	public void setBasicweight(Integer basicweight) {
		this.basicweight = basicweight;
	}

	public boolean isGt() {
		return gt;
	}

	public void setGt(boolean gt) {
		this.gt = gt;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public Long getMemberid() {
		return memberid;
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

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public Serializable realId() {//不能确定唯一性
		return 0;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Integer getFromcount() {
		return fromcount;
	}

	public void setFromcount(Integer fromcount) {
		this.fromcount = fromcount;
	}
	
}
