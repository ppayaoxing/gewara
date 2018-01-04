package com.gewara.api.vo.sport;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class SportVo extends BaseVo {

	private static final long serialVersionUID = -5384514237223604638L;
	public static final String BOOKING_OPEN = "open";
	public static final String BOOKING_CLOSE = "close";
	protected Long id;
	protected String name;
	protected String briefname;// 名称简称
	protected String seotitle; // SEO关键字
	protected String seodescription; // SEO描述
	protected String englishname;
	protected String pinyin;
	protected String content;
	protected Timestamp addtime;
	protected Timestamp updatetime;
	protected Integer hotvalue = 0;
	protected String logo;
	protected String firstpic;
	protected Integer clickedtimes;
	protected Integer quguo;
	protected Integer xiangqu; // 话剧明星版块: 想成为粉丝
	protected Integer generalmark;
	protected Integer generalmarkedtimes;

	protected Integer avggeneral;
	protected Integer collectedtimes; // 被收藏次数
	private String services;
	private String openinfo;
	private String flag;
	public static final String FLAG_RECOMMEND = "recommend";// 推荐分类
	public static final String FLAG_HOT = "hot";// 推荐热门
	private Integer avgfield;
	private String booking;
	private String floorplan;
	private String machinepic;

	public SportVo() {
	}

	public SportVo(String name) {
		this.booking = BOOKING_CLOSE;
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getOpeninfo() {
		return openinfo;
	}

	public void setOpeninfo(String openinfo) {
		this.openinfo = openinfo;
	}

	public Integer getAvgfield() {
		return avgfield;
	}

	public void setAvgfield(Integer avgfield) {
		this.avgfield = avgfield;
	}

	public String getUrl() {
		return "sport/" + this.getId();
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

	public boolean isEnableBook() {
		return BOOKING_OPEN.equals(this.booking);
	}

	public String getFloorplan() {
		return floorplan;
	}

	public void setFloorplan(String floorplan) {
		this.floorplan = floorplan;
	}

	public String getMachinepic() {
		return machinepic;
	}

	public void setMachinepic(String machinepic) {
		this.machinepic = machinepic;
	}
}
