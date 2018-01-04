package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

public class PhoneAdvertisementVo extends BaseVo{
	private static final long serialVersionUID = 4961436964379898448L;
	
	private Long id;
	private String advlink;
	private String link;
	private String title;
	private String apptype;//应用类型(cinema)
	private String osType;//系统类型(ANDROID,IPHONE)
	private String citycode;
	private Timestamp addtime;
	private String isshow;//是否显示
	private String status;
	private Timestamp starttime;
	private Timestamp endtime;
	
	private String tag;
	private Long relatedid;
	private String relatedids;
	private String summary;
	
	private Integer rank;//排序
	private String advertType;//活动类型 
	private String sharefriend;
	private String appSource;
	private Long discountid;
	private String sdlogo;
	private String sharepic; //分享图片地址
	private String tips;	// 提示语
	private String advdesc;	// 说明
	private String sharetitle;
	private String linkedid;	//关联其它活动ID	(for wap)
	private String tabname;		//tab标签显示的名称	(for wap)
	private String otherinfo;	//其他设置 json格式， 存放配置信息等
	private String batchid;		//批次ID，标识同一批活动
	public PhoneAdvertisementVo() {}
	
	public PhoneAdvertisementVo(Timestamp addtime){
		this.addtime = addtime;
	}
	
	@Override
	public Serializable realId() {
		return id;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	
	public Integer getTimeTag(){
		Timestamp curTime = DateUtil.getCurFullTimestamp();
		if(curTime.before(starttime)){
			return -1;
		}else if(curTime.after(endtime)){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	public String getAdvlink() {
		return advlink;
	}

	public void setAdvlink(String advlink) {
		this.advlink = advlink;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getAdvertType() {
		return advertType;
	}

	public void setAdvertType(String advertType) {
		this.advertType = advertType;
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

	public String getSharefriend() {
		return sharefriend;
	}

	public void setSharefriend(String sharefriend) {
		this.sharefriend = sharefriend;
	}

	public String getAppSource() {
		return appSource;
	}

	public void setAppSource(String appSource) {
		this.appSource = appSource;
	}

	public Long getDiscountid() {
		return discountid;
	}

	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}

	public String getSdlogo() {
		return sdlogo;
	}

	public void setSdlogo(String sdlogo) {
		this.sdlogo = sdlogo;
	}

	public String getSharepic() {
		return sharepic;
	}

	public void setSharepic(String sharepic) {
		this.sharepic = sharepic;
	}

	public String getRelatedids() {
		return relatedids;
	}

	public void setRelatedids(String relatedids) {
		this.relatedids = relatedids;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getAdvdesc() {
		return advdesc;
	}

	public void setAdvdesc(String advdesc) {
		this.advdesc = advdesc;
	}

	public String getSharetitle() {
		return sharetitle;
	}

	public void setSharetitle(String sharetitle) {
		this.sharetitle = sharetitle;
	}
	public String getLinkedid() {
		return linkedid;
	}

	public void setLinkedid(String linkedid) {
		this.linkedid = linkedid;
	}

	public String getTabname() {
		return tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	
	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	
}
