/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;

public class ExpressProvinceVo extends BaseVo {
	private static final long serialVersionUID = -6669986405172603038L;
	private Long id;
	private String name;
	private String provincename;
	private String provincecode;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String expressid;
	private Integer expressfee;
	private Integer freelimit;

	public ExpressProvinceVo() {
	}

	public ExpressProvinceVo(String provincecode, String expressid, Integer expressfee, Integer freelimit) {
		this.provincecode = provincecode;
		this.expressid = expressid;
		this.expressfee = expressfee;
		this.freelimit = freelimit;
		this.addtime = DateUtil.getCurFullTimestamp();
		this.updatetime = this.addtime;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getProvincecode() {
		return this.provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
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

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public Integer getExpressfee() {
		return this.expressfee;
	}

	public void setExpressfee(Integer expressfee) {
		this.expressfee = expressfee;
	}

	public Integer getFreelimit() {
		return this.freelimit;
	}

	public void setFreelimit(Integer freelimit) {
		this.freelimit = freelimit;
	}

	public Serializable realId() {
		return this.id;
	}
}