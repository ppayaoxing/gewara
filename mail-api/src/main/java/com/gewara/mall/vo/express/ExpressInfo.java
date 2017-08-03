package com.gewara.mall.vo.express;


import java.util.ArrayList;
import java.util.List;

public class ExpressInfo {
	private String expTextName;
	private String expSpellName;
	private String mailNo;
	private String update;
	private String tel;
	private String status;
	private List<ExpressData> data = new ArrayList<ExpressData>();
	private List<ExpressCompany> expressList = new ArrayList<ExpressCompany>();
	public String getExpTextName() {
		return expTextName;
	}

	public void setExpTextName(String expTextName) {
		this.expTextName = expTextName;
	}

	public String getExpSpellName() {
		return expSpellName;
	}

	public void setExpSpellName(String expSpellName) {
		this.expSpellName = expSpellName;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ExpressData> getData() {
		return data;
	}

	public void setData(List<ExpressData> data) {
		this.data = data;
	}

	public List<ExpressCompany> getExpressList() {
		return expressList;
	}

	public void setExpressList(List<ExpressCompany> expressList) {
		this.expressList = expressList;
	}

}
