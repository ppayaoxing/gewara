/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.drama.vo.common.BaseEntityVo;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class DramaVo extends BaseEntityVo {
	private static final long serialVersionUID = 5187699562687697869L;
	private String language;
	private String dramaname;
	private String director;
	private String actors;
	private Date releasedate;
	private Date enddate;
	private String type;
	private String length;
	private String state;
	private String highlight;
	private String dramatype;
	private String citycode;
	private String dramaalias;
	private String playwright;
	private String website;
	private String actorstext;
	private String directortext;
	private String troupecompany;
	private String troupecompanytext;
	private String dramacompany;
	private String dramadata;
	private String playinfo;
	private Integer boughtcount;
	private String actorcontent;
	private String otherinfo;
	private String pretype;
	private String saleCycle;
	private String prices;
	private String performDesc;
	private String prepay;
	private String prepayDesc;
	private String calendarExt;
	private String warmPrompt;
	private String separate;
	private String promo;
	private String crmMsg;
	private String gypMsg;
	private String show;
	private String partner;

	public String getShow() {
		return this.show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDramaname() {
		return this.dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHighlight() {
		return this.highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getDramatype() {
		return this.dramatype;
	}

	public void setDramatype(String dramatype) {
		this.dramatype = dramatype;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDramaalias() {
		return this.dramaalias;
	}

	public void setDramaalias(String dramaalias) {
		this.dramaalias = dramaalias;
	}

	public String getPlaywright() {
		return this.playwright;
	}

	public void setPlaywright(String playwright) {
		this.playwright = playwright;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getActorstext() {
		return this.actorstext;
	}

	public void setActorstext(String actorstext) {
		this.actorstext = actorstext;
	}

	public String getDirectortext() {
		return this.directortext;
	}

	public void setDirectortext(String directortext) {
		this.directortext = directortext;
	}

	public String getTroupecompany() {
		return this.troupecompany;
	}

	public void setTroupecompany(String troupecompany) {
		this.troupecompany = troupecompany;
	}

	public String getTroupecompanytext() {
		return this.troupecompanytext;
	}

	public void setTroupecompanytext(String troupecompanytext) {
		this.troupecompanytext = troupecompanytext;
	}

	public String getDramacompany() {
		return this.dramacompany;
	}

	public void setDramacompany(String dramacompany) {
		this.dramacompany = dramacompany;
	}

	public String getDramadata() {
		return this.dramadata;
	}

	public void setDramadata(String dramadata) {
		this.dramadata = dramadata;
	}

	public String getPlayinfo() {
		return this.playinfo;
	}

	public void setPlayinfo(String playinfo) {
		this.playinfo = playinfo;
	}

	public Integer getBoughtcount() {
		return this.boughtcount;
	}

	public void setBoughtcount(Integer boughtcount) {
		this.boughtcount = boughtcount;
	}

	public String getActorcontent() {
		return this.actorcontent;
	}

	public void setActorcontent(String actorcontent) {
		this.actorcontent = actorcontent;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getPretype() {
		return this.pretype;
	}

	public void setPretype(String pretype) {
		this.pretype = pretype;
	}

	public String getSaleCycle() {
		return this.saleCycle;
	}

	public void setSaleCycle(String saleCycle) {
		this.saleCycle = saleCycle;
	}

	public String getPrices() {
		return this.prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getPerformDesc() {
		return this.performDesc;
	}

	public void setPerformDesc(String performDesc) {
		this.performDesc = performDesc;
	}

	public String getPrepay() {
		return this.prepay;
	}

	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}

	public String getPrepayDesc() {
		return this.prepayDesc;
	}

	public void setPrepayDesc(String prepayDesc) {
		this.prepayDesc = prepayDesc;
	}

	public String getCalendarExt() {
		return this.calendarExt;
	}

	public void setCalendarExt(String calendarExt) {
		this.calendarExt = calendarExt;
	}

	public String getPriceText() {
		String res = "";
		if (StringUtils.isNotBlank(this.prices)) {
			List strList = Arrays.asList(this.prices.split(","));
			res = res + (String) strList.get(0);
			if (strList.size() > 1) {
				res = res + "-" + (String) strList.get(strList.size() - 1);
			}

			res = res + "Ԫ";
		}

		return res;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public String getWarmPrompt() {
		return this.warmPrompt;
	}

	public void setWarmPrompt(String warmPrompt) {
		this.warmPrompt = warmPrompt;
	}

	public String getSeparate() {
		return this.separate;
	}

	public void setSeparate(String separate) {
		this.separate = separate;
	}

	public String getPromo() {
		return this.promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getCrmMsg() {
		return this.crmMsg;
	}

	public void setCrmMsg(String crmMsg) {
		this.crmMsg = crmMsg;
	}

	public String getGypMsg() {
		return this.gypMsg;
	}

	public void setGypMsg(String gypMsg) {
		this.gypMsg = gypMsg;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}
}