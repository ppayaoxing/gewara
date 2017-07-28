/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

public class UseCondition {
	private String accept_category;
	private String reject_category;
	private Boolean can_use_with_other_discount;

	public UseCondition() {
	}

	public UseCondition(String accept_category, String reject_category) {
		this.accept_category = accept_category;
		this.reject_category = reject_category;
		this.can_use_with_other_discount = Boolean.valueOf(false);
	}

	public String getAccept_category() {
		return this.accept_category;
	}

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return this.reject_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public Boolean getCan_use_with_other_discount() {
		return this.can_use_with_other_discount;
	}

	public void setCan_use_with_other_discount(Boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}
}