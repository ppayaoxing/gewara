package com.gewara.movie.vo;

import java.util.List;
import java.util.Map;

import com.gewara.movie.vo.common.BaseInfoVo;
import com.gewara.util.JsonUtils;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class CinemaVo extends BaseInfoVo {
	private static final long serialVersionUID = 5226491557222831911L;
	private static final double R = 6371229;              //地球的半径 米
	public static final String BOOKING_OPEN = "open";
	public static final String BOOKING_CLOSE = "close";

	private String flag;
	private String booking;
	private String popcorn;
	private String contactTelephone;//格式json [{"areaCode":"021","phone":"1234567","phoneRemark":"院长办公室"}{"areaCode":"021","phone":"1234567","phoneRemark":"院长办公室"}]
	private String mobilePhone;
	private String englishaddress;
	private String manageCompany;
	private String showGawara;		//Y:显示  N:不显示
	private String pcid;			//影院8位编码
	private String generalmarksort;//影院评分的排序字段
	
	public String getGeneralmarksort() {
		return generalmarksort;
	}
	public void setGeneralmarksort(String generalmarksort) {
		this.generalmarksort = generalmarksort;
	}
	/**
	 * 地铁交通描述{地铁站id:[{"详细描述":"右转50米","出口":"2号口","线路","1,2,8号线"}]}
	 * 例如： {"170170":[{"detail":"s","exitnumber":"5","lines":"9"}],"7702811":[{"detail":"123","exitnumber":"2","lines":"1"},{"detail":"43","exitnumber":"3","lines":"2"}]}
	 */
	private String subwayTransport; 
	
	public CinemaVo(){}
	public Long getCinemaid(){
		return id;
	}
	public String getCinemaname(){
		return name;
	}
	public String getUrl(){
		return "cinema/" + this.id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getBooking() {
		return booking;
	}
	public void setBooking(String booking) {
		this.booking = booking;
	}
	
	public String getPopcorn() {
		return popcorn;
	}

	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}
	public String getContactTelephone() {
		return contactTelephone;
	}
	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getSubwayTransport() {
		return subwayTransport;
	}
	
	public void setSubwayTransport(String subwayTransport) {
		this.subwayTransport = subwayTransport;
	}
	public String getShowGawara() {
		return showGawara;
	}
	public void setShowGawara(String showGawara) {
		this.showGawara = showGawara;
	}
	public String getDistance(String latx1, String laty1){
		try{
			double x1=Double.valueOf(latx1);
			double y1=Double.valueOf(laty1);
			double x2=Double.valueOf(pointx);
			double y2=Double.valueOf(pointy);
			double x,y,distance;
			x=(x2-x1)* Math.PI*R*Math.cos( ((y1+y2)/2) * Math.PI/180)/180;
			y=(y2-y1)*Math.PI*R/180;
			distance=Math.hypot(x,y)/1000;
			return Math.round(distance)+"公里";
		}catch(Exception e){
			return "";
		}
		
		
	}
	public List<Map> gainContactTelephone(){
		return JsonUtils.readJsonToObjectList(Map.class, contactTelephone);
	}
	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	public String getEnglishaddress() {
		return englishaddress;
	}
	public void setEnglishaddress(String englishaddress) {
		this.englishaddress = englishaddress;
	}
	public String getManageCompany() {
		return manageCompany;
	}
	public void setManageCompany(String manageCompany) {
		this.manageCompany = manageCompany;
	}
	
}
