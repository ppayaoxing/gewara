/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.qa;

import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class GewaQuestionVo extends BaseVo {
	private static final long serialVersionUID = 5578727148166770087L;
	public static Map<String, String> ssMap = new HashMap();
	public static final int HOTVALUE_HOT = 30000;
	public static final int HOTVALUE_RECOMMEND = 50000;
	public static final String QS_STATUS_N = "N";
	public static final String QS_STATUS_Y = "Y";
	public static final String QS_STATUS_Z = "Z";
	public static final String QS_STATUS_NOPROPER = "noproper";
	public static final Integer MAXDAYS = Integer.valueOf(15);
	private Long id;
	private String title;
	private String content;
	private String addinfo;
	private Integer reward;
	private String tag;
	private String category;
	private Long categoryid;
	private Long relatedid;
	private Long memberid;
	private Integer replycount;
	private Long replymemberid;
	private Integer clickedtimes;
	private Integer hotvalue;
	private String questionstatus;
	private String status;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Timestamp modtime;
	private Timestamp addinfotime;
	private Timestamp recommendtime;
	private Timestamp dealtime;
	private Long tomemberid;
	private String countycode;
	private String membername;
	private String citycode;
	private String ip;
	private BaseObject relate;
	private BaseObject relate2;

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public GewaQuestionVo() {
	}

	public GewaQuestionVo(Long memberid) {
		this.memberid = memberid;
		this.hotvalue = Integer.valueOf(0);
		this.replycount = Integer.valueOf(0);
		this.clickedtimes = Integer.valueOf(0);
		this.questionstatus = "Z";
		this.status = "Y_NEW";
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.addtime;
		this.recommendtime = this.addtime;
		this.modtime = this.addtime;
		this.reward = Integer.valueOf(0);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getReplycount() {
		return this.replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getReplymemberid() {
		return this.replymemberid;
	}

	public void setReplymemberid(Long replymemberid) {
		this.replymemberid = replymemberid;
	}

	public Long getTomemberid() {
		return this.tomemberid;
	}

	public void setTomemberid(Long tomemberid) {
		this.tomemberid = tomemberid;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public String getQuestionstatus() {
		return this.questionstatus;
	}

	public void setQuestionstatus(String questionstatus) {
		this.questionstatus = questionstatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Integer getReward() {
		return this.reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	public void addReplycount() {
		Integer arg1 = this.replycount;
		Integer arg2 = this.replycount = Integer.valueOf(this.replycount.intValue() + 1);
	}

	public Timestamp getRecommendtime() {
		return this.recommendtime;
	}

	public void setRecommendtime(Timestamp recommendtime) {
		this.recommendtime = recommendtime;
	}

	public String getTagname() {
		return (String) ssMap.get(this.tag);
	}

	public String getAddinfo() {
		return this.addinfo;
	}

	public void setAddinfo(String addinfo) {
		this.addinfo = addinfo;
	}

	public Timestamp getAddinfotime() {
		return this.addinfotime;
	}

	public void setAddinfotime(Timestamp addinfotime) {
		this.addinfotime = addinfotime;
	}

	public Timestamp getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Timestamp dealtime) {
		this.dealtime = dealtime;
	}

	public Timestamp getModtime() {
		return this.modtime;
	}

	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}

	public String getCname() {
		return this.title;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public BaseObject getRelate() {
		return this.relate;
	}

	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}

	public BaseObject getRelate2() {
		return this.relate2;
	}

	public void setRelate2(BaseObject relate2) {
		this.relate2 = relate2;
	}

	static {
		ssMap.put("cinema", "看电影");
		ssMap.put("theatre", "话剧");
		ssMap.put("activity", "活动");
		ssMap.put("", "其它");
	}
}