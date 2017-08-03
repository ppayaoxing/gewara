package com.gewara.partner2.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
/**
 * 
 * @author user_2
 *
 */
public class PaymethodIconVo extends BaseVo{
	private static final long serialVersionUID = 2047438443244820893L;
	private Long id;
	/** 创建人 */
	private String createstaff;
	
	/** 创建时间 */
	private String createtime;
	/** 备注 */
	private String remark;
	/** 支付方式 */
	private String paymethod;
	/** 图标 */
	private String iconurl;
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCreatestaff() {
		return createstaff;
	}

	public void setCreatestaff(String createstaff) {
		this.createstaff = createstaff;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	@Override
	public Serializable realId() {
		return id;
	}
}
