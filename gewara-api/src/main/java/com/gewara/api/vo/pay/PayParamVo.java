package com.gewara.api.vo.pay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class PayParamVo extends BaseVo{
	private static final long serialVersionUID = -306123430828268831L;
	private String paramname;
	private String paramvalue;
	
	public PayParamVo(String paramname, String paramvalue){
		this.paramname = paramname;
		this.paramvalue = paramvalue;
	}
	public PayParamVo(){
		
	}
	public String getParamname() {
		return paramname;
	}
	public void setParamname(String paramname) {
		this.paramname = paramname;
	}
	public String getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
	@Override
	public Serializable realId() {
		return paramname;
	}

}
