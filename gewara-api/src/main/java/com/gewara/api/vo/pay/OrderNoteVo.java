/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class OrderNoteVo extends BaseVo {
	private static final long serialVersionUID = -135038508746485007L;
	private Long id;
	private Long orderid;
	private String tradeno;
	private String ordertype;
	private String mobile;
	private String placename;
	private String placetype;
	private Long placeid;
	private String itemname;
	private String itemtype;
	private Long itemid;
	private String checkpass;
	private Integer ticketnum;
	private String smallitemtype;
	private Long smallitemid;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Timestamp validtime;
	private String message;
	private Timestamp playtime;
	private Timestamp taketime;
	private String status;
	private String serialno;
	private Timestamp modifytime;
	private String result;
	private String description;
	private String fromup;
	private String express;
	private String otherinfo;
	private Integer convertnum;
	private String converttype;
	private Integer totalfee;
	private Integer totaldisfee;
	private Integer convertfee;
	private Integer convertdisfee;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPlacename() {
		return this.placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPlacetype() {
		return this.placetype;
	}

	public void setPlacetype(String placetype) {
		this.placetype = placetype;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getCheckpass() {
		return this.checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public Integer getTicketnum() {
		return this.ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getSmallitemtype() {
		return this.smallitemtype;
	}

	public void setSmallitemtype(String smallitemtype) {
		this.smallitemtype = smallitemtype;
	}

	public Long getSmallitemid() {
		return this.smallitemid;
	}

	public void setSmallitemid(Long smallitemid) {
		this.smallitemid = smallitemid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String gainSynchtype() {
		return StringUtils.equals(this.result, "U") ? "1" : (StringUtils.equals(this.result, "D") ? "2" : "0");
	}

	public Timestamp getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	public String getSerialno() {
		return this.serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String gainSmsKey() {
		return this.tradeno + this.smallitemtype + this.smallitemid;
	}

	public Timestamp getTaketime() {
		return this.taketime;
	}

	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}

	public String getFromup() {
		return this.fromup;
	}

	public void setFromup(String fromup) {
		this.fromup = fromup;
	}

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Integer getConvertnum() {
		return this.convertnum;
	}

	public void setConvertnum(Integer convertnum) {
		this.convertnum = convertnum;
	}

	public String getConverttype() {
		return this.converttype;
	}

	public void setConverttype(String converttype) {
		this.converttype = converttype;
	}

	public Integer getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getTotaldisfee() {
		return this.totaldisfee;
	}

	public void setTotaldisfee(Integer totaldisfee) {
		this.totaldisfee = totaldisfee;
	}

	public Integer getConvertfee() {
		return this.convertfee;
	}

	public void setConvertfee(Integer convertfee) {
		this.convertfee = convertfee;
	}

	public Integer getConvertdisfee() {
		return this.convertdisfee;
	}

	public void setConvertdisfee(Integer convertdisfee) {
		this.convertdisfee = convertdisfee;
	}
}