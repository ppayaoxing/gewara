package com.gewara.movie.vo.common;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;


public class BaseEntityVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = 6326252378179481450L;
	protected Long id;
	protected String name;
	protected String englishname;
	protected String pinyin;
	protected String content;
	protected String logo;
	protected String fullLogo;
	protected String firstpic;
	protected Integer generalmark;//评分
	protected Integer generalmarkedtimes;
	protected Integer avggeneral;
	protected Integer collectedtimes;// 收藏 感兴趣
	protected Integer clickedtimes;//关注
	protected String briefname;//名称简称
	protected Integer xiangqu;	// 话剧明星版块: 想成为粉丝
	protected String seotitle; //SEO关键字
	protected String seodescription; //SEO描述
	protected Timestamp addtime;
	protected Timestamp updatetime;	//修改时间
	protected Integer hotvalue=0; 
	protected Integer quguo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClickedtimes() {
		return clickedtimes;
	}
	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getFirstpic() {
		return firstpic;
	}
	public void setFirstpic(String firstpic) {
		this.firstpic = firstpic;
	}
	public Integer getGeneralmark() {
		return generalmark;
	}
	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}
	public Integer getGeneralmarkedtimes() {
		return generalmarkedtimes;
	}
	public void setGeneralmarkedtimes(Integer generalmarkedtimes) {
		this.generalmarkedtimes = generalmarkedtimes;
	}
	public Integer getAvggeneral() {
		return avggeneral;
	}
	public void setAvggeneral(Integer avggeneral) {
		this.avggeneral = avggeneral;
	}
	public Integer getCollectedtimes() {
		return collectedtimes;
	}
	public void setCollectedtimes(Integer collectedtimes) {
		this.collectedtimes = collectedtimes;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getRealBriefname(){
		return StringUtils.isNotBlank(this.briefname)? briefname: getName();
	}
	public String getBriefname() {
		return briefname;
	}
	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}
	public String getFullLogo() {
		return fullLogo;
	}
	public void setFullLogo(String fullLogo) {
		this.fullLogo = fullLogo;
	}
	public Integer getXiangqu() {
		return xiangqu;
	}
	public void setXiangqu(Integer xiangqu) {
		this.xiangqu = xiangqu;
	}
	public String getSeotitle() {
		return seotitle;
	}
	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}
	public String getSeodescription() {
		return seodescription;
	}
	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getHotvalue() {
		return hotvalue;
	}
	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}
	public Integer getQuguo() {
		return quguo;
	}
	public void setQuguo(Integer quguo) {
		this.quguo = quguo;
	}
	public String getCname() {
		return this.name;
	}
	public String getLimg(){
		if(StringUtils.isBlank(logo)) return "img/default_logo.png";
		return logo;
	}
	public void addQuguo(){
		this.quguo +=1;
	}
	public void addXiangqu() {
		this.xiangqu += 1;
	}
	public void addCollection(){
		this.collectedtimes += 1;
	}

}
