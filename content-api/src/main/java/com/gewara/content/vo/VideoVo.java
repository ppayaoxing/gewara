package com.gewara.content.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

/**
 * @author Administrator
 *
 */
public class VideoVo extends BaseVo{
	private static final long serialVersionUID = 4914995483381697551L;
	public static final int HOTVALUE_RECOMMEND = 1000;
	public static final String VIDEOTYPE_FILM = "movieFilm";//电影影片  tag为movie是原来的电影的预告片
	private Long id;
	private String tag;//类型标签
	private Long relatedid;//关联Id
	private String flag;
	private String category;	
	private Long categoryid;	
	private String url;
	private String videotitle;//视频标题
	private String logo; //图标
	private String content;//内容
	private Timestamp addtime;
	private Long memberid; //用户
	private String memberType;
	private Long verifymemberid; //审核用户
	private Integer hotvalue;
	private Timestamp updatetime;
	private Integer clickedtimes; //点击数
	private Integer orderNum;
	private String videono;			// 视频ID
	private String h5code;		//H5代码
	private String origin;		//地址源：优酷，土豆等
	private String displayinfo;	//是否显示,Y表示显示，N表示不显示
	private String timelength;	//时长：3:15 
	private String htmlcode;	//html代码
	private String flashcode;	//flashcode
	
	public String getH5code() {
		return h5code;
	}
	public void setH5code(String h5code) {
		this.h5code = h5code;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public Integer getClickedtimes() {
		return clickedtimes;
	}
	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	public VideoVo() {}
	
	@Override
	public Serializable realId() {
		return id;
	}
	public String getVideoHtml(Integer width, Integer height){
		StringBuilder result = new StringBuilder("<embed ");
		if(width != null) result.append("width='" + width + "' ");
		if(height!= null) result.append("height='" + height + "' ");
		result.append("type='application/x-shockwave-flash' allowScriptAccess='always'")
				.append("pluginspage='http://www.macromedia.com/go/getflashplayer' ")
				.append("src='" + this.url + "' ")
				.append("play='true' loop='true' menu='true' wmode='transparent'></embed>");
		return result.toString();
	}
	public String getDefaultVideoHtml(){
		return getVideoHtml(null, null);
	}
	public String getTag() {
		return tag;
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
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getVerifymemberid() {
		return verifymemberid;
	}
	public void setVerifymemberid(Long verifymemberid) {
		this.verifymemberid = verifymemberid;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getLogo() {
		return logo;
	}
	public String getLimg() {
		if(StringUtils.isBlank(logo)) return "img/default_head.png";
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getVideotitle() {
		return videotitle;
	}
	public void setVideotitle(String videotitle) {
		this.videotitle = videotitle;
	}
	public Integer getHotvalue() {
		return hotvalue;
	}
	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}
	public String getCname(){
		return this.videotitle;
	}
	public boolean getContainsUrl(){
		if(StringUtils.contains(url, "ku6.com")){
			return true;
		}else if(StringUtils.contains(url, "youku.com")){
			return false;
		}
		return true;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public boolean hasMemberType(String type){
		return StringUtils.equals(this.memberType, type);
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getVideono() {
		return videono;
	}
	public void setVideono(String videono) {
		this.videono = videono;
	}
	public String getDisplayinfo() {
		return displayinfo;
	}
	public void setDisplayinfo(String displayinfo) {
		this.displayinfo = displayinfo;
	}
	public String getTimelength() {
		return timelength;
	}
	public void setTimelength(String timelength) {
		this.timelength = timelength;
	}
	public String getHtmlcode() {
		return htmlcode;
	}
	public void setHtmlcode(String htmlcode) {
		this.htmlcode = htmlcode;
	}
	public String getFlashcode() {
		return flashcode;
	}
	public void setFlashcode(String flashcode) {
		this.flashcode = flashcode;
	}
	
}
