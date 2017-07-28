/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class DiaryVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = 4909399739817173386L;
	protected Long id;
	protected Long memberid;
	protected String subject;
	protected Integer flowernum;
	protected Integer poohnum;
	protected Integer sumnum;
	protected Integer sumnumed;
	protected Timestamp addtime;
	protected Integer clickedtimes;
	protected String tag;
	protected String category;
	protected Long categoryid;
	protected Long relatedid;
	protected String status;
	protected String summary;
	protected Timestamp replytime;
	protected Integer replycount;
	protected Long replyid;
	protected String type;
	protected Boolean viewed;
	protected Timestamp updatetime;
	protected Date overdate;
	protected Timestamp utime;
	protected Long communityid;
	protected String flag;
	protected String range;
	protected String membername;
	protected String replyname;
	protected String countycode;
	protected Long moderatorid;
	protected String citycode;
	protected String division;
	protected String otherinfo;
	protected String diaryImage;
	protected String ip;

	public String getDiaryImage() {
		return this.diaryImage;
	}

	public void setDiaryImage(String diaryImage) {
		this.diaryImage = diaryImage;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Long getModeratorid() {
		return this.moderatorid;
	}

	public void setModeratorid(Long moderatorid) {
		this.moderatorid = moderatorid;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
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

	public String getRange() {
		return this.range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public DiaryVo() {
	}

	public DiaryVo(String subject) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.addtime;
		this.replytime = this.addtime;
		this.utime = this.addtime;
		this.flowernum = Integer.valueOf(0);
		this.poohnum = Integer.valueOf(0);
		this.clickedtimes = Integer.valueOf(0);
		this.replycount = Integer.valueOf(0);
		this.viewed = Boolean.valueOf(true);
		this.status = "Y_NEW";
		this.communityid = Long.valueOf(0L);
		this.division = "N";
		this.subject = subject;
	}

	public void init(String stype, String stag, Long srelatedid, String scategory, Long scategoryid, String ssubject) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.type = stype;
		this.tag = stag;
		this.relatedid = srelatedid;
		this.category = scategory;
		this.categoryid = scategoryid;
		this.subject = ssubject;
		this.status = "Y_NEW";
	}

	public void addFlowernum() {
		this.flowernum = Integer.valueOf(this.flowernum.intValue() + 1);
	}

	public void addPoohnum() {
		this.poohnum = Integer.valueOf(this.poohnum.intValue() + 1);
	}

	public void addReplycount() {
		this.replycount = Integer.valueOf(this.replycount.intValue() + 1);
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUtime() {
		return this.utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public Boolean getViewed() {
		return this.viewed;
	}

	public void setViewed(Boolean viewed) {
		this.viewed = viewed;
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

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
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

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Integer getFlowernum() {
		return this.flowernum;
	}

	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}

	public Integer getPoohnum() {
		return this.poohnum;
	}

	public Integer getSumnum() {
		return this.sumnum;
	}

	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}

	public Integer getSumnumed() {
		return this.sumnumed;
	}

	public void setSumnumed(Integer sumnumed) {
		this.sumnumed = sumnumed;
	}

	public void setPoohnum(Integer poohnum) {
		if (poohnum == null) {
			poohnum = Integer.valueOf(0);
		}

		this.poohnum = poohnum;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public boolean getPic() {
		return StringUtils.contains(this.flag, "userfiles");
	}

	public Date getOverdate() {
		return this.overdate;
	}

	public void setOverdate(Date overdate) {
		this.overdate = overdate;
	}

	public Long getCommunityid() {
		return this.communityid;
	}

	public void setCommunityid(Long communityid) {
		this.communityid = communityid;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void addFlag(String sflag) {
		if (StringUtils.isBlank(this.flag)) {
			this.flag = sflag;
		}

		if (!StringUtils.contains(this.flag, sflag)) {
			this.flag = this.flag + "," + sflag;
		}

	}

	public String getCname() {
		return this.subject;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLimg() {
		return this.diaryImage;
	}

	public boolean canModify() {
		return true;
	}

	public Serializable realId() {
		return this.id;
	}
}