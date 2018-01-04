package com.gewara.drama.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.drama.vo.common.BaseEntityVo;

public class DramaVo extends BaseEntityVo{
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
	private String dramatype;//��������
	
	private String citycode;
	private String dramaalias;
	private String playwright;
	private String website;
	private String actorstext;//�����ı�
	private String directortext;//�����ı�
	private String troupecompany;//��Ʒ����
	private String troupecompanytext;//��Ʒ�����ı�
	private String dramacompany;//��Ʒ��
	private String dramadata;//
	private String playinfo; //��ӳʱ��
	private Integer boughtcount;	// ��Ʊ�˴�
	private String actorcontent;	//��Ա�Ľ���
	
	private String otherinfo;
	private String pretype;			//Ԥ������
	private String saleCycle;		//Ԥ������
	private String prices;			//�۸�����"��, ����"
	private String performDesc;		//�ݳ�˵��
	private String prepay;			//�Ƿ�Ԥ��
	private String prepayDesc;		//Ԥ������˵������
	private String calendarExt;		//������ʾ
	private String warmPrompt;		//��ܰ��ʾ
	private String separate;
	private String promo;
	private String crmMsg;			//CRM��ʾ����
	private String gypMsg;			//����Ʊ��ʾ����
	private String show;				//��Ŀ��ʾ/����״̬
	private String partner;         //��Ӧ��
	
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDramaname() {
		return dramaname;
	}
	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getDramatype() {
		return dramatype;
	}
	public void setDramatype(String dramatype) {
		this.dramatype = dramatype;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getDramaalias() {
		return dramaalias;
	}
	public void setDramaalias(String dramaalias) {
		this.dramaalias = dramaalias;
	}
	public String getPlaywright() {
		return playwright;
	}
	public void setPlaywright(String playwright) {
		this.playwright = playwright;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getActorstext() {
		return actorstext;
	}
	public void setActorstext(String actorstext) {
		this.actorstext = actorstext;
	}
	public String getDirectortext() {
		return directortext;
	}
	public void setDirectortext(String directortext) {
		this.directortext = directortext;
	}
	public String getTroupecompany() {
		return troupecompany;
	}
	public void setTroupecompany(String troupecompany) {
		this.troupecompany = troupecompany;
	}
	public String getTroupecompanytext() {
		return troupecompanytext;
	}
	public void setTroupecompanytext(String troupecompanytext) {
		this.troupecompanytext = troupecompanytext;
	}
	public String getDramacompany() {
		return dramacompany;
	}
	public void setDramacompany(String dramacompany) {
		this.dramacompany = dramacompany;
	}
	public String getDramadata() {
		return dramadata;
	}
	public void setDramadata(String dramadata) {
		this.dramadata = dramadata;
	}
	public String getPlayinfo() {
		return playinfo;
	}
	public void setPlayinfo(String playinfo) {
		this.playinfo = playinfo;
	}
	public Integer getBoughtcount() {
		return boughtcount;
	}
	public void setBoughtcount(Integer boughtcount) {
		this.boughtcount = boughtcount;
	}
	public String getActorcontent() {
		return actorcontent;
	}
	public void setActorcontent(String actorcontent) {
		this.actorcontent = actorcontent;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getPretype() {
		return pretype;
	}
	public void setPretype(String pretype) {
		this.pretype = pretype;
	}
	public String getSaleCycle() {
		return saleCycle;
	}
	public void setSaleCycle(String saleCycle) {
		this.saleCycle = saleCycle;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getPerformDesc() {
		return performDesc;
	}
	public void setPerformDesc(String performDesc) {
		this.performDesc = performDesc;
	}
	public String getPrepay() {
		return prepay;
	}
	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}
	public String getPrepayDesc() {
		return prepayDesc;
	}
	public void setPrepayDesc(String prepayDesc) {
		this.prepayDesc = prepayDesc;
	}
	public String getCalendarExt() {
		return calendarExt;
	}
	public void setCalendarExt(String calendarExt) {
		this.calendarExt = calendarExt;
	}
	public String getPriceText(){
		String res = "";
		if(StringUtils.isNotBlank(prices)){
			List<String> strList = Arrays.asList(prices.split(","));
			res = res + strList.get(0);
			if(strList.size()>1){
				res = res + "-"+strList.get(strList.size()-1);
			}
			res = res + "Ԫ";
		}
		return res;
	}
	
	@Override
    public String getLimg() {
		if(StringUtils.isBlank(logo)) {
            return "img/default_head.png";
        }
		return logo;
	}
	public String getWarmPrompt() {
		return warmPrompt;
	}
	public void setWarmPrompt(String warmPrompt) {
		this.warmPrompt = warmPrompt;
	}
	public String getSeparate() {
		return separate;
	}
	public void setSeparate(String separate) {
		this.separate = separate;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public String getCrmMsg() {
		return crmMsg;
	}
	public void setCrmMsg(String crmMsg) {
		this.crmMsg = crmMsg;
	}
	public String getGypMsg() {
		return gypMsg;
	}
	public void setGypMsg(String gypMsg) {
		this.gypMsg = gypMsg;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
}
