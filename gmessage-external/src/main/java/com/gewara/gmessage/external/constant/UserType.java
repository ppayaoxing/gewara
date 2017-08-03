package com.gewara.gmessage.external.constant;

public enum UserType {
	
	/**gewara 会员*/
	MEMBER("M"),
	
	/**gewara 商户*/
	BUSINESS("B"),
	
	/**gewara 后台运维人员*/
	MAINTAIN("A");
	
	private String value=null;
	private UserType(String value){
		this.value=value;
	}
	
	public String value(){
		return this.value;
	}
	
}
