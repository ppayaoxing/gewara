/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;

public class PhoneAdvertisementVo extends BaseVo {
	private static final long serialVersionUID = 4961436964379898448L;
	private Long id;
	private String advlink;
	private String link;
	private String title;
	private String apptype;
	private String osType;
	private String citycode;
	private Timestamp addtime;
	private String isshow;
	private String status;
	private Timestamp starttime;
	private Timestamp endtime;
	private String tag;
	private Long relatedid;
	private String relatedids;
	private String summary;
	private Integer rank;
	private String advertType;
	private String sharefriend;
	private String appSource;
	private Long discountid;
	private String sdlogo;
	private String sharepic;
	private String tips;
	private String advdesc;
	private String sharetitle;
	private String linkedid;
	private String tabname;
	private String otherinfo;
	private String batchid;

	public PhoneAdvertisementVo() {
	}

	public PhoneAdvertisementVo(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getOsType() {
		return this.osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getTimeTag() {
		Timestamp curTime = DateUtil.getCurFullTimestamp();
		return curTime.before(this.starttime) ? Integer.valueOf(-1)
				: (curTime.after(this.endtime) ? Integer.valueOf(1) : Integer.valueOf(0));
	}

	public String getAdvlink() {
		return this.advlink;
	}

	public void setAdvlink(String advlink) {
		this.advlink = advlink;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getAdvertType() {
		return this.advertType;
	}

	public void setAdvertType(String advertType) {
		this.advertType = advertType;
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

	public String getSharefriend() {
		return this.sharefriend;
	}

	public void setSharefriend(String sharefriend) {
		this.sharefriend = sharefriend;
	}

	public String getAppSource() {
		return this.appSource;
	}

	public void setAppSource(String appSource) {
		this.appSource = appSource;
	}

	public Long getDiscountid() {
		return this.discountid;
	}

	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}

	public String getSdlogo() {
		return this.sdlogo;
	}

	public void setSdlogo(String sdlogo) {
		this.sdlogo = sdlogo;
	}

	public String getSharepic() {
		return this.sharepic;
	}

	public void setSharepic(String sharepic) {
		this.sharepic = sharepic;
	}

	public String getRelatedids() {
		return this.relatedids;
	}

	public void setRelatedids(String relatedids) {
		this.relatedids = relatedids;
	}

	public String getTips() {
		return this.tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getAdvdesc() {
		return this.advdesc;
	}

	public void setAdvdesc(String advdesc) {
		this.advdesc = advdesc;
	}

	public String getSharetitle() {
		return this.sharetitle;
	}

	public void setSharetitle(String sharetitle) {
		this.sharetitle = sharetitle;
	}

	public String getLinkedid() {
		return this.linkedid;
	}

	public void setLinkedid(String linkedid) {
		this.linkedid = linkedid;
	}

	public String getTabname() {
		return this.tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getBatchid() {
		return this.batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
}