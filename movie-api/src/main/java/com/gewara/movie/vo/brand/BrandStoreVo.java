package com.gewara.movie.vo.brand;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 品牌下的门店
 * @author zhoufy
 */
public class BrandStoreVo extends BaseVo{

	private static final long serialVersionUID = 4010577028328154103L;
	private static final double R = 6371229;              //地球的半径 米
	private Long id;
	private Long cinemaid;		//影院ID
	private Long brandid;		//品牌ID
	private String storename;	//门店名称
	private String storeadd;	//门店地址
	private String tel;			//电话
	private Byte status;
	private String citycode;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String lat;			//纬度值
	private String lng;			//经度值
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	public Long getBrandid() {
		return brandid;
	}
	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
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
	@Override
	public Serializable realId() {
		return this.id;
	}
	public String getStoreadd() {
		return storeadd;
	}
	public void setStoreadd(String storeadd) {
		this.storeadd = storeadd;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getDistance(String latx1, String laty1){
		try{
			double x1=Double.valueOf(latx1);
			double y1=Double.valueOf(laty1);
			double x2=Double.valueOf(lat);
			double y2=Double.valueOf(lng);
			double x,y,distance;
			x=(x2-x1)* Math.PI*R*Math.cos( ((y1+y2)/2) * Math.PI/180)/180;
			y=(y2-y1)*Math.PI*R/180;
			distance=Math.hypot(x,y)/1000;
			return Math.round(distance)+"公里";
		}catch(Exception e){
			return "";
		}
		
		
	}
}
