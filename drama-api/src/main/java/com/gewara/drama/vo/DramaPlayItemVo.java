package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.OdiConstant;

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
	private Timestamp playtime; // �ݳ�ʱ��
	private Timestamp endtime; // �ݳ�����ʱ��
	private String language; //
	private String status; // �Ƿ���Ч
	private String partner; // �Ƿ���⿪��
	private Long dramaStarId; //
	private String citycode; // ���б���
	private Long batch; // ���α�ʶ
	private String opentype; // �������ͣ�ѡ�����۸�
	private String period; // �Ƿ�̶�ʱ��
	private String seller; // ���ͣ�GEWA,GPTBS
	private String sellerseq; // ����ID(showItem-->siseq)
	private Integer sortnum; // �����ֶ�
	private String openStatus; // �Ƿ񿪷�
	private String showtype; // �������ͣ���ͨ���ػݣ�
	private String crmflag; // �̻���ʶ
	private String roomnum;
	private String takemethod;
	private Integer maxbuy;
	private String fieldlogo;
	private String idcard;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getDramaname() {
		return dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	@Deprecated
	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Long getDramaStarId() {
		return dramaStarId;
	}

	public void setDramaStarId(Long dramaStarId) {
		this.dramaStarId = dramaStarId;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerseq() {
		return sellerseq;
	}

	public void setSellerseq(String sellerseq) {
		this.sellerseq = sellerseq;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getShowtype() {
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public boolean hasPeriod(String perid) {
		if (StringUtils.isBlank(perid)) {
            return false;
        }
		return StringUtils.equals(this.period, perid);
	}

	public boolean hasSeller(String sell) {
		if (StringUtils.isBlank(sell)) {
            return false;
        }
		return StringUtils.equals(this.seller, sell);
	}

	public String getCrmflag() {
		return crmflag;
	}

	public void setCrmflag(String crmflag) {
		this.crmflag = crmflag;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public Integer getMaxbuy() {
		return maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public String getFieldlogo() {
		return fieldlogo;
	}

	public void setFieldlogo(String fieldlogo) {
		this.fieldlogo = fieldlogo;
	}

	public boolean hasGewa() {
		return StringUtils.equals(this.seller, OdiConstant.PARTNER_GEWA);
	}

	public boolean hasOpenseat() {
		return OdiConstant.OPEN_TYPE_SEAT.equals(this.opentype);
	}

	public boolean hasOpenprice() {
		return OdiConstant.OPEN_TYPE_PRICE.equals(this.opentype);
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

}
