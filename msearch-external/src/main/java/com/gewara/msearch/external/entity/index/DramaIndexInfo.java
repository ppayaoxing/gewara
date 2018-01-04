package com.gewara.msearch.external.entity.index;


/**
 * 演出的信息
 * 
 * @author 董明
 * @createDate 2015年6月3日
 */
public class DramaIndexInfo  extends IndexData {

	private static final long serialVersionUID = 7074469411495043856L;
	
	private String seotitle;  //SEO关键字
	private String dramaname; //剧目名称
	private String englishname;//英文名称
	private String dramaalias;	//演出别名
	private String type;//剧目类型
	private String cityId;
	
	public String getSeotitle() {
		return seotitle;
	}
	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}
	public String getDramaname() {
		return dramaname;
	}
	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getDramaalias() {
		return dramaalias;
	}
	public void setDramaalias(String dramaalias) {
		this.dramaalias = dramaalias;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
