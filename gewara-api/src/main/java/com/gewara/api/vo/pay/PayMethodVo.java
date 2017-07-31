/** 
 */
package com.gewara.api.vo.pay;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * @author Zhicheng.Peng   Johnny.Resurgam@Gmail.com
 *  
 *  Jul 9, 2013  11:43:13 AM
 */
public class PayMethodVo extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1752493104769799032L;
	private String payMethod;
	private String payMethodText;
	private String flag;
	private String mangerUrl;
	/**
	 * @return the payMethod
	 */
	public String getPayMethod() {
		return payMethod;
	}
	/**
	 * @param payMethod the payMethod to set
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	/**
	 * @return the payMethodText
	 */
	public String getPayMethodText() {
		return payMethodText;
	}
	/**
	 * @param payMethodText the payMethodText to set
	 */
	public void setPayMethodText(String payMethodText) {
		this.payMethodText = payMethodText;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return flag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.flag = tag;
	}
	/* (non-Javadoc)
	 * @see com.gewara.model.BaseVo#realId()
	 */
	@Override
	public Serializable realId() {
		return payMethod;
	}
	
	public String getMangerUrl() {
		return mangerUrl;
	}
	
	public void setMangerUrl(String mangerUrl) {
		this.mangerUrl = mangerUrl;
	}
	
}
