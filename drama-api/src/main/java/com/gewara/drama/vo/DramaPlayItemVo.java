/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DramaPlayItemVo extends BaseVo {
	private static final long serialVersionUID = -7865966237027417724L;
	public static final String STATUS_Y = "Y";
	public static final String STATUS_N = "N";
	private Long id;
	private String name;
	private Long dramaid;
	private Long theatreid;
	private String dramaname;
	private String theatrename;
	private Long roomid;
	private String roomname;
	private Timestamp addtime;
	private Timestamp playtime;
	private Timestamp endtime;
	private String language;
	private String status;
	private String partner;
	private Long dramaStarId;
	private String citycode;
	private Long batch;
	private String opentype;
	private String period;
	private String seller;
	private String sellerseq;
	private Integer sortnum;
	private String openStatus;
	private String showtype;
	private String crmflag;
	private String roomnum;
	private String takemethod;
	private Integer maxbuy;
	private String fieldlogo;
	private String idcard;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getDramaname() {
		return this.dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getTheatrename() {
		return this.theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	@Deprecated
	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Long getDramaStarId() {
		return this.dramaStarId;
	}

	public void setDramaStarId(Long dramaStarId) {
		this.dramaStarId = dramaStarId;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getBatch() {
		return this.batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerseq() {
		return this.sellerseq;
	}

	public void setSellerseq(String sellerseq) {
		this.sellerseq = sellerseq;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getOpenStatus() {
		return this.openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getShowtype() {
		return this.showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public boolean hasPeriod(String perid) {
		return StringUtils.isBlank(perid) ? false : StringUtils.equals(this.period, perid);
	}

	public boolean hasSeller(String sell) {
		return StringUtils.isBlank(sell) ? false : StringUtils.equals(this.seller, sell);
	}

	public String getCrmflag() {
		return this.crmflag;
	}

	public void setCrmflag(String crmflag) {
		this.crmflag = crmflag;
	}

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public String getFieldlogo() {
		return this.fieldlogo;
	}

	public void setFieldlogo(String fieldlogo) {
		this.fieldlogo = fieldlogo;
	}

	public boolean hasGewa() {
		return StringUtils.equals(this.seller, "GEWA");
	}

	public boolean hasOpenseat() {
		return "seat".equals(this.opentype);
	}

	public boolean hasOpenprice() {
		return "price".equals(this.opentype);
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
}