/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.api;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ApiUserExtraVo extends BaseVo {
	private static final long serialVersionUID = -411948352145748060L;
	private Long id;
	private String openDiscount;
	private String paymethod;
	private String chargemethod;
	private String specialmethod;
	private String proxyqry;
	private String authFields;
	private String sourcemethod;
	private String otherinfo;
	private String supportseller;
	private String include;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenDiscount() {
		return this.openDiscount;
	}

	public void setOpenDiscount(String openDiscount) {
		this.openDiscount = openDiscount;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getChargemethod() {
		return this.chargemethod;
	}

	public void setChargemethod(String chargemethod) {
		this.chargemethod = chargemethod;
	}

	public String getSpecialmethod() {
		return this.specialmethod;
	}

	public void setSpecialmethod(String specialmethod) {
		this.specialmethod = specialmethod;
	}

	public String getProxyqry() {
		return this.proxyqry;
	}

	public void setProxyqry(String proxyqry) {
		this.proxyqry = proxyqry;
	}

	public String getAuthFields() {
		return this.authFields;
	}

	public void setAuthFields(String authFields) {
		this.authFields = authFields;
	}

	public String getSourcemethod() {
		return this.sourcemethod;
	}

	public void setSourcemethod(String sourcemethod) {
		this.sourcemethod = sourcemethod;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSupportseller() {
		return this.supportseller;
	}

	public void setSupportseller(String supportseller) {
		this.supportseller = supportseller;
	}

	public String getInclude() {
		return this.include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public Serializable realId() {
		return null;
	}
}