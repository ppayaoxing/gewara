package com.gewara.content.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;

public class GewaCommendVo extends BaseVo {
	private static final long serialVersionUID = -1637550881723667131L;
	private Long id;
	private String signname;
	private String title;
	private String link;
	private String tag;
	private String logo;
	private String smalllogo;			//mnews,dnews
	private String summary;
	private Long relatedid;
	private Long parentid;
	private Integer ordernum;
	private Timestamp addtime;
	private Timestamp starttime;
	private Timestamp stoptime;
	private String citycode;
	
	private BaseObject relate;
	private BaseObject relate2;
	
	private String otherinfo ; //项目的相关属性
	
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
	public String getSimpleLink() {
		String simpleLink = StringUtils.trim(link);
		if(StringUtils.startsWith(simpleLink, "http://www.gewara.com")){
			return StringUtils.replace(simpleLink, "http://www.gewara.com", "");
		}
		return simpleLink;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
	public GewaCommendVo(){}
	
	public GewaCommendVo(String signname){
		this.signname = signname;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.ordernum = 0;
		this.starttime = new Timestamp(System.currentTimeMillis());
		this.stoptime = new Timestamp(System.currentTimeMillis());
	}
	// 为电影首页弹出框推荐 做区排序.
	public GewaCommendVo(String signname, String title, Long relatedid, Integer ordernum){
		this(signname);
		this.title = title;
		this.relatedid = relatedid;
		this.ordernum = ordernum;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSignname() {
		return signname;
	}
	public void setSignname(String signname) {
		this.signname = signname;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLogo() {
		return logo;
	}
	public String getLimg() {
		if(StringUtils.isBlank(logo)) return "img/default_head.png";
		return logo;
	}
	public String getLsmallimg() {
		if(StringUtils.isBlank(smalllogo)) return "img/default_head.png";
		return smalllogo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getReallogo(){
		if(StringUtils.isBlank(logo)) return "img/default_pic.png";
		return logo;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getStoptime() {
		return stoptime;
	}
	public void setStoptime(Timestamp stoptime) {
		this.stoptime = stoptime;
	}
	
	public String getSmalllogo() {
		return smalllogo;
	}
	public void setSmalllogo(String smalllogo) {
		this.smalllogo = smalllogo;
	}
	public BaseObject getRelate() {
		return relate;
	}
	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}
	public BaseObject getRelate2() {
		return relate2;
	}
	public void setRelate2(BaseObject relate2) {
		this.relate2 = relate2;
	}
}
