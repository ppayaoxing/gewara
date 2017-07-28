/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo.express;

import com.gewara.mall.vo.express.ExpressCompany;
import com.gewara.mall.vo.express.ExpressData;
import java.util.ArrayList;
import java.util.List;

public class ExpressInfo {
	private String expTextName;
	private String expSpellName;
	private String mailNo;
	private String update;
	private String tel;
	private String status;
	private List<ExpressData> data = new ArrayList();
	private List<ExpressCompany> expressList = new ArrayList();

	public String getExpTextName() {
		return this.expTextName;
	}

	public void setExpTextName(String expTextName) {
		this.expTextName = expTextName;
	}

	public String getExpSpellName() {
		return this.expSpellName;
	}

	public void setExpSpellName(String expSpellName) {
		this.expSpellName = expSpellName;
	}

	public String getMailNo() {
		return this.mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getUpdate() {
		return this.update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ExpressData> getData() {
		return this.data;
	}

	public void setData(List<ExpressData> data) {
		this.data = data;
	}

	public List<ExpressCompany> getExpressList() {
		return this.expressList;
	}

	public void setExpressList(List<ExpressCompany> expressList) {
		this.expressList = expressList;
	}
}