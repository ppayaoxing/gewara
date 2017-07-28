/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class OrderOtherVo extends BaseVo {
	private static final long serialVersionUID = -135038508746485007L;
	public static final String PAY_CARD = "ABD";
	public static final String PAY_DISCOUNT = "M";
	private Long id;
	private String takemethod;
	private String expressid;
	private String elecard;
	private boolean openPointPay;
	private int minpoint;
	private int maxpoint;
	private boolean ewarning;
	private boolean greetings;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public boolean isExpress() {
		return StringUtils.isNotBlank(this.expressid);
	}

	public boolean isOpenCardPay() {
		return StringUtils.containsAny(this.elecard, "ABD");
	}

	public boolean isOpenPointPay() {
		return this.openPointPay;
	}

	public boolean isDisCountPay() {
		return StringUtils.contains(this.elecard, "M");
	}

	public void setOpenPointPay(boolean openPointPay) {
		this.openPointPay = openPointPay;
	}

	public int getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(int minpoint) {
		this.minpoint = minpoint;
	}

	public int getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(int maxpoint) {
		this.maxpoint = maxpoint;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public boolean isEwarning() {
		return this.ewarning;
	}

	public void setEwarning(boolean ewarning) {
		this.ewarning = ewarning;
	}

	public boolean isGreetings() {
		return this.greetings;
	}

	public void setGreetings(boolean greetings) {
		this.greetings = greetings;
	}

	public boolean hasTakemethod(String... methods) {
		if (ArrayUtils.isEmpty(methods)) {
			return false;
		} else {
			String[] arg1 = methods;
			int arg2 = methods.length;

			for (int arg3 = 0; arg3 < arg2; ++arg3) {
				String method = arg1[arg3];
				if (!StringUtils.contains(this.takemethod, method)) {
					return false;
				}
			}

			return true;
		}
	}

	public void insertElecard(String ecard) {
		if ((!this.isOpenCardPay() || !this.isDisCountPay()) && !StringUtils.isBlank(ecard)) {
			if (StringUtils.isBlank(this.elecard)) {
				this.elecard = ecard;
			} else if (StringUtils.equals(ecard, "ABD")) {
				if (!StringUtils.contains(this.elecard, ecard)) {
					this.elecard = ecard + this.elecard;
				}
			} else if (StringUtils.equals(ecard, "M") && !StringUtils.contains(this.elecard, ecard)) {
				this.elecard = this.elecard + ecard;
			}

		}
	}

	public Serializable realId() {
		return this.id;
	}
}