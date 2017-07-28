/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class VideoVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	public static final int HOTVALUE_RECOMMEND = 1000;
	public static final String VIDEOTYPE_FILM = "movieFilm";
	private Long id;
	private String tag;
	private Long relatedid;
	private String flag;
	private String category;
	private Long categoryid;
	private String url;
	private String videotitle;
	private String logo;
	private String content;
	private Timestamp addtime;
	private Long memberid;
	private String memberType;
	private Long verifymemberid;
	private Integer hotvalue;
	private Timestamp updatetime;
	private Integer clickedtimes;
	private Integer orderNum;
	private String videono;
	private String h5code;
	private String origin;
	private String displayinfo;
	private String timelength;
	private String htmlcode;
	private String flashcode;

	public String getH5code() {
		return this.h5code;
	}

	public void setH5code(String h5code) {
		this.h5code = h5code;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getVideoHtml(Integer width, Integer height) {
		StringBuilder result = new StringBuilder("<embed ");
		if (width != null)
			result.append(new StringBuilder().append("width='").append(width).append("' ").toString());
		if (height != null)
			result.append(new StringBuilder().append("height='").append(height).append("' ").toString());
		result.append("type='application/x-shockwave-flash' allowScriptAccess='always'")
				.append("pluginspage='http://www.macromedia.com/go/getflashplayer' ")
				.append(new StringBuilder().append("src='").append(this.url).append("' ").toString())
				.append("play='true' loop='true' menu='true' wmode='transparent'></embed>");

		return result.toString();
	}

	public String getDefaultVideoHtml() {
		return getVideoHtml(null, null);
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getVerifymemberid() {
		return this.verifymemberid;
	}

	public void setVerifymemberid(Long verifymemberid) {
		this.verifymemberid = verifymemberid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getLogo() {
		return this.logo;
	}

	public String getLimg() {
		if (StringUtils.isBlank(this.logo))
			return "img/default_head.png";
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getVideotitle() {
		return this.videotitle;
	}

	public void setVideotitle(String videotitle) {
		this.videotitle = videotitle;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public String getCname() {
		return this.videotitle;
	}

	public boolean getContainsUrl() {
		if (StringUtils.contains(this.url, "ku6.com")) {
			return true;
		}
		return (!(StringUtils.contains(this.url, "youku.com")));
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

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public boolean hasMemberType(String type) {
		return StringUtils.equals(this.memberType, type);
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getVideono() {
		return this.videono;
	}

	public void setVideono(String videono) {
		this.videono = videono;
	}

	public String getDisplayinfo() {
		return this.displayinfo;
	}

	public void setDisplayinfo(String displayinfo) {
		this.displayinfo = displayinfo;
	}

	public String getTimelength() {
		return this.timelength;
	}

	public void setTimelength(String timelength) {
		this.timelength = timelength;
	}

	public String getHtmlcode() {
		return this.htmlcode;
	}

	public void setHtmlcode(String htmlcode) {
		this.htmlcode = htmlcode;
	}

	public String getFlashcode() {
		return this.flashcode;
	}

	public void setFlashcode(String flashcode) {
		this.flashcode = flashcode;
	}
}